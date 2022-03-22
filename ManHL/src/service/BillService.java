package service;


import dao.BillDAO;
import domain.Bill;

import java.util.List;
import java.util.UUID;

// 处理和账单相关的业务逻辑
public class BillService {
	private BillDAO bdao = new BillDAO();
	// 与其他Service配合
	private MenuService menuService = new MenuService();
	private DinTableService dtSetvice = new DinTableService();

	// 编写点餐的方法
	// 1、生成账单
	// 2、更新对应餐桌的状态
	public boolean orderMenu(int menuId, int nums, int tableNo) {
		// 生成一个账单号，UUID
		String billId = UUID.randomUUID().toString();

		// 将账单生成到 bill 表
		// 账单的金额可以直接计算
		int update = bdao.update("insert into bill values(null, ?, ?, ?, ?, ?, now(), '未结账')",
				billId, menuId, nums,
				menuService.getMenuById(menuId).getPrice() * nums, tableNo);

		if (update <= 0) {
			return false;
		}

		// 更新对应餐桌的状态showMenu
		return dtSetvice.updateDiningTableState(tableNo, "就餐中");

	}


	// 返回所有的账单
	public List<Bill> list() {
		return bdao.queryMulti("select * from bill", Bill.class);
	}

	// 按照餐桌编号返回账单对象
	public Bill getBillByTableNo(int tableNo) {
		return bdao.querySingle("select * from bill where tableNo = ? and state = '未结账'",
				Bill.class, tableNo);
	}

	// 结账
	public boolean overBillStateMethod(String method, int tableNo) {
		int update = bdao.update("update bill set state = ? where tableNo = ? and state = '未结账'",
				method, tableNo);

		// 结账后更新餐桌状态
		dtSetvice.updateDiningTableStateAndNameAndTel(tableNo);

		return update > 0;
	}



}
