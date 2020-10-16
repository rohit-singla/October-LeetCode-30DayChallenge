class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

                                        OR

class Solution {
    public boolean binary(int[] arr, int target){
        int start = 0, mid = 0, end = arr.length - 1;
        while(start <= end){
            mid = (start + end) / 2;
            if(arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i].length >= 1 && matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target)
                return binary(matrix[i], target);
        }
        return false;
    }
}