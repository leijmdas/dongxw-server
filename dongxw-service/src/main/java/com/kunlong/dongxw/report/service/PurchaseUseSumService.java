package com.kunlong.dongxw.report.service;

import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.report.base.ExportBaseService;
import com.kunlong.dongxw.report.dto.PurchaseUseSumRptDTO;
import com.kunlong.dongxw.util.ExportExcelTool;
import com.kunlong.dubbo.api.service.MetadataDictApiService;
import com.kunlong.dubbo.api.service.MetadataFieldApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PurchaseUseSumService extends ExportBaseService {

    @Autowired
    ExportExcelTool excelUtil;

    @com.alibaba.dubbo.config.annotation.Reference(lazy = true, version = "${dubbo.service.version}")
    MetadataDictApiService metadataDictApiService;
    @com.alibaba.dubbo.config.annotation.Reference(lazy = true, version = "${dubbo.service.version}")

    MetadataFieldApiService metadataFieldApiService;
    @Autowired
    CustomerService customerService;

    @Autowired
    PurchasePlanService purchasePlanService;
    @Autowired
    OrderMasterService orderMasterService;
    String path="C:\\Users\\Administrator\\Desktop\\";
    @Autowired
    OrderLineService orderLineService;

    @Autowired
    ProductService productService;

    Map<Integer,Product> queryOrderLines(Integer orderId){
        OrderLine.QueryParam qp=new OrderLine.QueryParam();
        qp.setLimit(-1);
        qp.setParam(new OrderLine());
        qp.getParam().setOrderId(orderId);
        List<OrderLine> orderLines=orderLineService.findByQueryParam(qp);

        Map<Integer, Product> map = new LinkedHashMap<>();

        for (OrderLine orderLine : orderLines) {
            Integer productId = orderLine.getProductId();
            Product product = productService.findById(productId);
            map.put(productId, product);
        }
        return map;
    }
    public String export(HttpServletResponse rsp, Integer orderId) throws IllegalAccessException, IOException, InvocationTargetException {

        OrderMaster orderMaster = orderMasterService.findById(orderId);

        Integer custId = orderMaster.getCustomerId();
        Customer customer = customerService.findById(custId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = customer.getCustName() + "-"
                + orderMaster.getCustomerOrderCode()
                + "订单物料采购进度表" + sdf.format(new Date()) + ".xlsx";
        setExcelHeader(rsp,fileName);

        Map<Integer, Product> mapProduct = queryOrderLines(orderId);

        PurchasePlan.QueryParam queryParam = new PurchasePlan.QueryParam();
        queryParam.setLimit(-1);
        queryParam.setParam(new PurchasePlan());
        queryParam.getParam().setOrderId(orderId);
        List<PurchasePlan> purchasePlans = purchasePlanService.findByQueryParam(queryParam);

        Map<Integer, List<PurchasePlan>> results = purchasePlans.stream().collect(Collectors.groupingBy(PurchasePlan::getRmId));

        List<PurchaseUseSumRptDTO> dtoList = new ArrayList<>();

        for (Integer key : results.keySet()) {
            Product rm = productService.findById(key);

            PurchaseUseSumRptDTO pum = new PurchaseUseSumRptDTO();
            pum.setCode(rm.getCode());
            pum.setName(rm.getName());
            pum.setColor(rm.getColor());
            pum.setUnit(rm.getUnit());

            pum.setMap(new TreeMap<>());
            for(Integer k:mapProduct.keySet()){
                Product p=mapProduct.get(k);
                pum.getMap().put(p.getCode() + " (" + p.getEpCode() + ")", null);

            }
            BigDecimal sum = BigDecimal.ZERO;
            for (PurchasePlan pp : results.get(key)) {
                Product product = mapProduct.get(pp.getProductId());
                pum.getMap().put(product.getCode() + " (" + product.getEpCode() + ")", pp.getTotalQty());
                sum = sum.add(pp.getTotalQty());
            }
            pum.setSum(sum);
            dtoList.add(pum);

        }
        List<PurchaseUseSumRptDTO> sortRptLst = dtoList.stream().sorted(Comparator.comparing(PurchaseUseSumRptDTO::getCode)).collect(Collectors.toList());

        String sheetTitle = orderMaster.getCustomerOrderCode() + "用料汇总" + sdf.format(new Date());
        excelUtil.erpExportExcel(rsp.getOutputStream(), sheetTitle, sortRptLst);
        return fileName;

    }
    public String export(OutputStream outputStream, Integer orderId) throws IllegalAccessException, IOException, InvocationTargetException {

        OrderMaster orderMaster = orderMasterService.findById(orderId);

        Integer custId = orderMaster.getCustomerId();
        Customer customer = customerService.findById(custId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = customer.getCustName() + "-"
                + orderMaster.getCustomerOrderCode()
                + "订单物料采购进度表" + sdf.format(new Date()) + ".xlsx";

        Map<Integer, Product> mapProduct = queryOrderLines(orderId);

        PurchasePlan.QueryParam queryParam = new PurchasePlan.QueryParam();
        queryParam.setLimit(-1);
        queryParam.setParam(new PurchasePlan());
        queryParam.getParam().setOrderId(orderId);
        List<PurchasePlan> purchasePlans = purchasePlanService.findByQueryParam(queryParam);

        Map<Integer, List<PurchasePlan>> results = purchasePlans.stream().collect(Collectors.groupingBy(PurchasePlan::getRmId));

        List<PurchaseUseSumRptDTO> dtoList = new ArrayList<>();

        for (Integer key : results.keySet()) {
            Product rm = productService.findById(key);

            PurchaseUseSumRptDTO pum = new PurchaseUseSumRptDTO();
            pum.setCode(rm.getCode());
            pum.setName(rm.getName());
            pum.setColor(rm.getColor());
            pum.setUnit(rm.getUnit());

            pum.setMap(new TreeMap<>());
            for(Integer k:mapProduct.keySet()){
                Product p=mapProduct.get(k);
                pum.getMap().put(p.getCode() + " (" + p.getEpCode() + ")", null);

            }
            BigDecimal sum = BigDecimal.ZERO;
            for (PurchasePlan pp : results.get(key)) {
                Product product = mapProduct.get(pp.getProductId());
                pum.getMap().put(product.getCode() + " (" + product.getEpCode() + ")", pp.getTotalQty());
                sum = sum.add(pp.getTotalQty());
            }
            pum.setSum(sum);
            dtoList.add(pum);

        }
        List<PurchaseUseSumRptDTO> sortRptLst = dtoList.stream().sorted(Comparator.comparing(PurchaseUseSumRptDTO::getCode)).collect(Collectors.toList());

        String sheetTitle = orderMaster.getCustomerOrderCode() + "用料汇总" + sdf.format(new Date());
        excelUtil.erpExportExcel(outputStream, sheetTitle, sortRptLst);
        return fileName;

    }
}
