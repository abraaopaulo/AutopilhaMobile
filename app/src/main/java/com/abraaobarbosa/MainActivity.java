package com.abraaobarbosa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.abraaobarbosa.automato.Automato;
import com.abraaobarbosa.model.Cadeia;
import com.abraaobarbosa.model.Estado;
import com.abraaobarbosa.model.Transicao;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtResul;
    private TextInputEditText txtElementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtResul = findViewById(R.id.textView);
        txtElementos = findViewById(R.id.txtElementos);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(), AddAutomatoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void automatoDePilha(View view){
        ArrayList<Estado> estados = new ArrayList<>();

        Estado q0 = new Estado(); q0.setNome("q0");
        Estado q1 = new Estado(); q1.setNome("q1");
        Estado q2 = new Estado(); q2.setNome("q2");

        q0.setEstadoInicial(true);
        q2.setEstadoFinal(true);

        estados.add(q0);
        estados.add(q1);
        estados.add(q2);

        ArrayList<Transicao> q0Transicoes = new ArrayList<>();
        q0Transicoes.add(new Transicao(estados.get(0),estados.get(0),"0","E","E"));
        q0Transicoes.add(new Transicao(estados.get(0),estados.get(1),"E","E","E"));

        ArrayList<Transicao> q1Transicoes = new ArrayList<>();
        q1Transicoes.add(new Transicao(estados.get(1),estados.get(1),"1","x","E"));
        q1Transicoes.add(new Transicao(estados.get(1),estados.get(2),"E","$","$"));

        ArrayList<Transicao> q3Transicoes = new ArrayList<>();

        q0.setTransicoes(q0Transicoes);
        q1.setTransicoes(q1Transicoes);
        q2.setTransicoes(q3Transicoes);

        char[] elementos = txtElementos.getText().toString().toCharArray();
        String[] elementosProntos = new String[elementos.length];
        for (int i = 0; i< elementos.length;i++){
            elementosProntos[i] = elementos[i]+"";
        }
        Cadeia c = new Cadeia();

        c.setItens(elementosProntos);

        Automato a = new Automato(estados, c);
        ArrayList<String> listresul = a.run();
        for(String s: listresul){
            txtResul.setText(txtResul.getText().toString()+"\n"+s);
        }

    }
    public void maquinaTuring(View view){

    }
}
