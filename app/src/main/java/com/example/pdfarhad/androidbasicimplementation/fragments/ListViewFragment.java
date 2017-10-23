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
import com.example.pdfarhad.androidbasicimplementation.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class ListViewFragment extends Fragment {

    private View rootView ;
    private ListView listView;
    private CustomAdapter listViewAdapter;
    Context context;

    public static String [] authorListArray = {"Author 1","Author 2","Author 3","Author 4","Author 5","Author 6","Author 7","Author 8","Author 9","Author 10","Author 11","Author 12","Author 13","Author 14","Author 15","Author 16","Author 17"};
    public static String [] authorCountryListArray = {"Bangladesh","Oman","USA","Germany","Canada","Germany","USA","India","South Africa","Indonesia","Uganda","Uganda","Uganda","Uganda","Uganda","Uganda","Uganda"};
    ArrayList<String> authorList = new ArrayList<String>(Arrays.asList(authorListArray));
    ArrayList<String> authorCountryList = new ArrayList<String>(Arrays.asList(authorCountryListArray));

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.listview_fragment,null);
        listView = (ListView) rootView.findViewById(R.id.bookListView);

        listViewAdapter =  new CustomAdapter(getActivity(), authorList, authorCountryList);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(),authorList.get(position)
//                        +" "+
//                        authorCountryList.get(position),
//                        Toast.LENGTH_SHORT).show();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.listcontainer, new BookInfoFragment()).addToBackStack(null);
                ft.commit();
            }
        });


        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addBtnAction();
            }


        });


        return rootView;
    }

    private void addBtnAction() {
        Toast.makeText(getActivity(), "Floating Pressed", Toast.LENGTH_LONG).show();
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        Context context = this.getContext();
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText titleBox = new EditText(context);
        titleBox.setHint("Author Name");
        layout.addView(titleBox);

        final EditText descriptionBox = new EditText(context);
        descriptionBox.setHint("Country Name");
        layout.addView(descriptionBox);

        alert.setView(layout);


        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //What ever you want to do with the value
                Editable YouEditTextValue = titleBox.getText();
//                //OR
                String authorName = titleBox.getText().toString();
                String authorCountryName = descriptionBox.getText().toString();

                authorList.add(authorName);
                authorCountryList.add(authorCountryName);

                listViewAdapter.notifyDataSetChanged();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // what ever you want to do with No option.
                dialog.cancel();
            }
        });

        alert.show();
    }


}
