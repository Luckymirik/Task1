import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Мирослав", 34);
        User user2 = new User("Мирослав", 34);
        User user3 = new User("Саша", 33);
        User user4 = new User("Олег", 33);
        User user5 = new User("Ева", 20);
        User user8 = new User("Рон", 20);
        User user6 = new User("Макс", 15);
        User user7 = new User("Анастас", 33);
        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        System.out.println(users);
        sortedByAgeAndName(users);

        getOldUser(users);


    }
        public static List<User>  sortedByAgeAndName(Set<User> users) {
            List<List<User>> byAgeList = users.stream()
                    .collect(Collectors.groupingBy(User::getAge))
                    .entrySet().stream().sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue).collect(Collectors.toList());
            System.out.println(byAgeList);
            List<User> byAgeAndNameList = byAgeList.stream().flatMap(userList -> userList.stream()
                            .sorted(Comparator.comparing(User::getName)))
                    .collect(Collectors.toList());
            System.out.println(byAgeAndNameList);
            return byAgeAndNameList;

        }


    public static User getOldUser(Set<User> users) {
        User oldUser = users.stream().max(Comparator.comparing(User::getAge)).get();
        System.out.println(oldUser);
        return oldUser;
    }





}

