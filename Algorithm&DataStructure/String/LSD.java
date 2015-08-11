// @breif: LSD Class
// @reference: Princeton Algorithm book P.458

public class LSD {
	public static void sort(String[] a, int w){
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = w - 1; d >= 0; d--){
			int[] count = new int[R+1];
			for(int i = 0; i < N; i++){
				count[a[i].charAt(d) + 1]++;
			}
			
			
			for(int r = 0; r < R; r++){
				count[r+1] += count[r];
			}
			
			for(int i = 0; i < N; i++){
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			
			for(int i = 0; i < N; i++)
				a[i] = aux[i];
		}
	}
	
	
	public static void main(String[] args){
		String[] a = {"4PGC938", "2IYE230", "3CIO720", "1ICK750", "10HV846", "4JZY524", "1ICK750",
				"3CI0720", "10HV845", "10HV845", "2RLA629", "2RLA629", "3ATW723"};
		printStringArr(a);
		sort(a, a[0].length());
		printStringArr(a);
	}

	private static void printStringArr(String[] a){
		for(String str : a){
			System.out.println(str);
		}
		System.out.println();
	}
}
