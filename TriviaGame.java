import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
//Swing, gui functionalies, reader, writer and ArrayList are all imported into the Trivia Game class.

/**
*This class demonstrates the TriviaGame class. It is used to read the question data into an array and create the actual Trivia Game setup that runs through the main class.  .
*@author Spencer Green, Jacob Johnson, McKenzie Peters, and Josh White
*@version 11/30/2021
*/

public class TriviaGame implements ActionListener {

  JTextField userName; //Create new JTextfield to hold the user's name

  JButton beginGame; //Create new JButton to begin game
  JButton answerOne; //Create new JButton to to hold 1st answer
  JButton answerTwo; //Create new JButton to hold 2nd answer
  JButton answerThree; //Create new JButton to hold 3rd answer
  JButton answerFour; //Create new JButton to hold 4th answer
  JButton nextQuestion; //Create new JButton to go to next question
  JButton endGame; //Create new JButton to end game

  JLabel welcome; //Create new JLabel to welcome user
  JLabel category; //Create new JLabel to display category
  JLabel questionText; //Create new JLabel to show question
  JLabel questionPoints; //Create new JLabel to show points for question
  JLabel currentScore; //Create new JLabel to display current score
  JLabel endMessage; //Create JLabel to display end score

  JFrame frame; //Create new JFrame to hold game

  ArrayList<Question> question; //New ArrayList to hold Question variables
  static String fileName; //Creaet fileName object
  static FileReader triviaFile; //Create fileReader object
  int score = 0; //initialize game score variable
  int index = 0; //initialize index variable to use with ArrayList


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

    //Use try/catch block to read trivia.txt file into the question ArrayList to create question objects for use in our buttons and labels during the game.

    frame = new JFrame("University of Cincinnati Trivia Game");
    frame.setLayout(new FlowLayout());
    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    frame.setSize(750, 500);
    //Initialize JFram and customize layout, size and color

    userName = new JTextField(10);
    userName.setActionCommand("Please Enter Your Name");
    //Intialize userName JTextfield 


    beginGame = new JButton("Press to Begin Game");
    beginGame.setFont(new Font("Arial", Font.BOLD, 20));
    beginGame.setBackground(Color.BLACK);
    beginGame.setForeground(Color.RED);
    //Intialize and format beginGame JButton
  

    answerOne = new JButton(question.get(index).getAOne());
    answerOne.setFont(new Font("Arial", Font.BOLD, 20));
    answerOne.setBackground(Color.WHITE);
    answerOne.setForeground(Color.BLACK);
    //Intialize and format answerOne JButton

    answerTwo = new JButton(question.get(index).getATwo()); 
    answerTwo.setFont(new Font("Arial", Font.BOLD, 20));
    answerTwo.setBackground(Color.WHITE);
    answerTwo.setForeground(Color.BLACK);
    //Intialize and format answerTwo JButton

    answerThree = new JButton(question.get(index).getAThree());
    answerThree.setFont(new Font("Arial", Font.BOLD, 20));
    answerThree.setBackground(Color.WHITE);
    answerThree.setForeground(Color.BLACK);
    //Intialize and format answerThree JButton

    answerFour = new JButton(question.get(index).getAFour()); 
    answerFour.setFont(new Font("Arial", Font.BOLD, 20));
    answerFour.setBackground(Color.WHITE);
    answerFour.setForeground(Color.BLACK);
    //Intialize and format answerFour JButton

    nextQuestion = new JButton("Next Question");
    nextQuestion.setFont(new Font("Arial", Font.BOLD, 20));
    nextQuestion.setBackground(Color.BLACK);
    nextQuestion.setForeground(Color.RED);
    //Intialize and format nextQuestion JButton

    endGame = new JButton("End Game");
    endGame.setFont(new Font("Arial", Font.BOLD, 20));
    endGame.setBackground(Color.BLACK);
    endGame.setForeground(Color.RED);
    //Intialize and format endGame JButton

    userName.addActionListener(this); 
    answerOne.addActionListener(this); 
    answerTwo.addActionListener(this); 
    answerThree.addActionListener(this);
    answerFour.addActionListener(this);
    nextQuestion.addActionListener(this);
    endGame.addActionListener(this);
    //add action listeners to all newly intialized object so they function when running the actual Trivia Game

    welcome = new JLabel("Welcome to the UC Trivia Game!");
    welcome.setFont(new Font("Arial", Font.BOLD, 20));
    //intialize welcome JLabel and provide prompt for user

    category = new JLabel("Category: " + question.get(index).getCategoryType());
    category.setFont(new Font("Arial", Font.BOLD, 15));
    //intialize and format category JLabel so user can see the category

    questionText = new JLabel(question.get(index).getQuestion());
    questionText.setFont(new Font("Arial", Font.BOLD, 15));
    //initialize and format the questionText JLabel so user can view the question they are answering


    questionPoints = new JLabel("This question is worth: " + Integer.toString(question.get(index).getPoints()) + " points");
    questionPoints.setFont(new Font("Arial", Font.BOLD, 15));
    //intialize questionPoints JLabel so user can view points for specific question

    currentScore = new JLabel("Your Current Score is " + score);
    currentScore.setFont(new Font("Arial", Font.BOLD, 20));
    //Initialize currentScore JLabel so user can view score after answering each question

    endMessage = new JLabel("Game Over: Your Final Score is " + score);
    endMessage.setFont(new Font("Arial", Font.BOLD, 15));
    //Initialize endMessage JLabel so the user can see final score after completing game or ending game early.

    frame.add(welcome);
    frame.add(currentScore);
    frame.add(questionText);
    frame.add(answerOne);
    frame.add(answerTwo);
    frame.add(answerThree);
    frame.add(answerFour);
    frame.add(questionPoints);
    frame.add(nextQuestion);
    frame.add(endGame);
    frame.add(category);
    
    //add all JButton, JLabels, and JTextFields to frame

    frame.setVisible(true);
    //set frame to visible

    }
      public void actionPerformed(ActionEvent aev) {

        questionText.setText(question.get(index).getQuestion());
        category.setText(question.get(index).getCategoryType());
        answerOne.setText(question.get(index).getAOne());
        answerTwo.setText(question.get(index).getATwo());
        answerThree.setText(question.get(index).getAThree());
        answerFour.setText(question.get(index).getAFour());
        //Set the questionText and each answer button to the correct index number from the question ArrayList

        if(aev.getActionCommand().equals(question.get(index).getAOne())){
          if(question.get(index).getCorrectAnswer().equals(question.get(index).getAOne())){
            score = score + question.get(index).getPoints();
            currentScore.setText("Correct! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          else{
            score = score - question.get(index).getPoints();
            currentScore.setText("Incorrect! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
            
          }
          //if answer one is selected and the correct answer based on the question ArrayList is equal to the answer one button, add points to the current score.  If not, subtract points from the current score.
        }
        if(aev.getActionCommand().equals(question.get(index).getATwo())){
          if(question.get(index).getCorrectAnswer().equals(question.get(index).getATwo())){
            score = score + question.get(index).getPoints();
            currentScore.setText("Correct! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          else{
            score = score - question.get(index).getPoints();
            currentScore.setText("Incorrect! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          //if answer two is selected and the correct answer based on the question ArrayList is equal to the answer two button, add points to the current score.  If not, subtract points from the current score.
        }
        if(aev.getActionCommand().equals(question.get(index).getAThree())){
          if(question.get(index).getCorrectAnswer().equals(question.get(index).getAThree())){
            score = score + question.get(index).getPoints();
            currentScore.setText("Correct! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          else{
            score = score - question.get(index).getPoints();
            currentScore.setText("Incorrect! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          //if answer three is selected and the correct answer based on the question ArrayList is equal to the answer three button, add points to the current score.  If not, subtract points from the current score.
        }
        if(aev.getActionCommand().equals(question.get(index).getAFour())){
          if(question.get(index).getCorrectAnswer().equals(question.get(index).getAFour())){
            score = score + question.get(index).getPoints();
            currentScore.setText("Correct! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          else{
            score = score - question.get(index).getPoints();
            currentScore.setText("Incorrect! Your Score is now: " + Integer.toString(score) + "  Please Select the Next Question Button");
          }
          //if answer four is selected and the correct answer based on the question ArrayList is equal to the answer four button, add points to the current score.  If not, subtract points from the current score.
        }

        if(aev.getActionCommand().equals("Next Question")){
          index++;
          currentScore.setText("Current Score: " + score);
          welcome.setVisible(false);
          beginGame.setVisible(false);

          if(index < question.size()){

          questionText.setText(question.get(index).getQuestion());
          answerOne.setText(question.get(index).getAOne());
          answerTwo.setText(question.get(index).getATwo());
          answerThree.setText(question.get(index).getAThree());
          answerFour.setText(question.get(index).getAFour());
        }
          else{
            frame.add(endMessage);
            userName.setVisible(false);
            welcome.setVisible(false);
            beginGame.setVisible(false);
            nextQuestion.setVisible(false);
            currentScore.setVisible(false);
            questionText.setVisible(false);
            answerOne.setVisible(false);
            answerTwo.setVisible(false);
            answerThree.setVisible(false);
            answerFour.setVisible(false);
            questionPoints.setVisible(false);
            category.setVisible(false);
            endMessage.setText("Game Over! Your Final Score is: " + score);
          }
          //if the user selects next question, reset the current score JLabel and move onto the next question so the user can continue through the game. The screen will display a new question and four new answers on the screen.
          //Once the trivia game runs out of questions, the user will be directed to a final score screen that displays their final score and a button to show the high score list.

          
        }

        if(aev.getActionCommand().equals("End Game")){
          frame.add(endMessage);
          userName.setVisible(false);
          welcome.setVisible(false);
          beginGame.setVisible(false);
          nextQuestion.setVisible(false);
          currentScore.setVisible(false);
          questionText.setVisible(false);
          answerOne.setVisible(false);
          answerTwo.setVisible(false);
          answerThree.setVisible(false);
          answerFour.setVisible(false);
          questionPoints.setVisible(false);
          category.setVisible(false);
          endMessage.setText("Game Over! Your Final Score is: " + score);
          //If the user selects the end game button, the game will go straight to the final score screen without finishing all questions. Selecting this button will not direct you to the high scores list because the game was not entirely finished.

          try{
            String name = userName.getText();

            FileWriter fw = new FileWriter("highscore.txt" ,true);
            BufferedWriter bufwr = new BufferedWriter(fw);

            bufwr.write(name);
            bufwr.newLine();

            bufwr.flush();
          
          bufwr.close();
        }

          catch (IOException exception) 
          {  
          System.out.println("An error occurred: " + exception);
          }
          //try/catch block is used to write to the high score.txt file after the game is concluded.  


        }
      }
    }
      




    

