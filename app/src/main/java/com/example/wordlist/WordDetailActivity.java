package com.example.wordlist;

/**
 * Created by 张笑佳 on 2016/10/29.
 */
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 *横屏显示全部单词
 */
public class WordDetailActivity extends AppCompatActivity implements WordDetailFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //如果是横屏的话直接退出
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        }
        WordDetailFragment detailFragment = new WordDetailFragment();
        detailFragment.setArguments(getIntent().getExtras());
        getFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, detailFragment)
                .commit();

    }

    @Override
    public void onWordDetailClick(Uri uri) {

    }
}
