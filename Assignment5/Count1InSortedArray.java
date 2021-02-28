public class Count1InSortedArray{
    public static void main(String[] args) {
        //int[] arr ={10,9,8,8,7,5,4,3,2,1};
        //int[] arr = {1, 1, 0, 0, 0, 0, 0};
        int[] arr = {3,2,1,1, 1, 0, 0, 0, 0, 0};
        System.out.println(count1s(arr));
    }

    public static int count1s(int[] arr){
        int res = 0;
        int left= 0 , right = arr.length-1;


        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[left] == 1 && arr[right]== 1){
                return right - left + 1;
            }
            if(arr[mid] > 1){
                left = mid + 1;
            }
            else if(arr[mid] < 1){
                right = mid - 1;
            }else{
                while(arr[left] != 1){
                    left++;
                }
                while(arr[right] != 1){
                    right--;
                }
            }
        }
        return res;
    }
}