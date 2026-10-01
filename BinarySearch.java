class BinarySearch{
    static int binarySearchAlgo(int[] arr , int key){
        int First_index = 0, Last_index = arr.length -1, mid;
        while(First_index <= Last_index){
            mid =(First_index + Last_index) / 2;
            if (arr[mid]==key)
            return mid;
            else if(key < arr[mid])
            Last_index = mid - 1 ;
            else
            First_index  = mid + 1;

        }
        return -1;
    }
 public static void main(String ar[]){
    int[] arr = { 2 ,4, 5, 23,55,66 };
    int key = 23;
    int result = binarySearchAlgo(arr, key);
    System.out.println("Element found at index : "+ result);
 }
}
