// Title: Wraith
// Files: Wraith.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa
import java.util.Random;

/** 
 * The Wraith class contains methods that define a wraith monster. 
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class Wraith extends Monster
    implements Winged, Undead
{
    private final static int powerIncrement = 10;
    private final static int powerDivisor = 4;
    private final static double successValue = 0.2;
    /**
     * No-arg constructor for Wraith.
     */
    public Wraith()
    {
        super();
    }
    /**
     * Constructor for Wraith.
     * @param age age of monster
     * @param vitality vitality of monster
     * @param power power of monster
     */
    public Wraith(int age, double vitality, double power)
    {
        super(age, vitality, power);
    }
    /**
     * Increases power of calling Wraith object by a value of 10.
     */
    @Override
    public void rest()
    {
        double power = super.getPower();
        power += powerIncrement;
        super.setPower(power);
    }
    /**
     * Increases power of calling Wraith object by a quarter of inputted 
     * monster's power.
     * @param monster monster whose power is to be divided by four
     */
    @Override
    public void strafe(Monster monster)
    {
        double power = super.getPower();
        power += monster.getPower() / powerDivisor;
        super.setPower(power);
    } 
    /**
     * Will return true 20% of the time.
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