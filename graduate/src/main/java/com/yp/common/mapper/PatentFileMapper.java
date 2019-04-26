package com.yp.common.mapper;

import com.yp.common.pojo.PatentFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//ר��·�����ñ�
public interface PatentFileMapper {

    //�鿴ר���ļ�����·��
    public PatentFile selectOnePatentFileById(@Param("id") int id);

    //¼��ר���ļ�·��
    public boolean insertPatentFile(PatentFile patentFile);

    //���ר���ļ�·������ר�����patent_id
    public List<PatentFile> seletcAllPatentFileBypatent_id(int patentId);

    //����ר��idɾ��ר���ļ�·��
    public int deletePatentFileByPatentId(@Param("patentId") int patentId);
}
