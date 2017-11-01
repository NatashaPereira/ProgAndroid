package natashapereira.calculadora_de_areas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        char identificador = getIntent().getExtras().getChar("identificador");
        double resultado;

        if (identificador == 'C') {
            resultado = getIntent().getExtras().getDouble("result");
            ivImage.setImageResource(R.drawable.circulo);
            tvResultado.setText("Área: " + resultado);
        } else if (identificador == 'R') {
            resultado = getIntent().getExtras().getDouble("result");
            ivImage.setImageResource(R.drawable.retangulo);
            tvResultado.setText("Área: " + resultado);
        } else {
            resultado = getIntent().getExtras().getDouble("result");
            ivImage.setImageResource(R.drawable.triangulo);
            tvResultado.setText("Área: " + resultado);
        }
    }

    public void recomecar(View c) {
        finish();
    }
}
