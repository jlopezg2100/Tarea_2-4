package com.example.firma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firma.transacciones.Transacciones;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText descripcion;
    Button btnguardar, btngaleria;
    View view5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descripcion = (EditText) findViewById(R.id.txtdescripcion);
        view5 = (View) findViewById(R.id.viewfirma);

        btnguardar = (Button)findViewById(R.id.btnguardar);
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarfirma();
            }
        });

        btngaleria = (Button)findViewById(R.id.btngaleria);
        btngaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(intent);
            }
        });
    }

    public void guardarfirma(){

        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        try{

            ContentValues valores = new ContentValues();

            valores.put(Transacciones.imagen, Verfirma(view5));
            valores.put(Transacciones.descripcion, descripcion.getText().toString());

            Long resultado = db.insert(Transacciones.tabla_firmas, Transacciones.id, valores);

            Toast.makeText(getApplicationContext(), "FIRMA FUE INGRESADA: " + resultado.toString(), Toast.LENGTH_LONG).show();


        }
        catch (Exception e){
            e.printStackTrace();
        }
       ClearScreen();

    }

    public static byte[]  Verfirma(View view5) {
        view5.setDrawingCacheEnabled(true);
        Bitmap bitmap = view5.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    private void ClearScreen() {
        descripcion.setText("");
        view5.setDrawingCacheEnabled(false);
    }

}