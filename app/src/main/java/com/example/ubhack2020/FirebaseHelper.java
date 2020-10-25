package com.example.ubhack2020;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FirebaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceFood;
    private List<Food> foods = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Food> foods, List<Strings> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseHelper(){
        mDatabase = Firebase.getInstance();
        mReferenceFood = mDatabase.getReference();

    }

    public void readFoods(final DataStatus dstat){
        mReferenceFood.addValueEventListner(new ValueEventListner(){
           
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                foods.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keynode : dataSnapshot.getChildren()){
                    keys.add(keynode.getKey());
                    Food currFood = keynode.getValue(Food.class);
                    foods.add(currFood);
                }
                dstat.DataIsLoaded(foods, keys);
            }
            
            @Override
            public void onCancelled(@NonNull DatabaseError dbError){

            }
        });
    };
}
