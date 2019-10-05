package com.lastname.esmeraldajeromeexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox[] checkbox = new CheckBox[8];
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox [0]= findViewById(R.id.checkBox1);
        checkbox [1] = findViewById(R.id.checkBox2);
        checkbox [2] = findViewById(R.id.checkBox3);
        checkbox [3] = findViewById(R.id.checkBox4 );
        checkbox [4] = findViewById(R.id.checkBox5);
        checkbox [5] = findViewById(R.id.checkBox6);
        checkbox [6] = findViewById(R.id.checkBox7);
        checkbox [7]= findViewById(R.id.checkBox8);
        et = findViewById(R.id.comment);
    }
    public void save(View v){
        FileOutputStream writer = null;
        String input1 = checkbox[0].getText().toString() + ",";
        String input2 = checkbox[1].getText().toString() + ",";
        String input3 = checkbox[2].getText().toString() + ",";
        String input4 = checkbox[3].getText().toString() + ",";
        String input5 = checkbox[4].getText().toString() + ",";
        String input6 = checkbox[5].getText().toString() + ",";
        String input7 = checkbox[6].getText().toString() + ",";
        String input8 = checkbox[7].getText().toString() + ",";
        String text = et.getText().toString();
        try {
            writer = openFileOutput("data.txt", MODE_APPEND);
            writer.write(input1.getBytes());
            writer.write(input2.getBytes());
            writer.write(input3.getBytes());
            writer.write(input4.getBytes());
            writer.write(input5.getBytes());
            writer.write(input6.getBytes());
            writer.write(input7.getBytes());
            writer.write(input8.getBytes());
            writer.write(text.getBytes());
        }catch (IOException e){
            Log.d("error", "IOException");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found 2");
            }
        }
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
    }
    public void next(View v){
        Intent intent = new Intent(MainActivity.this, MainActivitytwo.class);
        startActivity(intent);
    }
}
