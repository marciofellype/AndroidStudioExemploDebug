package mobile.fasam.edu.br;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends DebugActivity {

    EditText txtNome;
    EditText txtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exibir(View view) {

        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);

        //pegar os dados digitados

        String nome, telefone;
        nome = txtNome.getText().toString();
        telefone = txtTelefone.getText().toString();

        //exibir dados

        String dados = String.format("O texto digitado foi: %s %s", nome, telefone);

        Toast.makeText(getApplicationContext(),dados, Toast.LENGTH_LONG).show();



    }
}
