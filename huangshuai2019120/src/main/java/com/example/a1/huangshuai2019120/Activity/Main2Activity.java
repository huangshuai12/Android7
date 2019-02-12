package com.example.a1.huangshuai2019120.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1.huangshuai2019120.R;

public class Main2Activity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private EditText password1;
    private Button zhu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        zhu1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                String s = name.getText().toString();
                String s1 = password.getText().toString().trim();
                String s2 = password1.getText().toString().trim();
                if (s1.equals("")){
                    Toast.makeText(Main2Activity.this,"用户名不能为空",0).show();
                }else if (s1.equals("")){
                    Toast.makeText(Main2Activity.this,"密码不能为空",0).show();
                } else if (s2.equals("")){
                    Toast.makeText(Main2Activity.this,"确认密码不能为空",0).show();
                }else if(s1.equals("")!=s2.equals("")){
                    Toast.makeText(Main2Activity.this,"两次密码不一致",1).show();
                }else{
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void initView() {
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        password1 = (EditText) findViewById(R.id.password1);
        zhu1 = (Button) findViewById(R.id.zhu1);
    }
}
