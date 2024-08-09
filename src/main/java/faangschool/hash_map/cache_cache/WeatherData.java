package faangschool.hash_map.cache_cache;

import java.util.Objects;

public class WeatherData {
    private String city;
    private double temperature;
    private int humidity;


    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public long getHumidity() {
        return humidity;
    }

    public WeatherData(String city, double temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData weatherData = (WeatherData) o;
        return temperature == weatherData.getTemperature() && humidity == weatherData.getHumidity() && Objects.equals(city, weatherData.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity);
    }
}
