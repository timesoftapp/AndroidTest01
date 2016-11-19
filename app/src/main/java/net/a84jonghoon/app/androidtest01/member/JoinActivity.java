package net.a84jonghoon.app.androidtest01.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.a84jonghoon.app.androidtest01.MainActivity;
import net.a84jonghoon.app.androidtest01.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id,et_pw,et_name,et_email,et_phone,et_photo,et_addr;
    Button bt_joinOk, bt_joinCancel;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_photo = (EditText) findViewById(R.id.et_photo);
        et_addr = (EditText) findViewById(R.id.et_addr);
        bt_joinOk = (Button) findViewById(R.id.bt_joinOk);
        bt_joinCancel = (Button) findViewById(R.id.bt_joinCancel);

        bt_joinOk.setOnClickListener(this);
        bt_joinCancel.setOnClickListener(this);

        service = new MemberServiceImpl(this.getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.bt_joinOk :
                join();
                break;
            case R.id.bt_joinCancel :
                intent = new Intent(JoinActivity.this, MainActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    public void join(){
        MemberDTO dto = new MemberDTO();
        dto.setId(et_id.getText().toString());
        dto.setPw(et_pw.getText().toString());
        dto.setName(et_name.getText().toString());
        dto.setEmail(et_email.getText().toString());
        dto.setPhoto(et_photo.getText().toString());
        dto.setPhone(et_phone.getText().toString());
        dto.setAddr(et_addr.getText().toString());
        service.join(dto);
    }
}
