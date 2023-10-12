package co.project.prjdb.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.project.prjdb.notice.map.ReplyMapper;
import co.project.prjdb.notice.service.ReplyVO;

public class MainExe {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
		
		ReplyVO vo = new ReplyVO();
		vo.setNoticeId(1);
		vo.setReply("댓글 테스트(수정)");
		vo.setReplyer("newbie");
		vo.setReplyId(9);
		map.updateReply(vo);
		
		System.out.println(map.selectReply(8));
		
//		map.deleteReply(vo);
		
//		List<ReplyVO>list = map.replySelectList(1);
//		for(ReplyVO r : list) {
//			System.out.println(r.toString());
//		}
	}
}
