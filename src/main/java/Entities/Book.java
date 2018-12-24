package Entities;
import java.io.Serializable;

public class Book implements Serializable {

    /*
    * 书籍id
    * */
    private int bid;
    /*
    * 书籍名称
    * */
    private String bname;
    /*
    * 书籍价格
    * */
    private double bprice;
    /*
    * 书籍作者
    * */
    private String author;

    public Book() {
    }

    public Book(int bid, String bname, double bprice, String author) {
        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.author = author;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", author='" + author + '\'' +
                '}';
    }
}
