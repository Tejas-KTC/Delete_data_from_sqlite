package com.example.delete_data_from_sqlite;

import static com.example.delete_data_from_sqlite.OpenHelper.DB_TABLE_NAME;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<Model> modelArrayList = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public MyAdapter(Context context, int userentry, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Model model = modelArrayList.get(position);
        holder.name.setText(model.getM_name());
        holder.co_name.setText(model.getM_C_name());

        holder.del_txt.setOnClickListener(new View.OnClickListener() {
            final OpenHelper openHelper = new OpenHelper(context);
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openHelper.getReadableDatabase();
                long delete = sqLiteDatabase.delete(DB_TABLE_NAME,"id="+model.getId(),null);
                if (delete!=-1){
                    Toast.makeText(context, "Data deleted!!", Toast.LENGTH_SHORT).show();
                    modelArrayList.remove(position);
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,co_name,del_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.item_name);
            co_name = (TextView) itemView.findViewById(R.id.item_course_name);
            del_txt = (TextView) itemView.findViewById(R.id.del_text);
        }
    }
}
