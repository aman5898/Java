package myHashMap;

import java.util.ArrayList;

public class HashMap<K, V> {

	LinkedList<HMnode>[] buckets;
	private int size = 0;

	private class HMnode {
		K key;
		V value;

		public HMnode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap() {
		buckets = new LinkedList[4];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public void put(K key, V value) {
		int bi = hashFunction(key);
		HMnode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			this.size++;
			buckets[bi].addlast(new HMnode(key, value));
		} else {
			hmnode.value = value;
		}

		double lambda = this.size * 1.0 / buckets.length;
		if (lambda > 2.0) {
			rehash();
		}
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		LinkedList<HMnode>[] oba = buckets;
		buckets = new LinkedList[2 * buckets.length];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}

		this.size = 0;
		for (int bi = 0; bi < oba.length; bi++) {
			for (int di = 0; di < oba[bi].size; di++) {
				HMnode hmnode = oba[bi].getat(di);
				put(hmnode.key, hmnode.value);
			}
		}
	}

	public V get(K key) {
		int bi = hashFunction(key);
		HMnode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			return null;
		} else {
			return hmnode.value;
		}
	}

	public boolean containsKey(K key) {
		int bi = hashFunction(key);
		HMnode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			return false;
		} else {
			return true;
		}
	}

	public V remove(K key) {
		int bi = hashFunction(key);
		HMnode hmnode = findWithinBucket(bi, key);

		if (hmnode == null) {
			return null;
		} else {
			this.size--;
			removeWithinBucket(bi, key);
			return hmnode.value;
		}
	}

	public ArrayList<K> keyset() {
		ArrayList<K> keys = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (int di = 0; di < buckets[i].size; di++) {
				keys.add(buckets[i].getat(di).key);
			}
		}
		return keys;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println("````````````````````````````````````````````````````````");
		for (int i = 0; i < buckets.length; i++) {
			System.out.print("B" + i + "- ");
			for (int di = 0; di < buckets[i].size; di++) {
				HMnode hmnode = buckets[i].getat(di);
				System.out.print("{" + hmnode.key + "=" + hmnode.value + "}, ");
			}
			System.out.println();
		}
	}

	private void removeWithinBucket(int bi, K key) {
		for (int di = 0; di < buckets[bi].size; di++) {
			HMnode hmnode = buckets[bi].getat(di);
			if (hmnode.key.equals(key)) {
				buckets[bi].removeat(di);
				return;
			}
		}
	}

	private HashMap<K, V>.HMnode findWithinBucket(int bi, K key) {
		for (int di = 0; di < buckets[bi].size; di++) {
			HMnode hmnode = buckets[bi].getat(di);
			if (hmnode.key.equals(key)) {
				return hmnode;
			}
		}

		return null;
	}

	private int hashFunction(K key) {
		int hash = key.hashCode();
		return Math.abs(hash) % buckets.length;
	}
}
