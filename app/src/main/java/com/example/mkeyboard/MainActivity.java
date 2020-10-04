package com.example.mkeyboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int set = -1, positions,set2;
    EditText inputText;
    Button khello;
    Button kworld;
    Cursor cursor;
  //  MotionEvent motionEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int pos;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        khello = (Button) findViewById(R.id.button1);
        kworld = (Button) findViewById(R.id.button2);
        inputText = (EditText) findViewById(R.id.editTextTextPersonName);

        khello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText.setText("Hello");
            }
        });

        kworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText.setText("world");
                inputText.setSelection(0,3);
            }
        });
        set = set2;
        positions = inputText.length() + 1;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action, keycode ;
        positions = inputText.length();
        action = event.getAction();
        keycode = event.getKeyCode();
        switch (keycode)
        {
            case KeyEvent.KEYCODE_VOLUME_UP:
            {
                if(action == KeyEvent.ACTION_UP){
                    set++;
                    inputText.setSelection(set);
                }
                if(KeyEvent.FLAG_LONG_PRESS == action)
                {
                    if(KeyEvent.ACTION_UP == action){
                        set++;
                        inputText.setSelection(set2,set);
                    }
                }
            }

            case KeyEvent.KEYCODE_VOLUME_DOWN:
            {
                if(action==KeyEvent.ACTION_DOWN){
                    positions--;
                    inputText.setSelection(positions);
                }
            }

        }

        return super.dispatchKeyEvent(event);
    }
}