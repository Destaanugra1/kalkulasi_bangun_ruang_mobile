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

public class Kalkulator_Tabung extends AppCompatActivity {

    EditText etJariJari, etTinggi;
    Button btnLuas, btnVolume;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_tabung);

        // Supaya UI menyesuaikan notch/status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi view
        etJariJari = findViewById(R.id.editJariJari);
        etTinggi   = findViewById(R.id.editTinggi);
        btnLuas    = findViewById(R.id.btnLuas);
        btnVolume  = findViewById(R.id.btnVolume);
        tvHasil    = findViewById(R.id.tvHasil);

        // Event klik tombol hitung LUAS
        btnLuas.setOnClickListener(v -> {
            if (isInputValid()) {
                double r = Double.parseDouble(etJariJari.getText().toString());
                double t = Double.parseDouble(etTinggi.getText().toString());

                // Luas permukaan tabung = 2πr (r + t)
                double luas = 2 * Math.PI * r * (r + t);

                tvHasil.setText("Luas Tabung: " + luas);
            } else {
                tvHasil.setText("Mohon isi semua input!");
            }
        });

        // Event klik tombol hitung VOLUME
        btnVolume.setOnClickListener(v -> {
            if (isInputValid()) {
                double r = Double.parseDouble(etJariJari.getText().toString());
                double t = Double.parseDouble(etTinggi.getText().toString());

                // Volume tabung = π r² t
                double volume = Math.PI * r * r * t;

                tvHasil.setText("Volume Tabung: " + volume);
            } else {
                tvHasil.setText("Mohon isi semua input!");
            }
        });
    }

    // Fungsi untuk cek input tidak kosong
    private boolean isInputValid() {
        return !etJariJari.getText().toString().isEmpty()
                && !etTinggi.getText().toString().isEmpty();
    }
}
