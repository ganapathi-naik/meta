class Solution346 {
}

class MovingAverage {
    int size;
    Queue<Integer> q;
    int sum;
    public MovingAverage(int size) {
        this.size = size;
        this.q = new LinkedList<>();
        this.sum = 0;
    }

    double next(int val) {
        if(this.q.size() == this.size) {
            sum -= this.q.poll();
        }
        this.q.offer(val);
        this.sum += val;
        return (this.sum * 1.0) / q.size();
    }
}

/**
Variant asked in Facebook interview
    Given a list of integers nums and an integer size, compute the average of elements in a sliding window of exactly size elements.
    Return a list containing the results of these computations using integer division.
    Example 1:
    Input: nums = [5,2,8,14,3]
    Output: [5,8,8]
    Explanation:
    The first window is (5+2+8)/3=5
    The second window is (2+8+14)/3=8
    The third window is (8,14,3)/3=8
    Constraints:
    • 1 <= nums. length <= 1000
    • 1 < size <= nums. length
*/


class MovingAverage {
    public computeAverage(int[] nums, int size) {
        int sum = 0;
        List<Integer> avgs = new ArrayList<>();
        for(int right = 0; right < nums.length; right++) {
            sum += nums[i];
            int left = right - size;
            if(left >= 0) {
                sum -= nums[left];
            }
            if(right >= size - 1) {
                avgs.add(sum / size);
            }
        }
        return avgs.toArray(new int[0]);
    }
}
