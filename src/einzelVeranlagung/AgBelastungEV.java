package einzelVeranlagung;

import com.flashback.calcestv2.Auswertung;
import com.flashback.calcestv2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AgBelastungEV extends Activity {
	
	public EditText etKrankheitsKostenGezahlt, etHaushaltsHilfeMitMinijob, etHaushaltsHilfeOhneMinijob, etHandwerkerleistung;
	Button btnGoToA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_agbelastung);
		
		etKrankheitsKostenGezahlt = (EditText)findViewById(R.id.etKrankheitskostenGezahlt);
		etHaushaltsHilfeMitMinijob = (EditText)findViewById(R.id.etHnDlMitAn);
		etHaushaltsHilfeOhneMinijob = (EditText)findViewById(R.id.etHnDlOhneAn);
		etHandwerkerleistung =(EditText)findViewById(R.id.etHnDlHandwerker);		
		
		btnGoToA = (Button)findViewById(R.id.btnGoToAuswertung);
		btnGoToA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			startActivity(new Intent(getApplicationContext(), Auswertung.class));	
			
			Intent evAGB = new Intent(getApplicationContext(), Auswertung.class);
			evAGB.putExtra("KrankheitskostenGezahlt", etKrankheitsKostenGezahlt.getText().toString());
			evAGB.putExtra("HnDlMitAn", etHaushaltsHilfeMitMinijob.getText().toString());
			evAGB.putExtra("HnDlOhneAn", etHaushaltsHilfeOhneMinijob.getText().toString());
			evAGB.putExtra("HnDlHandwerker", etHandwerkerleistung.getText().toString());
			}
		});
		
	}

}
