class Solution {
    public int maximumSum(int[] arr) {
        int oneDel = 0;
        int noDel = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++) {
            oneDel = Math.max(noDel, oneDel + arr[i]);
            noDel = Math.max(arr[i], noDel + arr[i]);
            maxSum = Math.max(maxSum, Math.max(oneDel, noDel));
        }
        return maxSum;
    }
}
