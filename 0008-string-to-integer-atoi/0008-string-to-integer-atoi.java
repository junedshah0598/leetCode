class Solution {
    public int myAtoi(String s) {
        char[] characters = s.toCharArray();
        Integer result = null;
        boolean isPositive = true, wasPositive = true, isSignPossible = true;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                if (result == null && isSignPossible) {
                    continue;
                } else
                    break;
            } else if (characters[i] >= '0' && characters[i] <= '9') {
                int newDigit = characters[i] - '0';
                int oldValue = result == null ? 0 : result;

                if (result == null) {
                    if (newDigit == 0) {
                        isSignPossible = false;
                        continue;
                    }
                    result = isPositive ? newDigit : -newDigit; 
                } else {
                    result *= 10;
                    result = isPositive ? result + newDigit : result - newDigit;
                }
                isSignPossible = false;

                // If the old value divided by 10 does not equal to the new value, it is an Overflow or an Underflow!
                if (result / 10 != oldValue) { 
                    return wasPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else if (characters[i] == '-') {
                if (result == null && isSignPossible) {
                    isPositive = false;
                    wasPositive = false;
                    isSignPossible = false;
                } else
                    break;
            } else if (characters[i] == '+' && isSignPossible) {
                if (result == null) {
                    isPositive = true;
                    wasPositive = true;
                    isSignPossible = false;
                } else
                    break;
            } else 
                break;
        }

        if (result == null) {
            result = 0;
        }

        return result;
    }
}