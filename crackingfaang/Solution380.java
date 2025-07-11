class Solution380 {
}
class RandomizedSet {

    Map<Integer, Integer> numMap;
    List<Integer> numList;

    public RandomizedSet() {
        numMap = new HashMap<>();
        numList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (numMap.containsKey(val)) {
            return false;
        }
        numList.add(val);
        int index = numList.size() - 1;
        numMap.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!numMap.containsKey(val)) {
            return false;
        }
        int index = numMap.get(val);

        int lastIndex = (int) numList.size() - 1;
        int lastIndexVal = numList.get(lastIndex);

        numList.set(index, lastIndexVal);
        numList.remove(lastIndex);

        numMap.put(lastIndexVal, index);
        numMap.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(numList.size());
        return numList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
