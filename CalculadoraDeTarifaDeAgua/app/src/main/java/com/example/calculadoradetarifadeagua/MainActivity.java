package com.example.calculadoradetarifadeagua;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText txtnumMetros;
    TextView lblRespuestaMetros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnumMetros = findViewById(R.id.txtnumMetros);
        lblRespuestaMetros = findViewById(R.id.lblRespuestaMetros);

        TabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Consumo de Agua");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tab Two");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Segunda Pestaña");
        tabHost.addTab(spec);

        Button btnCalcularMetros = findViewById(R.id.btnCalcular);
        btnCalcularMetros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularValorAPagar();
            }
        });
    }

    private void calcularValorAPagar() {
        String metrosStr = txtnumMetros.getText().toString();

        if (!metrosStr.isEmpty()) {
            double metrosConsumidos = Double.parseDouble(metrosStr);
            double valorAPagar = metrosConsumidos * 0.50;
            lblRespuestaMetros.setText("Valor a Pagar: $" + valorAPagar);
        } else {
            lblRespuestaMetros.setText("Por favor ingrese la cantidad de metros consumidos.");
        }
    }
}
