import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/*
 * Input String[] array = {"ab, bc, bz"} Output "abcz"
 * Input String[] array = {"fbz, jb, ebj"} Output "efbjz"
 * 要满足三个条件：
 * 1. Output unique character
 * 2. output的string里，character相对顺序不变。Input不会有“bc ”，“cb”这种情况出现
 * 3.满足以上两个条件，按照lexicographical order, 输出最小的可能性
 * */

public class ShortestSuperString {
	public static void toposort(Map<Character, Set<Character>> map,
			Set<Character> visited, Stack<Character> stack, char c) {
		visited.add(c);
		if (map.containsKey(c)) {
			for (Character neigbor : map.get(c)) {
				if (!visited.contains(neigbor)) {
					toposort(map, visited, stack, neigbor);
				}
			}
		}
		stack.push(c);
	}
	
	public static String GetSuperString(List<String> strs){
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Set<Character> set = new HashSet<Character>();
		Set<Character> visited = new HashSet<Character>();
		
		for (String s : strs) {
			set.add(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				if (!map.containsKey(s.charAt(i - 1))) {
					Set<Character> adjacent = new HashSet<Character>();
					adjacent.add(s.charAt(i));
					map.put(s.charAt(i - 1), adjacent);
				} else {
					map.get(s.charAt(i - 1)).add(s.charAt(i));
				}
				set.add(s.charAt(i));
			}
		}

		Stack<Character> stack = new Stack<Character>();
		for (char c : set) {
			if (!visited.contains(c)) {
				toposort(map, visited, stack, c);
			}
		}

		StringBuilder ret = new StringBuilder();
		while (!stack.isEmpty()) {
			ret.append(stack.pop());
		}

		return ret.toString();
	}
    
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("fbz");list.add("jb");list.add("ebj");
		String res = GetSuperString(list);
		System.out.println(res);
	}
}
