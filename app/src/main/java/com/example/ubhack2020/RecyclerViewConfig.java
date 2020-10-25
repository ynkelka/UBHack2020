package com.example.ubhack2020;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;

public class RecyclerViewConfig{
    private Context mContext;
    private FoodAdapter mFoodAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Food> food, List<String> keys){
        mContext = context;
        mFoodAdapter = new FoodAdapter(food,keys);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mFoodAdapter);
    }

    class FoodItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDescription;
        private TextView mtag;
        private TextView mingredient;
        private TextView mstep;

        private String key;

        public FoodItemView(@NonNull View itemView) {
            super(itemView);
        }

        public FoodItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.food_list_item, parent,false));

            mDescription = (TextView) itemView.findViewById(R.id.Description_textView);
            mtag = (TextView) itemView.findViewById(R.id.Tag_textView);
            mingredient =(TextView) itemView.findViewById(R.id.Ingredient_textView);
            mstep = (TextView) itemView.findViewById(R.id.step_textView);

        }

        public void bind(Food f, String key){
            mDescription.setText(f.getDescription());
            mtag.setText(f.getTag().toString());
            mingredient.setText(f.getIngredient().toString());
            mstep.setText(f.getStep().toString());
            this.key=key;
        }
    }

    class FoodAdapter extends RecyclerView.Adapter<FoodItemView>{

        private List<Food> mFoodList;
        private List<String> mKeys;

        public FoodAdapter(List<Food> mFoodList, List<String> mKeys) {
            this.mFoodList = mFoodList;
            this.mKeys = mKeys;
        }

        //@NonNull
        @Override
        public FoodItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FoodItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull FoodItemView holder, int position) {
            holder.bind(mFoodList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mFoodList.size();
        }
    }
}