import java.io.*;
import java.util.*;
public class StudentManagementSystem {
    Static HashMap<Integer,String>studentMap=new HashMap<>();
    S00tatic final String FILE_NAME="students.txt";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n --student management menu--");
            System.out.println("1.Add student");
            System.out.println("2.save to file");
            System.out.println("3.load from file");
            System.out.println("4.search by IO");
            System.out.println("5.remove student");    
            System.out.println("6.Display ALL students");
            System.out.println("0.exit");
            System.out.println("enter choice:");
            choice=sc.nextInt();
            switch(choice){
                case 1->addStudent(sc);
                case 2->saveToFile();
                case 3->loadFromFile();
                case 4->searchStudent(sc);
                case 5->removeStudent(sc);
                case 6->displayAll();
                case 0->System.out.println("exiting program.");
                default ->System.out.println("invalid choice.try again.");
            }
        }
while(choice!=0) {
            sc.close();
        }
        static void addStudent(Scanner sc) {
            System.out.println("enter student ID");
            int id=sc.nextLine();
            System.out.print("enter student name");
            String name=sc.nextLine();
            if(studentMap.containsKey(id)){
                System.out.println("ID already exits!");
            }
            else
            {
                studentMap.put(id,name);
                System.out.println("Student added.");
            }
        }
        static void saveToFile(){
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_NAME))){
                for(Map.Entry<Integer,String>entry:studentMap.entrySet()){
                    bw.write(entry.getKey()+","+entry.getValue());
                    bw.newLine();
                }
                Catch(IOException e){
                    System.out.println("error saving to file:"+e.getMessage());
                }
            }
            static void loadFromFile(){
                studentMap.clear();
                try(BufferedReader br=new BUfferedReader(new FileReader(FILE_NAME))){
                    String line;
                    while((line=br.readLine())!=null){
                        String[] parts=line.split(",");
                        int id=Integer.parseInt(parts[0]);
                        String name=parts[1];
                        studentMap.put(id,name);
                    }
                    System.out.println("data loaded from file.");
                }catch (IOException e){
                    System.out.println("Error loading from file:"+e.getMessage());
                }
            }
            static void searchStudent(Scanner sc){
                System.out.print("EnterID to search:");
                int id=sc.nextInt();
                if(studentMap.containsKey(id)){
                    System.out.println("Name:"+studentMap.get(id));
                }
                else
                {
                    System.out.println("student ID not found");
                }
            }
            static void removeStudent(Scanner sc){
                System.out.println("Enter ID to remove");
                int id=sc.nextInt();
                if(studentMap.remove(id)!=null){
                    System.out.println("student removed");
                }
                else
                {
                    System.out.println(" ID not found");
                }
            }
            static void displayAll(){
                if(studentMap.isEmpty()){
                    System.out.println("no students to display");
                }
                else{
                    System.out.println("\nStudent List:");
                    for(Mao.Entry<Integer,String>entry:studentMap.entrySet()){
                        System.out.println("ID:"+entry.getKey()+",Name:"+entry.getValue());
                    }
                }
            }
        }
    }
}