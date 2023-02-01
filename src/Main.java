import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         start();

    }

    static void start() {
        // meniul pentru alegerea exercitiului 1-10
        System.out.println("\nScrie numarul specific exercitiului (1-10): ");

        int problemNumber = inputNumber();
        switchcase(problemNumber);

    }

    // verificarea valorilor introduse de la tastatura daca sunt numere
    public static int inputNumber() {
        Scanner input = new Scanner(System.in);

        int returnNumber;
        int test = 0;
        do {
            while (!input.hasNextInt()) {
                System.out.println("Te rog sa introduci numere.");
                input.next();
            }

            returnNumber = input.nextInt();
            test++;

        } while (test <= 0);

        return returnNumber;
    }


    static void reload() {
        System.out.println("Nu ai introdus o valoare cuprinsa intre 1-10.");
        start();
    }

    static void problem1() {
        System.out.println("Exercitiul 1 \n\n Scrieti 3 numere si verifica daca minim doua dintre ele sunt pozitive.\n");

        System.out.println("Scrie primul numar:");
        int number1 = inputNumber();
        System.out.println("Scrie al doilea numar:");
        int number2 = inputNumber();
        System.out.println("Scrie al treilea numar:");
        int number3 = inputNumber();

        if(number1 > 0 && number2 > 0 && number3 > 0)
            System.out.println("Toate numerele sunt pozitive.");
        else if(number1 > 0 && number2 > 0
                || number1 > 0 && number3 > 0
                || number2 > 0 && number3 > 0)
            System.out.println("Cel putin doua numere sunt pozitive.");
        else
            System.out.println("Nu ai cel putin 2 numere pozitive.");

        promptEnterKey();
        start();
    }

    static void problem2() {
        System.out.println("Exercitiul 2 \n\n Determina numarul cel mai mare din trei numere citite de la tastatura "
                + "fara a folosi if case (se vor folosi operatori ternari).\n");

        // introducerea celor 3 valori
        System.out.println("Scrie primul numar:");
        int number1 = inputNumber();

        System.out.println("Scrie al doilea numar:");
        int number2 = inputNumber();

        System.out.println("Scrie al treilea numar:");
        int number3 = inputNumber();

        // verificarea numerelor prin operatori ternari
        int largestNumber = (number1 >= number2) ? ((number1 >= number3) ? number1 : number3) : ((number2 >= number3) ? number2 : number3);

        System.out.println("Cel mai mare numer introdus de la tastatura este: " + largestNumber);

        promptEnterKey();
        start();
    }

    static void problem3() {
        System.out.println("Exercitiul 3 \n\n Afiseaza valorile impare dintr-un interval citit de la tastatura (Ex: citit de la tastatura 2, 9 -> afiseaza: 3, 5, 7, 9)\n");

        // introducerea valorilor
        System.out.println("Scrie primul numar:");
        int minNumber = inputNumber();

        System.out.println("Scrie al doilea numar:");
        int maxNumber = inputNumber();

        // afisarea valorilor impare dintr-un interval
        String oddNumberList = "";
        for(int i = minNumber; i <= maxNumber; i++) {
            if( i % 2 != 0) {
                oddNumberList = oddNumberList + i + ", ";
            }
        }
        System.out.println(oddNumberList);

        promptEnterKey();
        start();

    }

    static void problem4() {
        System.out.println("Exercitiul 4 \n\n Verifica daca un numar este prim sau nu.\n");

        // introducerea unei valori de la tastatura
        System.out.println("Introdu un numar:");

        // verificarea numarului daca este prim
        int primeNumber = inputNumber();
        boolean flag = false;

        for (int i = 2; i <= primeNumber / 2; ++i) {

            if (primeNumber % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(primeNumber + " este numar prim.");
        else
            System.out.println(primeNumber + " nu este numar prim.");

        promptEnterKey();
        start();
    }


    static void problem5() {
        System.out.println("Exercitiul 5 \n\n Verifica daca un String este palindrom sau nu.\n");

        System.out.println("Scrie textul exercitiului: ");
        Scanner input = new Scanner(System.in);
        String isPalindrom = input.nextLine();

        if(isPalindrome(isPalindrom))
        {
            System.out.println(isPalindrom + " este un palindrom.");
        } else {
            System.out.println(isPalindrom + " nu este un palindrom.");
        }

        promptEnterKey();
        start();
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static void problem6() {
        System.out.println("Exercitiul 6 \n\n Afisati primele N numere din sirul lui Fibonacci.\n");
        // initierea variabilelor
        int n1 = 0, n2 = 1, n3;

        System.out.println("N = ");
        int count = inputNumber();

        String fibonacci = n1 + ", " + n2;
        for(int i = 2;i<count;++i) {
            n3=n1+n2;
            fibonacci = fibonacci + ", " + n3;
            n1 = n2;
            n2 = n3;
        }
        System.out.println(fibonacci);

        promptEnterKey();
        start();
    }

    static void problem7() {
        System.out.println("Exercitiul 7 \n\nVerifica daca un numar natural, introdus de la tastatura, este pefect. \n");

        // introducerea numarului de verificat
        System.out.println("Introdu un numar:");
        int checkPerfectNumber = inputNumber();

        if (isPerfect(checkPerfectNumber))
            System.out.println(checkPerfectNumber + " este un numar perfect.");
        else
            System.out.println(checkPerfectNumber + " nu este un numar perfect.");

        promptEnterKey();
        start();
    }

    static boolean isPerfect(int n)
    {
        // 1 nu este un numar perfect
        if (n == 1)
            return false;

        int sum = 1;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        if (sum == n)
            return true;
        return false;
    }

    static void problem8() {
        System.out.println("Exercitiul 8 \n\nSa se determine valoarea functiei de mai jos pentru x (intreg) citit de la tastatura. \n");

        // introducerea numarului
        System.out.println("Introdu un numar:");
        int number = inputNumber();

        // verificarea numarului in functie de cele 3 conditii
        if(number <= -5) {
            number = number + 10;
        } else if(-5 < number && number <= 10) {
            number = number * 2;
        } else if(number > 10) {
            number = number * 2 + 50;
        }

        System.out.println("Rezultat: " + number);

        promptEnterKey();
        start();
    }

    static void problem9() {
        System.out.println("Exercitiul 9 \n \n");

        // introducerea de la tastatura a unui string
        Scanner curenncy = new Scanner(System.in);
        System.out.println("Scrie de la tastatura valuta dorita.(EUR, USD, GBP, MDL sau CAD)");
        String curenncy2 = curenncy.nextLine();

        if (curenncy2.matches("(?i)EUR|USD|GBP|MDL|CAD")) {
            System.out.println("Ai ales: " + curenncy2.toUpperCase());

            System.out.println("Scrie valoarea in RON.");
            double value = inputNumber();

            switch (curenncy2.toUpperCase()) {
                case "EUR":
                    double ronEur = value / 4.9410;
                    System.out.println("RON: " + value + " --> EUR: " + ronEur );
                    break;
                case "USD":
                    double ronUsd = value / 5.0408;
                    System.out.println("RON: " + value + " --> USD: " + ronUsd );
                    break;
                case "GBP":
                    double ronGbp = value / 5.6488;
                    System.out.println("RON: " + value + " --> GBP: " + ronGbp );
                    break;
                case "MDL":
                    double ronMdl = value / 0.2572;
                    System.out.println("RON: " + value + " --> MDL: " + ronMdl );
                    break;
                case "CAD":
                    double ronCad = value / 3.6767;
                    System.out.println("RON: " + value + " --> CAD: " + ronCad );
                    break;
                default:
                    System.out.println("Valoare incorecta.");
                    break;
            }

        } else {
            System.out.println("Valoare incorecta.");
            problem9();
        }

        promptEnterKey();
        start();
    }

    static void problem10() {
        System.out.println("Exercitiul 10 \n\nSe citeste de la tastatura un String. Sa se verifice daca acesta\r\n"
                + "indeplineste constrangerile pentru a fi o parola sigura - lungimea de\r\n"
                + "minim 8, litere lowercase si uppercase, minim o cifra, minim un caracter special\r\n "
                + "(ex: pass - returneaza false, XKs4yGC[Sm - returneaza true) \n");

        // initializarea variabilelor
        int passwordLength=8, upChars=0, lowChars=0, special=0, digits=0;
        char ch;

        Scanner s = new Scanner(System.in);
        System.out.print("Scrie o parola: ");
        String password = s.nextLine();

        int totalLength = password.length();

        if(totalLength < passwordLength) {

            System.out.println("\nParola nu contine cel putin 8 caractere!");
            promptEnterKey();
            start();

        } else {

            for(int i=0; i<totalLength; i++) {

                ch = password.charAt(i);
                if(Character.isUpperCase(ch))
                    upChars = 1;
                else if(Character.isLowerCase(ch))
                    lowChars = 1;
                else if(Character.isDigit(ch))
                    digits = 1;
                else
                    special = 1;

            }
        }

        if(upChars==1 && lowChars==1 && digits==1 && special==1)
            System.out.println("\nParola este puternica.");
        else
            System.out.println("\nParola este slaba.");

        promptEnterKey();
        start();
    }


    public static void promptEnterKey(){
        System.out.println("\n Apasa \"ENTER\" pentru a continua...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void switchcase(int problemNumber) {
        //Switch expression
        switch(problemNumber){

            //Case statements
            case 1: problem1();
                break;
            case 2: problem2();
                break;
            case 3: problem3();
                break;
            case 4: problem4();
                break;
            case 5: problem5();
                break;
            case 6: problem6();
                break;
            case 7: problem7();
                break;
            case 8: problem8();
                break;
            case 9: problem9();
                break;
            case 10: problem10();
                break;
            default: reload();
        }
    }

}
