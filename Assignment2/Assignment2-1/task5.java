public class task5 {
    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }
    public static void reverseArray(int[] array) {
        for(int i = 0; i < array.length/2;i++)
        {
             int prev = array[i];
             array[i] = array[array.length-i-1];
             array[array.length-i-1]=prev;
        }
    }
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
