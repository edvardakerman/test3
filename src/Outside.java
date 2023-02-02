class Outside extends Location {

	public static String Weather;
	
	Outside(String Name, String Description){
		super(Name, Description);
	}
	
	public void changeWeather() {
		String possWeather[] = new String[] { "sunny", "cloudy", "rainy" };
		Outside.Weather = possWeather[(int) Math.floor(Math.random()*possWeather.length)];
	}
}
