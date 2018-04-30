package com.example.beomuk.chanllenge3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity {

    String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Intent intent = getIntent();
        title = intent.getExtras().getString("title");

        TextView textView = (TextView) findViewById(R.id.titleOfView);
        textView.setText(title);
//        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    public void clickClose(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", title);
        setResult(RESULT_OK, resultIntent);
        finish();
    }


}
