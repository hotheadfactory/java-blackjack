package blackjack.domain.card;

import blackjack.domain.user.UserCards;
import blackjack.exception.NoCardException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    private static final String DECK_IS_EMPTY = "덱이 비었습니다";
    private static final int INITIAL_CARDS = 2;

    private final LinkedList<Card> deck;

    public Deck(LinkedList<Card> cards) {
        this.deck = Objects.requireNonNull(cards);
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new NoCardException(DECK_IS_EMPTY);
        }
        return deck.poll();
    }

    public UserCards drawInitialCards() {
        return new UserCards(IntStream.of(0, INITIAL_CARDS).mapToObj(t -> this.drawCard())
                .collect(Collectors.toList()));
    }
}
