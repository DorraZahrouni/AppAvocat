package com.example.dorra.screensplash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileActivity extends AppCompatActivity {
    //@BindView(R.id.profile_username) EditText _usernameText;
    //final Intent intent = getIntent();
    //final String username = intent.getExtras().getString("ROOT");
    DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_profile_screen_xml_ui_design);
        //ButterKnife.bind(this);
        String username = getIntent().getStringExtra("EXTRA_CURRENT_USERNAME");

        Avocat user = db.getAvocat(username);
        //_usernameText.setText(user.getNom());
    }


}