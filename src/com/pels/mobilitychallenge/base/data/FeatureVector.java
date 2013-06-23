package com.pels.mobilitychallenge.base.data;

import java.util.List;

import com.pels.mobilitychallenge.base.common.Utilities;

public class FeatureVector {

	public static final String HEADER = "Avg Speed,Max Speed,Straight Distance,Actual Distance,Distance Delta,Actual Duration,Computed Duration,Duration Delta";
	private static final String SEP = ",";
	// Speed Features
	double avgSpeed;
	double maxSpeed = -1;

	// Distance Features
	double straightDistance = 0;
	double actualDistance = 0;
	double distanceDelta = 0;

	// Time Features
	double actualDuration;
	double computedDuration;
	double durationDelta;

	public FeatureVector(List<Reading> frames) {
		if (!frames.isEmpty()) {

			Reading firstR = frames.get(0);
			Reading lastR = frames.get(frames.size()-1);

			double speedTemp = 0;
			for (int i = 1; i < frames.size(); i++) {
				Reading r1 = frames.get(i - 1);
				Reading r2 = frames.get(i);
				double time = (r2.time - r1.time) / 1000;

				double distance = Utilities.distance(r1, r2);
				actualDistance += distance;

				double speed = distance / time;

				maxSpeed = maxSpeed > speed ? maxSpeed : speed;

				speedTemp += speed;

			}
			avgSpeed = speedTemp / frames.size();

			straightDistance = Utilities.distance(firstR, lastR);

			actualDuration = (lastR.time - firstR.time) / 1000;

			computedDuration = straightDistance / avgSpeed;

			durationDelta = Math.abs(actualDuration - computedDuration);
			distanceDelta = Math.abs(actualDistance - straightDistance);

		}
	}

	@Override
	public String toString() {
		return "" + avgSpeed + SEP + maxSpeed + SEP + straightDistance + SEP
				+ actualDistance + SEP + distanceDelta + SEP + actualDuration
				+ SEP + computedDuration + SEP + durationDelta;
	}

}
