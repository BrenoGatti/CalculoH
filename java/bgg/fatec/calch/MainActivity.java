package bgg.fatec.calch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etInputN;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputN = findViewById(R.id.etInputN);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(op -> calcularSerie());
    }
    private void calcularSerie() {
        String textoDigitado = etInputN.getText().toString();

        if (textoDigitado.isEmpty()) {
            etInputN.setError(getString(R.string.erro_digite_valor));
            return;
        }

        int n = Integer.parseInt(textoDigitado);

        if (n <= 0 || n > 20) {
            Toast.makeText(this, getString(R.string.erro_intervalo), Toast.LENGTH_SHORT).show();
            etInputN.setText("");
            tvResultado.setText("-");
            return;
        }

        int h = 0;
        for (int i = 1; i <= n; i++) {
            int Impar = (2 * i) - 1;
            int termo = Impar * 2;
            h = h + termo;
        }
        /*
        Ou
        h = 2 * n**2;
         */
        tvResultado.setText(String.valueOf(h));
        etInputN.setText("");

    }
}