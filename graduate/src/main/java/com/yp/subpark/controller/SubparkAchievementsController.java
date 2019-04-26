package com.yp.subpark.controller;

import com.yp.common.pojo.Achievements;
import com.yp.common.pojo.AchievementsNumber;
import com.yp.common.pojo.AssessmentTable;
import com.yp.common.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("subpark")
public class SubparkAchievementsController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private AchievementsService achievementsService; //�ɹ����ñ�
    @Autowired
    private AssessmentTableService assessmentTableService; //����ָ���
    @Autowired
    private PaperService paperService;
    @Autowired
    private PatentService patentService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private SoftwareService softwareService;
    @Autowired
    private AchievementsNumberService achievementsNumberService;

    //��ȡ�ɹ�
    @RequestMapping("getAllAchievements")
    @RequiresPermissions("role:insert")
    public ModelAndView getAllAchievements(ModelAndView modelAndView, HttpServletRequest request) {
        String groupId = request.getParameter("groupId");
        List<Achievements> achievementsList = achievementsService.getAllachievements();
        modelAndView.addObject("groupId", groupId);
        modelAndView.addObject("achievementsList", achievementsList);
        modelAndView.setViewName("view/subpark/GroupAchievements");
        return modelAndView;
    }

    //�޸ĳɹ�
    @RequestMapping("updateAchievement")
    @RequiresPermissions("role:insert")
    public ModelAndView UpdateAchievement(ModelAndView modelAndView, HttpServletRequest request) {
        Achievements achievements = achievementsService.selectAchievementsByachievementsId(Integer.parseInt(request.getParameter("achievementsId")));
        modelAndView.addObject("achievements", achievements);
        modelAndView.setViewName("view/subpark/UpdateAchievement");
        return modelAndView;
    }

    @RequestMapping("updateOneAchievement")
    @RequiresPermissions("role:insert")
    private String UpdateOneAchievement(Achievements achievements) {
        achievementsService.updateAchievement(achievements);
        return "view/subpark/index";
    }

    //ɾ���ɹ�����
    @RequestMapping("deleteAchievement")
    @RequiresPermissions("role:insert")
    public String DeleteAchievements(HttpServletRequest request) {
        int achievementsId = Integer.parseInt(request.getParameter("achievementsId"));
        achievementsService.delectAchievements(achievementsId);  //ɾ����������ļ��ĳɹ�
        softwareService.deleteSoftWareByAchievementsId(achievementsId);
        paperService.deletePaperByAchievementsId(achievementsId);
        patentService.deletePatentByAchievementsId(achievementsId);
        competitionService.deleteCompitionByAchievementsId(achievementsId);
        return "view/subpark/index";
    }

    //��ӳɹ�
    @RequestMapping("insertAchievement")
    @RequiresPermissions("role:insert")
    public String InsertAchievement() {
        return "view/common/RegistAchievement";
    }

    @RequestMapping("insertToAchievement")
    @RequiresPermissions("role:insert")
    private String InsertToAchievement(Achievements achievements) {
        achievementsService.insertAchievements(achievements);
        return "view/subpark/index";
    }

    //��ȡ�Ŷӳɹ�
    @RequestMapping("getGroupAchievements")
    @RequiresPermissions("role:insert")
    public ModelAndView GetGroupAchievements(ModelAndView modelAndView, HttpServletRequest request) {
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("achievementsNumber", achievementsNumber);
        modelAndView.addObject("groupId", request.getParameter("groupId"));
        modelAndView.setViewName("view/subpark/GetGroupAchievements");
        return modelAndView;
    }


}
