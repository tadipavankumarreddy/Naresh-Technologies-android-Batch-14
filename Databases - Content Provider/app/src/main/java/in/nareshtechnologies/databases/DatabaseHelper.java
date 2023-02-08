package in.nareshtechnologies.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // WE create constants
    public static final String DATABASE_NAME = "myDb";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "persons";
    public static final String COL1 = "id";
    public static final String COL2 = "person_name";
    public static final String COL3 = "person_age";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // To create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_query = "create table "+TABLE_NAME+"("+COL1+" integer primary key autoincrement, "+COL2+" text, "+COL3+" integer);";
        sqLiteDatabase.execSQL(create_query);
    }

    //When there is a version change on the database, the first method that gets exeucted is this.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    // We write the logic for SQlite here only. we dont do database operations out of this file

    // How do we insert data
    public void insertData(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }

    // How to read data
    public Cursor getAllData(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("select * from "+TABLE_NAME, null);
    }
}
