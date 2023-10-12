package co.project.prjdb.book.map;

import java.util.List;

import co.project.prjdb.book.service.BookVO;

public interface BookMapper {
	int bookInsert(BookVO vo);
	List<BookVO> bookList();
	int bookRemove(String bookId);
}
