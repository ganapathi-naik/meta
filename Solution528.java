class Solution528 {

    Random random;
    double[] probability;
    double sum;
    public Solution(int[] w) {
        this.random = new Random();
        probability = new double[w.length];
        for(int i = 0; i < w.length; i++) {
            sum += w[i];
        }
        double cSum = 0;
        for(int i = 0; i < w.length; i++) {
            cSum += w[i];
            this.probability[i] = cSum / sum;
        }
        this.random = new Random();
    }

    public int pickIndex() {
        double target = random.nextDouble();
        int left = 0, right = probability.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(probability[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
