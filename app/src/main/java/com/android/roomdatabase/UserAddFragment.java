package com.android.roomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserAddFragment extends Fragment {
    private EditText id, name, email;
    private Button save;

    public UserAddFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_add, container, false);
        id = view.findViewById(R.id.id);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int userId = Integer.parseInt(id.getText().toString());
                    String userName = name.getText().toString();
                    String userEmail = email.getText().toString();
                    User user = new User();
                    user.setId(userId);
                    user.setName(userName);
                    user.setEmail(userEmail);
                    MainActivity.appDatabase.userDao().insertUsers(user);
                    Toast.makeText(getContext(), id + ".kullanıcı eklendi", Toast.LENGTH_SHORT).show();
                } catch (Exception exception) {
                    Toast.makeText(getContext(), "Aynı id den iki tane olamaz ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}