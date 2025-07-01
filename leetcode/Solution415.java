class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        while(i1 >= 0 && i2 >= 0) {
            int op1 = num1.charAt(i1) - '0';
            int op2 = num2.charAt(i2) - '0';
            int sum = op1 + op2 + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            sb.append(reminder);
            i1--;
            i2--;
        }

        while(i1 >= 0) {
            int op1 = num1.charAt(i1) - '0';
            int sum = op1 + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            sb.append(reminder);
            i1--;
        }

        while(i2 >= 0) {
            int op2 = num2.charAt(i2) - '0';
            int sum = op2 + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            sb.append(reminder);
            i2--;
        }

        if(carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}


//Adding decimal number
/**

 */
class Solution415 {
    public String addStrings(String num1, String num2) {
        boolean hasBoolean = false;
        String[] nums1 = num1.split("\\.");
        hasBoolean = hasBoolean || nums1.length > 1;

        String[] nums2 = num2.split("\\.");
        hasBoolean = hasBoolean || nums2.length > 1;

        StringBuilder n1 = new StringBuilder(nums1[0]);
        StringBuilder n2 = new StringBuilder(nums2[0]);

        if(hasBoolean) {
            n1.append(".");
            n2.append(".");

            int decimalLen1 = nums1.length > 1 ? nums1[1].length() : 0;
            int decimalLen2 = nums2.length > 1 ? nums2[1].length() : 0;

            if(nums1.length > 1) {
                n1.append(nums1[1]);
            }
            for(int i = decimalLen1; i < decimalLen2; i++) {
                n1.append('0');
            }

            if(nums2.length > 1) {
                n2.append(nums2[1]);
            }
            for(int i = decimalLen2; i < decimalLen1; i++) {
                n2.append('0');
            }
        }
        return add(n1.toString(), n2.toString());
    }

    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        while(i1 >= 0 && i2 >= 0) {
            if(num1.charAt(i1) == '.') {
                sb.append('.');
                i1--;
                i2--;
                continue;
            }
            int op1 = num1.charAt(i1) - '0';
            int op2 = num2.charAt(i2) - '0';
            int sum = op1 + op2 + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            sb.append(reminder);
            i1--;
            i2--;
        }

        while(i1 >= 0) {
            int op1 = num1.charAt(i1) - '0';
            int sum = op1 + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            sb.append(reminder);
            i1--;
        }

        while(i2 >= 0) {
            int op2 = num2.charAt(i2) - '0';
            int sum = op2 + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            sb.append(reminder);
            i2--;
        }

        if(carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("91.465", "72.865"));
    }
}
