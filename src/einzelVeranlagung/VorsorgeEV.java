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

public class VorsorgeEV extends Activity {
	
	public EditText etHaftpflV, etUnfallV, etBuV, etRuerupV, etRiesterV, etLebensVmitKap, etLebensVohneKap;
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
				
			startActivity(new Intent(getApplicationContext(), AgBelastungEV.class));
			
			UserdatenEV user = (UserdatenEV)getApplication();
			user.setHapfpfV(etHaftpflV.getText().toString());
			user.setUnfallV(etUnfallV.getText().toString());
			user.setBuV(etBuV.getText().toString());
			user.setRuerupV(etRuerupV.getText().toString());
			user.setRieserV(etRiesterV.getText().toString());
			user.setLvMitKap(etLebensVmitKap.getText().toString());
			user.setLvOhneKap(etLebensVohneKap.getText().toString());
			}
		});
	}

}
