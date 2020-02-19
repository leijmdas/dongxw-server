package com.kunlong.dongxw.data.service.impl;

import com.kunlong.dongxw.consts.BomConsts;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.platform.model.KunlongModel;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * BomCostServiceImpl
 * @author generator
 * @date 2020年02月02日
 */
@Service
public class BomJoinServiceImpl implements BomJoinService {
	@Autowired
	ProductService productService;
	@Autowired
	ProductTypeService productTypeService;

	@Autowired
	BomCostService bomCostService;

	@Autowired
	BomService bomService;

	public List<Bom> queryBomByProduct(int productId)     {
		Bom.QueryParam queryParam=new Bom.QueryParam();
		queryParam.setParam(new Bom());
		queryParam.getParam().setProductId(productId);
		List<Bom> boms = bomService.findByQueryParam(queryParam);
		return boms;
	}

	public Bom sumBomByProduct(int productId)     {
		Bom.QueryParam queryParam = new Bom.QueryParam();
		queryParam.setParam(new Bom());
		queryParam.getParam().setProductId(productId);
		List<Bom> boms = bomService.findByQueryParam(queryParam);
		Bom sum = new Bom();
		sum.setMoney(sum.newBigDecimal(BigDecimal.ZERO));
		sum.setLossMoney(BigDecimal.ZERO);

		for (Bom bom : boms) {
			sum.setMoney(sum.getMoney().add(bom.getMoney()));
			BigDecimal lossMoney = bom.getLossQty().multiply(bom.getPrice());
			sum.setLossMoney(sum.getLossMoney().add(lossMoney));
		}

		return sum;
	}

	public JsonResult<BomCost> findBomCostByProduct(Integer productId) {
		BomCost.QueryParam queryParam = new BomCost.QueryParam();
		queryParam.setParam(new BomCost());
		queryParam.getParam().setProductId(productId);
		List<BomCost> list = bomCostService.findByQueryParam(queryParam);
		if (list.size() == 0) {
			return JsonResult.success(null);
		}
		return JsonResult.success(list.get(0));

	}

	@Transactional
	public Integer save(Bom bom, Integer sysUserId) {
		//组件不判断
		if (bom.getParentId()==0 && checkExistsBomByProductRm(bom.getId(), bom.getProductId(), bom.getChildId())) {
			return -1;
		}

		bom.setLossQty(bom.getEachQty().multiply(KunlongUtils.newBigDecimal(bom.getLossRate())
				.divide(KunlongUtils.newBigDecimal(100 ) ,BigDecimal.ROUND_FLOOR)));

		bom.setQty((bom.getEachQty().add(bom.getLossQty()).multiply(new BigDecimal(bom.getPieces()))));
		bom.setMoney(bom.getPrice().multiply(bom.getQty()));
		if (bom.getChildId() != null && bom.getChildId() > 0) {
			Product product = productService.findById(bom.getChildId());
			if (product != null) {
				bom.setBigType(product.getParentId());
				bom.setSmallType(product.getProductTypeId());
			}
		}
		if (bom.getId() == null) {
			bom.setCreateBy(sysUserId);
			bom.setCreateDate(new Date());
			bomService.save(bom);
		} else {
			bomService.update(bom);
		}
		//更新父物料
		if (bom.getParentId() > 0) {
			Bom parentBom = saveParentBomByCom(bom.getParentId());
			saveBomCostByProduct(parentBom.getProductId());
		}else {
			saveBomCostByProduct(bom.getProductId());
		}
		return  bom.getId();
	}

	public Integer save( BomCost bomCost ) {

		Bom sum = sumBomByProduct(bomCost.getProductId());
		bomCost.setRmFee(sum.getMoney().subtract(sum.getLossMoney()));
		bomCost.setLossRm(sum.getLossMoney());
		bomCost.setTotalFee(sum.getMoney());
		if (bomCost.getId() == null) {
			bomCost.setCreateDate(new Date());
			bomCostService.save(bomCost);
		} else {
			bomCostService.update(bomCost);
		}

		return  bomCost.getId() ;
	}

	public Integer saveBomCostByProduct(Integer productId) {
		JsonResult<BomCost> result = findBomCostByProduct(productId);
		if (result.getData() != null) {
			return save(result.getData());
		}

		return save(BomCost.defaultBomCost(productId));


	}

	public Bom sumParentBomByCom(Integer parentId) {
		Bom.QueryParam queryParam = new Bom.QueryParam();
		queryParam.setParam(new Bom());
		queryParam.getParam().setParentId(parentId);
		queryParam.setLimit(-1);
		List<Bom> boms = bomService.findByQueryParam(queryParam);
		Bom sumBom = new Bom();
		sumBom.setQty(BigDecimal.ZERO);
		sumBom.setEachQty(BigDecimal.ZERO);
		sumBom.setLossQty(BigDecimal.ZERO);

		//eachQty, qty ,  lossQty
		for (Bom bom : boms) {
			sumBom.setLossQty(sumBom.getLossQty().add(bom.getLossQty()));
			sumBom.setEachQty(sumBom.getEachQty().add(bom.getEachQty()));
			sumBom.setQty(sumBom.getQty().add(bom.getQty()));
		}
		return sumBom;
	}

	public Bom saveParentBomByCom(Integer parentId) {
		Bom bom = bomService.findById(parentId);
		if (bom != null) {
			Bom sumBom = sumParentBomByCom(parentId);
			bom.setLossQty(sumBom.getLossQty());
			bom.setEachQty(sumBom.getEachQty());
			bom.setQty(sumBom.getQty());
			BigDecimal lossRate = bom.getLossQty().multiply(KunlongUtils.newBigDecimal(4, 100));
			if (bom.getLossQty().compareTo(BigDecimal.ZERO) == 0) {
				lossRate = BigDecimal.ZERO;
			} else {
				lossRate = lossRate.divide(bom.getEachQty(), BigDecimal.ROUND_FLOOR);
			}

			bom.setLossRate(lossRate.toBigInteger().shortValue());
			bom.setMoney(bom.getPrice().multiply(bom.getQty()));
		}
		bomService.update(bom);

		return bom;
	}

	List<Bom> findBomByProductRm(Integer productId, Integer childId) {
		Bom.QueryParam queryParam = new Bom.QueryParam();
		queryParam.setParam(new Bom());
		queryParam.getParam().setChildId(childId);

		queryParam.getParam().setProductId(productId);
		return bomService.findByQueryParam(queryParam);

	}

	public Boolean checkExistsBomChild(Integer parentId) {
		Bom.QueryParam queryParam = new Bom.QueryParam();
		queryParam.setParam(new Bom());
		queryParam.getParam().setParentId(parentId);
		queryParam.setLimit(1);

		List<Bom> boms = bomService.findByQueryParam(queryParam);
		return boms != null && boms.size() > 0;

	}

	Boolean checkExistsBomByProductRm(Integer productId, Integer childId) {
		List<Bom> boms = findBomByProductRm(productId, childId);
		return boms != null && boms.size() > 0;
	}

	Boolean checkExistsBomByProductRm(Integer bomId, Integer productId, Integer childId) {
		if (bomId == null && checkExistsBomByProductRm(productId, childId)) {
			return true;
		}

		List<Bom> boms = findBomByProductRm(productId, childId);
		if (boms == null) {
			return false;
		}
		for (Bom bom : boms) {
			if (!bom.getId().equals(bomId)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * bom: getProductId
	 * bom: getRmIds
	 * bom: getCreateBy
	 * */
	@Transactional
	public List<Integer> saveByIds(Bom bom) {


		Assert.notNull(bom.getRmIds(), "rmIds不存在");
		List<Integer> integers = new ArrayList<>();
		if (!bom.getRmIds().isEmpty()) {

			String[] ids = bom.getRmIds().split(",");
			Integer productId = bom.getProductId();
			for (String childId : ids) {
				Integer rmId = Integer.valueOf(childId);
				if (checkExistsBomByProductRm(productId, rmId)) {
					continue;
				}
				Bom saveBom = BomBase.defaultBom();

				saveBom.setCreateBy(bom.getCreateBy());
				saveBom.setProductId(productId);
				saveBom.setChildId(Integer.valueOf(childId));
				Product product = productService.findById(rmId);
				if (product != null) {
					saveBom.setBigType(product.getParentId());
					saveBom.setSmallType(product.getProductTypeId());
				}
				checkSource(saveBom);
				bomService.save(saveBom);
				integers.add(saveBom.getId());
			}
		}
		return integers;
	}

	void checkSource(Bom saveBom){
		Product rm = productService.findById(saveBom.getChildId());
		ProductType rmType = productTypeService.findById(rm.getParentId());
		String rmBigTypeCode = rmType.getCode().trim();
		//10 11 20 有组件
		if ("10".equals(rmBigTypeCode) || "11".equals(rmBigTypeCode) || "20".equals(rmBigTypeCode)) {
			saveBom.setSource(true);
		} else {
			saveBom.setSource(false);
		}
	}
}
