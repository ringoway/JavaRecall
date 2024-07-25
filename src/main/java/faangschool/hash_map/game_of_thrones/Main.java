package faangschool.hash_map.game_of_thrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static HashMap<String, House> housesOfWesteros = new HashMap<>();

    public static void main(String[] args) {
        housesOfWesteros.put("Stark", new House("Stark", "Dragon"));
        housesOfWesteros.put("Lannister", new House("Lannister", "Snake"));
        addHouse("Barateon", "Fish");
        removeHouse("Lannister");

        System.out.println(findHouse("Stark"));
        System.out.println(findAllHouses(housesOfWesteros));
    }

    public static void addHouse(String name, String sigil) {
        if (name.isBlank()) {
            System.out.println("You entered an empty value for home!");
        }
        if (sigil.isBlank()) {
            System.out.println("You entered an empty coat of arms value!");
        }
        if (!(name.isBlank() || sigil.isBlank())) {
            House house = new House(name, sigil);
            housesOfWesteros.put(name, house);
        }

    }

    public static void removeHouse(String name) {
        if (name.isBlank()) {
            System.out.println("You entered an empty value for home!");
        }
        if (!name.isBlank()) {
            housesOfWesteros.remove(name);
        }
    }

    public static House findHouse(String name) {
        if (!name.isBlank()) {
            return housesOfWesteros.get(name);
        }
        if (name.isBlank()) {
            System.out.println("You entered an empty value for home!");
        }
        return null;
    }

    public static List<House> findAllHouses(HashMap<String, House> housesOfWesteros) {
        if (housesOfWesteros.isEmpty()) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Main.housesOfWesteros.values());
        }
    }
}
