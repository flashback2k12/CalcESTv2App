package einzelVeranlagung;


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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_start);
		
		etSteuerJahr = (EditText)findViewById(R.id.etSteuerJahr);		
		
		btnGoToGS = (Button)findViewById(R.id.btnGoToGehaltsschein);
		btnGoToGS.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			startActivity(new Intent(getApplicationContext(), GehaltsscheinEV.class));	
			
			Intent evSteuerJahr = new Intent(getApplicationContext(), GehaltsscheinEV.class);
			evSteuerJahr.putExtra("SteuerJahr", etSteuerJahr.getText().toString());
			startActivity(evSteuerJahr);
			}
		});
	
	}
}
