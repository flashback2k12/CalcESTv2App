package einzelVeranlagung;

import userdaten.UserdatenEV;

import com.flashback.calcestv2.R;

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
import auswertungen.AuswertungEV;

public class AgBelastungEV extends Activity {
	
	public EditText etKrankheitsKostenGezahlt, etHaushaltsHilfeMitMinijob, etHaushaltsHilfeOhneMinijob, etHandwerkerleistung;
	public boolean kkKomma = false;
 	public boolean hhMKomma = false;
 	public boolean hhOKomma = false;
 	public boolean hwKomma = false;
	public PopupWindow mpopup;
	Button btnGoToA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_agbelastung);
		setTitle(R.string.title05);
		
		etKrankheitsKostenGezahlt = (EditText)findViewById(R.id.etKrankheitskostenGezahlt);
		etHaushaltsHilfeMitMinijob = (EditText)findViewById(R.id.etHnDlMitAn);
		etHaushaltsHilfeOhneMinijob = (EditText)findViewById(R.id.etHnDlOhneAn);
		etHandwerkerleistung =(EditText)findViewById(R.id.etHnDlHandwerker);		
		
		btnGoToA = (Button)findViewById(R.id.btnGoToAuswertung);
		btnGoToA.setOnClickListener(new OnClickListener() {
			
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
				double KrankhkG = Double.parseDouble(etKrankheitsKostenGezahlt.getText().toString());
				user.setKrankheitsKostenGezahlt(String.valueOf(KrankhkG));
				kkKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "gezahlte Krankheitskosten ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double HhMj = Double.parseDouble(etHaushaltsHilfeMitMinijob.getText().toString());
				user.setHaushaltshilfeMitMinijob(String.valueOf(HhMj));
				hhMKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Kosten der Haushaltshilfe mit Minijob ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double HhOj = Double.parseDouble(etHaushaltsHilfeOhneMinijob.getText().toString());
				user.setHaushaltshilfeOhneMinijob(String.valueOf(HhOj));
				hhOKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Kosten der Haushaltshilfe ohne Minijob ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double HwL = Double.parseDouble(etHandwerkerleistung.getText().toString());
				user.setHandwerkerLeistung(String.valueOf(HwL));
				hwKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Kosten Handwerkerleistungen ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			//Gehe zur naechsten Activity, wenn FLAGs true ist
			if((kkKomma == true)&&(hhMKomma == true)&&(hhOKomma == true)&&(hwKomma == true)){
				startActivity(new Intent(getApplicationContext(), AuswertungEV.class));	
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
