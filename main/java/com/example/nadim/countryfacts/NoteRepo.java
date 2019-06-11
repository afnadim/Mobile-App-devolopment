package com.example.nadim.countryfacts;

/**
 * Created by Nadim on 03/12/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class NoteRepo {
    private DBHelper dbHelper;

    public NoteRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Note Notes) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( Note.NOTE_two, Notes.noteTwo );
        values.put( Note.NOTE_one, Notes.noteOne );
        values.put( Note.KEY_note, Notes.title );

        // Inserting Row
        long Note_Id = db.insert( Note.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) Note_Id;
    }

    public void delete(int note_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete( Note.TABLE, Note.KEY_ID + "= ?", new String[] { String.valueOf( note_Id ) });
        db.close(); // Closing database connection
    }

    public void update(Note note) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( Note.NOTE_two, note.noteTwo );
        values.put( Note.NOTE_one, note.noteOne );
        values.put( Note.KEY_note, note.title );

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update( Note.TABLE, values, Note.KEY_ID + "= ?", new String[] { String.valueOf( note.Note_ID ) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getNoteList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Note.KEY_ID + "," +
                Note.KEY_note + "," +
                Note.NOTE_one + "," +
                Note.NOTE_two +
                " FROM " + Note.TABLE;

        //Note student = new Note();
        ArrayList<HashMap<String, String>> noteList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> note = new HashMap<String, String>();
                note.put("id", cursor.getString(cursor.getColumnIndex( Note.KEY_ID )));
                note.put("title", cursor.getString(cursor.getColumnIndex( Note.KEY_note )));
                noteList.add( note );

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return noteList;

    }

    public Note getNoteById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Note.KEY_ID + "," +
                Note.KEY_note + "," +
                Note.NOTE_one + "," +
                Note.NOTE_two +
                " FROM " + Note.TABLE
                + " WHERE " +
                Note.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Note note = new Note();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                note.Note_ID =cursor.getInt(cursor.getColumnIndex( Note.KEY_ID ));
                note.title =cursor.getString(cursor.getColumnIndex( Note.KEY_note ));
                note.noteOne =cursor.getString(cursor.getColumnIndex( Note.NOTE_one ));
                note.noteTwo =cursor.getString(cursor.getColumnIndex( Note.NOTE_two ));
                //note.noteTwo =cursor.getInt(cursor.getColumnIndex(Note.NOTE_two));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return note;
    }

}