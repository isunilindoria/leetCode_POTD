import java.util.*;

/**
 * minHeightTrees
 */

public class minHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, List<int[]> edges) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] list2 : edges) {
            int u = list2[0];
            int v = list2[1];
            list.get(u).add(v);
            list.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                q.add(i);

        }

        int remainingLeaf = n;

        while (remainingLeaf > 2) {
            int leafLevel = q.size();
            remainingLeaf -= leafLevel;

            for (int i = 0; i < leafLevel; i++) {
                int leaf = q.poll();

                for (int it : list.get(leaf)) {
                    degree[it]--;
                    if (degree[it] == 1) {
                        q.add(it);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[] { 3, 0 });
        edges.add(new int[] { 3, 1 });
        edges.add(new int[] { 3, 2 });
        edges.add(new int[] { 3, 4 });
        edges.add(new int[] { 5, 4 });

        List<Integer> ans = findMinHeightTrees(6, edges);
        System.out.println(ans);
    }
}