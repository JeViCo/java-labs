package lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Ship> ships = new ArrayList<Ship>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			System.out.print("Введите количество кораблей для добавления: ");
			int count = sc.nextInt();
			
			for (int i = 0; i < count; i++) {
				sc.nextLine();
				System.out.print("Укажите название корабля: ");
				String name = sc.nextLine();
				
				System.out.print("Укажите водоизмещение корабля: ");
				int displacement = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Укажите тип корабля: ");
				String type = sc.nextLine();
				
				ships.add(
					new Ship(name, displacement, type)
				);
			}
			
			System.out.println();
			System.out.print("Информацию о каком корабле вы бы хотели узнать (Напишите число от 1 до ");
			System.out.print(count);
			System.out.print("): ");
			
			int id = sc.nextInt() - 1;
			System.out.println();

			System.out.println("Информация о корабле:");
			ships.get(id).getInfo();
			
		} catch (Exception e) { // Вывод ошибок
			System.out.println(e);
		}
	}
}
