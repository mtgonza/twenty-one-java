/*
Name: Michael Gonzalez
Email: michael.t.gonza@gmail.com
Date: 12/19/2022
Project Name: Final_Gonzalez_Michael
Course: CS17.11
Description: The class public class Card creates a Card object representative of
a playing card from a standard 52-card deck.  Each Card object has four private
final data members: Image cardFront, Image cardBack, String cardName, and int[]
cardValue.  The class also contains getters for each data member.
*/

package edu.srjc.gonzalez.michael.final_gonzalez_michael;

import javafx.scene.image.Image;

public class Card
{
    private final Image cardFront;
    private final Image cardBack;
    private final String cardName;
    private final int[] cardValue;


    public Card(String cardName, Image cardFront, Image cardBack)
    {
        this.cardName = cardName;
        this.cardFront = cardFront;
        this.cardBack = cardBack;

        if (this.cardName.equals("ace"))
        {
            this.cardValue = new int[2];
            this.cardValue[0] = 11;
            this.cardValue[1] = 1;
        }
        else if (this.cardName.equals("two"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 2;
        }
        else if (this.cardName.equals("three"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 3;
        }
        else if (this.cardName.equals("four"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 4;
        }
        else if (this.cardName.equals("five"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 5;
        }
        else if (this.cardName.equals("six"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 6;
        }
        else if (this.cardName.equals("seven"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 7;
        }
        else if (this.cardName.equals("eight"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 8;
        }
        else if (this.cardName.equals("nine"))
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 9;
        }
        else
        {
            this.cardValue = new int[1];
            this.cardValue[0] = 10;
        }
    }

    // region Getters
    public Image getCardFront()
    {
        return cardFront;
    }

    public Image getCardBack()
    {
        return cardBack;
    }

    public String getCardName()
    {
        return cardName;
    }

    public int getCardValue(int cardTotal)
    {
        if (this.cardName.equals("ace") && cardTotal > 10)
        {
            return cardValue[1];
        }
        else
        {
            return cardValue[0];
        }
    }
    // endregion
}
