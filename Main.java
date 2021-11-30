import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
//import all java swing and gui packages into Main for running all the code

/**
*This class demonstrates the Main method. It is utilizes all the of Java Swing capabilites to run the code from the TriviaGame class.  .
*@author Spencer Green, Jacob Johnson, McKenzie Peters, and Josh White
*@version 11/30/2021
*/


class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new TriviaGame();
      }
    });
    }
}
//set of code above starts the trivia constructor and beings the game for the user.