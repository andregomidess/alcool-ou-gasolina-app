package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoAlcool, campoGasolina;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoAlcool = findViewById(R.id.textInputAlcool);
        campoGasolina = findViewById(R.id.textInputGasolina);
        textoResultado = findViewById(R.id.resultado);

    }

    public void calculaResultado(View view){
        String precoAlcool = campoAlcool.getText().toString();
        String precoGasolina = campoGasolina.getText().toString();
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            if (valorAlcool/valorGasolina >= 0.70)
                textoResultado.setText("A gasolina é a melhor opção!");
            else
                textoResultado.setText("O álcool é a melhor opção!");
        } else{
            textoResultado.setText("Preencha os preços primeiro!");
        }
    }

    public  Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidos = true;
        if (pAlcool == null || pAlcool.equals("")){
            camposValidos = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidos = false;
        }

        return camposValidos;
    }
}