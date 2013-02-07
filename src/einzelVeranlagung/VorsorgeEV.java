package einzelVeranlagung;

import com.flashback.calcestv2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class VorsorgeEV extends Activity {
	
	Button btnGoToAB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_vorsorge);
		
		btnGoToAB = (Button)findViewById(R.id.btnGoToAGB);
		btnGoToAB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			startActivity(new Intent(getApplicationContext(), AgBelastungEV.class));	
				
			}
		});
	}

}
