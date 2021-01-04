import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Garrett
 */
public class UserInterface2 implements DisplayUI, Observer{
    private ArrayList<Integer> grades = new ArrayList<>();
    
    public UserInterface2(Observable observable){
        observable.addObserver(this);
    }
    
    public void Display(){
        System.out.println("---------------------------------------------------");
        if(grades.isEmpty())
            System.out.println("There are no grades to display in grades.txt");
        else{
            System.out.println("Here are the grades in the file:  ");
            for(int i:grades){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
    }
    
    public void update(Observable obs, Object arg){
        if(obs instanceof FileManager){
            FileManager fileManager = (FileManager)obs;
            grades = fileManager.GetAllGrades();
            Display();           
        }
    }
}
