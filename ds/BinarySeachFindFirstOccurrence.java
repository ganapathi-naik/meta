public class BinarySearchFindFirstOccurrence {
    private int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] = target) {
                right = mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        BinarySearchFindFirstOccurrence bs = new BinarySearchFindFirstOccurrence();
        bs.search(arr, 10);
    }
}
