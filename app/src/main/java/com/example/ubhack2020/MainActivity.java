package com.example.ubhack2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.Context;


public class MainActivity extends AppCompatActivity {
    Button mButton;
    EditText mEdit;
    TextView mText;
    private Context mContext;
    private Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.enter);
        mContext = getApplicationContext();
        mActivity = MainActivity.this;

        //DB code here

        String[] arraySpinner = new String[] {
                "Ingredients Inclusive", "Ingredients Exclusive", "Cuisine"
        };
        final Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String message = s.getSelectedItem().toString();
                mEdit = findViewById(R.id.editText);
                mText = findViewById(R.id.textView2);
                mText.setText(mEdit.getText());
                String[] msg = {mEdit.getText().toString(), message};
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra("com.example.ubhack2020.MSG",msg);

                startActivity(intent);
            }
        });
    }
}
