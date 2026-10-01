class Bubblesort{
    void bubblesortAlgo(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1;i++) {
            //u can write i< = n-2 
            for( int j= 0; j < n - 1 - i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; // swapping of elements 

                }
            }
        }
    }
        public static void main(String ar[]){
            Bubblesort obj = new Bubblesort();
            int[] arr  = { 5, 9, 1, 8 ,2 };
            obj.bubblesortAlgo(arr);
            System.out.println("Sorted Array is :");
           // for ( int i =0 ;i < arr.length; i++){
                for(int num : arr ){
                System.out.print(num + " "); 
            }
        
    }
}