package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.entity.Employee;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "Create Table User (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GENDER TEXT, EMAIL TEXT, " +
                "PASSWORD TEXT,CONTACT INTEGER)";

        String query2 = "Create Table Employee (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GENDER TEXT, EMAIL TEXT, PASSWORD TEXT,CONTACT INTEGER ,DEPARTMENT TEXT)";



        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void addNewUser(String userName, String email, String password,Integer contact){
        SQLiteDatabase DB= this.getReadableDatabase();


        ContentValues values= new ContentValues();
        values.put("Name",userName);
        values.put("Email",email);
        values.put("Password",password);
        values.put("Contact",contact);

        DB.insert("User",null,values);
        DB.close();
    }


    public  void addNewEmployee(Employee emp){
        SQLiteDatabase DB= this.getReadableDatabase();


        ContentValues values= new ContentValues();
        values.put("NAME",emp.getName());
        values.put("EMAIL",emp.getEmail());
        values.put("PASSWORD",emp.getPassword());
        values.put("CONTACT",emp.getContact());
        values.put("DEPARTMENT",emp.getDepartment());

        DB.insert("Employee",null,values);
        DB.close();
    }


    public int logIn(String userName,String password){
        int result=0;
        String []arr= new String[2];

        arr[0]=userName;
        arr[1]=password;

        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor c=DB.rawQuery("seLect * from User where NAME=? and PASSWORD =?" ,arr);

                ;if(c.moveToFirst()){
                    return  1;
      }else  return  0;
  }
}
