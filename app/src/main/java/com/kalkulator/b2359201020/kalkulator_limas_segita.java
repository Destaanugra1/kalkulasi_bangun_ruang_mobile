package com.kalkulator.b2359201020;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class kalkulator_limas_segita extends AppCompatActivity {

    EditText etAlas, etTinggiAlas, etTinggiLimas;
    Button btnLuas, btnVolume;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_limas_segita);

        // Supaya UI menyesuaikan notch/status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi view
        etAlas       = findViewById(R.id.editAlas);
        etTinggiAlas = findViewById(R.id.editTinggiAlas);
        etTinggiLimas= findViewById(R.id.editTinggiLimas);
        btnLuas      = findViewById(R.id.btnLuas);
        btnVolume    = findViewById(R.id.btnVolume);
        tvHasil      = findViewById(R.id.tvHasil);

        // Event klik tombol hitung LUAS
        btnLuas.setOnClickListener(v -> {
            if (isInputValid()) {
                double alas = Double.parseDouble(etAlas.getText().toString());
                double tinggiAlas = Double.parseDouble(etTinggiAlas.getText().toString());
                double tinggiLimas = Double.parseDouble(etTinggiLimas.getText().toString());

                // Luas alas segitiga = 0.5 * alas * tinggiAlas
                double luasAlas = 0.5 * alas * tinggiAlas;

                // Perkiraan luas limas segitiga sederhana:
                // Luas permukaan = luas alas + 3 * luas segitiga sisi
                // Misal segitiga sisi pakai alas yang sama & tinggi limas sebagai tinggi segitiga
                double luasSisi = 0.5 * alas * tinggiLimas;
                double luasTotal = luasAlas + 3 * luasSisi;

                tvHasil.setText("Luas Limas: " + luasTotal);
            } else {
                tvHasil.setText("Mohon isi semua input!");
            }
        });

        // Event klik tombol hitung VOLUME
        btnVolume.setOnClickListener(v -> {
            if (isInputValid()) {
                double alas = Double.parseDouble(etAlas.getText().toString());
                double tinggiAlas = Double.parseDouble(etTinggiAlas.getText().toString());
                double tinggiLimas = Double.parseDouble(etTinggiLimas.getText().toString());

                // Luas alas segitiga = 0.5 * alas * tinggiAlas
                double luasAlas = 0.5 * alas * tinggiAlas;

                // Volume limas segitiga = 1/3 * luasAlas * tinggiLimas
                double volume = (1.0 / 3.0) * luasAlas * tinggiLimas;

                tvHasil.setText("Volume Limas: " + volume);
            } else {
                tvHasil.setText("Mohon isi semua input!");
            }
        });
    }

    // Fungsi untuk cek input tidak kosong
    private boolean isInputValid() {
        return !etAlas.getText().toString().isEmpty()
                && !etTinggiAlas.getText().toString().isEmpty()
                && !etTinggiLimas.getText().toString().isEmpty();
    }
}
