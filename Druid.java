// Title: Druid
// Files: Druid.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Druid class contains methods that define a druid monster. 
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class Druid extends Monster
    implements Shapeshifter
{
    private final static int powerIncrement = 10;
    private final static int MAX_VALUE = 40;
    /**
     * No-arg constructor for Druid.
     */
    public Druid()
    {
        super();
    }
    /**
     * Constructor for Druid.
     * @param age age of monster
     * @param vitality vitality of monster
     * @param power power of monster
     */
    public Druid(int age, double vitality, double power)
    {
        super(age, vitality, power);
    }
    /**
     * Increases power of calling Druid object by a value of 10.
     */
    @Override
    public void rest()
    {
        double power = super.getPower();
        power += powerIncrement;
        super.setPower(power);
    }
    /**
     * The calling Druid object's power is randomly changed. 
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