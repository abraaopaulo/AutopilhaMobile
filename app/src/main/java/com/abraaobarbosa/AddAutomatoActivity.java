package com.abraaobarbosa;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddAutomatoActivity extends AppCompatActivity {

    private TextInputEditText txtEstado, ler, consome, retorna;
    private Spinner estadoAtual, estadoFinal, estadoInicial;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_automato);

        txtEstado = findViewById(R.id.txtNewEstado);
        ler = findViewById(R.id.ler);
        consome = findViewById(R.id.consome);
        retorna = findViewById(R.id.retorna);

        estadoAtual = findViewById(R.id.selectEstado);
        estadoInicial = findViewById(R.id.estadoInicialSpinner);
        estadoFinal = findViewById(R.id.estadoFinalSpinner);
        adapter    = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        estadoAtual.setAdapter(adapter);
    }
    public void addEstado(View view){




        adapter.add(txtEstado.getText().toString());
        txtEstado.setText("");


    }
    public void addTransicao(View view){
        Toast.makeText(this, estadoAtual.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }
}
