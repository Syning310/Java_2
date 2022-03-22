package service;

import dao.DinTableDAO;
import domain.DiningTable;

import java.util.List;

public class DinTableService {

	DinTableDAO dtd = new DinTableDAO();


	// 所有所有餐桌信息
	public List<DiningTable> list() {
		return dtd.queryMulti("select id, state from diningTable",
				DiningTable.class);
	}


	// 根据id，查询对应的餐桌DiningTable 对象
	// 如果返回null，表示id编号对应的餐桌不存在
	public DiningTable getDiningTableById(int id) {
		return dtd.querySingle("select * from diningTable where id = ?",
				DiningTable.class, id);
	}


	// 如果餐桌可以预定，调用方法，对其状态进行更新(包括预定人的名字和电话)
	public boolean orderDiningTable(int id, String orderName, String orderTel) {
		int upInt =
				dtd.update("update diningTable set state = '已预定', orderName = ?, orderTel = ? where id = ?",
				orderName, orderTel, id);
		return upInt > 0;
	}


	// 需要提供更新餐桌状态的方法
	public boolean updateDiningTableState(int id, String state) {
		int up = dtd.update("update diningTable set state = ? where id = ?", state, id);
		return up > 0;
	}

	// 结账后更新空桌状态，并且姓名电话置为空
	public boolean updateDiningTableStateAndNameAndTel(int id) {
		int up = dtd.update("update diningTable set state = '空桌', orderName = null, orderTel = null where id = ?", id);
		return up > 0;
	}


}
