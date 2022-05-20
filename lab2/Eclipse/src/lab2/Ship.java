package lab2;

public class Ship {
	private String name;
	private int displacement;
	private String type;

	Ship(String name, int displacement, String type) {
		this.name = (name == null) ? "Тест" : name;
		this.displacement = (displacement == 0) ? -1 : displacement;
		this.type = (type == null) ? "Тест" : type;
	}
	
	private void print(String text, int value) {
		System.out.print(text);
		System.out.println(value);
	}
	private void print(String text, String value) {
		System.out.print(text);
		System.out.println(value);
	}
	
	public void getName() {
		print("Название корабля: ", this.name);
	}
	public void getDisplacement() {
		print("Водоизмещение корабля: ", this.displacement);
	}
	public void getType() {
		print("Тип корабля: ", this.type);
	}
	
	public void getInfo() {
		getName();
		getDisplacement();
		getType();
	}
}
