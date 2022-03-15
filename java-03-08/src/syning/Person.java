package syning;

public class Person {
	public String name = "宁";
	public int age = 20;
	public double weight = 140;

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", weight=" + weight +
				'}';
	}
}
