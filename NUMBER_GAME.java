
package number_game;

import java.util.Scanner;

public class NUMBER_GAME {

    public static void main(String[] args) {
        //initialisation of maximum tries the user has to guess the correct number
        int maxTry = 10;
        //initialisation of score the user gets at the end of the game
        int Score = 0;
        int original_Num , guessed_Num;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game.");
        System.out.println("  GENERAL INSTRUCTION:");
        System.out.println("1. Guess the number in between a range of 1 to 100.");
        System.out.println("2. You have maximum 10 chances to guess the correct number.");
        System.out.println("3. Once you Guessed the correct number , the Total Score out of 100 will be Your achieved result.");
        System.out.println("4. Your Wrong guessing will leads to the reduction of 10 points out of 100 straightaway.");
        
        for(int i=0 ; i<maxTry ; i++){
            //This method is used to generate a random number between 1 to 100
            original_Num = 1+(int)(Math.random()*100);
            System.out.print("\n");
            System.out.print("Guess the random number between 1 to 100: ");
            guessed_Num = sc.nextInt();
            
            if(guessed_Num == original_Num){
                System.out.println("Congrats!! You  have Guessed the correct number.");
                Score = 100 - (10*i);//This shows the Total score on guessing the correct number
                break;
            }
            else if(guessed_Num > original_Num){
                System.out.println("Oops!! The Guessed Number was too high.");
                System.out.println("The Right Number is: "+original_Num);
            }
            else if(guessed_Num < original_Num){
                System.out.println("Oops!! The Guessed Number was too low.");
                System.out.println("The Right Number is: "+original_Num);
            }    
        }
        System.out.print("\n");
        System.out.println("Your Total Score : "+Score+"/100");
        System.out.println("Wanna Play Again??");
    }
    
}
