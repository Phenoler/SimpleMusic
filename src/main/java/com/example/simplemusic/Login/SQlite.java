package com.example.simplemusic.Login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQlite extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public SQlite(Context context){
        super(context,"db_test",null,1);
        db = getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
    public void add(String name,String password ){
        db.execSQL("INSERT INTO user(name,password)VALUES(?,?)",new Object[]{name,password});
    }
    public ArrayList<User> getAllDATA(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("user",null,null,null,null,null,"null");
        while(cursor.moveToNext()){
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new User(name,password));
        }
        return list;
    }
}