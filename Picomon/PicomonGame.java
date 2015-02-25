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
        // Implement me!
        System.out.println("My deck"+ gymLeaderDeck+ "Their deck" + trainerDeck);

        System.out.println("My card" +gymLeaderCard+ "Their card"+ trainerCard);

        System.out.println("The match winner is"+ round1.winner);

        System.out.println("The full game winner is"+ fullGame);

    }

}
