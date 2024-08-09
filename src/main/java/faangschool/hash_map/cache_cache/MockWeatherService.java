package faangschool.hash_map.cache_cache;

public class MockWeatherService {
    public WeatherData getWeatherDataForCity(String city) {
        double mockTemperature = Math.round((Math.random() * 30 + 10) * 10) / 10.0;
        int mockHumidity = (int) (Math.random() * 50 + 50);
        return new WeatherData(city, mockTemperature, mockHumidity);
    }
}
