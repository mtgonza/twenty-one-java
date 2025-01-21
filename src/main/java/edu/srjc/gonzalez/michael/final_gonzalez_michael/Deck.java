/*
Name: Michael Gonzalez
Email: michael.t.gonza@gmail.com
Date: 12/19/2022
Project Name: Final_Gonzalez_Michael
Course: CS17.11
Description: The class public class Deck extends ArrayList<Card> is a class that
creates an ArrayList<> of Card objects by loading images from the folder CardImages
and placing the images, as well as the name of the images, into the Card constructor.
The ArrayList<> of card objects is then shuffled creating a unique standard 52 card
deck time a Deck object is created.  The method drawCard() returns the current card
indexed by the data member private int cardIndex, which is then incremented each
time the method is called.
*/

package edu.srjc.gonzalez.michael.final_gonzalez_michael;

import javafx.scene.image.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card>
{
    private int cardIndex = 0;
    private Image imgCardBack;

    public Deck()
    {
        File imageFolder = new File("src/main/resources/edu/srjc/gonzalez/michael/final_gonzalez_michael/CardImages");
        imgCardBack = new Image(getClass().getResource("CardImages/card_back.png").toString());
        Image imgCardFront = null;
        String cardName = null;

        for (File file : imageFolder.listFiles())
        {
            String cardPath = "CardImages/" + file.getName();

            if (!(file.getName().equals("card_back.png")))
            {
                imgCardFront = new Image(getClass().getResource(cardPath).toString());
                String[] nameFields = file.getName().split("_");
                cardName = nameFields[0];

                Card newCard = new Card(cardName, imgCardFront, imgCardBack);
                this.add(newCard);
            }
        }

        Collections.shuffle(this);
    }

    public Card drawCard()
    {
        if (this.cardIndex == this.size())
        {
            this.cardIndex = 0;
        }

        Card card = (Card)this.get(this.cardIndex);
        this.cardIndex++;
        return card;
    }

    public Image getImgCardBack()
    {
        return imgCardBack;
    }
}
