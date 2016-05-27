package listPackage;

/**
 * Created by 212564432 on 5/26/2016.
 */

import java.util.*;

class Deal {
    public static void main(String args[]) {

        int numHands;
        int cardsPerHand;
        if (args.length > 1){
        numHands = Integer.parseInt(args[0]);
        cardsPerHand = Integer.parseInt(args[1]);
        }else{
            numHands = 3; // jatekosok
            cardsPerHand = 2; // 1 pár lap
        }

        // Make a normal 52-card deck
        String[] suit = new String[] {"spades", "hearts", "diamonds", "clubs"};
        String[] rank = new String[] {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
        List deck = new ArrayList(); // arrayList,  a pakli
        for (int i=0; i<suit.length; i++)
            for (int j=0; j<rank.length; j++)
                deck.add(rank[j] + " of " + suit[i]);

        Collections.shuffle(deck); // arraylist keveres

        // Create a deck of cards for each player
        for (int i=0; i<numHands; i++)
            System.out.println("Cards for player #" + (i+1) + ": " + dealHand(deck, cardsPerHand));    }

    public static List dealHand(List deck, int n) {
        int deckSize = deck.size();
        System.out.println("deckSize = " + deckSize);
        // Returns "a view" of the portion of this list between the
        // specified fromIndex, inclusive, and toIndex, exclusive.
        List handView = deck.subList(deckSize-n, deckSize);
        // Create another List object from handView since we have
        // to call remove() to it.
        List hand = new ArrayList(handView);
        // Remove the deck of cards from the original list
        //handView.clear();  // This works as well instead of the line below
        deck.removeAll(hand);
        return hand;
    }
}
