package com.example.coronadailybd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.UserViewHolder> {

    private Context context;
    List<Data> userList;



    public Adapter(Context context, List<Data> userList) {
        this.context = context;
        this.userList = userList;





    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Data data = userList.get(position);
        String f = data.getDate();
        f = f.replaceAll("T.*", "");



        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(f);
            SimpleDateFormat sdfnewformat = new SimpleDateFormat("dd MMM yyyy");
            String finalDateString = sdfnewformat.format(convertedDate);
            holder.da.setText(finalDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        holder.con.setText(data.getConfirmed().toString());
        holder.deat.setText(data.getDeaths().toString());
        holder.rec.setText(data.getRecovered().toString());
        holder.ac.setText(data.getActive().toString());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView da, con, deat, rec, ac;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            da = itemView.findViewById(R.id.textView);
            con = itemView.findViewById(R.id.textView11);
            deat = itemView.findViewById(R.id.textView12);
            rec = itemView.findViewById(R.id.textView13);
            ac = itemView.findViewById(R.id.textView14);
        }
    }



}
