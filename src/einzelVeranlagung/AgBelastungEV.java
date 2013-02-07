package einzelVeranlagung;

import com.flashback.calcestv2.Auswertung;
import com.flashback.calcestv2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AgBelastungEV extends Activity {
	
	Button btnGoToA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_agbelastung);
		
		btnGoToA = (Button)findViewById(R.id.btnGoToAuswertung);
		btnGoToA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			startActivity(new Intent(getApplicationContext(), Auswertung.class));	
				
			}
		});
		
	}

}
