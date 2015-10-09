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
        return list.get(cur++);
    }

    public boolean hasNext() {
        return cur < list.size();
    }
}

// Iterator only solution:
public class Vector2D {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    
    public Vector2D(List<List<Integer>> vec2d) {    
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}
