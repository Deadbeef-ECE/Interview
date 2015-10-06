/* 题意:
 * 设计两个API, 能把list<String> encode成String, 同时可以把String decode回来
 * 
 * solution:
 * len + "#" + str + "#"
 */

public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s).append("#");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new LinkedList<String>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '#')  continue;
            int len = Integer.valueOf(s.substring(start, i));
            String str = s.substring(i+1, i+1+len);
            i = i + 1 + len + 1;
            start = i;
            ret.add(str);
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));