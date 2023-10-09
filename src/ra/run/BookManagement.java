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
                    deleteBook();
                    break;
                case 5:
                    searchBookByName();
                    break;
                case 6:
                    changeBookStatusById();
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


    public static void deleteBook() {
        System.out.println("Nhập vào bookId cần xóa");
        int bookIdDelete = Integer.parseInt(sc.nextLine());
        // Tìm vị trí của sách cần xóa trong danh sách
        int indexToDelete = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookId() == bookIdDelete) {
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
            System.out.println("Không tìm thấy sách với mã sách " + bookIdDelete);
        }
    }

    public static void searchBookByName() {
        System.out.println("Nhập tên cần tìm kiếm");
        String bookNameSearch = sc.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bookNameSearch)) {
                book.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + bookNameSearch);
        }
    }

    public static void changeBookStatusById() {
        System.out.println("Nhập vào bookId cần thay đổi trạng thái");
        int bookIdToChange = Integer.parseInt(sc.nextLine());
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId() == bookIdToChange) {
                book.setBookStatus(!book.isBookStatus());
                found = true;
                System.out.println("Đã thay đổi trạng thái sách với mã sách " + bookIdToChange);
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách với mã sách: " + bookIdToChange);
        }
    }
}
