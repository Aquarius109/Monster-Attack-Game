// Title: Phoenix
// Files: Phoenix.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Phoenix class contains methods that define a phoenix monster. 
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class Phoenix extends Monster
    implements Winged
{
    private final static int powerIncrement = 15;
    private final static int powerDivisor = 3;
    /**
     * No-arg constructor for Phoenix.
     */
    public Phoenix()
    {
        super();
    }
    /**
     * Constructor for Phoenix.
     * @param age age of monster
     * @param vitality vitality of monster
     * @param power power of monster
     */
    public Phoenix(int age, double vitality, double power)
    {
        super(age, vitality, power);
    }
    /**
     * Increases power of calling Phoenix object by a value of 15.
     */
    @Override
    public void rest()
    {
        double power = super.getPower();
        power += powerIncrement;
        super.setPower(power);
    }
    /**
     * Increases power of calling Phoenix object by half of inputted monster's
     * power.
     * @param monster monster whose power is to be divided by two
     */
    @Override
    public void strafe(Monster monster)
    {
        double power =  super.getPower();
        power += monster.getPower() / powerDivisor;
        super.setPower(power);
    }       
}