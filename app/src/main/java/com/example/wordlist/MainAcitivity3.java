package com.example.wordlist;

/**
 * Created by 张笑佳 on 2016/10/29.
 */
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 2016/10/15.
 */
public class MainAcitivity3 extends AppCompatActivity {
    private String strMeaning;
    private EditText get_English;
    private TextView result_Ch;
    private Button translate, input, return3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        get_English = (EditText) findViewById(R.id.English);
        result_Ch = (TextView) findViewById(R.id.result);
        translate = (Button) findViewById(R.id.translate);
        input = (Button) findViewById(R.id.input);
        return3 = (Button) findViewById(R.id.return3);

        return3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String request = get_English.getText().toString();
                RequestUtils requestUtils = new RequestUtils();
                if (!request.isEmpty()) {
                    try {
                        requestUtils.translate(request, "auto", "auto", new HttpCallBack() {
                            @Override
                            public void onSuccess(String result) {
                                result_Ch.setText(result);
                                strMeaning = result;
                            }

                            @Override
                            public void onFailure(String exception) {
                                result_Ch.setText(exception);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity3.this, "请输入要翻译的内容", Toast.LENGTH_SHORT).show();
                }

            }
        });
        input.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String request = get_English.getText().toString();
                WordsDB wordsDB = WordsDB.getWordsDB();
                wordsDB.InsertUserSql(request, strMeaning, "");
                Toast.makeText(MainActivity3.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void RefreshWordItemFragment(String strWord) {
        WordItemFragment wordItemFragment = (WordItemFragment) getFragmentManager().findFragmentById(R.id.wordslist);
        wordItemFragment.refreshWordsList(strWord);
    }

    private void RefreshWordItemFragment() {
        WordItemFragment wordItemFragment = (WordItemFragment) getFragmentManager().findFragmentById(R.id.wordslist);
        wordItemFragment.refreshWordsList();
    }


}
