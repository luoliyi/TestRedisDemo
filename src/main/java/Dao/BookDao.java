package Dao;

import Entities.Book;
import Utils.SerializeUitl;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public BookDao(){
        this.getBooks();
    }

    private List<Book> bookList;

    /*
    * 存储数据
    * */
    public void saveBooks(){
        /*
        * jedis：redis客户端的实现，连接池
        * */
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("myBooks".getBytes(),SerializeUitl.serialize(this.bookList));
        /*
        * 异步存储数据
        * */
        jedis.bgsave();
        jedis.close();
    }

    /*
    * 获取数据
    * */
    public  void getBooks(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        byte[]bytes=jedis.get("myBooks".getBytes());
        if (bytes!=null&&bytes.length>0){
            this.bookList= (List<Book>) SerializeUitl.deSerialize(bytes,Book.class);
        }else {
            this.bookList=new ArrayList<>();
        }
    }

    /*
    * 初始化数据
    * */
    public void initBooks(List<Book>books){
        this.bookList=books;
        saveBooks();
        System.out.println("init success!");
    }

    /*
    * 获取数据
    * */
    public List<Book> getBooksList(){
        return this.bookList;
    }

    /*
    * 添加
    * */
    public void addOneBook(Book book){
        this.bookList.add(book);
        saveBooks();
    }

    /*
    * 修改
    * */
    public void update(Book book){
        for (int i=0;i<this.bookList.size();i++){
            if(this.bookList.get(i).getBid()==book.getBid()){
                this.bookList.remove(i);
                this.bookList.add(i,book);
                System.out.println("update success!");
                break;
            }
        }
        saveBooks();
    }

    /*
    * 删除
    * */
    public  void delete(int bid){
        for (int i=0;i<this.bookList.size();i++){
            if(this.bookList.get(i).getBid()==bid){
                this.bookList.remove(i);
                System.out.println("remove success!");
            }
        }
        saveBooks();
    }
}
