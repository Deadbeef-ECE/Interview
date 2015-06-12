//parameters: character array, integer representing the length of the array
//function should print the contents of the array in sorted order
//array contains only lower case letters

//example - bbcdezzaab --->   aabbbcdezz
public class SortCharArray {
	public static void sortCharArray(char[] arr, int length) {
	    int[] count = new int[26];

	    for(int i = 0; i < length; i++) {
	        char c = arr[i];
	        if(c < 'a' || c > 'z') {
	            System.out.println("There is illegal letter!");
	            return;
	        }
	        int index = c - 'a';
	        count[index]++;
	    }

	    for(int j = 0; j < 26; j++) {
	        for(int m = 0; m < count[j]; m++) {
	            System.out.print((char)(j+'a'));
	        }
	    }
	    return;
	}
	
	public static void main(String[] args){
		char[] arr = {'b','b','c','d','e','z','a','z','a'};
		sortCharArray(arr, arr.length);
	}
}
