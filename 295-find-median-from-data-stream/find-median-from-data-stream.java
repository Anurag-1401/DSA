class MedianFinder {
    private int[] nums;
    private int size;

    public MedianFinder() {
        nums = new int[10]; // start small; will auto-expand
        size = 0;
    }

    public void addNum(int num) {
        if (size == nums.length) resize(); // \U0001f527 expand when full

        int i = size - 1;
        // insert in sorted order
        while (i >= 0 && nums[i] > num) {
            nums[i + 1] = nums[i];
            i--;
        }
        nums[i + 1] = num;
        size++;
    }

    private void resize() {
        int[] newArr = new int[nums.length * 2]; // double capacity
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
        }
        nums = newArr;
    }

    public double findMedian() {
        if (size == 0) return 0;

        if (size % 2 == 1) {
            return nums[size / 2];
        } else {
            return (nums[size / 2 - 1] + nums[size / 2]) / 2.0;
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */