package com.cocho.elvis.calculadora_dosis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CalcularDosis(View view)
    {

            EditText peso = (EditText) findViewById(R.id.PesoPersona);
            EditText dosisRequerida = (EditText) findViewById(R.id.DosisRequerida);
            EditText concentracion = (EditText) findViewById(R.id.Concentracion);
            EditText volumen = (EditText) findViewById(R.id.Volumen);
            TextView resultado = (TextView) findViewById(R.id.txtResultado);
        try {
            double res = Double.parseDouble(dosisRequerida.getText().toString()) * Double.parseDouble(peso.getText().toString()) * 60;
            res = res / 1000;
            double conc = Double.parseDouble(volumen.getText().toString()) / Double.parseDouble(concentracion.getText().toString());
            double dosis = res * conc;
            resultado.setText(Double.toString(dosis) + " ml/hora");
        }catch (NumberFormatException e)
        {
            resultado.setText("Ingrese todos los valores");
        }
    }
}
