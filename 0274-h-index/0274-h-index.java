import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int[] arr = new int[citations.length+1];
        int idx = 0;
        for (int citation : citations) {
            if (citation >= arr.length) {
                idx = arr.length - 1;
                arr[idx]++;
            } else {
                idx = citation;
                arr[idx]++;
            }
        }

        // Iterate over the counts array to find the h-index
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            if (sum >= i) {
                return i;
            }
        }

        // If no h-index is found, return 0
        return 0;
    }
}
