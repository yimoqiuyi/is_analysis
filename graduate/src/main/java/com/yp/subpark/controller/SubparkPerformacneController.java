package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.*;
import com.yp.common.service.GroupService;
import com.yp.common.service.PerformanceService;
import com.yp.common.service.SubParkService;
import com.yp.common.service.UserService;
import com.yp.common.service.impl.SalaryDao;
import com.yp.subpark.jsonUtil.PerformacneToJson;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkPerformacneController {
    @Autowired
    private PerformanceService performanceService; //��Ч
    @Autowired
    private GroupService groupService;//�Ŷ�
    @Autowired
    private UserService userService;//�û�
    @Autowired
    private SubParkService subParkService;


    //�����ŶӼ�Ч
    @RequestMapping("performanceOperation")
    @RequiresPermissions("role:insert")
    public String PerformanceOperation() {
        return "view/subpark/PerformanceOperation";
    }

    @RequestMapping("subparkPerformance")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> SubparkPerformance(Integer page, Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
        List<Performance> performanceList = performanceService.selectPerformanceBySubparkIdAndLimit(subParkId, page, limit);
        JSONArray groupData = PerformacneToJson.PerformacneInfoToJson(performanceList);
        if (groupData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", groupData.size());
            jsonObject.put("data", groupData);
            return jsonObject;
        }
        return null;
    }

    //��Ч¼��
    @RequestMapping("insertPerformance")
    @RequiresPermissions("role:insert")
    public ModelAndView InsertPerformance(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        Group group = groupService.selectOneGroupById(groupId);
        String groupName = group.getGroupName();
        int subParkId = group.getSubParkId();
        SubPark subPark = subParkService.selectOneSubParkById(subParkId);
        int generalParkId = subPark.getGeneralParkId();
        List<User> userList = userService.selectAllUserBygroupId(groupId);
        int sanitationScore = 0;
        int attendanceScore = 0;
        int performanceScore = 0;
        int score = 0;
        int num = userList.size();
        for (User user : userList) {
            sanitationScore += user.getSanitationScore();
            attendanceScore += user.getAttendanceScore();
        }
        score = num * 2 * 100;
        performanceScore = score - (sanitationScore + attendanceScore);
        Performance performance = new Performance();
        performance.setGroupId(groupId);
        performance.setGeneralParkId(generalParkId);
        performance.setSubParkId(subParkId);
        performance.setPerformanceScore(performanceScore);
        modelAndView.addObject("performance", performance);
        modelAndView.setViewName("view/subpark/RegistPerformance");
        return modelAndView;
    }

    @RequestMapping("insertToPerformance")
    @RequiresPermissions("role:insert")
    public String InsertToPerformance(Performance performance) {
        performanceService.insertPerformance(performance);
        return "view/subpark/index";
    }

    //�鿴��Ч
    @RequestMapping("selectPerformance")
    @RequiresPermissions("role:insert")
    public String SelectPerformance() {
        return "view/subpark/SubparkPerformace";
    }

    @RequestMapping("checkPerformance")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    Map<String, Object> CheckPerformance(Integer page, Integer limit) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
        List<Performance> performanceList = performanceService.selectPerformanceBySubparkIdAndLimit(subParkId, page, limit);
        JSONArray groupData = PerformacneToJson.PerformacneInfoToJson(performanceList);
        if (groupData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", groupData.size());
            jsonObject.put("data", groupData);
            return jsonObject;
        }
        return null;
    }

    //ѡ���԰����Ч�鿴
    @RequestMapping("selectSubparkPerformance")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectSubparkPerformance(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                                 @RequestParam("endTime") String endTime) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
        Dateutile dateutile = new Dateutile();
        dateutile.setId(subParkId);
        dateutile.setSignDate(beginTime);
        dateutile.setExpirationDate(endTime);
        List<Performance> performanceList = performanceService.selectPerformanceBySubparkIdAndTime(dateutile);
        modelAndView.addObject("performanceList", performanceList);
        modelAndView.setViewName("view/subpark/SelectSubparkPerformance");
        return modelAndView;
    }

    //ѡ���ŶӼ�Ч�鿴
    @RequestMapping("checkGroupPerformance")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckPerformance(HttpServletRequest request, ModelAndView modelAndView) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<Performance> performanceList = performanceService.selectPerformanceByGroupId(groupId);
        modelAndView.addObject("performanceList", performanceList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/CheckPerformance");
        return modelAndView;
    }

    @RequestMapping("selectGroupPerformance")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectGroupPerformance(ModelAndView modelAndView, @RequestParam("beginTime") String beginTime,
                                               @RequestParam("endTime") String endTime, Integer groupId) {
        Dateutile dateutile = new Dateutile();
        dateutile.setId(groupId);
        dateutile.setSignDate(beginTime);
        dateutile.setExpirationDate(endTime);
        List<Performance> performanceList = performanceService.selectPerformanceByGroupIdAndTime(dateutile);
        modelAndView.addObject("performanceList", performanceList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/subpark/SelectGroupPerformance");
        return modelAndView;
    }

    //ɾ���Ŷ���һ����Ч
    @RequestMapping("deleteGroupPerformance")
    @RequiresPermissions("role:insert")
    public String DeleteGroupPerformance(HttpServletRequest request) {
        performanceService.deletePerformanceById(Integer.parseInt(request.getParameter("performanceId")));
        return "redirect:selectPerformance.do";
    }

    //�鿴һ����Ч
    @RequestMapping("checkOnePerformance")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckOnePerformance(ModelAndView modelAndView, HttpServletRequest request) {
        Performance performance = performanceService.selectOnePerformance(Integer.parseInt(request.getParameter("performanceId")));
        modelAndView.addObject("performance", performance);
        modelAndView.setViewName("view/subpark/CheckOnePerformance");
        return modelAndView;
    }

    //����һ����Ч
    @RequestMapping("updateOnePerformance")
    @RequiresPermissions("role:insert")
    public String UpdateOnePerformance(Performance performance) {
        performanceService.updatePerformance(performance);
        return "view/subpark/index";
    }

    //�����Ŷ�excel��Ч
    @RequestMapping("performancesDownload")
    @RequiresPermissions("role:insert")
    public @ResponseBody
    void PerformanceDownload(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, UnsupportedEncodingException, IntrospectionException, ParseException {
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
}


