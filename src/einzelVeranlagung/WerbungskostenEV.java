package einzelVeranlagung;

import userdaten.UserdatenEV;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.flashback.calcestv2.R;

public class WerbungskostenEV extends Activity {
	
	public EditText etEntfernungWA, etArbeitsTage, etSpendenGezahlt, etArbeitsMittelGezahlt, etTelefonKostenGezahlt;
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
 * wenn nicht wird eine Fehlermeldung angezeigt
 * beim letzten try-catch-Block wieder gleichzeitig die naechste Activity gestartet, wenn das korrekte Zahlenformat eingegeben wurde.
 */			
			try {
				double EntfernungWA = Double.parseDouble(etEntfernungWA.getText().toString());
				user.setEntfernungWA(String.valueOf(EntfernungWA));
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Entfernung Wohnung Arbeit ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				int ArbeitsT = Integer.parseInt(etArbeitsTage.getText().toString());
				user.setArbeitsTage(String.valueOf(ArbeitsT));
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Arbeitstage ist keine Ganzzahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double SpendenG = Double.parseDouble(etSpendenGezahlt.getText().toString());
				user.setSpendenGezahlt(String.valueOf(SpendenG));
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Spenden ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double ArbeitsmittelG = Double.parseDouble(etArbeitsMittelGezahlt.getText().toString());
				user.setArbeitsmittelGezahlt(String.valueOf(ArbeitsmittelG));
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Arbeitsmittel ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double TelefonkostenG = Double.parseDouble(etTelefonKostenGezahlt.getText().toString());
				user.setTelefonkostenGezahlt(String.valueOf(TelefonkostenG));
				startActivity(new Intent(getApplicationContext(), VorsorgeEV.class));
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Telefonkosten ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
		}
		});
		
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
