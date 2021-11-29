/**
*This class demonstrates the question method. It holds the variables, constructors, and accessor methods needed to get the trivia questions running in the TriviaGame class.
*@author Spencer Green, Jacob Johnson, McKenzie Peters, and Josh White
*@version 11/30/2021
*/

class Question { //Create new Question class
  String questionName; //Create new String variable called name for the question names
  String firstAnswer;  //Create new String variable called name for the first answer
  String secondAnswer;  //Create new String variable called name for the second answer
  String thirdAnswer;  //Create new String variable called name for the third answer
  String fourthAnswer;  //Create new String variable called name for the fourth answer
  String correctAnswer; //Create new String variable called name for the correct answer
  int points; //Create new int variable called name for the number of points question is worth.
  String categoryType; //Create new String variable called name for the category type.

  Question(String aQuestion, String aOne, String aTwo ,String aThree ,String aFour, String correctA, int aPoint, String aCategory) {
    questionName = aQuestion;
    firstAnswer = aOne;
    secondAnswer = aTwo;
    thirdAnswer = aThree;
    fourthAnswer = aFour;
    correctAnswer = correctA;
    points = aPoint;
    categoryType = aCategory;
  }
  /**
  *This method is the constructor in the Question class.
  *Sets the parameter aQuestion equal to the variable questionName.
  *Sets the parameter aOne equal to the variable firstAnswer.
  *Sets the parameter aTwo equal to the variable secondAnswer.
  *Sets the parameter aThree equal to the variable thirdAnswer.
  *Sets the parameter aFour equal to the variable fourthAnswer.
  *Sets the parameter correctA equal to the variable correctAnswer.
  *Sets the parameter aPoint equal to the variable points.
  *Sets the parameter aCategory equal to the variable categoryType.
  @param String aQuestion, String aOne, String aTwo, String aThree, String aFour, String correctA, int aPoint, String aCategory
  */

  String getQuestion(){
    return questionName;
  }
  /**
  *This is a mututor method to get the question name.
  @return The value returns the String questionName.
  */

  String getAOne(){
    return firstAnswer;
  }
  /**
  *This is a mututor method to get the first answer.
  @return The value returns the String firstAnswer
  */

  String getATwo(){
    return secondAnswer;
  }
  /**
  *This is a mututor method to get the second answer.
  @return The value returns the String secondAnswer
  */

  String getAThree(){
    return thirdAnswer;
  }
  /**
  *This is a mututor method to get the third answer.
  @return The value returns the String thirdAnswer
  */

  String getAFour(){
    return fourthAnswer;
  }
  /**
  *This is a mututor method to get the fourth answer.
  @return The value returns the String fourthAnswer
  */

  String getCorrectAnswer(){
    return correctAnswer;
  }
  /**
  *This is a mututor method to get the correct answer.
  @return The value returns the String correctAnswer
  */

  int getPoints(){
    return points;
  }
  /**
  *This is a mututor method to get the question points.
  @return The value returns the int points
  */

  String getCategoryType(){
    return categoryType;
  }
  /**
  *This is a mututor method to get the category type.
  @return The value returns the String cateogryType
  */

}

