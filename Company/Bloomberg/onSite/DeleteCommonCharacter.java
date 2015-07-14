package onsite;
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=136563&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
public class DeleteCommonCharacter {
	public static int[] DeleteCommonChars(String str1, String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		int[] ret = {len1, len2};
		if(len1 == 0 || len2 == 0)
			return ret;
		int[] map1 = new int[256];
		int[] map2 = new int[256];
		int[] dup = new int[256];
		for(int i = 0; i < str1.length(); i++)
			map1[str1.charAt(i)]++;

		for(int i = 0; i < str2.length(); i++){
			if(map1[str2.charAt(i)] > 0)	dup[str2.charAt(i)]++;
			map2[str2.charAt(i)]++;
		}
		for(int i = 0; i < 256; i++){
			if(dup[i] > 0){
				ret[0] -= map1[i]; ret[1] -= map2[i];
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		//int[] ret = DeleteCommonChars("aaabbcccdddffff", "bcddde");
		int[] ret = DeleteCommonChars("bcdddde", "bcddde");

		System.out.println("[" + ret[0] + ", "+ ret[1]+"]");
	}
}
