package com.example.conversordeareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    Button btnArea;
    Spinner spnAreaDe, spnAreaA;
    EditText txtAreaCantidad;
    Conversores objConversor = new Conversores();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("AREAS").setContent(R.id.tabArea).setIndicator("AREAS", null));

        btnArea = findViewById(R.id.btnAreaConvertir);
        btnArea.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                spnAreaDe = findViewById(R.id.spnAreaDe);
                int de = spnAreaDe.getSelectedItemPosition();

                spnAreaA = findViewById(R.id.spnAreaA);
                int a = spnAreaA.getSelectedItemPosition();

                txtAreaCantidad = findViewById(R.id.txtAreaCantidad);
                double cantidad = Double.parseDouble(txtAreaCantidad.getText().toString());

                double resp = objConversor.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
    }

    class Conversores {
        double[][] valores = {

                // Areas
                {1, 0.1329421, 0.111111, 0.0929, 0.0001477465648855, 0.0000132, 0.0000092},
        };

        public double convertir(int opcion, int de, int a, double cantidad) {
            return valores[opcion][a] / valores[opcion][de] * cantidad;

        }
    }
}



