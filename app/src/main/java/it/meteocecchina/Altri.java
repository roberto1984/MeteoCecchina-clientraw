package it.meteocecchina;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import android.R.string;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import android.widget.ImageView;





public class Altri extends Activity {
	// Dichiarazione oggetti
    TextView data;
    TextView alba;
    TextView tramonto;
    TextView lunghezzagiorno;
    TextView tempinterna;
    TextView huminterna;
    TextView pioggiamese;
    TextView pioggiaanno;
    TextView pioggiatemporale;
    TextView luna;
    TextView albaluna;
    TextView tramontoluna;
    TextView densita;
    TextView altezzanubi;
    TextView vartemp1h;
    TextView varwind1h;
    TextView varhum1h;
    TextView varpress1h;
    TextView vartemp1d;
    TextView varwind1d;
    TextView varhum1d;
    TextView varpress1d;
    //Button btnImport;
    //Button btnImport2;
    //Button btnImport3;
    
    //private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            Log.i("main", "BEGIN");
            setContentView(R.layout.main_altri); //Carico layout
            
            // Inizializzo gli  oggetti
            data = (TextView) findViewById(R.id.data);
            alba = (TextView) findViewById(R.id.alba);
            tramonto = (TextView) findViewById(R.id.tramonto);
            lunghezzagiorno = (TextView) findViewById(R.id.lunghezzagiorno);
            tempinterna = (TextView) findViewById(R.id.tempinterna); 
            huminterna = (TextView) findViewById(R.id.huminterna);
            pioggiamese = (TextView) findViewById(R.id.pioggiamese);
            pioggiaanno = (TextView) findViewById(R.id.pioggiaanno);
            pioggiatemporale = (TextView) findViewById(R.id.pioggiatemporale);
            luna = (TextView) findViewById(R.id.luna);
            albaluna = (TextView) findViewById(R.id.albaluna);
            tramontoluna = (TextView) findViewById(R.id.tramontoluna);
            densita = (TextView) findViewById(R.id.densita);
            altezzanubi = (TextView) findViewById(R.id.altezzanubi);
            vartemp1h = (TextView) findViewById(R.id.vartemp1h);
            varwind1h = (TextView) findViewById(R.id.varwind1h);
            varhum1h = (TextView) findViewById(R.id.varhum1h);
            varpress1h = (TextView) findViewById(R.id.varpress1h);
            vartemp1d = (TextView) findViewById(R.id.vartemp1d);
            varwind1d = (TextView) findViewById(R.id.varwind1d);
            varhum1d = (TextView) findViewById(R.id.varhum1d);
            varpress1d = (TextView) findViewById(R.id.varpress1d);            
            
            startImport();
            
            //dichiaro i 3 bottoni per i dati minimi attuali e massimi
            //sono definiti nel main_attuali
            //btnImport = (Button) findViewById(R.id.btnImport);
            //btnImport2 = (Button) findViewById(R.id.btnImport2);
            //btnImport3 = (Button) findViewById(R.id.btnImport3);

            //come per cambiare attivity ma qui invece lo uso per richiamare una funzione cioe startimport(piu in basso)
            //btnImport.setOnClickListener(new OnClickListener() 
            //                 {

            //    public void onClick(View v) {
            // TODO Auto-generated method stub
            //Richiamo il metodo che esegue il parse
            //startImport("attuali");
            //    }
            //});
            //idem
            //btnImport2.setOnClickListener(new OnClickListener() 
            //{

            //	public void onClick(View v) {
           // TODO Auto-generated method stub
           //Richiamo il metodo che esegue il parse
           //startImport("minimi");
           // 	}
           // });
            //idem
           // btnImport3.setOnClickListener(new OnClickListener() 
           // {

           // 	public void onClick(View v) {
           // TODO Auto-generated method stub
           //startImport("massimi");
           // 	}
           // });
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Aggiorna").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
                startImport();
    			return true;
    		}
    	});;
    	return true;
	}

    // Metodo parse file
    //qui c'e il metodo per il calcolo dei dati attuali
    private void startImport() 
    {
       
        	
    	try {
            // Create a URL for the desired page,posso leggere anche gli htm!
            URL url = new URL("http://www.meteoseano.it/clientraw.txt");
            URL url2 = new URL("http://www.meteoseano.it/clientrawextra.txt");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            String[] str= new String[147];
            //StringBuilder sb = new StringBuilder(100);
            String line = in.readLine(); //lettura riga
            String line2 = in2.readLine(); //lettura riga
            int i = 0;
            String[] dati = line.split(" "); //split. A questo punto nell'array di stringhe "dati" hai i valori, nel mio caso splittati per "spazio".
            String[] dati2 = line2.split(" "); //split. A questo punto nell'array di stringhe "dati" hai i valori, nel mio caso splittati per "spazio".


            while (line != null && line2 != null){
            	if(i==0){
                str[i]=line;
                data.setText("Agg alle "+dati[29]+":"+dati[30]+" del "+dati[74]);
                }
            	if(i==0){
            	str[i]=line;
                pioggiamese.setText(dati[8]+" mm");
            	}
                if(i==0){
                    str[i]=line;
                    pioggiaanno.setText(dati[9]+" mm");
                }
            	if(i==0){
            	str[i]=line;
                tempinterna.setText(dati[12]);
            	}
            	if(i==0){
            	str[i]=line;
                huminterna.setText(dati[13]);
            	}
            	if(i==0){
                str[i]=line;
                altezzanubi.setText(dati[73]);
                }
            	if(i==0){
                    str[i]=line;
                alba.setText(dati2[556]);
                }
            	if(i==0){
                    str[i]=line;
                tramonto.setText(dati2[557]);
                }
                if(i==0){
                    str[i]=line;
                    albaluna.setText(dati2[558]);
                }
                if(i==0){
                    str[i]=line;
                    tramontoluna.setText(dati2[559]);
                }
            	i++;
            	line = in.readLine(); // legge la prossima riga
                line2 = in2.readLine(); // legge la prossima riga
            	}
            in.close();
            in2.close();
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	alba.setText("mal");
        } catch (IOException e) {
        	tramonto.setText("io");
        }
    }//fine if
    
}

