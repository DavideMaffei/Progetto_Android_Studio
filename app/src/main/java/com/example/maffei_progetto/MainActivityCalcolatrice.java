package com.example.maffei_progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityCalcolatrice extends AppCompatActivity
{
    private Double num1=null;
    private Double num2=null;
    private double risultato;
    private String operazione;
    private String numeroInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calcolatrice);

        TextView schermo = (TextView) findViewById(R.id.textViewSchermo);

//--------------------------BOTTONI CON I NUMERI DELLA CALCOLATRICE-------------------------------
        Button btn0 = (Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn0.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn1 = (Button) findViewById(R.id.buttonUno);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn1.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn2 = (Button) findViewById(R.id.buttonDue);
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn2.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn3 = (Button) findViewById(R.id.buttonTre);
        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn3.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn4 = (Button) findViewById(R.id.buttonQuattro);
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn4.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn5 = (Button) findViewById(R.id.buttonCinque);
        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn5.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn6 = (Button) findViewById(R.id.buttonSei);
        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn6.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn7 = (Button) findViewById(R.id.buttonSette);
        btn7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn7.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn8 = (Button) findViewById(R.id.buttonOtto);
        btn8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn8.getText().toString();
                schermo.setText(numeroInput);
            }
        });

        Button btn9 = (Button) findViewById(R.id.buttonNove);
        btn9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroInput=schermo.getText()+btn9.getText().toString();
                schermo.setText(numeroInput);
            }
        });

//--------------------------BOTTONI CON I LE OPERAZIONI DELLA CALCOLATRICE-------------------------------
        Button btnSomma = (Button) findViewById(R.id.buttonPiu);
        btnSomma.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                num1=Double.parseDouble((String) schermo.getText());
                schermo.setText("");
                operazione="+";
            }
        });

        Button btnSottrazione = (Button) findViewById(R.id.buttonMeno);
        btnSottrazione.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                num1=Double.parseDouble((String) schermo.getText());
                schermo.setText("");
                operazione="-";
            }
        });

        Button btnMoltiplicazione = (Button) findViewById(R.id.buttonPer);
        btnMoltiplicazione.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                num1=Double.parseDouble((String) schermo.getText());
                schermo.setText("");
                operazione="*";
            }
        });

        Button btnDivisione = (Button) findViewById(R.id.buttonDiviso);
        btnDivisione.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                num1=Double.parseDouble((String) schermo.getText());
                schermo.setText("");
                operazione="/";
            }
        });

        Button btnPercentuale = (Button) findViewById(R.id.buttonPercent);
        btnPercentuale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                double aux;
                num1=Double.parseDouble((String) schermo.getText());
                aux=num1*0.01;
                schermo.setText(""+aux);
            }
        });

        Button btnUGuale = (Button) findViewById(R.id.buttonUguale);
        btnUGuale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String risposta;

                if(num1==null && num2==null)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityCalcolatrice.this);
                    builder.setTitle("Errore");
                    builder.setMessage("Devi inserire degli operandi");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Ok capito!", new
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
                else
                {
                    num2=Double.parseDouble((String) schermo.getText());
                    if(operazione.equals("+"))
                    {
                        risultato=num1+num2;
                        risposta=String.format("%.2f", risultato);
                        schermo.setText(risposta);
                    }
                    else if(operazione.equals("-"))
                    {
                        risultato=num1-num2;
                        risposta=String.format("%.2f", risultato);
                        schermo.setText(risposta);
                    }
                    else if(operazione.equals("*"))
                    {
                        risultato=num1*num2;
                        risposta=String.format("%.2f", risultato);
                        schermo.setText(risposta);
                    }
                    else if(operazione.equals("/"))
                    {
                        risultato=num1/num2;
                        risposta=String.format("%.2f", risultato);
                        schermo.setText(risposta);
                    }
                    Toast.makeText(getApplicationContext(), "Calcolo Risultato..", Toast.LENGTH_LONG).show();
                    num1=null;num2=null;
                }
            }
        });

//--------------------------BOTTONI CON UTILITA' DELLA CALCOLATRICE-------------------------------
        Button btnEsc = (Button) findViewById(R.id.buttonEsc);
        btnEsc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityCalcolatrice.this);
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
        });

        Button btnPunto = (Button) findViewById(R.id.buttonPunto);
        btnPunto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String aux= (String) schermo.getText();
                schermo.setText(aux+".");
            }
        });

        Button btnIndietro = (Button) findViewById(R.id.buttonIndietro);
        btnIndietro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String spazio=null;

                if(schermo.getText().length()>0)
                {
                    StringBuilder aux = new StringBuilder(schermo.getText());
                    aux.deleteCharAt(schermo.getText().length()-1);
                    spazio=aux.toString();
                    schermo.setText(spazio);
                }
            }
        });

        Button btnCancella = (Button) findViewById(R.id.buttonC);
        btnCancella.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                schermo.setText(null);
            }
        });

        if(savedInstanceState!=null)
        {
            risultato=savedInstanceState.getDouble("risultato");
            schermo.setText(String.valueOf(risultato));
        }
    }

    //viene salvasto il risultato in caso l'activity venga distrutta a seguito del giramento di schermo
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putDouble("risultato",risultato);
    }

    //se viene premuto il pulsante "indietro" compare un alert dialog che chiede conferma se si vuole uscire dalla calcoaltrice
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityCalcolatrice.this);
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
}