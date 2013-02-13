package einzelVeranlagung;

import userdaten.UserdatenEV;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.flashback.calcestv2.R;

public class GehaltsscheinEV extends Activity {
	
 	public EditText etBruttoGehalt, etLohnSteuer, etSolZ, etKv, etPv, etRv, etAv, etArbeitsMonate;
	Button btnGoToWK;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_gehaltsschein);
		
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
				
			startActivity(new Intent(getApplicationContext(), WerbungskostenEV.class));	
				
			UserdatenEV user = (UserdatenEV)getApplication();
			user.setBruttoGehaltMonat(etBruttoGehalt.getText().toString());
			user.setLohnSteuerMonat(etLohnSteuer.getText().toString());
			user.setSolzMonat(etSolZ.getText().toString());
			user.setKvMonat(etKv.getText().toString());
			user.setPvMonat(etPv.getText().toString());
			user.setRvMonat(etRv.getText().toString());
			user.setAvMonat(etAv.getText().toString());
			user.setArbeitsMonate(etArbeitsMonate.getText().toString());
			}
		});
		
		
	}

}
