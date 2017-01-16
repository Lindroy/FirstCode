package com.lindroid.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addData(View view){
        // 添加数据
        Uri uri = Uri.parse("content://com.lindroid.databasettest/book");
        ContentValues values = new ContentValues();
        values.put("name", "三国演义");
        values.put("author", "罗贯中");
        values.put("pages", 466);
        values.put("price", 28.70);
        Uri newUri = getContentResolver().insert(uri, values);
        if (newUri == null){
            Log.e("Tag",newUri+"");
        }
        newId = newUri.getPathSegments().get(1);
    }

    public void queryData(View view){
        // 查询数据
        Uri uri = Uri.parse("content://com.lindroid.databasettest/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor. getColumnIndex("name"));
                String author = cursor.getString(cursor. getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex ("pages"));
                double price = cursor.getDouble(cursor. getColumnIndex("price"));
                Log.e("MainActivity", "book name is " + name);
                Log.e("MainActivity", "book author is " + author);
                Log.e("MainActivity", "book pages is " + pages);
                Log.e("MainActivity", "book price is " + price);
            }
            cursor.close();
        }
    }

    public void updateData(View view){
        // 更新数据
        Uri uri = Uri.parse("content://com.lindroid.databasettest/book/" + newId);
        ContentValues values = new ContentValues();
        values.put("name", "红楼梦");
        values.put("pages", 711);
        values.put("price", 35.05);
        getContentResolver().update(uri, values, null, null);
    }

    public void deleteData(View view){
        // 删除数据
        Uri uri = Uri.parse("content://com.lindroid.databasettest/book/" + newId);
        getContentResolver().delete(uri, null, null);
    }
}
