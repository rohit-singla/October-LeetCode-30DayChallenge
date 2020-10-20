public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if (n <= 1 || k <= 0) return 0;

        if (2 * k >= n) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        
        int T[][] = new int[k+1][prices.length];
        for (int i = 1; i < T.length; i++) {
            int maxDiff = -1 * prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[k][prices.length-1];
    }
}