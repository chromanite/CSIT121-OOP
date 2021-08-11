import java.util.*;
  
enum Zodiac {
    Aries ("ARI", "March 21", "April 19"),
    Taurus ("TAU", "April 20", "May 20"),
    Gemini ("GEM", "May 21", "June 20"),
    Cancer ("CAN", "June 21", "July 22"),
    Leo ("LEO", "July 23", "August 22"),
    Virgo ("VIR", "August 23", "September 22"),
    Libra ("LIB", "September 23", "October 22"),
    Scorpio ("SCO", "October 23", "November 21"),
    Sagittarius ("SAG", "November 22", "December 21"),
    Capricon ("CAP", "December 22", "January 19"),
    Aquarius ("AQU", "January 20", "Feburary 18"),
    Pisces ("PIS", "Feburary 19", "March 20");

    private final String aka;
    private final String sDate;
    private final String eDate;

    Zodiac(String aka, String sDate, String eDate) {
        this.aka = aka;
        this.sDate = sDate;
        this.eDate = eDate;
    }

    public String getAka() {
        return this.aka;
    }

    public String getSdate() {
        return this.sDate;
    }

    public String getEdate() {
        return this.eDate;
    }
}

class Set {
    private ArrayList<Zodiac> s;

    // To construct empty set in default constructor
    public Set() {
        this.s = new ArrayList<>();
    }

    // To do a deep copying from original arraylist to another arraylist
    public Set(Set otherSet) {
        this.s = new ArrayList<>();

        for (int i = 0; i < otherSet.s.size(); i++) {
            s.add(otherSet.s.get(i));
        }
    }

    // To return true if arraylist is empty
    public boolean isEmpty() {
        return this.s.isEmpty();
    }

    // To return number of elements in arraylist
    public int cardinality() {
        return this.s.size();
    }

    // To return true if arraylist contain specific elements
    public boolean belongToZodiac(Zodiac element) {
        return this.s.contains(element);
    }

    // To only add elements into arraylist if its not inside a Set
    public void addElement(Zodiac element) {
        if (!belongToZodiac(element)) {
            this.s.add(element);
        }
    }

    // To return true if otherSet contains all element in s
    public boolean subset(Set otherSet) {
        return otherSet.s.containsAll(s);
    }

    // To add all arraylist from s2 to s with no duplicates
    public void union(Set otherSet) {
        for (Zodiac value : otherSet.s) {
            if (!this.s.contains(value)) {
                this.s.add(value);
            }
        }
    }

    // To get common elements from 2 arraylist
    public void intersection(Set otherSet) {
        s.retainAll(otherSet.s);        
    }

    // To get different elements from 2 arrays
    public void difference(Set otherSet) {
        s.removeAll(otherSet.s);
    }
    
    // To return a set that is complement of set
    public Set complement() {
        Set setA = new Set();

        for (Zodiac value : Zodiac.values()) {
            if (!this.s.contains(value)) {
                setA.addElement(value);
            }
        }

        return setA;
    }

    // To return true if both values are true
    public boolean equality(Set otherSet) {
        return subset(otherSet) && s.containsAll(otherSet.s);
    }
    
    // To return full zodiac value 
    public String getEnumFormat() {
        String A = " = {";
        String B = "}";
        String comma = ", ";
        String result = A;

        if (s.isEmpty()) {
            A = A.concat(" ");
            result = A.concat(B);
        } else {
            for (int i = 0; i < this.s.size(); i++) {
                result = result.concat(this.s.get(i).name());
    
                if (i != (this.s.size() - 1)) {
                    result = result.concat(comma);
                } else {
                    result = result.concat(B);
                }
            }
        }
        return result;
    }

    // To return zodiac aka value
    @Override
    public String toString() {
        String A = " = {";
        String B = "}";
        String comma = ", ";
        String result = A;

        if (s.isEmpty()) {
            A = A.concat(" ");
            result = A.concat(B);
        } else {
            for (int i = 0; i < this.s.size(); i++) {
                result = result.concat(this.s.get(i).getAka());
    
                if (i != (this.s.size() - 1)) {
                    result = result.concat(comma);
                } else {
                    result = result.concat(B);
                }
            }
        }
        return result;
    }
}

public class Assignment1 {
    
    // Display zodiac info
    private static void displayZodiacInfo() {
        System.out.println("Universal set info\n");
        System.out.printf("%-15s%-15s%-15s%-15s%n", "Zodiac Sign", "Known as", "From Date", "To Date");
        
        for (Zodiac s : Zodiac.values()) {
            System.out.printf("%-15s%-15s%-15s%-15s%n", s, s.getAka(), s.getSdate(), s.getEdate());
        }
        System.out.println();
    }

    // Display mainmenu
    private static void displayMenu() {
        System.out.println("Welcome to SIM Set Theory Lesson\n");
        System.out.println("0: Properties of set");
        System.out.println("1: Union example");
        System.out.println("2: Intersection example");
        System.out.println("3: Subset example");
        System.out.println("4: Difference example");
        System.out.println("5: Complement example");
        System.out.println("6: Sets equality example");
        System.out.println("7: Distributive Law 1");
        System.out.println("9: Quit");
        System.out.println();
    }

    // Display submenu
    private static void displaySubmenu() {
        System.out.println("Some basic operations in set");
        System.out.printf("\t%s%n", "1. Add an element");
        System.out.printf("\t%s%n", "2. Check an element");
        System.out.printf("\t%s%n", "3. Cardinality");
        System.out.printf("\t%s%n", "4. Enum format");
        System.out.printf("\t%s%n", "9. Quit");
        System.out.println();
    }

    // To display example with submenu
    private static void anExample() {
        Scanner kb = new Scanner(System.in);
        Set demoA = getASet();

        System.out.println("Here is an example of set");
        System.out.println("\tA" + demoA);
        System.out.printf("\t%s%n%n", "All elements in set are distinct and random order");
        displaySubmenu();
                    
        System.out.printf("Enter your option: ");
        int subOption = kb.nextInt();
        System.out.println();
        
        while(subOption != 9) {
            switch (subOption) {
                case 1:
                    System.out.printf("Enter an element: ");

                    Zodiac zodiac = Zodiac.valueOf(kb.next());

                    demoA.addElement(zodiac);

                    System.out.printf("A%s%n", demoA);
                    System.out.println(".................................................\n");
                    break;

                case 2:
                    System.out.print("Enter an element: ");
                    
                    zodiac = Zodiac.valueOf(kb.next());

                    System.out.printf(demoA.belongToZodiac(zodiac) ? 
                    "Element %s is in set%n" : 
                    "Element %s is not in set%n", (zodiac));
                    System.out.println(".................................................\n");
                    break;

                case 3:
                    System.out.printf("No of elements in set is %s%n", demoA.cardinality());
                    System.out.println(".................................................\n");              
                    break;

                case 4:
                    System.out.println("Notation in enum format");
                    System.out.println("\t A" + demoA.getEnumFormat());
                    System.out.println(".................................................\n");    
                    break;

                case 9:
                    kb.close();
                    break;
            }
            displaySubmenu();
            System.out.printf("Enter your option: ");
            subOption = kb.nextInt();
            System.out.println();
        }
    }

    // To randomly generate 1 element 
    private static Zodiac getAnElement() {
        ArrayList<Zodiac> rng = new ArrayList<>();

        for (Zodiac value : Zodiac.values()) {
            rng.add(value);
        }

        Collections.shuffle(rng);
        return rng.get(0);
    }

    // To generate a new set  
    private static Set getASet() {
        Random rand = new Random();
        int j = rand.nextInt(12);
        Set set = new Set();

        for (int i = 0; i < j; i++) {
            Zodiac value = getAnElement();

            if (set.isEmpty()) {
                set.addElement(value);
            } else if (!set.belongToZodiac(value)) {
                set.addElement(value);
            }
        }

        return set;
    }

    // To display union example
    private static void unionExample() {
        Set setA = getASet();
        Set setB = getASet();

        System.out.println("Given sets");
        System.out.printf("\tA%s%n", setA);
        System.out.printf("\tB%s%n", setB);

        setA.union(setB);

        System.out.printf("\tUnion of A and B%s%n", setA);
        System.out.println("-----------------------------------------------\n");
    }

    // To display intersection example
    private static void intersectionExample() {
        Set setA = getASet();
        Set setB = getASet();

        System.out.println("Given sets");
        System.out.printf("\tA%s%n", setA);
        System.out.printf("\tB%s%n", setB);

        setA.intersection(setB);

        System.out.printf("\tIntersection of A and B%s%n", setA);
        System.out.println("-----------------------------------------------\n");

    }

    // To display subset example
    private static void subsetExample() {
        Set setA = getASet();
        Set setB = getASet();

        System.out.println("Given sets");
        System.out.printf("\tA%s%n", setA);
        System.out.printf("\tB%s%n", setB);
        System.out.printf("Conclusion%n");
        System.out.printf("\tA subset of B: %s%n", setA.subset(setB));
        System.out.printf("\tB subset of A: %s%n", setB.subset(setA));
        System.out.println("-----------------------------------------------\n");
    }

    // To display difference example
    private static void differenceExample() {
        Set setA = getASet();
        Set setB = getASet();

        System.out.println("Given sets");
        System.out.printf("\tA%s%n", setA);
        System.out.printf("\tB%s%n", setB);

        setA.difference(setB);

        System.out.printf("\tA - B%s%n", setA);
        System.out.println("-----------------------------------------------\n");
    }

    // To display complement example
    private static void complementExample() {
        Set setA = getASet();
        
        System.out.println("Given set");
        System.out.printf("\tA%s%n%n", setA);
        System.out.printf("\tA'%s%n", setA.complement());
        System.out.println("-----------------------------------------------\n");
    }

    // To display equality example
    private static void equalityExample() {
        Set setA = getASet();
        Set setB = getASet();

        System.out.println("Given sets");
        System.out.printf("\tA%s%n", setA);
        System.out.printf("\tB%s%n%n", setB);
        System.out.printf("Analysis%n");
        System.out.printf("\tA subset of B: %s%n", setA.subset(setB));
        System.out.printf("\tB subset of A: %s%n%n", setB.subset(setA));
        System.out.println("Conclusion");
        System.out.printf("\tA equals to B: %s%n", setA.equality(setB));
        System.out.println("-----------------------------------------------\n");
    }

    // To dispaly distributive law 
    private static void distributiveLaw() {
        Set setALHS = getASet();
        Set setARHS = new Set(setALHS);
        Set setBLHS = getASet();
        Set setBRHS = new Set(setBLHS);
        Set setCLHS = getASet();
        Set setCRHS = new Set(setCLHS);

        // Law 1
        System.out.println("We wish to prove: A U (B I C) = (A U B) I (A U C)\n");
        System.out.println("Given sets");
        System.out.printf("\tA%s%n", setALHS);
        System.out.printf("\tB%s%n", setBLHS);
        System.out.printf("\tC%s%n%n", setCLHS);

        // LHS calculation
        // B intersect C
        setBLHS.intersection(setCLHS); 
        
        // A union (B I C)
        setALHS.union(setBLHS); 

        // RHS calculation

        // A union B == B union A commutive 
        setBRHS.union(setARHS); 

        // A union C 
        setARHS.union(setCRHS); 
        setBRHS.intersection(setARHS);

        System.out.println("LHS analysis");
        System.out.printf("\tLHS %s%n%n", setALHS);
        System.out.println("RHS analysis");
        System.out.printf("\tRHS %s%n%n", setBRHS);
        System.out.println("Conclusion");
        System.out.printf("\tLHS = RHS is %s%n", setALHS.equality(setBRHS));
        System.out.println("-----------------------------------------------\n");
    }
    
    // Driver code
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // Main execution 
        displayZodiacInfo();
        displayMenu();
        System.out.printf("Your option: ");
        
        int option = kb.nextInt();
        
        System.out.println();
        
        while(option != 9) {
            switch (option) {
                
                // Display example and submenu options
                case 0:
                    anExample();   
                    break;

                // Display union example
                case 1:
                    unionExample();
                    break;

                // Display intersection example
                case 2:
                    intersectionExample();
                    break;

                // Display subset example
                case 3:
                    subsetExample();
                    break;

                // Display difference example
                case 4:
                    differenceExample();
                    break;

                // Display complement example
                case 5:                
                    complementExample();
                    break;

                // Display equality example
                case 6:
                    equalityExample();
                    break;

                // Display distributive law example
                case 7:
                    distributiveLaw();
                    break;

                case 9:
                    kb.close();
                    break;
            }

            displayMenu();
            System.out.printf("Your option: ");
            option = kb.nextInt();
            System.out.println();
        }
    } 
}
