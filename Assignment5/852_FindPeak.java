class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int maxi = -1;
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            
            //如果这个点左边更高
            // if left point is higher, we move search area to left
            if( mid != 0 && arr[mid] < arr[mid - 1]){
                end = mid - 1;
            }
            //如果这个点右边更高
            // if right pointer is higher, we move search area to right;
            else if(mid != arr.length - 1 && arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }
            //如果这个点就是最高点
            // else we find the highest point
            else{
                maxi = mid;
                break;
            }
        }
        return maxi;
    }
}