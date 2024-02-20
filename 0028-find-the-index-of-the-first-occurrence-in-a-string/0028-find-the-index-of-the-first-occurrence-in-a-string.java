class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0; // Needle is an empty string, so it's always present in the haystack
        }

        int i = 0;
        int j = 0;

        while (j < haystack.length()) {
            if (needle.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
                if (i == needle.length()) {
                    return j - i; // Needle found at index (j - i) in haystack
                }
            } else {
                j = j - i + 1; // Move the pointer in haystack to the next position
                i = 0; // Reset the pointer in needle
            }
        }

        return -1; // Needle not found in haystack
    }
}
