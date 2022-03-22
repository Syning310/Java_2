package view;

import domain.Bill;
import domain.DiningTable;
import domain.Employee;
import domain.Menu;
import service.BillService;
import service.DinTableService;
import service.EmpService;
import service.MenuService;
import utils.Utility;

import javax.rmi.CORBA.Util;
import java.util.List;


public class MHLView {

	// 控制循环
	private boolean loop = true;
	// 接收键盘收入
	private String key;

	// Service
	EmpService empService = new EmpService();
	DinTableService dinService = new DinTableService();
	MenuService menuService = new MenuService();
	BillService billService = new BillService();

	public static void main(String[] args) {

		new MHLView().menuOne();
	}

	public void menuOne() {
		while (loop) {
			System.out.println("===============满汉楼===============");
			System.out.println("\t\t 1 登 录");
			System.out.println("\t\t 0 退 出");
			System.out.print("请输入选择>: ");
			key = Utility.readString(1);

			switch (key) {
				case "1":
					// 输入账号密码
					System.out.print("请输入账号:> ");
					String empId = Utility.readString(20);
					System.out.print("请输入密码:> ");
					String pwd = Utility.readString(20);

					// 传入到判断账号密码的方法
					if (judementEmpIdAndPwd(empId, pwd)) {
						menuTwo();
					} else {
						System.out.println("账号或密码错误，请重新输入");
					}
					break;
				case "0":
					System.out.println("退出满汉楼系统");
					loop = false;
					break;
				default :
					System.out.println("输入有误！");
					break;
			}
		}
	}

	// 验证用户密码
	private boolean judementEmpIdAndPwd(String empId, String pwd) {
		Employee e = empService.getEmployeeByIdAndPwd(empId, pwd);
		if (e != null) {
			System.out.println("\t 登录成功 -->  " + e.getName());
			return true;
		}
		return false;
	}



	void menuTwo() {
		while (loop) {
			System.out.println("\n==============满汉楼二级菜单============");
			System.out.println("\t\t 1 显示餐桌状态");
			System.out.println("\t\t 2 预定餐桌");
			System.out.println("\t\t 3 显示所有菜品");
			System.out.println("\t\t 4 点餐服务");
			System.out.println("\t\t 5 查看账单");
			System.out.println("\t\t 6 结账");
			System.out.println("\t\t 0 退出系统");
			System.out.print("请输入选择:> ");
			key = Utility.readString(1);

			switch (key) {
				case "1":
					showDinTableState();
					break;
				case "2":
					scheduledTable();
					break;
				case "3":
					showMenu();
					break;
				case "4":
					orderMenu();
					break;
				case "5":
					showBillList();
					break;
				case "6":
					overBill();
					break;
				case "0":
					System.out.println("退出满汉楼系统");
					loop = false;
					break;
				default :
					System.out.println("输入有误！");
					break;
			}
		}
	}

	private void showDinTableState() {
		List<DiningTable> lst = dinService.list();
		System.out.println("\n餐桌编号\t\t餐桌状态");
		for (DiningTable d : lst) {
			System.out.println(d);
		}
		System.out.println("==========显示完毕==========");
	}

	private void scheduledTable() {
		System.out.println("==========预定餐桌==========");
		System.out.print("请选择要预定的餐桌编号(-1退出)>: ");
		int orderId = Utility.readInt();
		if (orderId == -1) {
			System.out.println("取消预定");
			return;
		}
		// 得到要么是 Y 要么是 N
		char ch = Utility.readConfirmSelection("确认是否预定(Y/N)");
		if (ch == 'Y') {
			// 预定
			DiningTable d = dinService.getDiningTableById(orderId);
			if (d == null) {
				// 不存在
				System.out.println("=========预定餐桌不存在========");
				return;
			}
			if (!("空桌".equals(d.getState()))) {
				// 说明当前餐桌不是空桌状态
				System.out.println("=========餐桌已被预定=========");
				return;
			}
			// 这时可以预定
			System.out.print("请输入预定人的名字:> ");
			String name = Utility.readString(20);
			System.out.print("请输入预定人的电话:> ");
			String tel = Utility.readString(11);
			// 更新状态
			if (dinService.orderDiningTable(orderId, name, tel)) {
				System.out.println("==========预定成功==========");
			} else {
				System.out.println("==========预定失败==========");
			}
		} else {
			System.out.println("==========取消预定==========");
		}
	}

	// 显示所有菜品
	private void showMenu() {
		List<Menu> lst = menuService.list();
		System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
		for (Menu m : lst) {
			System.out.println(m);
		}
		System.out.println("=========显示完毕=========");
	}


	// 完成点餐
	private void orderMenu() {
		System.out.println("\n=========点餐服务=========");
		System.out.print("请输入点餐的桌号(-1退出):> ");
		int orderDiningTableNo = Utility.readInt();
		if (orderDiningTableNo == -1) {
			System.out.println("\n=========取消点餐=========");
			return;
		}
		// 验证餐桌号是否存在
		DiningTable dt = dinService.getDiningTableById(orderDiningTableNo);
		if (dt == null) {
			System.out.println("\n=========餐桌不存在========");
			return;
		}

		System.out.print("请输入菜品编号(-1退出):> ");
		int orderMenuId = Utility.readInt();
		if (orderMenuId == -1) {
			System.out.println("\n=========取消点餐=========");
			return;
		}
		// 验证菜品是否正确
		Menu me = menuService.getMenuById(orderMenuId);
		if (me == null) {
			System.out.println("\n=========菜品不存在========");
			return;
		}

		System.out.print("请输入菜品数量(-1退出):> ");
		int orderNums = Utility.readInt();
		if (orderNums == -1) {
			System.out.println("\n=========取消点餐=========");
			return;
		}


		// 入账
		if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableNo)) {
			System.out.println("\n=========点餐成功=========");
		} else {
			System.out.println("\n=========点餐失败=========");
		}
	}

	// 查看所有账单
	private void showBillList() {
		List<Bill> lst = billService.list();
		System.out.println("\n=========所有账单=========");
		System.out.println("编号\t\t菜品号\t\t数量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
		for (Bill b : lst) {
			System.out.println(b);
		}
	}


	// 结账
	private void overBill() {
		System.out.println("=========结账服务=========");
		System.out.print("请选择要结账的餐桌编号(-1退出):> ");
		int tableNo = Utility.readInt();
		if (tableNo == -1) {
			System.out.println("\n=========取消结账=========");
			return;
		}
		// 验证餐桌号是否存在
		Bill b = billService.getBillByTableNo(tableNo);
		if (b == null) {
			System.out.println("\n=========餐桌不存在========");
			return;
		}

		// 查看账单中桌号的状态
		DiningTable d = dinService.getDiningTableById(tableNo);
		if ("空桌".equals(d.getState())) {
			System.out.println("\n========餐桌没有未结账单======");
			return;
		}


		String method;
		while (true) {
			System.out.print("请选择结账方式(现金/支付宝/微信) Q-表示退出:> ");
			method = Utility.readString(32);
			if ("Q".equals(method) || "q".equals(method)) {
				System.out.println("\n=========取消结账=========");
				return;
			}
			if (!("现金".equals(method) || "支付宝".equals(method) || "微信".equals(method))) {
				System.out.println("\n========结账方式有误!=======");
				continue;
			} else {
				break;
			}
		}

		char c = Utility.readConfirmSelection("确认是否结账(Y/N)");
		if ("N".equals(c)) {
			System.out.println("\n=========取消结账=========");
			return;
		} else {
			if (billService.overBillStateMethod(method, tableNo)) {
				System.out.println("\n=========结账成功=========");
			} else {
				System.out.println("\n=========结账失败=========");
			}
		}

	}

}
