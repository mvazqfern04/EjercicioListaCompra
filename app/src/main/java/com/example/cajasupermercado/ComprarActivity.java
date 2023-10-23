package com.example.cajasupermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cajasupermercado.entidades.Producto;
import com.example.cajasupermercado.utilidades.Utilidades;

import java.util.ArrayList;

public class ComprarActivity extends AppCompatActivity {
    private Button salir, restablecer;
    private ListView listaViewProductos;

    ArrayList<Producto> productos;
    ArrayList<String> productosInfo;

    ComprarSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        conn = new ComprarSQLiteHelper(getApplicationContext(), Utilidades.TABLA_PRODUCTO_COMPRAR, null, 1);


        salir = findViewById(R.id.idBotSalirCompra);
        salir.setOnClickListener(v -> salir());
        restablecer = findViewById(R.id.idBotRestablecer);
        restablecer.setOnClickListener(v -> generarProductosEnTabla());

        //Hacer que se muestren en el list view


        listaViewProductos =findViewById(R.id.idListaComprar);
        consultarListaProductos();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,productosInfo);
        listaViewProductos.setAdapter(adaptador);


    }

    private void consultarListaProductos() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Producto producto = null;
        productos = new ArrayList<Producto>();
        //Select * from tabla_compra
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PRODUCTO_COMPRAR, null);

        while (cursor.moveToNext()) {
            producto=new Producto();
            producto.setId(cursor.getInt(0));
            producto.setNombre(cursor.getString(1));
            producto.setCantidad(cursor.getInt(2));
            producto.setCant_Actual(cursor.getInt(3));
            producto.setPrecio(cursor.getDouble(4));

            productos.add(producto);
        }

        obtenerLista();
    }

    private void obtenerLista() {
        productosInfo = new ArrayList<String>();

        for (int i = 0; i < productos.size(); i++) {
            productosInfo.add(productos.get(i).getId()+" - "+productos.get(i).getNombre()+" - Cantidad:"+
                    productos.get(i).getCantidad()+" - Cantidad actual:"+
                    productos.get(i).getCant_Actual()+" - Precio:"+
                    productos.get(i).getPrecio());
        }

    }

    //Esto establece la base de datos a su estado original
    private void generarProductosEnTabla() {
        SQLiteDatabase db = conn.getWritableDatabase();

        db.execSQL("DELETE FROM "+Utilidades.TABLA_PRODUCTO_COMPRAR);

        productos = generarProductos();

        for (Producto producto : productos) {
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_ID, producto.getId().toString());
            values.put(Utilidades.CAMPO_NOMBRE, producto.getNombre());
            values.put(Utilidades.CAMPO_CANTIDAD, producto.getCantidad().toString());
            values.put(Utilidades.CAMPO_CANTIDAD_ACTUAL, producto.getCant_Actual().toString());
            values.put(Utilidades.CAMPO_PRECIO, producto.getPrecio().toString());

            db.insert(Utilidades.TABLA_PRODUCTO_COMPRAR, Utilidades.CAMPO_ID, values);
        }
        Toast.makeText(getApplicationContext(), "Base de datos restablecida correctamente", Toast.LENGTH_SHORT).show();

    }

    private ArrayList<Producto> generarProductos() {
        ArrayList<Producto> salida = new ArrayList();
        salida.add(new Producto("Patas", 1, 20, 3.0));
        salida.add(new Producto("Aceite", 2, 3, 5.0));
        salida.add(new Producto("Chocolate", 3, 30, 2.4));
        salida.add(new Producto("Monster", 4, 7, 1.7));
        salida.add(new Producto("Judias", 5, 20, 2.0));

        return salida;
    }

    private void salir() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}