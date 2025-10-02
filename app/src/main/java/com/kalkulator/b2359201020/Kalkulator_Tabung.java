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

    EditText editJariJari, editTinggi;
    Button btnVolume;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_tabung);

        // Inisialisasi View
        editJariJari = findViewById(R.id.editJariJari);
        editTinggi = findViewById(R.id.editTinggi);
        btnVolume = findViewById(R.id.btnVolume);
        tvHasil = findViewById(R.id.tvHasil);

        // Logic Hitung Volume Tabung
        btnVolume.setOnClickListener(v -> {
            String jariInput = editJariJari.getText().toString();
            String tinggiInput = editTinggi.getText().toString();

            if (!jariInput.isEmpty() && !tinggiInput.isEmpty()) {
                double r = Double.parseDouble(jariInput);
                double t = Double.parseDouble(tinggiInput);

                double volume = Math.PI * r * r * t;

                tvHasil.setText("Hasil Volume: " + String.format("%.2f", volume));
            } else {
                tvHasil.setText("Mohon isi semua data!");
            }
        });

        // Atur padding untuk system bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
