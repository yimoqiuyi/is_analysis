package com.yp.common.service;

import com.yp.common.pojo.AssessmentReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssessmentReportService {
    //��������ѡ�񱨸�
    public AssessmentReport selectAssessmentReportById(@Param("reportId") int reportId);

    //�����Ŷ�Idѡ���Ŷӿ��˱���
    public AssessmentReport selectOneAssessmentReportByid(@Param("groupId") int groupId);

    //ѡ�������Ŷӱ���
    public List selectAllAssessmentReport();

    //¼���Ŷӱ���
    public boolean insertAssessmentReport(AssessmentReport assessmentReport);

    //�����Ŷ�id�����Ŷӱ�����޸�
    public boolean updateAssessmentReport(AssessmentReport assessmentReport);

    //�����Ŷ�idɾ���Ŷӱ���
    public int delectAssessmentReportByid(@Param("reportId") int reportId);

    //ɾ�����еı���
    public int delectAllAssessmentReport();
}
