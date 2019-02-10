package com.example.tartaneatsv20;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Datastuff extends MapsActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference UsersRef = database.getReference();

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public void setValTest() {
        UsersRef.child("users").child(getUid()).setValue(new User("pikachu", 4.5));
    }

    public void UpdateSeller(double block_price, double dinex_price) {
        UsersRef.child("users").child(getUid()).setValue(new User(block_price, dinex_price));
    }
}