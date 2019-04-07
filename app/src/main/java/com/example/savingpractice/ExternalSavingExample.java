package com.example.savingpractice;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalSavingExample extends AppCompatActivity {
    final private String FILE_NAME = "Test.txt";
    private TextView textView;

    private File externalFile;
    final private String FILE_PATH = "MyFilePath";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textToSave);

        //used for folder inside Android/data/data/application_package/
        //gets del when app is uninstalled
        externalFile = new File(getExternalFilesDir(FILE_PATH),FILE_NAME);

    }

    public void save(View view){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(externalFile);
            fos.write(textView.getText().toString().getBytes());

            Toast.makeText(this,externalFile.getPath().toString() ,Toast.LENGTH_LONG).show();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,e.getMessage() ,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,e.getMessage() ,Toast.LENGTH_LONG).show();
        }


    }

    public void load(View view){
        String output = "";
        try {
            FileInputStream fis = new FileInputStream(externalFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                output = output + line;
            }

            fis.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,e.getMessage() ,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this,e.getMessage() ,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        textView.setText(output);
    }

}
