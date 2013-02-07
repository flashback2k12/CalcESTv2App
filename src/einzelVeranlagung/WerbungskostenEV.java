package einzelVeranlagung;

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

import com.flashback.calcestv2.R;

public class WerbungskostenEV extends Activity {
	
	Button btnGoToV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_werbungskosten);
		
		btnGoToV = (Button)findViewById(R.id.btnGoToVorsorge);
		btnGoToV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			startActivity(new Intent(getApplicationContext(), VorsorgeEV.class));	
				
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
