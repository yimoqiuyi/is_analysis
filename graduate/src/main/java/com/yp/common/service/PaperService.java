package com.yp.common.service;

import com.yp.common.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PaperService {

    //ѡ�����ĸ���paperId
    public Paper selectOnePaper(@Param("paperId") int paperId);

    //�����Ŷ�����鿴��������
    public int selectPapersbyGroupId(@Param("groupId") int groupId);

    //�����Ŷ�����鿴����
    public List<Paper> selectAllPaperBygroupId(@Param("groupId") int groupId);

    //���ݷ�Ժ������鿴����
    public List<Paper> selectAllPaperBysubParkId(int subParkId);

    //������԰������鿴����
    public List<Paper> selectAllPaperBygeneralParkId(@Param("generalParkId") int generalParkId);

    public List<Paper> selectPaperByLimit(@Param("map") Map<String, Object> map);

    //���Ĳ鿴����groupID��״̬
    public List<Paper> selectPaperByGroupIdAndState(@Param("groupId") int groupId, @Param("paperState") int paperState);

    public List<Paper> selectPaperByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //¼������
    public boolean insertOnePaper(Paper paper);

    //�޸�����
    public boolean updatePaper(Paper paper);

    //ɾ�����ĸ�������id
    public int delectOnePaper(@Param("paperId") int paperId);

    //ɾ����������
    public int delectAllaper();

    //ɾ����������ͨ��achievementsId
    public int deletePaperByAchievementsId(@Param("achievementsId") int achievementsId);
}
