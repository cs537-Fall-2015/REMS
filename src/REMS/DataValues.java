package REMS;
import java.util.Random;

/** Generate random integers in a certain range. */
public final class DataValues {
  
  public static final void main(String... aArgs){
	  
	  
	  int W_START = 20;
	  int W_END = 60;
	  long W;
	  Random W_random = new Random();   
	  W = showRandomInteger(W_START, W_END, W_random);
	 log("Wind Speed: " + W);
    
	
    int G_START = -225;
    int G_END = 72;
    long G;
    Random G_random = new Random();   
    G = showRandomInteger(G_START, G_END, G_random);
    log("Ground Temperature: " + G);
    
    
    
    int A_START = -100;
    int A_END = 70;
    long A;
    Random A_random = new Random();   
    A= showRandomInteger(A_START, A_END, A_random);
    log("Air Temperature: " + A);
        
    
    
    int H_START = 40;
    int H_END = 100;
    long H;
    Random H_random = new Random();   
    H = showRandomInteger(H_START, H_END, H_random);
    log("Humidity: " + H);
    
    
    int U_START = 200;
    int U_END = 400;
    long U;
    Random U_random = new Random();   
    U = showRandomInteger(U_START, U_END, U_random);
    log("Ultravoilet: " + U);
    
   
    int P_START = 200;
    int P_END = 400;
    long P;
    Random P_random = new Random();   
    P = showRandomInteger(P_START, P_END, P_random);  
    log("Pressure: " + P);
    
 }
  
  private static long showRandomInteger(int aStart, int aEnd, Random aRandom){
    if (aStart > aEnd) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    long range = (long)aEnd - (long)aStart + 1;   
    long fraction = (long)(range * aRandom.nextDouble());
    int randomNumber =  (int)(fraction + aStart);    
    return (randomNumber);
  //  log("" + randomNumber);
  }
  
  private static void log(String aMessage){
    System.out.println(aMessage);
  }
} 