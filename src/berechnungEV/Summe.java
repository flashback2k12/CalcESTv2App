package berechnungEV;
/*
 * Ideen fuer ein vernuenftigen Klassennamen!?
 */
public class Summe {
	
	public static double abrunden50(double summe){
		return ((summe) - (summe + 100)%50);
	}
	
	public static double abrunden100(double summe){
		return (Math.round(summe/100)*100);
	}
	/*
	 * benoetige noch die richtige Methode!!!
	 * 
	public static double aufrunden50(double summe){
		return (XXX);
	}
	*/
	public static double aufrunden100(double summe){
		return ((((summe) + 50)/100)*100);
	}
}
