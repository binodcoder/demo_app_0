package com.binoccoder.test6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView answer;
    Button send;
    int data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        answer=(TextView)findViewById(R.id.tv_answer);
        send=(Button)findViewById(R.id.btn_send_first);

        data=getIntent().getIntExtra("value",0);
        answer.setText(Integer.toString(data));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("value", data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bottom_menu, menu);
        return true;
    }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menu_first:
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_second:
                Toast.makeText(this, "second", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_third:
                Toast.makeText(this, "third", Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}