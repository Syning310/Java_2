package utils;

import dao.EmpDAO;
import domain.Employee;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		EmpDAO dao = new EmpDAO();
		List<Employee> lst = dao.queryMulti("select * from employee", Employee.class);

		for (Employee e : lst) {
			System.out.println(e);

		}


	}

}
