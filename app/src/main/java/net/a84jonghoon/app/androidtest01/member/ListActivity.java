package net.a84jonghoon.app.androidtest01.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.a84jonghoon.app.androidtest01.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    MemberService service;
    ListView lv_member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberDTO> list = service.list();
        Log.d("친구 수 : ",String.valueOf(list.size()));
        lv_member = (ListView) findViewById(R.id.lv_member);
        lv_member.setAdapter(new MemberAdapter(this, list));
        lv_member.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long id) {
                Object o = lv_member.getItemIdAtPosition(i);
                MemberDTO member = (MemberDTO) o;

                Toast.makeText(ListActivity.this, "로그인 성공!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
            }
        });

        lv_member.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }
}
