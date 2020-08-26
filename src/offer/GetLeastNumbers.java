package offer;

public class GetLeastNumbers {


    public int[] getLeastNumbers(int[] arr, int k) {
        int[] array = new int[k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            array[i] = arr[i];
            if (i == k) {
                break;
            }
        }
        return array;
    }
}
