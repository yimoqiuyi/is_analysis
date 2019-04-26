package com.yp.role.controller;

import com.yp.common.pojo.*;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
 //�Ŷӳɹ�����
@Controller
@RequestMapping("group")
public class GroupAchievementsController {
    @Autowired
    private AchievementsNumberService achievementsNumberService; //�Ŷӳɹ���
    @Autowired
    private AssessmentTableService assessmentTableService;  //�Ŷ������
    @Autowired
    private PatentFileService patentFileService; //ר������·��
    @Autowired
    private PatentService patentService; //ר�����
    @Autowired
    private SoftwareService softwareService; //�������
    @Autowired
    private PaperService paperService; //���Ĵ��
    @Autowired
    private CompetitionService competitionService; //�������
    @Autowired
    private AchievementsService achievementsService;
    @Autowired
    private SubParkService subParkService;
    @Autowired
    private GeneralParkService generalParkService;
    @Autowired
    private GroupService groupService;

    @RequestMapping("selectAchievements")
    @RequiresRoles(value = "group")
    public ModelAndView selectGroupAchievements(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        AchievementsNumber achievementsNumber = achievementsNumberService.selectOneAchievementsNumber(groupId); //�Ŷӳɹ���
        AssessmentTable assessmentTable = assessmentTableService.selectOneAssessmentTableByid(groupId);//�Ŷӳɹ�������
        modelAndView.addObject("assessmentTable", assessmentTable);
        modelAndView.addObject("achievementsNumber", achievementsNumber);
        modelAndView.setViewName("view/group/AchievemnetNumber");
        return modelAndView;
    }

    @RequestMapping(value = "insertGroupachievement")
    @RequiresRoles(value = "group")
    public String insertGroupAchievements(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        int groupId = user.getGroupId();
        int patentNum = patentService.selectPatentsByGroupId(groupId);
        int paperNum = paperService.selectPapersbyGroupId(groupId);
        int softwareNum = softwareService.selectSoftWaresByGroupId(groupId);
        int comprtitionNum = competitionService.selctCompetitionsBygroupId(groupId);
        AchievementsNumber achievementsNumber = new AchievementsNumber();
        achievementsNumber.setCompetitionNum(comprtitionNum);
        achievementsNumber.setGroupId(groupId);
        achievementsNumber.setPaperNum(paperNum);
        achievementsNumber.setPatentNum(patentNum);
        achievementsNumber.setSoftwareNum(softwareNum); //����Ŷ�����ý�������
        achievementsNumberService.insertAchievementsNumber(achievementsNumber);
        return "redirect:selectAchievements.do";
    }

    @RequestMapping("Achievementoperation")
    public String operation() {
        return "view/common/index";
    }

    @RequestMapping("insertAchievement")
    @RequiresRoles(value = "group")
    public ModelAndView insertAchievement(ModelAndView modelAndView, HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Achievements> achievementsList = achievementsService.getAllachievements();
        if (id == 1) {
            modelAndView.setViewName("view/common/patentConfiguration");
        } else if (id == 2) {
            modelAndView.setViewName("view/common/softwareConfiguration");
        } else if (id == 3) {
            modelAndView.setViewName("view/common/competitionConfiguration");
        } else if (id == 4) {
            modelAndView.setViewName("view/common/paperConfiguration");
        } else if(id==5){
            modelAndView.setViewName("view/group/index");
        }
        modelAndView.addObject("achievementsList", achievementsList);

        return modelAndView;
    }

    @RequestMapping(value = "insertPatent", method = RequestMethod.POST)
    @RequiresRoles(value = "group")
    public String insertPatentFile(ModelAndView modelAndView, Patent patent, @RequestParam(value = "file", required = false) MultipartFile[] file) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String achievementsName = patent.getPatentCategory(); //��ȡ�ɹ����ͣ�����
        Achievements achievements = achievementsService.selectAchievementsByName(achievementsName);//�鿴�ɹ�����
        int groupId = user.getGroupId(); //�Ŷ����
        Group group = groupService.selectOneGroupById(groupId);
        FileUtils fileUtils = new FileUtils();
        List filepathlist = fileUtils.UploadFiles(file);
        int subparkId = group.getSubParkId(); //��԰�����
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //��԰�����
        patent.setPatentState(0);//����Ϊ0��ʾδ���
        patent.setAchievementsId(achievements.getAchievementsId());//���óɹ����
        patent.setGroupId(groupId);
        patent.setSubParkId(subparkId);
        patent.setGeneralParkId(generalId);
        patent.setPatentAuditTime("0"); //δ���,�������Ϊ0
        patentService.insertOnePatent(patent);
        PatentFile patentFile = new PatentFile();
        Iterator<String> iterator = filepathlist.iterator();//·������
        while (iterator.hasNext()) {
            String path = iterator.next();  //iteratorȡ���ַ���
            patentFile.setPatentId(patent.getPatentId());
            patentFile.setPfName(patent.getPatentName());
            patentFile.setPfPath(path);
            patentFileService.insertPatentFile(patentFile);//���ר��·����
        }
        return "redirect:Achievementoperation.do";
    }

    @RequestMapping(value = "insertSoftware", method = RequestMethod.POST)
    @RequiresRoles(value = "group")
    public String insertSoftware(Software software, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String softGradeName = software.getSoftGrade(); //��ȡ�ɹ����ͣ�����
        Achievements achievements = achievementsService.selectAchievementsByName(softGradeName);//�鿴�ɹ�����
        int groupId = user.getGroupId(); //�Ŷ����
        Group group = groupService.selectOneGroupById(groupId);
        int subparkId = group.getSubParkId(); //��԰�����
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //��԰�����
        FileUtils fileUtils = new FileUtils();
        String filePath = fileUtils.UploadFile(multipartFile);//���ص�ַ
        software.setSoftwareState(0);//����Ϊ0��ʾδ���
        software.setSoftwareAuditTime("0"); //��ʾδ���
        software.setAchievementsId(achievements.getAchievementsId()); //���óɹ����
        software.setGroupId(groupId); //�Ŷ����
        software.setSubParkId(subparkId); //��԰�����
        software.setGeneralParkId(generalId); //��԰�����
        software.setSoftDocument(filePath);//����·��
        softwareService.insertOneSoftware(software);
        return "redirect:Achievementoperation.do"; //�����ļ���ҳ
    }

    @RequestMapping("insertPaper")
    @RequiresRoles(value = "group")
    public String insertPaper(Paper paper,@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String softGradeName = paper.getGrade(); //��ȡ�ɹ����ͣ�����
        Achievements achievements = achievementsService.selectAchievementsByName(softGradeName);//�鿴�ɹ�����
        int groupId = user.getGroupId(); //�Ŷ����
        Group group = groupService.selectOneGroupById(groupId);
        int subparkId = group.getSubParkId(); //��԰�����
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //��԰�����
        FileUtils fileUtils = new FileUtils();
        String  paperPath = fileUtils.UploadFile(multipartFile);
        paper.setPaperState(0);//����Ϊ0��ʾδ���
        paper.setPaperAuditTime("0");
        paper.setGroupId(groupId);
        paper.setSubParkId(subparkId);
        paper.setGeneralParkId(generalId);
        paper.setPaperPath(paperPath);
        paper.setAchievementsId(achievements.getAchievementsId());
        paperService.insertOnePaper(paper);
        return "redirect:Achievementoperation.do";
    }

    @RequestMapping("insertCompetition")
    @RequiresRoles(value = "group")
    public String insertCompetition(Competition competition, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        String softGradeName = competition.getAwardLevel(); //��ȡ�ɹ����ͣ�����
        Achievements achievements = achievementsService.selectAchievementsByName(softGradeName);//�鿴�ɹ�����
        int groupId = user.getGroupId(); //�Ŷ����
        Group group = groupService.selectOneGroupById(groupId);
        int subparkId = group.getSubParkId(); //��԰�����
        SubPark subPark = subParkService.selectOneSubParkById(subparkId);
        int generalId = subPark.getGeneralParkId(); //��԰�����
        FileUtils fileUtils = new FileUtils();
        String competitionPath = fileUtils.UploadFile(multipartFile);
        competition.setAchievementsId(achievements.getAchievementsId());
        competition.setCompetitionState(0); //����Ϊ0��ʾδ���
        competition.setCompetitionAuditTime("0");
        competition.setCompetitionPath(competitionPath);
        competition.setGroupId(groupId);
        competition.setSubParkId(subparkId);
        competition.setGeneralParkId(generalId);
        competitionService.insertCompetition(competition);
        return "redirect:Achievementoperation.do";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(ModelAndView modelAndView, @RequestParam(value = "file", required = false) MultipartFile[] multipartFiles) throws IOException {
        FileUtils fileUtils = new FileUtils();
        List filepathlist = fileUtils.UploadFiles(multipartFiles);
        modelAndView.addObject("filepathlist", filepathlist);
        modelAndView.setViewName("view/common/Patentupload");
        return modelAndView;
    }
}
