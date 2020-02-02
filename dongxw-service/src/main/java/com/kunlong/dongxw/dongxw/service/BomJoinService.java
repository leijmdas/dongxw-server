package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.Bom;
import com.kunlong.dongxw.dongxw.domain.BomCost;
import com.kunlong.platform.utils.JsonResult;
import java.util.List;

public interface BomJoinService {
    List<Bom> queryBomByProduct(int productId);

    Bom sumBomByProduct(int productId);

    JsonResult<BomCost> findBomCostByByProduct(Integer productId);

    Integer save(BomCost bom);

    Integer reSaveBomCostByProduct(Integer productId);


}
