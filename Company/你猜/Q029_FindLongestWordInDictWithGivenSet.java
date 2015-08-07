// 29.
// 假设有一个dictionary和一个字符的 set, 找到从该字符集中能组成的存在于dictionary中的最长的word

import java.util.HashSet;
import java.util.Set;

public class Q029_FindLongestWordInDictWithGivenSet {
	public static String find(Set<String> dict, Set<Character> set){
		String[] ret = new String[1];
		StringBuilder path = new StringBuilder();
		Trie trie = new Trie();
		for(String word : dict){
			System.out.println("insert " + word);
			trie.insert(word);
		}
		
		TrieNode root = trie.root();
		int[] len = {Integer.MIN_VALUE};
		dfs(root, len, set, path, ret);
		return ret[0];
	}
	
	private static void dfs(TrieNode node, int[] len, Set<Character> set, StringBuilder path, String[] ret){
		if(node.end == true){
			if(path.length() >= len[0]){
				ret[0] = path.toString();
				len[0] = path.length();
				return;
			}
		}
		
		for(int i = 0; i < 26; i++){
			if(node.child[i] != null && set.contains((char)(i+'a'))){
				path.append((char)(i+'a'));
				dfs(node.child[i], len, set, path, ret);
				path.deleteCharAt((path.length()-1));
			}
		}
	}
	
	public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		Set<Character> set = new HashSet<Character>();
		
		dict.add("monkey"); dict.add("mom"); dict.add("noon");
		dict.add("monk"); dict.add("money"); dict.add("moon");
		set.add('m');	set.add('k');	set.add('o'); set.add('n');
		set.add('e');	set.add('y');
		
		String ret = find(dict, set);
		System.out.println("result: "+ret);
	}
}
