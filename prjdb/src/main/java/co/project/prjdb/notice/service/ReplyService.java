package co.project.prjdb.notice.service;

import java.util.List;

public interface ReplyService {
	public boolean addReply(ReplyVO vo);
	public boolean editReply(ReplyVO vo);
	public boolean delReply(int replyId);
	public ReplyVO getReply(int replyId);
	public List<ReplyVO> listReply(int noticeId);
	
	public List<EventVO> listEvent();
	public int insertEvent(EventVO vo);
}
