package com.example.tartaneatsv20;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.MenuItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sell extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference mDatabase;

    private EditText BlockPrice;
    private EditText DinexPrice;
    private Button UpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Views
        BlockPrice = findViewById(R.id.blockp);
        DinexPrice = findViewById(R.id.dinep);
        UpdateButton = findViewById(R.id.update);

        // Click listeners
        UpdateButton.setOnClickListener(this);

        /*BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_sell:
                        break;
                    case R.id.navigation_map:
                        Intent map = new Intent(Sell.this, MapsActivity.class);
                        startActivity(map);
                        break;
                    case R.id.navigation_request:
                        Intent request = new Intent(Sell.this, Request.class);
                        startActivity(request);
                        break;
                }
                return false;
            }
        });*/

        //code

    }
    public void onClick(View v) {
        if (v.getId() == R.id.update) {
            String b = BlockPrice.getText().toString();
            String dd = DinexPrice.getText().toString();
            if (b.isEmpty() || b == null || dd.isEmpty() || dd == null) return;
            Datastuff d = new Datastuff();
            double blocc = Double.valueOf(b);
            double dinecc = Double.valueOf(dd);
            d.UpdateSeller(blocc, dinecc);
            startActivity(new Intent(this, MapsActivity.class));
            finish();
        }

    }
}
