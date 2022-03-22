package com.android.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userUpdateFragment extends Fragment {
private  EditText txtId,txtName,txtEmail;
private  Button button;
    public userUpdateFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_user_update, container, false);
        txtId=view.findViewById(R.id.updateId);
        txtName=view.findViewById(R.id.updateName);
        txtEmail=view.findViewById(R.id.updateEmail);
        button=view.findViewById(R.id.updateSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = Integer.parseInt(txtId.getText().toString());
                String userName = txtName.getText().toString();
                String userEmail = txtEmail.getText().toString();
                User user = new User();
                user.setId(userId);
                user.setName(userName);
                user.setEmail(userEmail);
                MainActivity.appDatabase.userDao().updateUsers(user);
                Toast.makeText(getContext(), "kullanıcı Güncellendi", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}