package einzelVeranlagung;

import userdaten.UserdatenEV;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.flashback.calcestv2.R;

public class WerbungskostenEV extends Activity {
	
	public EditText etEntfernungWA, etArbeitsTage, etSpendenGezahlt, etArbeitsMittelGezahlt, etTelefonKostenGezahlt;
	public boolean entfWAKomma = false;
 	public boolean aTageGanz = false;
 	public boolean spendenKomma = false;
 	public boolean aMittelKomma = false;
 	public boolean telefonKomma = false;
	public PopupWindow mpopup;
	Button btnGoToV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_werbungskosten);
		setTitle(R.string.title03);
		
		etEntfernungWA = (EditText)findViewById(R.id.etEntfernungWA); 
		etArbeitsTage = (EditText)findViewById(R.id.etArbeitstage);
		etSpendenGezahlt = (EditText)findViewById(R.id.etSpendenGezahlt);
		etArbeitsMittelGezahlt = (EditText)findViewById(R.id.etArbeitsmittelGezahlt);
		etTelefonKostenGezahlt = (EditText)findViewById(R.id.etTelefonkostenGezahlt);
		
		btnGoToV = (Button)findViewById(R.id.btnGoToVorsorge);
		btnGoToV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
						
			UserdatenEV user = (UserdatenEV)getApplication();
/* 			 
 * try-catch-Bloecke zur Pruefung, ob die korrekten Zahlenformate in die jeweiligen EditTexts eingegeben wurden, 
 * wenn JA - FLAG wird auf true gesetzt 
 * wenn nicht wird eine Fehlermeldung angezeigt
 * beim letzten try-catch-Block wieder gleichzeitig die naechste Activity gestartet, wenn das korrekte Zahlenformat eingegeben wurde.
 */			
			try {
				double EntfernungWA = Double.parseDouble(etEntfernungWA.getText().toString());
				user.setEntfernungWA(String.valueOf(EntfernungWA));
				entfWAKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Entfernung Wohnung Arbeit ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				int ArbeitsT = Integer.parseInt(etArbeitsTage.getText().toString());
				user.setArbeitsTage(String.valueOf(ArbeitsT));
				aTageGanz = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Arbeitstage ist keine Ganzzahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double SpendenG = Double.parseDouble(etSpendenGezahlt.getText().toString());
				user.setSpendenGezahlt(String.valueOf(SpendenG));
				spendenKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Spenden ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double ArbeitsmittelG = Double.parseDouble(etArbeitsMittelGezahlt.getText().toString());
				user.setArbeitsmittelGezahlt(String.valueOf(ArbeitsmittelG));
				aMittelKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Arbeitsmittel ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double TelefonkostenG = Double.parseDouble(etTelefonKostenGezahlt.getText().toString());
				user.setTelefonkostenGezahlt(String.valueOf(TelefonkostenG));
				telefonKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Telefonkosten ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			//Gehe zur naechsten Activity, wenn FLAGs true ist
			if((entfWAKomma == true)&&(aTageGanz == true)&&(spendenKomma == true)&&(aMittelKomma == true)&&(telefonKomma == true)){
				startActivity(new Intent(getApplicationContext(), VorsorgeEV.class));
			}else{
				View popUpView = getLayoutInflater().inflate(R.layout.activity_base_fehlermeldung, null);
			    mpopup = new PopupWindow(popUpView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
		        mpopup.setAnimationStyle(android.R.style.Animation_Dialog);  
		        mpopup.showAtLocation(popUpView, Gravity.BOTTOM, 0, 0);
			}
		}
		});		
	}
	//Close FehlermeldungsPopUp
		 public void CloseFehlerPopUp(View view){
	     	mpopup.dismiss();
	     }	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_ev_werbungskosten, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		case R.id.googleMaps:
//			open browser
			Uri uriBGM = Uri.parse("https://maps.google.de/maps?hl=de&tab=wl");
			Intent intentBGM = new Intent(Intent.ACTION_VIEW, uriBGM);
			startActivity(intentBGM);			
			return true;
		case R.id.wkAbc:
//			open browser
			Uri uriBWA = Uri.parse("http://www.steuernsparen.de/steuerwiki/index.php/Werbungskosten");
			Intent intentBWA = new Intent(Intent.ACTION_VIEW, uriBWA);
			startActivity(intentBWA);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
