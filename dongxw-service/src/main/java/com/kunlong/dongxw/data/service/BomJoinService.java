package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.Bom;
import com.kunlong.dongxw.data.domain.BomCost;
import com.kunlong.platform.utils.JsonResult;
import java.util.List;

public interface BomJoinService {
    List<Bom> queryBomByProduct(int productId);

    Bom sumBomByProduct(int productId);

    JsonResult<BomCost> findBomCostByProduct(Integer productId);

    Integer save(Bom bom, Integer sysUserId);

    Integer save(BomCost bom);

    Integer saveBomCostByProduct(Integer productId);

    Bom sumParentBomByCom(Integer productId);

    Bom saveParentBomByCom(Integer productId);

    List<Integer> saveByIds(Bom bom);

}
