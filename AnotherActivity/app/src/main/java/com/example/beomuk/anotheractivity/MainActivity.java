package com.example.beomuk.anotheractivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ANOTHER = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(),AnotherActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE_ANOTHER);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_ANOTHER) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "onActivityResult 메소드가 호출됨. 요청코드 : " + requestCode
                    + ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG);

            toast.show();

            if(resultCode == RESULT_OK) {
                String name = data.getExtras().getString("name");
                toast = Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
