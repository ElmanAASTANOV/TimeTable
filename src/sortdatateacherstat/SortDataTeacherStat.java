/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortdatateacherstat;

import java.util.ArrayList;
import java.util.List;
 

class Teacher {
    public Teacher( String Name,int Age){
        this.Name = Name;
        this.Age = Age;
        
        if(Age >= 20 && Age < 30) this.Stat = 60;
        if(Age >= 30 && Age < 40) this.Stat = 55;
        if(Age >= 40 && Age < 50) this.Stat = 40;
        if(Age >= 50 && Age < 60) this.Stat = 35;
        if(Age >= 60 && Age < 70) this.Stat = 40; 
    }
    
    public void setStat(int newStat)
    {
       this.Stat = newStat; 
    }
    
    public int getStat()
    {
        return Stat;
    }
    int ID;
    String Name;
    int Age;
    int Stat;
    
    
}

class Subject
{
    public Subject(String Name,int Stat){
        this.Name = Name;
        this.Stat = Stat;
               
    }
     String Name;
     int Stat;
    
 }   
class Table{
  String TeacherName;    
  String SubjectName;  
}

public class SortDataTeacherStat {

   
    
    private static void SortTeacherStat(List<Teacher> list)
    {
        Teacher HTeacher = null;
        boolean sorted;
        
        for(int i=0;i<list.size();i++)
        {
        sorted  = true;
            
            for(int j=0;j<list.size()-i-1;j++)
            {
                
                if(list.get(j).Stat < list.get(j+1).Stat)
                {   
                    HTeacher = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1,HTeacher);
                    sorted = false;
                }
            }
            if(sorted) break;
        }
    }
    private static void ShowTeachersData(List<Teacher> teachers)
{
    for(int i=0;i<teachers.size();i++)
        {
         System.out.println(teachers.get(i).Stat + " - " + teachers.get(i).Name + " - " + teachers.get(i).Age);
               
        }
    System.out.println();
}
    private static void ShowTablesData(List<Table> tables)
    {
        for (int i = 0; i < tables.size()-1; i++)
        {
         System.out.println(tables.get(i).SubjectName + " - " + tables.get(i).TeacherName);
        }
    }
    
    static void CreateTables(List<Teacher> teachers,List<Subject> subjects,List<Table> tables)
    {
        Table currentTable;
        
        for (int i = 0; i < subjects.size(); i++) {
        currentTable = new Table();
        
        currentTable.SubjectName = subjects.get(i).Name;
        currentTable.TeacherName = teachers.get(0).Name;
        tables.add(currentTable);
        
        teachers.get(0).setStat(teachers.get(0).getStat()-subjects.get(i).Stat);
        SortTeacherStat(teachers);
        }
        
    }
    
    public static void main(String[] args)
    {
        List<Table> tables = new ArrayList<Table>();
        List<Subject> subjects = new ArrayList<Subject>();
        subjects.add(new Subject("Fizika",10));
        subjects.add(new Subject("Fizika",10));
        subjects.add(new Subject("Fizika",10));
        subjects.add(new Subject("Fizika",10));
        subjects.add(new Subject("Fizika",10));
        subjects.add(new Subject("Fizika",10));
      
        subjects.add(new Subject("Riyazi Analiz",15));
        subjects.add(new Subject("Riyazi Analiz",15));
        subjects.add(new Subject("Riyazi Analiz",15));
        subjects.add(new Subject("Riyazi Analiz",15));
        subjects.add(new Subject("Riyazi Analiz",15));
        subjects.add(new Subject("Riyazi Analiz",15));
        
        
        subjects.add(new Subject("Ehtimal Nezeriyyesi",5));
        subjects.add(new Subject("Ehtimal Nezeriyyesi",5));
        subjects.add(new Subject("Ehtimal Nezeriyyesi",5));
        subjects.add(new Subject("Ehtimal Nezeriyyesi",5));
        subjects.add(new Subject("Ehtimal Nezeriyyesi",5));
        subjects.add(new Subject("Ehtimal Nezeriyyesi",5));
        
        subjects.add(new Subject("Riyazi Statistika",5));
        subjects.add(new Subject("Riyazi Statistika",5));
        subjects.add(new Subject("Riyazi Statistika",5));
        subjects.add(new Subject("Riyazi Statistika",5));
        subjects.add(new Subject("Riyazi Statistika",5));
        subjects.add(new Subject("Riyazi Statistika",5));
        
        
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("x1",23));
        teachers.add(new Teacher("x2",56));
        teachers.add(new Teacher("x3",34));
        teachers.add(new Teacher("x4",42));
        teachers.add(new Teacher("x5",27));
        
        
        
    
        //ShowTeachersData(teachers);
        SortTeacherStat(teachers);
        ShowTeachersData(teachers);
        
        CreateTables(teachers,subjects,tables);
        ShowTablesData(tables);
    
        SortTeacherStat(teachers);
        ShowTeachersData(teachers);
        
    
    
    }
    
}





