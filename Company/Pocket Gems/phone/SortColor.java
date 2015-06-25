import java.util.Comparator;
import java.util.Arrays;

// Red, White, Blue
public class SortColor {
	public enum Color{
		RED(0),
		WHITE(1),
		BLUE(2);
		private int value;
		Color(int x){
			this.value =x;
		}
	}
	
	// O(n) solution: Red, White, Blue
	public static void sortColor(Color[] colors){
		if(colors == null || colors.length == 0)
			return;
		int Red = 0;
		int Blue = colors.length-1;
		int i = 0;
		while(i <= Blue){
			if(colors[i].value == 0){
				swap(colors, i, Red);
				i++;
				Red++;
			}else if(colors[i].value == 2){
				swap(colors, i, Blue);
				Blue--;
			}else{
				i++;
			}
		}
		return;
	}
	
	public static void swap(Color[] colors, int a, int b){
		Color temp = colors[a];
		colors[a] = colors[b];
		colors[b] = temp;
	}
	
	// O(nlogn) solution with comparator
	public static void sortColorWithComparator(Color[] colors){
		if(colors == null || colors.length == 0)
			return;
		Arrays.sort(colors, new ColorComparator());
	}
    
	public static class ColorComparator implements Comparator<Color>{
		public int compare(Color o1, Color o2){
			return o1.value - o2.value;
		}
	}

	public static void main(String[] args){
		Color[] colors ={Color.BLUE,Color.WHITE,Color.WHITE,Color.RED, Color.BLUE,Color.RED,Color.RED,Color.WHITE};
		printColors(colors);
		sortColor(colors);
		//sortColorWithComparator(colors);
		printColors(colors);
	}
	
	public static void printColors(Color[] colors){
		for(Color c : colors){
			System.out.print(c+" ");
		}
		System.out.println();
	}
}
