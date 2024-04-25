

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final List<String> CITIES = new ArrayList<>(List.of("София", "Варна", "Бургас"));
        Scanner input;
        FileWriter output;
        Map<String, Integer> cities = new HashMap<>();
        List<Map.Entry<String, Integer>> numbers = new ArrayList<>();
        try {
            input = new Scanner(new File("src/bg/smg/input.txt"));
            output = new FileWriter("src/bg/smg/output.txt");
            while(input.hasNext()) {
                String city = input.next();
                int rooms = input.nextInt();
                int area = input.nextInt();
                int price = input.nextInt();
                String number = input.next();

                if(cities.containsKey(city)) {
                    cities.put(city, cities.get(city) + 1);
                } else {
                    cities.put(city, 1);
                }

                if(CITIES.contains(city) && rooms == 3 && area > 100) {
                    numbers.add(Map.entry(number, price));
                }
            }

            if(numbers.isEmpty()) throw new UnsuitableApartmentsException("No apartments found");

            numbers.sort(Map.Entry.comparingByValue());

            Set<String> phones = new LinkedHashSet<>();

            for(int i = 0; i < 5; i++) {
                if(i >= numbers.size()) break;
                phones.add(numbers.get(i).getKey());
            }

            for(String s : phones) {
                output.write(s + "\n");
            }

            List<Map.Entry<String, Integer>> citiesL = new ArrayList<>(cities.entrySet());
            citiesL.sort(Map.Entry.comparingByValue());

            Collections.reverse(citiesL);

            int most = citiesL.get(0).getValue();
            output.write(citiesL.get(0).getKey() + "\n");

            for(int i = 1; i < citiesL.size(); i++) {
                if(citiesL.get(i).getValue() < most) break;
                output.write(citiesL.get(i).getKey() + "\n");
            }

            output.close();
            input.close();
        } catch (IOException ioe) {
            System.out.println("Invalid input and output");
        } catch (UnsuitableApartmentsException e) {
            e.printStackTrace();
        }

    }
}
