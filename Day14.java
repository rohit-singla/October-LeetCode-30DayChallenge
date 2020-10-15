class Solution {
    
    //code for House Robber problem
    public int helper(int[] nums, int start, int end) {
        if(start == end)
            return nums[start];
        if(start == end - 1)
            return Math.max(nums[start],nums[end]);

        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start + 1]);
        
        for(int i = 2; i < dp.length; i++)
            dp[i]= Math.max(nums[start + i]+dp[i - 2], dp[i - 1]);

        return dp[dp.length-1];
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0 || nums == null)
            return 0;
        if(n == 1)
            return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
}