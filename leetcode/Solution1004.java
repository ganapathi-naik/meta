
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int longestOnes = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            k = k - (1 - nums[r]);
            if(k < 0) {
                k = k + (1 - nums[l]);
                l++;
            } else {
                longestOnes = Math.max(longestOnes, r - l + 1);
            }
        }
        return longestOnes;
    }
}

// Another way to put it using 'W' - Workday, 'H' - Holiday, PTO
class Solution1004 {
    public int longestVacation(char[] days, int pto) {
        int longestVacation = 0;
        int l = 0;
        for(int r = 0; r < days.length; r++) {
            if(days[r] == 'H') {
                pto = pto - 1;
            }
            while(pto < 0) {
                if(days[l] == 'H') {
                    pto = pto + 1;
                }
                l++;
            }
            longestVacation = Math.max(longestVacation, r - l + 1);
        }
        return longestVacation;
    }
}
