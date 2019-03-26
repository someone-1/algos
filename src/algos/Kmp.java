package algos;

public class Kmp {
	public static void search(String str, String pat) {
		int [] patArr = new int [pat.length()];
		buildMatrix(pat, patArr);
		int i=0,j=0;
		while(i < str.length()) {
			if(pat.charAt(j) == str.charAt(i)) {
				i++;
				j++;
				if(j == pat.length()) {
					System.out.println("found pattern at " + (i-j));
					j = patArr[j - 1]; 
				}
			} else {
				if(j==0) {
					i++;
				} else {
					j = patArr[j-1];
				}
			}
		}
	}
	
	private static void buildMatrix(String pat, int [] arr) {
		int len = pat.length();
		int i=1,j=0;
		arr[0] = 0;
		while(i<len) {
			if(pat.charAt(i) == pat.charAt(j)) {
				arr[i] = j+1;
				i++;
				j++;
			} else {
				if(j!=0) {
					j= arr[j-1];
				} else {
					arr[i]=0;
					i++;
				}
			}
		}
	}
	public static void main(String args[]) {
		
		Kmp.search("aaabc", "abc");
	}

}
