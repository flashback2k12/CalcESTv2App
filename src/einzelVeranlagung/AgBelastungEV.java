package einzelVeranlagung;

import userdaten.UserdatenEV;

import com.flashback.calcestv2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import auswertungen.AuswertungEV;

public class AgBelastungEV extends Activity {
	
	public EditText etKrankheitsKostenGezahlt, etHaushaltsHilfeMitMinijob, etHaushaltsHilfeOhneMinijob, etHandwerkerleistung;
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
				
			startActivity(new Intent(getApplicationContext(), AuswertungEV.class));	
			
			UserdatenEV user = (UserdatenEV)getApplication();
			user.setKrankheitsKostenGezahlt(etKrankheitsKostenGezahlt.getText().toString());
			user.setHaushaltshilfeMitMinijob(etHaushaltsHilfeMitMinijob.getText().toString());
			user.setHaushaltshilfeOhneMinijob(etHaushaltsHilfeOhneMinijob.getText().toString());
			user.setHandwerkerLeistung(etHandwerkerleistung.getText().toString());
			}
		});
		
	}

}
