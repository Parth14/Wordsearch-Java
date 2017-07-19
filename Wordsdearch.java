import java.util.*;
class Wordsdearch {
    static Scanner sc = new Scanner (System.in);
    
    static char ws_easy[][]= {{'C','S','M','F','S','N','O','W'},{'O','C','B','R','C','S','M','H'},{'A','A','Q','O','O','B','V','K'},{'T','R','E','S','L','F','E','I'},{'W','F','O','T','D','Q','S','Z',},{'L','W','K','Y','Q','I','C','E'},{'V','Q','W','I','G','L','O','O'},{'H','W','I','N','T','E','R','N'}};
    static char ws_medium[][]= {{'X','D','I','Y','Z','P','A','N','H','S'},{'T','N','I','E','C','O','R','O','A','V',},{'N','U','Z','L','S','B','C','S','Y','G'},{'E','O','B','E','K','O','H','M','T','C'},{'D','S','C','L','X','K','A','I','L','A'},{'N','N','Y','U','M','N','I','R','E','R'},{'I','U','H','K','Y','U','C','C','V','P'},{'P','M','Z','U','Y','D','G','F','O','E'},{'C','R','O','S','S','B','A','R','N','T'},{'A','W','Y','Y','F','O','N','D','U','E'}};
    
    //static char ws_3n[][]= {{'z','z','z','z','z','z','z'},{'z','z','z','z','z','z','z'},{'z','z','z','z','z','z','z'},{'z','z','z','z','z','z','z'},{'z','z','z','z','z','z','z'},{'z','z','z','z','z','z','z'},{'z','z','z','z','z','z','z'}};
    static char ws_3n[][]= new char[7][7];
    static char ws_4n[][]= new char[9][9];
    static String easy_words[] = {"COAT", "COLD", "WINTER", "SNOW", "IGLOO", "ICE", "SCARF", "FROST"};
    static String medium_words[] = {"unsound", "ukulele", "carpet", "indent", "crossbar", "dunk", "fondue", "crimson", "novelty", "archaic"};
    
    static String words3[]= new String [5];
    static String words3_answers[]= new String [5];
    static String words4[]= new String [5];
    static String words4_answers[]= new String [5];

    static String alpha = "abcdefghijklmnopqrstuvwxyz";

    public static void main (String [] args){
        System.out.println("        Welcome to WORDSEARCH   ");
        System.out.println("       ***********************  ");
        System.out.println();
        Menu();
    }
    public static void Menu (){
        
        int x = 0;
        
        while(true){
            Scanner scc = new Scanner (System.in);
            try {
                System.out.println("Main Menu");
                System.out.println("Press 1 to play a pre-made game");
                System.out.println("Press 2 to make your own game");
                x = scc.nextInt();
                break;
            }
            catch(Exception e){
                scc.close();
                System.out.println("Enter only integers");
            }
        }
        
        switch (x){
            case 1:
            Pre_made();
            break;
            case 2:
            Custom();
            break;
            default:
            System.out.println("Invalid input. Try again");
            Menu();
            break;
        }
        
    }
    public static void Pre_made (){
        
        int x = 0;
        
        while(true){
            Scanner scc = new Scanner (System.in);
            try {
                System.out.println("Press 1 for easy");
                System.out.println("Press 2 for medium");
                System.out.println("Press 3 for hard");
                x = scc.nextInt();
                break;
            }
            catch(Exception e){
                scc.close();
                System.out.println("Enter only integers");
            }
        }
        
        switch (x){
            case 1:
            Easy();
            break;
            case 2:
            Medium();
            break;
            case 3:
            Hard();
            break;
            default:
            System.out.println("Invalid input. Try again");
            Pre_made();
            break;
        }
    }
    public static void Easy (){
        Print(8,8,8,1);
        Answers(8,1);
    }
    public static void Medium (){
        Print(10,10,10,2);
        Answers(10,2);
    }
    public static void Hard (){
        System.out.println("Sorry, this is not yet available");
        Menu();
    }
    public static void Custom (){
        int x = 0;
        
        while(true){
            Scanner scc = new Scanner (System.in);
            try {
                System.out.println("Choose the length of each word (3,4,5 or 6 letters).");
                x = scc.nextInt();
                break;
            }
            catch(Exception e){
                scc.close();
                System.out.println("Enter only integers");
            }
        }
        
        switch (x){
            case 3:
            Accept(3,11);
            RandomL(7,7,11);
            N3();
            Print(7,7,5,11);
            Answers(5,11);
            break;
            case 4:
            Accept(4,12);
            RandomL(9,9,12);
            N4();
            Print(9,9,5,12);
            Answers(5,12);
            //add backward words functionality
            break;
            case 5:
            System.out.println("Sorry, this is not yet available");
            Custom();
            break;
            case 6:
            System.out.println("Sorry, this is not yet available");
            Custom();
            break;
            default:
            System.out.println("Invalid input. Try again");
            Custom();
            break;
        }
    }
    public static void Accept(int length, int type){
        System.out.println("Enter 5 words of length " + length + " each.");
        for (int i=0; i<5; i++){
            switch(type){
                case 11:
                words3[i]=sc.next();
                if(words3[i].length()!=length){
                    System.out.println("Wrong length. Try again.");
                    i--;
                }
                break;
                case 12:
                words4[i]=sc.next();
                if(words4[i].length()!=length){
                    System.out.println("Wrong length. Try again.");
                    i--;
                }
                break;
            }
        }
    }
    public static void RandomL (int x, int y, int type){
        Random ran = new Random();
        for (int i=0; i<x; i++){
            for (int j=0; j<y; j++){
                switch (type){
                    case 11:
                        ws_3n[i][j]=alpha.charAt(ran.nextInt(26));
                        break;
                    case 12:
                        ws_4n[i][j]=alpha.charAt(ran.nextInt(26));
                        break;
                }
            }
        }
    }
    public static void N3 (){
        Random ran = new Random();
        int r1 = ran.nextInt(3);
        int r2 = ran.nextInt(3);
        int r3 = ran.nextInt(2);
        int r4 = ran.nextInt(2);
        int r5 = ran.nextInt(2);
        if (r2==0){
            r2=3;
        }
        else if (r2==1){
            r2=4;
        }
        else {
            r2=5;
        }
        if (r3==0){
            r3=3;
        }
        else {
            r3=4;
        }
        if (r4==0){
            r4=5;
        }
        else {
            r4=6;
        }
        if (r5==0){
            r5=5;
        }
        else {
            r5=6;
        }
        
        words3_answers[0]="0,"+r1+".2,"+r1;
        words3_answers[1]=r2+",0."+r2+",2";
        words3_answers[2]="2,"+r3+".4,"+r3;
        words3_answers[3]=r4+",4."+r4+",6";
        words3_answers[4]="0,"+r5+".2,"+r5;
        for (int i=0; i<7; i++){
            for (int j=0; j<7; j++){
                if(j==r1){
                    if (i==0||i==1||i==2){
                       ws_3n[i][j]=words3[0].charAt(i);
                    }
                }

                if (i==r2){
                    if (j==0||j==1||j==2){
                       ws_3n[i][j]=words3[1].charAt(j);
                    }
                }

                if (j==r3){
                    if (i==2||i==3||i==4){
                       ws_3n[i][j]=words3[2].charAt(i-2);
                    }
                }

                if (i==r4){
                    if (j==4||j==5||j==6){
                       ws_3n[i][j]=words3[3].charAt(j-4);
                    }
                }

                if (j==r5){
                    if (i==0||i==1||i==2){
                       ws_3n[i][j]=words3[4].charAt(i);
                    }
                }
            }
        }
        
    }
    public static void N4(){
        Random ran = new Random();
        int r1 = ran.nextInt(4);
        int r2 = ran.nextInt(3);
        int r3 = ran.nextInt(5);
        int r4 = ran.nextInt(2);
        int r5 = ran.nextInt(5);
        if (r3==0){
            r3=4;
        }
        else if (r3==1){
            r3=5;
        }
        else if (r3==2){
            r3=6;
        }
        else if (r3==3){
            r3=7;
        }
        else {
            r3=8;
        }
        if (r4==0){
            r4=7;
        }
        else {
            r4=8;
        }
        if (r5==0){
            r5=4;
        }
        else if (r5==1){
            r5=5;
        }
        else if (r5==2){
            r5=6;
        }
        else if (r5==3){
            r5=7;
        }
        else {
            r5=8;
        }
        
        words4_answers[0]=r1+",0."+r1+",3";
        words4_answers[1]="4,"+r2+".7,"+r2;
        words4_answers[2]=r3+",3."+r3+",6";
        words4_answers[3]="5,"+r4+".8,"+r4;
        words4_answers[4]="0,"+r5+".3,"+r5;
        
        //0 for forwards and 1 for backwards
        int rd1 = ran.nextInt(2);
        int rd2 = ran.nextInt(2);
        int rd3 = ran.nextInt(2);
        int rd4 = ran.nextInt(2);
        int rd5 = ran.nextInt(2);
        
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if(i==r1){
                    if (j==0||j==1||j==2||j==3){
                        if (rd1 == 0){
                            ws_4n[i][j]=words4[0].charAt(j);
                        }
                        else {
                            ws_4n[i][j]=words4[0].charAt(3-j);
                        }
                        
                    }
                    
                }

                if (j==r2){
                    if (i==4||i==5||i==6||i==7){
                        if (rd2==0){
                            ws_4n[i][j]=words4[1].charAt(i-4);
                        }
                        else {
                            ws_4n[i][j]=words4[1].charAt(7-i);
                        }
                    }
                    
                }

                if (i==r3){
                    if (j==3||j==4||j==5||j==6){
                        if (rd3==0){
                            ws_4n[i][j]=words4[2].charAt(j-3);
                        }
                        else {
                             ws_4n[i][j]=words4[2].charAt(6-j);
                        }
                    }
                    
                }

                if (j==r4){
                    if (i==5||i==6||i==7||i==8){
                        if (rd4==0){
                            ws_4n[i][j]=words4[3].charAt(i-5);
                        }
                        else {
                            ws_4n[i][j]=words4[3].charAt(8-i);
                        }
                    }
                    
                }

                if (j==r5){
                    if (i==0||i==1||i==2||i==3){
                        if (rd5==0){
                            ws_4n[i][j]=words4[4].charAt(i);
                        }
                        else{
                            ws_4n[i][j]=words4[4].charAt(3-i);
                        }
                    }
                    
                }
            }
        }
        
    }
    public static void Print (int x, int y, int words, int mode){
        
        System.out.println("Start: There are "+words+" words to find: ");
        for (int i=0; i<words; i++){
            switch (mode){
                case 1:
                System.out.print(easy_words[i].toUpperCase()+" ");
                break;
                case 2:
                System.out.print(medium_words[i].toUpperCase()+" ");
                break;
                case 11:
                System.out.print(words3[i].toUpperCase()+" ");
                break;
                case 12:
                System.out.print(words4[i].toUpperCase()+" ");
                break;
            }
        }
        System.out.println();
        System.out.print("   ");
        for (int i=0; i<y; i++){
            System.out.print(i+" ");
        }
        for (int i=0; i<x; i++){
            System.out.println();
            System.out.print(i+"  ");
            for (int j=0; j<y; j++){
                switch (mode){
                    case 1:
                    System.out.print(ws_easy[i][j]+ " ");
                    break;
                    case 2:
                    System.out.print(ws_medium[i][j]+ " ");
                    break;
                    case 11:
                    System.out.print(ws_3n[i][j]+ " ");
                    break;
                    case 12:
                    System.out.print(ws_4n[i][j]+ " ");
                    break;
                }
            }
            System.out.print("  "+i);
        }
        System.out.println();
        System.out.print("   ");
        for (int i=0; i<y; i++){
            System.out.print(i+" ");
        }
        
    }
    public static void Answers (int num, int mode){
        long startTime = System.currentTimeMillis();
        
        System.out.println();
        String a[] = {"0,0.3,0", "1,4.4,4", "7,1.7,6", "0,4.0,7", "6,3.6,7", "5,5.5,7", "0,1.4,1", "0,3.4,3"};
        String b[] = {"6,1.0,1", "7,3.1,3", "3,9.8,9", "6,0.1,0","8,0.8,7", "7,5.4,5", "9,4.9,9", "6,7.0,7", "8,8.2,8", "0,6.6,6"}  ;
        boolean correct = false;
        boolean quitter = false;
        int left = num;
        while (left>0){
            String x = sc.next();
            if(x.charAt(0) =='e'){
                System.out.println("Do you really want to exit? [y/n]");
                String e = sc.next();
                if (e.equals("y")){
                    System.out.println("Exiting...");
                    quitter = true;
                    left = -1;
                }
                else {
                    System.out.println("Continuing...");
                }
                correct = true;
            }
            for (int i=0; i<num; i++){
                switch (mode){
                    case 1:
                        if (a[i].equals(x)){
                            System.out.println("Word "+easy_words[i]+" found! "+(--left)+ " left.");
                            a[i]="";
                            correct = true;
                        }
                        break;
                    case 2:
                        if (b[i].equals(x)){
                            System.out.println("Word "+medium_words[i]+" found! "+(--left)+ " left.");
                            b[i]="";
                            correct = true;
                        }
                        break;
                    case 11:
                        if (words3_answers[i].equals(x)){
                            System.out.println("Word "+words3[i]+" found! "+(--left)+ " left.");
                            words3_answers[i]="";
                            correct = true;
                        }
                        break;
                    case 12:
                        if (words4_answers[i].equals(x)){
                            System.out.println("Word "+words4[i]+" found! "+(--left)+ " left.");
                            words4_answers[i]="";
                            correct = true;
                        }
                        break;
                    }
            }
            if (correct==false){
                System.out.println("Wrong entry, try again.");
            }
            else {
                correct = false;
            }
        }
        long Time = (System.currentTimeMillis() - startTime)/1000;
        if (quitter==false)System.out.println("Congratulations! You have completed this puzzle in " +Time + " s. ! Play another one");
        System.out.println();
        Menu();
        
    }
}