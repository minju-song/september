package co.project.prjdb.book.web;
import java.util.Scanner;

public class prac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=n-1-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<(n+2)-2*i+2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

