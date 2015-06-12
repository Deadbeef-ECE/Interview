
public class atoi {
    public static int myAtoi(String str) {
        if(str == null || str.length() < 1)
            return 0;
        
        str = str.trim();
        if(str.length() == 0)
            return 0;
        
        boolean isNeg = false;
        int i = 0;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            if(str.charAt(i) == '-')
                isNeg = true;
            i++;
        }
        
        int ret = 0;
        while(i < str.length()){
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            int digit = (int)(str.charAt(i) - '0');
            if(isNeg && ret > -((Integer.MIN_VALUE + digit)/10))
                return Integer.MIN_VALUE;
            if(!isNeg && ret > (Integer.MAX_VALUE - digit)/10)
                return Integer.MAX_VALUE;
            ret = 10*ret + digit;
            i++;
        }
        return isNeg ? -ret : ret;
    }
    
    public static void main(String[] args){
    	String str0 = "+4341434.123";
    	String str1 = "-24424.22";
    	String str2 = "2434";
    	String str3 = "42342342323";
    	String str4 = "-642342342343";
    	System.out.println("atoi(" + str0 +")" + " = " + myAtoi(str0));
    	System.out.println("atoi(" + str1 +")" + " = " + myAtoi(str1));
    	System.out.println("atoi(" + str2 +")" + " = " + myAtoi(str2));
    	System.out.println("atoi(" + str3 +")" + " = " + myAtoi(str3));
    	System.out.println("atoi(" + str4 +")" + " = " + myAtoi(str4));
    }
}
