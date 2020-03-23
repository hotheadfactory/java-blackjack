package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.game.Result;
import blackjack.domain.game.ScoreRule;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class User {
    protected final String name;
    protected final List<Card> cards;
    protected Money money;

    public User(String name, Money money) {
        Objects.requireNonNull(name, "name이 null일 수 없습니다");
        Objects.requireNonNull(money, "money가 null일 수 없습니다");

        this.name = name;
        this.cards = new LinkedList<>();
        this.money = money;
    }

    public User(String name, int money) {
        this(name, new Money(money));
    }

    public User(String name) {
        this(name, 0);
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveInitialCards(List<Card> initialCards) {
        Objects.requireNonNull(initialCards);
        this.cards.addAll(initialCards);
    }

    public void addMoney(Money profit) {
        this.money = this.money.add(profit);
    }

    public Money getProfit(Result result) {
        return this.money.multiply(result.getRate());
    }

    public boolean isBusted() {
        return ScoreRule.isBusted(cards);
    }

    public boolean isBlackJack() {
        return ScoreRule.isBlackjack(cards);
    }

    public int compareScore(User user) {
        return this.getTotalScore() - user.getTotalScore();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalScore() {
        return ScoreRule.calculateTotalScore(cards);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public abstract List<Card> getInitialCards();
}
