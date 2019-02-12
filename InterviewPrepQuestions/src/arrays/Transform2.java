package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class Transform2 {
	public static void main (String[] args) {
		//code
		Scanner sc =new Scanner(System.in);
	
	    int t2=sc.nextInt();
	    while(t2-->0)
	    {
	        int n=sc.nextInt();
	        int arr[]=new int[n];
	        int t=0;
	        for(int i=0;i<n;i++)
	        {
	            int x=sc.nextInt();
	            if(x!=0)
	            {
	                arr[t++]=x;
	                if(t>1)
	                {
	                    if(arr[t-1]==arr[t-2])
	                    {
	                        arr[t-1]=0;
	                        arr[t-2]*=2;
	                        t--;
	                    }
	                }
	            }
	        }
	        for(int i=0;i<n;i++)
	        {
	            if(i<t)
	            {
	                System.out.print(arr[i]+" ");
	            }
	            else
	                System.out.print("0 ");
	        }
	        
	        System.out.println();
	    }

}}