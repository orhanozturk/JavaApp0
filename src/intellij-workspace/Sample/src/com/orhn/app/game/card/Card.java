package com.orhn.app.game.card;

public class Card {
    private CardValue m_value;
    private CardType m_type;
    //...

    private static void fillDeck(Card[] deck)
    {
        int idx = 0;
        for(CardType ct : CardType.values())
            for (CardValue cv: CardValue.values()) {
                deck[idx++] = new Card(cv, ct);
            }
    }

    public static Card[]getShuffledDeck()
    {
        Card[] deck = new Card[52];

        fillDeck(deck);

        return deck;
    }

    public Card(CardValue value, CardType type)
    {
        m_value = value;
        m_type = type;
    }

    public Card(String name)
    {
        //..
    }

    public String getName()
    {
        ///..
        return "";
    }
    public void setName(String name)
    {
        //..
    }

    public String toString()
    {
        return m_type.toString() + "_" + m_value.toString();
    }
}
