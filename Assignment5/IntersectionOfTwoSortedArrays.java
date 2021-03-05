import java.util.List;
import java.util.*;
class Solution {
    public static void main(String[] args) {
        int arr1[] = {1,2,4,5,6};
        int arr2[] = {2,3,5,7};

        List<Integer> res = intersection(arr1, arr2);
        for(int i : res){
            System.out.print(i + " -> ");
        }
    }
    public static List<Integer> intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        // Create two pointers
        int p1 = 0, p2 = 0;

        while(p1!= nums1.length && p2 != nums2.length){
            if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }
            else{
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        return res;
    }
}