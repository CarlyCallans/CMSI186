import java.util.HashMap;
import java.util.Map;


public class PicomonDeck {

    private PicomonCard[] cards;
    
    public PicomonDeck() {
        // Note how the default deck thus has 10 cards.
        this(new PicomonCard[] {
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard(),
            new PicomonCard()
        });
    }

    public PicomonDeck(PicomonCard... cards) {
        this.cards = cards;     
    }

    public PicomonCard cardAt(int index) {
        if (index < 0 || index > cards.length - 1) {
            throw new IllegalArgumentException();
        } else {
            return cards[index];
        }
    }

    public int getSize() {
        return cards.length;
    }

    public void shuffle() {
        int i =0;
        PicomonCard[] half1;
        PicomonCard[] half2;

        if (this.getSize() % 2 == 0){
            half1 = new PicomonCard[this.getSize()/2];
            half2 = new PicomonCard[this.getSize()/2];
        
            for(i=0;i < this.getSize()/2; i++){
                half1[i] = this.cards[i];

            }
            for (i=this.getSize()/2; i < this.getSize(); i++){
                half2[i - this.getSize()/2] = this.cards[i];
            }

        } else {
            half1 = new PicomonCard[this.getSize()/2];
            half2 = new PicomonCard[this.getSize()/2 +1];

            for(i=0;i < this.getSize()/2; i++){
                half1[i] = this.cards[i];

            }
            for (i=this.getSize()/2; i < this.getSize(); i++){
                half2[i - this.getSize()/2] = this.cards[i];
            }
        }   

        for (i=0; i < this.cards.length; i++){
            if(i%2==0){
                this.cards[i] = half2[i/2];
            }else{
                this.cards[i] = half1[(i-1)/2];            
            }

        }

    }

    public boolean orderedEquals(PicomonDeck other) {
        int i=0;
        if(this.getSize() == other.getSize()){
            for(;i < this.getSize(); i++){
                if(!(this.cardAt(i).equals(other.cardAt(i)))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "[\n";
        for (PicomonCard card: cards) {
            result += "    ";
            result += card;
            result += "\n";
        }
        return result + "]";
    }

    // Advanced Java---study with caution.
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

        PicomonDeck other = (PicomonDeck)obj;
        return tally().equals(other.tally());
    }

    private Map<PicomonCard, Integer> tally() {
        Map<PicomonCard, Integer> result = new HashMap<PicomonCard, Integer>();
        for (PicomonCard card: cards) {
            Integer value = result.get(card);
            if (value == null) {
                result.put(card, 1);
            } else {
                result.put(card, value + 1);
            }
        }
        
        return result;
    }
    public static void main (String [] args) {
        System.out.println("hi");
    }

}
