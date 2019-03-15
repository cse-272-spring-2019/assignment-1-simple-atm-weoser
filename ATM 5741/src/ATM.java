import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class ATM extends Application implements EventHandler<ActionEvent>{
	Button button1, button2, button3, button4, button5;
	Stage window;
	Scene scene1, scene2;
	String id, deposit, withdraw;
	int a = -1;
	public static void main(String[] args) {
		launch(args);
	
}
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		primaryStage.setTitle("ATM");
		User user = new User(0);
		TextField cardNo = new TextField();
		Label label = new Label("Enter your credit card number (5741)");
		button1 = new Button("Enter");
		button1.setOnAction(e -> {
			id = cardNo.getText();
			if(id.equals("5741"))
				window.setScene(scene2);
			else
				Alerts.display("Error","Please try again");});
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, cardNo, button1);
		layout.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout, 400, 200);

		Label history = new Label("			  	 Welcome");
		Button next = new Button("Next");
		next.setOnAction(e -> {
			if (a == 4)
			{}
			else
			a++;
			history.setText("			    " + user.trans[a].type + " " + user.trans[a].amount);
			});
		Button prev = new Button ("Previous");
		prev.setOnAction(e ->{ 
			if (a == 0)
			{}
			else
			a--;
			history.setText("			    " + user.trans[a].type + " " + user.trans[a].amount);
			});

		
		button2 = new Button("Balance");
		button2.setOnAction(e -> {
		user.getBalance();	
		Alerts.display("Balance","Your balance is " + user.initialBalance);});
		button3 = new Button("Deposit");
		button3.setOnAction(e -> displayDeposit(user));
		button4 = new Button("Withdraw");
		button4.setOnAction(e -> displayWithdraw(user));
		button5 = new Button("Exit");
		button5.setOnAction(e -> window.close());

		HBox ap = new HBox(25);
		ap.getChildren().addAll(button2,button3,button4,button5);
		
		GridPane layout2 = new GridPane();
		layout2.add(ap,1,0);
		layout2.add(prev, 0, 3);
		layout2.add(history, 1, 3);
		layout2.add(next, 2, 3);
		layout2.setVgap(10);
		layout2.setAlignment(Pos.CENTER);
		history.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 400, 200);
		
		window.setScene(scene1);
		window.show();
		
	}
	
	public static void displayWithdraw(User user) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Withdrawal");
		window.setMinWidth(400);
		window.setMinHeight(300);
		Label label = new Label();
		label.setText("Enter amount");
		TextField entry = new TextField();
		Button close = new Button("OK");
		close.setOnAction(e ->{ 
			String withdraw = entry.getText();
			if(withdraw.matches("[0-9]+"))
			{user.withdrawal(withdraw);
			window.close();}
			else
				Alerts.display("Error", "Enter a number");});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, entry, close);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
	
	public static void displayDeposit(User user) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Deposit");
		window.setMinWidth(400);
		window.setMinHeight(300);
		Label label = new Label();
		label.setText("Enter amount");
		TextField entry = new TextField();
		Button close = new Button("OK");
		close.setOnAction(e ->{ 
			String deposit = entry.getText();
			if(deposit.matches("[0-9]+"))
			{user.deposit(deposit);
			window.close();}
			else
				Alerts.display("Error", "Enter a number");});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, entry, close);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
	public void displayHistory() {
		
	}
	
	public void handle(ActionEvent arg0) {
		
		
	}
}
