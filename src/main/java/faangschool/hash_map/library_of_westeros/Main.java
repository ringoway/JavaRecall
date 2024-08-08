package faangschool.hash_map.library_of_westeros;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {

    public static HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.put(new Book("Адам и ева", "Бог", -1000), "1 полка");
        library.put(new Book("Распятие иисуса", "Бог", 0), "1 полка");
        library.put(new Book("Кровавый князь", "Иван Грозный", 1547), "2 полка");

        addBook(new Book("Жизнь пчелы", "Королева пчёл", 100), "1 полка");

        Book book = new Book("Горит Поттер", "Кто то важный", 2003);
        addBook(book, "2 полка");

        removeBook(new Book("Кровавый князь", "Иван Грозный", 1547));

        System.out.println(findBook(new Book("Адам и ева", "Бог", -1000)));
        printAllBooks();
    }

    public static void addBook(Book book, String bookPlace) {
        if (book == null) {
            log.error("Book is null");
            return;
        }
        if (!bookPlace.isBlank()) {
            library.put(book, bookPlace);
            log.info("Successfully inserting a book onto the shelf");
        } else {
            log.error("BookPlace is blank");
        }
    }

    public static void removeBook(Book book) {
        if (!(book == null)) {
            library.remove(book);
            log.info("Successfully removed a book onto the shelf");
        } else {
            log.error("Book is null");
        }
    }

    public static String findBook(Book book) {
        if (book == null) {
            log.error("Book is null and cannot be found.");
            return null;
        }
        String location = library.get(book);

        if (location != null) {
            log.info("Successfully found the book: '{}' by '{}' on the shelf: {}", book.getTitle(), book.getAuthor(), location);
        } else {
            log.warn("Book '{}' by '{}' not found in the library.", book.getTitle(), book.getAuthor());
        }
        return location;
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", Shelf: " + entry.getValue());
        }
    }
}
