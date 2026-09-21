class Solution {
    public int hIndex(int[] citations) {
        quickSort(citations,0,citations.length-1);
        for (int i = 0 ; i < citations.length ; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}


// class Solution {
//     public int hIndex(int[] citations) {
//         int n = citations.length;
//         int[] tmp = new int[n+1];
//         for (int i = 0; i < n; i++) {
//             if (citations[i] > n) {
//                 tmp[n]++;
//             }
//             else {
//                 tmp[citations[i]]++;
//             }
//         }
//         int total = 0;
//         for (int i = n; i >=0; i--) {
//             total += tmp[i];
//             if (total >= i) return i;
//         }
//         return 0;
//     }
// }
