package com.example.cajasupermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cajasupermercado.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {
    private Button pagar,comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComprarSQLiteHelper conn = new ComprarSQLiteHelper(getApplicationContext(), Utilidades.TABLA_PRODUCTO_COMPRAR,null,1);


        pagar = findViewById(R.id.idBotPendiente);
        comprar = findViewById(R.id.idBotComprar);

        pagar.setOnClickListener(view -> irPagar());
        comprar.setOnClickListener(v -> irComprar());
    }

    private void irComprar() {
        Intent intent = new Intent(getApplicationContext(), ComprarActivity.class);
        this.startActivity(intent);
    }

    private void irPagar() {
        Intent intent = new Intent(getApplicationContext(), PagarActivity.class);
        this.startActivity(intent);
    }
}