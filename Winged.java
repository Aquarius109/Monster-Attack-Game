// Title: Winged
// Files: Winged.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Winged interface contains abstract methods that apply to Gryphon,Pheonix,
 * and Wraith subclasses.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */

public interface Winged
{
    /**
     * Changes power of winning monster if winning monster is Winged.
     * @param monster winning monster
     */
    public void strafe(Monster monster);
}