package com.platform.chorus.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Create by A.T on 2019/4/28
 */
public class CommonTests {

    public static class Student {
        private String name;
        private int age;
        public Student(){}
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String toString(){
            return "Student [ name: "+name+", age: "+ age+ " ]";
        }
    }
    @Test
    public void jacksonTest() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"name\":\"Mahesh\", \"age\":21}";

        try {
            Student student = mapper.readValue(json, Student.class);

            assert student.age == 21;

            System.out.println(mapper.writeValueAsString(student));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
