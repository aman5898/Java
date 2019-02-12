package string;

import java.util.*;
import java.lang.*;
import java.io.*;
class BinaryDivisibleBy3
 {
	public static void main (String[] args)
	 {
	    Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		scn.nextLine();
		while (t-- > 0) {
			String str = scn.nextLine();
			divisibleBy(str);
		}
	 }
	
	 
	 public static void divisibleBy(String s){
	     int odd=0;
	     int even=0;
	     for(int i=0;i<s.length();i++){
	         if(s.charAt(i)=='1'){
	             if(i%2==0){
	                 even++;
	             }else{
	                 odd++;
	             }
	         }
	     }
	     System.out.println(odd);
	     System.out.println(even);
	     
	     if(Math.abs(even-odd)%3==0){
	         System.out.println("1");
	     }else{
	         System.out.println("0");
	     }
	 }
}