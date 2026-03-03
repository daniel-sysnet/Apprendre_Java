import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int i=0;
        Scanner sc=new Scanner(System.in);
        /*boolean isPlaying=true;
        while(isPlaying){
            System.out.println(i+1);
            if(i>=5){
                isPlaying=false;
            }
            i++;
        }
        for(i=0;i<5;i++){
            System.out.println(i+1);
        }

        do{
            int choix=sc.nextInt();
            System.out.println("Menu");
            System.out.println("Saisir votre choix");
                if(choix==1){
                    System.out.println("Option 1");
                }else if(choix==2){
                    System.out.println("Option 2");
                }else if(choix==3){
                    System.out.println("Option 3");
                }else if(choix==4){
                    System.out.println("Option 4");
                }
        }while(true);

        while (i<5) {
            i++;
            if(i%2==1){
                continue;
            }
            System.out.println(i);
        }*/

        for(String arg : args){
            System.out.println(arg);
        }
    }
}