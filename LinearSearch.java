// //Program on linear search
// publicclass LinearSerach{
//     int linearSearchAlgo(int[] arr, int key){
//         for(int i=0;i < arr.length; i++) {
//             if(arr[i]== key)
//             return i;
//         }
//         return -1;
//     }
//     public static void main(String ar[]){
//         LinearSearch obj = new LinearSerach();
//         int[] arr = { 5,3,10,34,44,54};
//         int key = 10;
//         int result = obj.linearSearchAlgo(arr, key);
//         System.out.println("Element found at index: "+result);
//     }
// }
public class LinearSearch {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Element found, return index
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 30;

        int result = linearSearch(arr, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
