package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.kunlong.center.api.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.BomConsts;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.dongxw.domain.Bom;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
import com.kunlong.dongxw.dongxw.domain.Product;
import com.kunlong.dongxw.dongxw.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/bom")
public  class BomController extends BaseController {
    @Autowired
    BomService bomService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;



    @Autowired
    BomJoinService bomJoinService;



    //检查有计划
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {
        Bom bom = bomService.findById(id);

        bomService.deleteById(id);

        bomJoinService.reSaveBomCostByProduct(bom.getProductId());
        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<Bom> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        Bom bom = bomService.findById(id);

        return JsonResult.success(bom);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Bom bom) {

        bom.setMoney(bom.getPrice().multiply(bom.getQty()));
        if (bom.getChildId() != null && bom.getChildId() > 0) {
            Product product = productService.findById(bom.getChildId());
            if (product != null) {
                bom.setBigType(product.getParentId());
                bom.setSmallType(product.getProductTypeId());
            }
        }
        if (bom.getId() == null) {
            bom.setCreateBy(getCurrentUserId());
            bom.setCreateDate(new Date());
            bomService.save(bom);
        } else {
            bomService.update(bom);
        }

        bomJoinService.reSaveBomCostByProduct(bom.getProductId());
        return JsonResult.success(bom.getId());
    }


    @PostMapping("/query")
    public PageResult<Bom> query(@RequestBody Bom.QueryParam queryParam) throws IOException {
        PageResult<Bom> pageResult = new PageResult<Bom>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(bomService.countByQueryParam(queryParam));
        pageResult.setData(bomService.findByQueryParam(queryParam));
        for(Bom bom:pageResult.getData()){
            bom.setChildRm(productService.findById(bom.getChildId()));
            bom.setProduct(productService.findById(bom.getProductId()));
            if(bom.getChildRm()!=null){
                bom.getChildRm().setProductSubType(productTypeService.findById(bom.getChildRm().getProductTypeId()));
                bom.getChildRm().setProductType(productTypeService.findById(bom.getChildRm().getParentId()));
                if(bom.getLossType().equals(BomConsts.TYPE_LOSS_QTY)){
                    bom.setLossMoney(bom.getPrice().multiply(BigDecimal.valueOf(bom.getLossQty())));
                 }else {
                    bom.setLossMoney(bom.getMoney().divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(bom.getLossQty())));
                 }
                bom.setTotalMoney(bom.getMoney().add(bom.getLossMoney()));
            }
            SysUserDTO sysUserDTO = sysUserApiService.findById(bom.getCreateBy());
            bom.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        }
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new MakePlan());
        }
        queryParam.setLimit(3000);
        queryParam.setStart(0);
        queryParam.setSortBys("customerId|asc,orderId|asc");

        WebFileUtil web = new WebFileUtil(req,rsp);
        //List<MakePlan> makePlans = this.makePlanService.findByQueryParam(queryParam);
        //fillMakePlans(makePlans);
        rsp.setHeader("file",URLEncoder.encode(  "生产计划表.xlsx","UTF-8"));

        //web.export2EasyExcelObject("生产计划表.xlsx", buildTitles(),buildRecords(makePlans));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();

        strings.add("发外标志");
        strings.add("客户名称");
        strings.add("客户订单号");
        strings.add("客款号");
        strings.add("产品描述");
        strings.add("颜色");
        strings.add("数量");

        strings.add("接单日期");
        strings.add("要求交期");
        strings.add("物料到位日期");
        strings.add("包材到位日期");
        strings.add("计划上线日期");
        strings.add("计划完成日期");
        strings.add("是否完成");
        strings.add("实际完成日期");
        strings.add("备注");
        return strings;
    }
    List<List<Object>> buildRecords(List<MakePlan> makePlans) {
        List<List<Object>> records = new ArrayList<>();
        for (MakePlan makePlan : makePlans) {
            List<Object> r = new ArrayList<>();
             //strings.add("发外标志");
            r.add(MakePlanConst.getOutFlag(makePlan.getOutFlag()));
            // strings.add("客户名称");
            r.add(makePlan.getCustomer()==null?"-":makePlan.getCustomer().getCustName());
            //strings.add("客户订单号");
            r.add(makePlan.getOrderMaster()==null?"-":makePlan.getOrderMaster().getCustomerOrderCode());
            //strings.add("客款号");
            r.add(makePlan.getProduct()==null?"-":makePlan.getProduct().getCode());
            //strings.add("产品描述");
            r.add(makePlan.getProduct()==null?"-":makePlan.getProduct().getRemark());
            //strings.add("颜色");
            r.add(makePlan.getProduct()==null?"-":makePlan.getProduct().getColor());
            //strings.add("数量");
            r.add(makePlan.getOrderLine()==null?"-":makePlan.getOrderLine().getQty());

            //strings.add("接单日期");
            r.add(transDate(makePlan.getOrderDate()));
            //strings.add("要求交期");
            r.add(transDate(makePlan.getIssueDate()));
            //strings.add("物料到位日期");
            r.add(transDate(makePlan.getRmDate()));
            //strings.add("包材到位日期");
            r.add(transDate(makePlan.getPkgDate()));
            //strings.add("计划上线日期");
            r.add(transDate(makePlan.getPlanStart()));
            //strings.add("计划完成日期");
            r.add(transDate(makePlan.getPlanEnd()));
            //strings.add("是否完成");
            r.add(MakePlanConst.getFinishFlag(makePlan.getFinishFlag()));

            //strings.add("实际完成日期");
            r.add(transDate(makePlan.getRealEnd()));
            //strings.add("备注");
            r.add(makePlan.getRemark());

            records.add(r);
        }
        return records;
    }

    String transDatetime(Date d) {
        if(d==null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        if(d==null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }



}
