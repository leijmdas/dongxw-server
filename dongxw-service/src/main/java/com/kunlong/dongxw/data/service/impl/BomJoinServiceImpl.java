package com.kunlong.dongxw.data.service.impl;

import com.kunlong.dongxw.data.domain.Bom;
import com.kunlong.dongxw.data.domain.BomBase;
import com.kunlong.dongxw.data.domain.BomCost;
import com.kunlong.dongxw.data.domain.Product;
import com.kunlong.dongxw.data.service.BomCostService;
import com.kunlong.dongxw.data.service.BomJoinService;
import com.kunlong.dongxw.data.service.BomService;
import com.kunlong.dongxw.data.service.ProductService;
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
			lossRate = lossRate.divide(bom.getEachQty(),BigDecimal.ROUND_FLOOR);

			bom.setLossRate(lossRate.toBigInteger().shortValue());
			bom.setMoney(bom.getPrice().multiply(bom.getQty()));
		}
		bomService.update(bom);

		return bom;
	}

	  List<Bom> findBomByProductRm(Integer productId, Integer childId) {
		Bom.QueryParam queryParam = new Bom.QueryParam();
		queryParam.setParam(new Bom());
		queryParam.getParam().setProductId(productId);
		queryParam.getParam().setChildId(childId);

		  return bomService.findByQueryParam(queryParam);

	  }

	Boolean checkExistsBomByProductRm(Integer productId, Integer childId) {
		List<Bom> boms = findBomByProductRm(productId, childId);
		return boms != null && boms.size() > 0;
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
				Integer rmId=Integer.valueOf(childId);
				if(checkExistsBomByProductRm(productId,rmId)){
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
				bomService.save(saveBom);
				integers.add(saveBom.getId());
			}
		}
		return  integers ;
	}
}
