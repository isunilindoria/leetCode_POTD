import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * nthTribonacci
 */
public class nthTribonacci {
    private HashMap<Integer, Integer> mpp = new HashMap<>();

    public static void main(String[] args) {
        nthTribonacci sol = new nthTribonacci();
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        n = input.nextInt();
        System.out.println("Nth Tribonacci is " + sol.finding(n));
    }

    public int finding(int n)
    {
        if(mpp.containsKey(n)) return mpp.get(n);

        int result;

        if(n == 0) result = 0;
        else if(n == 1 || n == 2) result = 1;
        else result = finding(n-1) + finding(n-2) + finding(n - 3);
        mpp.put(n, result);
        return result;
    }
}