import java.util.ArrayList;
import java.util.*;

/**
 * findingPathInGraph
 */
public class findingPathInGraph {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(0, 1));
        list.add(List.of(1, 2));
        list.add(List.of(2, 0));

        System.out.println("The path between the source and destination is " + validPath(list, 3, 0, 2));
    }

    public static boolean validPath(List<List<Integer>> list, int n, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (List<Integer> list2 : list) {
            int u = list2.get(0);
            int v = list2.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<Integer> vis = new HashSet<>();

        return helper(graph, vis, source, destination);
    }

    public static boolean helper(HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> vis, int node,
            int destination) {
        if (node == destination)
            return true;
        vis.add(node);
        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if (!vis.contains(neighbour)) {
                if (helper(graph, vis, neighbour, destination))
                    return true;
            }
        }
        return false;
    }
}