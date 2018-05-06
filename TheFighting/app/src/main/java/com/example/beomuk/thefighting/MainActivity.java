package com.example.beomuk.thefighting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mNewProject;
    private Button mExistProject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewProject = (Button) findViewById(R.id.new_project);
        mExistProject = (Button) findViewById(R.id.exist_project);

        mNewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTheProject(1001, v);
            }
        });

        mExistProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTheProject(1002, v);
            }
        });
        Intent intent = getIntent();
        System.out.println(intent.getExtras().get("accessToken"));

    }

    private void goToTheProject(int requestCode, View view) {
        Intent intent = null;
        if(requestCode == 1001) {
            intent = new Intent(getApplicationContext(),NewProjectActivity.class);
        } else if(requestCode == 1002) {
            intent = new Intent(getApplicationContext(),ExistProjectActivity.class);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1001) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "onActivityResult 메소드가 호출됨. 요청코드 : " + requestCode
                            + ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG);

            toast.show();
//
//            if(resultCode == RESULT_OK) {
//                String name = data.getExtras().getString("name");
//                toast = Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " + name, Toast.LENGTH_LONG);
//                toast.show();
//            }
        } else if(requestCode == 1002) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "onActivityResult 메소드가 호출됨. 요청코드 : " + requestCode
                            + ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG);

            toast.show();
        }
    }
}
