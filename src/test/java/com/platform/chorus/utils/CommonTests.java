package com.platform.chorus.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

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

    @Test
    public void jsonTreeTest() {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"name\":\"Mahesh\", \"age\":21, \"a\": null}";
        try {
            JsonNode node = mapper.readTree(json);
            JsonNode haha = node.get("haha");
            assert node.hasNonNull("a");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void jsonTest2() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[" +
                "[\"chorus.Pupil\",\"name\",\"string\",\"张二虎\"]," +
                "[\"chorus.Pupil\",\"age\",\"integer\",20]," +
                "[\"chorus.Pupil\",\"gender\",\"string\",\"male\"]," +
                "[\"chorus.Pupil\",\"id\",\"integer\",10001]," +
                "[\"chorus.Pupil\",\"hobby\",\"string\",\"football\"]," +
                "[\"chorus.School\",\"name\",\"string\",\"上海中学\"]," +
                "[\"chorus.School\",\"address\",\"string\",\"上海市中心\"]" +
                "]";

        try {
            String[][] out = mapper.readValue(json, String[][].class);
            System.out.println(out.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
