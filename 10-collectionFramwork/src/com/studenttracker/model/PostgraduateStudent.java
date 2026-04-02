package com.studenttracker.model;

public class PostgraduateStudent extends Student{

    public PostgraduateStudent(int id,String name,String dept){
        super(id,name,dept);
    }

    @Override
    public String getType(){
        return "Postgraduate";
    }
}