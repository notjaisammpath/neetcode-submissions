class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String k : tokens) {
            try {
                int i = Integer.parseInt(k);
                st.push(i);
            } catch (Exception e) {
                int b = st.pop();
                int a = st.pop();
                switch (k) { 
                    case "+":
                        st.push(a + b);
                        break;
                    case "-":
                        st.push(a - b);
                        break;
                    case "/":
                        st.push(a / b);
                        break;
                    case "*":
                        st.push(a * b);
                        break;
                }
            }
        }
        return st.pop();
    }
}
