package main.java.com.school.system.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * An entity Student composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author boni.mislyashki
 */
@Entity
@Table(name = "students")
public class Student {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An autogenerated id (unique for each Student in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  // The Student's email
  @NotNull
  private String email;
  
  // The Student's name
  @NotNull
  private String firstName;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public Student() { }

  public Student(long id) { 
    this.id = id;
  }
  
  public Student(String email, String name) {
    this.email = email;
    this.firstName = name;
  }

  // Getter and setter methods

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String value) {
    this.firstName = value;
  }
  
}
