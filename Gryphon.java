// Title: Gryphon
// Files: Gryphon.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Gryphon class contains methods that define a gryphon monster.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class Gryphon extends Monster
    implements Winged
{
    private final static int powerIncrement = 20;
    private final static int powerDivisor = 2;
    /**
     * No-arg constructor for Gryphon.
     */
    public Gryphon()
    {
        super();
    }
    /**
     * Constructor for Gryphon.
     * @param age age of monster
     * @param vitality vitality of monster
     * @param power power of monster
     */
    public Gryphon(int age, double vitality, double power)
    {
        super(age, vitality, power);
    }
    /**
     * Increases power of calling Gryphon object by a value of 20.
     */
    @Override
    public void rest()
    {
        double power = super.getPower();
        power += powerIncrement;
        super.setPower(power);
    }
    /**
     * Increases power of calling Gryphon object by half of inputted monster's
     * power.
     * @param monster monster whose power is to be divided by two
     */
    @Override
    public void strafe(Monster monster)
    {
        double power = super.getPower();
        power += monster.getPower() / powerDivisor;
        super.setPower(power);
    }       
}