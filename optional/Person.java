package com.example.jdbcexample.optional;

public class Person {
    private final String name;
    private final Integer age;
    private final String job;
    public Person(String name, Integer age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
