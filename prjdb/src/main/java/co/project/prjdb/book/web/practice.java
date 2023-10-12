package co.project.prjdb.book.web;

import java.util.*;
import java.util.stream.Collectors;

public class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a = n/4+1;
		
		int b = n%4-1;
		
		System.out.println(a+" "+b);
		int resulta = a-b;
		int resultb = a+b;
		
		if(resulta==0) resulta = 1;
		if(resultb==0) resultb = 1;
		System.out.println(resulta+"/"+resultb);
	}	
}

