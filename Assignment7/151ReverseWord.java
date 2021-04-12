class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        
        String[] words = s.split("\\s+");
        String res = "";
        for (int i = words.length - 1; i >= 0; i--) {
            
                res = res + words[i];
                if (i != 0)
                    res += " ";
        
            
        }
        return res;
    }
}