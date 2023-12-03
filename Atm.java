import java.util.Scanner;


public class Atm{


    public static void main(String[] args){
         Account account=new Account();
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("\nWelcome to ATM Machine,First Please create your account");
        System.out.print("\nEnter Your Full Name: ");
        String Name= scanner.nextLine();
        System.out.println();
        account.setpin();

        System.out.println("\nYour Initial Balance is 0.0");
        boolean quit = false;

        System.out.println("\nChoose Action\n");

        printActions();
        while (!quit) {

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    account.AddAmount();
                    break;

                case 2:
                    account.Withdrawl();
                    break;

                case 3:
                    account.CheckBalance();
                    break;

                case 4:
                    account.ChangePin();
                    break;

                case 5:
                    account.Transation();
                    break;
                case 6:
                    Quit();
                    break;

            }
            printAfterActions();
        }
    }
    public static void printActions(){
        System.out.println("                      Welcome to ATM Machine\n\n" +
                           "1.ADD MONEY                                        2.WITHDRAW \n\n"+
                           "3.BALANCE ENQUIRY                                  4.CHANGE PIN\n\n"+
                           "5.MINI STATEMENT                                   6. QUIT\n");
    }
     public static void printAfterActions(){
        System.out.println("                     \t\tChoose\n\n" +
                           "1.ADD MONEY                                        2.WITHDRAW \n\n"+
                           "3.BALANCE ENQUIRY                                  4.CHANGE PIN\n\n"+
                           "5.MINI STATEMENT                                   6. QUIT\n");
    }
    public static void Quit(){
        System.out.println("\nThank you for using ATM machine :)");
        System.exit(0);
    }

   

}
 class Account {
    double AccountBalance =0;
    int Amountadded ;
    int AmountWithdrawl;
    String b;
    int count=0;
    int sum=0;
    int arr[] = new int[100];
    int why[]= new int[100];

    Scanner a = new Scanner(System.in);

    public void AddAmount(){
        System.out.println("\nEnter the amount you want to add\n");
        Amountadded=a.nextInt();
        if(Amountadded>0){
            AccountBalance += Amountadded;
            count++;
            System.out.println("\n★ Rs "+ Amountadded +" Added Successfully in your Bank Account\n");
            for (int i =count ; i<count+1 ; i++){
                arr[i]=Amountadded;
            }
        }else{
            System.out.println("\nError : Amount not added ");
        }
    }
    public void Withdrawl(){
        System.out.println("\nEnter the amount you want to withdraw");
        AmountWithdrawl = a.nextInt();
        if(AccountBalance>AmountWithdrawl){
            sum++;
            AccountBalance=AccountBalance-AmountWithdrawl;
            System.out.println("\n★ Transaction of Rs "+AmountWithdrawl+" Successful");
            for (int j =count ; j<count+1 ; j++){
                why[j]=Amountadded;
            }
        }else
            System.out.println("Insufficient Balance");

    }
    public void CheckBalance(){
        System.out.println(AccountBalance);
    }

    public void Transation(){

        for (int i=1 ; i<count+1 ; i++){
            System.out.println("+ " + arr[i]);
        }

        for (int j = 1; j < sum + 1; j++) {
            System.out.println("- " + why[j]);
        }

    }

    public boolean setpin(){
        System.out.println("\nCreate your 4 Digit Number Pin ");
        b = a.nextLine();
        if( String.valueOf(b).length()==4) {
            if (b == null) {
                System.out.println("\nPin is null");
            }
            try {
                double  currentPin= Double.parseDouble(b);
                System.out.println("\n★ Account created Successfully.Please Do not Share your Pin ");

            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid Pin");
                System.exit(0);
                return false;
            }
        }else{
            System.out.println("\nINVALID PIN");
            System.out.println("\nCreate your 4 Digit Number Pin ");
            b = a.nextLine();
            if( String.valueOf(b).length()==4) {
                if (b == null) {
                    System.out.println("\nPin is null");
                }
                try {
                    double  currentPin= Double.parseDouble(b);
                    System.out.println("\n★ Account created Successfully.Please Do not Share your Pin ");

                } catch (NumberFormatException numberFormatException) {
                    System.out.println("\nInvalid Pin");
                    System.exit(0);
                    return false;
                }
            }else{
                System.out.println("\nINVALID PIN");
                System.exit(0);
                return false;
            }
            System.exit(0);
            return false;
        }
        return true;

    }
    public void ChangePin(){
        String temp;
        System.out.println("Enter Current Pin");
        String Currentpin = a.nextLine();
        if (String.valueOf(b).equals(Currentpin)) {
            System.out.println("\nPin Verified Successfully");
        } 
        else{
            System.out.println("\nInvalid Pin Number");
        }
        System.out.println("\nSet New Pin");
        String newPin = a.nextLine();
        System.out.println("\nPin Updated Successfully");
        temp = b;
        b=newPin;
        newPin=temp;
    }
}
