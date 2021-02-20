class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Declare a list to store appeared intersection
        List<Integer> list = new ArrayList<>();
        // Sort two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // Declare two pointers
        int pointer1 = 0;
        int pointer2 = 0;
        // Iterate while two pointers both inside each array
        while(pointer1 < nums1.length && pointer2 < nums2.length){
            // if we find equal element and the element is not contained in ArrayList
            if(nums1[pointer1] == nums2[pointer2] && !list.contains(nums1[pointer1])){
                // add this number to list
                list.add(nums1[pointer1]);
                // Increment two pointers
                pointer1++;
                pointer2++;
            }
            // Increment the smaller element's pointer
            else if(nums1[pointer1] < nums2[pointer2]){
                pointer1++;
            }
            else{
                pointer2++;
            }    
        }
        // Turn the ArrayList to Array;
        int[] res = list.stream().mapToInt(i->i).toArray();
        return res;
        
    }
}