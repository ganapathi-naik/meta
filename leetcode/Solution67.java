class Solution67 {
    public String addBinary(String a, String b) {
        int len1 = a.length() - 1, len2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            int sum = (a.charAt(len1) - '0') + (b.charAt(len2) - '0') + carry;
            int remainder = sum % 2;
            carry = sum / 2;
            sb.append(remainder);
            len1--;
            len2--;
        }

        while (len1 >= 0) {
            int sum = (a.charAt(len1) - '0') + carry;
            int remainder = sum % 2;
            carry = sum / 2;
            sb.append(remainder);
            len1--;
        }

        while (len2 >= 0) {
            int sum = (b.charAt(len2) - '0') + carry;
            int remainder = sum % 2;
            carry = sum / 2;
            sb.append(remainder);
            len2--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
