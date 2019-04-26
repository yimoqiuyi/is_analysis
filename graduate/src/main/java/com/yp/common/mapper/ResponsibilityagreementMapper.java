package com.yp.common.mapper;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Responsibilityagreement;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

//����Э���Ĳ���
public interface ResponsibilityagreementMapper {
    //ͬ��������ȡ����Э���
    public Responsibilityagreement selectOneResponsibilityagreementById(@Param("responsibleId") int responsibleId);

    //ͨ���Ŷ������ȡ����Э��
    public List<Responsibilityagreement> selectAllResponsibilityagreementBygroupId(int groupId);

    //ͨ����԰ȫ�����ȡ����Э��
    public List<Responsibilityagreement> selectAllResponsibilityagreementBysubParkId(int subParkId);

    //ͨ����԰�������ȡ����Э��
    public List<Responsibilityagreement> selectAllResponsibilityagreementBygeneralParkId(@Param("generalParkId") int generalParkId);

    //ͨ���Ŷ��Լ�ʱ���ȡ����Э��
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndgroupId(Dateutile dateutile);

    //ͨ��ʱ�����԰����ȡ����Э��
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndsubParkId(Dateutile dateutile);

    //�����齣����԰����ȡ����Э��
    public List<Responsibilityagreement> selectAllResponsibilityagreementByTimeAndgeneralParkId(Dateutile dateutile);

    //��ҳ��ѯ
    public List<Responsibilityagreement> selectResponsibilityagreementBymap(@Param("map") Map<String, Object> map);

    //����������ҳ��ѯ
    public List<Responsibilityagreement> selectResponsibilityagreementByCondition(@Param("map") Map<String, Object> map);

    //¼������Э���
    public boolean insertOneResponsibilityagreement(Responsibilityagreement responsibilityagreement);

    //�޸�����Э��
    public boolean updateOneResponsibilityagreement(Responsibilityagreement responsibilityagreement);

    //ɾ������Э��
    public int delectOneResponsibilityagreementById(@Param("responsibleId") int responsibleId);


}
