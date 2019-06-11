package com.example.nadim.countryfacts;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivityNote extends ListActivity  implements View.OnClickListener{

    Button btnAdd,btnGetAll;
    TextView Note_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,NoteDetail.class);
            intent.putExtra("Note_Id",0);
            startActivity(intent);

        }else {

            NoteRepo repo = new NoteRepo(this);

            ArrayList<HashMap<String, String>> NoteList =  repo.getNoteList();
            if(NoteList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        Note_Id = (TextView) view.findViewById(R.id.Note_Id );
                        String NoteId = Note_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),NoteDetail.class);
                        objIndent.putExtra("Note_Id", Integer.parseInt( NoteId ));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( ActivityNote.this, NoteList, R.layout.view_note_entry, new String[] { "id","title"}, new int[] {R.id.Note_Id, R.id.Note_title});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No Note!",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note );

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

    }


}