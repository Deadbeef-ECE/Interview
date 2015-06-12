
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x < 0)   return false;
        int probe = 1;
        while(x/probe >= 10)
            probe *= 10;
            
        while(probe > 1){
            int left = x / probe;
            int right = x % 10;
            if(left != right)
                return false;
            x = (x - left*probe) / 10;
            probe /= 100;
        }
        return true;
	}
	
	public static void main(String[] args){
		int x0 = 12321;
		int x1 = 12222;
		int x2 = 0;
		System.out.println("is x0 palindrome number? "+ isPalindrome(x0));
		System.out.println("is x1 palindrome number? "+ isPalindrome(x1));
		System.out.println("is x2 palindrome number? "+ isPalindrome(x2));

	}
}
