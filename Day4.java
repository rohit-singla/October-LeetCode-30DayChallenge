class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int i = 0, j = 0, count = intervals.length;
        for(i = 0; i < intervals.length; i++){
            for(j = 0; j < intervals.length; j++){
                if(i!=j && intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}