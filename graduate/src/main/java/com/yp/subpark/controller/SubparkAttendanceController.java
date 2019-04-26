package com.yp.subpark.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yp.common.pojo.Attendance;
import com.yp.common.pojo.Group;
import com.yp.common.pojo.User;
import com.yp.common.service.*;
import com.yp.subpark.jsonUtil.GroupToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("subpark")
public class SubparkAttendanceController {
    @Autowired
    private SubParkService subParkService;  //԰��
    @Autowired
    private GroupService groupService;  //�Ŷ�
    @Autowired
    private UserService userService;   //��Ա
    @Autowired
    private AttendanceService attendanceService;  //����
    @Autowired
    private WorkAttendanceService workAttendanceService;
    @RequestMapping("subparkAttendance")
    @RequiresPermissions("role:insert")
    public String SubparkAttendance(){
        return "view/subpark/SubparkAttendance";
    }
    @RequestMapping("selectGroupAttendance")
    @RequiresPermissions("role:insert")
    public  @ResponseBody
    Map<String, Object> SelectGroupAttendance(Integer page,Integer limit){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subParkId = user.getSubParkId();
        List<Group> groupList = groupService.selectGroupByLimit(subParkId, page, limit);
        JSONArray groupData = GroupToJson.GroupInfoToJson(groupList);
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
    //����
    @RequestMapping("attendanceOperation")
    @RequiresPermissions("role:insert")
    public ModelAndView AttendanceOperation(ModelAndView modelAndView){
        List<Attendance> attendanceList=attendanceService.selectAllAttendance();
        modelAndView.addObject("attendanceList",attendanceList);
        modelAndView.setViewName("view/subpark/AttendanceOperation");
        return modelAndView;
    }
    //��ӿ���
    @RequestMapping("addAttendance")
    @RequiresPermissions("role:insert")
    public String AddAttendance(){
        return "view/common/AddAttendance";
    }
    @RequestMapping("insertAttendacne")
    @RequiresPermissions("role:insert")
    public String InsertAttendance(Attendance attendance){
        attendanceService.insertAttendance(attendance);
        return "view/subpark/index";
    }

    //�޸Ŀ���
    @RequestMapping("updateAttendance")
    @RequiresPermissions("role:insert")
    public ModelAndView  updateAttendace(ModelAndView modelAndView,HttpServletRequest request){
        Attendance attendance=attendanceService.selectOneAttendanceById(Integer.parseInt(request.getParameter("attendanceId")));
        modelAndView.addObject("attendance",attendance);
        modelAndView.setViewName("view/common/SubparkAttendance");
        return modelAndView;
    }
    @RequestMapping("updateToAttendacne")
    @RequiresPermissions("role:insert")
    public String UpdateToAttendacne(Attendance attendance){
        attendanceService.updateAttendance(attendance);
        return "view/subpark/index";
    }
    //ɾ������
    @RequestMapping("deleteAttendance")
    @RequiresPermissions("role:insert")
    public String DeleteAttendance(HttpServletRequest request){
        attendanceService.delectOneAttendanceByid(Integer.parseInt(request.getParameter("attendanceId")));
        return "redirect:attendanceOperation.do";
    }



    //�Ŷӿ���
     @RequestMapping("groupAttendance")
    @RequiresPermissions("role:insert")
    public ModelAndView GroupAttendance(ModelAndView modelAndView,HttpServletRequest request){
         List<User> userList=userService.selectAllUserBygroupId(Integer.parseInt(request.getParameter("groupId")));
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("view/subpark/GroupAttendacne");
        return modelAndView;
    }
    //�û����ڲ鿴����
    @RequestMapping("selectUserAttendacne")
    @RequiresPermissions("role:insert")
    public ModelAndView SelectUserAttendacne(HttpServletRequest request,ModelAndView modelAndView){
        int userId=Integer.parseInt(request.getParameter("userId"));
        List<Attendance> attendanceList=attendanceService.selectAttendanceByUserId(userId);
        User user=userService.selectOneUserById(userId);
        modelAndView.addObject("user",user);
        modelAndView.addObject("attendanceList",attendanceList);
        modelAndView.setViewName("view/subpark/SubparkUserAttendance");
        return modelAndView;
    }

    //�û��鿴����ɾ��,�û��������²���
    @RequestMapping("deleteUserAttendance")
    @RequiresPermissions("role:insert")
    public String DeleteUserAttendance(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        workAttendanceService.deleteWorkAttendacneByUserId(userId);
        User user=userService.selectOneUserById(userId);
        user.setAttendanceScore(100);
        user.setWorkRatio("100%");
        userService.updateOneUser(user);
        return "view/subpark/index";
    }
}
