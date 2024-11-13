/*
 * In this version of the exercise we define a VideoGame subclass called
 * PCVideoGame, with its own attributes. Then, we use "super" to call
 * parent's constructor, and override "toString" method to print each
 * video game (or pc video game) in the screen. In the main program, we
 * define a VideoGame array (using polymorphism), and ask the user to
 * enter either a video game or a PC video game. The rest of the program
 * is the same than in previous version.
 */

import java.util.Scanner;

/*
 * VideoGame class
 */
class VideoGame {
    protected String title;
    protected String genre;
    protected float price;
    protected Company company;

    public VideoGame() {
        title = "";
        genre = "";
        price = 0;
    }

    public VideoGame(String t, String g, float p, Company c) {
        title = t;
        genre = g;
        price = p;
        company = c;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String g) {
        genre = g;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float p) {
        price = p;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company c) {
        company = c;
    }

    // Overriding toString method

    @Override
    public String toString() {
        return title + " (" + genre + ", " + price + " eur.)";
    }
}

/*
 * PCVideoGame subclass
 */
class PCVideoGame extends VideoGame {
    private int minimumRAM;
    private int minimumHD;

    public PCVideoGame() {
    }

    public PCVideoGame(String title, String genre, int price, Company company, int minimumRAM, int minimumHD) {
        super(title, genre, price, company);
        this.minimumRAM = minimumRAM;
        this.minimumHD = minimumHD;
    }

    public int getMinimumRAM() {
        return minimumRAM;
    }

    public void setMinimumRAM(int minimumRAM) {
        this.minimumRAM = minimumRAM;
    }

    public int getMinimumHD() {
        return minimumHD;
    }

    public void setMinimumHD(int minimumHD) {
        this.minimumHD = minimumHD;
    }

    // Overriding toString method and using "super" to call parent's
    // toString

    @Override
    public String toString() {
        return super.toString() + " " + minimumRAM + "GB, " + minimumHD + "MB";
    }
}

/*
 * Company class
 */
class Company {
    private String name;
    private int foundationYear;

    public Company(String n, int y) {
        name = n;
        foundationYear = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int y) {
        foundationYear = y;
    }
}

/*
 * Main class
 */
public class VideoGameList3 {
    public static final int MAX_VIDEOGAMES = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoGame[] games = new VideoGame[MAX_VIDEOGAMES];
        int minPos = 0, maxPos = 0, chosenCompany, chosenType;

        // Pre-defined array of companies

        Company[] companies = new Company[3];
        companies[0] = new Company("Capcom", 1987);
        companies[1] = new Company("UbiSoft", 1998);
        companies[2] = new Company("EA Sports", 1990);

        for (int i = 0; i < MAX_VIDEOGAMES; i++) {
            System.out.println("Choose the game type (1. VideoGame, 2. PC VideoGame)");
            chosenType = sc.nextInt();
            sc.nextLine();

            switch (chosenType) {
                case 2:
                    games[i] = new PCVideoGame();
                    break;
                default:
                    games[i] = new VideoGame();
                    break;
            }

            System.out.println("Enter title for videogame " + (i + 1) + ":");
            games[i].setTitle(sc.nextLine());

            System.out.println("Enter genre for videogame " + (i + 1) + ":");
            games[i].setGenre(sc.nextLine());

            System.out.println("Enter price for videogame " + (i + 1) + ":");
            games[i].setPrice(sc.nextFloat());

            // Add company to the video game

            for (int j = 0; j < companies.length; j++) {
                System.out.println((j + 1) + ". " + companies[j].getName());
            }
            System.out.println("Choose a company from the list (1 - " + companies.length + "):");
            chosenCompany = sc.nextInt();
            sc.nextLine();
            games[i].setCompany(companies[chosenCompany - 1]);

            if (chosenType == 2) {
                System.out.println("Choose the minimum RAM:");
                ((PCVideoGame) games[i]).setMinimumRAM(sc.nextInt());
                System.out.println("Choose the minimum HD:");
                ((PCVideoGame) games[i]).setMinimumHD(sc.nextInt());
            }
        }

        // Cheapest and most expensive video game

        for (int i = 1; i < MAX_VIDEOGAMES; i++) {
            if (games[i].getPrice() > games[maxPos].getPrice()) {
                maxPos = i;
            }

            if (games[i].getPrice() < games[minPos].getPrice()) {
                minPos = i;
            }
        }

        System.out.println("Cheapest videogame: " + games[minPos].getTitle());
        System.out.println("Most expensive videogame: " + games[maxPos].getTitle());
    }
}
