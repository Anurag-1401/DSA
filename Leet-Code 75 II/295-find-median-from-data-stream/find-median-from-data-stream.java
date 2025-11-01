class MedianFinder {

    int[] hashVals;
    int median;
    int medianCount2x;

    public MedianFinder() {
        hashVals = new int[200001];
        median = Integer.MIN_VALUE;
        medianCount2x = 1;
    }
    
    public void addNum(int num) {
        hashVals[num+100000]++;
        if (median != Integer.MIN_VALUE) {
            if (num > median) {
                if (medianCount2x < 2*hashVals[median+100000]) {
                    medianCount2x++;
                } else {
                    medianCount2x = 1;
                    while (hashVals[++median+100000] == 0) {}
                }
            } else if (num < median) {
                if (medianCount2x > 1) {
                    medianCount2x--;
                } else {
                    while (hashVals[--median + 100000] ==0) {}
                    medianCount2x = 2*hashVals[median+100000];
                }
            } else {
                medianCount2x++;
            }
        } else {
            median = num;
        }
    }
    
    public double findMedian() {
        if (medianCount2x % 2 == 0) {
            if (2*hashVals[median+100000] > medianCount2x) {
                return median;
            } else {
                int median2 = median;
                while (hashVals[++median2 + 100000] == 0) {}
                return (median + median2)/2.0;
            }
        } else {
            return median;
        }
    }
}



// class MedianFinder {
//     private int[] nums;
//     private int size;

//     public MedianFinder() {
//         nums = new int[10]; // start small; will auto-expand
//         size = 0;
//     }

//     public void addNum(int num) {
//         if (size == nums.length) resize(); // 🔧 expand when full

//         int i = size - 1;
//         // insert in sorted order
//         while (i >= 0 && nums[i] > num) {
//             nums[i + 1] = nums[i];
//             i--;
//         }
//         nums[i + 1] = num;
//         size++;
//     }

//     private void resize() {
//         int[] newArr = new int[nums.length * 2]; // double capacity
//         for (int i = 0; i < nums.length; i++) {
//             newArr[i] = nums[i];
//         }
//         nums = newArr;
//     }

//     public double findMedian() {
//         if (size == 0) return 0;

//         if (size % 2 == 1) {
//             return nums[size / 2];
//         } else {
//             return (nums[size / 2 - 1] + nums[size / 2]) / 2.0;
//         }
//     }
// }


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
