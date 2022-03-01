package com.binoccoder.test6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumber, secondNumber;
    private Button findSum, send;
    private TextView findResult, status;
    int c=0;
    final int rCode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber=(EditText)findViewById(R.id.et_num1);
        secondNumber=(EditText)findViewById(R.id.et_num2);
        findSum=(Button)findViewById(R.id.btn_find_sum);
        findResult=(TextView)findViewById(R.id.tv_result);
        send=(Button)findViewById(R.id.btn_send);
        status=(TextView)findViewById(R.id.tv_status);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("value", c);
                startActivityForResult(intent, rCode);
            }
        });

        findSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(firstNumber.getText().toString());
                int b=Integer.parseInt(secondNumber.getText().toString());
                c=a+b;
                findResult.setText(Integer.toString(c));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int ans=data.getIntExtra("value", 0);
        if(requestCode==rCode){
            if(resultCode==RESULT_OK){
                status.setText(Integer.toString(ans));
            }
        }
    }
}