package natashapereira.calculadora_de_areas;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaRetangulo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_retangulo);
    }

    public void resultadoQuadrado(View c) {
        EditText etBaseQuadrado = (EditText) findViewById(R.id.etBaseQuadrado);
        EditText etAlturaQuadrado = (EditText) findViewById(R.id.etAlturaQuadrado);

        if (etBaseQuadrado.getText().toString().equals("") || etAlturaQuadrado.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle mochila = new Bundle(); //Criar a mochila
        char id = 'R';

        try {
            double base = Double.parseDouble(etBaseQuadrado.getText().toString());
            double altura = Double.parseDouble(etAlturaQuadrado.getText().toString());
            double resultado = base*altura;
            mochila.putDouble("result", resultado); //Botar o resultado na mochila
            mochila.putChar("identificador", id); //Bota o identificador na mochila
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao converter os dados", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intencao = new Intent(getApplicationContext(), TelaResultado.class);

        intencao.putExtras(mochila);

        startActivityForResult(intencao, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        finish();
    }

}
