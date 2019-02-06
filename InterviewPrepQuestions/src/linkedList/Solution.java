package linkedList;


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        
        int x=minJumps(arr,n);
        System.out.println(x);
    }
    
    public static int minJumps(int[] arr,int n){
        int[] strg=new int[n];
        for(int i=1;i<n;i++){
            int min=1000;
            for(int j=0;j<i;j++){
                if(arr[j]>=i-j){
                    min=Math.min(min,strg[j]);
                }
            }
            System.out.println(min+" "+strg[i]);
            // /System.out.println(strg[i]+" "+(min+1));
            strg[i]=min+1;
        }
        
        return strg[strg.length-1];
    }
}