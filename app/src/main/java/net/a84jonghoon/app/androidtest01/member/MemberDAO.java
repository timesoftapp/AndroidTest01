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
import static net.a84jonghoon.app.androidtest01.global.Message.CONTENT;
import static net.a84jonghoon.app.androidtest01.global.Message.MESSAGE;
import static net.a84jonghoon.app.androidtest01.global.Message.RECEIVER;
import static net.a84jonghoon.app.androidtest01.global.Message.SENDER;
import static net.a84jonghoon.app.androidtest01.global.Message.WRITE_TIME;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, "androidTest1.db", null, 1);
        this.getWritableDatabase();
        Log.d("DB생성","==================");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE+"\n"+
                "(\n" +
                ID+" TEXT PRIMARY KEY,\n" +
                PW+" TEXT,\n" +
                NAME+" TEXT,\n" +
                EMAIL+" TEXT,\n" +
                PHONE+" TEXT,\n" +
                PHOTO+" TEXT,\n" +
                ADDR+" TEXT \n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ MESSAGE+"\n"+
                "(\n" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,\n"+
                SENDER+" TEXT,\n" +
                RECEIVER+" TEXT,\n" +
                WRITE_TIME+" TEXT,\n" +
                CONTENT+" TEXT,\n" +
                ID+" TEXT, CONSTRAINT message_fk FOREIGN KEY(id) REFERENCES "+TABLE+"("+ID+")\n" +
                ");");
        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('kim','123','KIM','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test1','123','테스트1','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test2','123','테스트2','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test3','123','테스트3','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test4','123','테스트4','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test5','123','테스트5','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ TABLE+" ("+ID+","+PW+","+NAME+","+
                EMAIL+","+PHONE+","+PHOTO+","+ADDR+")\n" +
                "VALUES ('test6','123','테스트6','mail@mail.com','02-1234-5678','n/a','n/a');");

        db.execSQL("INSERT INTO "+ MESSAGE+" ("+SENDER+","+RECEIVER+","+WRITE_TIME+","+CONTENT+")\n" +
                "VALUES ('KIM','LEE','2016-11-26 12:10','I LOVE YOU');");
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
        String sql = "INSERT INTO table("+ID+","+PW+","+NAME+","+EMAIL+","+PHONE+","+PHOTO+","+ADDR+
                ") VALUES("+param.getId()+","+param.getPw()+","+param.getName()+","+param.getEmail()+","+param.getPhone()+","+param.getPhoto()+","+param.getAddr()+");";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public int count(){
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM table";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        return count;
    }
    public MemberDTO findBy(String id){
        MemberDTO member = null;
        String sql = "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,PHONE,PHOTO,ADDR)
                +String.format(" FROM %s WHERE %s = '%s';", TABLE, ID, id);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null) {
            Log.d("findBy Result :","EXIST!!");
            if (cursor.moveToNext()) {
                member = new MemberDTO();
                member.setId(cursor.getString(0));
                member.setPw(cursor.getString(1));
                member.setEmail(cursor.getString(2));
                member.setPhone(cursor.getString(3));
                member.setPhoto(cursor.getString(4));
                member.setAddr(cursor.getString(5));
            }
        }
        return member;
    }
    public ArrayList<MemberDTO> list(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        String sql = "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,PHONE,PHOTO,ADDR)+" FROM member;";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        int i=0;
        if(cursor != null){
            Log.d("DAO LIST IS", "EXIST");
            cursor.moveToFirst();
        }

        do {
            MemberDTO member = new MemberDTO();
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAddr(cursor.getString(6));
            list.add(member);
        } while(cursor.moveToNext());

        return list;
    }
    public MemberDTO login(String id, String pw){
        Log.d("DAO LOGIN ID : ", id);
        Log.d("DAO LOGIN PW : ", pw);
        String sql = "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,PHONE,PHOTO,ADDR)+" FROM member WHERE ID = '"+id+"';";
        MemberDTO member = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            member = new MemberDTO();
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setEmail(cursor.getString(2));
            member.setPhone(cursor.getString(3));
            member.setPhoto(cursor.getString(4));
            member.setAddr(cursor.getString(5));
        }
        return member;
    }
    public void update(MemberDTO param){
        String sql = "UPDATE "+TABLE+" SET "
                +PW+" = '"+param.getPw()+"', "
                +NAME+" = '"+param.getName()+"', "
                +EMAIL+" = '"+param.getEmail()+"', "
                +PHONE+" = '"+param.getPhone()+"', "
                +PHOTO+" = '"+param.getPhoto()+"', "
                +ADDR+" = '"+param.getAddr()+"' "
                +"WHERE "+ID+" = '"+param.getId()+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();

    }
    public void delete(String id){
        Log.d("DAO DELETE ID : ", id);
        String sql = String.format("DELETE FROM %s WHERE %s = '%s';", TABLE, ID, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
}
