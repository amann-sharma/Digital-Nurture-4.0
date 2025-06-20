import java.util.Arrays;
import java.util.Comparator;

public class LibraryManager {
    private Book[] books;
    private int size;

    public LibraryManager(int capacity) {
        books = new Book[capacity];
        size = 0;
    }
    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Array is full. Cannot add more books.");
        }
    }
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public void traverseBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
} 