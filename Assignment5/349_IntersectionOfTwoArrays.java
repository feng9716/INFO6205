class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // This use Set and List to record duplicate
        Set<Integer> set = new HashSet<>();
        for(int i : nums1) set.add(i);
        List<Integer> array = new ArrayList<>();
        for(int i : nums2){
            if(set.contains(i)){
                array.add(i);
                set.remove(i);
            }
            
        }
        int[] res = new int[array.size()];
        for(int i = 0 ; i < array.size();i++){
            res[i] = array.get(i);
        }
        return res;
        

        
    }
}