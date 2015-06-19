public class TwoSum {
	// O(n) space, O(n) time
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void add(int number) {
        if(map.containsKey(number))
            map.put(number, map.get(number)+1);
        else
            map.put(number, 1);
	}

	public boolean find(int value) {
	    for(int num: map.keySet()){
	        if(value - num == num){
	            if(map.get(num) >= 2)
	                return true;
	        }else{
	            if(map.containsKey(value-num))
	                return true;
	        }
	    }
	    return false;
	}
}