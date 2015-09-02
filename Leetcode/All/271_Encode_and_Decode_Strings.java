/* 题意:
 * 设计两个API, 能把list<String> encode成String, 同时可以把String decode回来
 * 
 * solution:
 * len + "#" + str + "#"
 */

public class Codec {
    public String encode(List<String> strs) {
        StringBuffer ans = new StringBuffer();
        for (String s : strs)
            ans.append(s.length()).append("#").append(s).append("#");
        return ans.toString();
    }

    public List<String> decode(String s) {
        List<String> ans = new LinkedList<String>();
        int i = 0, start = 0;
        while (start < s.length() && (i = s.indexOf("#", start)) != -1) {
            int len = Integer.parseInt(s.substring(start, i));
            i++;
            String str = s.substring(i, i + len);
            ans.add(str);
            start = i + len + 1;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));