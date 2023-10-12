
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Participant[] participants = new Participant[5];

        participants[0] = new Participant("Eraj", "Rizvi", 25, Participant.SportType.BASKETBALL, Arrays.asList("INTERNATIONAL COMMONWEALTH GAMES 2023 Runner-up", "NATIONAL TOURNAMENT 2020 Champion", "NATIONAL TOURNAMENT 2021 Champion"));
        participants[1] = new Participant("Tasmeena", "Iqbal", 28, Participant.SportType.SOCCER, Arrays.asList("INTERNATIONAL OLYMPICS 2022 RUNNER-UP"));
        participants[2] = new Participant("Ali", "Haider", 26, Participant.SportType.SWIMMING, Arrays.asList("NATIONAL OLYMPICS 2020 CHAMPION"));
        participants[3] = new Participant("Hudaib", "Baig", 22, Participant.SportType.BASKETBALL, Arrays.asList("INTERNATIONAL COMMMONWEALTH GAMES 2023 Champion"));
        participants[4] = new Participant("Saeed", "Shah", 25, Participant.SportType.ATHLETICS, Arrays.asList("NATIONAL TOURNAMENT 2023 Runner-up"));

        Scanner input = new Scanner(System.in);

        System.out.print("Please select participant by: \n1. Sport Type\n2. Number of national awards.\n3. Number of international awards.\nYour choice: ");
        String choice = input.nextLine();

        switch(choice) {

            // Case 1: Find out participants depending on sport type
            case "1": 
                System.out.print("Please input sport type: ");
                String sportTypeChoice = input.nextLine();
                if(Arrays.stream(Participant.SportType.values()).anyMatch((type) -> type.name().equalsIgnoreCase(sportTypeChoice))) {
                    for(int i = 0; i < participants.length; i++) {
                        if(sportTypeChoice.equalsIgnoreCase(participants[i].getSportType().name())) {
                            System.out.println("Participant " + i + " --- " + participants[i]);
                        }
                    }
                } else {
                    System.out.println("Invalid sport selected. Try again");
                }
                break;

            // Case 2: Find out participants depending number of national awards
            case "2": 
                System.out.println("-------------------------------------------\nNational Awards: \n-------------------------------------------");
                int nationalAwardCount = 0;
                for(int i = 0; i < participants.length; i++) {
                    for(int j = 0; j < participants[i].getAwards().size(); j++) {
                        if(participants[i].getAwards().get(j).startsWith("NATIONAL")) {
                            System.out.println("Participant " + i + " --- Name: " + participants[i].getName() + " " + participants[i].getSurname() + ", Award: " + participants[i].getAwards().get(j));
                            nationalAwardCount++;
                        }
                    }
                }
                System.out.println("-------------------------------------------\nTotal National awards: " + nationalAwardCount);
                break;

            // Case 3: Find out participants depending number of international awards
            case "3":
                System.out.println("-------------------------------------------\nInternational Awards: \n-------------------------------------------");
                int internationalAwardCount = 0;
                for(int i = 0; i < participants.length; i++) {
                    for(int j = 0; j < participants[i].getAwards().size(); j++) {
                        if(participants[i].getAwards().get(j).startsWith("INTERNATIONAL")) {
                            System.out.println("Participant " + i + " --- Name: " + participants[i].getName() + " " + participants[i].getSurname() + ", Award: " + participants[i].getAwards().get(j));
                            internationalAwardCount++;
                        }
                    }
                }
                System.out.println("-------------------------------------------\nTotal International awards: " + internationalAwardCount);
                break;

            default: 
                System.out.println("Invalid input. Try again");
                break;
                
        }
        input.close();
    }

}
