public class Team9SortCompetition extends SortCompetition {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectSwap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    @Override
    public int challengeOne(int[] arr) {
        //insertion sort
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j-1 >= 0 && arr[j] < arr[j-1]){
                swap(arr, j, j-1);
                j--;
            }
        }

        return (arr[4999]+ arr[5000])/2;
    }

    @Override
    public int challengeTwo(String[] arr, String query) {
        //selection sort
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-1; j++){
                if(arr[i].compareTo(arr[j]) < 0){
                    selectSwap(arr, j, i);
                }
            }
        }
        for(int m = 0; m < arr.length; m++){
            if(arr[m].indexOf("query") > 0){
                return arr[m].indexOf("query");
            }
        }
        return -1;
    }

    @Override
    public int challengeThree(int[] arr) {
        quicksort(arr,0,arr.length-1);
        return arr[(arr.length-1)/2];
    }
    public static void quicksort(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int pivot = partition(arr,left,right);
            quicksort(arr, left,pivot -1);
            quicksort(arr, pivot + 1, right);
        }
    }
    public static int partition(int[]arr, int left, int right)
    {
        int pivot = arr[right];
        int i = left - 1;
        for(int j = left; j < right; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[right];
        arr[right] = arr[i+1];
        arr[i+1] = temp;
        return i+1;
    }



    @Override
    public int challengeFour(int[][] arr) {
        //I'm trying to figure this out but it's tough...... Because its an array of 1001 numbers (1-1000 + position 0)
        // we have to calculate median by adding index 499+500 and dividing by 2.
        int[] temparray = new int[arr.length];
        for(int i = 0; i < arr.length;i++)
        {
                quicksort(arr[i], 0, arr[i].length-1);
                temparray[i] = arr[i][arr[i].length/2 - 1];
        }
        quicksort(temparray,0, temparray.length -1);
        return temparray[temparray.length/2 -1];
        //ev in temparray should be an array, this adds all to one single arr
        /*int[] smallarr1 = new int[1000];
        int[] smallarr2 = new int[1000];
        for(int outerarr = 0; outerarr < 1000;outerarr++)
        {
            smallarr1[outerarr] = temparray[outerarr];

        }
        quicksort(smallarr1,0,arr.length-1);
        for(int innerarr = 0; innerarr < 1000;innerarr++)
        {
            smallarr2[innerarr] = temparray[1000+innerarr];
            quicksort(arr[innerarr],0,arr.length-1);
        }
        //trying to divide the separate arrays

        int[] arrmedians = new int[1000];
        for(int k = 0; k < 1000;k++)
        {
            int[] temp = new int[1000];
            temp[k] = smallarr1[k];
            arrmedians[k] = smallarr1[(k-1)/2];
        }
        quicksort(arrmedians,0,arr.length-1);
        int median = arr[(999)/2][(999)/2][5/2];
        return median;
        */
    }

    @Override
    public int challengeFive(Comparable[] arr, Comparable query) {
        return 0;
    }

    @Override
    public String greeting() {
        return null;
    }
}
/*
public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSwap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectSwap(double[] arr, int i, int j){
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void insertionSort(int[] list1){
        for(int i = 1; i < list1.length; i++){
            int j = i;
            while(j-1 >= 0 && list1[j] < list1[j-1]){
                swap(list1, j, j-1);
                j--;
            }
        }
    }
    public static void selectionSort(double[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-1; j++){
                if(arr[i] < arr[j]){
                    selectSwap(arr, j, i);
                }
            }
        }
    }
    //use compareTo
    public static void bubbleSort(String[] list1){
        for(int i = 0; i < list1.length; i++){
            for(int j = 0; j < list1.length-1; j++) {
                if (list1[j].compareTo(list1[j+1])> 0) {
                    bubbleSwap(list1, j, j + 1);
                }
            }
        }
    }
    public static void mergeSort(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, 0, n - 1, temp);
    }
    private static void mergeSortHelper(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid, temp);
            mergeSortHelper(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= right){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(k = left; k <= right; k++){
            arr[k] = temp[k];
        }
    }
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot -1);
            quickSort(arr, pivot+1, right);
        }
    }
    public static  int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left -1;
        for(int j = left; j < right; j++){
            if(arr[i] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i +1;
    }
}


 */