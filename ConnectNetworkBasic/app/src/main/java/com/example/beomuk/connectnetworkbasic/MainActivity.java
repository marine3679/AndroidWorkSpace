package com.example.beomuk.connectnetworkbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = "10.4.73.197";

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }

    class ConnectThread extends Thread {
        String hostname;

        public ConnectThread(String addr) {
            hostname = addr;
        }

        public void run() {
            try {
                int port = 11001;
                Socket sock = new Socket(hostname, port);

                ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
                outStream.writeObject("Hello AndroidTown on Android");
                outStream.flush();
                ObjectInputStream inStream = new ObjectInputStream(sock.getInputStream());
                String obj = (String) inStream.readObject();

                Log.d("button", "서버에서 받은 메세지" + obj);
                sock.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
