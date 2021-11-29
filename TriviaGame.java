import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

/**
*This class demonstrates the TriviaGame class. It is used to read the question data into an array and create the actual Trivia Game setup that runs through the main class.  .
*@author Spencer Green, Jacob Johnson, McKenzie Peters, and Josh White
*@version 11/30/2021
*/

public class TriviaGame implements ActionListener {

  JTextField userName;

  JButton beginGame;
  JButton answerOne;
  JButton answerTwo;
  JButton answerThree;
  JButton answerFour;
  JButton nextQuestion;
  JButton endGame;

  JLabel welcome;
  JLabel category;
  JLabel questionText;
  JLabel questionPoints;
  JLabel questionResult;
  JLabel currentScore;
  JLabel endMessage;

  JFrame frame;

  ArrayList<Question> question;
  static String fileName;
  static FileReader triviaFile; 
  int score = 0;
  int index = 0;


TriviaGame(){

  question = new ArrayList<Question>();
  fileName = "Trivia.txt";
  String questionName = " ", firstAnswer = " ", secondAnswer = " ", thirdAnswer = " ", fourthAnswer = " ", correctAnswer = " ", points = " " , categoryType = " ";

    try{
    triviaFile = new FileReader(fileName);
    BufferedReader br = new BufferedReader(triviaFile);
      while(br.ready()){
        questionName = br.readLine();
        firstAnswer = br.readLine();
        secondAnswer = br.readLine();
        thirdAnswer = br.readLine();
        fourthAnswer = br.readLine();
        correctAnswer = br.readLine();
        points = br.readLine();
        categoryType = br.readLine();

        Question theQuestion = new Question(questionName, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, correctAnswer, Integer.parseInt(points), categoryType);
        question.add(theQuestion);
      }
    br.close();
  }
  catch(IOException exception){
      System.out.println("An Error Occurred: " + exception);
    }

    frame = new JFrame("Group #3's Trivia Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    userName = new JTextField(10);
    userName.setActionCommand("Please Enter Your Name");


    beginGame = new JButton("Press to Begin Game");
    answerOne = new JButton(question.get(index).getAOne());
    answerTwo = new JButton(question.get(index).getATwo()); 
    answerThree = new JButton(question.get(index).getAThree());
    answerFour = new JButton(question.get(index).getAFour()); 
    nextQuestion = new JButton("Next Question");
    endGame = new JButton("End Game");

    userName.addActionListener(this); 
    answerOne.addActionListener(this); 
    answerTwo.addActionListener(this); 
    answerThree.addActionListener(this);
    answerFour.addActionListener(this);
    nextQuestion.addActionListener(this);
    endGame.addActionListener(this);

    welcome = new JLabel("Welcome to the Trivia Game!");
    category = new JLabel(question.get(0).getCategoryType());
    questionText = new JLabel(question.get(0).getQuestion());
    questionPoints = new JLabel("This question is worth: " + Integer.toString(question.get(0).getPoints()) + " points");
    currentScore = new JLabel("Your Current Score is " + score);
    endMessage = new JLabel("Game Over: Your Final Score is " + score);


    frame.add(userName);
    frame.add(welcome);
    frame.add(beginGame);
    frame.add(category);
    frame.add(currentScore);
    frame.add(questionText);
    frame.add(answerOne);
    frame.add(answerTwo);
    frame.add(answerThree);
    frame.add(answerFour);
    frame.add(questionPoints);
    frame.add(endGame);
    frame.add(nextQuestion);
    frame.add(endMessage);

    frame.setVisible(true);

    }
      public void actionPerformed(ActionEvent aev) {
        
        if(aev.getActionCommand().equals("Begin Game")){
            questionText.setText(question.get(index).getQuestion());
            answerOne.setText(question.get(index).getAOne());
            answerTwo.setText(question.get(index).getATwo());
            answerThree.setText(question.get(index).getAThree());
            answerFour.setText(question.get(index).getAFour());
          }
        
        if(aev.getActionCommand().equals(question.get(index).getAOne())){

        }

        if(aev.getActionCommand().equals("Next Question")){
          score = 0;
          index++;
          if(index < question.size()){

          questionText.setText(question.get(index).getQuestion());
          answerOne.setText(question.get(index).getAOne());
          answerTwo.setText(question.get(index).getATwo());
          answerThree.setText(question.get(index).getAThree());
          answerFour.setText(question.get(index).getAFour());
        }
        }


        if(aev.getActionCommand().equals("End Game")){
          try{
            String highScore = "Game Over! Here are the High Scores";

            FileWriter fw = new FileWriter("highscore.txt" ,true);
            BufferedWriter bufwr = new BufferedWriter(fw);
            bufwr.write(score);
            bufwr.close();

            bufwr.flush();
            bufwr.close();
           }

          catch (IOException exception) 
          {  
          System.out.println("An error occurred: " + exception);
          }


        }
      }
    }

/*
    FileWriter fw = new FileWriter("highscore.txt",true);
BufferedWriter bw = new BufferedWriter(fw);
bw.write(Integer.toString(score));


.compareTo OR .equals

*/



    

