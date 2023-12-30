package com.example.delete_data_from_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed_name,ed_co_name;
    Button submit,view;
    public OpenHelper openHelper;
    int id=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name=findViewById(R.id.text_name);
        ed_co_name=findViewById(R.id.text_course_name);
        submit=findViewById(R.id.submit_btn);
        view=findViewById(R.id.view_btn);

        openHelper = new OpenHelper(MainActivity.this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_name=ed_name.getText().toString();
                String s_c_name=ed_co_name.getText().toString();

                if(s_name.isEmpty() && s_c_name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Oops!!Look like some fields are empty!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    openHelper.add_data(s_name,s_c_name);
                    Toast.makeText(MainActivity.this, "Data added!!", Toast.LENGTH_SHORT).show();
                    ed_name.setText("");
                    ed_co_name.setText("");
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}