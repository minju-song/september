package co.project.prjdb.book.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.project.prjdb.book.map.BookMapper;
import co.project.prjdb.book.service.BookService;
import co.project.prjdb.book.service.BookVO;
import co.project.prjdb.common.DataSource;

public class BookServiceImpl implements BookService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);

	@Override
	public int bookInsert(BookVO vo) {
		return map.bookInsert(vo);
	}

	@Override
	public List<BookVO> bookList() {
		return map.bookList();
	}

	@Override
	public int bookRemove(String bookId) {
		return map.bookRemove(bookId);
	}

}
