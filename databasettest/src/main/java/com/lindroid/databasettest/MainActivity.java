package com.lindroid.databasettest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
    }

    public void createDatabase(View view){
        dbHelper.getWritableDatabase();
    }

    //添加数据
    public void addData(View view){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //组装第一条数据
        values.put("name","西游记");
        values.put("author","吴承恩");
        values.put("pages",612);
        values.put("price",32.5);
        sqLiteDatabase.insert("Book",null,values);
        //组装第二条数据
        values.put("name","水浒传");
        values.put("author","施耐庵");
        values.put("pages",589);
        values.put("price",30.5);
        sqLiteDatabase.insert("Book",null,values);
        Toast.makeText(this, "添加数据成功", Toast.LENGTH_SHORT).show();
    }

    //更新数据
    public void updateData(View view){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price",29.0);
        sqLiteDatabase.update("Book",values,"name=?",new String[]{"水浒传"});
        Toast.makeText(this, "更新数据成功", Toast.LENGTH_SHORT).show();
    }

    //查询数据
    public void queryData(View view){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        //查询Book表中所有的数据
        Cursor cursor = sqLiteDatabase.query("Book",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.e("Tag","book name is "+name);
                Log.e("Tag","book author is "+author);
                Log.e("Tag","book pages is "+pages);
                Log.e("Tag","book price is "+price);
            }while (cursor.moveToNext());
        }
        cursor.close();
        Toast.makeText(this, "查询数据成功", Toast.LENGTH_SHORT).show();
    }
}
