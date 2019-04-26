package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yp.common.pojo.Performance;
import com.yp.common.service.GroupService;
import com.yp.common.service.PerformanceService;
import com.yp.common.service.SubParkService;
import com.yp.common.service.UserService;
import com.yp.subpark.jsonUtil.PerformacneToJson;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneraPerformanceController {
    @Autowired
    private PerformanceService performanceService; //��Ч
    @Autowired
    private GroupService groupService;//�Ŷ�
    @Autowired
    private UserService userService;//�û�
    @Autowired
    private SubParkService subParkService;

    @RequestMapping("selectSubparkPerformance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectSubparkPerformance(ModelAndView modelAndView, HttpServletRequest request) {
        String subParkId = request.getParameter("subParkId");
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/SubparkPerformance");
        return modelAndView;
    }

    @RequestMapping("checkGroupPerformance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> checkGroup(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        List<Performance> performances = performanceService.selectPerformanceBySubparkId(subParkId);
        PageHelper.startPage(page, limit);
        List<Performance> performanceList = performanceService.selectPerformanceBySubparkId(subParkId);
        JSONArray performanceDate = PerformacneToJson.PerformacneInfoToJson(performanceList);
        if (performanceDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", performances.size());
            jsonObject.put("data", performanceDate);
            return jsonObject;
        }
        return null;
    }
    //ģ����ѯ�ŶӼ�Ч

    //�����Ŷ�excel��Ч
    @RequestMapping("downLoadPerformance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    void DownLoadPerformance(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, UnsupportedEncodingException, IntrospectionException, ParseException {
        response.reset(); //���buffer����
        // ָ�����ص��ļ��������������ʹ�ñ��ر��룬��GBK��������յ�����ļ�������ISO-8859-1�����룬Ȼ����GBK����ʾ
        // ����������GBK���룬ISO-8859-1�����룬��������Ǳ߻ᷴ����ִ�С�
        String fileName = "Performance.xls";
        String name = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        response.setHeader("Content-Disposition", "attachment; filename=" + name);
        XSSFWorkbook workbook = null;
        //����Excel����
        workbook = performanceService.downLoadExcel(Integer.parseInt(request.getParameter("groupId")));
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            output.close();
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ģ����ѯ
    @RequestMapping("fuzzyGroupPerformance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView FuzzyGroupPerformance(ModelAndView modelAndView,
                                              @RequestParam("subParkId") String subParkId,
                                              @RequestParam("condition") String condition) {
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.addObject("condition", condition);
        modelAndView.setViewName("view/general/FuzzyGroupPerformance");
        return modelAndView;
    }

    @RequestMapping("fuzzyGroupPerformances")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> FuzzyGroupPerformances(HttpServletRequest request, Integer page, Integer limit) {
        System.out.println("11111de" + page);
        String condition = request.getParameter("condition");
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("condition", condition);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Performance> performanceList = performanceService.selectPerformanceByCondition(map);
        JSONArray performanceDate = PerformacneToJson.PerformacneInfoToJson(performanceList);
        if (performanceDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", performanceDate.size());
            jsonObject.put("data", performanceDate);
            return jsonObject;
        }
        return null;
    }

}
