public class Solution {
	// Sort and insert
	// O(n^2) time, O(n) space
    public int[][] reconstructQueue(int[][] people) {
        int num = people.length;
        List<int[]> list = new LinkedList<int[]>();
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for(int[] p : people){
            list.add(p[1], p);
        }
        return list.toArray(people);
    }
    // TODO: Binary Indexed Tree solution
}