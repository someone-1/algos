package algos;

import java.util.ArrayList;

public class PrintSubset {
	
	public static void printAllSubset(int[] superSet, ArrayList<Integer> subset, int index) {
		if(index > superSet.length) {
			return;
		}
		if(index == superSet.length) {
//			System.out.print(index + " - ");
			for(int i=0;i<subset.size();i++) {
				System.out.print(subset.get(i) + " ");
			}
			System.out.println("");
		}
		ArrayList<Integer> temp = (ArrayList<Integer>) subset.clone();
		if(index<superSet.length) {
			subset.add(superSet[index]);
			printAllSubset(superSet, subset, index+1);
			printAllSubset(superSet, temp, index+1);
		}
	}
	public static void printAllSubset(int[] a){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		printAllSubset(a, subset, 0);
	}
	
	public static void main(String []args) {
		int [] a = {1,2,3,4};
		printAllSubset(a);
	}

}
