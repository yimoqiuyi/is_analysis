package com.yp.common.service;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Performance;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.Map;

public interface PerformanceService {
    //ͨ��id��ѯ��Ч
    public Performance selectOnePerformance(@Param("performanceId") int performanceId);

    //ͨ���Ŷ�����鿴��Ч
    public List<Performance> selectPerformanceByGroupId(int groupId);  //��_parameter

    //ͨ����԰�������ѯ��Ч
    public List<Performance> selectPerformanceBySubparkId(@Param("subParkId") int subParkId);

    //ͨ����԰������鿴��Ч
    public List<Performance> selectPerformanceByGeneralParkId(@Param("generalParkId") int generalParkId);

    //ͨ��ʱ���Լ��Ŷ�����鿴��Ч
    public List<Performance> selectPerformanceByGroupIdAndTime(Dateutile dateutile);

    //ͨ��ʱ���Լ���԰������鿴��Ч
    public List<Performance> selectPerformanceBySubparkIdAndTime(Dateutile dateutile);

    public List<Performance> selectPerformanceByCondition(@Param("map") Map<String, Object> map);

    //����ʱ���Լ���԰���鿴��Ч
    public List<Performance> selectPerformanceByGeneralParkIdAndTime(Dateutile dateutile);

    //����excel
    public XSSFWorkbook downLoadExcel(int groupId);

    //��ҳ��ѯ
    public List<Performance> selectPerformanceBySubparkIdAndLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //¼�뼨Ч
    public boolean insertPerformance(Performance performance);

    //�޸ļ�Ч
    public boolean updatePerformance(Performance performance);

    //ɾ����Ч
    public int deletePerformanceById(@Param("performanceId") int performanceId);
}
