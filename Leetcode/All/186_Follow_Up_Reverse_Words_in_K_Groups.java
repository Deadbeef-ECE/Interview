public solution{
    public static void reverseWordsKgroups(char[] s, int k) {
        reverse(s, 0, s.length-1);
        //reverse single word one by one
        int start = 0;
        int cnt = 0;
        for(int i = 0; i <= s.length; i++){
            if(i == s.length || s[i] == ' '){
                cnt++;
                if(cnt % k == 0){
                    reverse(s, start, i-1);
                    start = i+1;
                }
                if(cnt % k != 0 && i == s.length)
                    reverse(s, start, s.length-1);
            }
        }
    }

    private static void reverse(char[] s, int start, int end){
        while(start < end){
            char c = s[start]; s[start] = s[end]; s[end] = c;
            end--; start++;
        }   
    }

    public static void main(String[] args){
        String str = "How are you doing today";
        char[] arr = str.toCharArray();
        reverseWordsKgroups(arr, 2);
    }
}