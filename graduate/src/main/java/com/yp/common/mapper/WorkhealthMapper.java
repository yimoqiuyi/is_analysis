package com.yp.common.mapper;

import com.yp.common.pojo.Workhealth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��λ��������
public interface WorkhealthMapper {
    //��λ����¼��
    public boolean insertOneWorkhealth(Workhealth workhealth);

    //��λ�����޸�
    public boolean updateOneWorkhealth(Workhealth workhealth);

    //��λ����ɾ��
    public int deleteOneWorkhealthById(@Param("whId") int whId);

    //��λ-����ɾ��
    public int deleteWorkHealthByUserId(@Param("userId") int userId);

}
