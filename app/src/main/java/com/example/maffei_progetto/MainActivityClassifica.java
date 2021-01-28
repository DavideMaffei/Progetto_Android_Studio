package com.example.maffei_progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityClassifica extends AppCompatActivity
{

    private String selectedFile="classifica.txt";
    private String testo ="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_classifica);


        TextView txtclassifica = (TextView) findViewById(R.id.txtTestoFile);

        //viene letto il file di testo contente la classifica, il contenuto memorizzato in una stringa che viene visualizzato nella TextView
        testo=FileUtils.readFile(selectedFile,getApplicationContext());
        txtclassifica.setText(testo);

        //la TextView non è editabile dall'utente
        txtclassifica.setKeyListener(null);
    }


    //quando viene premuto la freccia "indietro" compare un alert dialog che avvisa che si sta tornando al menu, e chiede conferma dell'azione
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityClassifica.this);
        builder.setTitle("Exit");
        builder.setMessage("Vuoi ritornare nel Menu?");
        builder.setCancelable(true);
        builder.setPositiveButton("Esci", new
                DialogInterface.OnClickListener()
                {
                    public void onClick(
                            DialogInterface dialog, int id)
                    {
                        dialog.dismiss();  // quit AlertDialog
                        finish();  // quit activity
                    }
                });
        builder.setNegativeButton("Annulla", new
                DialogInterface.OnClickListener()
                {
                    public void onClick(
                            DialogInterface dialog, int id)
                    {
                        dialog.dismiss();  // quit AlertDialog
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    //in caso il telefono venga ruotato, la classifica viene comunque salvata quando l'activity viene distrutta e poi ricostruita
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("risultato",testo);
    }
}