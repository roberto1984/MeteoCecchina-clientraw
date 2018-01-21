package it.meteocecchina;

import android.app.Activity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;





public class Estremi extends Activity {
	// Dichiarazione oggetti
    TextView temperatura;
    TextView umidita;
    TextView pressione;
    TextView ventom;
    TextView ventoDir;
    TextView pioggia;
    TextView dewpoint;
    TextView heatIndex;
    TextView rainRate;
    TextView data;
    TextView Intestazione;
    ImageView tempImm;
    ImageView humImm;
    ImageView pressImm;
    ImageView windmImm;
    ImageView windDirImm;
    ImageView rainImm;
    ImageView dewImm;
    ImageView hIndexImm;
    ImageView rRateImm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            Log.i("main", "BEGIN");
            setContentView(R.layout.main_estremi); //Carico layout
            
                            // Inizializzo gli  oggetti
            temperatura = (TextView) findViewById(R.id.temperatura);
            umidita = (TextView) findViewById(R.id.umidita);
            pressione = (TextView) findViewById(R.id.pressione);
            ventom = (TextView) findViewById(R.id.ventom); 
            ventoDir = (TextView) findViewById(R.id.ventoDir);
            pioggia = (TextView) findViewById(R.id.pioggia);
            dewpoint = (TextView) findViewById(R.id.dewpoint);
            heatIndex = (TextView) findViewById(R.id.heatIndex);
            rainRate = (TextView) findViewById(R.id.rainRate);
            data = (TextView) findViewById(R.id.data);
            Intestazione = (TextView) findViewById(R.id.intestazione);


            
            //ventoMed = (TextView) findViewById(R.id.ventoMed);
            //ventoDir = (TextView) findViewById(R.id.ventoDir);
            //pioggia = (TextView) findViewById(R.id.pioggia);
            //rainRate = (TextView) findViewById(R.id.rainRate);  
            tempImm = (ImageView) findViewById(R.id.tempImage);
            tempImm.setImageResource(R.drawable.temper);
            humImm = (ImageView) findViewById(R.id.humImage);
            humImm.setImageResource(R.drawable.humid);
            pressImm = (ImageView) findViewById(R.id.pressImage);
            pressImm.setImageResource(R.drawable.press);
            windmImm = (ImageView) findViewById(R.id.windmImage);
            windmImm.setImageResource(R.drawable.windm);  
            windDirImm = (ImageView) findViewById(R.id.windDirImage);
            windDirImm.setImageResource(R.drawable.windd);  
            rainImm = (ImageView) findViewById(R.id.rainImage);
            rainImm.setImageResource(R.drawable.rain);  
            dewImm = (ImageView) findViewById(R.id.dewImage);
            dewImm.setImageResource(R.drawable.dew);  
            hIndexImm = (ImageView) findViewById(R.id.hIndexImage);
            hIndexImm.setImageResource(R.drawable.hi);  
            rRateImm = (ImageView) findViewById(R.id.rRateImage);
            rRateImm.setImageResource(R.drawable.rr);  
               

            
    }
 //*********************CREZAZIONE MENU**************
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Max mensili").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("max_mese");
    			return true;
    		}
    	});;
    	menu.add("Max Annuali").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("max_anno");
    			return true;
    		}
    	});;
    	menu.add("Max Assoluti").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("max_ass");
    			return true;
    		}
    	});;
    	menu.add("Min mensili").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("min_mese");
    			return true;
    		}
    	});;

    	menu.add("Min Annuali").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("min_anno");
    			return true;
    		}
    	});;

    	menu.add("Min assoluti").setOnMenuItemClickListener(new OnMenuItemClickListener() {
    		public boolean onMenuItemClick(MenuItem item) {
    			startImport("min_ass");
    			return true;
    		}
    	});;

    	return true;
	}
    // Metodo parse file
    private void startImport(String string) 
    {
          
    	try {
            // Create a URL for the desired page,posso leggere anche gli htm!
            URL url = new URL("http://www.meteoseano.it/clientrawextra.txt");
            URL url2 = new URL("http://www.meteoseano.it/clientraw.txt");

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

            //***************INIZIO CONDIZIONI IF***************
           if(string =="min_mese"){
           
            while (line != null){
                if(i==0){
                str[i]=line;
                data.setText("Agg alle "+dati2[29]+":"+dati2[30]+" del "+dati2[74]);
                }
                if(i==0){
            	str[i]=line;
                temperatura.setText(dati[67]);
            	}
            	if(i==0){
                    str[i]=line;
                pressione.setText(dati[85]);
                }
            	if(i==0){
                    str[i]=line;
                dewpoint.setText(dati[735]);
                }
            	
            	
            	i++;
            	line = in.readLine(); // legge la prossima riga 
            	} 

            in.close();
            umidita.setText("ND");
            ventom.setText("ND");
            ventoDir.setText("ND");
            pioggia.setText("ND");
            heatIndex.setText("ND");
            rainRate.setText("ND");
            Intestazione.setText("Estremi minimi mensili");
           }//***************fine if***********
           if(string =="max_mese"){
        	   
        	   while (line != null){
                if(i==0){
                    str[i]=line;
                    data.setText("Agg alle "+dati2[29]+":"+dati2[30]+" del "+dati2[74]);
                   }
               	if(i==0){
                    str[i]=line;
                   temperatura.setText(dati[61]);
               	}
               	if(i==0){
               	   str[i]=line;
                   pressione.setText(dati[91]);
                   }
               	if(i==0){
                   str[i]=line;
                   Double ventonodi=Double.parseDouble(dati[73]);
                   ventonodi=ventonodi*1.852;
                   ventom.setText(String.valueOf(String.format("%.2f", ventonodi)));
                   }
               	if(i==0){
                   str[i]=line;
                   dewpoint.setText(dati[729]);
                   }
               	if(i==0){
                   str[i]=line;
                   heatIndex.setText(dati[175]);
                   }
               	if(i==0){
                   str[i]=line;
                   rainRate.setText(dati[79]);
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 
               in.close();
        	   umidita.setText("ND");
               ventoDir.setText("ND");
               pioggia.setText("ND");
               Intestazione.setText("Estremi massimi mensili"); 
           }//****************fine if ***************************
           if(string =="min_anno"){
        	   
               while (line != null){
                   if(i==0){
                       str[i]=line;
                       data.setText("Agg alle "+dati2[29]+":"+dati2[30]+" del "+dati2[74]);
                   }
                   if(i==0){
                       str[i]=line;
                       temperatura.setText(dati[193]);
                   }
                   if(i==0){
                       str[i]=line;
                       pressione.setText(dati[217]);
                   }
                   if(i==0){
                       str[i]=line;
                       dewpoint.setText(dati[747]);
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 

               in.close();
               ventom.setText("ND");
               ventoDir.setText("ND");
               pioggia.setText("ND");
               heatIndex.setText("ND");
               rainRate.setText("ND");
               Intestazione.setText("Estremi minimi Annuali");
           }//****************fine if ***************************
           if(string =="max_anno"){
        	   
               while (line != null){
                   if(i==0){
                       str[i]=line;
                       data.setText("Agg alle "+dati2[29]+":"+dati2[30]+" del "+dati2[74]);
                   }
                   if(i==0){
                       str[i]=line;
                       temperatura.setText(dati[187]);
                   }
                   if(i==0){
                       str[i]=line;
                       pressione.setText(dati[211]);
                   }
                   if(i==0){
                       str[i]=line;
                       Double ventonodi=Double.parseDouble(dati[199]);
                       ventonodi=ventonodi*1.852;
                       ventom.setText(String.valueOf(String.format("%.2f", ventonodi)));
                   }
                   if(i==0){
                       str[i]=line;
                       dewpoint.setText(dati[741]);
                   }
                   if(i==0){
                       str[i]=line;
                       heatIndex.setText(dati[301]);
                   }
                   if(i==0){
                       str[i]=line;
                       rainRate.setText(dati[205]);
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 
               in.close();
               ventoDir.setText("ND");
               pioggia.setText("ND");
               Intestazione.setText("Estremi massimi annuali");
           }//****************fine if ***************************
           if(string =="min_ass"){
        	   
               while (line != null){
                   if(i==0){
                       str[i]=line;
                       data.setText("Agg alle "+dati2[29]+":"+dati2[30]+" del "+dati2[74]);
                   }
                   if(i==0){
                       str[i]=line;
                       temperatura.setText(dati[319]);
                   }
                   if(i==0){
                       str[i]=line;
                       pressione.setText(dati[337]);
                   }
                   if(i==0){
                       str[i]=line;
                       dewpoint.setText(dati[759]);
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 

               in.close();
               ventom.setText("ND");
               ventoDir.setText("ND");
               pioggia.setText("ND");
               heatIndex.setText("ND");
               rainRate.setText("ND");
               Intestazione.setText("Estremi minimi assoluti");
           }//****************fine if ***************************
           if(string =="max_ass"){
        	   
               while (line != null){
                   if(i==0){
                       str[i]=line;
                       data.setText("Agg alle "+dati2[29]+":"+dati2[30]+" del "+dati2[74]);
                   }
                   if(i==0){
                       str[i]=line;
                       temperatura.setText(dati[313]);
                   }
                   if(i==0){
                       str[i]=line;
                       pressione.setText(dati[343]);
                   }
                   if(i==0){
                       str[i]=line;
                       Double ventonodi=Double.parseDouble(dati[325]);
                       ventonodi=ventonodi*1.852;
                       ventom.setText(String.valueOf(String.format("%.2f", ventonodi)));
                   }
                   if(i==0){
                       str[i]=line;
                       dewpoint.setText(dati[753]);
                   }
                   if(i==0){
                       str[i]=line;
                       heatIndex.setText(dati[427]);
                   }
                   if(i==0){
                       str[i]=line;
                       rainRate.setText(dati[331]);
                   }
               	
               	
               	i++;
               	line = in.readLine(); // legge la prossima riga 
               	} 
               in.close();
               ventoDir.setText("ND");
               pioggia.setText("ND");
               Intestazione.setText("Estremi massimi assoluti"); 
           }//***************FINE CONDIZIONI IF*************** 
            //txtDifficolta.setText(sb.toString());
        } catch (MalformedURLException e) {
        	temperatura.setText("mal");
        } catch (IOException e) {
        	umidita.setText("io");
        }
    }

}