import javax.management.loading.PrivateClassLoader;
import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        // Create Vertex;
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        Vertex seven = new Vertex(7);
        Vertex eight = new Vertex(8);

        // Create a map to find Vertex by Integer
        HashMap<Integer, Vertex> map = new HashMap();
        map.put(1,one);
        map.put(2,two);
        map.put(3,three);
        map.put(4,four);
        map.put(5,five);
        map.put(6,six);
        map.put(7,seven);
        map.put(8,eight);

        // Connect Vertexes, 1 is the source Vertex
        // 1 -> 2,3,4;
        // 2-> 5 , 6
        // 3 -> 7
        // 4-> 8
        // 5-> 8,7
        // 6-> 8
        one.addEdge(two);
        one.addEdge(three);
        one.addEdge(four);
        two.addEdge(five);
        two.addEdge(six);
        three.addEdge(seven);
        four.addEdge(eight);
        five.addEdge(eight);
        five.addEdge(seven);
        six.addEdge(eight);
        
        //find shortest path to reach all Vertex
        //findMinPath(one,map);
        dfs(one,map);
    }

    // Use dfs to find path and print the path
    // Time Complexity: O(V + E), visited all the Vertex and Edges once
    // Space Complexity: O(1), no extra space is used;
    private static void dfs(Vertex v, HashMap<Integer, Vertex> map){
        // find path until reach a visited Vertex, or a Vertex that has no outward Edge
        // We print the Vertex's num
        if( v.isVisited()){
            return;
        }

        System.out.print(v.num + " -> ");
        v.visited = true;
        for(Edge e: v.listOfEdges){
            if(!map.get(e.end).isVisited()){
                dfs(map.get(e.end),map);
                System.out.print(v.num + " -> ");
            }
            
            
        }

    }

    private static class Vertex{
        public int num;
        public List<Edge> listOfEdges;
        public boolean visited;
        public Vertex parent;

        public Vertex(int num){
            this.num = num;
            listOfEdges = new ArrayList<>();
            visited = false;
            parent = null;
        }

        public void addEdge(Vertex target){
            target.parent = this;
            listOfEdges.add(new Edge(this.num,target.num));
        }

        public void deleteEdge(int destination){
            for(Edge e: listOfEdges){
                if(e.end == destination){
                    listOfEdges.remove(e);
                    return;
                }
            }
        }

        public List<Integer> findAllNeighbors(){
            List<Integer> res = new ArrayList<>();
            for(Edge e: listOfEdges){
                res.add(e.end);
            }

            return res;
        }

        public boolean isVisited(){
            return this.visited;
        }

    }

    private static class Edge{
        public int start, end;

        public Edge(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
