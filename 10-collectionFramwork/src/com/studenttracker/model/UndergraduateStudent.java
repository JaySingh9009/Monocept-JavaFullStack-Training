package com.studenttracker.model;

public class UndergraduateStudent extends Student{

    public UndergraduateStudent(int id,String name,String dept){
        super(id,name,dept);
    }

    @Override
    public String getType(){
        return "Undergraduate";
    }
}