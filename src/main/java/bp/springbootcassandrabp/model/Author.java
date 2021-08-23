package bp.springbootcassandrabp.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Author {

    @PrimaryKey
    private UUID uid;
    private String firstName;
    private String lastName;
    private int age;

    public Author(){

    }

    public Author(UUID id, String firstName, String lastName, int age) {
        this.uid = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Author( String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public UUID getId() {
        return uid;
    }

    public void setId(UUID id) {
        this.uid = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Customer[uid=%d, firstName='%s', lastName='%s', age=%d]", this.uid,
                this.firstName, this.lastName, this.age);
    }
}
