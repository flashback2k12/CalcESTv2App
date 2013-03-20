package berechnungEV;

public class BerechneEV {

/*
 * BEGIN
 * Berechnung Jahreswerte
 */
	public static double JahresWerte(int arbeitsMonate, double monatsWert){
		double jahresWert = monatsWert * arbeitsMonate;
//		return Math.round(jahresWert * 100.00) / 100.00;
		return Math.ceil(jahresWert);
	}
/*
 * END
 */
	
/*
 * BEGIN
 * Berechnung der Werbungskosten
 */
	public static double WerbungsKosten(int steuerJahr, int arbeitsTage, double entfernungWA,
			double arbeitsMittelGezahlt, double telefonKostenGezahlt) {
/*
* init konstanten + notwendige variablen
*/
		final double ENTFERNUNGSPAUSCHALE = 0.3;
		final double KONTOFUEHRUNG = 16.0;
		final double WKPB2012 = 1000.00;
		final double WKPB2013 = 1130.00;
		final double ARBEITSMITTELPB = 110.0;
		final double TELEFONPB = 240.0;
		final int MAXARBEITSTAGE = 220;
		double WerbungsKostenAbzug = 0.0;
		double ArbeitsMittelAbzug = 0.0;
		double TelefonKostenAbzug = 0.0;
		double WerbungsKostenGezahlt = 0.0;
		int ArbeitsTageAbzug = 0;
/*
* Kontrollstruktur zum Arbeitsmittelabzug --> pauschal oder tatsaechliche ausgaben guenstiger fuer AN
*/
		if (arbeitsMittelGezahlt <= ARBEITSMITTELPB) 
		{
			ArbeitsMittelAbzug = ARBEITSMITTELPB;
		} 
		else {
			ArbeitsMittelAbzug = Math.round(arbeitsMittelGezahlt * 100.00) / 100.00;
		}
/*
* Kontrollstruktur zum Telefonkostenabzug --> pauschal oder tatsaechliche ausgaben guenstiger fuer AN
*/
		if (telefonKostenGezahlt <= TELEFONPB) {
			TelefonKostenAbzug = TELEFONPB;
		} else {
			TelefonKostenAbzug = Math.round(telefonKostenGezahlt * 100.00) / 100.00;
		}
/*
 * Kontrollstruktur zu Arbeistage --> maximal 220 Tage zulässig 
 */
		if (arbeitsTage >= MAXARBEITSTAGE) {
			ArbeitsTageAbzug = MAXARBEITSTAGE;
		} else {
			ArbeitsTageAbzug = arbeitsTage;
		}
/*
* Berechnung der gezahlten Werbungskosten
*/
		WerbungsKostenGezahlt = Math.round(((ArbeitsTageAbzug * entfernungWA * ENTFERNUNGSPAUSCHALE) + KONTOFUEHRUNG
						+ ArbeitsMittelAbzug + TelefonKostenAbzug) * 100.00) / 100.00;
/*
* Kontrollstruktur zum Werbungskostenabzug --> pauschal oder tatsaechliche ausgaben guenstiger fuer AN + Abgleich des Steuerjahres
*/
		switch (steuerJahr) {
		case 2012:
			if (WerbungsKostenGezahlt <= WKPB2012) {
				WerbungsKostenAbzug = WKPB2012;
			} else {
//				WerbungsKostenAbzug = Math.round(WerbungsKostenGezahlt * 100.00) / 100.00;
				WerbungsKostenAbzug = Math.ceil(WerbungsKostenGezahlt);
			}
			break;

		case 2013:
			if (WerbungsKostenGezahlt <= WKPB2013) {
				WerbungsKostenAbzug = WKPB2013;
			} else {
//				WerbungsKostenAbzug = Math.round(WerbungsKostenGezahlt * 100.00) / 100.00;
				WerbungsKostenAbzug = Math.ceil(WerbungsKostenGezahlt);
			}
			break;
			
		default:
			break;
		}
		return WerbungsKostenAbzug;
		
	}
/*
 * END
 */

/*
 * BEGIN
 * Berechnung Summe der Einkuenfte + Ausgabe gerundetes Ergebnis
 */
	public static double SummeEinkunft(double jahresBruttoLohn,	double werbungsKosten) {
		double SummeEinkunft = jahresBruttoLohn - werbungsKosten;
//		return Math.round(SummeEinkunft * 100.00) / 100.00;
		return Math.ceil(SummeEinkunft);
	}
/*
 * END
 */
	
/*
 * BEGIN
 * Berechnung Gesamtbetrag der Einkuenfte ohne zusaetzliche Angaben (Erweiterung in spaeteren Versionen) + Ausgabe gerundetes Ergebnis
 */	
	public static double GesamtbetragEinkunft(double SummeEinkunft){
		double GesamtbetragEinkunft = SummeEinkunft;
//		return Math.round(GesamtbetragEinkunft*100.00)/100.00;
		return Math.ceil(GesamtbetragEinkunft);
	}
/*
 * END
 */
	
/*
 * BEGIN
 * Berechnung Gesamtbetrag der Einkuenfte mit zusaetzliche Angaben (Erweiterung in spaeteren Versionen) + Ausgabe gerundetes Ergebnis
 */
	public static double GesamtbetragEinkunftErweitert(double SummeEinkunft,double AlleinerziehendeFB, double AltersFB, double LandwirteFB){
		double GesamtbetragEinkunft = SummeEinkunft - AlleinerziehendeFB - AltersFB - LandwirteFB;
//		return Math.round(GesamtbetragEinkunft*100.00)/100.00;
		return Math.ceil(GesamtbetragEinkunft);
	}
/*
 * END
 */

/*
 * BEGIN
 * Berechnung des abzugsfaehigen Spendenbetrages
 */
	public static double SpendenAbzug (double GesamtBetragEinkunft, double SpendenGezahlt){
/*
 * Variablen deklarieren
 */		
		final double SPENDENPB = 36.00;
		//Hoechstbetrag des Spendenabzugsberechnen
		double maxSpenden = GesamtBetragEinkunft*20/100;
		double spendenAbzug;
/*
 * Auswertung der gezahlten Spenden gegenueber pauschale und Hoechstbetrag
 */
		if ((SpendenGezahlt >= SPENDENPB) & (SpendenGezahlt <= maxSpenden))
		{
		spendenAbzug = SpendenGezahlt;
		return Math.ceil(spendenAbzug); 
		}
		else if ((SpendenGezahlt >= SPENDENPB) & (SpendenGezahlt >= maxSpenden))
		{
		spendenAbzug = maxSpenden;
		return Math.ceil(spendenAbzug);
		}
		else
		{
		return spendenAbzug = SPENDENPB;
		}
	}
/*
 * END
 */

/*
 * BEGIN
 * Berechnung der abzugsfaehigen aussergewoehnlichen Belastungen
 */
	public static double agBelastungAbzug (double GesamtBetragEinkunft, double KrankheitskostenGezahlt){
/*
 * Variablen deklarieren
 */
		final int GBESTUFE01 = 15340;
		final int GBESTUFE02 = 51130;
		final double ZBSTUFE01 = 0.05;
		final double ZBSTUFE02 = 0.06;
		final double ZBSTUFE03 = 0.07;
		double zumutbareBelastung = 0.0;
/*
 * Berechnung der zumutbaren Belastung anhand des Gesamtbetrages der Einkuenfte
 */
		if ((GesamtBetragEinkunft == 0) & (GesamtBetragEinkunft <= GBESTUFE01))
		{
		zumutbareBelastung = ZBSTUFE01;
		}
		else if ((GesamtBetragEinkunft >= GBESTUFE01) & (GesamtBetragEinkunft <= GBESTUFE02))
		{
		zumutbareBelastung = ZBSTUFE02;
		}
		else
		{
		zumutbareBelastung = ZBSTUFE03;
		}
/*
 * Berechnung aussergewoehnliche Belastung
 */
		double agB = (int) (Math.round((KrankheitskostenGezahlt - (GesamtBetragEinkunft * zumutbareBelastung))*100)/100.00);
/*
 * Kontrolle das agB nicht ins negative faellt
 */
		if (agB <= 0)
		{
		return 0.0;
		}
		else
		{
		return agB;
		}
	}
/*
 * END
 */
	
/*
 * BEGIN
 * Berechnung des Vorsorgeaufwands
 */
	public static double vorsorgeAufwand (int steuerJahr, double RVJahr, double KVJahr, double PVJahr, double AVJahr, double HV, double UV, double BU, double Ruerup, double LvMit, double LvOhne){
/*
 * Variablen deklarieren
 */
		final double SONSVORSORGEPAUSCHAL = 1900.00;
		double vorsorgeAufwand = 0.0;
		double sonsVorsorgeAufwand = 0.0;
/*
 * Berechnung Vorsorgeaufwand
 */
		double vorsorgeAufwandGezahlt = KVJahr+PVJahr;
/*
 * Berechnung der sonstigen Vorsorgeaufwendungen
 */
		double sonsVorsorgeAufwandGezahlt = KVJahr+PVJahr+AVJahr+UV+HV+BU+(LvMit*0.88)+LvOhne; 
/*
 * Kontrolle, ob Vorsorgeaufwand kleiner gleich die Pauschale ist
 * JA = 2. Kontrolle wird geprueft
 * NEIN = Summe aus gezahlte KV + PV
 */
		if(vorsorgeAufwandGezahlt <= SONSVORSORGEPAUSCHAL)
		{
/*
 * Kontrolle, ob sons. Vorsorgeaufwand kleiner gleich Pauschale ist
 * JA = gezahlte Beitraege
 * NEIN = Pauschale
 */
			if(sonsVorsorgeAufwandGezahlt <= SONSVORSORGEPAUSCHAL)
			{
				sonsVorsorgeAufwand = sonsVorsorgeAufwandGezahlt;
			}
			else
			{
				sonsVorsorgeAufwand = SONSVORSORGEPAUSCHAL; 
			}
		}
		else
		{
			sonsVorsorgeAufwand = vorsorgeAufwandGezahlt;
		}
/*
 * Pruefung des Steuerjahres mit dazugehoerigen jahresabhaengigen Berechnungen fuer den abzugsfaehigen Vorsorgeaufwands	
 */
		switch (steuerJahr) {
		case 2010:
			{
				vorsorgeAufwand = ((RVJahr*2+Ruerup)*0.70 - RVJahr) + sonsVorsorgeAufwand;
			}
			break;
		case 2011:
			{
				vorsorgeAufwand = ((RVJahr*2+Ruerup)*0.72 - RVJahr) + sonsVorsorgeAufwand;			
			}
			break;
		case 2012:
			{
			vorsorgeAufwand = ((RVJahr*2+Ruerup)*0.74 - RVJahr) + sonsVorsorgeAufwand;			
			}
		break;	
		case 2013:
			{
			vorsorgeAufwand = ((RVJahr*2+Ruerup)*0.76 - RVJahr) + sonsVorsorgeAufwand;			
			}
		break;	
		case 2014:
			{
			vorsorgeAufwand = ((RVJahr*2+Ruerup)*0.78 - RVJahr) + sonsVorsorgeAufwand;			
			}
			break;	
		default:
			break;
		}
/*
 * Pruefung des Hoechstbetrages der abzugsfaehigen Vorsorgeaufwendungen
 */
		if(steuerJahr == 2010)
		{
			if(vorsorgeAufwand <= 14000.00)
				return Math.round(vorsorgeAufwand*100)/100.00;
			else 
				return vorsorgeAufwand = 14000.00;
		}
		else if (steuerJahr == 2011) 
		{
			if(vorsorgeAufwand <= 14400.00)
				return Math.round(vorsorgeAufwand*100)/100.00;
			else 
				return vorsorgeAufwand = 14400.00;
		}
		else if (steuerJahr == 2012) 
		{
			if(vorsorgeAufwand <= 14800.00)
				return Math.round(vorsorgeAufwand*100)/100.00;
			else 
				return vorsorgeAufwand = 14800.00;
		}
		else if (steuerJahr == 2013) 
		{
			if(vorsorgeAufwand <= 15200.00)
				return Math.round(vorsorgeAufwand*100)/100.00;
			else 
				return vorsorgeAufwand = 15200.00;
		}
		else if (steuerJahr == 2014) 
		{
			if(vorsorgeAufwand <= 15600.00)
				return Math.round(vorsorgeAufwand*100)/100.00;
			else 
				return vorsorgeAufwand = 15600.00;
		}
		return vorsorgeAufwand = 0.0;
	}
/*
 * END
 */

/*
 * BEGIN
 * Berechnung des zuversteuernden Einkommens
 */
	public static double zuVerstEinkommen (double gesamtbetragEinkunft, double vorsorgeAufwand, double spendenAbzug, double agBelastungAbzug){
		double zvE = gesamtbetragEinkunft - vorsorgeAufwand - spendenAbzug - agBelastungAbzug;
//		return Math.round(zvE*100.00)/100.00;
		return Math.ceil(zvE);
	}
/*
 * END	
 */
	
/*
 * BEGIN
 * Berechnung der Einkommensteuerbelastung
 */
	public static double einkommenSteuer (int steuerJahr, double zuVerstEinkommen){
		double est = 0.0;
		double faktor = 0.0;
		
		switch (steuerJahr) {
		case 2010:
		case 2011:
		case 2012:{		
			if ((zuVerstEinkommen == 0) & (zuVerstEinkommen <= 8004))
			{
				return est;
			}
			else if ((zuVerstEinkommen >= 8005) & (zuVerstEinkommen <= 13469))
			{
				faktor = (zuVerstEinkommen - 8004)*0.0001;
				est = Math.round((((912.17 * faktor + 1400) * faktor))*100)/100.00;
			}
			else if ((zuVerstEinkommen >= 13470) & (zuVerstEinkommen <= 52881))
			{
				faktor = (zuVerstEinkommen - 13469)*0.0001;
				est = Math.round((((228.74 * faktor + 2397) * faktor) + 1038)*100)/100.00;
			}
			else if ((zuVerstEinkommen >= 52882) & (zuVerstEinkommen <= 250730))
			{
				faktor = (int) zuVerstEinkommen;
				est = Math.round((0.42 * faktor - 8172)*100)/100.00;
			}
			else
			{
				faktor = (int) zuVerstEinkommen;
				est = Math.round((0.45 * faktor - 15694)*100)/100.00;
			}
			break;
		}
		case 2013:
		case 2014:{
			if ((zuVerstEinkommen == 0) & (zuVerstEinkommen <= 8130))
			{
				return est;
			}
			else if ((zuVerstEinkommen >= 8131) & (zuVerstEinkommen <= 13469))
			{
				faktor = (zuVerstEinkommen - 8130)*0.0001;
				est = Math.round((((933.7 * faktor + 1400) * faktor))*100)/100.00;
			}
			else if ((zuVerstEinkommen >= 13470) & (zuVerstEinkommen <= 52881))
			{
				faktor = (zuVerstEinkommen - 13469)*0.0001;
				est = Math.round((((228.74 * faktor + 2397) * faktor) + 1038)*100)/100.00;
			}
			else if ((zuVerstEinkommen >= 52882) & (zuVerstEinkommen <= 250730))
			{
				faktor = Math.ceil(zuVerstEinkommen);
				est = Math.round((0.42 * faktor - 8196)*100)/100.00;
			}
			else
			{
				faktor = Math.ceil(zuVerstEinkommen);
				est = Math.round((0.45 * faktor - 15718)*100)/100.00;
			}
			break;
		}
	}
/*
 * Kontrolle das Einkommensteuer nicht ins negative faellt
 */
		if (est <= 0)
		{
		return 0.0;
		}
		else
		{
		return est;
		}
	}
/*
 * END
 */

/*
 * BEGIN
 * Berechnung der SoliZuschlagbelastung
 */
	public static double soliZuschlag (double zuVerstEinkommen, double kapitalSteuer, double einkommenSteuer){
		final double FREIBETRAGSOLI = 972.0; 
/*
 * berechne soliZuschlag
 */
		double soliZuschlag = zuVerstEinkommen*0.055;
/*
 * berechne haerteklausel soliZuschlag
 */
		double haerteKlausel = ((zuVerstEinkommen-kapitalSteuer-FREIBETRAGSOLI)*0.2)+(kapitalSteuer*0.055); 
/*
 * vergleichabfrage zwischen obergrenze und tatsaechlichen zuschlag
 */
		if (soliZuschlag <= FREIBETRAGSOLI)
		{
			return 0.0; 
		}
		else if (soliZuschlag <= haerteKlausel)
		{
//			return Math.round(soliZuschlag*100.00)/100.00;
			return Math.ceil(soliZuschlag);
		} else
		{
//			return Math.round(haerteKlausel*100.00)/100.00; 
			return Math.ceil(haerteKlausel);
		}
	}
/*
 * END
 */
	
/*
 * BEGIN
 * Berechnug des direkten Steuerabzugs nach Paragraph 35a EStG 
 */
	public static double hnDlAbzug (double hnDlMitAN, double hnDlOhneAN, double handwerkerL){
		
		final double HNDLMITANMAX = 510.00;
		final double HNDLOHNEMAX = 4000.00;
		final double HANDWERKERLMAX = 1200.00;
		final double ABZUGFAKTOR = 0.2;
		double hnDlMitAnAbzug = 0.0;
		double hnDlOhneAnAbzug = 0.0;
		double handwerkerLAbzug = 0.0;
		
		if((hnDlMitAN*ABZUGFAKTOR) <= HNDLMITANMAX){
			hnDlMitAnAbzug = (hnDlMitAN*ABZUGFAKTOR);
		} else {
			hnDlMitAnAbzug = HNDLMITANMAX;
		}
		if ((hnDlOhneAN*ABZUGFAKTOR) <= HNDLOHNEMAX){
			hnDlOhneAnAbzug = (hnDlOhneAN*ABZUGFAKTOR);
		} else {
			hnDlOhneAnAbzug = HNDLOHNEMAX;
		}
		if ((handwerkerL*ABZUGFAKTOR) <= HANDWERKERLMAX){
			handwerkerLAbzug = (handwerkerL*ABZUGFAKTOR);
		} else {
			handwerkerLAbzug = HANDWERKERLMAX;
		}
		
		return Math.round((hnDlMitAnAbzug+hnDlOhneAnAbzug+handwerkerLAbzug)*100.00)/100.00; 
	}
/*
 * END
 */
	
/*
 * BEGIN
 * Berechnung des Steuerergebnisses
 */
	public static double ergebnisSteuer (double einkommenSteuer, double soliZuschlag, double lohnSteuerJahr, double soliZuschlagJahr, double hnDlAbzug){
		double ergebnis = einkommenSteuer + soliZuschlag - lohnSteuerJahr - soliZuschlagJahr - hnDlAbzug;
		return Math.round(ergebnis*100.00)/100.00;
	}
/*
 * END
 */
}
