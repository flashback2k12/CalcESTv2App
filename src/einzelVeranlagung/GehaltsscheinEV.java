package einzelVeranlagung;

import userdaten.UserdatenEV;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.flashback.calcestv2.R;

public class GehaltsscheinEV extends Activity {
	
 	public EditText etBruttoGehalt, etLohnSteuer, etSolZ, etKv, etPv, etRv, etAv, etArbeitsMonate;
 	public boolean bruttoKomma = false;
 	public boolean lohnsteuerKomma = false;
 	public boolean solzKomma = false;
 	public boolean kvKomma = false;
 	public boolean pvKomma = false;
 	public boolean rvKomma = false;
 	public boolean avKomma = false;
 	public boolean aMonateGanz = false;
	public PopupWindow mpopup;
 	Button btnGoToWK;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_gehaltsschein);
		setTitle(R.string.title02);
		
		etBruttoGehalt = (EditText)findViewById(R.id.etBruttoGehalt);
		etLohnSteuer = (EditText)findViewById(R.id.etLohnSteuer);
		etSolZ = (EditText)findViewById(R.id.etSolZ);
		etKv = (EditText)findViewById(R.id.etKV);
		etPv = (EditText)findViewById(R.id.etPV);
		etRv = (EditText)findViewById(R.id.etRV);
		etAv = (EditText)findViewById(R.id.etAV);
		etArbeitsMonate = (EditText)findViewById(R.id.etArbeitsMonate);		
		
		btnGoToWK = (Button)findViewById(R.id.btnGoToWerbungsKosten);
		btnGoToWK.setOnClickListener(new OnClickListener() {
			
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
				double BruttoGehalt = Double.parseDouble(etBruttoGehalt.getText().toString());
				user.setBruttoGehaltMonat(String.valueOf(BruttoGehalt));
				bruttoKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Bruttogehalt ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double LohnSteuer = Double.parseDouble(etLohnSteuer.getText().toString());
				user.setLohnSteuerMonat(String.valueOf(LohnSteuer));
				lohnsteuerKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Lohnsteuer ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double SolZ = Double.parseDouble(etSolZ.getText().toString());
				user.setSolzMonat(String.valueOf(SolZ));
				solzKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "SoliZuschlag ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double KvMonat = Double.parseDouble(etKv.getText().toString());
				user.setKvMonat(String.valueOf(KvMonat));
				kvKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Krankenversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double PvMonat = Double.parseDouble(etPv.getText().toString());
				user.setPvMonat(String.valueOf(PvMonat));
				pvKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Pflegeversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double RvMonat = Double.parseDouble(etRv.getText().toString());
				user.setRvMonat(String.valueOf(RvMonat));
				rvKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Rentenversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}			
			try {
				double AvMonat = Double.parseDouble(etAv.getText().toString());
				user.setAvMonat(String.valueOf(AvMonat));
				avKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Arbeitslosenversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				int ArbeitsM = Integer.parseInt(etArbeitsMonate.getText().toString());
				user.setArbeitsMonate(String.valueOf(ArbeitsM));
				aMonateGanz = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Arbeitsmonate ist keine Ganzzahl", Toast.LENGTH_SHORT).show();
			}
			
			//Gehe zur naechsten Activity, wenn FLAGs true ist
			if((bruttoKomma == true)&&(lohnsteuerKomma == true)&&(solzKomma == true)&&(kvKomma == true)&&(pvKomma == true)&&(rvKomma == true)&&(avKomma == true)&&(aMonateGanz == true)){
				startActivity(new Intent(getApplicationContext(), WerbungskostenEV.class));
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
}
