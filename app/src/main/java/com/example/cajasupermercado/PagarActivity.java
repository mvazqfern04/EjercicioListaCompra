package com.example.cajasupermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PagarActivity extends AppCompatActivity {

    private Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        salir = findViewById(R.id.idBotSalirPagar);
        salir.setOnClickListener(v -> cancelar());
    }

    private void cancelar() {
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }
}