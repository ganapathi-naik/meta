class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            nums1[0] = nums2[0];
        }
        int ptr1 = m - 1, ptr2 = n - 1, ptr = m + n - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] >= nums2[ptr2]) {
                nums1[ptr] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[ptr] = nums2[ptr2];
                ptr2--;
            }
            ptr--;
        }

        while(ptr2 >=0) {
            nums1[ptr] = nums2[ptr2];
            ptr2--;
            ptr--;
        }
    }
}

/**
    [4,6,8,0,0,0]
    [1,5,6]
 */
