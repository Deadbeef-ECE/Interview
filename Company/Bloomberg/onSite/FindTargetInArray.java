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
		else{
			// find from the left part
			int res = search(arr, target, 0, index-1);
			if(res != -1 && target == arr[res])	
				return res;
			else
				res = search(arr, target, index + 1, arr.length-1);
			if(res != -1 && target == arr[res])	
				return res;
		}
		return -1;
	}
	
	private static int search(int[] arr, int target, int start, int end){
		int lo = start;
		int hi = end;
		// 递减数列 e.g, {7,5,4,3,2}
		if(arr[start] > arr[end]){
			while(lo <= hi){
				int mid = lo + (hi - lo)/2;
				if(arr[mid] == target)	return mid;
				else if(arr[mid] > target)
					lo = mid + 1;
				else
					hi = mid - 1;
			}
		}else{ // 递增数列 e.g, {1,3,6}
			while(lo <= hi){
				int mid = lo + (hi - lo)/2;
				if(arr[mid] == target)	return mid;
				else if(arr[mid] > target)
					hi = mid - 1;
				else
					lo = mid + 1;
			}
		}
		return -1;
	}
	// {7,5,4,3,2,-1,1,6}
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
		int target = 12;//6;
		int index = Find(arr, target);
		System.out.println("index of "+target+" is: "+ index);
		if(index >= 0 && index < arr.length)
			System.out.println("The answer is " + (arr[index] == target));
		else 
			System.out.println("Cannot find target: "+ target);
	}
}
