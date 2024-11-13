/*
 * In this exercise, we define a Team class with some attributes,
 * constructor and getters/setters. Also, we define a Player class and a
 * Captain subclass. 
 * In the main program we create a Team object along with its players,
 * including a Captain, and show all the information
 */ 
import java.util.Scanner;

/*
 * Player class
 * Now the attributes are protected because it's a superclass
 */
class Player
{
	protected String name;
	protected int age;
	protected int number;
	
	public Player(String n, int a, int bn)
	{
		name = n;
		age = a;
		number = bn;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int a)
	{
		age = a;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setNumber(int bn)
	{
		number = bn;
	}
} 

/*
 * Captain class
 */
class Captain extends Player
{
	private int experience;
	
	public Captain(String n, int a, int bn, int e)
	{
		super(n, a, bn);
		experience = e;
	}
	
	public int getExperience()
	{
		return experience;
	}
	
	public void setExperience(int e)
	{
		experience = e;
	}	
} 

/*
 * Team class
 */ 
class Team
{
    private String name;
    private int foundationYear;
    private Player[] players;
    
    public Team(String n, int y, Player[] p)
    {
		name = n;
		foundationYear = y;
		players = p;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public int getFoundationYear()
    {
        return foundationYear;
    }
    
    public void setFoundationYear(int y)
    {
        foundationYear = y;
    }    
    
    public Player[] getPlayers()
    {
		return players;
	}
	
	public void setPlayers(Player[] p)
	{
		players = p;
	}
}

/*
 * Main class
 */
public class TeamsExample3
{    
    public static void main(String[] args)
    {
		// First, we create the players
		Player[] players = new Player[5];
		players[0] = new Player("John Snow", 33, 7);
		players[1] = new Player("Peter Griffin", 35, 6);
		players[2] = new Captain("Homer Simpson", 30, 2, 5);
		players[3] = new Player("Maggie Simpson", 3, 5);
		players[4] = new Player("Fry Fansworth", 24, 9);
		
		// Then, we create the team with the players in it
		Team t = new Team("Java F.C.", 1995, players);
		
        System.out.println(t.getName());
        System.out.println(t.getFoundationYear());
        // We use some kind of "foreach" structure to explore players
        for (Player p: t.getPlayers())
        {
			System.out.print(p.getNumber() + ". ");
			if (p instanceof Captain)
				System.out.println(p.getName() + " (Captain)");
			else
				System.out.println(p.getName());
		}
    }
}


