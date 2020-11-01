import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("number of ball : ");
        String number=scanner.next();
        //checking if the input is number
        if(number.matches("\\d+")){
            int numberOfBall = Integer.parseInt(number);
            if(numberOfBall ==1)
                System.out.println("you don't need weighting :)");
            else if(numberOfBall==0)
                System.out.println("you're kidding");
            else
                System.out.println("ways: "+findSolution(numberOfBall,0,0));


        }else
            main(args);
    }
    public static int findSolution(int numberOfBall,int counter,int residue){
        if(residue==2){
            residue=0;
            numberOfBall+=2;
        }
        if(numberOfBall==2){
            showWeighting(1,2);
            return counter+1;
        }else if(numberOfBall%3==0){
            showWeighting(numberOfBall/3,3);
            return findSolution(numberOfBall/3,counter+1, residue);
        }else if(numberOfBall%2==0){
            showWeighting(numberOfBall/2,2);
            return findSolution(numberOfBall/2,counter+1,residue);
        }else
            return findSolution(numberOfBall-1,counter,residue+1);
    }
    public static void showWeighting(int numberOfBallInEachLot,int numberLot){
        for (int i = 0; i <numberLot ; i++) {
            System.out.print(numberOfBallInEachLot+" ");
        }
        System.out.println();
    }

}
