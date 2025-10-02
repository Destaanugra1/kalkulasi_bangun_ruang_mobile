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

public class Kalkulator_Balok extends AppCompatActivity {

    EditText etPanjang, etLebar, etTinggi;
    Button btnLuas, btnVolume;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_balok);

        // Supaya padding UI menyesuaikan notch/statusbar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi view
        etPanjang = findViewById(R.id.editTextText2);
        etLebar   = findViewById(R.id.editTextText);
        etTinggi  = findViewById(R.id.editTextText3);
        btnLuas   = findViewById(R.id.button);
        btnVolume = findViewById(R.id.button2);
        tvHasil   = findViewById(R.id.textView2);

        // Tombol Hitung Luas Permukaan
        btnLuas.setOnClickListener(v -> {
            if (isInputValid()) {
                double p = Double.parseDouble(etPanjang.getText().toString());
                double l = Double.parseDouble(etLebar.getText().toString());
                double t = Double.parseDouble(etTinggi.getText().toString());

                // Rumus luas permukaan balok = 2 * (pl + pt + lt)
                double luas = 2 * ((p * l) + (p * t) + (l * t));

                tvHasil.setText("Hasil Luas Permukaan: " + luas);
            } else {
                tvHasil.setText("Mohon isi semua input!");
            }
        });

        // Tombol Hitung Volume
        btnVolume.setOnClickListener(v -> {
            if (isInputValid()) {
                double p = Double.parseDouble(etPanjang.getText().toString());
                double l = Double.parseDouble(etLebar.getText().toString());
                double t = Double.parseDouble(etTinggi.getText().toString());

                // Rumus volume balok = p * l * t
                double volume = p * l * t;

                tvHasil.setText("Hasil Volume: " + volume);
            } else {
                tvHasil.setText("Mohon isi semua input!");
            }
        });
    }

    // Fungsi untuk cek input tidak kosong
    private boolean isInputValid() {
        return !etPanjang.getText().toString().isEmpty()
                && !etLebar.getText().toString().isEmpty()
                && !etTinggi.getText().toString().isEmpty();
    }
}
