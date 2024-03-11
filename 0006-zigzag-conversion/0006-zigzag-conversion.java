class Solution {
    public String convert(String s, int numRows) {
        String[] st = new String[numRows];

        // Initialize each element in the array to an empty string
        for (int i = 0; i < numRows; i++) {
            st[i] = "";
        }

        char[] ch = s.toCharArray();
        int j = 0;

        while (j < s.length()) {
            for (int idx = 0; idx < numRows && j < ch.length; idx++) {
                st[idx] += ch[j++];
            }
            for (int idx = numRows - 2; idx > 0 && j < ch.length; idx--) {
                st[idx] += ch[j++];
            }
        }

        for (int i = 1; i < numRows; i++) {
            st[0] += st[i];
        }

        return st[0];
    }
}
