package com.maxwell.javafxprograms.slot_machine_demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SlotMachine  extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//The bet radio buttons at the right side 
	private RadioButton[] lstBet = new RadioButton[7];
	//The bet radio button's caption 
	final static String[] lstBetCap = {"$1","$2","$5","$10","$20","$50","$100"};
	//The pay out ratio for the different icon
	final static double[] lstPayout = {5d,//banana - will pay out 5 times of the bet user choose
			4d,//Water melon
			14d,//Bell
			1d,//bar
			7d,//lemon
			9d,//Orange
			1000d,//7
			3d,//plum
			2d};//cherry
	//We support all 9 icons now
	final static int MAX_ICONS = 9;
	//Three slots
	private ImageView imgSlot1= new ImageView();;
	private ImageView imgSlot2= new ImageView();;
	private ImageView imgSlot3= new ImageView();;
	//All the icons
	private Image[] imgSource;
	//Am I in cheat mode
	private boolean cheatMode = false;
	//The title 
	Text txtResults = new Text("Results go Here - Cash $200.0");
	//How much cash do I have now?
	private double dCash = 200.0;
	//The final icon for each slot
	private int nSlot1 = 0;
	private int nSlot2 = 0;
	private int nSlot3 = 0;

	public void start(Stage primaryStage) {

		//The overall border pane
		BorderPane obPane = new BorderPane();
		//Space bar to spin
		obPane.addEventFilter(KeyEvent.KEY_RELEASED, event->{
			if (event.getCode() == KeyCode.SPACE) { 
				cheatMode = event.isShiftDown();//Press shift space will cheat
				spin();
			}});
		//The machine pane at center		 
		Pane obTop = new Pane();
		obPane.setCenter(obTop);

		//The bet pane at right
		VBox obRight = new VBox(10);
		obRight.setAlignment(Pos.CENTER_LEFT);
		obRight.setPadding(new Insets(5,20,0,20));
		obPane.setRight(obRight);

		//the button pane at bottom
		HBox obBottom = new HBox(20);
		obBottom.setAlignment(Pos.BASELINE_CENTER);
		obBottom.setPadding(new Insets(5,20,5,20));
		obPane.setBottom(obBottom);

		//The title is in machine pane
		txtResults.setFont(Font.font("playbill",FontWeight.BOLD, FontPosture.ITALIC, 25));
		txtResults.setFill(Color.GOLD);

		//Make sure machine pane and bet pane have correct size
		obTop.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.78));
		obRight.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.22));

		//Set the slot machine back ground image
		BackgroundImage myBI= new BackgroundImage(new Image("file:images/background.jpg",687,640,false,true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		obTop.setBackground(new Background(myBI));

		//Init two buttons
		ImageView imgSpin = new ImageView("file:images/spin.png");
		imgSpin.setFitHeight(100);
		imgSpin.setFitWidth(100);
		Button cmdSpin = new Button("Spin",imgSpin);

		ImageView imgCash = new ImageView("file:images/cash.png");
		imgCash.setFitHeight(100);
		imgCash.setFitWidth(100);
		Button cmdCash = new Button("Cash Out",imgCash);
		obBottom.getChildren().addAll(cmdSpin, cmdCash);

		//Two button's event handler
		cmdCash.setOnAction(e->{
			showAlert(String.format("You have $%3.1f left.", dCash));
			System.exit(0);
		});			
		cmdSpin.setOnAction(e->spin());

		//Init the bets radio buttons
		ToggleGroup group = new ToggleGroup();
		for(int i=0;i<lstBet.length;i++)
		{
			lstBet[i]=new RadioButton(lstBetCap[i]);
			lstBet[i].setToggleGroup(group);

		}
		lstBet[0].setSelected(true);
		obRight.getChildren().addAll(lstBet);

		//Init the slots
		imgSource = loadImages();
		imgSlot1.setImage(imgSource[0]);
		imgSlot2.setImage(imgSource[1]);
		imgSlot3.setImage(imgSource[2]);
		//We use Pane so we will set the exact pos for each slot and title
		imgSlot1.setX(50);
		imgSlot1.setY(347);
		imgSlot1.setFitHeight(209);
		imgSlot1.setFitWidth(170);
		imgSlot2.setX(260);
		imgSlot2.setY(347);
		imgSlot2.setFitHeight(209);
		imgSlot2.setFitWidth(170);
		imgSlot3.setX(467);
		imgSlot3.setY(347);
		imgSlot3.setFitHeight(209);
		imgSlot3.setFitWidth(170);
		txtResults.setX(260);
		txtResults.setY(310);
		obTop.getChildren().addAll(imgSlot1,imgSlot2,imgSlot3,txtResults);

		//Regular stuff
		Scene scene = new Scene(obPane, 887, 750);
		primaryStage.setTitle("CST Slot Machine"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void spin()
	{
		//Do I have enough fund for the bet I choosed?
		if(dCash<getSelectedBet())
		{
			showAlert(String.format("You have $%3.1f left. It is no enough for the bet.", dCash));
			return;
		}
		new Thread(()->
		{
			//Any time only one spin
			synchronized(this)
			{
				//spin for 20 icons
				for(int i=0;i<20;i++)
				{
					//Get random icon index
					final int slot1 = (int)(Math.random()*(MAX_ICONS));
					//Record it to a member var so we can reference it later
					nSlot1=slot1;
					//Update the slot image
					Platform.runLater(()->updateSlot(imgSlot1,slot1));
					//If it is in cheat mode, we only need to cheat in the last spin
					final int slot2 = cheatMode && i==19?slot1:(int)(Math.random()*(MAX_ICONS));
					nSlot2=slot2;
					Platform.runLater(()->updateSlot(imgSlot2,slot2));
					final int slot3 = cheatMode && i==19?slot1:(int)(Math.random()*(MAX_ICONS));
					nSlot3=slot3;
					Platform.runLater(()->updateSlot(imgSlot3,slot3));
					//Sleep 100 ms
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//All spins over let see win/lost
				Platform.runLater(()->judge());
			}
		}).start();
	}

	//Update slot image
	private void updateSlot(ImageView slot, int icon)
	{
		slot.setImage(imgSource[icon]);
	}

	//Which bet did I choose?
	private double getSelectedBet()
	{
		double bse=0d;
		for(int i=0;i<lstBetCap.length;i++)
		{
			if(lstBet[i].isSelected())
			{
				//Based on the selection get the pay out rario
				bse= Double.parseDouble(lstBetCap[i].substring(1));
				break;
			}
		}
		return bse;
	}

	private void judge()
	{
		//Bet X Win Ratio
		double bse=getSelectedBet();
		boolean bWin=false;
		cheatMode = false;
		//Find which bet is selected

		if(nSlot1==nSlot2 && nSlot1==nSlot3)
		{
			//Win! pay out
			dCash+=bse*lstPayout[nSlot1];
			bWin=true;
		}
		else
		{
			//Lost! deduct
			dCash-=bse;
			bWin=false;
		}
		//Update status
		String sRs=String.format("%s - Cash: $%3.1f", bWin?"You Win":"You Lost",dCash);
		txtResults.setText(sRs);
		if(dCash<1d)
		{
			showAlert("You have insufficient funds.");
			System.exit(9);
		}
	}

	private void showAlert(String sText) { 
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText("End Game");
		alert.setContentText(sText);
		alert.showAndWait();
	}


	private Image[] loadImages()
	{
		Image[] imgs = new Image[MAX_ICONS];
		for(int i=0;i<imgs.length;i++)
		{
			imgs[i]=new Image(String.format("file:images/%d.jpg",i+1));
		}
		return imgs;
	}
}
