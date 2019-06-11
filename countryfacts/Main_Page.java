package com.example.nadim.countryfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main_Page extends AppCompatActivity {
    ImageView img;
    Button bt_countrySearch,bt_knowledge_test,bt_log_out,bt_notes,bt_viewNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);



        ImageView img= (ImageView) findViewById(R.id.imageView_main);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Main_Page.this,"This is the accecibilty view of the application", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }


        });
//setting up listener for  country knowledge button
        bt_countrySearch =(Button) findViewById(R.id.button_country_information);
        bt_countrySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Main_Page.this,Activity_country.class);
                startActivity(myIntent);
            }
        });
//setting up listener for knowledge test button
        bt_knowledge_test =(Button) findViewById(R.id.button_test_knowledge);
        bt_knowledge_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Main_Page.this,Knowledge_test.class);
                startActivity(myIntent);
            }
        });

        bt_notes =(Button) findViewById(R.id.button_notes);
        bt_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Main_Page.this,ActivityNote.class);
                startActivity(myIntent);
            }
        });


    }
}
