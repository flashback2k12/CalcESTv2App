package einzelVeranlagung;

import com.flashback.calcestv2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class VorsorgeEV extends Activity {
	
	public EditText etHaftpflV, etUnfallV, etBuV, etRuerupV, etRiesterV, etLebensVmitKap, etLebensVohneKap;
	Button btnGoToAB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_vorsorge);
		
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
				
			startActivity(new Intent(getApplicationContext(), AgBelastungEV.class));
			
			Intent evVorsorge = new Intent(getApplicationContext(), AgBelastungEV.class);
			evVorsorge.putExtra("Haftpflict", etHaftpflV.getText().toString());
			evVorsorge.putExtra("UnfallV", etUnfallV.getText().toString());
			evVorsorge.putExtra("BuV", etBuV.getText().toString());
			evVorsorge.putExtra("RuerupV", etRuerupV.getText().toString());
			evVorsorge.putExtra("RiesterV", etRiesterV.getText().toString());
			evVorsorge.putExtra("LvMitKap", etLebensVmitKap.getText().toString());
			evVorsorge.putExtra("LvOhneKap", etLebensVohneKap.getText().toString());
			}
		});
	}

}
