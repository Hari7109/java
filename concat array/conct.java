import java.util.Arrays;

public class conct {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int[] result = concatArrays(array1, array2);

        System.out.println(Arrays.toString(result));
    }

    public static int[] concatArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        // Copy elements from array1 to result
        System.arraycopy(array1, 0, result, 0, array1.length);

        // Copy elements from array2 to result
        System.arraycopy(array2, 0, result, array1.length, array2.length);

        return result;
    }
}