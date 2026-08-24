class Solution {

    public String encode(List<String> strs) {
        String output = "";
        for(String str : strs) {
           output += "SECRET" + str.length() + "@" + str;
        }
        return output;
    }

    public List<String> decode(String str) {
        int i = 0;
        String curr = "";
        boolean inString = false;
        List<String> output = new ArrayList<String>();
        while(i < str.length()) {
            if(str.substring(i, i + 6).equals("SECRET")) {
                i += 6;
                int escapeInd = str.indexOf("@", i);
                int len = Integer.parseInt(str.substring(i, escapeInd));
                String str1 = str.substring(escapeInd + 1, escapeInd + 1 + len);
                i = escapeInd + 1 + len;
                System.out.println(len);
                System.out.println(str1);
                output.add(str1);
            }
        }
        return output;
    }
}
