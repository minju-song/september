package co.project.prjdb.book.service;

import java.util.List;

public interface BookService {
	int bookInsert(BookVO vo);
	List<BookVO> bookList();
	int bookRemove(String bookId);
}
