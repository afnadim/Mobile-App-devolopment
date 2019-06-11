package com.example.nadim.countryfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity {
    //creating variable img i for information button
    ImageView img;
    Button bt_guest,bt_signUp,bt_signIn,bt_countrySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);


     //setting up listener for information button
        ImageView img= (ImageView) findViewById(R.id.imageView_main);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Home_Page.this,"Thhis is the accecibilty view of the application", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }


        });


        //setting listener for guest button
        bt_guest =(Button) findViewById(R.id.button_guest);
        bt_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"this is my first android app",Toast.LENGTH_LONG).show();
                Intent myIntent=new Intent(Home_Page.this,Main_Page.class);
                startActivity(myIntent);
            }
        });


        //setting listener for signup button
        bt_signUp =(Button) findViewById(R.id.button_Sign_up);
        bt_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Home_Page.this,Registration_page.class);
                startActivity(myIntent);
            }
        });

        //setting listener for signIn button
        bt_signIn =(Button) findViewById(R.id.button_sign_in);
        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Home_Page.this,Sign_in_page.class);
                startActivity(myIntent);
            }
        });

        bt_countrySearch =(Button) findViewById(R.id.button_country_information);
        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Home_Page.this,Activity_country.class);
                startActivity(myIntent);
            }
        });





    }
}
