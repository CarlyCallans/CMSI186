import java.util.HashMap;
import java.util.Map;

public class PicomonCard {

    private String name;
    private PicomonElement element;
    private int power;
    
    public PicomonCard() {
        this(getRandomElement(), getRandomPower());

    }

    public PicomonCard(PicomonElement element, int power) {
        this(getRandomName(element), element, power);
    }
    
    public PicomonCard(String name, PicomonElement element, int power) {
        if (power < 1) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.element = element;
        this.power = power;
    }
    
    public String getName() {
        return name;
    }

    public PicomonElement getElement() {
        return element;
    }
    
    public int getPower() {
        return power;
    }

    public boolean beats(PicomonCard opponent) {


        // Implement me!

        int myPower = this.getPower();
        int theirPower = opponent.getPower();

        switch (this.getElement()) {
            case FIRE:
                switch (opponent.getElement()) {
                    case WIND:
                        myPower *= 4;

                        System.out.println("MULT 4x = " + myPower);

                        break;
                }
                break;
            case WIND:
                switch (opponent.getElement()) {
                    case EARTH:
                        myPower *= 2;

                        break;

                    case WATER:
                        myPower *= 3;

                        break;
                }
            case WATER:
                switch(opponent.getElement()) {
                   case FIRE:
                        myPower *= 2;

                        break;
                    case EARTH:
                        myPower *= 2;

                        break;

                }
            case EARTH:
                switch(opponent.getElement()) {
                    case FIRE:
                        myPower *= 4;
                        System.out.println("MULT 4x = " + myPower);

                        break;
                }

        }


        boolean hasWon = this.getPower() > opponent.getPower();




        return hasWon;
    }

    @Override
    public String toString() {
        return name + " (" + element + ", " + power + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        PicomonCard other = (PicomonCard)obj;
        if ((element != other.element) || (power != other.power)) {
            return false;
        }

        // name can be null, so extra handling is needed.
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        return true;
    }

    // Advanced Java---look away, look away!
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((element == null) ? 0 : element.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + power;
        return result;
    }

    private static final Map<PicomonElement, String[]> NAMES = new HashMap<PicomonElement, String[]>();
    static {
        NAMES.put(PicomonElement.FIRE, new String[] {
            "Justin", "Anthony", "Christopher", "Jake", "Allen",
            "Anson", "Brandon", "Carly", "Geoffrey"
        });
        
        NAMES.put(PicomonElement.EARTH, new String[] {
            "Claire", "Jacqueline", "Matthew", "Jared", "Alexander",
            "Henry", "Brian", "Alondra", "Lauren"
        });
        
        NAMES.put(PicomonElement.WATER, new String[] {
            "Mary", "Sasha", "Zach", "Victor", "Anna",
            "Casey", "Scott", "Kevin", "David"
        });
        
        NAMES.put(PicomonElement.WIND,  new String[] {
            "Savannah", "Carleen", "Sean", "Mathew", "Josh",
            "Jordan", "George", "Kyle"
        });
    }

    private static String getRandomName(PicomonElement element) {
        String[] elementNames = NAMES.get(element);
        return elementNames[(int)Math.floor(Math.random() * elementNames.length)];
    }
    
    private static PicomonElement getRandomElement() {
        return PicomonElement.values()[(int)Math.floor(Math.random() * 4)];
    }

    private static int getRandomPower() {
        return (int)((Math.random() * 99) + 1);
    }



    public static void main (String [] args) {


        PicomonCard card1 = new PicomonCard("Windwoman", PicomonElement.EARTH, 10);
        System.out.println(card1.getPower());

        PicomonCard card2 = new PicomonCard("Waterperson", PicomonElement.FIRE, 12);
        System.out.println(card2.getPower());

        System.out.println(card1.beats(card2));

        System.out.println(card2.beats(card1));





    }

}
