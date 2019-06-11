package com.example.nadim.countryfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Registration_successfull extends AppCompatActivity {
    ImageView img;
    Button bt_click_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_successfull);

        ImageView img= (ImageView) findViewById(R.id.imageView_main);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Registration_successfull.this,"Thhis is the accecibilty view of the application", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }


        });
//take the user to login page once login button clicked
        bt_click_login =(Button) findViewById(R.id.button_login2);
        bt_click_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Registration_successfull.this,Sign_in_page.class);
                startActivity(myIntent);
            }
        });
        


    }
}
