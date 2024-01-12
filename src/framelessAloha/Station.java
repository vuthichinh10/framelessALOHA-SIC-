package framelessAloha;

import java.util.ArrayList;
import java.util.Random;

public class Station {
	private int idStation ;
	private boolean stationSent = false;
	private int countOFCopy ;
	public Station(int id ) {
		this.idStation = id ;
	}
	public int getIdStation() {
		return this.idStation ;
	}

	public boolean isStationSent() {
		return stationSent;
	}

	public void setStationSent(boolean stationSent) {
		this.stationSent = stationSent;
	}
	public int getCountOFCopy() {
		return countOFCopy;
	}
	public void setCountOFCopy(int countOFCopy) {
		this.countOFCopy = countOFCopy;
	}
	


}
