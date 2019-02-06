package aVl;


public class client {

	public static void main(String[] args) {
		int[] sa = { 12, 25, 37, 50, 62, 75, 87 };
		Avl bt = new Avl(sa);
		bt.display();
		bt.display();
		bt.add(10);
		bt.add(20);
		bt.add(30);
		bt.add(40);
		bt.add(60);
		bt.add(70);
		bt.add(80);
		bt.add(90);
		System.out.println("aman");
		bt.display();
		bt.remove(30);
		bt.remove(40);
		bt.remove(37);
		bt.remove(10);
		System.out.println("aman");
		bt.display();
		
		

	}

}
