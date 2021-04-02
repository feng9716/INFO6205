import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {2,4,4,4,6,7,8,9,9,9,10,11,12,13,13,15,15};
        System.out.println(Arrays.toString(nums));
        System.out.println("Index of 7 is " + getIndex(nums,7));
        System.out.println("Index of 10 is " + getIndex(nums,10));
        System.out.println("Index of 2 is " + getIndex(nums,2));
        System.out.println("Index of 15 is " + getIndex(nums,15));
        System.out.println("Index of 100 is " + getIndex(nums,100));
        System.out.println();
        int[] fives= {5,5,5,5,5};
        System.out.println(Arrays.toString(fives));
        System.out.println("Index of 5 is: " + getIndex(fives,5));
    }

    // Time Complexity O(log(n)) we used binary search to speed up the search
    //Space Complexity O(1) we did not use extra space to store data
    public static int getIndex(int[] nums, int x){
        // IF not existed in this array, return -1;
        if(x > nums[nums.length -1] || x < nums[0]){
            System.out.print("(The x is not in this array)");
            return -1;
        }

        int index = binary(nums,0,nums.length-1,x);
        while(index != 0 && nums[index] == nums[index -1]){
            index = index -1;
        }
        return index;
    }

    private static int binary(int[] nums, int start, int end, int target){
        int mid = start + (end-start)/2;
        if(target > nums[mid]){
            return binary(nums,mid + 1,end,target);
        }
        else if(target < nums[mid]){
            return binary(nums,start,mid-1,target);
        }
        else{
            return mid;
        }
    }
}
