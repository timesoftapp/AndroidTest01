package net.a84jonghoon.app.androidtest01.movie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public class MovieDAO extends SQLiteOpenHelper {
    public MovieDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void add(MovieDTO param) {
        String sql = "INSERT INTO table() VALUES()";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM table";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return 0;
    }

    public MovieDTO findOne() {
        String sql = "SELECT * FROM table WHERE column = 'key'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    }

    public ArrayList<MovieDTO> findBy(MovieDTO param) {
        String sql = "SELECT * FROM table WHERE column = 'search word'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    }

    public ArrayList<MovieDTO> list() {
        String sql = "SELECT * FROM table";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    }

    public void update(MovieDTO param) {
        String sql = "UPDATE table SET column1 = 'val1, column2 = 'val2' WHERE column = 'key'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public void delete(MovieDTO param) {
        String sql = "DELTE table WHERE column = 'key'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
}
