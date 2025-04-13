// Title: Undead
// Files: Undead.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Undead interface contains abstract methods that apply to Wraith and 
 * Vampire subclasses.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */

public interface Undead
{
    /**
     * Most likely drains life from winning monster if losing monster is an 
     * undead object.
     * @return a boolean value 
     */
    public boolean drainLife();
}