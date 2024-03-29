package myHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPq {
	PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> pq2 = new PriorityQueue<>();

	public void add(int val) {
		if (pq1.size() == 0 && pq2.size() == 0) {
			pq1.add(val);
		} else if (pq1.size() == 0) {
			pq1.add(val);
		} else if (pq2.size() == 0) {
			pq2.add(val);
		} else {
			if (pq1.peek() > val) {
				pq1.add(val);
			} else {
				pq2.add(val);
			}
			balance(pq1, pq2);
		}
	}

	public int remove() {
		if (pq1.size() >= pq2.size()) {
			return pq1.remove();
		} else {
			return pq2.remove();
		}
	}

	public int peek() {
		return pq1.size() >= pq2.size() ? pq1.peek() : pq2.peek();
	}

	public int size() {
		return pq1.size() + pq2.size();
	}

	private void balance(PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
		if (pq1.size() - pq2.size() > 1) {
			pq2.add(pq1.remove());
		} else if (pq2.size() - pq1.size() > 1) {
			pq1.add(pq2.remove());
		}
	}

}
