// Using - O(n^2)
class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });
        int maxEnvelopes = 1;
        int[] longestIncreasingSubSequence = new int[envelopes.length];
        Arrays.fill(longestIncreasingSubSequence, 1);
        for(int i = 1; i < envelopes.length; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && 1 + longestIncreasingSubSequence[j] > longestIncreasingSubSequence[i]) {
                    longestIncreasingSubSequence[i] = 1 + longestIncreasingSubSequence[j];
                    maxEnvelopes = Math.max(maxEnvelopes, longestIncreasingSubSequence[i]);
                }
            }
        }
        return maxEnvelopes;
    }
}

// Using binary search - O(nlogn)
class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> {
            if(e1[0] != e2[0]) {
                return e1[0] - e2[0];
            }
            return e2[1] - e1[1];
        });
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < envelopes.length; i++) {
            int index = findLowerBound(res, envelopes[i]);
            if(index == -1) {
                res.add(envelopes[i]);
            } else {
                res.set(index, envelopes[i]);
            }
        }
        return res.size();
    }

    private int findLowerBound(List<int[]> nums, int[] target) {
        int res = -1;
        int left = 0, right = nums.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums.get(mid)[1] >= target[1]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
