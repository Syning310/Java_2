package domain;

import java.util.Date;

public class Bill {

	private Integer id;
	private String billId;
	private Integer menuId;
	private Integer nums;
	private Double money;
	private int tableNo;
	private Date billDate;
	// 未结账   已结账    挂单
	private String state;

	@Override
	public String toString() {
		return id + "\t\t" + menuId + "\t\t\t" + nums + "\t\t"
				+ money + "\t" + tableNo + "\t\t" + billDate + "\t\t"
				+ state;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, int tableNo, Date billDate, String state) {
		this.id = id;
		this.billId = billId;
		this.menuId = menuId;
		this.nums = nums;
		this.money = money;
		this.tableNo = tableNo;
		this.billDate = billDate;
		this.state = state;
	}

	public Bill() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
