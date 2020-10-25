package com.example.ubhack2020;

import ...;

public class FoodListActivity extends AppCompactActivty {
    
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        mRecyclerView = (RecyclerView) findViewByID(R.id.recyclerview_Food);
        new FirebaseHelper().readFood(new FirebaseHelper.DataStatus(){

            @Override
            public void DataIsLoaded(List <Food> food, List<String>keys){
                new RecyclerViewConfig().setConfig(mRecyclerView, context: FoodListActivity.this, foods, keys);
            }
        });
    }
}
