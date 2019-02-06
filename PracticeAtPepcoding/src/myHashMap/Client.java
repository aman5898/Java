package myHashMap;


public class Client {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap=new HashMap<>();
		hmap.put("India", 133);
		hmap.put("Pakistan", 13);
		hmap.put("China", 150);
		hmap.put("Australia", 80);
		hmap.put("America", 100);
		hmap.put("Utopia", 33);
		hmap.put("Nepal", 5);
		hmap.display();
		
		hmap.put("Nepal", 10);
		hmap.display();
		hmap.put("Africa", 100);
		hmap.display();
		hmap.remove("Africa");
		hmap.display();
		System.out.println(hmap.keyset());
		System.out.println(hmap.remove("inda"));
		hmap.put("wakanda", 100);
		hmap.display();
		hmap.put("Uk", 100);
		hmap.display();
		System.out.println(hmap.keyset());
	}

}
