package com.example.pdfarhad.androidbasicimplementation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.example.pdfarhad.androidbasicimplementation.R;
import com.example.pdfarhad.androidbasicimplementation.adapter.BookInfoAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class BookInfoFragment extends Fragment {

    private View rootView ;
    private ListView listView;
    private BookInfoAdapter listViewAdapter;
    Context context;

    public static String [] authorListArray = {"Title1dfdsjfoijdfoijdsofjsdofjdospjfodsfodsjfodjsfojdsofjdosfjodsjfojdsf","Author 2","Author 3","Author 4","Author 5"};
    public static String [] authorCountryListArray = {"Bangladesh","Oman","USA","Germany","Canada"};
    ArrayList<String> authorList = new ArrayList<String>(Arrays.asList(authorListArray));
    ArrayList<String> authorCountryList = new ArrayList<String>(Arrays.asList(authorCountryListArray));


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.book_info,null);

        listView = (ListView) rootView.findViewById(R.id.bookInfoListView);
        listViewAdapter =  new BookInfoAdapter(getActivity(), authorList, authorCountryList);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),authorList.get(position)
                        +" "+
                        authorCountryList.get(position),
                        Toast.LENGTH_SHORT).show();


                listView.removeViewAt(position);
                listViewAdapter.notifyDataSetChanged();

            }
        });



        return rootView;
    }
}
