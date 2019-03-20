package algos;

import java.util.ArrayList;

public class MaxHeap {

	private ArrayList <Integer> elements = new ArrayList<Integer>();
	
	public MaxHeap(int data) {
		elements.add(data);
	}
	public void add (int data) {
		elements.add(data);
		this.heapifyDown(elements.size()-1);
	}
	public int getMax() {
		if(size()<1) {
			throw new IllegalStateException("cant remove element from empty heap");
		}
		return elements.get(0); 
	}
	public int size() {return elements.size();}
	public void print() {
		for(int i=0;i<size() ;i++) {
			System.out.print("Parent "+ get(i));
			System.out.print(" left child ");
			if(leftExists(i)) {
				System.out.print(getLC(i));
			} else {
				System.out.print("-");
			}
			System.out.print(" right child ");
			if(rightExists(i)) {
				System.out.print(getRC(i));
			}else {
				System.out.print("-");
			}
			System.out.println("");
		}
	}
	public void removeMax() {
		if(size()<1) {
			throw new IllegalStateException("cant remove element from empty heap");
		}
		elements.set(0, get(size()-1));
		elements.remove(size()-1);
		heapifyUp(0);
	}
	private void heapifyUp(int index) {
		if(!leftExists(index) && !rightExists(index)) {
			return;
		}
		if(!leftExists(index)) {
			swap(index, getRI(index));
			heapifyUp(getRI(index));
		}
		if(!rightExists(index)) {
			swap(index, getLI(index));
			heapifyUp(getLI(index));
		}
		if(getLC(index) > getRC(index)) {
			swap(index, getLI(index));
			heapifyUp(getLI(index));
		}else {
			swap(index, getRI(index));
			heapifyUp(getRI(index));
		}
	}
	private void heapifyDown(int index) {
		if(index<=0) {
			return ;
		}
		if(getP(index) >= get(index)) {
			return;
		}
		swap(index, getPI(index));
		heapifyDown(getPI(index));
	}
	private void swap(int index1, int index2) {
		int temp = get(index1);
		set(index1, get(index2));
		set(index2, temp);
	}
	private boolean leftExists(int index) {
		if((index*2+1)<size()) {
			return true;
		} else {
			return false;
		}
	}
	private boolean rightExists(int index) {
		if((index*2+2)<size()) {
			return true;
		} else {
			return false;
		}
	}
	private void set(int index, int element) { elements.set(index, element); }
	private int get(int index) { return elements.get(index); }
	private int getP(int index) { return get(getPI(index)); }
	private int getPI(int index) {
		if(index%2==0) {
			return ((index-2)/2);
		}else {
			return((index-1)/2);
		}
	}
	private int getLC(int index) { return get(getLI(index)); }
	private int getLI(int index) { return(2*index+1); }
	private int getRC(int index) { return get(getRI(index)); }
	private int getRI(int index) { return (2*index+2); }
	
	
	public static void main(String args[]) {
		
		MaxHeap heap = new MaxHeap(3);
		heap.add(21);
		heap.add(17);
		heap.add(7);
		heap.print();
		heap.removeMax();
		System.out.println("--");
		heap.print();
		
		
	}

}
