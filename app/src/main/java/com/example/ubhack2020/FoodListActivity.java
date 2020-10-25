package com.example.ubhack2020;



import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.util.Strings;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Context;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_Food);
        new FireBaseHelper().readFoods(new FireBaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Food> foods, List<String> keys) {
                new RecyclerViewConfig().setConfig(mRecyclerView, FoodListActivity.this, foods, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
