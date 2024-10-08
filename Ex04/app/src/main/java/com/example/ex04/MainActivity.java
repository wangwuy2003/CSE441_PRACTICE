package com.example.ex04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtdoC, edtdoF;
    Button btnCel, btnFah, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtdoC = findViewById(R.id.edt1);
        edtdoF = findViewById(R.id.edt2);
        btnCel = findViewById(R.id.btnCel);
        btnFah = findViewById(R.id.btnFah);
        btnClear = findViewById(R.id.btnClear);
        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("#.00");

                String doC = edtdoC.getText()+ "";
                int C = Integer.parseInt(doC);
                edtdoF.setText("" + dcf.format(C*1.8+32));
            }
        });

        btnFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("#.00");

                String doF = edtdoF.getText()+ "";
                int F = Integer.parseInt(doF);
                edtdoC.setText("" + dcf.format((F - 32)/1.8));
            }
        });
    }
}