package natashapereira.calculadora_de_areas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void avancar(View c) {

        RadioGroup rgFormas = (RadioGroup) findViewById(R.id.rgFormas);

        if (rgFormas.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Selecione uma forma geométrica", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rgFormas.getCheckedRadioButtonId() == R.id.rbRetangulo) {
            Intent intencao = new Intent(getApplicationContext(), TelaRetangulo.class);
            startActivityForResult(intencao, 1);
        } else if (rgFormas.getCheckedRadioButtonId() == R.id.rbTriangulo) {
            Intent intencao = new Intent(getApplicationContext(), TelaTriangulo.class);
            startActivityForResult(intencao, 2);
        } else {
            Intent intencao = new Intent(getApplicationContext(), TelaCirculo.class);
            startActivityForResult(intencao, 3);
        }

    }

}
