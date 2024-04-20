import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * farmland
 */
public class farmland {
    public static void main(String[] args) {
        farmland sol = new farmland();
        List<List<Integer>> land = new ArrayList<>();
        land.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
        land.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        land.add(new ArrayList<>(Arrays.asList(0, 1, 1)));

        List<List<Integer>> ans = sol.findFarmland(land);
        for(List<Integer> res : ans)
        {
            System.out.println(res);
        }

        
    }

    public List<List<Integer>> findFarmland(List<List<Integer>> land)
    {
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < land.size(); i++) {
            for (int j = 0; j < land.get(i).size(); j++) {
                if (land.get(i).get(j) == 1) {
                    int[] rc = new int[]{i, j};
                    dfs(i, j, rc, land);
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    res.add(rc[0]);
                    res.add(rc[1]);
                    ans.add(res);                  
                    
                }
                
            }
            
        }
        return ans;
    }
    
    public void dfs(int row, int col, int[]rc, List<List<Integer>>land)
    {
        if(row >= land.size() || col >= land.get(row).size() || land.get(row).get(col) != 1 )
            return;
        land.get(row).set(col, 0);
        rc[0] = Math.max(rc[0], row);
        rc[1] = Math.max(rc[1], col);
        dfs(row + 1, col, rc, land);
        dfs(row , col + 1, rc, land);
    }
    
}