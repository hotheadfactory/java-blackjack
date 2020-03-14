package blackjack.domain.card;

import java.util.Objects;

public class Card {
    public static final String BLANK = " ";
    private final Suit suit;
    private final Symbol symbol;

    public Card(Suit suit, Symbol symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    public int getScore() {
        return symbol.getScore();
    }

    public boolean isAce() {
        return this.symbol.name().equals("ACE");
    }

    @Override
    public String toString() {
        return suit.getName() +
                BLANK +
                symbol.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                symbol == card.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, symbol);
    }
}
