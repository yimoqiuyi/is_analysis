package com.yp.common.mapper;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Managementagreement;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

//�ʲ�����Э���Ĳ���
public interface ManagementagreementMapper {

    //����Э��id�鿴Э��
    public Managementagreement selectOneManagementagreementByid(@Param("managementId") int managementId);

    //�����Ŷ�id�鿴Э��
    public List<Managementagreement> selectAllManagementagreementBygroupId(int groupId);

    //�鿴���з�԰��Э��
    public List<Managementagreement> selectAllManagementagreementBysubParkId(int subParkId);

    //�鿴������԰����Э��
    public List<Managementagreement> selectAllManagementagreementBygeneralParkId(@Param("generalParkId") int generalParkId);

    //����ʱ�����Ŷ�id�鿴
    public List<Managementagreement> selectAllManagementagreementByTime(Dateutile dateutile);

    //���ݷ�԰����ʱ����в鿴
    public List<Managementagreement> selectAllManagementagreementBytimeAndsubParkId(Dateutile dateutile);

    //������԰����ʱ��鿴
    public List<Managementagreement> selectAllManagementagreementByTimeAndgeneralParkId(Dateutile dateutile);

    //��ҳ�鿴
    public List<Managementagreement> selectManagementagreementByMap(@Param("map") Map<String, Object> map);

    //���������鿴
    public List<Managementagreement> selectManagementagreementByCondition(@Param("map") Map<String, Object> map);

    //�鿴���е�Э��
    public List<Managementagreement> selectAllManagementagreement();

    //¼��Э��
    public boolean insertOneManagementagreement(Managementagreement managementagreement);

    //�޸�Э��
    public boolean updateOneManagementagreement(Managementagreement managementagreement);

    //ɾ��Э��
    public int delectOneManagementagreement(@Param("managementId") int managementId);
}
