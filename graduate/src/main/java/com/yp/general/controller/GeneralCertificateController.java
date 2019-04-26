package com.yp.general.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.subpark.jsonUtil.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("general")
public class GeneralCertificateController {
    @Autowired
    private PatentService patentService;  //ר��
    @Autowired
    private SoftwareService softwareService; //����
    @Autowired
    private PaperService paperService;  //����
    @Autowired
    private CompetitionService competitionService; //����
    @Autowired
    private GroupService groupService;
    @Autowired
    private AchievementsNumberService achievementsNumberService; //�Ŷӳɹ�

    //�ɹ�����
    @RequestMapping("generalCertificate")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectBuildings(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("subParkId", request.getParameter("subParkId"));
        modelAndView.setViewName("view/general/GeneralCertificate");
        return modelAndView;
    }

    //ר������
    @RequestMapping("selectGeneralPatent")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SelectGeneralPatent(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        Map<String, Object> map = new HashMap<>();
        map.put("subParkId", subParkId);
        map.put("page", page - 1);
        map.put("limit", limit);
        List<Patent> patentList = patentService.selectPatentByLimit(map);
        JSONArray patentData = PatentToJson.PatentInfoToJson(patentList);
        if (patentData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", patentData.size());
            jsonObject.put("data", patentData);
            return jsonObject;
        }
        return null;
    }

    //��������
    @RequestMapping("selectGeneralPaper")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectGeneralPaper(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("subParkId", request.getParameter("subParkId"));
        modelAndView.setViewName("view/general/GeneralPaper");
        return modelAndView;
    }

    @RequestMapping("generalPaper")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> SelectGeneralPaper(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
        Map<String, Object> map = new HashMap<>();
//        map.put("subParkId", subParkId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Paper> paperList = paperService.selectPaperByLimit(map);
        List<Paper> papers = paperService.selectAllPaperBysubParkId(subParkId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Paper> paperList = paperService.selectAllPaperBysubParkId(subParkId); //��ҳ�鿴��Ա
        JSONArray paperDate = PaperToJson.PaperInfoToJson(paperList);
        if (paperDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", papers.size());
            jsonObject.put("data", paperDate);
            return jsonObject;
        }
        return null;
    }

    //��������
    @RequestMapping("selectGeneralSoftware")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView selectGeneralSoftware(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("subParkId", request.getParameter("subParkId"));
        modelAndView.setViewName("view/general/GeneralSoftware");
        return modelAndView;
    }

    @RequestMapping("generalSoftware")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GeneralSoftware(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("subParkId", subParkId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Software> softwareList = softwareService.selectSoftwareByLimit(map);
        List<Software> softwares = softwareService.selectAllSoftwareBysubParkId(subParkId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Software> softwareList = softwareService.selectAllSoftwareBysubParkId(subParkId); //��ҳ�鿴��Ա
        JSONArray softWareDate = SoftToJson.SoftWareInfoToJson(softwareList);
        if (softWareDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", softwares.size());
            jsonObject.put("data", softWareDate);
            return jsonObject;
        }
        return null;
    }

    //��������
    @RequestMapping("selectGeneralCompetion")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectGeneralCompetion(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("subParkId", request.getParameter("subParkId"));
        modelAndView.setViewName("view/general/GeneralCompetion");
        return modelAndView;
    }

    @RequestMapping("generalCompetion")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GeneralCompetion(HttpServletRequest request, Integer page, Integer limit) {
        int subParkId = Integer.parseInt(request.getParameter("subParkId"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("subParkId", subParkId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Competition> competitionList = competitionService.selectCompetitionByLimit(map);
        List<Competition> competitions = competitionService.selectAllCompetitionBysubParkId(subParkId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Competition> competitionList = competitionService.selectAllCompetitionBysubParkId(subParkId); //��ҳ�鿴��Ա
        JSONArray competitionDate = CompetionToJson.CompetionInfoToJson(competitionList);
        if (competitionDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", competitions.size());
            jsonObject.put("data", competitionDate);
            return jsonObject;
        }
        return null;
    }

    //�Ŷ�ר��
    @RequestMapping("selectGroupPatent")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectGroupPatent(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/GroupPatent");
        return modelAndView;
    }

    @RequestMapping("groupPatent")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GroupPatent(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("groupId", groupId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Patent> patentList = patentService.selectPatentByGroupIdandLimit(map);
        List<Patent> patents = patentService.selectAllPatentBygroupId(groupId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Patent> patentList = patentService.selectAllPatentBygroupId(groupId); //��ҳ�鿴��Ա
        JSONArray patentData = PatentToJson.PatentInfoToJson(patentList);
        if (patentData != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", patents.size());
            jsonObject.put("data", patentData);
            return jsonObject;
        }
        return null;
    }

    //�Ŷ�����
    @RequestMapping("selectGroupPaper")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectGroupPaper(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/GroupPaper");
        return modelAndView;
    }

    @RequestMapping("groupPaper")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GroupPaper(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("groupId", groupId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Paper> paperList = paperService.selectPaperByGroupIdandLimit(map);
        List<Paper> papers = paperService.selectAllPaperBygroupId(groupId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Paper> paperList = paperService.selectAllPaperBygroupId(groupId); //��ҳ�鿴��Ա
        JSONArray paperDate = PaperToJson.PaperInfoToJson(paperList);
        if (paperDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", papers.size());
            jsonObject.put("data", paperDate);
            return jsonObject;
        }
        return null;
    }

    //�Ŷ�����
    @RequestMapping("selectGroupSoftware")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectGroupSoftware(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/GroupSoftware");
        return modelAndView;
    }

    @RequestMapping("groupSoftware")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GroupSoftware(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("groupId", groupId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Software> softwareList = softwareService.selectSoftwareByGroupIdandLimit(map);
        List<Software> softwares = softwareService.selectAllSoftwareBygroupId(groupId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Software> softwareList = softwareService.selectAllSoftwareBygroupId(groupId); //��ҳ�鿴��Ա
        JSONArray softWareDate = SoftToJson.SoftWareInfoToJson(softwareList);
        if (softWareDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", softwares.size());
            jsonObject.put("data", softWareDate);
            return jsonObject;
        }
        return null;
    }

    //�ŶӾ���
    @RequestMapping("selectGroupCompetion")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView SelectGroupCompetion(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/general/GroupCompetion");
        return modelAndView;
    }

    @RequestMapping("groupCompetion")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GroupCompetion(HttpServletRequest request, Integer page, Integer limit) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("groupId", groupId);
//        map.put("page", page - 1);
//        map.put("limit", limit);
//        List<Competition> competitionList = competitionService.selectCompetitionByGroupIdandLimit(map);
        List<Competition> competitions = competitionService.selectAllCompetitionBygroupId(groupId); //�鿴���еĳ�Ա
        PageHelper.startPage(page, limit);
        List<Competition> competitionList = competitionService.selectAllCompetitionBygroupId(groupId); //��ҳ�鿴��Ա
        JSONArray competitionDate = CompetionToJson.CompetionInfoToJson(competitionList);
        if (competitionDate != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", competitions.size());
            jsonObject.put("data", competitionDate);
            return jsonObject;
        }
        return null;
    }

    //�Ŷ�֤����״ͼ
    @RequestMapping("certificateHistogram")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView CertificateHistogram(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/general/CertificateHistogram");
        return modelAndView;
    }

    @RequestMapping(value = "getCertificateHistogram", method = RequestMethod.POST)
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public @ResponseBody
    Map<String, Object> GetCertificateHistogram(HttpServletRequest request) {
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(Integer.parseInt(request.getParameter("groupId")));
        Echart echart = new Echart();
        List<String> categories = Arrays.asList("Patent", "Soft", "Paper", "Competion");
        List<Integer> data = Arrays.asList(achievementsNumber.getPatentNum(), achievementsNumber.getSoftwareNum(), achievementsNumber.getPaperNum(), achievementsNumber.getCompetitionNum());
        echart.setCategories(categories);
        echart.setData(data);
        JSONObject jsonObj = (JSONObject) JSON.toJSON(echart);
        return jsonObj;
    }

    //�Ŷ�����ͼ
    @RequestMapping("certificateGraph")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public ModelAndView CertificateGraph(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("view/general/CertificateGraph");
        return modelAndView;
    }

    @RequestMapping(value = "getCertificateGraph", method = RequestMethod.POST)
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
     public @ResponseBody
    Map<String, Object> GetCertificateGraph(HttpServletRequest request) {
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(Integer.parseInt(request.getParameter("groupId")));
        Echart echart = new Echart();
        List<String> categories = Arrays.asList("Patent", "Soft", "Paper", "Competion");
        List<Integer> data = Arrays.asList(achievementsNumber.getPatentNum(), achievementsNumber.getSoftwareNum(), achievementsNumber.getPaperNum(), achievementsNumber.getCompetitionNum());
        echart.setCategories(categories);
        echart.setData(data);
        JSONObject jsonObj = (JSONObject) JSON.toJSON(echart);
        return jsonObj;
    }
}
