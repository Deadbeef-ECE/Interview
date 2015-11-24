// My own solution
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new LinkedList<String>();
        int start = 0, end = 0;
        int len = 0;
        int charLen = 0;
        for(int i = 0; i < words.length; i++){
            if(len + words[i].length() <= L){
                charLen += words[i].length();
                len += words[i].length();
                if(len < L)
                    len++;  
                continue;
            }
            generateOneLine(words, start, i - 1, charLen, L, ret, false);
            start = i;
            charLen = words[i].length();
            // if the word length is equal to the line length, do not put space after it.
            len = charLen < L ? charLen + 1 : charLen; 
        }
        generateOneLine(words, start, words.length - 1, charLen, L, ret, true);
        return ret;
    }
    
    private void generateOneLine(String[] words, int start, int end, int charLen, int L, List<String> ret, boolean isLast){
        // if this is one-word line
        StringBuilder sb = new StringBuilder();
        if(end == start){
            sb.append(words[start]);
            addSpace(sb, L - words[start].length());
            ret.add(sb.toString());
            return;
        }
        int wordNum = end - start + 1;
        int spaceNum = L - charLen;
        // if this is the last line, space per word is 1
        int spacePerWord = isLast ? 1 : spaceNum / (wordNum - 1);
        // if this is the last line, add the remaining space in the end
        int remainSpace = isLast ? spaceNum - spacePerWord * wordNum + 1: spaceNum % (wordNum - 1);
        for(int i = start; i < end; i++){
            sb.append(words[i]);
            addSpace(sb, spacePerWord);
            // Only distributed remaining space if not the last line
            if(!isLast && remainSpace != 0){ 
                addSpace(sb, 1);
                remainSpace--;
            }
        }
        sb.append(words[end]);
        if(isLast) addSpace(sb, remainSpace); // add the remaing space if last line
        ret.add(sb.toString());
    }
    
    private void addSpace(StringBuilder sb, int spaceNum){
        while(spaceNum > 0){
            spaceNum--;
            sb.append(' ');
        }
    }
}

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


