package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.data.domain.OrderLine;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.BomConsts;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.data.domain.Bom;
import com.kunlong.dongxw.data.domain.MakePlan;
import com.kunlong.dongxw.data.domain.Product;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Transactional
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {
        if (bomJoinService.checkExistsBomChild(id)) {

            return JsonResult.failure(-1, "物料存在组件，无法删除！");
        }
        Bom bom = bomService.findById(id);
        bomService.deleteById(id);
        if (bom.getParentId() > 0) {
            bomJoinService.saveParentBomByCom(bom.getParentId());
        }
        bomJoinService.saveBomCostByProduct(bom.getProductId());
        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<Bom> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        Bom bom = bomService.findById(id);

        SysUserDTO sysUserDTO = sysUserApiService.findById(bom.getCreateBy());
        bom.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());

        return JsonResult.success(bom);

    }

    @RequestMapping("/saveByIds")
    @Transactional
    public JsonResult<List<Integer>> saveByIds(@RequestBody Bom bom) {
//        bom =new Bom();
//        bom.setProductId(189);
//        bom.setRmIds("268,229,228");
        bom.setCreateBy(getCurrentUserId());
        List<Integer> list = bomJoinService.saveByIds(bom);
        return JsonResult.success(list);
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Bom bom) {
        Integer id = bomJoinService.save(bom, getCurrentUserId());
        if (id < 0) {
            return JsonResult.failure(id, "物料代码已经存在");
        }
        return JsonResult.success(id);

    }


    @PostMapping("/query")
    public PageResult<Bom> query(@RequestBody Bom.QueryParam queryParam) throws IOException {
        PageResult<Bom> pageResult = new PageResult<Bom>();
        queryParam.setSortBys(queryParam.getOrderBys());

        //queryParam.setSortBys("id|desc");
        pageResult.setTotal(bomService.countByQueryParam(queryParam));
        pageResult.setData(bomService.findByQueryParam(queryParam));
        for(Bom bom:pageResult.getData()){
            bom.setChildRm(productService.findById(bom.getChildId()));
            bom.setProduct(productService.findById(bom.getProductId()));
            if(bom.getChildRm()!=null){
                bom.getChildRm().setProductSubType(productTypeService.findById(bom.getChildRm().getProductTypeId()));
                bom.getChildRm().setProductType(productTypeService.findById(bom.getChildRm().getParentId()));

            }
            SysUserDTO sysUserDTO = sysUserApiService.findById(bom.getCreateBy());
            bom.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        }
        if(queryParam.getOrderBys().startsWith("code|")){
            Collections.sort(pageResult.getData());
        }else if (queryParam.getOrderBys().startsWith("name|")){
            Collections.sort(pageResult.getData(), new Comparator<Bom>() {

                @Override
                public int compare(Bom b1, Bom b2) {
                    String name1 = b1.getProduct()==null?"-":b1.getProduct().getName();
                    String name2 = b2.getProduct()==null?"-":b2.getProduct().getName();
                    return name1.compareTo(name2) ;
                }
            });

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

