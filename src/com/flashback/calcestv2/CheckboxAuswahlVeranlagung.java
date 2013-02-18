package com.flashback.calcestv2;

import zusammenVeranlagung.StartBildschirmZV;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import einzelVeranlagung.StartBildschirmEV;

@SuppressLint("NewApi")
public class CheckboxAuswahlVeranlagung extends Activity {

	Button btnEV, btnZV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_veranlagung_chb);
		setTitle(R.string.title00);
		
		btnEV = (Button)findViewById(R.id.btnEV);
		btnEV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), StartBildschirmEV.class));
			}
		});
		
		btnZV = (Button)findViewById(R.id.btnZV);
		btnZV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), StartBildschirmZV.class));
			}
		});
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
