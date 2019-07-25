class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"c", "c"};
        String result = longestCommonPrefix(input);
    	System.out.println(result);
    }

    static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0 || (strs.length == 1 && strs[0].length() == 0))
            return "";

        String result = "";
        char[] first = strs[0].toCharArray();

        if (strs.length == 1)
            return ""+first[0];

        for(int i=0; i<first.length; ++i) {
            char diff = first[i];
            for(int j=1; j < strs.length; ++j) {

                if (strs[j].length() <= i)
                    return result;

                if (diff != strs[j].charAt(i))
                    return result;
            }
            result += diff;
        }

        return result;
    }
}