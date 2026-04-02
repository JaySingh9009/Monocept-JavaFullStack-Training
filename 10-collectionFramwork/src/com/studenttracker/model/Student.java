package com.studenttracker.model;

import java.util.*;

import com.LibrarySystem.model.Book;

public abstract class Student implements Comparable<Student>{

    private int studentId;
    private String name;
    private String department;

    private Map<String,Integer> marks = new HashMap<>();

    public Student(int id,String name,String dept){
        this.studentId=id;
        this.name=name;
        this.department=dept;
    }

    public int getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public void addMarks(String subject,int score){
        marks.put(subject,score);
    }

    public double getAverage(){

        if(marks.isEmpty()) return 0;

        int sum=0;

        for(int m:marks.values())
            sum+=m;

        return sum/(double)marks.size();
    }

    public abstract String getType();

    @Override
    public int compareTo(Student s){
        return Double.compare(s.getAverage(),this.getAverage());
    }

    @Override
    public boolean equals(Object obj){

        if(this==obj) return true;

        if(obj == null || !(obj instanceof Student)) return false;

        Student s=(Student)obj;

        return studentId==s.studentId;
    }

    @Override
    public int hashCode(){
        return Objects.hash(studentId);
    }

    @Override
    public String toString(){

        return "ID:"+studentId+
                " Name:"+name+
                " Dept:"+department+
                " Avg:"+getAverage()+
                " Type:"+getType();
    }
}