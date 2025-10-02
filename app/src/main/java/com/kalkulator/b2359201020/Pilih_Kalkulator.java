package com.kalkulator.b2359201020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pilih_Kalkulator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pilih_kalkulator);

        // Supaya padding sesuai notch/status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ambil tombol balok
        Button btnBalok = findViewById(R.id.btnBalok);
        Button btnLimas = findViewById(R.id.btnLimas);
        Button btnTabung = findViewById(R.id.btnTabung);

        // Pindah ke activity Kalkulator_Balok
        btnBalok.setOnClickListener(v -> {
            Intent intent = new Intent(Pilih_Kalkulator.this, Kalkulator_Balok.class);
            startActivity(intent);
        });

//        pindah ke liman
        btnLimas.setOnClickListener(v -> {
            Intent intent = new Intent(Pilih_Kalkulator.this, kalkulator_limas_segita.class);
            startActivity(intent);
        });

//        Pindah ke tabung
        btnTabung.setOnClickListener(v -> {
            Intent intent = new Intent(Pilih_Kalkulator.this, Kalkulator_Tabung.class);
            startActivity(intent);
        });
    }
}
