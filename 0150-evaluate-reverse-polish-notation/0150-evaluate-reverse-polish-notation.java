class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (!st.isEmpty() && (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
                int uppertop = Integer.parseInt(st.pop()); 
                int innertop = Integer.parseInt(st.pop());
                int item = 0;
                if (token.equals("+")) {
                    item = innertop + uppertop;
                } else if (token.equals("-")) {
                    item = innertop - uppertop;
                } else if (token.equals("*")) {
                    item = innertop * uppertop;
                } else if (token.equals("/")) {
                    item = innertop / uppertop;
                }
                st.push(String.valueOf(item));
            } else {
                st.push(token);
            }
        }
        
        int ret = !(st.isEmpty()) ? Integer.parseInt(st.pop()) : 0;
        return ret;
    }
}
