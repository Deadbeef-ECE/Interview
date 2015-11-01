
public class KMP {
	public static void main(String[] args){
		String p = "ababc";
		String t = "abababacabbababcd";
		System.out.println("Match start at " + KMP(p, t));
	}
	
	public static int KMP(String p, String t){
		int[] lps = new int[p.length()];
		computeLps(p, lps);
		for(int n : lps)
			System.out.print(n+" ");
		int i = 0, j = 0;
		while(i < t.length()){
			if(t.charAt(i) == p.charAt(j)){
				i++; j++;
			}
			
			if(j == p.length()){
				return i - j;
				// if we need to find all 
				// j = lps[j-1];
			}else if (i < t.length() && t.charAt(i) != p.charAt(j)){
				if(j != 0)
					j = lps[j-1];
				else
					i = i + 1;
			}
		}
		return -1;
	}
	
	private static void computeLps(String p, int[] lps){
		lps[0] = 0;
		int i = 1, j = 0;
		while(i < p.length()){
			if(p.charAt(i) == p.charAt(j)){
				lps[i] = j+1;
				j++;i++;
			}else{
				if(j != 0)
					j = lps[j-1];
				else
					lps[i++] = 0;
			}
		}
	}
}
