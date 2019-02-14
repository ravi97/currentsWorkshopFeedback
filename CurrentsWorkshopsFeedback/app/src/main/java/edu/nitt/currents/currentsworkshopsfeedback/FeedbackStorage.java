package edu.nitt.currents.currentsworkshopsfeedback;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ravi on 14/2/17.
 */

public class FeedbackStorage extends SQLiteOpenHelper {


    private static int DATABASE_VERSION=1;
    private static String DATABASE_NAME="feedback.db";
    private static String TABLE_NAME="currentsfeedback";
    private static String COLUMN_ID="ID";
    private static String COLUMN_WORKSHOP="WORKSHOP";
    private static String COLUMN_Q1="Q1";
    private static String COLUMN_Q2="Q2";
    private static String COLUMN_Q3="Q3";
    private static String COLUMN_Q4="Q4";
    private static String COLUMN_Q5="Q5";
    private static String COLUMN_Q6="Q6";
    private static String COLUMN_Q7="Q7";
    private static String COLUMN_Q8="Q8";
    private static String COLUMN_Q9="Q9";


    public FeedbackStorage(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " TEXT," +
                COLUMN_WORKSHOP + " TEXT," +
                COLUMN_Q1 + " TEXT," +
                COLUMN_Q2 + " TEXT," +
                COLUMN_Q3 + " TEXT," +
                COLUMN_Q4 + " TEXT," +
                COLUMN_Q5 + " TEXT," +
                COLUMN_Q6 + " TEXT," +
                COLUMN_Q7 + " TEXT," +
                COLUMN_Q8 + " TEXT," +
                COLUMN_Q9 + " TEXT);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public Cursor returnFullTableCursor(){
        Cursor c=null;
        SQLiteDatabase db=getWritableDatabase();
        c=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return c;
    }

   public void addRow(Feedback feedback){
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,feedback.getCurrents_id());
        values.put(COLUMN_WORKSHOP,feedback.getWorkshop());
        values.put(COLUMN_Q1,feedback.getQ1());
       values.put(COLUMN_Q2,feedback.getQ2());
       values.put(COLUMN_Q3,feedback.getQ3());
       values.put(COLUMN_Q4,feedback.getQ4());
       values.put(COLUMN_Q5,feedback.getQ5());
       values.put(COLUMN_Q6,feedback.getQ6());
       values.put(COLUMN_Q7,feedback.getQ7());
       values.put(COLUMN_Q8,feedback.getQ8());
       values.put(COLUMN_Q9,feedback.getQ9());

        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
