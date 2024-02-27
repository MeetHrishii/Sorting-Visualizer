public class SortingAlgorithms {

    public static void bubbleSort(int[] arr, int currentIteration, SortingPanel sortingPanel) {
        for (int i = 0; i < arr.length - currentIteration - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                sortingPanel.setComparedIndices(new int[]{i, i + 1});
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
