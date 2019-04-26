package com.yp.subpark.controller;

import com.yp.common.pojo.AssessmentTable;
import com.yp.common.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
//�Ŷ�����ָ���
@Controller
@RequestMapping("subpark")
public class SubparkAssessmentTableController {
     @Autowired
    private AssessmentTableService assessmentTableService; //����ָ���
    //�Ŷӷ�������
    @RequestMapping("distributionAchievements")
    @RequiresPermissions("role:insert")
    public ModelAndView DistributionAchievements(ModelAndView modelAndView, HttpServletRequest request){
        int groupId=Integer.parseInt(request.getParameter("groupId"));
        AssessmentTable assessmentTable=assessmentTableService.selectOneAssessmentTableByid(groupId);
        if(assessmentTable==null){
            modelAndView.addObject("groupId",groupId);
            modelAndView.setViewName("view/subpark/IncreaseAchievements");
        }
        else{
            modelAndView.addObject("assessmentTable",assessmentTable);
            modelAndView.setViewName("view/subpark/DisplayAchievements");
        }
        return modelAndView;
    }
    //�޸��Ŷӳɹ���
    @RequestMapping("updateAssessmentTable")
    @RequiresPermissions("role:insert")
    public String UpdateAssessmentTable(AssessmentTable assessmentTable){
        assessmentTableService.updateOneAssessmentTableByid(assessmentTable);
        return "view/subpark/index";
    }
   //����Ŷӳɹ���
    @RequestMapping("insertAssessmentTable")
    @RequiresPermissions("role:insert")
    public String InsertAssessmentTable(AssessmentTable assessmentTable){
        assessmentTableService.insertOneAssessmentTable(assessmentTable);
        return "view/subpark/index";
    }
    //�鿴�Ŷӳɹ���
    @RequestMapping("selectAssessmentTable")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectAssessmentTable(ModelAndView modelAndView,HttpServletRequest request){
        AssessmentTable assessmentTable=assessmentTableService.selectOneAssessmentTableByid(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("assessmentTable",assessmentTable);
        modelAndView.setViewName("view/subpark/DisplayAchievements");
        return modelAndView;
    }
}
