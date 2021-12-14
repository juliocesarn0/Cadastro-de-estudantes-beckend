package com.cadastroestudantes.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
export interface Student {
    id: number
    ra: number;
    name: string;
    age: number;
    studentClass: string;
    parentName: string;
}*/

@Entity
@Table(name = "TB_STUDENT")

public class Student implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long ra;
    private String name;
    private Long age;
    private String sala;
    private String parent;

    //id
    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    //ra
    public Long getRa(){
        return ra;
    }

    public void setRa(Long ra){
        this.ra = ra;
    }

    //name
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    //age
    public Long getAge() {

        return age;
    }

    public void setAge(Long age) {

        this.age = age;
    }
    
    //studentClass
    public String getSala() {

        return sala;
    }

    public void setSala(String sala) {

        this.sala = sala;
    }

    //parentName
    public String getParent() {

        return parent;
    }

    public void setParent(String parent) {

        this.parent = parent;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", id=" + id + ", name=" + name + ", parent=" + parent + ", ra=" + ra + ", sala="
                + sala + "]";
    }    
}
