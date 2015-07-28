// 13.
// 找到只包含 2 个 distinct ASCII character 的最长 substring
// 
// follow up: character 可能有 1 billion 怎么办
// my follow up: k个相同长度的解

public class Q013_LongestSubstringWithExactTwoDistinctChars {
	// this can be used for k distinct characters within substring
	public static String find(String str, int k){
		if(str == null || str.length() == 0)
			return null;
		String ret = "";
		int[] table = new int[256];
		int start = 0;
		int end = 0;
		int max = 1;
		for(int i = 0; i < str.length(); i++){
			int ch = str.charAt(i);
			 table[ch]++;
			 end++;
			 while(check(table, k) > k){
				 table[str.charAt(start)]--;
				 start++;
			 }
			 if(end - start > max && check(table, k) == k){
				 ret = str.substring(start, end);
			 }
		}
		return ret;
	}
	
	// O(1) time helper function
	private static int check(int[] table, int k){
        int v = 0;
        for(int i = 0; i < table.length; i++){
            if(table[i] > 0)
                v++;
        }
        return v;
    }
	
	// *******************************************
	// TODO: solution for Large input (follow up)
	// *******************************************
	
	public static void main(String[] args){
		String str = "aabbcccdd";
		test(str);
		String str1 = "aaaaaaaa";
		test(str1);	
	}

	private static void test(String str){
		System.out.println("input string is: "+ str);
		String ret = find(str, 2);
		System.out.println("Longest substring with 2 distinct chars is: " + ret);
	}
}
