package com.yp.common.mapper;

import com.yp.common.pojo.Admissioncontract;
import com.yp.common.pojo.Dateutile;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdmissioncontractMapper {

    //�鿴������ͬ��
    public Admissioncontract selectOneAdmissioncontract(@Param("admissionId") int admissionId);

    //��԰��ͬ��Ĳ���
    public List<Admissioncontract> selectOneAllAdmissioncontract(int groupId);//�����Ŷ�id�鿴�Ŷ����к�ͬ

    //�鿴�����ŶӺ�ͬ��
    public List<Admissioncontract> selectAllAdmissioncontract();

    // ���ݷ�԰��������в鿴��ͬ
    public List<Admissioncontract> selectAllAdmissioncontractBysubParkId(int subParkId);

    //����������ҳ��ѯ��ͬ
    public List<Admissioncontract> selectAdmissioncontractByLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //������԰������鿴��ͬ
    public List<Admissioncontract> selectAllAdmissioncontractBygeneralParkId(@Param("generalParkId") int generalParkId);

    //@Param("groupId") int groupId,@Param("signDate") String signDate, @Param("expirationDate"
    //����ʱ���Լ��Ŷ�idѡ���ŶӺ�ͬ
    public List<Admissioncontract> selectAllAdmissioncontractBytimeandgroupID(Dateutile dateutile);

    //���ݷ�԰����ʱ��鿴��ͬ
    public List<Admissioncontract> selectAllAdmissioncontractByTimeAndsubParkId(Dateutile dateutile);

    //������԰����ʱ��鿴��ͬ
    public List<Admissioncontract> selectAllAdmissioncontractByTimeAndgeneralParkId(Dateutile dateutile);

    //ͨ����ͬǩ�������ʱ����в鿴��ͬ
    public Admissioncontract selectAllAdmissioncontractBytime(@Param("signDate") String signDate, @Param("expirationDate") String expirationDate);

    //����������ҳ��ѯ��ͬ
    public List<Admissioncontract> selectAdmissioncontractByCondition(@Param("map") Map<String, Object> map);

    //¼���ŶӺ�ͬ
    public boolean insertOneAdmissioncontract(Admissioncontract admissioncontract);

    //����idɾ����ͬ
    public int delectOneAdmissioncontractByid(@Param("admissionId") int admissionId);

    //ɾ�������ŶӺ�ͬ
    public int delectAllAdmissioncontract();

    //�޸���԰��ͬ
    public boolean updateOneAdmissioncontractByid(Admissioncontract admissioncontract);

}
