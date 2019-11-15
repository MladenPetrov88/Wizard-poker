import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(":");
        List<String> cards = new ArrayList<>();
        List<String> deck = new ArrayList<>();


        for (int i = 0; i < input.length; i++) {
            cards.add(input[i]);
        }

        String command = scanner.nextLine();

        while (!command.equals("Ready")) {
            String[] temp = command.split(" ");
            String firstCommand = temp[0];

            if (firstCommand.equals("Add")) {
                if (cards.contains(temp[1])) {
                    deck.add(temp[1]);
                } else {
                    System.out.println("Card not found.");
                }
            }

            if (firstCommand.equals("Insert")) {
                if (Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) < cards.size() && cards.contains(temp[1])) {
                    deck.add(Integer.parseInt(temp[2]), temp[1]);
                } else {
                    System.out.println("Error!");
                }
            }

            if (firstCommand.equals("Remove")) {
                if (deck.contains(temp[1])) {
                    deck.remove(temp[1]);
                } else {
                    System.out.println("Card not found.");
                }
            }

            if (firstCommand.equals("Swap")) {
                if (deck.contains(temp[1]) && deck.contains(temp[2])) {
                    for (int i = 0; i < deck.size(); i++) {
                        if (deck.get(i).equals(temp[1])) {
                            deck.set(i, temp[2]);
                        } else if (deck.get(i).equals(temp[2])) {
                            deck.set(i, temp[1]);
                        }
                    }
                }
            }

            if (command.equals("Shuffle deck")) {

                Collections.reverse(deck);
            }


            command = scanner.nextLine();
        }

        for (String s : deck) {
            System.out.print(s + " ");
        }

    }
}
