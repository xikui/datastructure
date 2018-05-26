package com.hnxljd.list;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @author : hnxljd
 * @date : Created in 0:10 2018/5/27
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;

    public boolean equals(User o) {
        return Objects.equals(name, o.name) &&
                Objects.equals(age, o.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
