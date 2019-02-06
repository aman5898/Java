package genricTree;

public class Client {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		GenericTree gt = new GenericTree(arr);
		gt.display();

//	System.out.println(gt.nodeToRooTPath(110));
//	gt.removeLeaves();
//	gt.mirror();
//	gt.multiSolver();
		gt.mutliSolver3(100);
	}

}
