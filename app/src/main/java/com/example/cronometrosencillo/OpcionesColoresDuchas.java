package com.example.cronometrosencillo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

import org.w3c.dom.Text;

public class OpcionesColoresDuchas extends AppCompatActivity {

    int colorSeleccionado;
    TextView tvColor, tvCantidad;
    Button btnColor;
    EditText etCantidad;
    Button btnAceptar, btnVolver;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_colores_duchas);

        tvCantidad = (TextView) findViewById(R.id.tvCantidad);
        tvColor =(TextView) findViewById(R.id.tvColor);
        btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(view -> abrirPaletaDeColores());
        etCantidad = (EditText) findViewById(R.id.etCantidad);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnAceptar.setOnClickListener(view -> devolverResultado());
        btnVolver.setOnClickListener(view -> finish());
        //btnColor.setBackgroundColor(getResources().getInteger(R.color.black)); para poner backgroundcolor a un boton
    }

    private void abrirPaletaDeColores() {

        final ColorPicker cp = new ColorPicker(this, 0 , 0,0);
        /* Show color picker dialog */
        cp.show();
        cp.enableAutoClose(); // Enable auto-dismiss for the dialog
        cp.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(int color) {
                colorSeleccionado = color;
                btnColor.setBackgroundColor(color);
                int rojo = Color.red(color);
                int verde = Color.green(color);
                int azul = Color.blue(color);
            }
        });
    }


    private void devolverResultado() {
        Intent resultIntent = getIntent();
        resultIntent.putExtra("color", String.valueOf(colorSeleccionado));
        resultIntent.putExtra("cantidad", etCantidad.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}