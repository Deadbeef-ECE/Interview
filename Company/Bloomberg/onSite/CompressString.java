package onsite;
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=131230&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
// watch out: 
// (1) No dups will waste space 
// (2)big integer to overflow

public class CompressString {
	public static String compresStr(String str){
		String ret = "";
		if(str == null || str.length() == 0)
			return ret;
		int cnt = 1;
		int i = 1;
		for(; i < str.length(); i++){
			if(str.charAt(i) == str.charAt(i-1)){
				cnt++;
				continue;
			}
			ret += str.charAt(i-1);
			ret += cnt;
			cnt = 1;
		}
		ret += str.charAt(i - 1);
		ret += cnt;
		return ret;
	}
	
	public static void main(String [] args){
		System.out.println("abcdefg" + " -> " + compresStr("abcdefg"));
		System.out.println("a" + " -> " + compresStr("a"));
		System.out.println("aaaaaaaa" + " -> " + compresStr("aaaaaaaa"));
		System.out.println("abbbbbb" + " -> " + compresStr("abbbbbb"));
		System.out.println("aabbcdd" + " -> " + compresStr("aabbcdd"));
		System.out.println("" + " -> " + compresStr(""));
	}
}
