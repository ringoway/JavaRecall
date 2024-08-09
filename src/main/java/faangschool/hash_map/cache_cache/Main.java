package faangschool.hash_map.cache_cache;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {
    static HashMap<String, WeatherData> cache = new HashMap<>();
    static MockWeatherService weatherService = new MockWeatherService();
    public static void main(String[] args) {
        System.out.println(getWeatherData("Main"));
        System.out.println(getWeatherData(""));
        updateWeatherData("Main");
        getWeatherData("Ohio");
        getWeatherData("Moscow");
        removeWeatherData("Ohio");
        getWeatherData("Rostov");
        printAllCityByWeatherData();
    }
    public static WeatherData getWeatherData(String city) {
        if (city.isBlank()) {
            log.error("City is Blank!");
            return null;
        }
        if (cache.containsKey(city)) {
            log.debug(city + " is getting from cache");
            return cache.get(city);
        }
        WeatherData weatherDataForCity = weatherService.getWeatherDataForCity(city);
        log.debug(city + " is taking from service");

        cache.put(city, weatherDataForCity);
        log.debug(city + " putting in cache");
        log.info(city + " is taking from service, putting in cache and getting from cache");
        return cache.get(city);
    }
    public static WeatherData updateWeatherData(String city) {
        if (city.isBlank()) {
            log.error("City is Blank!");
            return null;
        }
        cache.remove(city);
        log.debug(city + " is removed");

        WeatherData weatherDataForCity = weatherService.getWeatherDataForCity(city);
        log.debug(city + " is taking from service");

        cache.put(city, weatherDataForCity);
        log.debug(city + " putting in cache");
        log.info(city + " is updated in cache");
        return cache.get(city);
    }
    public static void removeWeatherData(String city) {
        if (city.isBlank()) {
            log.error("City is Blank!");
        } else {
            cache.remove(city);
            log.info(city + " is removed from cache");
        }
    }
    public static void printAllCityByWeatherData() {
        log.debug("Print All City By Weather Data");
        for (Map.Entry<String, WeatherData> entry : cache.entrySet()) {
            System.out.println(entry);
        }
    }
}
