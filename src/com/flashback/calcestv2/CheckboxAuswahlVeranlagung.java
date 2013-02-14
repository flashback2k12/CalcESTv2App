package com.flashback.calcestv2;

import zusammenVeranlagung.StartBildschirmZV;
import einzelVeranlagung.StartBildschirmEV;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CheckboxAuswahlVeranlagung extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_veranlagung_chb);
		setTitle(R.string.title00);
	}
	
	public void onCheckboxClicked(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.chbEinzelveranlagung:
	        	if (checked)
					startActivity(new Intent(getApplicationContext(), StartBildschirmEV.class));
	        	else 
					Toast.makeText(getApplicationContext(), "Not checked Box 01", Toast.LENGTH_SHORT).show();
				break;
			case R.id.chbZusammenveranlagung:
				if (checked)
					startActivity(new Intent(getApplicationContext(), StartBildschirmZV.class));
				else
					Toast.makeText(getApplicationContext(), "Not checked Box 02", Toast.LENGTH_SHORT).show();
				break;
	    }
	}
}
