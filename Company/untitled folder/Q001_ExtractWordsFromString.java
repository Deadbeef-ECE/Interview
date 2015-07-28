// 1.
// 给一个 string,返回含有 word 的 list。word 的定义是空格(大于等于一个)之间的或者引号之间的,
// 如果引号里面有空格要做为一个 word 返回。
// e.g. 
// string 是 I have a "faux coat" 要返回[I, have, a, faux coat]

import java.util.LinkedList;
import java.util.List;

public class Q001_ExtractWordsFromString {
	public static List<String> extract(String str){
		List<String> ret = new LinkedList<String>();
		str = str.trim();
		int start = 0;
		int end = 0;
		int flag = 0; // 0 means no "
		for(end = 1; end < str.length(); end++){
			if(flag == 0 && str.charAt(end) != ' ' && str.charAt(end) != '"')
				continue;
			if(flag == 0 && str.charAt(end) == '"'){
				flag = 1;
				start = end;
			}
			if(flag == 1 && str.charAt(end) == '"'){
				flag = 0;
			}
			if(flag == 0 && str.charAt(end) == ' ' && str.charAt(end) != '"'){
				String s = str.substring(start, end);
				if(start != end && !s.equals("\""))
					ret.add(s);
				start = end+1;
			}
		}
		//ret.add(str.substring(start, end));
		return ret;
	}
	
	public static void main(String[] args){
		String str = " I  Have a \" Apple watch\" ";
		printRet(str);
	}
	
	
	private static void printRet(String str){
		System.out.println("Original String: " + str);
		List<String> ret = extract(str);
		for(int i = 0; i < ret.size(); i++){
			System.out.print("["+ret.get(i)+"]");
		}
	}
}
