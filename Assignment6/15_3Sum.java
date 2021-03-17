
class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        
        //Iterate all the numbers in nums[] for 1st int
        for(int i = 0 ; i < nums.length;i++){
            // If our 1st integer is greater than 1, we cannot find any combo that would result in sum = 0, we can break from the loop
            if(nums[i] > 0) break;
            else if(i== 0 || nums[i-1] != nums[i]){
                helper(res,nums,i);
            }
        }
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] nums, int i){
        // Set to store appeared integers without duplicates
        Set<Integer> storage = new HashSet<>();
        for(int j = i+1; j< nums.length;j++){
            int z = 0-nums[i]-nums[j];
            // If the third value appears, we add a List of 3 integers
            if(storage.contains(z)){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(z);
                res.add(new ArrayList<>(temp));
                while(j+1 < nums.length && nums[j+1] == nums[j]){
                    j++;
                }
            }
            //If not, we add 2nd number to the Set
            storage.add(nums[j]);
        }
    }
}