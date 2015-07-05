public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();
        int num = words.length;
        int i = 0;
        while(i < num){
            int rowLen = 0, j = i;
            while(j < num && rowLen + words[j].length() <= L)
                rowLen += (words[j++].length() + 1);
            // j - i是该行放入的单词的数目，如果该行只有一个单词的情况
            if(j - i == 1){
                StringBuilder tmp = new StringBuilder(words[i]);
                addSpace(tmp, L - words[i].length());
                ret.add(tmp.toString());
                i = j;
                continue;
            }
            // 每个word后面都有一个空格，
            // charLen为当前行剔除空格后所有字母的长度
            int charLen = rowLen - (j - i);
            // j < num的话意味着不是最后一行
            int meanSpace = j < num ? (L - charLen) / (j - i - 1) : 1;
            // 多余的空格
            int leftSpace = j < num ? (L - charLen) % (j - i - 1) : L - charLen - (j - i - 1);
            StringBuilder temp = new StringBuilder();
            for(int k = i; k < j - 1; k++){
                temp.append(words[k]);
                addSpace(temp, meanSpace);
                if(j < num && leftSpace > 0){
                    temp.append(" ");
                    leftSpace--;
                }
            }
            temp.append(words[j-1]);
            if(leftSpace > 0)   addSpace(temp, leftSpace);
            ret.add(temp.toString());
            i = j;
        }
        return ret;
    }
    private void addSpace(StringBuilder str, int count){
        for(int i = 1; i <= count; i++){
            str.append(" ");
        }
    }
}