package com.fgt.baron;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fgt.baron.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    EditText edtNama, edtTtl, edtJk, edtAlamat, edtKontak, edtDesk, edtPendidikan, edtPekerjaan, edtUmur;
    Button btnSimpan;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edtNama = findViewById(R.id.edtUsername);
        edtTtl = findViewById(R.id.edtTtl);
        edtJk = findViewById(R.id.edtJk);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtKontak = findViewById(R.id.edtKontak);
        edtDesk = findViewById(R.id.edtDesk);
        edtPendidikan = findViewById(R.id.edtPendidikan);
        edtPekerjaan = findViewById(R.id.edtPekerjaan);
        edtUmur = findViewById(R.id.edtUmur);
        btnSimpan = findViewById(R.id.btnSimpan);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            finish();
        }else {
            reference = FirebaseDatabase.getInstance().getReference("Profile").child(firebaseUser.getUid());
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null) {
                        edtNama.setText(user.getUsername() + "");
                        edtTtl.setText(user.getTtl() + "");
                        edtJk.setText(user.getJenis_kelamin() + "");
                        edtAlamat.setText(user.getAlamat() + "");
                        edtKontak.setText(user.getKontak() + "");
                        edtDesk.setText(user.getDesk() + "");
                        edtPendidikan.setText(user.getPendidikan() + "");
                        edtPekerjaan.setText(user.getPekerjaan() + "");
                        edtUmur.setText(user.getUmur() + "");

                    }
                    // profile.setImageResource(R.drawable.pofile);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Simpan(new User(edtNama.getText(), edtJk.getText(), edtTtl.getText(), edtAlamat.getText(), edtKontak.getText(), edtDesk.getText(), edtPendidikan.getText(), edtPekerjaan.getText(), String.valueOf(edtUmur.getText())));
                DatabaseReference database = FirebaseDatabase.getInstance().getReference();
                //new User(edtNama.getText(), edtJk.getText(), edtTtl.getText(), edtAlamat.getText(), edtKontak.getText(), edtDesk.getText(), edtPendidikan.getText(), edtPekerjaan.getText(), String.valueOf(edtUmur.getText()))
                database.child("Profile")
                        .child(firebaseUser.getUid())
                        .setValue(new User(edtNama.getText().toString()
                                , edtJk.getText().toString()
                                , edtTtl.getText().toString()
                                , edtAlamat.getText().toString()
                                , edtKontak.getText().toString()
                                , edtDesk.getText().toString()
                                , edtPendidikan.getText().toString()
                                , edtPekerjaan.getText().toString()
                                ,Integer.parseInt(edtUmur.getText().toString())))
                        .addOnSuccessListener(ProfileActivity.this, new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "Data Disimpan", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
