public class Solution {
    // DFS Recursion:
    
    // O(n * 4^n) OR O(n * 3^p*4^q) time
    // Explanation:
    // O(n * num of sols) time
    // n is the toString() API time complexity which is the same length as input
    // 
    // num of sols:
    // O(4^n)
    // n is the length of input digits
    // 
    // OR O(3^p*4^q) solutions
    // p is the number of digits which has 3 corresponding letters
    // q is the number of digits which has 4 corresponding letters

    // O(n) space
    // Explanation:
    // first n is the recursion stack
    // second n is the space complextiy of toString()
    // 即便total sulion的个数是4^n, 每个solution在调用toString()时要开辟O(n)的空间,
    // 但调用完会被回收, 所以total space还是n, 其原理跟recursion stack类似

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        if(digits == null || digits.length() == 0)    
            return ret;
        String[] table = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder path = new StringBuilder();

        doDFS(digits, 0, path, ret, table);

        return ret;
    }

    private void doDFS(String digits, int pos, StringBuilder path, 
        List<String> ret, String[] table){
        if(pos == digits.length()){
            // O(n) space and O(n) time for toString() API and called for 
            // each solution, n is the length of input digits
            ret.add(path.toString());
            return;
        }
        
        String letters = table[digits.charAt(pos) - '2'];
        for(int i = 0; i < letters.length(); i++){
            path.append(letters.charAt(i));
            doDFS(digits, pos + 1, path, ret, table);
            path.deleteCharAt(path.length() - 1);
        }
    }

    // Iteration:
    // O(4^n) OR O(3^p*4^q) time
    // Explanation: 
    // n is the total number of digits
    // OR p is the number of digits which has 3 corresponding letters
    //    q is the number of digits which has 4 corresponding letters
    //
    // let's assume all the number has 4 corresponding letters
    // the time complexity should be:
    // O(4 + 4^1 + 4^2 +.... + 4^n) then, 等比数列求和, 是O(4^n)
    //
    // 注: 实际验证的时候, 发现iteration在n小于一定个数时, 确实跑的比DFS快, 但是当n
    //    大于7的时候, 反而iteration时间更长, 原因之一是cache miss增多造成的delay
    //
    // O(1) space if does not count return list as extra space
    // O(n * 4^n) OR O(n * 3^p*4^q) return list space
    // Explanation: 
    // only consider the return list space here
    // n is the length of digits
    // OR p is the number of digits which has 3 corresponding letters
    //    q is the number of digits which has 4 corresponding letters

    public List<String> letterCombinations2(String digits) {
        List<String> list = new LinkedList<String>();
        if(digits == null || digits.length() == 0)    
            return list;
        String[] table = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for(int i = 0; i < digits.length(); i++){
            String letters = table[digits.charAt(i) - '2'];
            int size = list.size();
            for(int j = 0; j < size; j++){
                String temp = list.remove(0);
                for(int k = 0; k < letters.length(); k++){
                    list.add(temp + letters.charAt(k));
                }
            }
        }
        return list;
    }
}