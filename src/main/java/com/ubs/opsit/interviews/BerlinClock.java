package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {

	int NO_OF_HH_LED = 4;
	int NO_OF_MIN_QTR_LED = 11;
	int NO_OF_MIN_LED = 4;

	char RED = 'R';
	char YELLOW = 'Y';

	@Override
	/*
	 * param aTime of format When the time is HH:MM:SS in 24 hours format
	 * assuming validation is perfromed prior to this call.
	 */
	public String convertTime(String aTime) {

		String timeSplitArr[] = aTime.split(":");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getSeconds(Integer.parseInt(timeSplitArr[2])));
		stringBuilder.append("\r\n");
		stringBuilder.append(getTopHours(Integer.parseInt(timeSplitArr[0])));
		stringBuilder.append("\r\n");
		stringBuilder.append(getBottomHours(Integer.parseInt(timeSplitArr[0])));
		stringBuilder.append("\r\n");
		stringBuilder.append(getTopMinutes(Integer.parseInt(timeSplitArr[1])).replace("YYY", "YYR"));
		stringBuilder.append("\r\n");
		stringBuilder
				.append(getBottomMinutes(Integer.parseInt(timeSplitArr[1])));

		return stringBuilder.toString();
	}

	/*
	 * HH:MM:SS example 13:59:0 SS = 0; in Berlin Clock Seconds LED will be on
	 * for every Even second and of every Odd Second
	 * 
	 * @param seconds output Y or O
	 */
	private String getSeconds(int seconds) {
		return seconds % 2 == 0 ? "Y" : "O";
	}

	/*
	 * HH:MM:SS example 13:59:0 HH = 13; in Berlin Clock Seconds LED will be on
	 * for every Even second and of every Odd Second The top row will represents
	 * 5 hours in each 4 led the max being 20 hours HH - (HH % 5) / 5 will give
	 * us the how many LED should be RED on the Top Red Row for Example 13 (13 -
	 * (13 % 5) )/ 5 = 10 / 5 = 2 that is RR
	 */
	private String getTopHours(int hours) {
		int topHours = (hours - (hours % 5)) / 5;

		return turnOnOffLights(topHours, RED, NO_OF_HH_LED);

	}

	/*
	 * HH:MM:SS example 13:59:0 HH = 13; The bottom RED LED row will represents
	 * 4 hours 1 LED / HR HH % 5 will give us the how many LED should be RED on
	 * the bottom Red Row for example 13 % 5 = 3 that is RRR
	 */

	private String getBottomHours(int hours) {

		int bottomHours = hours % 5;
		return turnOnOffLights(bottomHours, RED, NO_OF_HH_LED);

	}

	/*
	 * HH:MM:SS example 13:59:0 MM = 59; The top minutes row will represents
	 * minutes quarter 15, 30 , 45 of the hours having 11 leds (MM - MM % 5) / 5
	 * will give us  how many LED should be On /off	 */
	private String getTopMinutes(int minutes){
		int topMinutes = (minutes - minutes % 5) / 5;
		return turnOnOffLights(topMinutes, YELLOW, NO_OF_MIN_QTR_LED);
	}	
 
	/*
	 * HH:MM:SS example 13:59:0 MM = 59; The top minutes row will represents
	 * low minutes row 
	 * will give us how many LED should be On /off
	 */
	private String getBottomMinutes(int minutes) {
		int bottomMinutes = minutes % 5;
		return turnOnOffLights(bottomMinutes, YELLOW , NO_OF_MIN_LED);

	}

	
	/*
	 * Method to Tunr On/ off ligths based on the row, and the noof lights
	 */
	private String turnOnOffLights(int noOfLedOn, char color, int maxLength) {
		char strArry[] = { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
				'O' };
		for (int i = 0; i < noOfLedOn; i++) {
			strArry[i] = color;
		}

		return String.valueOf(strArry, 0, maxLength );
	}
}
