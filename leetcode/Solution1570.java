import java.util.*;

public class Solution1570 {

    private Pair[] indexToValuePairs;

    public Solution1570(int[] nums) {
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                pairs.add(new Pair(i, nums[i]));
            }
        }
        indexToValuePairs = pairs.toArray(new Pair[0]);
    }

    public int dotProduct(Solution1570 vec) {
        int res = 0;
        int index1 = 0, index2 = 0;
        while(index1 < this.indexToValuePairs.length && index2 < vec.indexToValuePairs.length) {
            if(this.indexToValuePairs[index1].index == vec.indexToValuePairs[index2].index) {
                res += (this.indexToValuePairs[index1].value * vec.indexToValuePairs[index2].value);
                index1++;
                index2++;
            } else if(this.indexToValuePairs[index1].index < vec.indexToValuePairs[index2].index) {
                index1++;
            } else {
                index2++;
            }
        }
        return res;
    }

    public int dotProductUsingBinarySearch(Solution1570 vec) {
        int res = 0;
        Pair[] loopOver = vec.indexToValuePairs;
        Pair[] seachIn = this.indexToValuePairs;
        if(this.indexToValuePairs.length < vec.indexToValuePairs.length) {
            loopOver = this.indexToValuePairs;
            seachIn = vec.indexToValuePairs;
        }
        for(int i = 0; i < loopOver.length; i++) {
            int left = 0, right = seachIn.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(seachIn[mid].index == loopOver[i].index) {
                    res += (seachIn[mid].value * loopOver[i].value);
                    break;
                } else if(seachIn[mid].index < loopOver[i].index) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1570 vector1 = new Solution1570(new int[]{1,0,3});
        Solution1570 vector2 = new Solution1570(new int[]{4,5,6});
        int result1 = vector1.dotProductUsingBinarySearch(vector2);
        int result2 = vector1.dotProductUsingBinarySearch(vector2);
        System.out.println("result1:" + result1);
        System.out.println("result2:" + result2);
        System.out.println(result1 == result2);
    }
}

class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
