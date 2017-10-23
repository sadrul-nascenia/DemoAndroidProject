package com.example.pdfarhad.androidbasicimplementation.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.pdfarhad.androidbasicimplementation.R;


public class LoginFragment extends Fragment {

    private View rootView ;
    private Button loginBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.login_fragment,null);
        manageLogInBtn();
        return rootView;
    }

    private void manageLogInBtn() {
        loginBtn = (Button) rootView.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Login Pressed", Toast.LENGTH_LONG).show();
                moveToListView();
            }
        });
    }

    private void moveToListView() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.listcontainer, new ListViewFragment()).addToBackStack(null);
        ft.commit();
    }

    public LoginFragment() {

    }
}
