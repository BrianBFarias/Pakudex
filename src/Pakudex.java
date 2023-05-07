import java.util.Arrays;
public class Pakudex {
    private int size;
    private int capacity;
    //Pakuri array will be stored in here
    private Pakuri[] speciesArray;
    public Pakudex(){
        this.capacity = 20;
        this.speciesArray = new Pakuri[capacity];
    }
    //Default constructor; if called, the default size for the Pakudex should be 20

    public Pakudex(int capacity){
        this.capacity = capacity;
        this.speciesArray = new Pakuri[capacity];
    }
    //Initializes this object to contain exactly capacity objects when completely full

    public int getSize(){
        this.size=0;
        //for lop runs through Pakuri array
        for (int i= 0; i<speciesArray.length; i++){
            if(speciesArray[i] != null){
                size++;
            }
        }
        return size;
    }
    //Returns the number of critters currently being stored in the Pakudex
    public int getCapacity(){
        return capacity;
    }
    //Returns the number of critters that the Pakudex has the capacity to hold at most
    public String[] getSpeciesArray(){
        // temp srting to store the string that will be returned
        String[] ans = new String[getSize()];
        if(getSize()>0){
            for (int i =0; i<capacity; i++){
                if (speciesArray[i] != null) {
                    ans[i] = speciesArray[i].getSpecies();
                }
            }
        }
        //if there are no Pakuri's saved then return null
        else{
            return null;
        }
        return ans;
    }
    //Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species added yet, this method should return null

    public int[] getStats(String species){
        int [] ans = null;
        for (int i= 0; i<speciesArray.length; i++){
            if(speciesArray[i] != null) {
                if (speciesArray[i].getSpecies().equals(species)){
                    ans = new int[3];
                    ans[0] = speciesArray[i].getAttack();
                    ans[1] = speciesArray[i].getDefense();
                    ans[2] = speciesArray[i].getSpeed();
                }
            }
        }
        return ans;
    }
    //Returns  an  int  array  containing  the  attack,  defense,  and  speed  statistics  of  species  at  indices  0,  1,  and  2 respectively; if species is not in the Pakudex, returns null
    public void sortPakuri(){
        if(getSize()>0) {
            Arrays.sort(speciesArray,0,getSize());
        }
    }
    //Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name

    public boolean addPakuri(String species){
        boolean ans= false;
        //loop through Pakuri array
        for (int i= 0; i<speciesArray.length; i++){
                if (speciesArray[i] == null) {
                    speciesArray[i] = new Pakuri(species);
                    ans= true;
                    break;
                }
                else if(speciesArray[i].getSpecies().equals(species)){
                    ans = false;
                    break;
                }
        }
        return ans;
    }
    //Adds species to the Pakudex; if successful, return true, and false otherwise

    public boolean evolveSpecies(String species){
        boolean ans= false;
        //boolean initially set false until desired species found
        for (int i= 0; i<speciesArray.length; i++){
            if(speciesArray[i] != null) {
                if (speciesArray[i].getSpecies().equals(species)) {
                    speciesArray[i].evolve();
                    ans = true;
                }
            }
        }
        return ans;
    }
    //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
}