package einzelVeranlagung;


import userdaten.UserdatenEV;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.flashback.calcestv2.R;

public class StartBildschirmEV extends Activity {

	public EditText etSteuerJahr;
	Button btnGoToGS;
	boolean steuerJahrGanzZ = false;
	public PopupWindow mpopup;
	
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
				
			UserdatenEV user =(UserdatenEV)getApplication();
			
			try {
			//Kontrolle ob Steuerjahr ein Integer-Wert ist
				int SteuerJahr = Integer.parseInt(etSteuerJahr.getText().toString());
			//Pruefung Steuerjahr zwischen 2010 und 2016 --> Geltungsbereich
				if((SteuerJahr >= 2010)&&(SteuerJahr <= 2016)){
					user.setSteuerJahr(String.valueOf(SteuerJahr));
					steuerJahrGanzZ = true;
				}else{
					Toast.makeText(getApplicationContext(), "Steuerjahr ist au\u00dferhalb des Geltungsbereichs!", Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				View popUpView = getLayoutInflater().inflate(R.layout.activity_base_fehlermeldung, null);
			    mpopup = new PopupWindow(popUpView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
		        mpopup.setAnimationStyle(android.R.style.Animation_Dialog);  
		        mpopup.showAtLocation(popUpView, Gravity.BOTTOM, 0, 0);
		    }
			
			//Gehe zur naechsten Activity, wenn Steuerjahr FLAG true ist
			if(steuerJahrGanzZ == true){
				startActivity(new Intent(getApplicationContext(), GehaltsscheinEV.class));	
			}
		}
	});
   }
	//Close FehlermeldungsPopUp
	 public void CloseFehlerPopUp(View view){
     	mpopup.dismiss();
     }	
}
