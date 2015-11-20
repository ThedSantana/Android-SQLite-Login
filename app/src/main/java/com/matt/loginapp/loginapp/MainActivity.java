package com.matt.loginapp.loginapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    DBHelper helper = new DBHelper(this);
    EditText txtUsername;
    EditText txtPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        boolean loggedin = sharedPref.getBoolean("loggedin", false);

        if (loggedin){
            String username = sharedPref.getString("username", "");

            Intent i = new Intent(this, Display.class);
            i.putExtra("Username", username);

            startActivity(i);
        }

        txtUsername = (EditText)findViewById(R.id.txtAddUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
    }

    public void onButtonClick(View v){

        if (v.getId() == R.id.btnLogin){
            String username = txtUsername.getText().toString();
            String pass = txtPassword.getText().toString();

            String password = helper.searchPass(username);

            if (password.equals(pass)){

                sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor  editor = sharedPref.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.putBoolean("loggedin", true);
                editor.apply();

                Intent i = new Intent(this, Display.class);
                i.putExtra("Username", username);

                startActivity(i);
            }
            else{
                Toast msg = Toast.makeText(MainActivity.this, "Incorrect login credentials", Toast.LENGTH_SHORT);
                msg.show();
            }
        }

        if (v.getId()==R.id.btnSignup){
            Intent i = new Intent(this, Signup.class);
            startActivity(i);
        }
    }


}
