package heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data = new ArrayList<>();
	boolean max;

	public Heap(int[] arr, boolean max) {
		this.max = max;
		for (int val : arr) {
			this.data.add(val);
		}

		for (int i = (size() / 2) - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	// change
	public void add(int val) {
		this.data.add(val);
		upheafify(this.data.size() - 1);
	}

	// change
	private void upheafify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (isHP(pi, ci)==false) {
			swap(pi, ci);
			upheafify(pi);
		}
	}

	private void swap(int i, int j) {
		int ith = this.data.get(i);
		int jth = this.data.get(j);
		this.data.set(i, jth);
		this.data.set(j, ith);
	}

	public int remove() {
		swap(0, this.data.size() - 1);
		int rv = this.data.remove(this.data.size() - 1);
		downheapify(0);
		return rv;
	}

	// change
	private void downheapify(int pi) {
		int mini = pi;
		int lci = 2 * pi + 1;

		if (lci < this.data.size() && isHP(mini, lci)==false) {
			mini = lci;
		}

		int rci = 2 * pi + 2;
		if (rci < this.data.size() && isHP(mini, rci)==false) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}
	}

	public boolean isHP(int pi, int ci) {
		if (max == false) {
			return this.data.get(pi) < this.data.get(ci);
		} else {
			return this.data.get(pi) > this.data.get(ci);
		}
	}

	public int peek() {
		return this.data.get(0);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	public void display() {
		System.out.println(this.data);
	}
}
