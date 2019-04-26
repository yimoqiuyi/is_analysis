package com.yp.general.controller;

import com.yp.common.pojo.Competition;
import com.yp.common.pojo.Paper;
import com.yp.common.pojo.PatentFile;
import com.yp.common.pojo.Software;
import com.yp.common.service.*;
import com.yp.common.utils.FileUtils;
 import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("general")
public class GeneraldownLoadCerficateController {
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
    private PatentFileService patentFileService;

    //ר������
    @RequestMapping("downLoadPatent")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadPatent(HttpServletResponse response, HttpServletRequest request) {
        List<PatentFile> patentFileList = patentFileService.seletcAllPatentFileBypatent_id(Integer.parseInt(request.getParameter("patentId")));
        FileUtils fileUtils=new FileUtils();
        for(PatentFile patentFile:patentFileList){
            String path=patentFile.getPfPath();
            String name=patentFile.getPfName();
            String s=fileUtils.downFile(name,path,response);
            if(s.equals("success")){
                System.out.println("���سɹ�");
            }else{
                System.out.println("����ʧ��");
            }
        }
    }
    //��������
    @RequestMapping("downLoadPaper")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadPaper(HttpServletRequest request, HttpServletResponse response){
        Paper paper=paperService.selectOnePaper(Integer.parseInt(request.getParameter("paperId")));
        String path=paper.getPaperPath();
        String name=paper.getPaperName();
        FileUtils fileUtils=new FileUtils();
        String s=fileUtils.downFile(name,path,response);
        if(s.equals("success")){
            System.out.println("���سɹ�");
        }else{
            System.out.println("����ʧ��");
        }
    }
    //��������
    @RequestMapping("downLoadSoftware")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadSoftware(HttpServletRequest request, HttpServletResponse response){
        Software software=softwareService.selectOneSoftwareById(Integer.parseInt(request.getParameter("softId")));
        String name=software.getSoftName();
        String path=software.getSoftDocument();
        FileUtils fileUtils=new FileUtils();
        String s=fileUtils.downFile(name,path,response);
        if(s.equals("success")){
            System.out.println("���سɹ�");
        }else{
            System.out.println("����ʧ��");
        }
    }
    //��������
    @RequestMapping("downLoadCompetion")
    @RequiresRoles(value = {"general", "admin"}, logical = Logical.OR)
    public void DownLoadCompetion(HttpServletRequest request, HttpServletResponse response) {
        Competition competition = competitionService.selectOneCompetitionBycompetitionId(Integer.parseInt(request.getParameter("competitionId")));
        String path = competition.getCompetitionPath();
        String fileName = competition.getCompetitionName();
        FileUtils fileUtils = new FileUtils();
        String s = fileUtils.downFile(fileName, path, response);
        if (s.equals("success")) {
            System.out.println("�ɹ�����");
        } else {
            System.out.println("ʧ������");
        }
    }
}
