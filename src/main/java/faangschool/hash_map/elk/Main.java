package faangschool.hash_map.elk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static HashMap<User, List<Query>> userRequests = new HashMap<>();

    public static void main(String[] args) {
        User joe = new User(1, "Joe");
        User lucy = new User(2, "Lucy");
        Query queryJoe1 = new Query(1, "Find blue cars", LocalDate.now().atStartOfDay());
        Query queryJoe2 = new Query(2, "Find red cars", LocalDate.now().atStartOfDay());
        Query queryLucy1 = new Query(3, "Find yellow books", LocalDate.now().atStartOfDay());
        Query queryLucy2 = new Query(4, "Find brown books", LocalDate.now().atStartOfDay());


        addUserRequests(joe, new ArrayList<>(List.of(queryJoe1)));
        addNewQuery(joe, queryJoe2);

        addUserRequests(lucy, new ArrayList<>(List.of(queryLucy1)));
        addNewQuery(lucy, queryLucy2);
        printAllUsersAndQueries();

        System.out.println();
        deleteUserAndQueries(lucy);
        printAllUsersAndQueries();
    }

    public static void addUserRequests(User user, List<Query> queries) {
        if (!(user == null || queries == null)) {
            userRequests.put(user, queries);
        }
    }


    public static void addNewQuery(User user, Query query) {
        if (!(user == null || query == null)) {
            List<Query> queries = userRequests.get(user);
            if (queries == null) {
                queries = new ArrayList<>();
                userRequests.put(user, queries);
            }
            queries.add(query);
        }
    }

    public static void deleteUserAndQueries(User user) {
        if (user != null) {
            userRequests.remove(user);
        }
    }

    public static void printAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> userListEntry : userRequests.entrySet()) {
            System.out.println(userListEntry);
        }
    }
}
