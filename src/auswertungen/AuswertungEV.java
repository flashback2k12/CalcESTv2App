package auswertungen;

import userdaten.UserdatenEV;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import berechnungEV.BerechneEV;

import com.flashback.calcestv2.R;

public class AuswertungEV extends Activity {

	public TextView tvLine01, tvLine02, tvLine03, tvLine04, tvLine05, tvLine06,
			tvLine07, tvLine08, tvLine09, tvLine10, tvLine11, tvLine12,
			tvLine13, tvLine14;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ev_auswertung);
		setTitle(R.string.title06);

		tvLine01 =(TextView)findViewById(R.id.etLine1);
		tvLine02 =(TextView)findViewById(R.id.etLine2);
		tvLine03 =(TextView)findViewById(R.id.etLine3);
		tvLine04 =(TextView)findViewById(R.id.etLine4);
		tvLine05 =(TextView)findViewById(R.id.etLine5);
		tvLine06 =(TextView)findViewById(R.id.etLine6);
		tvLine07 =(TextView)findViewById(R.id.etLine7);
		tvLine08 =(TextView)findViewById(R.id.etLine8);
		tvLine09 =(TextView)findViewById(R.id.etLine9);
		tvLine10 =(TextView)findViewById(R.id.etLine10);
		tvLine11 =(TextView)findViewById(R.id.etLine11);
		tvLine12 =(TextView)findViewById(R.id.etLine12);
		tvLine13 =(TextView)findViewById(R.id.etLine13);
		tvLine14 =(TextView)findViewById(R.id.etLine14);	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_ev_auswertung, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.feedback:
			Intent Email = new Intent(Intent.ACTION_SEND);
			Email.setType("text/email");
			Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "feedbackcalcest@gmail.com" });
			Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
			Email.putExtra(Intent.EXTRA_TEXT, "Vielen Dank für das testen meiner ersten App! Bitte sende mir deine Meinung! Angaben: Telefon/Android-OS/Pro/Kon/Anregungen! Danke! :-)");
			startActivity(Intent.createChooser(Email, "Send Feedback:"));
			return true;
		case R.id.credits:
			setContentView(R.layout.activity_base_credits);
			TextView tv1 = (TextView)findViewById(R.id.textView2);
			tv1.setText(Html.fromHtml("<a href=https://github.com/flashback2k12/CalcESTv1App> GITHUB "));
			tv1.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv2 = (TextView)findViewById(R.id.textView3);
			tv2.setText(Html.fromHtml("<a href=http://stackoverflow.com/questions/4930228/open-a-url-on-click-of-ok-button-in-android> open url with button click "));
			tv2.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv3 = (TextView)findViewById(R.id.textView4);
			tv3.setText(Html.fromHtml("<a href=http://stackoverflow.com/questions/9852184/android-textview-hyperlinkp> textview hyperlink "));
			tv3.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv4 = (TextView)findViewById(R.id.textView5);
			tv4.setText(Html.fromHtml("<a href=http://stackoverflow.com/questions/11320685/how-to-implement-send-feedback-feature-in-android> send feedback "));
			tv4.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv5 = (TextView)findViewById(R.id.textView6);
			tv5.setText(Html.fromHtml("<a href=http://www.java-samples.com/showtutorial.php?tutorialid=1523> make folder / file "));
			tv5.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv6 = (TextView)findViewById(R.id.textView7);
			tv6.setText(Html.fromHtml("<a href=http://www.vogella.com/blog/2011/07/19/android-shapes/> background.xml "));
			tv6.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv7 = (TextView)findViewById(R.id.textView8);
			tv7.setText(Html.fromHtml("<a href=http://www.androidaspect.com/2012/12/android-splash-screen-tutorial.html> splashScreen "));
			tv7.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv8 = (TextView)findViewById(R.id.textView9);
			tv8.setText(Html.fromHtml("<a href=http://androidgps.blogspot.de/2008/09/writing-to-sd-card-in-android.html> Filewriter "));
			tv8.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv9 = (TextView)findViewById(R.id.textView10);
			tv9.setText(Html.fromHtml("<a href=http://stackoverflow.com/questions/3993924/get-android-api-level-of-phone-currently-running-my-application> Check OS VersionsCode "));
			tv9.setMovementMethod(LinkMovementMethod.getInstance());
			TextView tv10 = (TextView)findViewById(R.id.textView11);
			tv10.setText(Html.fromHtml("<a href=http://stackoverflow.com/questions/3093365/how-can-i-check-the-system-version-of-android> Check OS VersionsCode "));
			tv10.setMovementMethod(LinkMovementMethod.getInstance());
			return true;
		}
		return false;
	}
	
	public void btnAuswertung (View view){
/*
 * Variablen aus Userdaten deklarieren, Umwandlung von Strings in numaerische Werte
 */
		UserdatenEV user = (UserdatenEV)getApplication();
		int mSteuerJahr = Integer.parseInt(user.getSteuerJahr());
		double mBruttoGehaltMonat = Double.parseDouble(user.getBruttoGehaltMonat());
		double mLohnSteuerMonat = Double.parseDouble(user.getLohnSteuerMonat());
		double mSolzMonat = Double.parseDouble(user.getSolzMonat());
		double mKvMonat = Double.parseDouble(user.getKvMonat());
		double mPvMonat = Double.parseDouble(user.getPvMonat());
		double mRvMonat = Double.parseDouble(user.getRvMonat());
		double mAvMonat = Double.parseDouble(user.getAvMonat());
		int mArbeitsMonate = Integer.parseInt(user.getArbeitsMonate());
		double mEntfernungWA = Double.parseDouble(user.getEntfernungWA());
		int mArbeitsTage = Integer.parseInt(user.getArbeitsTage());
		double mSpendenGezahlt = Double.parseDouble(user.getSpendenGezahlt());
		double mArbeitsmittelGezahlt = Double.parseDouble(user.getArbeitsmittelGezahlt());
		double mTelefonkostenGezahlt = Double.parseDouble(user.getTelefonkostenGezahlt());
		double mHapfpflV = Double.parseDouble(user.getHapfpfV());
		double mUnfallV = Double.parseDouble(user.getUnfallV());
		double mBuV = Double.parseDouble(user.getBuV());
		double mRuerupV = Double.parseDouble(user.getRuerupV());
//		double mRiesterV = Double.parseDouble(user.getRieserV()); --> Funktionalitaet noch nicht eingebaut
		double mLvMitKap = Double.parseDouble(user.getLvMitKap());
		double mLvOhneKap = Double.parseDouble(user.getLvOhneKap());
		double mKrankheitsKostenGezahlt = Double.parseDouble(user.getKrankheitsKostenGezahlt());
		double mHhMitMinijob = Double.parseDouble(user.getHaushaltshilfeMitMinijob());
		double mHhOhneMinijob = Double.parseDouble(user.getHaushaltshilfeOhneMinijob());
		double mHandwerkerL = Double.parseDouble(user.getHandwerkerLeistung());
/*
 * Ausgabevariablen deklarieren
 */
		double mJahresBruttoGehalt = 0.0;
		double mJahresLohnSteuer = 0.0;
		double mJahresSolZ = 0.0;
		double mJahresKv = 0.0;
		double mJahresPv = 0.0;
		double mJahresRv = 0.0;
		double mJahresAv = 0.0;
		double mWerbungsKosten = 0.0;
		double mSummeEinkunft = 0.0;
		double mGesamtbetragEinkunft = 0.0;
		double mSpendenAbzug = 0.0;
		double mAgBelastungAbzug = 0.0;
		double mVorsorgeAufwand = 0.0;
		double mZuVerstEinkommen = 0.0;
		double mEinkommenSteuer = 0.0;
		double mSoliZuschlag = 0.0;
		double mKapitalSteuer = 0.0;
		double mHnDlAbzug = 0.0;
		double mErgebnisBerechnung = 0.0;
/*
 * Berechnung der JahresWerte
 */
		mJahresBruttoGehalt = BerechneEV.JahresWerte(mArbeitsMonate, mBruttoGehaltMonat);
		mJahresLohnSteuer = BerechneEV.JahresWerte(mArbeitsMonate, mLohnSteuerMonat);
		mJahresSolZ = BerechneEV.JahresWerte(mArbeitsMonate, mSolzMonat);
		mJahresKv = BerechneEV.JahresWerte(mArbeitsMonate, mKvMonat);
		mJahresPv = BerechneEV.JahresWerte(mArbeitsMonate, mPvMonat);
		mJahresRv = BerechneEV.JahresWerte(mArbeitsMonate, mRvMonat);
		mJahresAv = BerechneEV.JahresWerte(mArbeitsMonate, mAvMonat);
/*
 * Berechnung Werbungskosten
 */
		mWerbungsKosten = BerechneEV.WerbungsKosten(mSteuerJahr, mArbeitsTage, mEntfernungWA, mArbeitsmittelGezahlt, mTelefonkostenGezahlt);
/*
 * Berechnung Summe der Einkuenfte		
 */
		mSummeEinkunft = BerechneEV.SummeEinkunft(mJahresBruttoGehalt, mWerbungsKosten);
/*
 * Berechnung Gesamtbetrag der Einkuenfte
 */
		mGesamtbetragEinkunft = BerechneEV.GesamtbetragEinkunft(mSummeEinkunft);
/*
 * Berechnung Spendenabzug
 */
		mSpendenAbzug = BerechneEV.SpendenAbzug(mGesamtbetragEinkunft, mSpendenGezahlt);
/*
 * Berechnung Abzug der aussergewoehnlichen Belastung
 */
		mAgBelastungAbzug = BerechneEV.agBelastungAbzug(mGesamtbetragEinkunft, mKrankheitsKostenGezahlt);
/*
 * Berechnung des Vorsorgeaufwands
 */
		mVorsorgeAufwand = BerechneEV.vorsorgeAufwand(mSteuerJahr, mJahresRv, mJahresKv, mJahresPv, mJahresAv, mHapfpflV, mUnfallV, mBuV, mRuerupV, mLvMitKap, mLvOhneKap);
/*
 * Berechnung zu versteuerndes Einkommen
 */
		mZuVerstEinkommen = BerechneEV.zuVerstEinkommen(mGesamtbetragEinkunft, mVorsorgeAufwand, mSpendenAbzug, mAgBelastungAbzug);
/*
 * Berechnung der Einkommensteuer
 */
		mEinkommenSteuer = BerechneEV.einkommenSteuer(mZuVerstEinkommen);
/*
 * Berechnung des Soli-Zuschlags
 */
		mSoliZuschlag = BerechneEV.soliZuschlag(mZuVerstEinkommen, mKapitalSteuer, mEinkommenSteuer);
/*
 * Berechnung Steuerabzug gemaess Paragraph 35a EStG
 */
		mHnDlAbzug = BerechneEV.hnDlAbzug(mHhMitMinijob, mHhOhneMinijob, mHandwerkerL);
/*
 * Berechnung des Ergebnis
 */
		mErgebnisBerechnung = BerechneEV.ergebnisSteuer(mEinkommenSteuer, mSoliZuschlag, mJahresLohnSteuer, mJahresSolZ, mHnDlAbzug);
/*
 * Ausgabe der Berechnungsergebnisse in TextViews	
 */
		tvLine01.setText("Einnahmen: " + mJahresBruttoGehalt);
		tvLine02.setText("Werbungskosten: " + mWerbungsKosten);
		tvLine03.setText("Summe Einkunft: " + mSummeEinkunft);
		tvLine04.setText("Gesamtbetrag Einkunft: " + mGesamtbetragEinkunft);
		tvLine05.setText("Spendenabzug: " + mSpendenAbzug);
		tvLine06.setText("Aussergewoehnliche Belastung: " + mAgBelastungAbzug);
		tvLine07.setText("Vorsorgeaufwand: " + mVorsorgeAufwand);
		tvLine08.setText("zu versteuerndes Einkommen: " + mZuVerstEinkommen);
		tvLine09.setText("Einkommensteuer: " + mEinkommenSteuer);
		tvLine10.setText("vorausbezahlte Steuer: " + mJahresLohnSteuer);
		tvLine11.setText("SoliZuschlag: " + mSoliZuschlag);
		tvLine12.setText("vorausbezahlter Soli: " + mJahresSolZ);
		tvLine13.setText("Abzug gemaess Para.35a EStG: " + mHnDlAbzug);
		tvLine14.setText("Ergebnis: " + mErgebnisBerechnung);
	}
	
	public void btnCreateFile (View view){
/*
 * Variablen fuer Auswertungsdatei deklarieren
 */
		String ml01 = tvLine01.getText().toString();
		String ml02 = tvLine02.getText().toString();
		String ml03 = tvLine03.getText().toString();
		String ml04 = tvLine04.getText().toString();
		String ml05 = tvLine05.getText().toString();
		String ml06 = tvLine06.getText().toString();
		String ml07 = tvLine07.getText().toString();
		String ml08 = tvLine08.getText().toString();
		String ml09 = tvLine09.getText().toString();
		String ml010 = tvLine10.getText().toString();
		String ml011 = tvLine11.getText().toString();
		String ml012 = tvLine12.getText().toString();
		String ml013 = tvLine13.getText().toString();
		String ml014 = tvLine14.getText().toString();
/*
 * Auswertungsdatei erstellen
 */
		AuswertungsdateiEV.erstelle(ml01, ml02, ml03, ml04, ml05, ml06, ml07, ml08, ml09, ml010, ml011, ml012, ml013, ml014);
/*
 * Zeigen eines Toasts wenn Erstellung beendet wurde
 */
		Toast.makeText(getApplicationContext(), "Textfile wurde erstellt", Toast.LENGTH_LONG).show();

	}
	
	
}

		