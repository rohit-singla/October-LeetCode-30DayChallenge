class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        rec(ans,0,candidates,new ArrayList(),target);
        return ans;
    }
    
    void rec(List<List<Integer>> ans,int index,int[] arr,List<Integer> current,int target){
        
        if(target<0)return;
        if(target==0){
            ans.add(new ArrayList(current)); 
            return;
        }

        for(int i=index;i<arr.length;i++){
            current.add(arr[i]);
            rec(ans,i,arr, current,target-arr[i]);
            current.remove(current.size()-1);           
        } 
    }
}