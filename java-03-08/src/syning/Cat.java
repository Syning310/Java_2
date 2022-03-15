package syning;

public class Cat {
	private String name;
	public int age;

	public Cat() {
		name = "宁";
		age = 10;
	}

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void call() {
		System.out.println("call方法: " + name + ": 喵喵喵");
	}

	public int add() {
		return 1 + 1;
	}

	public void cry() {
		System.out.println("cry方法: " + name + ": 在哭泣");
	}
}
