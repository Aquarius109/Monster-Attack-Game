// Title: Werewolf
// Files: Werewolf.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Werewolf class contains methods that define a werewolf monster. 
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class Werewolf extends Monster
    implements Shapeshifter
{
    private final static int powerIncrement = 15;
    private final static int MAX_VALUE = 25;
    /**
     * No-arg constructor for Werewolf.
     */
    public Werewolf()
    {
        super();
    }
    /**
     * Constructor for Werewolf.
     * @param age age of monster
     * @param vitality vitality of monster
     * @param power power of monster
     */
    public Werewolf(int age, double vitality, double power)
    {
        super(age, vitality, power);
    }
    /**
     * Increases power of calling Werewolf object by a value of 15.
     */
    @Override
    public void rest()
    {
        double power = super.getPower();
        power += powerIncrement;
        super.setPower(power);
    }
    /**
     * The calling Werewolf object's power is randomly changed. 
     */
    @Override
    public void transform()
    {
        double power = super.getPower();
        double randValue = Math.random();
        double scaledValue = randValue * MAX_VALUE;
        power += scaledValue;
        super.setPower(power);
    }       
}