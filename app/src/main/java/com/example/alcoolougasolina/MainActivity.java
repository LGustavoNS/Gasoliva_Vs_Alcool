package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtPrecoAlcool;
    private TextInputEditText edtPrecoGasolina;

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrecoAlcool      = findViewById(R.id.edtPrecoAlcool);
        edtPrecoGasolina    = findViewById(R.id.edtPrecoGasolina);
        txtResultado        = findViewById(R.id.txtResultado);

    }

    public void calcularPreco (View view){

        //recuperar valores digitados
        String precoAlcool = edtPrecoAlcool.getText().toString();
        String precoGasolina = edtPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {

            //Convertendo string para números
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            Double resultado = valorAlcool /valorGasolina;
            if( resultado >= 0.7 ){
                txtResultado.setText( "Melhor utilizar Gasolina" );
            }else {
                txtResultado.setText( "Melhor utilizar Álcool" );
            }

        }else {
            txtResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos ( String pAlcool, String pGasolina ){

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }

        return camposValidados;
    }
}