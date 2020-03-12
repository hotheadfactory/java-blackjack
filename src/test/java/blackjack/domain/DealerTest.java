package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {
    private static Stream<Arguments> generateStandardDealer() {
        return Stream.of(
                Arguments.of(new UserCards(Arrays.asList(
                        new Card(Suit.DIAMOND, Symbol.SIX),
                        new Card(Suit.HEART, Symbol.KING)
                )), true),
                Arguments.of(new UserCards(Arrays.asList(
                        new Card(Suit.CLUB, Symbol.JACK),
                        new Card(Suit.SPADE, Symbol.SEVEN)
                )), false)
        );
    }

    @Test
    @DisplayName("딜러의 이름이 \"딜러\"인지 확인")
    void checkDealerName() {
        assertThat(new Dealer().getName()).isEqualTo("딜러");
    }

    @Test
    @DisplayName("딜러가 카드를 하나만 표시하는지 확인")
    void displayDealerCardInfo() {
        UserCards userCards = new UserCards(Arrays.asList(
                new Card(Suit.SPADE, Symbol.JACK),
                new Card(Suit.DIAMOND, Symbol.THREE)
        ));
        Dealer dealer = new Dealer();
        dealer.receiveInitialCards(userCards);
        assertThat(dealer.showInitialCardInfo()).isEqualTo("딜러 카드: 스페이드 잭");
    }

    @ParameterizedTest
    @DisplayName("딜러의 카드 합이 16 이하인지 확인")
    @MethodSource("generateStandardDealer")
    void scoreUnderSixteenTest(UserCards userCards, boolean expected) {
        Dealer dealer = new Dealer();
        dealer.receiveInitialCards(userCards);
        assertThat(dealer.isUnderThreshold()).isEqualTo(expected);
    }

}
