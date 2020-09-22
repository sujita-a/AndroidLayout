package edu.tu.androidlayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    String TAG = "Database";

    private final static String DATABASE_NAME = "androidproject";
    private final static Integer VERSION_NAME = 1;
    private final static String TABLE_LOGIN = "login_table";
    private final static String COL_EMAIL ="email";
    private final static String COL_PASSWORD ="password";
    private final static String COL_NAME ="name";
    private final static String COL_ADDRESS ="address";
    private final static String COL_MOBILE ="mobile";
    private final static String COL_SALARY ="salary";

    String myTable = "CREATE TABLE " +TABLE_LOGIN+ "(" + COL_NAME + " VARCHAR(30), " + COL_ADDRESS + " VARCHAR(50), " + COL_EMAIL + " VARCHAR(20), " +
            COL_MOBILE  + " VARCHAR(14), " + COL_SALARY  + " VARCHAR(20), " + COL_PASSWORD  + " VARCHAR(20) " + ")" ;


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null,VERSION_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(myTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN );
            sqLiteDatabase.execSQL(myTable);

        }

    }

    public void addValues(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, student.getName());
        cv.put(COL_ADDRESS, student.getAddress());
        cv.put(COL_EMAIL, student.getEmail());
        cv.put(COL_MOBILE, student.getMobile());
        cv.put(COL_SALARY, student.getSalary());
        cv.put(COL_PASSWORD, student.getPassword());
        int i = (int) db.insertWithOnConflict(TABLE_LOGIN, null, cv, SQLiteDatabase.CONFLICT_IGNORE);
        Log.d(TAG, "addValues: " + i) ;
    }
}
