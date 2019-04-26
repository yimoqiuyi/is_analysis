package com.yp.subpark.controller;

import com.yp.common.pojo.AssessmentReport;
import com.yp.common.pojo.AssessmentTable;
import com.yp.common.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
 //�Ŷӿ��˱���
@Controller
@RequestMapping("subpark")
public class SubparkAssessmentReportController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private AssessmentReportService assessmentReportService;   //���˱���
    @Autowired
    private AchievementsNumberService achievementsNumberService; //�Ŷӳɹ���
    @Autowired
    private AssessmentTableService assessmentTableService;  //�Ŷ������
    @Autowired
    private UserService userService;   //ͨ����Ա�������Լ����������ʼ�����д�������������ڵ�����

    @RequestMapping("checkAssessmentReport")
    @RequiresPermissions("role:insert")
    public ModelAndView CheckAssessmentReport(ModelAndView modelAndView, HttpServletRequest request) {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        AssessmentReport assessmentReport=assessmentReportService.selectOneAssessmentReportByid(groupId);
        modelAndView.addObject("assessmentReport",assessmentReport);
        modelAndView.setViewName("view/subpark/SubparkAssessmentReport");
        return modelAndView;
    }
    //�޸��Ŷӿ��˱�����Ϣ
   @RequestMapping("updateAssessmentReport")
   @RequiresPermissions("role:insert")
     public String UpdateAssessmentReport(AssessmentReport assessmentReport){
      assessmentReportService.updateAssessmentReport(assessmentReport);
      return "view/subpark/index";
   }
}
