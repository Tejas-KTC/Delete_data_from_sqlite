package com.example.delete_data_from_sqlite;

import static com.example.delete_data_from_sqlite.OpenHelper.DB_TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    OpenHelper openHelper;
    MyAdapter myAdapter;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        openHelper =  new OpenHelper(this);
        find_id();
        display();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void display() {
        sqLiteDatabase = openHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DB_TABLE_NAME,null);
        ArrayList<Model> modelArrayList = new ArrayList<>();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String co_name = cursor.getString(1);
            String co_c_name = cursor.getString(2);
            modelArrayList.add(new Model(id,co_name,co_c_name));
        }
        cursor.close();
        myAdapter = new MyAdapter(this,R.layout.userentry,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }

    private void find_id() {
        recyclerView = findViewById(R.id.recycleview);
    }
}