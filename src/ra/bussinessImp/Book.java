package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

import static ra.run.BookManagement.sc;

public class Book implements IBook,Comparable<Book> {

    //1. Atribute
    private int bookId;
    private String bookName;

    private String title;

    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest=getInterest();
    private boolean bookStatus;
    // 2. Contructor
    public Book() {

    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = getInterest();
        this.bookStatus = bookStatus;
    }

    //3. Getter/ Setter and Methods


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập vào mã sách");
        this.bookId=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào tên sách");
        this.bookName=sc.nextLine();
        System.out.println("Nhập vào tiêu đề sách");
        this.title=sc.nextLine();
        System.out.println("Nhập số trang sách");
        this.numberOfPages=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào giá nhập sách");
        this.importPrice=Float.parseFloat(sc.nextLine());
        System.out.println("Nhập vào giá bán sách");
        this.exportPrice=Float.parseFloat(sc.nextLine());
        this.interest=getInterest();
        System.out.println("Nhập vào trạng thái của sách(true/false)");
        this.bookStatus=Boolean.parseBoolean(sc.nextLine());

    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %d, Tên sách: %s, Tiêu đề sách: %s, Số trang sách: %d, ", this.bookId,this.bookName,this.title, this.numberOfPages);
        System.out.printf("Giá nhập sách: %.2f, Giá bán sách: %.2f, Lợi nhuận: %.2f, Trạng thái sách: %s\n", this.importPrice, this.exportPrice,calculateInterest(),this.bookStatus?"Còn hàng":"Dừng bán");
    }

    public float calculateInterest() {
        return this.exportPrice - this.importPrice;
    }

    @Override
    public int compareTo(Book o) {
            // So sánh sách dựa trên lợi nhuận (interest)
            // Để sắp xếp giảm dần, chúng ta sẽ sử dụng otherBook.getInterest() - this.getInterest()
            // để đảm bảo sắp xếp giảm dần.
            return -Float.compare(o.getInterest(), this.getInterest());

    }
}
