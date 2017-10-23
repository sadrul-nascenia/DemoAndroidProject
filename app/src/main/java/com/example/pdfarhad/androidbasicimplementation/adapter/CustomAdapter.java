package com.example.pdfarhad.androidbasicimplementation.adapter;

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

public class CustomAdapter extends BaseAdapter {


    ArrayList<String> authorList;
    ArrayList<String> authorCountryList;
    Context context;

    private static LayoutInflater inflater = null;

    public CustomAdapter(Context context, ArrayList<String> authorList, ArrayList<String> authorCountryList) {
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
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.book_list, null);
            holder = new Holder();
            holder.tv1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.tv2 = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        String data1 = authorCountryList.get(position);
        String data2 = authorList.get(position);

        Log.i("data", data1+ " " + data2);
        holder.tv1.setText(data1);
        holder.tv2.setText(data2);

        return convertView;
    }
}
