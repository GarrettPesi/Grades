import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Garrett
 */
public class UserInterface1 implements DisplayUI, Observer{
    private Float average;
    
    public UserInterface1(Observable observable){
        observable.addObserver(this);
    }
    
    public void Display(){
        System.out.println("---------------------------------------------------");
        if(average.isNaN())
            System.out.println("There are no grades to average in grades.txt");
        else
            System.out.println("The average grade is:  " + average);
        System.out.println("---------------------------------------------------");
    }
    
    public void update(Observable obs, Object arg){
        if(obs instanceof FileManager){
            FileManager fileManager = (FileManager)obs;
            int num = 0, sum = 0;
            ArrayList<Integer> grades = new ArrayList<>();
            grades = fileManager.GetAllGrades();
            for(int i:grades){
                sum += i;
                num++;
            }
            average = (float)sum/num;
            Display();
            
        }
    }

}
