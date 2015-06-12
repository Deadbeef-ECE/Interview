public class IsSortedArray {
	public static boolean isSorted(int[] a){
		// ask interviewer for this edge case
		if(a == null || a.length == 0)
			return true;
		
		for(int i = 1; i < a.length; i++){
			if(a[i] < a[i-1])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		int[] a0 = {};
		int[] a1 = null;
		int[] a2 = {1,5,2,1,3};
		int[] a3 = {1,1,1,1,1};
		int[] a4 = {1,5,7,9,9};
		System.out.println("is a0 sorted? "+isSorted(a0));
		System.out.println("is a1 sorted? "+isSorted(a1));
		System.out.println("is a2 sorted? "+isSorted(a2));
		System.out.println("is a3 sorted? "+isSorted(a3));
		System.out.println("is a4 sorted? "+isSorted(a4));

	}
}
