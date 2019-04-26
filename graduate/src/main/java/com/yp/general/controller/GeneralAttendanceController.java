package com.yp.general.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.subpark.jsonUtil.GroupToJson;
import com.yp.user.jsonUtil.UserToJson;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneralAttendanceController {
    @Autowired
    private GroupService groupService; //�Ŷ�
    @Autowired
    private AchievementsNumberService achievementsNumberService;//�ɹ�
    @Autowired
    private UserService userService;
    @Autowired
    private AssessmentReportService assessmentReportService;   //���˱���
    @Autowired
    private AttendanceService attendanceService;

    //������Ϣ
    @RequestMapping("generalAttendance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView GroupUser(ModelAndView modelAndView, HttpServletRequest request) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        modelAndView.addObject("subParkId", subParkId);
        modelAndView.setViewName("view/general/GeneralAttendance");
        return modelAndView;
    }

    @RequestMapping("selectGeneralAttendance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SelectGeneralAttendance(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        List<Group> groups = groupService.selectAllGroupBysubParkId(subParkId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Group> groupList = groupService.selectAllGroupBysubParkId(subParkId); //��ҳ�鿴��Ա
        JSONArray groupData = GroupToJson.GroupInfoToJson(groupList);
        if (groupData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", groups.size());
            jsonObject.put("data", groupData);
            return jsonObject;
        }
        return null;
    }

    @RequestMapping("selectSubparkAttendance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectgeneralAttendance(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/SelectgeneralAttendance");
        return modelAndView;
    }

    @RequestMapping("checkUserAttendance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> CheckUserAttendance(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> users = userService.selectAllUserBygroupId(groupId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<User> userList = userService.selectAllUserBygroupId(groupId); //��ҳ�鿴��Ա
        JSONArray userData = UserToJson.UserInfoToJson(userList);
        if (userData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", users.size());
            jsonObject.put("data", userData);
            return jsonObject;
        }
        return null;
    }

    //�鿴���˿������
    @RequestMapping("selectGeneralUserAttendance")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectGeneralUserAttendance(HttpServletRequest request, ModelAndView modelAndView) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Attendance> attendanceList = attendanceService.selectAttendanceByUserId(userId);
        User user = userService.selectOneUserById(userId);
        modelAndView.addObject("user", user);
        modelAndView.addObject("attendanceList", attendanceList);
        modelAndView.setViewName("view/general/GeneralUserAttendance");
        return modelAndView;
    }

    //������Ϣ
    @RequestMapping("checkGeneralAssessmentReport")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView CheckGeneralAssessmentReport(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        AssessmentReport assessmentReport = assessmentReportService.selectOneAssessmentReportByid(groupId);
        modelAndView.addObject("assessmentReport", assessmentReport);
        modelAndView.setViewName("view/general/GeneralAssessmentReport");
        return modelAndView;
    }

    //�鿴�ɹ���Ϣ
    @RequestMapping("selectgeneralAchievementsNumber")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectgeneralAchievementsNumber(HttpServletRequest request, ModelAndView modelAndView) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(groupId);
        modelAndView.addObject("achievementsNumber", achievementsNumber);
        modelAndView.setViewName("view/general/GeneralAchievementsNumber");
        return modelAndView;
    }

    //������״ͼ
    @RequestMapping("attendacneHistogram")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView AttendacneHistogram(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/AttendacneHistogram");
        return modelAndView;
    }

    @RequestMapping(value = "checkUserHistogram",method = RequestMethod.POST)
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> CheckUserHistogram(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> users = userService.selectAllUserBygroupId(groupId); //�鿴���еĳ�Ա
        Echart echart = new Echart();
        List<String> categories = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (User user : users) {
            String userName = user.getUserName();
            int attendanceScore = user.getAttendanceScore();
            categories.add(userName);
            data.add(attendanceScore);
        }
        echart.setCategories(categories);
        echart.setData(data);
        JSONObject jsonObj = (JSONObject) JSONArray.toJSON(echart);
        return jsonObj;
    }

    //��������ͼ
    @RequestMapping("attendacneGraph")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView AttendacneGraph(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/AttendacneGraph");
        return modelAndView;
    }

    @RequestMapping(value = "checkUserGraph",method = RequestMethod.POST)
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> CheckUserGraph(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        List<User> users = userService.selectAllUserBygroupId(groupId); //�鿴���еĳ�Ա
        Echart echart = new Echart();
        List<String> categories = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (User user : users) {
            String userName = user.getUserName();
            int attendanceScore = user.getAttendanceScore();
            categories.add(userName);
            data.add(attendanceScore);
        }
        echart.setCategories(categories);
        echart.setData(data);
        JSONObject jsonObj = (JSONObject) JSONArray.toJSON(echart);
        return jsonObj;
    }
}
