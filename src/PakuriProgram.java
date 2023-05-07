import java.util.*;
public class PakuriProgram{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //will make main loop repeat until user quits.
        boolean gameGo = true;
        //basic variables for user input
        int ans;
        String Pakuri;
        int capacity;
        System.out.print("Welcome to Pakudex: Tracker Extraordinaire!\n" +
                "Enter max capacity of the Pakudex: ");
        // this loop checks for any input error and repeats until accepted
        while(true){
            try{
                capacity = scan.nextInt();
                //repeats if input is less than 1
                if(capacity < 0){
                    System.out.println("Please enter a valid size.");
                    System.out.print("Enter max capacity of the Pakudex: ");
                    continue;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                //resets old scanner readings so that error goes away
                scan.next();
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
            //this loop does the same thing (scan for any input errors) same strategy
            while(true){
                try{
                    ans = scan.nextInt();
                    //repeats if input is less than 1
                    if(ans < 0){
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
                //checks to see if any Pakuri's have been added
                if (Pakudex.getSize() == 0){
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else {
                    //there is pakuri in array and print for loop
                    System.out.println("Pakuri In Pakudex:");
                    for(int i=0; i < Pakudex.getSize(); i++){
                        if (Pakudex.getSpeciesArray()[i] != null){
                            System.out.println((i+1)+". " + Pakudex.getSpeciesArray()[i]);
                        }
                    }
                }
                System.out.println(" ");
            }
            else if (ans == 2){
                System.out.print("Enter the name of the species to display: ");
                Pakuri = scan.next();
                // if pakuri returns null Pakuri wasn't found
                if(Pakudex.getStats(Pakuri) == null){
                    System.out.println("Error: No such Pakuri!\n");
                }
                else {
                    System.out.println("Species: " + Pakuri + "\n" + "Attack: " + Pakudex.getStats(Pakuri)[0] + "\n" + "Defense: "
                            + Pakudex.getStats(Pakuri)[1] + "\n" + "Speed: " + Pakudex.getStats(Pakuri)[2] +"\n");
                }
            }
            else if (ans == 3){
                // checks to see if capacity matches number of Pakuri's stored
                if(Pakudex.getSize() == capacity) {
                    System.out.println("Error: Pakudex is full!\n");
                    continue;
                }
                // if storage not full then read other if statements to check for repeats or add species
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
                //will call to evolve specific species
                System.out.println("Enter the name of the species to evolve: ");
                Pakuri = scan.next();
                if(Pakudex.evolveSpecies(Pakuri)){
                    System.out.println(Pakuri + " has evolved!\n");
                }
                //if Pakuri not found
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
            }
            //finds any inputs greater than 6
            else{
                System.out.println("Unrecognized menu selection!\n");
            }
        }
    }
}