package co.project.prjdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.project.prjdb.common.DataSource;
import co.project.prjdb.notice.map.NoticeMapper;
import co.project.prjdb.notice.service.NoticeService;
import co.project.prjdb.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		map.noticeHitUpdate(vo.getNoticeId()); //조회수를 증가시킨다.
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public void noticeHitUpdate(int id) {
		 map.noticeHitUpdate(id);
	}

	@Override
	public List<NoticeVO> noticeSelectList(String key, String val) {
		return map.noticeSelectList(key, val);
	}

}
