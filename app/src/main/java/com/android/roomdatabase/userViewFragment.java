package com.android.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class userViewFragment extends Fragment {
TextView textView;


    public userViewFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_user_view, container, false);
        textView=view.findViewById(R.id.txtDataView);
        List<User> user=MainActivity.appDatabase.userDao().getData();
        String data="";
        for (User user1:user){
            int id=user1.getId();
            String name=user1.getName();
            String email=user1.getEmail();
            data=data+"\n"+"Id: "+id+" "+"İsim: "+name+" "+"Email: "+email;
        }
       textView.setText(data);
        return view;
    }
}