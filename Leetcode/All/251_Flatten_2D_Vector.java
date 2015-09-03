public class Vector2D {
    private List<Integer> list;
    private int cur;
    public Vector2D(List<List<Integer>> vec2d) {
        list = new LinkedList<Integer>();
        for(List<Integer> l : vec2d){
            for(Integer n : l){
                list.add(n);
            }
        }
        cur = 0;
    }

    public int next() {
        int ret = list.get(cur);
        cur++;
        return ret;
    }

    public boolean hasNext() {
        return cur < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */