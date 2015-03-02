public class PicomonGame {

    public enum Player {
        GYM_LEADER("Gym leader"), TRAINER("Trainer");
        
        private String representation;
        private Player(String representation) {
            this.representation = representation;
        }

        @Override
        public String toString() {
            return representation;
        }
    }

    public class Round {
        public Player winner; // null if tied.
        public PicomonCard gymLeaderCard;
        public PicomonCard trainerCard;
        
        public Round(PicomonCard gymLeaderCard, PicomonCard trainerCard) {
            this.gymLeaderCard = gymLeaderCard;
            this.trainerCard = trainerCard;
        }

        @Override
        public String toString() {
            if (winner == null) {
                return "It's a tie between " + Player.GYM_LEADER + "'s " + gymLeaderCard + " and " +
                        Player.TRAINER + "'s " + trainerCard + "!";
            } else {
                Player loser = winner == Player.GYM_LEADER ? Player.TRAINER : Player.GYM_LEADER;
                PicomonCard winningCard = winner == Player.GYM_LEADER ? gymLeaderCard : trainerCard;
                PicomonCard losingCard = winner == Player.GYM_LEADER ? trainerCard : gymLeaderCard;
                return winner + "'s " + winningCard + " beats " + loser + "'s " + losingCard + "!";
            }
        }
    }

    private PicomonDeck gymLeaderDeck;
    private PicomonDeck trainerDeck;
    private int gymLeaderPosition;
    private int trainerPosition;
    
    public PicomonGame() {
        this(new PicomonDeck(), new PicomonDeck());
    }
    
    public PicomonGame(PicomonDeck gymLeaderDeck, PicomonDeck trainerDeck) {
        if (gymLeaderDeck.getSize() != trainerDeck.getSize()) {
            throw new IllegalArgumentException();
        }

        gymLeaderPosition = 0;
        trainerPosition = 0;
        this.gymLeaderDeck = gymLeaderDeck;
        this.trainerDeck = trainerDeck;
    }
    
    public PicomonDeck getGymLeaderDeck() {
        return gymLeaderDeck;
    }
    
    public PicomonDeck getTrainerDeck() {
        return trainerDeck;
    }

    public boolean isMatchOver() {
        // Implement me!
        return gymLeaderDeck.getSize() == gymLeaderPosition || trainerDeck.getSize() == trainerPosition;
    }
    
    public Player getLeader() {
        if (gymLeaderPosition < trainerPosition){
            return Player.GYM_LEADER;
        } else if (trainerPosition < gymLeaderPosition){
            return Player.TRAINER;
        } else {
        return null;
        }
    }
    
    public Round playRound() {
        Round round1 = new Round( gymLeaderDeck.cardAt(gymLeaderPosition), trainerDeck.cardAt(trainerPosition));
        if (round1.gymLeaderCard.beats(round1.trainerCard)){
            round1.winner = Player.GYM_LEADER;
            trainerPosition++;
        } else if (round1.trainerCard.beats(round1.gymLeaderCard)){
            round1.winner = Player.TRAINER;
            gymLeaderPosition++;
        }else {
            trainerPosition++;
            gymLeaderPosition++;
            round1.winner = null;
        }
        return round1;
    }

    public Round[] playMatch() {
        // Implement me!
        Round[] potentialFullGame = new Round[gymLeaderDeck.getSize() + trainerDeck.getSize()];
        int roundsPlayed;
        for(roundsPlayed = 0; !isMatchOver(); roundsPlayed++){
            potentialFullGame[roundsPlayed] = this.playRound();

        }
        Round[] fullGame = new Round[roundsPlayed + 1];
        for(;roundsPlayed >= 0;roundsPlayed--){
            fullGame[roundsPlayed] = potentialFullGame[roundsPlayed];
        }
        return fullGame;
    }

    public static void main(String[] args) {
        try{
            PicomonGame ourGame;
            if (args.length == 0){
                ourGame = new PicomonGame();
                Round[] rounds = ourGame.playMatch();
                for (int i = 0; i < rounds.length; i++){
                    System.out.println(rounds[i]);
                }

            }else {


                PicomonElement e = PicomonElement.WIND;


                PicomonCard[] cards = new PicomonCard[args.length/2];

                for(int i = 0; i < args.length; i++){
                    //System.out.println(args[i]);
                    if(i % 2 == 0){
                        System.out.println(args[i]);

                        String element = args[i];
                        switch (element) {
                            case "fire":
                                //System.out.println("case fire = " + element);
                                e = PicomonElement.FIRE;
                                



                                break;
                            case "earth":
                                //System.out.println("case earth = " + element);
                                
                                e = PicomonElement.EARTH;

                                break;
                            case "water":
                                //System.out.println("case water = " + element);

                                e =PicomonElement.WATER;

                                break;
                            case "wind":
                                //System.out.println("case wind = " + element);

                                e = PicomonElement.WIND;

                                break;

                            default:
                                throw new Exception();

                        }


                    } else {
                        int power = Integer.parseInt(args[i]);



                        PicomonCard c = new PicomonCard(e,power);
                        System.out.println(c);
                    

                        cards[(i-1)/2] = c;


                    }



                }


                PicomonDeck d1 = new PicomonDeck(cards);
                System.out.println(d1);

                PicomonDeck d2 = new PicomonDeck(cards);
                System.out.println(d2);
                System.out.println(Math.random()*100);
                int random = (int)(Math.random()*100);
                System.out.println(random);


                for(int i = 0; i < random; i++){
                    d1.shuffle();

                }


                random = (int)(Math.random()*10);
                System.out.println(random);
                for(int i = 0; i < random; i++){
                    
                    d2.shuffle();
                    System.out.println(d2);
                }
                System.out.println(d1);
                System.out.println(d2);

                PicomonGame g = new PicomonGame(d1,d2);
                Round[] rounds = g.playMatch();
                for (int i = 0; i < rounds.length; i++){
                    System.out.println(rounds[i]);
                }




            }
    

        } catch (Exception e){
            System.err.println("Cannot create a deck based on the supplied arguments.");


        }
     

    }

}
