
import java.util.ArrayList;
import java.util.Observable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Garrett
 */
public class FileManager extends Observable{
    
    private static FileManager instance = null;
    private FileManager(){ 
        try{
            String filename = "grades.txt";
            File file = new File(filename);
            if(file.createNewFile()){
                System.out.println("A new grades.txt will be used");
            }
            else{
                System.out.println("An existing grades.txt will be used");
            }
        
        } catch(IOException e){
            System.out.println("An error has occurred creating FileManager");
            e.printStackTrace();
        }
        
    }
    
    public static synchronized FileManager GetInstance(){
        if(instance == null)
            instance = new FileManager();
        return instance;
    }
    
    void AddGrade(int grade){
        try{
            File file = new File("grades.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write(grade + " ");
            fw.close();
            System.out.println("Grade successfully added");
            setChanged();
            notifyObservers();
        } catch (IOException e){
            System.out.println("An error has occurred adding a grade");
            e.printStackTrace();
        }
    }
    
    Integer GetFirstGrade(){
        try{
            File file = new File("grades.txt");
            Scanner fin = new Scanner(file);
            Integer first = null;
            if(fin.hasNextInt())
                first = fin.nextInt();
            fin.close();
            return first;
        } catch (IOException e){
            System.out.println("An error has occurred getting the first grade");
            e.printStackTrace();
        }
        return null;
    }
    
    ArrayList<Integer> GetAllGrades(){
        ArrayList<Integer> grades = new ArrayList<>();
        try{
            File file = new File("grades.txt");
            Scanner fin = new Scanner(file);
            while(fin.hasNextInt())
                grades.add(fin.nextInt());
            fin.close();
        } catch (IOException e){
            System.out.println("An error has occurred getting the first grade");
            e.printStackTrace();
        }    
        return grades;
    }
    
    void DeleteAllGrades(){
        try{
            File file = new File("grades.txt");
            FileWriter fw = new FileWriter(file, false);
            fw.close();
            System.out.println("Grades successfully deleted");
            setChanged();
            notifyObservers();
        } catch (IOException e){
            System.out.println("An error has occurred deleting grades");
            e.printStackTrace();
        }
    }
}
