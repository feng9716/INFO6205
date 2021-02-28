class Solution {
    public String reorganizeString(String S) {
        // Create a map to count 
        Map<Character,Integer> count = new HashMap<>();
        
        for(int i = 0;i < S.length();i++){
            if(count.get(S.charAt(i)) == null){
                count.put(S.charAt(i),1);
            }
            else count.put(S.charAt(i),count.get(S.charAt(i))+1);
        }
        
        // Create a list for entry, sort the list from most appearance to least
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(count.entrySet());
        list.sort(Map.Entry.comparingByValue());
        
        // Create a char array
        char[] res = new char[S.length()];
        
        //Use index to record place to enter character
        int index = 0;
        for(int i = list.size() - 1; i >= 0;i--){
            // if there is a character's appearance > 1/2 of S.length()
            // return ""
            if(list.get(i).getValue() > (S.length()+1)/2){
                return "";
            }
            
            // Else, add char from most appearance to least
            // each left a gap in between
            while(list.get(i).getValue() > 0){
                res[index] = list.get(i).getKey();
                list.get(i).setValue(list.get(i).getValue()-1);
                index+=2;
                // when index reaches end, start from index 1 again;
                if(index >= res.length){
                    index = 1;
                }
            }
        }

        // Return char[] as a String
        return String.valueOf(res);
    }
}