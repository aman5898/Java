package string;

import java.util.Scanner;

public class ExcelSheet {
	public static void main(String[] args) {
//		sheet(51);
		Scanner scn=new Scanner(System.in);
		 int n=scn.nextInt();
         int[] arr=new int[n];
         for(int i=0;i<arr.length;i++){
             arr[i]=scn.nextInt();
         }
         for(int i=0;i<arr.length;i++){
        	 if(arr[i]==2) {
        		 System.out.println(i);
        	 }
         }
	}

	public static void sheet(int n) {
		int quot = n / 26;
		int rem = n % 26;
		String res = "";
		for (int i = 0; i < quot; i++) {
			res += "A";
		}
		char ch = (char) (rem + 64);
		res+=ch+"";
		System.out.println(res);
	}
}
