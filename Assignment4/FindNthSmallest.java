public class FindNthSmallest{
    public static void main(String[] args) {
        int[] arr = {6,3,9,8,5,2,7,1,15,4};
        int n = 5;
        int res = findNthSmallest(arr, n, 0, arr.length-1);
        if(res == -1){
            System.out.println(arr[n-1]);
        }
        else{
            System.out.println(res);
        }

        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pos = partition(nums,low,high);
            quickSort(nums,low,pos-1);
            quickSort(nums,pos+1,high);
        }
    }
    
    public static int partition(int[] nums,int low, int high){
        int pivot = nums[high];
        int wall = low - 1;
        for(int i = low ; i < high;i++){
            if(nums[i] < pivot){
                wall++;
                swap(nums,i, wall);
            }
        }
        wall ++;
        swap(nums,high,wall);
        return wall;
    }
    
    public static void swap(int[] arr, int p1,int p2){
        int temp = arr[p2];
        arr[p2] = arr[p1];
        arr[p1] = temp;
    }

    public static int findNthSmallest(int[] arr, int n, int low, int high){
        int result = -1;
        if(low < high){
            int pos = partition(arr, low, high);
            if(pos == n-1){
                return arr[pos];
            }
            result = findNthSmallest(arr, n, low, pos-1);
            if(result != -1) return result;

            result = findNthSmallest(arr, n, pos+1, high);
            if(result != -1) return result;
        }
        
        return -1;
    }
}