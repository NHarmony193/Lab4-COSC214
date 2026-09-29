import java.util.Scanner;

public class Lab4MergeSorting {

    public static void main(String[] args) {

        int input_size = 1;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter 0 to exit the program.");

        while (input_size != 0) {

            System.out.println("Enter the number of integers to be sorted: ");

            input_size = userInput.nextInt();

            int[] inputArray = new int[input_size];

            for (int i = 0; i < input_size; i++) {
                System.out.printf("Enter the number at array position %d: ", i);
                int tempNum = userInput.nextInt();
                inputArray[i] = tempNum;
            }

            int low = 0;
            int high = inputArray.length - 1;
            mergeSort(inputArray, low, high);
            System.out.println("The final sorted array is: ");
            for (int i = 0; i <= high; i++) {
                System.out.printf("%d\n", inputArray[i]);
            }
        }
    }

    public static void mergeSort(int [] A, int low, int high) {

        if (low < high) {

            int mid = low + (high-low)/2;

            mergeSort(A, low, mid);
            mergeSort(A, mid+1, high);
            merge(A, low, mid, high);

        }
    }

    public static void merge(int [] A, int low, int mid, int high) {

        int [] tempArray = new int[high-low+1];

        int leftIndex = low;
        int rightIndex = mid + 1;
        int currentIndex = 0;

        while (leftIndex <= mid && rightIndex <= high) {
            if (A[leftIndex] <= A[rightIndex]) {
                tempArray[currentIndex] = A[leftIndex];
                leftIndex++;
            } else {
                tempArray[currentIndex] = A[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

         while (leftIndex <= mid) {
             tempArray[currentIndex] = A[leftIndex];
             leftIndex++;
             currentIndex++;
         }
        while (rightIndex <= high) {
            tempArray[currentIndex] = A[rightIndex];
            rightIndex++;
            currentIndex++;
        }

        for (int i=low; i<= high; i++) {
            A[i] = tempArray[i-low];
        }
    }
}

