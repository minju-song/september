package co.project.prjdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.project.prjdb.common.DataSource;
import co.project.prjdb.notice.map.ItemMapper;
import co.project.prjdb.notice.service.ItemService;
import co.project.prjdb.notice.service.ItemVO;

public class ItemServiceImpl implements ItemService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ItemMapper map = sqlSession.getMapper(ItemMapper.class);

	@Override
	public List<ItemVO> itemList() {
		return map.itemList();
	}

	@Override
	public ItemVO itemSelect(String itemId) {
		return map.itemSelect(itemId);
	}

	@Override
	public List<ItemVO> itemListFour() {
		return map.itemListFour();
	}

}
