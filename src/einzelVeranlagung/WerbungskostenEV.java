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
				
			startActivity(new Intent(getApplicationContext(), VorsorgeEV.class));	
			
			UserdatenEV user = (UserdatenEV)getApplication();
			user.setEntfernungWA(etEntfernungWA.getText().toString());
			user.setArbeitsTage(etArbeitsTage.getText().toString());
			user.setSpendenGezahlt(etSpendenGezahlt.getText().toString());
			user.setArbeitsmittelGezahlt(etArbeitsMittelGezahlt.getText().toString());
			user.setTelefonkostenGezahlt(etTelefonKostenGezahlt.getText().toString());
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
