import java.util.*;
public class PaukriProgram1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameGo = true;
        boolean error = true;
        int ans;
        String Pakuri;
        int capacity;
        System.out.print("Welcome to Pakudex: Tracker Extraordinaire!\n" +
                "Enter max capacity of the Pakudex: ");
        while(true){
            try{
                capacity = scan.nextInt();
                if(capacity < 0){
                    throw new InputMismatchException();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                scan = new Scanner(System.in);
                continue;
            }
            break;
        }
        Pakudex Pakudex = new Pakudex(capacity);
        System.out.println("The Pakudex can hold "+ Pakudex.getCapacity() +" species of Pakuri.\n");
        while(gameGo){
            System.out.println("Pakudex Main Menu\n" +
                    "-----------------\n" +
                    "1. List Pakuri\n" +
                    "2. Show Pakuri\n" +
                    "3. Add Pakuri\n" +
                    "4. Evolve Pakuri\n" +
                    "5. Sort Pakuri\n" +
                    "6. Exit\n");
            System.out.print("What would you like to do? ");
            while(true){
                try{
                    ans = scan.nextInt();
                    if(ans < 0){
                        throw new InputMismatchException();
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Unrecognized menu selection!\n");
                    System.out.println("Pakudex Main Menu\n" +
                            "-----------------\n" +
                            "1. List Pakuri\n" +
                            "2. Show Pakuri\n" +
                            "3. Add Pakuri\n" +
                            "4. Evolve Pakuri\n" +
                            "5. Sort Pakuri\n" +
                            "6. Exit\n");
                    System.out.print("What would you like to do? ");
                    scan = new Scanner(System.in);
                    continue;
                }
                break;
            }

            if (ans == 1){
                if (Pakudex.getSize() == 0){
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else for(int i=0; i < Pakudex.getSize(); i++){
                    System.out.println("Pakuri In Pakudex:");
                    if (Pakudex.getSpeciesArray()[i] != null){
                        System.out.println((i+1)+". " + Pakudex.getSpeciesArray()[i]);
                    }
                }
                System.out.println(" ");
            }
            else if (ans == 2){
                System.out.print("Enter the name of the species to display: ");
                Pakuri = scan.next();
                if(Pakudex.getStats(Pakuri) == null){
                    System.out.println("Error: No such Pakuri!\n");
                }
                else {
                    System.out.println("Species: " + Pakuri + "\n" + "Attack: " + Pakudex.getStats(Pakuri)[0] + "\n" + "Defense: "
                            + Pakudex.getStats(Pakuri)[1] + "\n" + "Speed: " + Pakudex.getStats(Pakuri)[2] +"\n");
                }
            }
            else if (ans == 3){
                if(Pakudex.getSize() == capacity) {
                    System.out.println("Error: Pakudex is full!\n");
                    break;
                }
                System.out.print("Enter the name of the species to add: ");
                Pakuri = scan.next();
                if (Pakudex.addPakuri(Pakuri)){
                    System.out.println("Pakuri species "+ Pakuri +" successfully added!\n");
                }
                else if (!Pakudex.addPakuri(Pakuri)){
                    System.out.println("Error: Pakudex already contains this species!\n");
                }
            }
            else if (ans == 4){
                System.out.println("Enter the name of the species to evolve: ");
                Pakuri = scan.next();
                if(Pakudex.evolveSpecies(Pakuri)){
                    System.out.println(Pakuri + " has evolved!\n");
                }
                else if(!Pakudex.evolveSpecies(Pakuri)){
                    System.out.println("Error: No such Pakuri!\n");
                }

            }
            else if (ans == 5){
                Pakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!\n");
            }
            else if (ans == 6){
                System.out.println("Thanks for using Pakudex! Bye!");
                gameGo = false;
                break;
            }
            else{
                System.out.println("Unrecognized menu selection!\n");
            }
        }
    }
}
