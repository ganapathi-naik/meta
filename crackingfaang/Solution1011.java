class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = weights[0], totalWeight = weights[0];
        for(int i = 1; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            totalWeight += weights[i];
        }

        int left = maxWeight, right = totalWeight;
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canShip(int[] weights, int days, int candidateWeight) {
        int currWeight = 0;
        int daysNeeded = 1;
        for(int i = 0; i < weights.length; i++) {
            currWeight += weights[i];
            if(currWeight > candidateWeight) {
                currWeight = weights[i];
                daysNeeded++;
            }
        }
        return daysNeeded <= days;
    }
}
