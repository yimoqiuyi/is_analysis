package com.yp.common.mapper;

import com.yp.common.pojo.WorkstylePicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��λ��ʽ����
public interface WorkstylePictureMapper {
    //��λ��ʽ�鿴
    public WorkstylePicture selectOneWorkstylePictureById(@Param("workStyleId") int workStyleId);

    //�鿴���й�λ��ʽ
    public List<WorkstylePicture> selectAllWorkstylePicture();

    //¼�빤λ��ʽ
    public boolean insertOneWorkstylePicture(WorkstylePicture workstylePicture);

    //�޸Ĺ�λ��ʽ
    public boolean updateOneWorkstylePicture(WorkstylePicture workstylePicture);

    //ɾ����λ��ʽ����id
    public int deleteOneWorkstylePictureById(@Param("workStyleId")int workStyleId);

    //�����û���λidѡ����Ϊ��ʽͼ
    public WorkstylePicture selectWorkstylePictureByworkId(@Param("workId") int workId );
}
