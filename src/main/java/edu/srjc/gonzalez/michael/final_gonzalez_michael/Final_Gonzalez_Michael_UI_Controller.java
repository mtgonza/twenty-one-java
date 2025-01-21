/*
Name: Michael Gonzalez
Email: michael.t.gonza@gmail.com
Date: 12/19/2022
Project Name: Final_Gonzalez_Michael
Course: CS17.11
Description: The class public class Final_Gonzalez_Michael_UI_Controller is a controller class
for a GUI replicating the card game "Twenty One."  This class utilizes the classes Card, Deck
and GameUtils to create a fully functional game of "Twenty One."
*/

package edu.srjc.gonzalez.michael.final_gonzalez_michael;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Final_Gonzalez_Michael_UI_Controller implements Initializable
{
    private ArrayList<Card> punterCards;
    private ArrayList<Card> bankerCards;
    private ArrayList<ImageView> punterImageViews;
    private ArrayList<ImageView> bankerImageViews;
    private Deck deck;
    private int punterCardsIndex;
    private int bankerCardsIndex;
    private int punterTotal;
    private int bankerTotal;
    private int totalBet;
    private int punterWallet = 20;
    private final int BET_AMOUNT = 5;
    private final int COST_TO_PLAY = 5;
    private final int MAX_CARDS = 5;
    private boolean cardBackFlag = true;
    @FXML
    private Button btnBetAmount;
    @FXML
    private Button btnHit;
    @FXML
    private Button btnStand;
    @FXML
    private ImageView ivBankerCard0;
    @FXML
    private ImageView ivBankerCard1;
    @FXML
    private ImageView ivBankerCard2;
    @FXML
    private ImageView ivBankerCard3;
    @FXML
    private ImageView ivBankerCard4;
    @FXML
    private ImageView ivDeck;
    @FXML
    private ImageView ivDeck1;
    @FXML
    private ImageView ivDeck2;
    @FXML
    private ImageView ivDeck3;
    @FXML
    private ImageView ivPunterCard0;
    @FXML
    private ImageView ivPunterCard1;
    @FXML
    private ImageView ivPunterCard2;
    @FXML
    private ImageView ivPunterCard3;
    @FXML
    private ImageView ivPunterCard4;
    @FXML
    private Label lblTotalBet;
    @FXML
    private Label lblWallet;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        deck = new Deck();
        ivDeck.setImage(deck.getImgCardBack());
        ivDeck1.setImage(deck.getImgCardBack());
        ivDeck2.setImage(deck.getImgCardBack());
        ivDeck3.setImage(deck.getImgCardBack());
        punterCards = new ArrayList<Card>();
        bankerCards = new ArrayList<Card>();
        btnHit.setDisable(false);
        btnStand.setDisable(false);
        btnBetAmount.setText(String.format("Bet $%d", BET_AMOUNT));
        punterCardsIndex = 0;
        bankerCardsIndex = 0;
        punterTotal = 0;
        bankerTotal = 0;
        punterWallet = punterWallet - COST_TO_PLAY;
        lblWallet.setText(String.format("%d", punterWallet));
        totalBet = 5;
        lblTotalBet.setText(String.format("%d", totalBet));
        if (punterWallet < BET_AMOUNT)
        {
            btnBetAmount.setDisable(true);
        }
        else
        {
            btnBetAmount.setDisable(false);
        }


        // reset punter and banker card images so that no card images are showing
        punterImageViews = new ArrayList<ImageView>();
        bankerImageViews = new ArrayList<ImageView>();
        ivPunterCard0.setImage(null);
        ivPunterCard1.setImage(null);
        ivPunterCard2.setImage(null);
        ivPunterCard3.setImage(null);
        ivPunterCard4.setImage(null);
        ivBankerCard0.setImage(null);
        ivBankerCard1.setImage(null);
        ivBankerCard2.setImage(null);
        ivBankerCard3.setImage(null);
        ivBankerCard4.setImage(null);
        punterImageViews.add(ivPunterCard0);
        punterImageViews.add(ivPunterCard1);
        punterImageViews.add(ivPunterCard2);
        punterImageViews.add(ivPunterCard3);
        punterImageViews.add(ivPunterCard4);
        bankerImageViews.add(ivBankerCard4);
        bankerImageViews.add(ivBankerCard3);
        bankerImageViews.add(ivBankerCard2);
        bankerImageViews.add(ivBankerCard1);
        bankerImageViews.add(ivBankerCard0);


        // deal two cards to each player, alternate from punter to banker
        punterCards.add(deck.drawCard());
        punterImageViews.get(punterCardsIndex).setImage(punterCards.get(punterCardsIndex).getCardBack());
        punterTotal = punterTotal + punterCards.get(punterCardsIndex).getCardValue(punterTotal);
        punterCardsIndex++;
        bankerCards.add(deck.drawCard());
        bankerImageViews.get(bankerCardsIndex).setImage(bankerCards.get(bankerCardsIndex).getCardBack());
        bankerTotal = bankerTotal + bankerCards.get(bankerCardsIndex).getCardValue(bankerTotal);
        bankerCardsIndex++;
        punterCards.add(deck.drawCard());
        punterImageViews.get(punterCardsIndex).setImage(punterCards.get(punterCardsIndex).getCardFront());
        punterTotal = punterTotal + punterCards.get(punterCardsIndex).getCardValue(punterTotal);
        punterCardsIndex++;
        bankerCards.add(deck.drawCard());
        bankerImageViews.get(bankerCardsIndex).setImage(bankerCards.get(bankerCardsIndex).getCardFront());
        bankerTotal = bankerTotal + bankerCards.get(bankerCardsIndex).getCardValue(bankerTotal);
        bankerCardsIndex++;


        //System.out.println(String.format("PunterTotal: %d", punterTotal));
    }


    @FXML
    void mnuGameInformation_Click(ActionEvent event)
    {
        GameUtils.gameInformation();
    }


    @FXML
    void ivPunterCard0_Click(MouseEvent event)
    {
        if (cardBackFlag == true)
        {
            punterImageViews.get(0).setImage(punterCards.get(0).getCardFront());
            cardBackFlag = false;
        }
        else
        {
            punterImageViews.get(0).setImage(punterCards.get(0).getCardBack());
            cardBackFlag = true;
        }
    }


    @FXML
    void btnBetAmount_Click(MouseEvent event)
    {
        totalBet = totalBet + BET_AMOUNT;
        lblTotalBet.setText(String.format("%d", totalBet));
        punterWallet = punterWallet - BET_AMOUNT;
        lblWallet.setText(String.format("%d", punterWallet));

        if (punterWallet - BET_AMOUNT < 0)
        {
            btnBetAmount.setDisable(true);
        }
    }


    @FXML
    void btnHit_Click(MouseEvent event)
    {
        punterCards.add(deck.drawCard());
        punterImageViews.get(punterCardsIndex).setImage(punterCards.get(punterCardsIndex).getCardFront());
        punterTotal = punterTotal + punterCards.get(punterCardsIndex).getCardValue(punterTotal);
        punterCardsIndex++;

        if (punterCardsIndex >= MAX_CARDS)
        {
            btnBetAmount.setDisable(true);
            btnHit.setDisable(true);
        }

        testBust();
        //System.out.println(String.format("PunterTotal: %d", punterTotal));
    }


    @FXML
    void btnStand_Click(MouseEvent event)
    {
        while(bankerTotal < 17  && bankerCardsIndex < MAX_CARDS)
        {
            bankerCards.add(deck.drawCard());
            bankerImageViews.get(bankerCardsIndex).setImage(bankerCards.get(bankerCardsIndex).getCardFront());
            bankerTotal = bankerTotal + bankerCards.get(bankerCardsIndex).getCardValue(bankerTotal);
            bankerCardsIndex++;
        }

        bankerImageViews.get(0).setImage(bankerCards.get(0).getCardFront());
        testWinPushLose();

        //System.out.println(String.format("BankerTotal: %d", bankerTotal));
    }


    private void testWinPushLose()
    {
        String winMessage = "Congratulations you win!  Play again?";
        String pushMessage = "It's a tie!  Play again?";
        String loseMessage = "You lose.  Play again?";
        String brokeMessage = "Sorry, you have no money to bet!";
        String loseTitle = "Lose!";
        String winTitle = "Win!";
        String pushTitle = "Push!";

        if (bankerTotal > 21)
        {
            punterWallet = punterWallet + (2 * totalBet);
            lblWallet.setText(String.format("%d", punterWallet));

            if(this.playAgain(winMessage, winTitle))
            {
                this.initialize((URL)null, (ResourceBundle)null);
            }
            else
            {
                Platform.exit();
            }
        }
        else if (bankerTotal == punterTotal)
        {
            if(this.playAgain(pushMessage, pushTitle))
            {
                if (punterWallet - COST_TO_PLAY >= 0)
                {
                    this.initialize((URL)null, (ResourceBundle)null);
                }
                else
                {
                    GameUtils.brokeMessageBox(brokeMessage);
                    Platform.exit();
                }
            }
            else
            {
                Platform.exit();
            }
        }
        else
        {
            if((21 - bankerTotal) > (21 - punterTotal))
            {
                punterWallet = punterWallet + (2 * totalBet);
                lblWallet.setText(String.format("%d", punterWallet));

                if(this.playAgain(winMessage, winTitle))
                {
                    this.initialize((URL)null, (ResourceBundle)null);
                }
                else
                {
                    Platform.exit();
                }
            }
            else
            {
                if(this.playAgain(loseMessage, loseTitle))
                {
                    if (punterWallet - COST_TO_PLAY >= 0)
                    {
                        this.initialize((URL)null, (ResourceBundle)null);
                    }
                    else
                    {
                        GameUtils.brokeMessageBox(brokeMessage);
                        Platform.exit();
                    }
                }
                else
                {
                    Platform.exit();
                }
            }
        }
    }


    private void testBust()
    {
        if (punterTotal > 21)
        {
            String bustMessage = "You went over!  Would you like to play again?";
            String brokeMessage = "Sorry, you have no money to bet!";
            String bustTitle = "Bust!";

            if(this.playAgain(bustMessage, bustTitle))
            {
                if (punterWallet - COST_TO_PLAY >= 0)
                {
                    this.initialize((URL)null, (ResourceBundle)null);
                }
                else
                {
                    GameUtils.brokeMessageBox(brokeMessage);
                    Platform.exit();
                }
            }
            else
            {
                Platform.exit();
            }
        }
    }


    private boolean playAgain(String message, String messageTitle)
    {
        ButtonType answer = GameUtils.yesCashOutAnswerBox(message, messageTitle);
        return answer.getText().equalsIgnoreCase("YES");
    }
}