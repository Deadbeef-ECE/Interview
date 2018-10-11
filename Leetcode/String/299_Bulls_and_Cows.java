class Solution {
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int bulls = 0;
        for(int i = 0; i < secret.length(); i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b){
                bulls++;
            }else{
                s[a - '0']++;
                g[b - '0']++;
            }
        }
        int cows = 0;
        for(int i = 0; i < 10; i++)
            cows += Math.min(s[i], g[i]);
        
        return bulls+"A"+cows+"B";
    }
}