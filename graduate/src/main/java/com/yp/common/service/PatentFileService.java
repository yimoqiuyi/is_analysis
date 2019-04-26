package com.yp.common.service;

import com.yp.common.pojo.PatentFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatentFileService {
    //�鿴ר���ļ�����·��
    public PatentFile selectOnePatentFileById(@Param("id") int id);

    //¼��ר���ļ�·��
    public boolean insertPatentFile(PatentFile patentFile);

    //���ר���ļ�·������ר�����patent_id
    public List<PatentFile> seletcAllPatentFileBypatent_id(@Param("patentId") int patentId);

    public int deletePatentFileByPatentId(@Param("patentId") int patentId);
}
