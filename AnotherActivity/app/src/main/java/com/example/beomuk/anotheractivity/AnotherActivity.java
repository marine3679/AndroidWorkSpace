package com.example.beomuk.anotheractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class AnotherActivity extends Activity {

    Intent resultIntent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another);

        resultIntent = new Intent();
        resultIntent.putExtra("name","mike");
//        Button backButton = (Button) findViewById(R.id.backButton);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("name","mike");
//                setResult(RESULT_OK, resultIntent);
//                finish();
//            }
//        });
    }

    public void buttonClicked2(View view) {

        setResult(RESULT_OK, resultIntent);
        resultIntent = null;
        finish();
    }
}
