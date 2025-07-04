class Solution670 {
    public int maximumSwap(int num) {
        if(num <= 11) {
            return num;
        }
        char[] numChars = String.valueOf(num).toCharArray();
        int maxSeenToTheRightIndex = numChars.length;
        int maxSeenToTheRight = -1;
        Triplet[] triplets = new Triplet[numChars.length];

        for(int i = numChars.length - 1; i >= 0; i--) {
            triplets[i] = new Triplet(numChars[i] - '0', maxSeenToTheRight, maxSeenToTheRightIndex);
            if(numChars[i] - '0' > maxSeenToTheRight)  {
                maxSeenToTheRight = numChars[i] - '0';
                maxSeenToTheRightIndex = i;
            }
        }
        for(int i = 0; i < triplets.length; i++) {
            if(triplets[i].currNum < triplets[i].maxSeenToTheRight) {
                char temp = numChars[i];
                numChars[i] = numChars[triplets[i].maxSeenToTheRightIndex];
                numChars[triplets[i].maxSeenToTheRightIndex] = temp;
                break;
            }
        }
        return Integer.valueOf(new String(numChars)).intValue();
    }
}

class Triplet {
    int currNum;
    int maxSeenToTheRight;
    int maxSeenToTheRightIndex;

    public Triplet(int currNum, int maxSeenToTheRight, int maxSeenToTheRightIndex) {
        this.currNum = currNum;
        this.maxSeenToTheRight = maxSeenToTheRight;
        this.maxSeenToTheRightIndex = maxSeenToTheRightIndex;
    }

    public String toString() {
        return "" + currNum + " " + maxSeenToTheRight + " " + maxSeenToTheRightIndex;
    }
}

//Without triplet
class Solution {
    public int maximumSwap(int num) {
        if(num <= 11) {
            return num;
        }
        char[] numChars = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];
        Arrays.fill(lastIndex, - 1);

        for(int i = 0; i < numChars.length; i++) {
            lastIndex[numChars[i] - '0'] = i;
        }

        for(int i = 0; i < numChars.length; i++) {
            for(int j = 9; j > numChars[i] - '0'; j--) {
                if(lastIndex[j] > i) {
                    char temp = numChars[i];
                    numChars[i] = numChars[lastIndex[j]];
                    numChars[lastIndex[j]] = temp;

                    return Integer.valueOf(new String(numChars)).intValue();
                }
            }
        }
        return num;
    }
}

//Variant second largest number

class Solution670 {
    public int[] buildSecondLargest(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[]{};
        }
        int[] frequency = new int[10];
        for(int num : nums) {
            frequency[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 9; i >= 0; i--) {
            for(int f = 0; f < frequency[i]; f++) {
                list.add(i);
            }
        }
        for(int i = list.size() - 1; i > 0; i++) {
            if(list.get(i) != list.get(i - 1)) {
                int temp = list.get(i);
                list.set(i, list.get(i - 1));
                list.set(i - 1, temp);
                return list.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return nums;
    }
}
