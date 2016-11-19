package net.a84jonghoon.app.androidtest01.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static net.a84jonghoon.app.androidtest01.global.Member.ADDR;
import static net.a84jonghoon.app.androidtest01.global.Member.EMAIL;
import static net.a84jonghoon.app.androidtest01.global.Member.ID;
import static net.a84jonghoon.app.androidtest01.global.Member.NAME;
import static net.a84jonghoon.app.androidtest01.global.Member.PHONE;
import static net.a84jonghoon.app.androidtest01.global.Member.PHOTO;
import static net.a84jonghoon.app.androidtest01.global.Member.PW;
import static net.a84jonghoon.app.androidtest01.global.Member.TABLE;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, "androidTest.db", null, 1);
        this.getWritableDatabase();
        Log.d("DB생성","==================");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE+"\n"+
            "(\n" +
                ID+" text primary key,\n" +
                PW+" text,\n" +
                NAME+" text,\n" +
                EMAIL+" text,\n" +
                PHONE+" text,\n" +
                PHOTO+" text,\n" +
                ADDR+" text \n" +
                ");");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('kim','123','TEST','KIM','mail@mail.com','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test1','123','TEST','테스트1','mail@mail.com','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test2','123','TEST','테스트2','mail@mail.com','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test3','123','TEST','테스트3','mail@mail.com','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test4','123','TEST','테스트4','mail@mail.com','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test5','123','TEST','테스트5','mail@mail.com','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test6','123','TEST','테스트6','mail@mail.com','n/a','n/a');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void join(MemberDTO param){
        Log.d("DAO JOIN ID : ", param.getId());
        Log.d("DAO JOIN PW : ", param.getPw());
        Log.d("DAO JOIN NAME : ", param.getName());
        Log.d("DAO JOIN EMAIL : ", param.getEmail());
        Log.d("DAO JOIN PHONE : ", param.getPhone());
        Log.d("DAO JOIN PHOTO : ", param.getPhoto());
        Log.d("DAO JOIN ADDR : ", param.getAddr());
        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

    }
    public int count(){
        int count = 0;
        return count;
    }
    public MemberDTO detail(String id){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public ArrayList<MemberDTO> list(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        MemberDTO member;
        String sql = "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,PHONE,PHOTO,ADDR)+" FROM member;";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        int i=0;
        if(cursor != null){
            Log.d("DAO LIST IS", "EXIST");
            cursor.moveToFirst();
        }

        do {
            member = new MemberDTO();
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setEmail(cursor.getString(2));
            member.setPhone(cursor.getString(3));
            member.setPhoto(cursor.getString(4));
            member.setAddr(cursor.getString(5));
            list.add(member);
        } while(cursor.moveToNext());

        return list;
    }
    public MemberDTO login(String id, String pw){
        Log.d("DAO LOGIN ID : ", id);
        Log.d("DAO LOGIN PW : ", pw);
        String sql = "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,PHONE,PHOTO,ADDR)+" FROM member WHERE ID = '"+id+"'";
        MemberDTO member = new MemberDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            member.setPw(cursor.getString(0));
        }
        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
