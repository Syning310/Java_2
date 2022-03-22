package service;


import dao.EmpDAO;
import domain.DiningTable;
import domain.Employee;

public class EmpService {

	// 操作 employee 表
	private EmpDAO empdao = new EmpDAO();


	// 根据empId，和pwd返回一个Employee对象
	public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
			return empdao.querySingle("select * from employee where empId = ? and pwd = md5(?)",
					Employee.class, empId, pwd);
	}



}
