package onsite;
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=136563&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Anagrams {
	static HashMap<String, HashSet<String>> dict;
	public Anagrams(){
		dict = new HashMap<String, HashSet<String>>();
	}
	
	public static void addToDictionary(String word){
		String anagram = convert(word);
		if(dict.containsKey(anagram)){
			HashSet<String> set = dict.get(anagram);
			set.add(word);
		}else{
			HashSet<String> newSet = new HashSet<String>();
			newSet.add(word);
			dict.put(anagram, newSet);
		}
	}
	
	public static Set<String> queryAnagram(String word){
		String anagram = convert(word);
		if(dict.containsKey(anagram)){
			return dict.get(anagram);
		}else{
			System.out.println("Can not find in the dict");
		}
		return new HashSet<String>();
	}
	
	private static String convert(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	private static void printHashSet(Set<String> set){
		for(String str : set)
			System.out.println(str);
	}
	public static void main(String[] args){
		Anagrams dict = new Anagrams();
		dict.addToDictionary("adscs");
		dict.addToDictionary("adcss");
		dict.addToDictionary("ascsd");
		dict.addToDictionary("aew");
		dict.addToDictionary("cow");
		dict.addToDictionary("ocw");
		dict.addToDictionary("eaw");
		Set<String> set = dict.queryAnagram("csdsa");
		printHashSet(set);
		Set<String> set2 = dict.queryAnagram("wco");
		printHashSet(set2);
		Set<String> set3 = dict.queryAnagram("c");
		printHashSet(set3);
	}
}
