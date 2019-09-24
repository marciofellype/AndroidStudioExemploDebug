package mobile.fasam.edu.br;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void exibirTela(View view) {

        int opcao = view.getId();
        Intent intent;

        //verifica qual botao foi adicionado

        switch (opcao){
            //Exibir tela Main

            case R.id.btnMain:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            break;

            case R.id.btnAluno:

                intent = new Intent(this, AlunoActivity.class);
                intent.putExtra("dados", "Exemplo de passagem de parametros");
                startActivity(intent);

                break;

            case R.id.btnProfessor:


                break;

            case R.id.btnLista:
                intent = new Intent( this,ListaActivity.class);
                startActivity(intent);
                break;

                default:
                    Toast.makeText(getApplicationContext(), "Opção invalida", Toast.LENGTH_LONG).show();
        }

    }
}
