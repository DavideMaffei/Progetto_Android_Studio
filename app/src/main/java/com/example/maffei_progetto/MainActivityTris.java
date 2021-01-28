package com.example.maffei_progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityTris extends AppCompatActivity
{
    //ogni volta che si inizia una partita, il primo a giocare sarà la X...alla partita successiva invece inizia il O
    private String inizio="X";

    private String nome1="",nome2="";
    private String b1="", b2="", b3="", b4="", b5="", b6="", b7="", b8="", b9="";

    private int contX=0, contO=0;

    private int pareggio=0;

    private Chronometer timer;

    String filename="classifica.txt";
    long tempofine;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tris);

        //siccome il nome dei giocatori viene inserito nell menu, dobbiamo utilizzare l'intent per memorizzarli in questa activity
        Intent intent = getIntent();

        nome1 = intent.getStringExtra("nome1");
        ((TextView) findViewById(R.id.textViewGiocatore1)).setText(nome1+": 0");

        nome2 = intent.getStringExtra("nome2");
        ((TextView) findViewById(R.id.textViewGiocatore2)).setText(nome2+": 0");

        //qui parte il timer all'apertura dell'activity
        timer=findViewById(R.id.cronometro);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()
        {
            @Override
            public void onChronometerTick(Chronometer cronometro)
            {
                timer=cronometro;
            }
        });
        timer.start();

//-------------------------------------TUTTE LE AZIONI DEI 9 BOTTONI CHE FORMANO LA GRIGLIA DI GIOCO--------------------------------------//

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn1.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn1.setTextColor(Color.RED);
                }
                else
                {
                    btn1.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b1= (String) btn1.getText();
                Vittoria();
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn2.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn2.setTextColor(Color.RED);
                }
                else
                {
                    btn2.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b2= (String) btn2.getText();
                Vittoria();
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn3.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn3.setTextColor(Color.RED);
                }
                else
                {
                    btn3.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b3= (String) btn3.getText();
                Vittoria();
            }
        });

        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn4.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn4.setTextColor(Color.RED);
                }
                else
                {
                    btn4.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b4= (String) btn4.getText();
                Vittoria();
            }
        });

        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn5.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn5.setTextColor(Color.RED);
                }
                else
                {
                    btn5.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b5= (String) btn5.getText();
                Vittoria();
            }
        });

        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn6.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn6.setTextColor(Color.RED);
                }
                else
                {
                    btn6.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b6= (String) btn6.getText();
                Vittoria();
            }
        });

        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn7.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn7.setTextColor(Color.RED);
                }
                else
                {
                    btn7.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b7= (String) btn7.getText();
                Vittoria();
            }
        });

        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn8.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn8.setTextColor(Color.RED);
                }
                else
                {
                    btn8.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b8= (String) btn8.getText();
                Vittoria();
            }
        });

        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pareggio++;
                btn9.setText(inizio);
                if(inizio.equalsIgnoreCase("X"))
                {
                    btn9.setTextColor(Color.RED);
                }
                else
                {
                    btn9.setTextColor(Color.BLUE);
                }
                ScegliGiocatore();
                b9= (String) btn9.getText();
                Vittoria();
            }
        });

//--------------------------------I DUE BOTTONI RICOMINCIA ED ESCI---------------------------------------------------------------------

        Button btnRicomincia = (Button) findViewById(R.id.buttonRicomincia);
        btnRicomincia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                btn1.setText(""); btn2.setText(""); btn3.setText(""); btn4.setText(""); btn5.setText(""); btn6.setText(""); btn7.setText(""); btn8.setText(""); btn9.setText("");
                pareggio=0;
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                Toast.makeText(getApplicationContext(), "Partita Ricominciata", Toast.LENGTH_LONG).show();
            }
        });

        Button btnEsci = (Button) findViewById(R.id.buttonEsci2);
        btnEsci.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityTris.this);
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

        //qui di seguito ogni volta che l'activity viene ricreata perché stata distrutta dopo aver girato lo schermo, le variabili vengono salvate: nomi giocatori, le X e O, il punteggio
        if(savedInstanceState!=null)
        {
            b1=savedInstanceState.getString("b1");
            btn1.setText(String.valueOf(b1));               if(b1.matches("X")){btn1.setTextColor(Color.RED);}else{btn1.setTextColor(Color.BLUE);}
            b2=savedInstanceState.getString("b2");
            btn2.setText(String.valueOf(b2));               if(b2.matches("X")){btn2.setTextColor(Color.RED);}else{btn2.setTextColor(Color.BLUE);}
            b3=savedInstanceState.getString("b3");
            btn3.setText(String.valueOf(b3));               if(b3.matches("X")){btn3.setTextColor(Color.RED);}else{btn3.setTextColor(Color.BLUE);}
            b4=savedInstanceState.getString("b4");
            btn4.setText(String.valueOf(b4));               if(b4.matches("X")){btn4.setTextColor(Color.RED);}else{btn4.setTextColor(Color.BLUE);}
            b5=savedInstanceState.getString("b5");
            btn5.setText(String.valueOf(b5));               if(b5.matches("X")){btn5.setTextColor(Color.RED);}else{btn5.setTextColor(Color.BLUE);}
            b6=savedInstanceState.getString("b6");
            btn6.setText(String.valueOf(b6));               if(b6.matches("X")){btn6.setTextColor(Color.RED);}else{btn6.setTextColor(Color.BLUE);}
            b7=savedInstanceState.getString("b7");
            btn7.setText(String.valueOf(b7));               if(b7.matches("X")){btn7.setTextColor(Color.RED);}else{btn7.setTextColor(Color.BLUE);}
            b8=savedInstanceState.getString("b8");
            btn8.setText(String.valueOf(b8));               if(b8.matches("X")){btn1.setTextColor(Color.RED);}else{btn8.setTextColor(Color.BLUE);}
            b9=savedInstanceState.getString("b9");
            btn9.setText(String.valueOf(b9));               if(b9.matches("X")){btn9.setTextColor(Color.RED);}else{btn9.setTextColor(Color.BLUE);}
            contX=savedInstanceState.getInt("punteggioX");
            contO=savedInstanceState.getInt("punteggioO");
            nome1=savedInstanceState.getString("nome1");
            nome2=savedInstanceState.getString("nome2");
            ((TextView) findViewById(R.id.textViewGiocatore1)).setText(nome1+": "+contX);
            ((TextView) findViewById(R.id.textViewGiocatore2)).setText(nome2+": "+contO);
        }
    }

    //qui si decidono i giocatori, di default inizio è X, quindi alla prima partita il giocatre inizia con X
    //ma alla seconda partita ad iniziare sarà O

    private void ScegliGiocatore()
    {
        if(inizio.matches("X"))
        {
            inizio="O";
        }
        else
        {
            inizio="X";
        }
    }

    //visualizzazione e aggiornamento del punteggio
    private void Punteggio()
    {
        TextView punteggio1 =(TextView) findViewById(R.id.textViewGiocatore1);
        punteggio1.setText(nome1+": "+contX);

        TextView punteggio2 =(TextView) findViewById(R.id.textViewGiocatore2);
        punteggio2.setText(nome2+": "+contO);
    }

    //comparsa dell'alert dialog in caso di vittoria di X
    private void MessaggioX()
    {
        tempofine = (SystemClock.elapsedRealtime() - timer.getBase())/1000;

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityTris.this);
        builder.setTitle("Partita Terminata!");
        builder.setMessage(nome1+" ha vinto");
        builder.setCancelable(true);
        AlertDialog alert = builder.create();
        alert.show();
        timer.setBase(SystemClock.elapsedRealtime());
        timer.stop();

        //il risultato della partita viene scritto nel file
        if(MainActivityMenu.StorageAccess)
        {
            String content="Ha vinto "+nome1+" contro "+nome2+" nel seguente tempo: "+tempofine+" secondi";
            if(filename.length()>0 && content.length() > 0)
            {
                FileUtils.createDirectory(FileUtils.directory, getApplicationContext());
                FileUtils.writeFile(filename, getApplicationContext(), content);
                Toast.makeText(getApplicationContext(), "Trying to write file "+filename +" in directory "+ FileUtils.directory+": \r\n"+ FileUtils.listDir(getApplicationContext()), Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getApplicationContext(), "Fields are required!", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Sorry.. Cannot access storage.. missing permission!", Toast.LENGTH_LONG).show();
    }

    //comparsa dell'alert dialog in caso di vittoria di X
    private void MessaggioO()
    {
        tempofine = (SystemClock.elapsedRealtime() - timer.getBase())/1000;

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityTris.this);
        builder.setTitle("Partita Terminata!");
        builder.setMessage(nome2+" ha vinto");
        builder.setCancelable(true);
        AlertDialog alert = builder.create();
        alert.show();
        timer.setBase(SystemClock.elapsedRealtime());
        timer.stop();

        //il risultato della partita viene scritto nel file
        if(MainActivityMenu.StorageAccess)
        {
            String content="Ha vinto "+nome2+" contro "+nome1+" nel seguente tempo: "+tempofine+" secondi";
            if(filename.length()>0 && content.length() > 0)
            {
                FileUtils.createDirectory(FileUtils.directory,getApplicationContext());
                FileUtils.writeFile(filename, getApplicationContext(), content);
                Toast.makeText(getApplicationContext(), "Trying to write file "+filename +" in directory "+ FileUtils.directory+": \r\n"+ FileUtils.listDir(getApplicationContext()), Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getApplicationContext(), "Fields are required!", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Sorry.. Cannot access storage.. missing permission!", Toast.LENGTH_LONG).show();

    }

    //funzione che pulisce la griglia, quando si decide di rigiocare una paritta
    private void Pulizia()
    {
        b1=""; b2=""; b3=""; b4=""; b5=""; b6=""; b7=""; b8=""; b9="";
    }

    //-------------------------FUNZIONE CHE VEDE QUALE GIOCATORE HA VINTO LA PARTITA---------------------------------
    private void Vittoria()
    {
                                        //-----------Giocatore X-----------------

        if(b1.matches("X") && b2.matches("X") && b3.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b4.matches("X") && b5.matches("X") && b6.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b7.matches("X") && b8.matches("X") && b9.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b1.matches("X") && b4.matches("X") && b7.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b2.matches("X") && b5.matches("X") && b8.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b3.matches("X") && b6.matches("X") && b9.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b1.matches("X") && b5.matches("X") && b9.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }
        else if(b3.matches("X") && b5.matches("X") && b7.matches("X"))
        {
            MessaggioX();
            contX++;
            Punteggio();
            Pulizia();
        }

                            //---------------Giocatore 0---------------

        else if(b1.matches("O") && b2.matches("O") && b3.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(b4.matches("O") && b5.matches("O") && b6.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(b7.matches("O") && b8.matches("O") && b9.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(b1.matches("O") && b4.matches("O") && b7.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(b2.matches("O") && b5.matches("O") && b8.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(b3.matches("O") && b6.matches("O") && b9.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        } else if(b1.matches("O") && b5.matches("O") && b9.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(b3.matches("O") && b5.matches("O") && b7.matches("O"))
        {
            MessaggioO();
            contO++;
            Punteggio();
            Pulizia();
        }
        else if(pareggio==9)
        {
            tempofine = (SystemClock.elapsedRealtime() - timer.getBase())/1000;

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityTris.this);
            builder.setTitle("Partita Terminata!");
            builder.setMessage("Pareggio!");
            builder.setCancelable(true);
            AlertDialog alert = builder.create();
            alert.show();
            timer.setBase(SystemClock.elapsedRealtime());
            timer.stop();

            //in caso di pareggio, anche questo risultato deve essere scritto nel file della classifica
            if(MainActivityMenu.StorageAccess)
            {
                String content="La partita è finita in pareggio tra: "+nome1+" e "+nome2+" nel seguente tempo: "+tempofine+" secondi";
                if(filename.length()>0 && content.length() > 0)
                {
                    FileUtils.createDirectory(FileUtils.directory,getApplicationContext());
                    FileUtils.writeFile(filename, getApplicationContext(), content);
                    Toast.makeText(getApplicationContext(), "Trying to write file "+filename +" in directory "+ FileUtils.directory+": \r\n"+ FileUtils.listDir(getApplicationContext()), Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Fields are required!", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getApplicationContext(), "Sorry.. Cannot access storage.. missing permission!", Toast.LENGTH_LONG).show();
        }
    }

    //qui vengono le salvate le variabili in caso lo schermo venga girato
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("b1",b1);outState.putString("b2",b2);outState.putString("b3",b3);outState.putString("b4",b4);outState.putString("b5",b5);outState.putString("b6",b6);outState.putString("b7",b7);
        outState.putString("b8",b8);outState.putString("b9",b9);outState.putInt("punteggioX",contX);outState.putInt("punteggioO",contO);outState.putString("nome1",nome1);outState.putString("nome2",nome2);

    }

    //se viene premuto il pulsante "indietro" compare un alert dialog che chiede conferma se si vuole andare al menu
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityTris.this);
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