package myHeap;


public class client {

	public static void main(String[] args) {
		int[] arr= {20,10,5,40,15,75,99,8};
		Heap hp = new Heap(arr,false) ;

		while (!hp.isEmpty()) {
			System.out.println(hp.remove());
		}
	}

}
