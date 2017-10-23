package com.example.pdfarhad.androidbasicimplementation.adapter;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pdfarhad.androidbasicimplementation.R;
import com.example.pdfarhad.androidbasicimplementation.activity.MainActivity;

import java.util.ArrayList;

public class BookInfoAdapter  extends BaseAdapter {

    ArrayList<String> authorList;
    ArrayList<String> authorCountryList;
    Context context;

    private static LayoutInflater inflater = null;

    public BookInfoAdapter(Context context, ArrayList<String> authorList, ArrayList<String> authorCountryList) {
        // TODO Auto-generated constructor stub
        this.authorList = authorList;
        this.authorCountryList = authorCountryList;
        this.context = context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return authorList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tv1;
        TextView tv2;
        ImageView removeImageView;
        ImageView imageView;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.book_info_cell, null);
            holder = new Holder();

            holder.tv1 = (TextView) convertView.findViewById(R.id.textView5);
            holder.tv2 = (TextView) convertView.findViewById(R.id.textView6);
            holder.removeImageView= (ImageView) convertView.findViewById(R.id.removeImageView);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        String data1 = authorCountryList.get(position);
        String data2 = authorList.get(position);

        Log.i("data", data1+ " " + data2);
        holder.tv1.setText(data1);
        holder.tv2.setText(data2);

        /*holder.removeImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                authorCountryList.remove(position);
                authorList.remove(position);
                notifyDataSetChanged();
            }
        });*/


        return convertView;
    }
}
