package co.project.prjdb.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.project.prjdb.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	void noticeHitUpdate(int id);
	
	List<NoticeVO> noticeSelectList(@Param("key") String key, @Param("val") String val);//Mapper에서는 매개변수가 2개 이상이면 반드시 @Param을 써야함(request.getParameter에서의 값을 key와 val에 넣어줌)
	//mapper.xml에서는 메소드 이름이 유일해야 함 아니면 오류
}
