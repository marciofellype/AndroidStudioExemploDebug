package mobile.fasam.edu.br;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListaActivity extends DebugActivity {

    EditText txtNome;
    EditText txtEmail;
    ListView listView;

    List<HashMap<String,String>> Lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void adicionar(View view) {

        //capturar dados da tela
        //findviewbyid busca pelo id
        //utilizando a classe r do java

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);

        //declarar as variaveis para receer os dados
        String nome, email;
        //extrair conteudo do componente edittext

        nome = txtNome.getText().toString();
        email = txtEmail.getText().toString();

        //formatar saida para o usuario

        String dados;
        dados = String.format("Os dados digitados foram %s %s", nome, email);

        //Adiciona dados em um mapa de valores(dicionario)
        //Mapa com um "array associativo", k = key, v = value

        HashMap<String,String> map = new HashMap<>();
        map.put("nome", nome);
        map.put("email", email);

        Lista.add(map);

        //mapeamento de dados do list<hashmap=k,v> pada imprimir no layout
        String[] de = {"nome","email"};//dados do map
        int[] para = {R.id.labelNome, R.id.labelEmail};//id do layout item.xml

        //criar o simpleadapter
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), Lista, R.layout.item, de, para);

        //buscar a listview e imprimir os dados
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
