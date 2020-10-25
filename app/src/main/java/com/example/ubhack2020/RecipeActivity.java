package com.example.ubhack2020;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        String msg = getIntent().getStringExtra("com.example.ubhack2020.MSG");
        TextView txt = (TextView) findViewById(R.id.rec);
        txt.setText(msg);



    }

}
