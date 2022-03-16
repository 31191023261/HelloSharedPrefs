package haohuynh.st.ueh.edu.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView tv_num;
    Button black;
    Button red;
    Button blue;
    Button green;
    Button count;
    Button reset;
    String text;
    int color;
    private String sharedPrefFile ="com.example.android.hellosharedprefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_num= findViewById(R.id.textview_num);
        black = findViewById(R.id.button_black);
        red= findViewById(R.id.button_red);
        blue= findViewById(R.id.button_blue);
        green= findViewById(R.id.button_green);
        count= findViewById(R.id.button_count);
        reset= findViewById(R.id.button_reset);
        loadData();
        uploadData();
        Runapp();
    }
    protected void Runapp(){
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                color=R.color.black;
                tv_num.setBackgroundResource(color);
                saveData();
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color=R.color.red;
                tv_num.setBackgroundResource(color);
                saveData();
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color=R.color.blue;
                tv_num.setBackgroundResource(color);
                saveData();
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color=R.color.green;
                tv_num.setBackgroundResource(color);
                saveData();
            }
        });
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int num = Integer.parseInt(tv_num.getText().toString())  ;
             num=num+1;
             String s=Integer.toString(num);
             tv_num.setText(s);
                saveData();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.clear();
                editor.apply();
                loadData();
                uploadData();
            }
        });


    }
    public void saveData(){
        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("text",tv_num.getText().toString());
        editor.putInt("color",color);
        editor.apply();

    }
    public  void loadData(){
        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        text = mPreferences.getString("text","0");
        color= mPreferences.getInt("color",R.color.gray);
    }
    public void uploadData(){
        tv_num.setText(text);
        tv_num.setBackgroundResource(color);
    }

}