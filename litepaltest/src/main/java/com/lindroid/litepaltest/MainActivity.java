package com.lindroid.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CreateDatabase(View v){
        Connector.getDatabase();
        Toast.makeText(MainActivity.this, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    /**
     * 添加数据
     * @param v
     */
    public void addDataClick(View v){
        Toast.makeText(MainActivity.this, "添加数据成功", Toast.LENGTH_SHORT).show();
        Book book = new Book();
        book.setName("《三国演义》");
        book.setAuthor("罗贯中");
        book.setPages(586);
        book.setPrice(28.5);
        book.setPress("文学出版社");
        book.save();
    }

    /**
     * 更新数据
     * @param v
     */
    public void upDateDataClick(View v){
        Toast.makeText(MainActivity.this, "更新数据成功", Toast.LENGTH_SHORT).show();
        Book book = new Book();
        book.setName("《水浒传》");
        book.setAuthor("施耐庵");
        book.setPages(612);
        book.setPrice(32.5);
        book.setPress("文学出版社");
        book.save();
        book.setPrice(33.5);
        book.save();
//        Book book = new Book();
//        book.setPrice(35.5);
//        book.setPress("世纪出版社");
//        book.updateAll("name = ? and author = ?","《水浒传》","施耐庵");
    }

    /**
     * 删除数据
     * @param v
     */
    public void deleteDataClick(View v){
        Toast.makeText(MainActivity.this, "删除数据成功", Toast.LENGTH_SHORT).show();
        DataSupport.deleteAll(Book.class,"price < ?","30");
    }

    /**
     * 查询数据
     * @param v
     */
    public void queryDataClick(View v){
        Toast.makeText(MainActivity.this, "查询数据成功", Toast.LENGTH_SHORT).show();
        List<Book> books = DataSupport.findAll(Book.class);
        for (Book book : books) {
            Log.e("MainActivity","book name is "+book.getName());
            Log.e("MainActivity","book author is "+book.getAuthor());
            Log.e("MainActivity","book pages is "+book.getPages());
            Log.e("MainActivity","book price is "+book.getPrice());
            Log.e("MainActivity","book press is "+book.getPress());
        }
    }
}
