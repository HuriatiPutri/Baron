package com.fgt.baron;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fgt.baron.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class DaftarPrivateActivity extends AppCompatActivity {

    Spinner spKategori;
    EditText edtHarga, edtDesc,edtDurasi;
    Button btnDaftar;
    String Kategori[] = {"Ilmu Agama","Ilmu Alam","Ilmu Komputer","Ilmu Kesehatan"};

    FirebaseUser firebaseUser;
    DatabaseReference reference;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pemateri);

        // Array of choices

// Selection of the spinner
        spKategori = findViewById(R.id.spKategori);
        edtDesc = findViewById(R.id.edtDesk);
        edtDurasi = findViewById(R.id.edtDurasi);
        edtHarga = findViewById(R.id.edtHarga);
        btnDaftar = findViewById(R.id.btnDaftar);


// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this,   android.R.layout.simple_spinner_item, Kategori);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spKategori.setAdapter(spinnerArrayAdapter);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }else {
            reference = FirebaseDatabase.getInstance().getReference("Profile").child(firebaseUser.getUid());

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null) {
                        username = user.getUsername();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                HashMap<String, Object>hashMap = new HashMap<>();
                hashMap.put("idUser", firebaseUser.getUid());
                hashMap.put("nama", username);
                hashMap.put("kategori", spKategori.getSelectedItem());
                hashMap.put("harga", edtHarga.getText().toString());
                hashMap.put("deskripsi", edtDesc.getText().toString());
                hashMap.put("durasi", edtDurasi.getText().toString());

                reference.child("Private").push().setValue(hashMap);
            }
        });
    }
}
