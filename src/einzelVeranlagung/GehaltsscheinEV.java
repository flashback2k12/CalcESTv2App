package einzelVeranlagung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.flashback.calcestv2.R;

public class GehaltsscheinEV extends Activity {
	
	Button btnGoToWK;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_gehaltsschein);
		
		btnGoToWK = (Button)findViewById(R.id.btnGoToWerbungsKosten);
		btnGoToWK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			startActivity(new Intent(getApplicationContext(), WerbungskostenEV.class));	
				
			}
		});
		
		
	}

}
