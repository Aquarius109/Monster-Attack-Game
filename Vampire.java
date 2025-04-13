// Title: Vampire
// Files: Vampire.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa
import java.util.Random;

/** 
 * The Vampire class contains methods that define a vampire monster. 
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class Vampire extends Monster
    implements Shapeshifter, Undead
{
    private final static int powerIncrement = 15;
    private final static double successValue = 0.4;
    /**
     * No-arg constructor for Vampire.
     */
    public Vampire()
    {
        super();
    }
    /**
     * Constructor for Vampire.
     * @param age age of monster
     * @param vitality vitality of monster
     * @param power power of monster
     */
    public Vampire(int age, double vitality, double power)
    {
        super(age, vitality, power);
    }
    /**
     * Increases power of calling Vampire object by a value of 15.
     */
    @Override
    public void rest()
    {
        double power = super.getPower();
        power += powerIncrement;
        super.setPower(power);
    }
    /**
     * The calling Vampire object's power is changed by twofold. 
     */
    @Override
    public void transform()
    {
        double power = super.getPower();
        power += power;
        super.setPower(power);
    }
    /**
     * Will return true 40% of the time.
     * @return a boolean value 
     */
    @Override
    public boolean drainLife()
    {
        Random randomObject = new Random();
        double randValue = randomObject.nextDouble();
        if(randValue == successValue)
        {
            return true;
        }
        return false;
    }       
}