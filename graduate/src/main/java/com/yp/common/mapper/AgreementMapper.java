package com.yp.common.mapper;

import com.yp.common.pojo.Agreement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��ͬ�����ò���
public interface AgreementMapper {

    //ѡ�񵥸���ͬ����
    public Agreement selectOneAgreementById(@Param("agreementId") int agreementId);

    //ѡ�����к�ͬ������
    public List<Agreement> selectAllAgreement();

    //¼���ͬ����
    public boolean insertAgreement(Agreement agreement);

    //���ݺ�ͬ����id�޸ĺ�ͬ����
    public boolean updateAgreementByid(@Param("agreement") Agreement agreement, @Param("agreementId") int agreementId);

    //���ݺ�ͬ����idɾ����ͬ����
    public int delectAgreementByid(@Param("agreementId")int agreementId);

    //ɾ�����к�ͬ����
    public int delectAllAgreement();

    //����Э�� managementId�鿴��ͬ������
    public Agreement selectAgreementBymanagementId(@Param("managementId")int managementId);

    //����responsibleId�鿴��ͬ����
    public Agreement selectAgreementByresponsibleId(@Param("responsibleId")int responsibleId);
}
