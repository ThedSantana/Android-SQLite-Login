package com.matt.loginapp.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Signup extends Activity{

    DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onButtonClick(View v){

        if (v.getId()==R.id.btnAdd){

            EditText txtAddUsername = (EditText) findViewById(R.id.txtAddUsername);
            EditText txtAddEmail = (EditText) findViewById(R.id.txtAddEmail);
            EditText txtAddPassword = (EditText) findViewById(R.id.txtAddPassword);
            EditText txtAddName = (EditText) findViewById(R.id.txtAddName);

            String username = txtAddUsername.getText().toString();
            String email = txtAddEmail.getText().toString();
            String password = txtAddPassword.getText().toString();
            String name = txtAddName.getText().toString();

            //insert details to DB
            User u = new User();
            u.setEmail(email);
            u.setName(name);
            u.setPassword(password);
            u.setUsername(username);

            helper.insertUser(u);

            Toast msg = Toast.makeText(Signup.this, "Successfully added", Toast.LENGTH_SHORT);
            msg.show();

        }
    }

}
