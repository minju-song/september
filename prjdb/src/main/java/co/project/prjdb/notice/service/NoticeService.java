package co.project.prjdb.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);
	
	List<NoticeVO> noticeSelectList(String key, String val); //다형성에서 메소드 오버라이드(검색기능), 타입, 매개변수가 달라질때 사용
}
