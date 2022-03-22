package com.android.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button userView,userAdd,userDelete,userUpdate;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        userAdd=view.findViewById(R.id.userAdd);
        userView=view.findViewById(R.id.usersView);
        userDelete=view.findViewById(R.id.userDelete);
        userUpdate=view.findViewById(R.id.userUpdate);


        userAdd.setOnClickListener(this);
        userView.setOnClickListener(this);
        userDelete.setOnClickListener(this);
        userUpdate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userAdd:
                MainActivity.fragmentManager.beginTransaction().replace
                        (R.id.frame,new UserAddFragment()).addToBackStack(null).commit();
                break;
            case R.id.usersView:
                MainActivity.fragmentManager.beginTransaction().replace
                        (R.id.frame,new userViewFragment()).addToBackStack(null).commit();
                break;
            case R.id.userDelete:
                MainActivity.fragmentManager.beginTransaction().replace
                        (R.id.frame,new userDeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.userUpdate:
                MainActivity.fragmentManager.beginTransaction().replace
                        (R.id.frame,new userUpdateFragment()).addToBackStack(null).commit();
                break;

        }
    }
}