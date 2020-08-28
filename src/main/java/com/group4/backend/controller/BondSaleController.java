package com.group4.backend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group4.backend.entity.DemoBond;
import com.group4.backend.entity.DemoUser;
import com.group4.backend.service.DemoBondService;
import com.group4.backend.tool.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("BondSaleCtrl")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class BondSaleController {
    @Autowired
    private DemoBondService demoBondService;

    @RequestMapping("/querybond")
    @ResponseBody
    public List<DemoBond> queryBond(@RequestParam("bondName") String bondName,
                                    @RequestParam("saleName") String saleName,
                                    @RequestParam("createdAt") String createdAt,
                                    @RequestParam("amount") BigDecimal amount,
                                    Model model) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date newCreatedAt = sdf.parse(createdAt);
        java.sql.Date dayDateSql = new java.sql.Date(newCreatedAt.getTime());
        DemoBond demoBond = new DemoBond();
        demoBond.setAmount(amount);
        demoBond.setSaleName(saleName);
        demoBond.setBondName(bondName);
        demoBond.setCreatedAt(dayDateSql);
        return demoBondService.queryBond(demoBond);
    }

    @RequestMapping("/queryBondByJson")
    @ResponseBody
    public List<DemoBond> queryBondByJson(@RequestBody String body, HttpServletRequest request) throws ParseException {
        if (!UserTool.loginStatus) return null;
        DemoBond demoBond = JSONObject.parseObject(body, DemoBond.class);

        return demoBondService.queryBond(demoBond);
    }

    @RequestMapping("/ordersale")
    @ResponseBody
    public String orderBySaleName(@RequestBody DemoBond demoBond, HttpServletRequest request) {
        if (!UserTool.loginStatus) return null;
        List<Map<String, String>> result = demoBondService.orderBySaleName(demoBond);

        return JSONObject.toJSONString(result);
    }

    @RequestMapping("/orderdate")
    @ResponseBody
    public String orderByCreated(@RequestBody DemoBond demoBond, HttpServletRequest request) {
        if (!UserTool.loginStatus) return null;
        List<Map<String, String>> result = demoBondService.orderByCreated(demoBond);

        return JSONObject.toJSONString(result);
    }

    @PostMapping("addRecord")
    @ResponseBody
    public String login(@RequestBody DemoBond bondSales, HttpServletRequest request) {
        if (!UserTool.loginStatus) return null;
        try {
            demoBondService.addRecord(bondSales);
        }
        catch(Exception e){
            return JSONObject.toJSONString("Invalid Record!");
        }
        return JSONObject.toJSONString("Recorded Correctly!");
    }

    @PostMapping("deleteRecord")
    @ResponseBody
    public String deleteRecord(@RequestBody DemoBond bondSales, HttpServletRequest request) {
        try {
            demoBondService.deleteRecord(bondSales);
        }
        catch(Exception e){
            return "Failed to delete record!";
        }
        return "Deleted Correctly!";
    }

    @PostMapping("modifyRecord")
    @ResponseBody
    public String modifyRecord(@RequestBody DemoBond bondSales, HttpServletRequest request) {
        try {
            demoBondService.modifyRecord(bondSales);
        }
        catch(Exception e){
            return "Failed to modify record!";
        }
        return "Modified Correctly!";
    }

    @RequestMapping("importData")
    @ResponseBody
    public String importData (@RequestBody List<DemoBond> bondData) {
        if (!UserTool.loginStatus) return null;
        demoBondService.importBonds(bondData);
        return JSONObject.toJSONString(true);
    }

}
