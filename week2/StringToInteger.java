class StringToInteger {
    public static int myAtoi(String s) {
        
        if (s == null || s.length() == 0){
            return 0;
        }

        s = s.trim();

        boolean isNegative = s.startsWith("-");

        int i = s.startsWith("+") || s.startsWith("-") ? 1 : 0;

        int result = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if (result > Integer.MAX_VALUE/10 
            || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result*10 + digit;
            i++;
        }

        if (isNegative){
            return -1*result;
        }

        return result;
    }
}