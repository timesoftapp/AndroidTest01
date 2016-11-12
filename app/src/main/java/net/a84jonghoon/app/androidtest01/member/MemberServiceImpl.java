package net.a84jonghoon.app.androidtest01.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberServiceImpl implements MemberService{

    MemberDAO memberDao;

    public MemberServiceImpl(Context context) {
        memberDao = new MemberDAO(context);
    }

    @Override
    public void join(MemberDTO param) {
        memberDao.join(param);
    }

    @Override
    public int count() {
        int count = memberDao.count();
        return count;
    }

    @Override
    public MemberDTO detail(String id) {
        MemberDTO member = new MemberDTO();
        member = memberDao.detail(id);
        return member;
    }

    @Override
    public ArrayList<MemberDTO> list() {
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        list = memberDao.list();
        return list;
    }

    @Override
    public MemberDTO login(String id, String pw) {
        MemberDTO member = new MemberDTO();
        member = memberDao.login(id, pw);
        return member;
    }

    @Override
    public void update(MemberDTO param) {
        memberDao.update(param);
    }

    @Override
    public void delete(MemberDTO param) {
        memberDao.delete(param);
    }
}
