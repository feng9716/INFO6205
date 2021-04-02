public class Solution {

    public static void main(String[] args) {
	// write your code here
        int[] nums_2 = {0,1,0,1,1,0,0,0,0}; // 2
        System.out.println(getMaxConsecutiveOnes(nums_2));

        int[] all_1 = {1,1,1,1,1,1,1,1,1,1,1,1,1}; // 13
        System.out.println(getMaxConsecutiveOnes(all_1));

        int[] empty = {};
        System.out.println(getMaxConsecutiveOnes(empty));

        int[] nums_0 = {0,0,0,0,0};
        System.out.println(getMaxConsecutiveOnes(nums_0));
    }

    //Time Complexity: O(n) we need to iterate the whole array
    //Space Complexity: O(1) we are not using extra space to store data;
    public static int getMaxConsecutiveOnes(int[] nums){
        int max_count = 0, count = 0;
        for(int i: nums){
            if(i == 1){
                count++;
            }
            else{
                count = 0;
            }
            if(count > max_count){
                max_count = count;
            }
        }
        return max_count;
    }
}
