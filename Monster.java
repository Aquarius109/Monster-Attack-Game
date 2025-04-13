// Title: Monster
// Files: Monster.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Monster class contains methods that help define the basic properties of
 * a monster.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public abstract class Monster
{
    private int age;
    private double vitality;
    private double power;
    /**
     * No-arg default constructor for Monster class.
     */
    public Monster()
    {
        age = 0;
        vitality = 0.0;
        power = 0.0;
    }
    /**
     * Constructor for monster class.
     * @param age age value of monster
     * @param vitality vitality value of monster
     * @param power power value of monster
     */
    public Monster(int age, double vitality, double power)
    {
        this.age = age;
        this.vitality = vitality;
        this.power = power;
    }
    /**
     * Gets age of monster.
     * @return int value of age of monster
     */
    public int getAge()
    {
        return this.age;
    }
    /**
     * Gets vitality of monster.
     * @return double value of vitality of monster
     */
    public double getVitality()
    {
        return this.vitality;
    }
    /**
     * Gets power of monster.
     * @return double value of power of monster
     */
    public double getPower()
    {
        return this.power;
    }
    /**
     * Sets vitality of monster.
     * @param vitality intended vitality for monster
     */
    public void setVitality(double vitality)
    {
        this.vitality = vitality;
    }
    /**
     * Sets power of monster.
     * @param power intended power of monster
     */
    public void setPower(double power)
    {
        this.power = power;
    }
    /**
     * Checks if an object belongs to the same monster subclass as the given
     * monster object.
     * @param monster monster object to be compared to calling object
     * @return a boolean value
     */
    public boolean sameSpecies(Monster monster)
    {
        String objectName = this.getClass().getName();
        String monsterName = monster.getClass().getName();
        if(objectName.equals(monsterName))
        {
            return true;
        }
        return false;
    }
    /**
     * Changes vitality value of a monster object depending on random attack
     * value.
     * @param monster monster whose vitality is being changed
     * @return the double value of the randomly generated attack value
     */
    public double attack(Monster monster)
    {
        double randValue = Math.random();
        double scaledValue = randValue * this.getPower();
        double monsterVitality = monster.getVitality();
        monsterVitality -= scaledValue;
        monster.setVitality(monsterVitality);
        return scaledValue;
    }
    /**
     * Prints string representation of a monster object.
     * @return a string value
     */
    @Override
    public String toString()
    {
        return "(" + getClass().getName() + ")" + " age: " + getAge() +
            "; vitality: " + getVitality() + "; power: " + getPower();
    }
    /**
     * Method to be overridden in subclasses.
     */
    public abstract void rest();
}