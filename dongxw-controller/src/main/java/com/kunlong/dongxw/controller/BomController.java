package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSON;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.dongxw.util.MergeExcelSheet;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
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
@RequestMapping("/dongxw/bom")
public  class BomController extends BaseController {
    @Autowired
    BomService bomService;
    //@Autowired
    //BomCostService bomCostService;

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
    @DongxwTransactional
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
    @DongxwTransactional
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

    void fillBoms(List<Bom> boms){
        for(Bom bom:boms){
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

    @PostMapping("/query")
    public PageResult<Bom> query(@RequestBody Bom.QueryParam queryParam) throws IOException {
        PageResult<Bom> pageResult = new PageResult<Bom>();
        queryParam.setSortBys(queryParam.getOrderBys());

        //queryParam.setSortBys("id|desc");
        pageResult.setTotal(bomService.countByQueryParam(queryParam));
        pageResult.setData(bomService.findByQueryParam(queryParam));
        fillBoms(pageResult.getData());
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

        }else if (queryParam.getOrderBys().startsWith("remark|")){
            Collections.sort(pageResult.getData(), new Comparator<Bom>() {

                @Override
                public int compare(Bom b1, Bom b2) {
                    String name1 = b1.getProduct()==null?"-":b1.getProduct().getRemark();
                    String name2 = b2.getProduct()==null?"-":b2.getProduct().getRemark();
                    return name1.compareTo(name2) ;
                }
            });

        }else if (queryParam.getOrderBys().startsWith("color|")){
            Collections.sort(pageResult.getData(), new Comparator<Bom>() {

                @Override
                public int compare(Bom b1, Bom b2) {
                    String name1 = b1.getProduct()==null?"-":b1.getProduct().getColor();
                    String name2 = b2.getProduct()==null?"-":b2.getProduct().getColor();
                    return name1.compareTo(name2) ;
                }
            });

        }
        return pageResult;
    }

    List<BomExcelModel> buildExcelModels(Bom.QueryParam queryParam){
        queryParam.getParam().setParentId(0);
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.setSortBys("parentId|asc,source|desc");
        List<Bom> boms = this.bomService.findByQueryParam(queryParam);
        fillBoms(boms);
        Collections.sort( boms, new Comparator<Bom>() {
            @Override
            public int compare(Bom a, Bom b) {
                if (a.getChildRm() != null && b.getChildRm() != null) {
                    return a.getChildRm().getCode().compareTo(b.getChildRm().getCode());
                }

                return a.getId().compareTo(b.getId());
            }
        });
        List<Bom> fullBoms = new ArrayList<>();
        int i=1;
        for (Bom bom : boms) {
            fullBoms.add(bom);
            bom.setSeqNo(String.valueOf(i++));

            if (bom.getSource()) {
                queryParam.getParam().setSource(false);
                queryParam.getParam().setParentId(bom.getId());
                queryParam.setLimit(-1);
                queryParam.setStart(0);
                List<Bom> subs = this.bomService.findByQueryParam(queryParam);
                fullBoms.addAll(subs);
            }
        }

        List<BomExcelModel> models = new ArrayList<>();
        for (Bom bom : fullBoms) {
            BomExcelModel model = JSON.parseObject(bom.toString(), BomExcelModel.class);
            if(bom.getSizeL()!=null&&BigDecimal.ZERO.compareTo(bom.getSizeL())!=0){
                model.setSizeX("X");
            }
            if (bom.getChildRm() == null) {
                model.setSeqNo(" " );
                model.setPrice(null);
                model.setMoney(null);
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
            models.add(model);
        }
        return models;
    }
    // JSON.parseObject(KunlongUtils.toJSONString(boms),             new TypeReference<List<BomExcelModel>>() {
    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable Bom.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {

        if (queryParam.getParam() == null || queryParam.getParam().getProductId() == null) {

            rsp.getWriter().write(JsonResult.failure(-1, "没有选择产品").toString());
            rsp.setStatus(500);
            return;
        }
        //有组件

        Product product = productService.findById(queryParam.getParam().getProductId());
        rsp.setHeader("file", URLEncoder.encode(product.getEpCode(), "UTF-8"));


        String productCode = product.getEpCode();
        String fileName = String.format("成本估价单_%s.xlsx", productCode);
        List<BomCostExcelModel> costModels = buildCost(queryParam.getParam().getProductId());
        List<BomExcelModel> models = buildExcelModels(queryParam);

        Map<String, List> map = new LinkedHashMap<>();
        if (models.size() > 0) {
            map.put(productCode, models);
        }
        if (costModels.size() > 0) {
            map.put(productCode + "_cost", costModels);
        }
        //writeBomProduct(productCode,queryParam.getParam().getProductId(),rsp);
        String headFile = writeBomProduct2File(productCode , queryParam.getParam().getProductId(), fileName);
        String bomFile = EasyExcelUtil.writeBomExcels2File(productCode + "_list", productCode, map);

        String outFile = new MergeExcelSheet().mergeSheets(headFile, bomFile, fileName);
        logger.info("writeExcel2Response bom filename:{}, outFile:{}",fileName,outFile);
        EasyExcelUtil.writeExcel2Response( fileName, rsp, outFile);
        // ExcelUtil.writeExcels(rsp, fileName, productCode, map);
        // fileName = String.format("成本估价单汇总_%s.xlsx", productCode+"_cost");
        // ExcelUtil.writeExcel(rsp, fileName, productCode, costModels);

    }
    String writeBomProduct2File(String sheetName, Integer productId, String fileName) throws IOException {

        Product product = productService.findById(productId);
        Customer customer = product == null ? null : customerService.findById(product.getCustomerId());

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("customerName", customer == null ? "-" : customer.getCustName());
        if (product != null) {
            map.put("remark", product.getRemark());
            map.put("size", product.getSize());
            map.put("code", product.getCode());
        }
        return makeExcelSheet("bom_template.xlsx",fileName,sheetName,map);

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

    void addCost(List<BomCostExcelModel> models,String item,BigDecimal value)
    {
        BomCostExcelModel model = new BomCostExcelModel();
        model.setItem(item);
        model.setValue(value);
        models.add(model);

    }

    List<BomCostExcelModel> buildCost(Integer productId) {
        List<BomCostExcelModel> models = new ArrayList<>();
        JsonResult<BomCost> bomCostJsonResult = bomJoinService.findBomCostByProduct(productId);
        BomCost bomCost = bomCostJsonResult.getData();
        if (bomCost == null) {
            return models;
        }

        addCost(models, "总材料费用", bomCost.getRmFee());
        addCost(models, "损耗", bomCost.getLossRm());
        addCost(models, "开料", bomCost.getCutRm());
        addCost(models, "刀模", bomCost.getKnifeModel());
        addCost(models, "人工", bomCost.getWorkFee());
        addCost(models, "运输", bomCost.getShippingFee());
        addCost(models, "总费用", bomCost.getTotalFee());
        return models;
    }





}

