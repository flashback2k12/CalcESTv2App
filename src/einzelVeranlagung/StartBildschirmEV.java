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

public class StartBildschirmEV extends Activity {

	public EditText etSteuerJahr;
	Button btnGoToGS;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_start);
		setTitle(R.string.title01);
		
		etSteuerJahr = (EditText)findViewById(R.id.etSteuerJahr);		
		
		btnGoToGS = (Button)findViewById(R.id.btnGoToGehaltsschein);
		btnGoToGS.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			Intent i = new Intent(getApplicationContext(), GehaltsscheinEV.class);
			startActivity(i);	
			
			UserdatenEV user =(UserdatenEV)getApplication();
			user.setSteuerJahr(etSteuerJahr.getText().toString());
			}
		});
	
	}
}
