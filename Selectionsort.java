class Selectionsort{
    void selectionsort(int[] arr){
        int minIdx;
        for(int i=0; i< arr.length -1; i++){
            minIdx =i;
            for(int j=i+1; j < arr.length; j++){
                if(arr[j]< arr[minIdx])
              //  arr[minIdx] = arr[j];
                minIdx = j;
                }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String ar[]){
        Selectionsort ob = new Selectionsort();
        int[] arr = {88,12,4,65,89,12};
        ob.selectionsort(arr);
        System.out.println("Sorted array : ");
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}