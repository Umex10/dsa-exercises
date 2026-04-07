import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numbers = new HashMap<>();
        List<Integer> result = new ArrayList()<>();

        for (int i = 0; i < nums1.length; i++) {

            numbers.merge(nums1[i], 1, (oldValue, one) -> oldValue + one);

        }

        for (int i = 0; i < nums2.length; i++) {
   
            numbers.computeIfPresent(nums2[i], (k, val) -> {
                if (val > 0) {
                    result.add(k);
                }
                return val - 1;
            });

        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}