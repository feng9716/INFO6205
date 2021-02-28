class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // Use a Queue to record the number added
        Queue<Integer> queue = new LinkedList<>();
        // When x is less than or equal to the 1st element
        // we add first k elements in array
        if(x <= arr[0]){
            for(int i = 0 ; i < k;i++){
                res.add(arr[i]);
            }
        }
        // When x is greater than or equal to the last element
        // we add from length - k to last elements in array
        else if(x >= arr[arr.length-1]){
            for(int i = arr.length-k; i<arr.length;i++){
                res.add(arr[i]);
            }
        }
        else{
            for(int i = 0 ; i < arr.length;i++){
                if(queue.size() < k){
                    queue.offer(arr[i]);
                }else{
                    if(Math.abs(arr[i] - x) < Math.abs(queue.peek() - x)){
                        queue.poll();
                        queue.offer(arr[i]);
                    }
                    else if(Math.abs(arr[i] - x) == Math.abs(queue.peek() - x) && arr[i] < queue.peek()){
                        queue.offer(arr[i]);
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}