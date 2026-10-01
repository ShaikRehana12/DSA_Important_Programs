import java.util.*;

public class Books {

    // Function to check whether all books can be allocated
    // such that no student gets more than 'limit' pages
    static boolean canAllocate(long[] pages, int students, long limit) {

        int used = 1;        // Start with the first student
        long current = 0;   // Pages assigned to the current student

        for (long book : pages) {

            // If adding the current book exceeds the limit,
            // assign this book to the next student
            if (current + book > limit) {
                used++;
                current = book;

                // If the number of students required exceeds
                // the available students, allocation is not possible
                if (used > students)
                    return false;
            } else {
                // Assign the book to the current student
                current += book;
            }
        }

        // Allocation is possible within the given limit
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of books
        int n = sc.nextInt();

        // Number of students
        int students = sc.nextInt();

        long[] pages = new long[n];

        // Minimum possible answer:
        // largest book (a student must read the entire book)
        long low = 0;

        // Maximum possible answer:
        // sum of all pages (one student reads all books)
        long high = 0;

        // Read pages in each book
        for (int i = 0; i < n; i++) 
        {
            pages[i] = sc.nextLong();

            // Update lower bound
            low = Math.max(low, pages[i]);

            // Update upper bound
            high += pages[i];
        }

        // If students are more than books,
        // allocation is not possible
        if (students > n) {
            System.out.println(-1);
            return;
        }

        // Binary Search on the answer space
        while (low < high) {

            // Mid represents the maximum pages
            // allowed for a student
            long mid = low + (high - low) / 2;

            // Check if allocation is possible
            if (canAllocate(pages, students, mid)) {
                // Try to find a smaller valid answer
                high = mid;
            } else {
                // Need a larger limit
                low = mid + 1;
            }
        }

        // Minimum possible maximum pages assigned
        System.out.println(low);
    }
}