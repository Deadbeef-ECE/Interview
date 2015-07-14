package onsite;
// 有一个数组，数组里元素先递增再递减再递增，然后给一个element， 
// 返回该element的index或者-1， 
// input : [7, 5, 4, 3, 2,-1, 1, 6]  element:4  返回2

public class FindTargetInArray {
	public static int Find(int[] arr, int target){
		int index = -1;
		if(arr == null || arr.length == 0)
			return index;
		index = findMin(arr, 0, arr.length - 1);
		System.out.println(index+ " Min " + arr[index]);
		if(target == arr[index])
			return index;
		
		
		return index;
	}
	
	private static int findMin(int[] arr, int start, int end){
		int lo = start, hi = end;
		while(lo <= hi){
			if(lo == hi)	return lo;
			int mid = lo + (hi - lo)/2;
			if(arr[mid] > arr[mid+1]){
                lo = mid+1;
            }else{
                hi = mid;
            }
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {7,5,4,3,2,-1,1,6};
		int target = 4;
		System.out.println("index of "+target+" is: "+Find(arr, target));
	}
}
