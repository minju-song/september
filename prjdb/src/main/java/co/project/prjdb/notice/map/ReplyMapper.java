package co.project.prjdb.notice.map;

import java.util.List;

import co.project.prjdb.notice.service.EventVO;
import co.project.prjdb.notice.service.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replySelectList(int noticeId);
	ReplyVO selectReply(int ReplyId);
	int insertReply(ReplyVO vo);
	int deleteReply(int ReplyId);
	int updateReply(ReplyVO vo);
	public List<EventVO> listEvent();
	public int insertEvent(EventVO vo);
}
