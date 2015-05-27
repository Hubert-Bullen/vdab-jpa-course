package be.vdab;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Transient
    private int age;

    private byte[] image;

    @Enumerated(EnumType.STRING)
    private PassengerType type;

    @Temporal(TemporalType.DATE)
    @Access(AccessType.PROPERTY)
    private Date dateOfBirth;

    /**
     * Only used by JPA.
     */
    protected Passenger() {
    }

    public Passenger(String firstName, String lastName, PassengerType type, Date dateOfBirth, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.image = image;
        setDateOfBirth(dateOfBirth);
    }

    public Integer getId() {
        return id;
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

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        assignAge(dateOfBirth);
    }

    /**
     * TODO: Take into account the month and day.
     * @param dateOfBirth The birthdate to deduct the age for.
     */
    private void assignAge(Date dateOfBirth) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        this.age = Calendar.getInstance().get(Calendar.YEAR)
                - dob.get(Calendar.YEAR);
    }
}
