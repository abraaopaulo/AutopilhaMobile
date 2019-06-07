package com.abraaobarbosa.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class AutomatoOpenHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "tm.db";
    private static final int VERSION = 1;
    private Context context;

    public AutomatoOpenHelper(Context context) {
        super(context, NOME_BANCO, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaDiciplina  = "CREATE TABLE  estado ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nome TEXT, "+
                " TEXT, "+
                " TEXT, "+
                " TEXT "+
                ");";
        String sqlTabelaLembrete  = "CREATE TABLE transicao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "estadoInicial TEXT, "+
                "estadoFinal TEXT, "+
                "ler TEXT "+
                ");";
        try {
            db.execSQL(sqlTabelaDiciplina);
            db.execSQL(sqlTabelaLembrete);
        }catch (Exception e){
            Toast.makeText(context, "Ocorreu um erro ao criar base de dados: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDisc = "DROP TABLE IF EXISTS estado";
        String sqlLembr = "DROP TABLE IF EXISTS transicao";
        try {
            db.execSQL(sqlDisc);
            db.execSQL(sqlLembr);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Ocorreu um erro ao atualizar base de dados: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



}
