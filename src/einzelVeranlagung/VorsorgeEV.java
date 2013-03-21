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

public class VorsorgeEV extends Activity {
	
	public EditText etHaftpflV, etUnfallV, etBuV, etRuerupV, etRiesterV, etLebensVmitKap, etLebensVohneKap;
	public boolean hvKomma = false;
 	public boolean uvKomma = false;
 	public boolean buKomma = false;
 	public boolean rupKomma = false;
 	public boolean rieKomma = false;
 	public boolean lvMKomma = false;
 	public boolean lvOKomma = false;
	public PopupWindow mpopup;
	Button btnGoToAB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_vorsorge);
		setTitle(R.string.title04);
		
		etHaftpflV = (EditText)findViewById(R.id.etHaftpflicht);
		etUnfallV = (EditText)findViewById(R.id.etUnfall);
		etBuV = (EditText)findViewById(R.id.etBU);
		etRuerupV = (EditText)findViewById(R.id.etRuerup);
		etRiesterV = (EditText)findViewById(R.id.etRiester);
		etLebensVmitKap = (EditText)findViewById(R.id.etLvMitKap);
		etLebensVohneKap = (EditText)findViewById(R.id.etLvOhneKap);
		
		btnGoToAB = (Button)findViewById(R.id.btnGoToAGB);
		btnGoToAB.setOnClickListener(new OnClickListener() {
			
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
				double HaftV = Double.parseDouble(etHaftpflV.getText().toString());
				user.setHapfpfV(String.valueOf(HaftV));
				hvKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Haftpflichtversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double UnfallV = Double.parseDouble(etUnfallV.getText().toString());
				user.setUnfallV(String.valueOf(UnfallV));
				uvKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Unfallversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double BuV = Double.parseDouble(etBuV.getText().toString());
				user.setBuV(String.valueOf(BuV));
				buKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Berufunf\u00E4higkeitsversicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double RuV = Double.parseDouble(etRuerupV.getText().toString());
				user.setRuerupV(String.valueOf(RuV));
				rupKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "R\u00FCrup-Versicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double RiV = Double.parseDouble(etRiesterV.getText().toString());
				user.setRieserV(String.valueOf(RiV));
				rieKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Riester-Versicherung ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			try {
				double LvMk = Double.parseDouble(etLebensVmitKap.getText().toString());
				user.setLvMitKap(String.valueOf(LvMk));
				lvMKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Lebensversicherung mit Kapitalwahlrecht ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}			
			try {
				double LvOk = Double.parseDouble(etLebensVohneKap.getText().toString());
				user.setLvOhneKap(String.valueOf(LvOk));
				lvOKomma = true;
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Lebensversicherung ohne Kapitalwahlrecht ist keine Kommazahl", Toast.LENGTH_SHORT).show();
			}
			//Gehe zur naechsten Activity, wenn FLAGs true ist
			if((hvKomma == true)&&(uvKomma == true)&&(buKomma == true)&&(rupKomma == true)&&(rieKomma == true)&&(lvMKomma == true)&&(lvOKomma == true)){
				startActivity(new Intent(getApplicationContext(), AgBelastungEV.class));
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