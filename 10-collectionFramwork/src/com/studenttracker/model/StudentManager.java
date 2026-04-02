package com.studenttracker.model;
import java.util.*;

public class StudentManager {

    private Set<Student> students = new HashSet<>();

    private Map<String,List<Student>> deptMap = new HashMap<>();


    public void addStudent(Student s){

        if(!students.add(s)){
            System.out.println("Duplicate student ID not allowed");
            return;
        }

        deptMap
                .computeIfAbsent(s.getDepartment(),k->new ArrayList<>())
                .add(s);

        System.out.println("Student added");
    }


    public void addMarks(int id,String subject,int marks){

        for(Student s:students){

            if(s.getStudentId()==id){

                s.addMarks(subject,marks);

                System.out.println("Marks added");
                return;
            }
        }

        System.out.println("Student not found");
    }


    public void showStudents(){

        students.forEach(System.out::println);
    }


    // ranking
    public void showRanking(){

        TreeSet<Student> ranking = new TreeSet<>(students);

        ranking.forEach(System.out::println);
    }


    // department grouping
    public void showByDepartment(String dept){

        List<Student> list = deptMap.get(dept);

        if(list==null){
            System.out.println("No students found");
            return;
        }

        list.forEach(System.out::println);
    }


    // custom sorting (by name)
    public void sortByName(){

        List<Student> list = new ArrayList<>(students);

        list.sort((a,b)->a.getName().compareToIgnoreCase(b.getName()));

        list.forEach(System.out::println);
    }


    public void removeIneligible(){

        Iterator<Student> itr = students.iterator();

        while(itr.hasNext()){

            Student s = itr.next();

            if(s.getAverage()<40){

                itr.remove();

                System.out.println("Removed: "+s.getName());
            }
        }
    }
}
