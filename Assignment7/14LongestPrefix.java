class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Boundary Conditions
        if(strs == null || strs.length == 0) return "";
        
        if(strs.length == 1) return strs[0];
        
        String res = "";
        Arrays.sort(strs,(s1,s2) -> s1.length()-s2.length());
        

        for(int i = 0 ; i < strs[0].length();i++){
            res += strs[0].charAt(i);
            for(String s: strs){
                if(!s.startsWith(res)){
                    if(res.length() == 1){
                        return "";
                    }
                    else{
                        return res.substring(0,res.length()-1);
                    }
                }
            }
        }
        return res;
    }
}