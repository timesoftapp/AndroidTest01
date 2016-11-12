package net.a84jonghoon.app.androidtest01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.a84jonghoon.app.androidtest01.calc.CalcActivity;
import net.a84jonghoon.app.androidtest01.member.JoinActivity;
import net.a84jonghoon.app.androidtest01.member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_calc, bt_join, bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_calc = (Button) findViewById(R.id.bt_calc);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login = (Button) findViewById(R.id.bt_login);

        bt_calc.setOnClickListener(this);
        bt_join.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt_calc :
                intent = new Intent(this.getApplicationContext(), CalcActivity.class);
                this.startActivity(intent);
                break;
            case R.id.bt_join :
                intent = new Intent(this.getApplicationContext(), JoinActivity.class);
                this.startActivity(intent);
                break;
            case R.id.bt_login :
                intent = new Intent(this.getApplicationContext(), LoginActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}
