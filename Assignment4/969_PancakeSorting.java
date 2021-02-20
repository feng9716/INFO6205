class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        if(isSorted(arr)) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        // Since the array is a partition,
        // We iterate from max and decreament to 1
        
        // In each iteration, we first move current unsorted max to index = 0;
        // then reverse subarray 0 to max-1
        // This will remove current unsorted max to correct position
        for(int max = arr.length; max > 0 ; max--){
            for(int i = 0 ; i < arr.length;i++){
                if(arr[i] == max){ // After we find the max and index i
                    // Add the index + 1 to  res List
                    res.add(i+1);
                    // swap 1st time, now max should be at index = 0
                    reverse(arr,i);
                    if(isSorted(arr)) return res;
                    
                    // swap second, now max should be at correct position
                    // index = max - 1
                    res.add(max);
                    reverse(arr,max-1);
                    if(isSorted(arr)) return res;
                    break;
                }
            }
        }
        return res;
    }
    
    // check if the arr is sorted
    public boolean isSorted(int[] arr){
        for(int i = 0 ; i < arr.length-1;i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
    // reverse sub array of arr from 0 to k;
    public void reverse(int[] arr, int k){
        int left = 0,right = k;
        while(left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
}