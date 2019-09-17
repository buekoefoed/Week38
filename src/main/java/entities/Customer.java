package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@NamedQuery(name = "Customer.deleteAllRows", query = "DELETE from Customer ")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    //Hobbies
    @ElementCollection
    @CollectionTable(
            name = "HOBBY",
            joinColumns = @JoinColumn(name = "Customer_ID")
    )
    @Column(name = "hobby")
    private List<String> hobbies = new ArrayList<>();

    //Phone numbers
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "PHONE",
            joinColumns = @JoinColumn(name = "Customer_ID")
    )
    @MapKeyColumn(name = "phone_nr")
    @Column(name = "description")
    private Map<String, String> phones = new HashMap<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addHobby(String s) {
        this.hobbies.add(s);
    }

    public String getHobbies() {
        return String.join(",", hobbies);
    }

    public void addPhone(String phoneNo, String description) {
        this.phones.put(phoneNo, description);
    }

    public String getPhoneDescription(String phoneNo) {
        return this.phones.get(phoneNo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
