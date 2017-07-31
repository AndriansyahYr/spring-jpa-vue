package com.example.demo.Model;

import javax.persistence.*;

/**
 * Created by Andriansyah YR on 7/29/2017.
 */
@Entity
@Table(name = "users")
public class Users {

    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "salary")
    private Integer Salary;
    @Column(name = "is_deleted")
    private String isDeleted;

    @Id
    @GeneratedValue
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
