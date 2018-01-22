package com.frandog.a20180122_02;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//前言:此專案跟20180122_01的不同點是，當資料庫於更新後有新增欄位時，用01的方法會讓新資料庫全部敷蓋舊資料庫，導致資料全部喪失，01專案適合用在使用者只讀不寫的狀況，所以資料被敷蓋也無所謂。
//在02專案中，會檢查使用者版本號，依據不同版本做不同更新，用新增而非敷蓋的方式來增加欄位。


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyHelper helper = new MyHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
    }
}
