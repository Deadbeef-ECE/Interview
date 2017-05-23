public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)    return s;
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j){
            if(!isVowel(arr[i])){
                i++; 
                continue;
            }
            if(!isVowel(arr[j])){
                j--;
                continue;
            }
            swap(arr, i++, j--);
        }
        return new String(arr);
    }
    public void swap(char[] arr, int i, int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    public boolean isVowel(char a){
        char b = Character.toLowerCase(a);
        return b == 'a' || b == 'e' || b == 'i' || b == 'o' || b =='u';
    }
}