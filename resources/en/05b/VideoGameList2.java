/*
 * In this version of the exercise, we add a Company class, so that each
 * VideoGame has a Company, and we specify the company of each video
 * game through the corresponding attribute in the constructor, or the
 * setter in VideoGame class. The main program is almost the same than in 
 * previous version, but we set a pre-defined array of companies at the 
 * beginning, and ask the user to choose a company from the list for each
 * video game.
 * 
 * We could also ask the user to enter company's data while adding the
 * video game, but this way we may add the same company more than once, 
 * instead of choosing the same object from the array. 
 */ 
import java.util.Scanner;

/*
 * Company class
 */ 
class Company
{
    private String name;
    private int foundationYear;
    
    public Company(String n, int y)
    {
        name = n;
        foundationYear = y;
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
}

/*
 * VideoGame class
 */ 
class VideoGame
{
    private String title;
    private String genre;
    private float price;
    private Company company;
    
    public VideoGame()
    {
        title = "";
        genre = "";
        price = 0;
    }
    
    public VideoGame(String t, String g, float p, Company c)
    {
        title = t;
        genre = g;
        price = p;
        company = c;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String t)
    {
        title = t;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public void setGenre(String g)
    {
        genre = g;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public void setPrice(float p)
    {
        price = p;
    }
    
    public Company getCompany()
    {
        return company;
    }
    
    public void setCompany(Company c)
    {
        company = c;
    }
}

/*
 * Main class
 */ 
public class VideoGameList2
{
    public static final int MAX_VIDEOGAMES = 5;
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        VideoGame[] games = new VideoGame[MAX_VIDEOGAMES];
        int chosenCompany;
        
        // Pre-defined array of companies
        
        Company[] companies = new Company[3];
        companies[0] = new Company("Capcom", 1987);
        companies[1] = new Company("UbiSoft", 1998);
        companies[2] = new Company("EA Sports", 1990);
        
        for(int i = 0; i < MAX_VIDEOGAMES; i++)
        {
            games[i] = new VideoGame();
            
            System.out.println("Enter title for videogame " + (i+1) + ":");
            games[i].setTitle(sc.nextLine());
            
            System.out.println("Enter genre for videogame " + (i+1) + ":");
            games[i].setGenre(sc.nextLine());

            System.out.println("Enter price for videogame " + (i+1) + ":");
            games[i].setPrice(sc.nextFloat());
            
            // Add company to the video game
            
            for (int j = 0; j < companies.length; j++)
            {
				System.out.println((j+1) + ". " + companies[j].getName());
			}
			System.out.println("Choose a company from the list (1 - " + 
				companies.length + "):");
            chosenCompany = sc.nextInt();
            sc.nextLine();
            games[i].setCompany(companies[chosenCompany - 1]);
        } 
        
        // Cheapest and most expensive video game
        
		int minPos = 0, maxPos = 0;
        
        for (int i = 1; i < MAX_VIDEOGAMES; i++)
        {
            if (games[i].getPrice() > games[maxPos].getPrice())
            {
                maxPos = i;
            }
            
            if (games[i].getPrice() < games[minPos].getPrice())
            {
                minPos = i;
            }
        }
        
        System.out.println("Cheapest videogame: " + games[minPos].getTitle());
        System.out.println("Company of cheapest videogame: " + 
			games[minPos].getCompany().getName());

        System.out.println("Most expensive videogame: " + games[maxPos].getTitle());
        System.out.println("Company of most expensive videogame: " + 
			games[maxPos].getCompany().getName());
    }
}



