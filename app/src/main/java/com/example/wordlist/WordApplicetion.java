package com.example.wordlist;

/**
 * Created by 张笑佳 on 2016/10/29.
 */
import android.app.Application;
import android.content.Context;

public class WordApplicetion extends Application{
    private static Context context;
    public static Context getContext(){
        return WordsApplication.context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        WordsApplication.context=getApplicationContext();
    }
}
