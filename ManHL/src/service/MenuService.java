package service;

import dao.MenuDAO;
import domain.Menu;

import java.util.List;

public class MenuService {
	MenuDAO mdao = new MenuDAO();

	// 返回所有的菜品，返回给界面
	public List<Menu> list() {
		return mdao.queryMulti("select * from menu",
				Menu.class);
	}

	// 需要一个方法，根据id返回一个Menu对象
	public Menu getMenuById(int id) {
		return mdao.querySingle("select * from menu where id = ?",
				Menu.class, id);
	}


}
