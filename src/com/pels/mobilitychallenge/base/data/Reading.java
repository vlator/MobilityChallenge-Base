package com.pels.mobilitychallenge.base.data;

import java.util.StringTokenizer;

import com.pels.mobilitychallenge.base.common.MalformedReading;

public class Reading {

	private static final String SEP = ",";

	protected double time;
	protected double latitude;
	protected double longitude;
	protected double elevation;
	protected double accuracy;
	protected double bearing;
	protected double speed;
	protected Label label;

	public Reading(String line) throws MalformedReading {
		StringTokenizer st = new StringTokenizer(line, SEP);
		if (st.countTokens() >= 7) {
			
			time = Double.valueOf(st.nextToken());
			latitude = Double.valueOf(st.nextToken());
			longitude = Double.valueOf(st.nextToken());
			elevation = Double.valueOf(st.nextToken());
			accuracy = Double.valueOf(st.nextToken());
			bearing = Double.valueOf(st.nextToken());
			speed = Double.valueOf(st.nextToken());
			
			if (st.hasMoreTokens()) {
				label = Label.valueOf(st.nextToken());
			} else {
				label = null;
			}
		}else{
			throw new MalformedReading();
			}
	}

	/**
	 * @return the sep
	 */
	public static String getSep() {
		return SEP;
	}

	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the elevation
	 */
	public double getElevation() {
		return elevation;
	}

	/**
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * @return the bearing
	 */
	public double getBearing() {
		return bearing;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}
}
