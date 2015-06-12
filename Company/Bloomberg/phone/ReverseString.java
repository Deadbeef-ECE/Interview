import java.util.LinkedList;
import java.util.List;


public class ReverseString {
	// The input string contains leading or trailing spaces 
	// and the words are always separated by a single space.
	public static String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        s = s.trim();
        String[] words = s.split(" ");
        String ret = "";
        for(int i = words.length - 1; i >= 0; i--){
            if(!words[i].isEmpty())
                ret += " " + words[i];
        }
        return ret.trim();
    }
	// No split
	public static String reverseWordsNoSplit(String s) {
        if(s == null || s.length() == 0)
            return s;
        List<String> words= new LinkedList<String>();
        int start = 0; int end = 0;
        while(end < s.length()){
        	while(end < s.length() && s.charAt(end) == ' '){
        		end++;
        	}
        	start = end;
        	while(end < s.length() && s.charAt(end) != ' '){
        		end++;
        	}
        	//System.out.println(start + ", "+end);
        	String word = s.substring(start, end);
        	//System.out.println(word);
        	words.add(word);
        	start = end;
        }
        String ret = "";
        for(int i = words.size() - 1; i >= 0; i--){
                ret += " " + words.get(i);
        }
        return ret.trim();
    }
	
	// No split No Extra Mem
	public static String reverseWordsNoSplitNoExtraMem(String s) {
        if(s == null || s.length() == 0)
            return s;
        String ret = "";
        int start = 0; int end = 0;
        while(end < s.length()){
        	while(end < s.length() && s.charAt(end) == ' '){
        		end++;
        	}
        	start = end;
        	while(end < s.length() && s.charAt(end) != ' '){
        		end++;
        	}
        	//System.out.println(start + ", "+end);
        	String word = s.substring(start, end);
        	//System.out.println(word);
        	ret = " "+word + ret;
        	//words.add(word);
        	start = end;
        }
        return ret.trim();
    }
	// The input string does not contain leading or trailing spaces 
	// and the words are always separated by a single space.
	public static void reverseWords2(char[] s) {
        if(s == null || s.length == 0)
            return;
        reverse(s, 0, s.length - 1);
        int start = 0;
        for(int i = 0; i <= s.length; i++){
            if(s.length == i || s[i] == ' '){
                reverse(s, start, i-1);
                start = i+1;
            }
        }
    }
    
    private static void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args){
    	String s = " Hello  From Bloomberg ! ";
    	String s2 = "          ! ";
    	String s3 = "   ";
    	String ret = reverseWordsNoSplitNoExtraMem(s);
    	String ret2 = reverseWordsNoSplitNoExtraMem(s2);
    	String ret3 = reverseWordsNoSplitNoExtraMem(s3);
    	System.out.println("Original string["+s+']');
    	System.out.println("ret["+ret+"]");
    	System.out.println("Original string["+s2+"]");
    	System.out.println("ret["+ret2+"]");
    	System.out.println("Original string["+s3+"]");
    	System.out.println("ret["+ret3+"]");
    }
}
