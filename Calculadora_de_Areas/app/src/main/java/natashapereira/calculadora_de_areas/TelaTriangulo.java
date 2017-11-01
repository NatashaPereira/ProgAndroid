package natashapereira.calculadora_de_areas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class TelaTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_triangulo);
    }

    public void resultadoTriangulo(View c) {
        EditText etBaseTriangulo = (EditText) findViewById(R.id.etBaseTriangulo);
        EditText etAlturaTriangulo = (EditText) findViewById(R.id.etAlturaTriangulo);

        if (etBaseTriangulo.getText().toString().equals("") || etAlturaTriangulo.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle mochila = new Bundle(); //Criar a mochila
        char id = '0';

        try {
            double base = Double.parseDouble(etBaseTriangulo.getText().toString());
            double altura = Double.parseDouble(etAlturaTriangulo.getText().toString());
            double resultado = (base*altura)/2;
            mochila.putDouble("result", resultado); //Bota o resultado na mochila
            mochila.putChar("identificador", id); //Bota o identificador na mochila
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao converter os dados", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intencao = new Intent(getApplicationContext(), TelaResultado.class);

        intencao.putExtras(mochila);

        startActivityForResult(intencao, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }

    }

