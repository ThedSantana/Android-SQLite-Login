package com.matt.loginapp.loginapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mcpar on 11/19/2015.
 */
public class Display extends Activity{

    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("Username");

        TextView tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvUsername.setText(username);

    }

    public void onButtonClick(View v){

        if (v.getId() == R.id.btnLogout){
            sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor  editor = sharedPref.edit();
            editor.putBoolean("loggedin", false);
            editor.apply();

            Toast msg = Toast.makeText(Display.this, "You have logged out", Toast.LENGTH_SHORT);
            msg.show();
        }

    }

}
