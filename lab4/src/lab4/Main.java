package lab4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static int getRandomInt() {
		return (int)(Math.random()*100);
	}
	
	public static int[][] createArray(int size) {
		int[][] array = new int[2][size];
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = getRandomInt();
			}
		}
		return array;
	}
	
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
		}
	
	public static void sortArray(int[][] array) {
		int n = array.length;
		int m = array[0].length;
		
		for (int j = 1; j < m; j++) {
			for (int k = 0; k < m-j; k++) {
				if (array[n-1][k]>array[n-1][k+1]) {
					for (int i = 0; i < n; i++) {
						swap(k, k+1, array[i]);
					}
				}
			}
		}
	}
	
	public static void outputArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

	public static void main(String[] args) {
		System.out.print("Укажите длину массивов: ");
		int size = sc.nextInt();
		
		int[][] array = createArray(size);
		System.out.println("Исходный массив:");
		outputArray(array);
		
		sortArray(array);

		System.out.println();
		System.out.println("Отсортированный массив:");
		outputArray(array);
	}

}
