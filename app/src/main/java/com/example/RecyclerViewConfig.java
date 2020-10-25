package com.example.ubhack2020;

import android.content.Context;

public class RecyclerViewConfig{
    
    private Context mContext;
    private FoodsAdapter mFoodAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Food> food, List<String> keys){
        mContext = context;
        mFoodAdapter = new FoodAdapter(food, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mFoodAdapter);
    }

    class ViewFood extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mDescription;
        private TextView mtag;
        private TextView mingredient;
        private TextView mstep;

        private String key;

        public FoodItemView(ViewGroup parent){
            super(LayoutInflator.from(mContext).inflate(R.layout.food_list_item, parent, attachToRoot: False));

            mDescription = (TextView) itemView.findViewById(R.id.Descriprion_textView);
            mtag = (TextView) itemView.findViewById(R.id.Tag_textView);
            mingredient =(TextView) itemView.findViewById(R.id.Ingredient_textView);
            mstep = (TextView) itemView.findViewById(R.id.step_textView);

        }

        public void bind(Food f, String key){
            mDescription.setText(f.getDescription());
            mtag.setText(f.getTag());
            mingredient.setText(f.getIngredient());
            mstep.setText(f.getStep());
            this.key=key;
        }
    }

    class FoodAdapter extends RecyclerView.Adapter<FoodItemView>{
        
        private List<Food> mFoodList;
        private List<String> mKeys;

    public RecyclerViewConfig() {
    }

    public RecyclerViewConfig(Context mContext) {
        this.mContext = mContext;
    }

    public Context getMContext() {
        return this.mContext;
    }

    public void setMContext(Context mContext) {
        this.mContext = mContext;
    }

    public RecyclerViewConfig mContext(Context mContext) {
        this.mContext = mContext;
        return this;
    }

    @Override
    public FoodItemView onCreateViewHolder(ViewGroup parent, int viewType){
        return new FoodItemView(parent);
    }

    @Override
    public void onBindViewHolder (FoodItemView holder, int position){
        holder.bind(mFoodList.get(position), mKeys.get(position));
    }

    @Override
    public int getItemCount(){
        return mFoodList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecyclerViewConfig)) {
            return false;
        }
        RecyclerViewConfig recyclerViewConfig = (RecyclerViewConfig) o;
        return Objects.equals(mContext, recyclerViewConfig.mContext);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mContext);
    }

    @Override
    public String toString() {
        return "{" +
            " mContext='" + getMContext() + "'" +
            "}";
    }


    }
}
