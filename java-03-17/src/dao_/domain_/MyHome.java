package dao_.domain_;




// MyHome对象映射myhome表，一个对象，表示一条myhome记录
public class MyHome {  // Javabean, POJO, Domain 对象
	private Integer id;
	private String name;

	public MyHome() {}  // 一定要给一个无参构造器，反射需要

	public MyHome(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyHome{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
