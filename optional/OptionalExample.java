package com.example.jdbcexample.optional;

import com.example.jdbcexample.optional.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExample {
    public static void main(String[] args){
        Person person = new Person(null,28,"SE");
        Optional<Person> personalOption = Optional.ofNullable(person);

        personalOption.ifPresent(p->{
            Optional<String> name = Optional.ofNullable(p.getName());
            String upperCaseName = name.map(x->x.toUpperCase()).orElse("Empty String");
            System.out.println(upperCaseName);
        });

        //Use filter() and map()
        List<Person> personList = Arrays.asList(
                new Person("Andrew", 28, null),
                new Person("John", 34, "QA"),
                new Person("Peter", 43, "SE"),
                new Person("Tim", 39, "TL")
        );
        List<Person> agedPersonList = personList.stream().filter(x->x.getAge()<30).collect(Collectors.toList());
        Optional<Person> optionalList = Optional.ofNullable(agedPersonList.get(0));
        optionalList.ifPresent(x->{
            Optional<String> job = Optional.ofNullable(x.getJob());
            Optional<String> name = Optional.ofNullable(x.getName());
            String uppercasejob = job.map(j->j.toUpperCase()).orElse("Empty Job");
            String uppercasename = name.filter(f->f.equals("Andrew")).map(n->n.toUpperCase()).orElse("Empty name");

            System.out.println("Job "+uppercasejob);
            System.out.println("Name "+uppercasename);

        });


    }
}

