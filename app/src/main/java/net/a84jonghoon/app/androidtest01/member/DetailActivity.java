package net.a84jonghoon.app.androidtest01.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.a84jonghoon.app.androidtest01.R;

public class DetailActivity extends AppCompatActivity {

    MemberService service;
    ImageView iv_photo;
    TextView tv_name, tv_id, tv_pw, tv_email, tv_phone, tv_address;
    Button bt_call, bt_message, bt_map, bt_movie, bt_update, bt_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_address = (TextView) findViewById(R.id.tv_address);
        String id = this.getIntent().getExtras().getString("id");
        MemberDTO member = service.detail(id);
        if(member != null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            tv_pw.setText(member.getPw());
            tv_email.setText(member.getEmail());
            tv_address.setText(member.getAddr());
            tv_phone.setText(member.getPhone());
//            iv_photo.setImageURI();
        } else {
            Log.d("아이디가 존재","하지 않음");
        }

        bt_call = (Button) findViewById(R.id.bt_call);
        bt_message = (Button) findViewById(R.id.bt_message);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);
    }
}
