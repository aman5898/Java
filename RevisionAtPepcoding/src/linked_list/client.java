package linked_list;


public class client {

	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.addlast(20);
		ll.addlast(3);
		ll.addlast(40);
		ll.addlast(55);
		ll.addlast(69);
		ll.addlast(70);
		ll.addlast(80);
		ll.addlast(90);
		ll.display();
//		ll.kthreverse(2);
//		ll.removedup();
		ll.oddeven();
		ll.display();
//		System.out.println(ll.Ispallindrome());
	}

}
