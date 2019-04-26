package com.yp.user.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserWorkPositionController {
    @Autowired
    private WorkPositionService workPositionService;
    @Autowired
    private SanitationService sanitationService;  //����
    @Autowired
    private AttendanceService attendanceService; //����
    @Autowired
    private WorkstylePictureService workstylePictureService;
    @Autowired
    private GroupService groupService;
    @RequestMapping("viewPosition")
    @RequiresPermissions(value="permission:select")
    public ModelAndView ViewOneSelfPositionById(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        int workId = user.getWorkId();
        WorkPosition workPosition = workPositionService.selectOneWorkPositionById(workId);
        WorkstylePicture workstylePicture = workstylePictureService.selectWorkstylePictureByworkId(workId);
        int groupId=workPosition.getGroupId();
         Group group=groupService.selectOneGroupById(groupId);
         modelAndView.addObject("user", user); //�û�
        modelAndView.addObject("workPosition", workPosition); //��λ
        modelAndView.addObject("workstylePicture", workstylePicture); //��λ��ʽ
        modelAndView.addObject("group",group); //�ŶӸ���
        modelAndView.setViewName("view/user/positionCondition");
        return modelAndView;
    }
     @RequestMapping("sanitation")
     @RequiresPermissions(value="permission:select")
    public ModelAndView ViewOneSelfSanitationById(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        List<Sanitation> sanitationList = sanitationService.selectSanitationByUserId(userId);
        modelAndView.addObject("sanitationList", sanitationList);
        modelAndView.setViewName("view/user/positionSanitation");
        return modelAndView;
    }
@RequestMapping("attendance")
@RequiresPermissions(value="permission:select")

    public ModelAndView ViewOneSelfAttendanceById(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        List<Attendance> attendanceList = attendanceService.selectAttendanceByUserId(userId);
        modelAndView.addObject("attendanceList", attendanceList);
        modelAndView.setViewName("view/user/positionAttendance");
        return modelAndView;
    }
}
