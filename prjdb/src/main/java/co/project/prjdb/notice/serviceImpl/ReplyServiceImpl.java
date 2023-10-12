package co.project.prjdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.project.prjdb.common.DataSource;
import co.project.prjdb.notice.map.ReplyMapper;
import co.project.prjdb.notice.service.EventVO;
import co.project.prjdb.notice.service.ReplyService;
import co.project.prjdb.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addReply(ReplyVO vo) {
		return map.insertReply(vo) == 1;
	}

	@Override
	public boolean editReply(ReplyVO vo) {
		return map.updateReply(vo) == 1;
	}

	@Override
	public boolean delReply(int replyId) {
		return map.deleteReply(replyId) == 1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		return map.selectReply(replyId);
	}

	@Override
	public List<ReplyVO> listReply(int noticeId) {
		return map.replySelectList(noticeId);
	}

	@Override
	public List<EventVO> listEvent() {
		return map.listEvent();
	}

	@Override
	public int insertEvent(EventVO vo) {
		return map.insertEvent(vo);
	}

}
