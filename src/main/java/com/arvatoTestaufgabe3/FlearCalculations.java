package com.arvatoTestaufgabe3;

import java.util.ArrayList;
import java.util.List;

public class FlearCalculations {
	
	private static int result;
	private static Flear[] bestFlears;
	
	
	public static int getOptimalValue(float money, List<Flear> flears) {
		
		// vorbesetzen
		result = 0;
		int res = 0;		
		Flear[] flearsTemp = new Flear[flears.size()];
		//Boolean[] flearsPickmap = new Boolean[flears.size()];
		bestFlears = new Flear[flears.size()];
		int summe = 0;
		int stelle = 0;
		
		// sobald liste nicht leer ist
		if(flears.size() > 0) {			
			
			nextPos(flears, flearsTemp, summe, money, stelle);
			
		}
		res = result;
		return res;
	}
	
	// rekursiv geht die Methode einen Schritt weiter nach rechts in der Liste und geht dort weiterhin alle Kombinationen durch
	public static void nextPos(List<Flear> flears, Flear[] flearsTemp, int summe, float money, int stelle) {
		
		// zwei zustände. erster zustand: floh wird ausgewählt. zweiter zustand: floh wird nicht ausgewählt
		for(int i = 0; i < 2; i++) {
			
			if(i == 0) {
				flearsTemp[stelle] = flears.get(stelle); // Temp wird mit floh an der gleichen stelle ausgewählt
				money -= flears.get(stelle).getPrice(); // price wird vom money abgezogen
				summe += flears.get(stelle).getRating(); // Bewertung wird aufsummiert
				
				// Abfrage bzw Vergleich ob Optimum
				if(money >= 0 && summe > result) {
					result = summe;
					bestFlears = flearsTemp.clone();
				}
				
			} else {
				flearsTemp[stelle] = null; // Floh wird nicht ausgewählt
				money += flears.get(stelle).getPrice();
				summe -= flears.get(stelle).getRating();
			}
			
			// solange die letzte pos nicht erreicht wurde
			if(stelle != (flears.size()-1)) {
				nextPos(flears, flearsTemp, summe, money, stelle+1); // nächster Schritt... stelle wird um 1 erhöht übergeben
			}
			
		}
	}
	
	// prüft ob aktueller Floh schon in der temporären Liste enthalten ist
//	public boolean isFlearInList(Flear flear) {
//		boolean tmp = false;
//		
//		for(Flear ft : flearsTemp){
//			if(flear.equals(ft)) {
//				return true;
//			}
//		}
//		return tmp;
//	}
	
}
