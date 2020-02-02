package com.kunlong.dongxw.dongxw.service.impl;

import com.kunlong.dongxw.consts.BomConsts;
import com.kunlong.dongxw.dongxw.domain.Bom;
import com.kunlong.dongxw.dongxw.domain.BomCost;
import com.kunlong.dongxw.dongxw.service.BomCostService;
import com.kunlong.dongxw.dongxw.service.BomJoinService;
import com.kunlong.dongxw.dongxw.service.BomService;
import com.kunlong.platform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
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
		sum.setTotalMoney(BigDecimal.ZERO);
		for (Bom bom : boms) {
			sum.setMoney(sum.getMoney().add(bom.getMoney()));
			BigDecimal lossMoney = bom.getLossType().equals(BomConsts.TYPE_LOSS_QTY) ?
					bom.getPrice().multiply(bom.newBigDecimal(bom.getLossQty())) :
					bom.getMoney().divide(BigDecimal.valueOf(100)).multiply(bom.newBigDecimal(bom.getLossQty()));
			sum.setLossMoney(sum.getLossMoney().add(lossMoney));
		}
		sum.setTotalMoney(sum.newBigDecimal(sum.getMoney().add(sum.getLossMoney())));
		sum.setLossMoney(sum.newBigDecimal(sum.getLossMoney()));
		return sum;
	}

	public JsonResult<BomCost> findBomCostByByProduct(Integer productId) {
		BomCost.QueryParam queryParam = new BomCost.QueryParam();
		queryParam.setParam(new BomCost());
		queryParam.getParam().setProductId(productId);
		List<BomCost> list = bomCostService.findByQueryParam(queryParam);
		if (list.size() == 0) {
			return JsonResult.success(null);
		}
		return JsonResult.success(list.get(0));

	}



	public Integer save( BomCost bom ) {

		Bom sum = sumBomByProduct(bom.getProductId());
		bom.setRmFee(sum.getMoney());
		bom.setLossRm(sum.getLossMoney());
		bom.setTotalFee(bom.getRmFee().add(bom.getLossRm()).add(bom.getShippingFee())
				.add(bom.getKnifeModel()).add(bom.getCutRm()).add(bom.getWorkFee()));
		bom.setTotalFee(sum.newBigDecimal(bom.getTotalFee()));
		if (bom.getId() == null) {
			bom.setCreateDate(new Date());
			bomCostService.save(bom);
		} else {
			bomCostService.update(bom);
		}

		return  bom.getId() ;
	}

	public Integer reSaveBomCostByProduct(Integer productId) {
		JsonResult<BomCost> result = findBomCostByByProduct(productId);
		if (result.getData() != null) {
			return save(result.getData());
		}

		return save(BomCost.defaultBomCosrt(productId));


	}

}
