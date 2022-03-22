package com.android.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userDeleteFragment extends Fragment {
private EditText text;
private Button button;

    public userDeleteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_user_delete, container, false);
        text=view.findViewById(R.id.deleteId);
        button=view.findViewById(R.id.delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(text.getText().toString());
                User user=new User();
                user.setId(id);
                MainActivity.appDatabase.userDao().deleteUsers(user);
                Toast.makeText(getContext(), id+".Kullanıcı silndi", Toast.LENGTH_SHORT).show();
            }
        });
        return  view;
    }
}