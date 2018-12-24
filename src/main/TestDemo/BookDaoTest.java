import Dao.BookDao;
import Entities.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookDaoTest {


    BookDao bookDao=new BookDao();

    @Test
    public void initData(){
        List<Book> bookList=new ArrayList<>();
        bookList.add(new Book(10001,"人性的弱点",63.0,"卡耐基"));
        bookList.add(new Book(10002,"人性的优点",67.0,"卡耐基"));
        bookList.add(new Book(10003,"卡耐基经商之道",73.0,"卡耐基"));
        bookList.add(new Book(10004,"卡耐基口才学",89.0,"卡耐基"));
        bookList.add(new Book(10005,"卡耐基形象设计艺术",109.0,"卡耐基"));
        bookDao.initBooks(bookList);
    }

    @Test
    public void getBooks(){
       List<Book>bookList= bookDao.getBooksList();
       for (Book book:bookList){
           System.out.println(book);
       }
    }

    @Test
    public void addOneBook(){
        Book book=new Book(10006,"故事会",19.0,"佚名");
        bookDao.addOneBook(book);
    }

    @Test
    public void update(){
        Book book=new Book(10006,"老夫子",19.0,"王泽");
        bookDao.update(book);
    }

    @Test
    public void delete(){
        bookDao.delete(10004);
    }
}
