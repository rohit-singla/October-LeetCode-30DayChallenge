class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        int count = 0;
        for (Map.Entry m : map.entrySet()) {
            Integer key = (Integer)m.getKey();
            if(k == 0){
                if(map.get(key) > 1)
                    count++;
            }
            else if(map.containsKey(key + k))
                count++;
        }
        return count;
    }
}