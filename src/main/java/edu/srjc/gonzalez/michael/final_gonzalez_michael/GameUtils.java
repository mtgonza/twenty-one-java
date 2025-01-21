/*
Name: Michael Gonzalez
Email: michael.t.gonza@gmail.com
Date: 12/19/2022
Project Name: Final_Gonzalez_Michael
Course: CS17.11
Description: The class public class GameUtils is a class that offers utilities in the form of
pop up message boxes and choices boxes for use in the card game Twenty One.
*/

package edu.srjc.gonzalez.michael.final_gonzalez_michael;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class GameUtils
{
    public static ButtonType btnOK = new ButtonType("OK");
    public static ButtonType btnYes = new ButtonType("Yes");
    public static ButtonType btnCashOut = new ButtonType("Cash Out");
    public static ButtonType btnGiveUp = new ButtonType("Give Up");

    public GameUtils()
    {

    }

    public static ButtonType yesCashOutAnswerBox(String message, String messageTitle) {
        Alert dlg = new Alert(AlertType.INFORMATION, message, new ButtonType[]{btnYes, btnCashOut});
        dlg.setContentText(message);
        dlg.setHeaderText((String)null);
        dlg.setResizable(true);
        dlg.setTitle(messageTitle);
        Optional<ButtonType> result = dlg.showAndWait();
        return (ButtonType)result.get();
    }

    public static void brokeMessageBox(String message)
    {
        Alert alert = new Alert(Alert.AlertType.NONE, message, new ButtonType[]{btnGiveUp});
        alert.setResizable(true);
        alert.setTitle("You're broke!");
        alert.showAndWait();
    }

    public static void gameInformation()
    {

        String gameInfo = "Objective:  Get a total card value of 21, or as close to 21 as possible.\n" + "\n" +
                "Punter:  Also known as the player or user.\n" + "\n" +
                "Banker:  Also known as the dealer or computer program.\n" + "\n" +
                "Bet:  The punter starts with $20 in their wallet and each game costs a minimum bet of $5 to play.  " +
                "The punter can bet as much money as they can afford to during their turn, in $5 increments. \n" + "\n" +
                "Hit:  The banker deals the punter a new card, for a maximum of 5 cards.  The punter must stand " +
                "after receiving their 5th card.\n" + "\n" +
                "Stand:  The punter takes no further action and passes over to the banker’s turn.\n" + "\n" +
                "Lose:  The punter loses all the money they bet during the game.\n" + "\n" +
                "Win:  The punter receives double the money they bet during the game.\n" + "\n" +
                "Push:  A tie that occurs when both the punter and banker have the same total card value.  " +
                "The punter loses all money bet during the game.\n" + "\n" +
                "Bust:  When the punter goes over a total card value of 21.  The punter loses.\n" + "\n" +
                "Card Values:  Numerical cards from 2 to 10 have their face values.  Jacks, Queens, and Kings " +
                "have a value of 10.  The Ace is always valued at 11 unless that value puts the total card value " +
                "over 21, in which case it has the value of 1.\n" + "\n" +
                "Gameplay:  The punter and banker are each dealt 2 cards.  The first card is face down " +
                "(click to reveal the punter’s card), the second card is face up.  The punter can hit to receive" +
                " additional cards, bet additional money, or stand to pass the turn to the banker.  If the punter" +
                " goes over 21, it’s a bust, and they lose.  After the banker’s turn, if both the punter and banker" +
                " have the same card amount, it’s a push, or tie.  If the punter and banker have different total" +
                " card values under 21, whoever is closer to a total card value of 21 wins.\n";

        Alert alert = new Alert(Alert.AlertType.NONE, gameInfo, new ButtonType[]{btnOK});
        alert.setResizable(true);
        alert.setTitle("Game Information");
        alert.showAndWait();
    }
}
