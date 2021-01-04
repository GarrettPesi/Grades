import java.util.Scanner;

/**
 *
 * @author Garrett
 */
public class grades {
    

    public static void main(String[] args) {
        FileManager fm = FileManager.GetInstance();
        UserInterface2 ui2 = new UserInterface2(fm);
        UserInterface1 ui1 = new UserInterface1(fm);
        Scanner keyboard = new Scanner(System.in);
        
        while(true){
            System.out.println("Enter 1 to add a grade, 2 to delete all grades, or 3 to quit");
            int choice = keyboard.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Please enter a new grade:");
                    int grade = keyboard.nextInt();
                    fm.AddGrade(grade);
                    break;
                case 2:
                    System.out.println("Deleting all grades...");
                    fm.DeleteAllGrades();
                    break;
                case 3:
                    System.out.println("Performing some tests before quitting");
                    fm.DeleteAllGrades();
                    System.out.println("Displaying empty grades:  ");
                    for(int i:fm.GetAllGrades()){
                        System.out.print(i + " ");
                    }
                    System.out.println("\nCalling GetFirstGrade while empty:  ");
                    System.out.println(fm.GetFirstGrade());
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
        
    }
    
}
