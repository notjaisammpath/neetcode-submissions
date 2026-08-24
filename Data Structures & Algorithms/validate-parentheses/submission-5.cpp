class Solution {
public:
    bool isValid(string s) {
        std::stack<char> st;
        for(char i : s) {
             if(i == '}' || i == ')' || i == ']') {
                if(st.empty())
                return false;
            }
            if(i == '(' || i == '{' || i == '[') {
                st.push(i);
            }
            else if (i == '}') {
                if(st.top() != '{') {
                    return false;
                }
            }
            else if (i == ']') {
                if(st.top() != '[') {
                    return false;
                }
            }
            else if (i == ')') {
                if(st.top() != '(') {
                    return false;
                }
            }

            if(i == '}' || i == ')' || i == ']') {
                st.pop();
            }
        }
        if(st.empty())
        return true;
        else return false;
    }
};
