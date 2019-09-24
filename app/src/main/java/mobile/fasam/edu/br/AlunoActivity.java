package mobile.fasam.edu.br;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AlunoActivity extends DebugActivity {

    List<HashMap<String,String>> ListaAluno = new ArrayList<>();


    EditText txtNomeAluno;
    EditText txtNota1;
    EditText txtNota2;
    EditText txtNota3;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
    }


    public void adicionarAluno(View view) {


        //capturar dados da tela
        //findviewbyid busca pelo id
        //utilizando a classe r do java

        txtNomeAluno = findViewById(R.id.txtNomeAluno);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        txtNota3 = findViewById(R.id.txtNota3);

        //declarar as variaveis para receer os dados
        String nome, Nota1, Nota2, Nota3;
        //extrair conteudo do componente edittext

        nome = txtNomeAluno.getText().toString();
        Nota1 = txtNota1.getText().toString();
        Nota2 = txtNota2.getText().toString();
        Nota3 = txtNota3.getText().toString();

        float media, n1, n2, n3;

        n1 = Float.parseFloat(Nota1);
        n2 = Float.parseFloat(Nota2);
        n3 = Float.parseFloat(Nota3);

        media = (n1+n2+n3)/3;

        String m;
        m = Float.toString(media);

        //formatar saida para o usuario

        String dados;
        dados = String.format("Os dados digitados foram %s %s %s %s %s", nome, Nota1,Nota2,Nota3, media);

        //Adiciona dados em um mapa de valores(dicionario)
        //Mapa com um "array associativo", k = key, v = value

        HashMap<String,String> map = new HashMap<>();
        map.put("nome", nome);
        map.put("nota1", Nota1);
        map.put("nota2", Nota2);
        map.put("nota3", Nota3);
        map.put("media", m);


        ListaAluno.add(map);

        //mapeamento de dados do list<hashmap=k,v> pada imprimir no layout
        String[] de = {"nome","nota1","nota2", "nota3", "media"};//dados do map
        int[] para = {R.id.labelNomeAluno, R.id.labelNota1, R.id.labelNota2, R.id.labelNota3, R.id.labelMedia };//id do layout item.xml

        //criar o simpleadapter
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), ListaAluno, R.layout.aluno, de, para);

        //buscar a listview e imprimir os dados
        listView = findViewById(R.id.listViewAluno);
        listView.setAdapter(adapter);
    }
    }
