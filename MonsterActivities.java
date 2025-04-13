// Title: MonsterActivities
// Files: MonsterActivities.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The MonsterActivities class contains methods that create game setup. 
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */

public class MonsterActivities
{
    // Necessary constants
    private final static int divisor = 2;
    private final static int SEC_MONSTER = 2;
    private final static int NUM_MONSTERS = 6;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";
    private final static double babyVitality = 100.0;
    private final static int ageMax = 5;
    /**
     * No-arg constructor.
     */
    private MonsterActivities()
    {
    }

    /* Below are helper methods to make fight() work */

    /**
    * Use this method in fight() to display the stats of both monsters together
    * @param monster1 Monster on the left side to display stats
    * @param monster2 Monster on the right side to display stats
    */
    public static void printBothMonsters(Monster monster1, Monster monster2) 
    {
        int ageSpacing = calcSpacing(Integer.toString(monster1.getAge()));
        int healthSpacing = calcSpacing(
            String.format("%.2f",monster1.getVitality()));
        int strSpacing = calcSpacing(
            String.format("%.2f",monster1.getPower()));
        int monsterSpacing = calcSpacing(monster1.getClass().getName());
        String str = String.format( "(%s) %s (%s)\n" +
            "----------" + " " + "----------\n" +
            "A: %d %s A: %d\n" +
            "V: %.2f %s V: %.2f\n" +
            "P: %.2f %s P: %.2f\n", monster1.getClass().getName(),
            " ".repeat(monsterSpacing),monster2.getClass().getName(),
            monster1.getAge()," ".repeat(ageSpacing),monster2.getAge(),
            monster1.getVitality(), " ".repeat(healthSpacing),
            monster2.getVitality(), monster1.getPower(),
            " ".repeat(strSpacing), monster2.getPower()
        );
        System.out.println(str);
    }
    /**
    * Helper method for printBothMonsters()
    * @param str String on the left - used to calculate spacing
    * @return An int describing how many spaces to put between strings
    */
    public static int calcSpacing(String str) 
    {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) 
        {
            return 0;
        }
        return spacing;
    }
    /**
    * Use this method in fight() to display the current round.
    * @param round An int of the round (should start at 0)
    */
    public static void printRound(int round) 
    {
        System.out.println();
        System.out.println("Round " + round + ":");
    }
    /**
    * Use this method in fight() to display the damage each round.
    * @param side The side of the Monster that invoked the attack().
    * @param damage The int (damage) returned from an attack() call
    */
    public static void printAttack(String side, double damage) 
    {
        System.out.printf("%s does %.2f damage!\n",side, damage);
    }
    /**
    * Use this method in fight() to display final stats and drain status.
    *
    * @param monster1 Left monster
    * @param monster2 Right monster
    * @param drained If either monster was drained
    */
    public static void printFinalStats(Monster monster1, Monster monster2,
        boolean drained) 
    {
        System.out.println();
        printBothMonsters(monster1, monster2);
        if(drained) 
        {
            System.out.println("An monster was drained.");
        }
    }
    /**
    * Use this method in fight() to display a tie game.
    */
    public static void printTieGame() 
    {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both monsters died!");
    }
    /**
    * Use this method in fight() to display the winner.
    * @param side The side of the Monster that won.
    */
    public static void printWinner(String side) 
    {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " monster wins!");
    }
    /**
     * Lets two monsters fight and returns result.
     * @param monster1 first monster in fight
     * @param monster2 second monster in fight
     * @return int value representing victory or failure of either monster
     */
    public static int fight(Monster monster1, Monster monster2)
    {
        int round = 0;
        boolean drained1 = false;
        boolean drained2 = false;
        boolean drained = false;
        if(monster1 instanceof Wraith)
        {
            drained1 = ((Wraith)monster1).drainLife();
        }
        else if(monster1 instanceof Vampire)
        {
            drained1 = ((Vampire)monster1).drainLife();
        }

        if(monster2 instanceof Wraith)
        {
            drained2 = ((Wraith)monster2).drainLife();
        }
        else if(monster2 instanceof Vampire)
        {
            drained2 = ((Vampire)monster2).drainLife();
        }

        if(drained1 == true && drained2 == true)
        {
            drained = true;
        }
        if(drained1 == true && drained2 == false)
        {
            drained = true;
        }
        if(drained1 == false && drained2 == false)
        {
            drained = false;
        }
        if(drained1 = false && drained2 == true)
        {
            drained = true;
        }

        while(monster1.getVitality() > 0 && monster2.getVitality() > 0)
        {
            MonsterActivities.printRound(round);
            MonsterActivities.printBothMonsters(monster1, monster2);
            MonsterActivities.printAttack(LEFT, monster1.attack(monster2));
            MonsterActivities.printAttack(RIGHT, monster2.attack(monster1));
            round++;
        }

        MonsterActivities.printFinalStats(monster1, monster2, drained);

        if(monster1.getVitality() <= 0 && monster2.getVitality() <= 0)
        {
            MonsterActivities.printTieGame();
            return 0;
        }
        if(monster1.getVitality() > 0)
        {
            if(drained2 == true)
            {
                MonsterActivities.printTieGame();
                return 0;
            }
            else if(monster1 instanceof Gryphon)
            {
                ((Gryphon)monster1).strafe(monster2);
                MonsterActivities.printWinner(LEFT);
                return 1;
            }
            else if(monster1 instanceof Phoenix)
            {
                ((Phoenix)monster1).strafe(monster2);
                MonsterActivities.printWinner(LEFT);
                return 1;
            }
            else if(monster1 instanceof Wraith)
            {
                ((Wraith)monster1).strafe(monster2);
                MonsterActivities.printWinner(LEFT);
                return 1;
            }
            else if(monster1 instanceof Druid)
            {
                ((Druid)monster1).transform();
                MonsterActivities.printWinner(LEFT);
                return 1;
            }
            else if(monster1 instanceof Werewolf)
            {
                ((Werewolf)monster1).transform();
                MonsterActivities.printWinner(LEFT);
                return 1;
            }
            else if(monster1 instanceof Vampire)
            {
                ((Vampire)monster1).transform();
                MonsterActivities.printWinner(LEFT);
                return 1;
            }
        }

        if(monster2.getVitality() > 0)
        {
            if(drained1 == true)
            {
                MonsterActivities.printTieGame();
                return 0;
            }
            else if(monster2 instanceof Gryphon)
            {
                ((Gryphon)monster2).strafe(monster1);
                MonsterActivities.printWinner(RIGHT);
                return SEC_MONSTER;
            }
            else if(monster2 instanceof Phoenix)
            {
                ((Phoenix)monster2).strafe(monster1);
                MonsterActivities.printWinner(RIGHT);
                return SEC_MONSTER;
            }
            else if(monster2 instanceof Wraith)
            {
                ((Wraith)monster2).strafe(monster1);
                MonsterActivities.printWinner(RIGHT);
                return SEC_MONSTER;
            }
            else if(monster2 instanceof Druid)
            {
                ((Druid)monster2).transform();
                MonsterActivities.printWinner(RIGHT);
                return SEC_MONSTER;
            }
            else if(monster2 instanceof Werewolf)
            {
                ((Werewolf)monster2).transform();
                MonsterActivities.printWinner(RIGHT);
                return SEC_MONSTER;
            }
            else if(monster2 instanceof Vampire)
            {
                ((Vampire)monster2).transform();
                MonsterActivities.printWinner(RIGHT);
                return SEC_MONSTER;
            }
        }
        return 0;
    }
    /**
     * Produces a baby monster given two monsters belonging to same species.
     * @param monster1 first parent monster
     * @param monster2 second parent monster
     * @return baby monster object
     */
    public static Monster reproduce(Monster monster1, Monster monster2)
    {
        double power1 = monster1.getPower();
        double power2 = monster2.getPower();
        double avgPower = (power1 + power2) / divisor;

        if(monster1.getAge() > ageMax && monster2.getAge() > ageMax)
        {
            if(monster1.sameSpecies(monster2))
            {
                if(monster1 instanceof Gryphon)
                {
                    Gryphon babyGryphon = new Gryphon(0,babyVitality,
                        avgPower/divisor);
                    return babyGryphon;
                }
                if(monster1 instanceof Phoenix)
                {
                    Phoenix babyPhoenix = new Phoenix(0,babyVitality,
                        avgPower/divisor);
                    return babyPhoenix;
                }
                if(monster1 instanceof Druid)
                {
                    Druid babyDruid = new Druid(0,babyVitality,
                        avgPower/divisor);
                    return babyDruid;
                }
                if(monster1 instanceof Werewolf)
                {
                    Werewolf babyWolf = new Werewolf(0,babyVitality,
                        avgPower/divisor);
                    return babyWolf;
                }
                if(monster1 instanceof Vampire)
                {
                    Vampire babyVamp = new Vampire(0, babyVitality,
                        avgPower/divisor);
                    return babyVamp;
                }
                if(monster1 instanceof Wraith)
                {
                    Wraith babyWraith = new Wraith(0,babyVitality,
                        avgPower/divisor);
                    return babyWraith;
                }
            }
        }
        return null;
    }
}