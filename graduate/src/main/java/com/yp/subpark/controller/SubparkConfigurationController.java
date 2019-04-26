package com.yp.subpark.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("subpark")
public class SubparkConfigurationController {
    @Autowired
    private GeneralParkService generalParkService;
    @Autowired
    private SubParkService subParkService;    //��԰��
    @Autowired
    private GroupService groupService;    //�Ŷ�
    @Autowired
    private UserService userService;     //�û�
    @Autowired
    private BuildingService buildingService;  //��
    @Autowired
    private RoomService roomService; //����
    @Autowired
    private WorkPositionService workPositionService;  //��λ
    @Autowired
    private WorkstylePictureService workstylePictureService;  //��λ��ʽͼ

    @RequestMapping("insertConfiguration")
    @RequiresPermissions("role:insert")  //ֻ�����԰���Լ�root�ܲ���
    public ModelAndView insertConfiguration(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
        String userName = user.getUserName();
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        modelAndView.addObject("subPark", subPark);
        modelAndView.addObject("userName", userName);
        modelAndView.setViewName("view/subpark/SubparkConfiguration");
        return modelAndView;
    }

    //�޸ķ�԰����Ϣ
    @RequestMapping("updateSubPark")
    @RequiresPermissions("role:insert")
    public String insertsubPark(SubPark subPark) {
        subParkService.updateOneSubPark(subPark);
        return "redirect:insertConfiguration.do";
    }

    @RequestMapping("selectBuilding")
    @RequiresPermissions("role:insert")
    public ModelAndView insertBuilding(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
         List<Building> buildingList = buildingService.selectAllBuildingBysubParkId(subparkId);
        modelAndView.addObject("buildingList", buildingList);
        modelAndView.setViewName("view/subpark/BuildingConfiguration");
        return modelAndView;
    }

    @RequestMapping("AddRoom")
    @RequiresPermissions("role:insert")
    public ModelAndView AddRoom(ModelAndView modelAndView, HttpServletRequest request) {
        int buildId = Integer.parseInt(request.getParameter("buildId"));
        modelAndView.addObject("buildId", buildId);
        modelAndView.setViewName("view/subpark/AddRoom");
        return modelAndView;
    }

    @RequestMapping(value = "insertRoom", method = RequestMethod.POST)
    @RequiresPermissions("role:insert")
    public String InsertRoom(Room room, Integer buildId, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        FileUtils fileUtils = new FileUtils();
        String path = fileUtils.UploadRoomPicture(multipartFile);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int subparkId = user.getSubParkId();
         SubPark subPark = subParkService.selectOneSubParkById(subparkId); //��԰��
        int generalId = subPark.getGeneralParkId();
        room.setGeneralParkId(generalId);
        room.setSubParkId(subparkId);
        room.setBuildId(buildId);
        room.setRoomPicture(path); //���淿��ͼƬ·��
        roomService.insertOneRoom(room);   //��ӷ���
        int roomNum=roomService.selectRoomNumberByBuildId(buildId);// ��������
        Building building=buildingService.selectOneBuildingBybuildId(buildId);
        building.setRoomNumber(roomNum);
        buildingService.updateOneBuildingById(building);
        return "view/subpark/index";
    }
    //ɾ�������ķ���
    @RequestMapping("deleteRoom")
    @RequiresPermissions("role:insert")
    public void DeleteRoom(HttpServletRequest request) {
        int buildId = Integer.parseInt(request.getParameter("buildId"));
        roomService.deleteOneRoomBybuildId(buildId);   //ɾ�������ķ���
    }

}
