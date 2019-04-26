package com.yp.common.mapper;

import com.yp.common.pojo.Sanitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//�����涨��Ĳ���
public interface SanitationMapper {

    //����idѡ����������
    public Sanitation selectOneSanitationById(@Param(value="sId") int sId);

    //�����û�idѡ�񴥷�������
    public List<Sanitation> selectSanitationByUserId(@Param(value="userId")int userId);

    //ѡ��������������
    public List<Sanitation> selectAllSanitation();

    //¼����������
    public boolean insertOneSanitation(Sanitation sanitation);

    //�޸���������
    public boolean updateOneSanitation(Sanitation sanitation);

    //ɾ����������
    public int deleteOneSanitationById(@Param(value="sId")int sId);
}
