class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];  // contains length of incresing subsequence till that index
        int[] cdp = new int[nums.length];  // contains count of LIS 
        
        int maxcount = 0;
        int maxlen = 0;
        
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;  // minimum length = 1
            cdp[i] = 1;  // hence, minimum count would also be 1
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cdp[i] = cdp[j];
                    }
                    else if(dp[j]+1 == dp[i])   // if both LIS are of equal length then just update count
                        cdp[i] += cdp[j];
                }
            }
            if(dp[i] > maxlen){   // if there is new max LIS
                maxlen = dp[i]; // update length
                maxcount = cdp[i];  // update count
            }
            else if(dp[i] == maxlen){  // if there is just another LIS of same length
                maxcount += cdp[i];   // only update the count
            }
        }
        return maxcount;
        
    }
}