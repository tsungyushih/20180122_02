package com.frandog.a20180122_02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2018/1/22.
 */
//新增class並繼承SQLiteOpenHelper

public class MyHelper extends SQLiteOpenHelper {

//原來的建構式寫法，但由於MyHelper是自己寫的，所以引數2、4也可以自己寫
//    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
    final static String DB_NAME = "student.sqlite";
    final static int VERSION = 1;       //此APP的版本號
    public MyHelper(Context context){
        super(context,DB_NAME,null,VERSION);
    }



    @Override       //用精靈implement methods
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        用DB Browser開01用的資料庫，複製其"架構"，並貼到引數裡
        sqLiteDatabase.execSQL("CREATE TABLE \"students\" ( `_id` INTEGER, `name` TEXT, `score` INTEGER, PRIMARY KEY(`_id`) )");        //記得貼上引數前先寫雙引號""，這樣貼上時精靈才會自動填上跳脫字元
    }

    @Override       //用精靈implement methods
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {      //引數2為使用者版本號，引數3為此最新版本號，要寫出每一個版本更新時的內容，例如最新為3，那就要寫1>3與2>3的不同更新內容，避免當使用者從1直接跳到3時，可能會漏掉版本2新增的欄位

    }
}
