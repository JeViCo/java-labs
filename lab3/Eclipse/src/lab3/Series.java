package lab3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class Series {
	public static double eps = 2E-17; // 2* 10^-17
	public static double an = 0;
	public static double sum = 0;
	
	public static int iter = 0;
	public static int maxIter = 1000;
	
	public static int breakpointIndex;
	public static int[] breakpoints;
	
	public static void print() {
		System.out.print("Итерация: " + (iter+1));
		System.out.print("\tЧлен ряда: " + an);
		System.out.println("\tСумма ряда: " + sum);
	}
	
	public static BigDecimal getFactorial(int number) {
		if(number == 0) {
			return BigDecimal.ONE;
		}
	    return BigDecimal.valueOf(number).multiply( getFactorial(number-1), MathContext.DECIMAL128);
	}
	
	public static double get_An(int n) {
		long n1 = (long) Math.pow(10, n);
		BigDecimal n2 = getFactorial(n);
		return BigDecimal.valueOf(n1).divide(n2, MathContext.DECIMAL128).doubleValue();
	}
	
	public static void execute() {
		do {
			an = get_An(iter);
			sum += an;
			print();
			
			if (!checkBreakpoint()) {
				break;
			}
			
			iter++;
		} while ((Math.abs(an) >= eps) && (iter < maxIter));
	}
	
	public static void addBreakpoints(int[] breakpoints) {
		Series.breakpoints = breakpoints;
		Arrays.sort(Series.breakpoints);
	}
	
	public static boolean checkBreakpoint() {
		// Точек нет
		if (breakpoints == null) {
			return true;
		}
		// Попали в контрольную итерацию
		if (iter != breakpoints[breakpointIndex]) {
			return true;
		}
		
		String answer;
		
		do {
			System.out.print("Вы достигли контрольной итерации №" + (iter+1) + "\nХотите продолжить вычисления (Y/N): ");
			answer = Main.sc.next();
			
			
			if (answer.equalsIgnoreCase("N")) {
				return false;
			} else if (answer.equalsIgnoreCase("Y")) {
				break;
			}
		// Спрашиваем пока не будет точного ответа
		} while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));

		breakpointIndex++;
		if (breakpointIndex >= breakpoints.length) {
			breakpoints = null;
		}
		
		return true;
	}
}
