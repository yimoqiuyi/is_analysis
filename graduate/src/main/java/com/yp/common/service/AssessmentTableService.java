package com.yp.common.service;

import com.yp.common.pojo.AssessmentTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssessmentTableService {
    //����id�鿴����ָ��
    public AssessmentTable selectOneAssessmentTableByassessmentId(@Param("assessmentId") int assessmentId);

    //�����Ŷ�idѡ��鿴�Ŷ�����ָ��
    public AssessmentTable selectOneAssessmentTableByid(@Param("groupId") int groupId);

    //�鿴��������ָ��
    public List selectAllAssessmentTable();

    //¼���Ŷ�����
    public boolean insertOneAssessmentTable(AssessmentTable assessmentTable);

    //�޸��Ŷ���������Ŷ�id
    public boolean updateOneAssessmentTableByid(AssessmentTable assessmentTable);

    //ɾ���Ŷ�����
    public int deleteOneAssessmentTableById(@Param("assessmentId")int assessmentId);

    //�����Ŷ�idɾ���Ŷ�����
    public int delectOneAssessmentTableByid(@Param("groupId")int groupId);

    //ɾ�������Ŷ�����
    public int delectAllAssessmentTable();
}
