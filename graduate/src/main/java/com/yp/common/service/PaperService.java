package com.yp.common.service;

import com.yp.common.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PaperService {

    //选择论文根据paperId
    public Paper selectOnePaper(@Param("paperId") int paperId);

    //根据团队外键查看论文数量
    public int selectPapersbyGroupId(@Param("groupId") int groupId);

    //根据团队外键查看论文
    public List<Paper> selectAllPaperBygroupId(@Param("groupId") int groupId);

    //根据分院区外键查看论文
    public List<Paper> selectAllPaperBysubParkId(int subParkId);

    //根据总园区外键查看论文
    public List<Paper> selectAllPaperBygeneralParkId(@Param("generalParkId") int generalParkId);

    public List<Paper> selectPaperByLimit(@Param("map") Map<String, Object> map);

    //论文查看根据groupID与状态
    public List<Paper> selectPaperByGroupIdAndState(@Param("groupId") int groupId, @Param("paperState") int paperState);

    public List<Paper> selectPaperByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //录入论文
    public boolean insertOnePaper(Paper paper);

    //修改论文
    public boolean updatePaper(Paper paper);

    //删除论文根据论文id
    public int delectOnePaper(@Param("paperId") int paperId);

    //删除所有论文
    public int delectAllaper();

    //删除所有论文通过achievementsId
    public int deletePaperByAchievementsId(@Param("achievementsId") int achievementsId);
}
