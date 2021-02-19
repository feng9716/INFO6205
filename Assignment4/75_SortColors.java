class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        int[] count = new int[3];
        for(int i: nums){
            count[i] ++;
        }
        
        int index = 0;
        for(int i = 0; i < count.length;i++){
            while(count[i] > 0){
                nums[index++] = i;
                count[i]--;
            }
        }
    }
}