class Solution {
    
    public ArrayList<Integer> toBinary(int decimal){
        ArrayList<Integer> binary = new ArrayList<>();
        while(decimal > 0){
            binary.add(decimal % 2);
            decimal /= 2;
        }
        return binary;
    } 
    
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        ArrayList<Integer> ar = toBinary(n);
        int ans = 0, p = 0;
        for(int i = 0; i < ar.size(); i++){
            if(ar.get(i) == 0)
                ar.set(i, 1);
            else
                ar.set(i, 0);
            ans += ar.get(i) * Math.pow(2, p);
            p++;
        }
        return ans;
    }
}


                                            OR


class Solution {
    public int bitwiseComplement(int num) {
        if(num == 0) return 1;
        int n = 0, temp = num;
        while(temp != 0){
            temp /= 2;
            n++;
        }
        int p = (int) Math.pow(2,n) - 1;
        return p - num;
    }
}