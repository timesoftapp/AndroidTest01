package net.a84jonghoon.app.androidtest01.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO {
    public MemberDAO(Context context) {

    }

    public void join(MemberDTO param){

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
        return list;
    }
    public MemberDTO login(String id, String pw){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
