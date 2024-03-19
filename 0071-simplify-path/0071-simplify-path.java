class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] sr = path.split("/");
        for (String s : sr) {
            if (!st.isEmpty() && s.equals("..")) {
                st.pop();
            } else if (!s.equals(".") && !s.isEmpty() && !s.equals("..")) {
                st.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }
        
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
