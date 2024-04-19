import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * noOfIsland
 */
public class noOfIsland {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList('1', '1', '1', '1', '0')));
        list.add(new ArrayList<>(Arrays.asList('1', '1', '0', '1', '0')));
        list.add(new ArrayList<>(Arrays.asList('1', '1', '0', '0', '0')));
        list.add(new ArrayList<>(Arrays.asList('0', '0', '0', '0', '0')));
        System.out.println(findingIsland(list));
    }

    public static int findingIsland(ArrayList<ArrayList<Character>> list)
    {
        int noOfIsland = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if(list.get(i).get(j) == '1')
                {
                    noOfIsland++;
                    helper(i, j, list);
                }
                
            }            
        }
        return noOfIsland;
    }

    public static void helper(int row, int col, ArrayList<ArrayList<Character>> list)
    {
        if(row < 0 || row >= list.size() || col < 0 || col >= list.get(row).size() || list.get(row).get(col) != '1')
            return;

        list.get(row).set(col, '0');
        helper(row - 1, col, list);
        helper(row + 1, col, list);
        helper(row , col - 1, list);
        helper(row , col + 1, list);    
    }

}