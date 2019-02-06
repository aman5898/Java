package DynamicProgramming;


public class UglyNumber {

	public static boolean isUglyNumber(int num) {
		while (num % 2 == 0) {
			num = num / 2;
		}

		while (num % 3 == 0) {
			num = num / 3;
		}

		while (num % 5 == 0) {
			num = num / 5;
		}

		return num == 1;
	}

	public static int nthUglyNumber(int n) {

		int count = 0;
		int num = 1;
		while (count < n) {
			if (isUglyNumber(num)) {
				count++;
			}
			num++;
		}
		return --num;
	}
	
	

	public static void main(String[] args) {
//		System.out.println(nthUglyNumber(150));
		
	}

}
