package com.yp.common.mapper;

import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Performance;
import com.yp.common.utils.DateUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PerformanceMapper {

    //ͨ��id��ѯ��Ч
    public Performance selectOnePerformance(@Param("performanceId") int performanceId);

    //ͨ���Ŷ�����鿴��Ч
    public List<Performance> selectPerformanceByGroupId(int groupId);  //��_parameter

    //ͨ����԰�������ѯ��Ч
    public List<Performance> selectPerformanceBySubparkId(int subParkId);

    //ͨ����԰������鿴��Ч
    public List<Performance> selectPerformanceByGeneralParkId(@Param("generalParkId") int generalParkId);

    //ͨ��ʱ���Լ��Ŷ�����鿴��Ч
    public List<Performance> selectPerformanceByGroupIdAndTime(Dateutile dateutile);

    //ģ����ѯ��Ч
    public List<Performance> selectPerformanceByCondition(@Param("map") Map<String, Object> map);

    //ͨ��ʱ���Լ���԰������鿴��Ч
    public List<Performance> selectPerformanceBySubparkIdAndTime(Dateutile dateutile);

    //����ʱ���Լ���԰���鿴��Ч
    public List<Performance> selectPerformanceByGeneralParkIdAndTime(Dateutile dateutile);

    //��ҳ��ѯ
    public List<Performance> selectPerformanceBySubparkIdAndLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //¼�뼨Ч
    public boolean insertPerformance(Performance performance);

    //�޸ļ�Ч
    public boolean updatePerformance(Performance performance);

    //ɾ����Ч
    public int deletePerformanceById(@Param("performanceId") int performanceId);
}
