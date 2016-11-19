package net.a84jonghoon.app.androidtest01.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.a84jonghoon.app.androidtest01.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_loginId,et_loginPw;
    Button bt_loginOk, bt_loginCancel;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());

        et_loginId = (EditText) findViewById(R.id.et_LoginId);
        et_loginPw = (EditText) findViewById(R.id.et_LoginPw);
        bt_loginOk = (Button) findViewById(R.id.bt_LoginOk);
        bt_loginCancel = (Button) findViewById(R.id.bt_LoginCancel);

        bt_loginOk.setOnClickListener(this);
        bt_loginCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = et_loginId.getText().toString();
        String pw = et_loginPw.getText().toString();
        MemberDTO param = new MemberDTO();
        param.setId(id);
        param.setPw(pw);
        Intent intent;
        switch (v.getId()){
            case R.id.bt_LoginOk :
                if(service.login(param)){
                    Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_LONG).show();
                    intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("id",id);
                    this.startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "로그인 실패!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_LoginCancel :
                break;


        }
    }
}
