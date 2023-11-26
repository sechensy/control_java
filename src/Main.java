import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        boolean flag = true;
        while(flag){
            System.out.println("Меню:");
            System.out.println("1. Добавить\n" +
                    "2. Вывести телефонную книгу\n" +
                    "3. Выход\n");

            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if (num == 1){
                Scanner in2 = new Scanner(System.in);
                System.out.print("Введите имя и фамилию человека: ");
                String name1 = in2.nextLine();
                System.out.print("Введите номер: ");
                Integer phone1 = in2.nextInt();
                addContact(phoneBook, name1, phone1);
            } else if (num == 2) {
                printPhoneBook(phoneBook);
            } else if (num == 3) {
                flag = false;
            }
        }
    }


    private static void addContact(Map<String, ArrayList<Integer>> phoneBook, String name, int phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    private static void printPhoneBook(Map<String, ArrayList<Integer>> phoneBook) {
        List<Map.Entry<String, ArrayList<Integer>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = sortedEntries.size() - 1; i >= 0; i--) {
            Map.Entry<String, ArrayList<Integer>> entry = sortedEntries.get(i);
            String name = entry.getKey();
            ArrayList<Integer> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}

