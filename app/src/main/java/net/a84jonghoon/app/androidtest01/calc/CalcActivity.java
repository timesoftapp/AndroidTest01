package net.a84jonghoon.app.androidtest01.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.a84jonghoon.app.androidtest01.R;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_first,et_second;
    Button bt_plu,bt_min,bt_mul,bt_div,bt_mod;
    TextView tv_result;
    int resNum;
    CalcService calcService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        calcService = new CalcServiceImpl();
        et_first = (EditText) findViewById(R.id.et_first);
        et_second = (EditText) findViewById(R.id.et_second);
        bt_plu = (Button) findViewById(R.id.bt_plu);
        bt_min = (Button) findViewById(R.id.bt_min);
        bt_mul = (Button) findViewById(R.id.bt_mul);
        bt_div = (Button) findViewById(R.id.bt_div);
        bt_mod = (Button) findViewById(R.id.bt_mod);
        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_plu.setOnClickListener(this);
        bt_min.setOnClickListener(this);
        bt_mul.setOnClickListener(this);
        bt_div.setOnClickListener(this);
        bt_mod.setOnClickListener(this);

        resNum = 0;
    }

    @Override
    public void onClick(View v) {
        if(et_first.getText().toString() == null || et_first.getText().toString().isEmpty()) {
            tv_result.setText("Result : ");
            return;
        }
        if(et_second.getText().toString() == null || et_second.getText().toString().isEmpty()) {
            tv_result.setText("Result : ");
            return;
        }
        int firstNum = Integer.parseInt(et_first.getText().toString());
        int secondNum = Integer.parseInt(et_second.getText().toString());
        CalcDTO dto = new CalcDTO();
        dto.setFirst(firstNum);
        dto.setSecond(secondNum);
        switch (v.getId()){
            case R.id.bt_plu :
                resNum = firstNum + secondNum;
                break;
            case R.id.bt_min :
                resNum = firstNum - secondNum;
                break;
            case R.id.bt_mul :
                resNum = firstNum * secondNum;
                break;
            case R.id.bt_div :
                resNum = firstNum / secondNum;
                break;
            case R.id.bt_mod :
                resNum = firstNum % secondNum;
                break;
        }

        tv_result.setText("Result : " + resNum);
    }
}
