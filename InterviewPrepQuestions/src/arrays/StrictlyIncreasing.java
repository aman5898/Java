package arrays;

public class StrictlyIncreasing {
	
	public static void main(String[] args) {
		strictlyIncreasing(new int[] {1,2,3,6,5,4});
	}
	public static void strictlyIncreasing(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i]>arr[j]&&arr[i]-arr[j]>=i-j) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++) {
			max=Math.max(max, dp[i]);
		}
		
		System.out.println(arr.length-max);
	}
	
	static int minChanges(int arr[], int n) 
    { 
        int LIS[] = new int[n]; 
        int len = 0; 
  
        for (int i = 0; i < n; i++) 
            LIS[i] = 1; 
  
        for (int i = 1; i < n; i++) { 
            for (int j = 0; j < i; j++) { 
                if (arr[i] > arr[j] && (i-j)<=(arr[i]-arr[j])) 
                    LIS[i] = Math.max(LIS[i],  
                                 LIS[j] + 1); 
            } 
            len = Math.max(len, LIS[i]); 
        } 
  
        return n - len; 
    } 
}
