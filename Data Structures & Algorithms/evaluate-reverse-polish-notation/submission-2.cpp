class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        std::stack<int> st;
        for(std::string s : tokens) {
            int l;
            int r;
            if (s.length() > 1 || isdigit(s[0])) {
                st.push(stoi(s));
                continue;
            }
            switch(s[0]){
                case '+':
                    r = st.top();
                    st.pop();
                    l = st.top();
                    st.pop();
                    st.push(l + r);
                break;

                case '-':
                    r = st.top();
                    st.pop();
                    l = st.top();
                    st.pop();
                    st.push(l - r);
                break;

                case '*':
                    r = st.top();
                    st.pop();
                    l = st.top();
                    st.pop(); 
                    st.push(l * r);
                break;

                case '/':
                    r = st.top();
                    st.pop();
                    l = st.top();
                    st.pop(); 
                    st.push(l / r);
                break;

            }
        }
        return st.top();
    }
};
