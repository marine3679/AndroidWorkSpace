package com.example.beomuk.chanllenge3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ManagementListActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CLIENT_MANAGER = 1001;
    public static final int REQUEST_CODE_SELLING_MANAGER = 1002;
    public static final int REQUEST_CODE_ITEM_MANAGER = 1003;
    private String THE_TITLE = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_list_activity);
    }

    public void clickClientManager(View view) {
        THE_TITLE = "Client Manager";
        settingIntent(THE_TITLE, REQUEST_CODE_CLIENT_MANAGER);
    }

    public void clickSellingManager(View view) {
        THE_TITLE = "Selling Manager";
        settingIntent(THE_TITLE, REQUEST_CODE_SELLING_MANAGER);
    }

    public void clickItemManager(View view) {
        THE_TITLE = "Item Manager";
        settingIntent(THE_TITLE, REQUEST_CODE_ITEM_MANAGER);
    }

    private void settingIntent(String title, int requestCode) {
        Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
        intent.putExtra("title",title);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_CLIENT_MANAGER) {
            Toast toast = Toast.makeText(getApplicationContext(), "Client Manager", Toast.LENGTH_SHORT);
            toast.show();

            if(resultCode == RESULT_OK) {
                String title = data.getExtras().getString("result");
                toast = Toast.makeText(getApplicationContext(), "응답으로 전달된 title : " + title, Toast.LENGTH_LONG);
                toast.show();
            }
        } else if (requestCode == REQUEST_CODE_SELLING_MANAGER) {
            Toast toast = Toast.makeText(getApplicationContext(), "Selling Manager", Toast.LENGTH_SHORT);
            toast.show();

            if(resultCode == RESULT_OK) {
                String title = data.getExtras().getString("result");
                toast = Toast.makeText(getApplicationContext(), "응답으로 전달된 title : " + title, Toast.LENGTH_LONG);
                toast.show();
            }
        } else if(requestCode == REQUEST_CODE_ITEM_MANAGER) {
            Toast toast = Toast.makeText(getApplicationContext(), "Item Manager", Toast.LENGTH_SHORT);
            toast.show();

            if(resultCode == RESULT_OK) {
                String title = data.getExtras().getString("result");
                toast = Toast.makeText(getApplicationContext(), "응답으로 전달된 title : " + title, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
