class Solution1891 {
    public int maxLength(int[] ribbons, int k) {
        int maxLength = ribbons[0];
        for(int i = 1; i < ribbons.length; i++) {
            maxLength = Math.max(maxLength, ribbons[i]);
        }

        int left = 0, right = maxLength;
        int res = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canCut(ribbons, k, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean canCut(int[] ribbons, int k, int candidateCutLength) {
        int currLength = candidateCutLength;
        int totalRibbons = 0;
        for(int i = 0; i < ribbons.length; i++) {
            totalRibbons += ribbons[i] / candidateCutLength;
            if(totalRibbons >= k) {
                return true;
            }
        }
        return false;
    }
}
