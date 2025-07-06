class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) {
            return true;
        }
        int previousPlantIndex = -2;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i > previousPlantIndex + 1 && ((i + 1 < len && flowerbed[i + 1] == 0) || (i == len - 1))) {
                    flowerbed[i] = 1;
                    n = n - 1;
                    previousPlantIndex = i;
                    if (n == 0) {
                        return true;
                    }
                }
            } else {
                previousPlantIndex = i;
            }
        }
        return false;
    }
}
