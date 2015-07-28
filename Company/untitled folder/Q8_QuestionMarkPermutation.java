// 8. 
// 给一个 string, 只包含{0,1,?}, ?可以代表 0 或者 1, 输出所有的组合. 
// e.g.: "10?", 输出"100", "101"

import java.util.LinkedList;
import java.util.List;

public class Q8_QuestionMarkPermutation {
	// O(n*2^m) time: 
	// n is the length of input
	// m is the number of question masks
	// 
	// O(n) space: 
	// n is the toString() 
	// m is the recursion stack which can be ignored
	public static List<String> PermutationWithQuestionMark(String str){
		List<String> ret = new LinkedList<String>();
		if(str == null || str.length() == 0)
			return ret;
		StringBuilder path = new StringBuilder();
		//doDFS(0, str, path, ret);
		dfs(ret, path, str, 0);
		return ret;
	}
	
	// @author: Lei Wang
	// This solution is better since only "?" will trigger backtracking
	private static void dfs(List<String> rst, StringBuilder sb, String str, int pos) {
		if (pos == str.length()) {
			rst.add(sb.toString());
			return;
		}

		char c = str.charAt(pos);
		if (c != '?') {
			sb.append(c);
			dfs(rst, sb, str, pos + 1);
		} else {
			for(int i = 0; i <= 1; i++){
				sb.append(i);
				dfs(rst, sb, str, pos + 1);
				sb.delete(pos, sb.length());
			}
		}
	}
	
	// @author: Richard
	// This solution will do backtracking all the time
	private static void doDFS(int start, String str, StringBuilder path, List<String>ret){
		if(start == str.length()){
			ret.add(path.toString());
			return;
		}
		
		if(str.charAt(start) != '?'){
			path.append(str.charAt(start));
			doDFS(start+1, str, path, ret);
			path.deleteCharAt(path.length() - 1);
		}else{
			for(int i = 0; i <= 1; i++){
				path.append(i);
				doDFS(start+1, str, path, ret);
				path.deleteCharAt(path.length() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		String str = "????";
		List<String> ret = PermutationWithQuestionMark(str);
		for(String s : ret){
			System.out.println(s);
		}
	}
}
