package com.example.ubhack2020;

import androidx.annotation.NonNull;

import com.google.android.gms.common.util.Strings;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceFood;
    private List<Food> foods = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Food> foods, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FireBaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceFood = mDatabase.getReference();

    }

    public void readFoods(final DataStatus dstat){
        mReferenceFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                foods.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keynode : snapshot.getChildren()){
                    keys.add(keynode.getKey());
                    Food currFood = keynode.getValue(Food.class);
                    foods.add(currFood);
                }
                dstat.DataIsLoaded(foods, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    };
}
