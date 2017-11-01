package natashapereira.calculadora_de_areas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCirculo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_circulo);
    }

    public void resultadoCirculo(View c) {

        EditText etRaio = (EditText) findViewById(R.id.etRaio);

        if (etRaio.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Preencha o campo raio", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle mochila = new Bundle(); //Criar a mochila
        char id = 'C';

        try {
            double raio = Double.parseDouble(etRaio.getText().toString());
            double resultado = (3.14)*(Math.pow(raio, 2));
            mochila.putDouble("result", resultado); //Botar o resultado na mochila
            mochila.putChar("identificador", id); //Bota o identificador na mochila
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao converter os dados", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intencao = new Intent(getApplicationContext(), TelaResultado.class);

        intencao.putExtras(mochila);

        startActivityForResult(intencao, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }


}


