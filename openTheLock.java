import java.util.*;

public class openTheLock {

    static class lockState {
        String state;
        int turns;

        public lockState(String state, int turns)
        {
            this.state = state;
            this.turns =turns;
        }           
    }


    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println("Minimum turns: " + findingTurns(deadends, target));
    }
    

    public static int findingTurns(String[] deadends, String target)
    {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends)); 
        Set<String> vis = new HashSet<>();
        Queue<lockState> q = new LinkedList<>();

        String start = "0000";
        if(dead.contains(start)) return -1;
        vis.add(start);
        q.offer(new lockState(start, 0));

        while (!q.isEmpty()) {
            lockState curr = q.poll();

            if(curr.state.equals(target)) return curr.turns;

            for (int i = 0; i < 4; i++) {
                String s1 = curr.state.substring(0, i) +
                            (char)((curr.state.charAt(i) - '0' + 1) % 10 + '0') + 
                            curr.state.substring(i+1);

                String s2 = curr.state.substring(0, i) + 
                            (char)((curr.state.charAt(i) - '0' - 1) % 10 + '0') + 
                            curr.state.substring(i+ 1);

                if(!vis.contains(s1) && !dead.contains(s1))
                {
                    vis.add(s1);
                    q.offer(new lockState(s1, curr.turns + 1));
                }

                if(!vis.contains(s2) && !dead.contains(s2))
                {
                    vis.add(s2);
                    q.offer(new lockState(s2, curr.turns + 1));
                }
                
            }
            
        }
        return -1;
    }
}