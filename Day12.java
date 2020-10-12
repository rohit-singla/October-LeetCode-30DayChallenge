class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        int count = 0;
        char f='a', s='b';
        int ch[] = new int[26];
        for(int i = 0; i < A.length(); i++){
            ch[A.charAt(i) - 'a']++;
            if(A.charAt(i) != B.charAt(i)){
                count++;
                if(count == 1){
                    f = A.charAt(i);
                    s = B.charAt(i);
                    System.out.println(count + " " + f + " " + s);
                }
                else if(count == 2){
                    System.out.println(count + " " + f + " " + s);
                    if(B.charAt(i) != f || A.charAt(i) != s) return false;
                }
                if(count > 2) return false;;
            }
        }
        if(count == 0){
            for(int i = 0; i < 26; i++){
                if(ch[i] > 1)
                    return true;
            }
            return false;
        }
        else if(count == 1) return false;
        else return true;
    }
}

                                               OR

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        
        if(A.equals(B)){ //if count == 0
            Set<Character> unique = new HashSet<>();
            for(char c : A.toCharArray()) unique.add(c);
            if(unique.size() < A.length()) return true; //contains duplicate characters
            else return false;
        }
        
        int count = 0, prev = -1, curr = -1;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                count++;
                if(count > 2) return false;
                prev = curr;
                curr = i;
            }
        }
        return (count ==2 && A.charAt(prev) == B.charAt(curr) && A.charAt(curr) == B.charAt(prev));
    }
}