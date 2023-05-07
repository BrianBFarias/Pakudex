public class Pakuri implements Comparable<Pakuri> {
    //blueprint to make Pakuri's
    private String species;
    private int attack, defense, speed;
    public Pakuri(String species){
        this.species = species;
        attack =(species.length() * 7) + 9  ;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13 ;

    }
    //This method should be the only constructor for this class. There should not be a default constructor!

    public String getSpecies(){
        return species;
    }
    //Returns the species of this critter

    public int getAttack(){
        return attack;
    }
    //Returns the attack value for this critter

    public int getDefense(){
        return defense;
    }
    //Returns the defense value for this critter

    public int getSpeed(){
        return speed;
    }
    //Returns the speed of this critter

    public void setAttack(int newAttack){
        this.attack = newAttack;
    }
    //Changes the attack value for this critter to newAttack

    public void evolve(){
        attack = this.attack*2;
        defense = this.defense*4;
        speed = this.speed*3;
    }
    //Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed
    public int compareTo(Pakuri target){
        return this.species.compareTo(target.species);
    }
}
