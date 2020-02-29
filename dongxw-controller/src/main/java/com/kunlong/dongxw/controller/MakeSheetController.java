package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSON;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.dongxw.util.MergeExcelSheet;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/makesheet")
public  class MakeSheetController extends BaseController {
    @Autowired
    MakePlanJoinService makePlanJoinService;
    @Autowired
    MakePlanService makePlanService;
    @Autowired
    MakeSheetService makeSheetService;

    @Autowired
    BomJoinService bomJoinService;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    OrderLineService orderLineService;
    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;
    @DongxwTransactional(rollbackFor = Exception.class)
    @RequestMapping("/makeSheetByPlan/{planId}")
    public JsonResult<String> makeSheetByPlan(@PathVariable("planId") Integer planId) throws IOException {

        makePlanJoinService.makeSheetByPlan(planId,getCurrentUserId());
        return JsonResult.success("成功！");
    }

    @DongxwTransactional(rollbackFor = Exception.class)
    @RequestMapping("/makeSheetByPlanOrder/{orderId}")
    public JsonResult<Integer> makeSheetByPlanOrder(@PathVariable("orderId") Integer orderId) throws IOException {

        int cnt=makePlanJoinService.makeSheetByPlanOrder(orderId,getCurrentUserId());
        return JsonResult.success(cnt,"成功！");
    }

    //检查有计划
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        makeSheetService.deleteById(id);
        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<MakeSheet> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        MakeSheet makeSheet = makeSheetService.findById(id);
        return JsonResult.success(makeSheet);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody MakeSheet makeSheet) {

        if (makeSheet.getId() == null) {
            makeSheetService.save(makeSheet);
        } else {
            makeSheetService.update(makeSheet);
        }

        return JsonResult.success(makeSheet.getId());
    }


    @PostMapping("/query")
    public PageResult<MakeSheet> query(@RequestBody MakeSheet.QueryParam queryParam) throws IOException {
        PageResult<MakeSheet> pageResult = new PageResult<MakeSheet>();

        queryParam.setSortBys("id|desc");
        queryParam.getParam().setParentId(0);
        pageResult.setTotal(makeSheetService.countByQueryParam(queryParam));
        pageResult.setData(makeSheetService.findByQueryParam(queryParam));
        for(MakeSheet sheet:pageResult.getData()){
            sheet.setChildRm(productService.findById(sheet.getChildId()));
            sheet.setProduct(productService.findById(sheet.getProductId()));
            if(sheet.getChildRm()!=null){
                sheet.getChildRm().setProductSubType(productTypeService.findById(sheet.getChildRm().getProductTypeId()));
                sheet.getChildRm().setProductType(productTypeService.findById(sheet.getChildRm().getParentId()));

            }
            SysUserDTO sysUserDTO = sysUserApiService.findById(sheet.getCreateBy());
            sheet.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        }
        //pageResult.setData(pageResult.getData().stream().filter(item->item.getParentId()==0)
        //        .sorted((x,y) -> x.getChildRm().getCode().compareTo(y.getChildRm().getCode())).collect(Collectors.toList()));
        Collections.sort( pageResult.getData(), new Comparator<MakeSheet>() {
            @Override
            public int compare(MakeSheet a, MakeSheet b) {
                if (a.getChildRm() != null && b.getChildRm() != null) {
                    return a.getChildRm().getCode().compareTo(b.getChildRm().getCode());
                }

                return a.getId().compareTo(b.getId());
            }
        });
        return pageResult;
    }
    void fillSheet(List<MakeSheet> boms){
        for(MakeSheet bom:boms){
            bom.setChildRm(productService.findById(bom.getChildId()));
            bom.setProduct(productService.findById(bom.getProductId()));
            if(bom.getChildRm()!=null){
                bom.getChildRm().setProductSubType(productTypeService.findById(bom.getChildRm().getProductTypeId()));
                bom.getChildRm().setProductType(productTypeService.findById(bom.getChildRm().getParentId()));

            }
            SysUserDTO sysUserDTO = sysUserApiService.findById(bom.getCreateBy());
            bom.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        }
    }
    List<MakeSheetExcelModel> buildExcelModels(MakeSheet.QueryParam queryParam) {
        queryParam.getParam().setParentId(0);
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        List<MakeSheet> boms = makeSheetService.findByQueryParam(queryParam);
        fillSheet(boms);
        Collections.sort( boms, new Comparator<MakeSheet>() {
            @Override
            public int compare(MakeSheet a, MakeSheet b) {
                if (a.getChildRm() != null && b.getChildRm() != null) {
                    return a.getChildRm().getCode().compareTo(b.getChildRm().getCode());
                }

                return a.getId().compareTo(b.getId());
            }
        });
        List<MakeSheet> fullBoms = new ArrayList<>();
        int i=1;
        for (MakeSheet bom : boms) {
            fullBoms.add(bom);

            if (bom.getSource()) {

                queryParam.getParam().setParentId(bom.getBomId());
                queryParam.setLimit(-1);
                queryParam.setStart(0);
                List<MakeSheet> subs = makeSheetService.findByQueryParam(queryParam);
                fullBoms.addAll(subs);
            }
        }

        List<MakeSheetExcelModel> models = new ArrayList<>();
        Integer ii=1;
        for (MakeSheet bom : fullBoms) {
            MakeSheetExcelModel model = JSON.parseObject(bom.toString(), MakeSheetExcelModel.class);
            if(bom.getSizeL()!=null&&BigDecimal.ZERO.compareTo(bom.getSizeL())!=0){
                model.setSizeX("X");
            }
            if (bom.getChildRm() == null) {
                model.setSeqNo(" " );
                model.setQty(" ");
            }
            model.setCode(bom.getChildRm() == null ? null : bom.getChildRm().getCode());
            model.setName(bom.getChildRm() == null ? null : bom.getChildRm().getName());
            model.setColor(bom.getChildRm() == null ? null : bom.getChildRm().getColor());
            model.setUnit(bom.getChildRm() == null ? " " : bom.getChildRm().getUnit());

            model.setLossRate(model.getLossRate()==null?"0%":model.getLossRate()+"%");
            if (bom.getSource() || bom.getParentId()==0) {
                model.setSizeL(null );
                model.setSizeW(null);
                model.setSizeX(" ");
                model.setCutPartName(" ");
                model.setLength(null);
                model.setWidth(" ");
                //model.setKnifeQty(null);
                // model.setPieces(null);
                model.setKnifeQty(" ");

                model.setLossRate(null);
                model.setEachQty(null);
            }
            if(model.getCode()!=null)
            {
                model.setSeqNo(ii.toString());
                ii++;
            }
            models.add(model);
        }
        return models;
    }
    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakeSheet.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {
        if (queryParam.getParam() == null || queryParam.getParam().getPlanId() == null) {

            rsp.getWriter().write(JsonResult.failure(-1, "没有选择计划!").toString());
            rsp.setStatus(500);
            return;
        }

        MakePlan makePlan = makePlanService.findById(queryParam.getParam().getPlanId());
        if(makePlan==null)
        {
            rsp.getWriter().write(JsonResult.failure(- 2, "计划不存在！").toString());
            rsp.setStatus(500);
            return;
        }
        OrderLine orderLine = orderLineService.findById(makePlan.getOrderLineId());
        makePlan.setOrderLine(orderLine);

        Product product = productService.findById( orderLine.getProductId());
        makePlan.setProduct(product);

        rsp.setHeader("file", URLEncoder.encode(product.getEpCode(), "UTF-8"));
        String productCode = product.getCode();
        String fileName = String.format("生产制造单-%s.xlsx",product.getCode());
        String headFile = writeOrderProduct2File(product.getCode() , makePlan, fileName);
        Map<String, List> map = new LinkedHashMap<>();
        List<MakeSheetExcelModel> models = buildExcelModels(queryParam);

        if (models.size() > 0) {
            map.put(productCode, models);
        }
        String sheetFile = EasyExcelUtil.writeBomExcels2File(productCode + "_list", productCode, map);
        String outFile = new MergeExcelSheet().mergeSheets(headFile, sheetFile, fileName);

        EasyExcelUtil.writeExcel2Response(fileName, rsp, outFile);

    }

    String writeOrderProduct2File(String sheetName, MakePlan makePlan, String fileName) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();

        Product product = makePlan.getProduct();
        Customer customer = product == null ? null : customerService.findById(product.getCustomerId());

        map.put("customerName", customer == null ? "-" : customer.getCustName());
        map.put("orderDate", transDate(makePlan.getOrderDate()));
        map.put("issueDate", transDate( makePlan.getIssueDate()));
        map.put("qty", makePlan.getOrderLine().getQty());
        if (product != null) {
            map.put("code", product.getCode());
            map.put("epCode", product.getEpCode());
            map.put("size", product.getSize());
            map.put("color", product.getColor());
            map.put("remark", product.getRemark());
          }

        OrderMaster orderMaster = orderMasterService.findById(makePlan.getOrderId());
        if (orderMaster != null) {
            map.put("customerOrderCode",orderMaster.getCustomerOrderCode());
            map.put("businessBy", orderMaster.getBusinessBy());
        }

        return makeExcelSheet("makesheet_template.xlsx",fileName,sheetName,map);
    }



    void writeBomProduct(String sheetName,Integer productId, HttpServletResponse rsp) throws IOException {
        Product product = productService.findById(productId);
        Customer customer = product==null?null:customerService.findById(product.getCustomerId());

        TemplateExportParams exportParams = new TemplateExportParams("templates/bom_product.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("customerName", customer == null ? "-" : customer.getCustName());
        if (product == null) {
            map.put("remark", " ");
            map.put("size", " ");
            map.put("code", " ");
        } else {
            map.put("remark", product.getRemark());
            map.put("size", product.getSize());
            map.put("code", product.getCode());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, map);
        workbook.setSheetName(0,sheetName);
        workbook.write(rsp.getOutputStream());

    }





}

