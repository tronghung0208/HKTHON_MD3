package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    public static Scanner sc = new Scanner(System.in);

    public static List<Book> bookList = new ArrayList<>();


    public static void main(String[] args) {
        do {
            System.out.println("********************JAVA-HACKATHON-05-BASIC-MENU********************\n" +
                    "1. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách \n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách \n" +
                    "7. Thoát \n");
            System.out.println("Mời nhập lựa chọn!!!");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBookLists();
                    break;
                case 3:
                    sortByBookDescending();
                    break;
                case 4:
                    System.out.println("Nhập vào bookId cần xóa");
                    int bookIdDelete = Integer.parseInt(sc.nextLine());
                    deleteBook(bookIdDelete);
                    break;
                case 5:
                    System.out.println("Nhập tên cần tìm kiếm");
                    String bookNameSearch = sc.nextLine();
                    searchBookByName(bookNameSearch);
                    break;
                case 6:
                    System.out.println("Nhập vào bookId cần xóa");
                    int bookIdToChange = Integer.parseInt(sc.nextLine());
                    changeBookStatusById(bookIdToChange);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Xin mời nhập lại");
            }
        } while (true);
    }

    // Thêm mới sách vào bookList
    public static void addBook() {
        System.out.println("Nhập số lượng sách cần thêm:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ: " + (i + 1));
            Book newBook = new Book();
            newBook.inputData();
            bookList.add(newBook);
        }
    }

    // Hiển thị thông tin sách;
    public static void showBookLists() {
        for (Book book : bookList) {
            book.displayData();
        }
    }

    // Sắp xếp theo lợi nhuận giảm dần;


    public static void sortByBookDescending() {
        bookList.sort(Book::compareTo);
        for (Book element : bookList) {
            element.displayData();
        }
    }


    public static void deleteBook(int bookIdToDelete) {
        // Tìm vị trí của sách cần xóa trong danh sách
        int indexToDelete = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookId() == bookIdToDelete) {
                indexToDelete = i;
                break;
            }
        }

        // Kiểm tra nếu tìm thấy sách
        if (indexToDelete != -1) {
            // Xóa sách khỏi danh sách
            bookList.remove(indexToDelete);
            System.out.println("Xóa sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách với mã sách " + bookIdToDelete);
        }
    }

    public static void searchBookByName(String bookNameToSearch) {
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bookNameToSearch)) {
                book.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + bookNameToSearch);
        }
    }

    public static void changeBookStatusById(int bookIdToChange) {
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId() == bookIdToChange) {
                book.setBookStatus(!book.isBookStatus());
                found = true;
                System.out.println("Đã thay đổi trạng thái sách với mã sách " + bookIdToChange);
                break; // Dừng vòng lặp sau khi tìm thấy sách cần thay đổi
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách với mã sách: " + bookIdToChange);
        }
    }
}
