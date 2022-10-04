package com.sds.app.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Student", catalog = "qLStudent")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masv")
    private int maSv;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "score", nullable = false, columnDefinition = "0")
    private float score;

    @Column(name = "class", nullable = false)
    private String clazz;

    public Student(int maSv, String name, float score, String clazz) {
        this.maSv = maSv;
        this.name = name;
        this.score = score;
        this.clazz = clazz;
    }

    public Student() {}

    public Student(String name, float score, String clazz) {
        this.name = name;
        this.score = score;
        this.clazz = clazz;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
