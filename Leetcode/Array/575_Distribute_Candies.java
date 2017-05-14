public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<Integer>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}