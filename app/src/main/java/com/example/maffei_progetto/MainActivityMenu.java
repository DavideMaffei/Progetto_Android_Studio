package com.example.maffei_progetto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityMenu extends AppCompatActivity
{
    SampleFragment f = new SampleFragment();

    //--------------------------------------------------------------------------------
    public static boolean StorageAccess = false;
    public final String myLogTAG = "PERMISSION";
    private final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 101;
    public final String explain = "Questa app necessita di accedere ai file nella memoria interna";
    //--------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //--------------------------------------------------------------------------------
        int newScore = 100;
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("mykey", newScore);
        editor.remove("name"); // will delete key name
        editor.remove("email"); // will delete key email
        editor.commit();
        String s = sharedPref.getString("myotherkey", "boh");
        float d = sharedPref.getFloat("myotherotherkey", 0.0f);
        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE, explain);
        //--------------------------------------------------------------------------------

        //quando si schiaccia il bottone per giocare a tris, compare un fragment con l'inserimento dei nomi del giocatore
        Button btnTris = (Button) findViewById(R.id.buttonTris);
        btnTris.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_down);
                    ft.replace(R.id.fragment_container, f);
                    ft.commit();
            }
        });

        //bottone per l'apertura della calcolatrice
        Button btnCalcolatrice = (Button) findViewById(R.id.buttonCalcolatrice);
        btnCalcolatrice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Apertura Calcolatrice", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivityMenu.this, MainActivityCalcolatrice.class);
                startActivity(i);
            }
        });

        //bottone per l'apertura della classifica
        Button btnClassifica = (Button) findViewById(R.id.buttonClassifica);
        btnClassifica.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Apertura della classifica", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivityMenu.this, MainActivityClassifica.class);
                startActivity(i);
            }
        });

    }

    //se viene premuto il pulsante "indietro" compare un alert dialog che chiede conferma se si vuole uscire dall'app
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityMenu.this);
        builder.setTitle("Exit");
        builder.setMessage("Vuoi uscire dall'applicazione?");
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
    //--------------------------------------------------------------------------------
    public void checkPermission(final String myPermission, final int MY_PERMISSIONS_REQUEST, final String explanation)
    {

        if (ContextCompat.checkSelfPermission(this, myPermission) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, myPermission))
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(explanation);
                builder.setMessage(explanation);
                builder.setCancelable(true);
                builder.setNeutralButton("Chiudi", new
                        DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.dismiss();
                                // Request permission
                                ActivityCompat.requestPermissions(MainActivityMenu.this,
                                        new String[]{myPermission},
                                        MY_PERMISSIONS_REQUEST);

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{myPermission},MY_PERMISSIONS_REQUEST);
            }
        }
        else
        {
            Toast myToast = Toast.makeText(this, myPermission + "era gia OK", Toast.LENGTH_LONG);
            myToast.show();
            Log.d(myLogTAG, myPermission + " era gia OK");
            StorageAccess = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast myToast = Toast.makeText(this, "Permesso Garantito!", Toast.LENGTH_LONG);
                    myToast.show();
                    Log.d(myLogTAG, "Permesso Garantito!");
                    StorageAccess = true;

                } else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast myToast = Toast.makeText(this, "Permesso rifiutato!", Toast.LENGTH_LONG);
                    myToast.show();
                    Log.d(myLogTAG, "Permesso rifiutato!");

                }
                return;
            }
        }
    }
    //--------------------------------------------------------------------------------

}