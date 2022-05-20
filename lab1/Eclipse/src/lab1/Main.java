package lab1;

public class Main {
	
	private static void calculate(double x, double a, double b) {
		double y = Math.pow(Math.sin(
				Math.pow(Math.pow(x, 2) + a, 2)
			), 3) - Math.sqrt(x/b);
		System.out.print("y = ");
		System.out.println(y);
		
		double z = Math.pow(x, 3)/3 + Math.cos(Math.pow(x+b, 3));
		System.out.print("z = ");
		System.out.println(z);
	}

	public static void main(String[] args) {
		try {
			if (args != null && args.length == 3) {
				System.out.println("Результат:");
				calculate(
						Double.parseDouble(args[0]), 
						Double.parseDouble(args[1]), 
						Double.parseDouble(args[2])
				);
			} else {
				System.out.println("Неправильно переданы аргументы! Пример: java -jar test.jar x a b");
			}
		} catch (Exception e) { // Вывод ошибок
			System.out.println(e);
		}
	}

}
