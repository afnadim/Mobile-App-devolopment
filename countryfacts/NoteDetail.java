package com.example.nadim.countryfacts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteDetail extends AppCompatActivity implements View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText NoteTitle;
    EditText NoteOne;
    EditText NoteTwo;
    private int _Note_Id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail );

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        NoteTitle = (EditText) findViewById(R.id.NoteTitle );
        NoteOne = (EditText) findViewById(R.id.NoteOne );
        NoteTwo = (EditText) findViewById(R.id.NoteTwo );

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Note_Id =0;
        Intent intent = getIntent();
        _Note_Id =intent.getIntExtra("Note_Id", 0);
        NoteRepo repo = new NoteRepo(this);
        Note note = new Note();
        note = repo.getNoteById( _Note_Id );

        NoteTwo.setText( note.noteTwo );
        NoteTitle.setText( note.title );
        NoteOne.setText( note.noteOne );
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            NoteRepo repo = new NoteRepo(this);
            Note note = new Note();
            note.noteTwo = NoteTwo.getText().toString();
            //note.noteTwo= Integer.parseInt(NoteTwo.getText().toString());
            note.noteOne = NoteOne.getText().toString();
            note.title = NoteTitle.getText().toString();
            note.Note_ID = _Note_Id;

            if (_Note_Id ==0){
                _Note_Id = repo.insert( note );

                Toast.makeText(this,"New Note Insert",Toast.LENGTH_SHORT).show();
            }else{

                repo.update( note );
                Toast.makeText(this,"Note Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            NoteRepo repo = new NoteRepo(this);
            repo.delete( _Note_Id );
            Toast.makeText(this, "Note Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}