package edu.tu.androidlayout.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    String TAG = "Database";
    public static final int VERSION=2;
    public static final String DATABASE="studentdata";
    public static final String TABLE_NAME="student_table";
    public static final String COL_NAME="name";
    public static final String COL_MOBILE="mobile";
    public static final String COL_ADDRESS="address";
    public static final String COL_SALARY="salary";
    public static final String COL_EMAIL="email";
    public static final String COL_PASSWORD="password";

    public Database(Context mContext){
        super(mContext,DATABASE,null,VERSION);
    }

    //Creating a Table and this will be first to execute.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableS="CREATE TABLE "+TABLE_NAME+"( "+COL_NAME+ " VARCHAR(50), "+
                COL_ADDRESS+" VARCHAR(150), "+
                COL_EMAIL+" VARCHAR(50), "+
                COL_MOBILE+" VARCHAR(15) PRIMARY KEY, "+
                COL_SALARY+" VARCHAR(10), "+
                COL_PASSWORD+" VARCHAR(30) "+")";
        sqLiteDatabase.execSQL(tableS);
        Log.d(TAG, "onCreate: table created");
    }

    //If we have a changes in Table Alteration(adding/reducing new field/column in a Table)., then we have to increase the version
    //so that we should not reinstall the appilication to make a changes available.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        if(newversion > oldversion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
    }

    //This method is to check weather the table exist or not.
    public boolean doesTableExist(String tableName) {
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'",
                null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }


    //Inserting in the table
    public int addValue(Student student){
        SQLiteDatabase db=getWritableDatabase();
        Log.d("TAGTT", "addValue: "+student.getPassword());
        ContentValues cv=new ContentValues();
        cv.put(COL_NAME,student.getName());
        cv.put(COL_ADDRESS,student.getAddress());
        cv.put(COL_EMAIL,student.getEmail());
        cv.put(COL_MOBILE,student.getMobile());
        cv.put(COL_SALARY,student.getSalary());
        cv.put(COL_PASSWORD,student.getPassword());
        int i =-1;//we got some error while trying to insert.
        if(!(isValueExist(student))){
            i=(int)db.insert(TABLE_NAME,null,cv);
        }
        else{
            i = -2;//-2 indicates the error due to already existing Mobile Number.
        }

        Log.d(TAG, "addValue: i " +i);
        db.close();
        return i;
    }


    //Retrieving value from Table using WHERE clause
    public Student getValue(String email, String password){
        SQLiteDatabase db=getWritableDatabase();
        Student student=new Student();
        @SuppressLint("Recycle") Cursor c= db.query(TABLE_NAME,new String[]{COL_NAME,COL_EMAIL,COL_MOBILE,COL_ADDRESS,COL_SALARY,COL_PASSWORD},
                COL_EMAIL+" = ? and "+COL_PASSWORD+" =? ",new String[]{email,password},null,null,null,null);
        Log.d(TAG, "getValue: count " +c.getCount() );
        if (c.moveToFirst()){
            student.setName(c.getString(0));
            student.setEmail(c.getString(1));
            student.setMobile(c.getString(2));
            student.setAddress(c.getString(3));
            student.setSalary(c.getString(4));
            student.setPassword(c.getString(5));
            return student;
        }else{
            return null;
        }
    }

    public List<Student> getStudentList(){
        SQLiteDatabase db=getWritableDatabase();
        List<Student> list = new ArrayList<>();
        @SuppressLint("Recycle") Cursor c= db.query(TABLE_NAME,new String[]{COL_NAME,COL_EMAIL,COL_MOBILE,COL_ADDRESS,COL_SALARY},
                COL_PASSWORD+" IS NULL ", null,null,null,null,null);
        Log.d(TAG, "getStudentList: count " +c.getCount() );
        if (c.moveToFirst()){
            do{
                Student student=new Student();
                student.setName(c.getString(0));
                student.setEmail(c.getString(1));
                student.setMobile(c.getString(2));
                student.setAddress(c.getString(3));
                student.setSalary(c.getString(4));
                list.add(student);
            }while (c.moveToNext());
        }
        return list;
    }

    private boolean isValueExist(Student student){
        SQLiteDatabase db=getWritableDatabase();

        @SuppressLint("Recycle") Cursor c= db.query(TABLE_NAME,new String[]{COL_NAME,COL_EMAIL,COL_MOBILE,COL_ADDRESS,COL_SALARY,COL_PASSWORD},
                COL_MOBILE+" =? ",new String[]{student.getMobile()},null,null,null,null);
        Log.d(TAG, "getValue: count " +c.getCount() );
        if (c.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateValue(Student student){

        return true;
    }

    public int  deleteValue(Student student){
        SQLiteDatabase db=getWritableDatabase();
        int i = -1;
        if(isValueExist(student)){
            i = db.delete(TABLE_NAME, COL_MOBILE + " =? AND " +COL_PASSWORD + " IS NULL ", new String[]{student.getMobile()} );
        }
        return i;
    }
}