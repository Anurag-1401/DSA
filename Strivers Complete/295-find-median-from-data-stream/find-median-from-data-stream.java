class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> b - a);
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (max.isEmpty() || num < max.peek()) {
            max.add(num);
        }
        else {
            min.add(num);
        }

        if (max.size() > min.size() + 1) {
            min.add(max.poll());
        }
        else if (min.size() > max.size() + 1) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            return (double) (max.peek() + min.peek()) / 2;
        }
        else if (max.size() > min.size()) {
            return (double) max.peek();
        }
        else {
            return (double) min.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */