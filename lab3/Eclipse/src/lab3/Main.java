package lab3;

import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Введите количество контрольных точек: ");
		int count = sc.nextInt();
		if (count > 0) {
			int[] breakpoints = new int[count];
			
			for (int i = 0; i < count; i++) {
				System.out.print("Укажите номер итерации от 1 до " + Series.maxIter + ": ");
				breakpoints[i] = sc.nextInt() - 1;
			}
			Series.addBreakpoints(breakpoints);
		}
		Series.execute();
	}
}