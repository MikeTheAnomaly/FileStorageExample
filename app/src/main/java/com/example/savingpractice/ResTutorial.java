package com.example.savingpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResTutorial extends AppCompatActivity {

    private TextView textView;
    private InputStream resFile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textToSave);
        resFile = getResources().openRawResource(R.raw.text);

    }


    public void load(View view) {
        FileInputStream fis = null;
        String text = "";

        try {

            InputStreamReader isr = new InputStreamReader(resFile);
            BufferedReader br = new BufferedReader(isr);

            text = br.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        textView.setText(text);

    }

    public void save(View view) {
        textView.setText("Huh cant save to a res file");
    }
}
