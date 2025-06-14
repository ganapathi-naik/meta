public class BinarySearch {
    int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 20, 10};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(arr, 40));
    }
}
