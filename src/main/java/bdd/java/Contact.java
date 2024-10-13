package bdd.java;
import java.time.LocalDate;

public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String pseudo;
    private String email;
    private LocalDate birthDate;
    private String address;
    private String personalPhoneNumber;
    private String professionalPhoneNumber;
    private String linkedInLink;
    private String gitLink;

    public Contact(int id, String firstName, String lastName, String gender, String pseudo, String email, LocalDate birthDate, String address, String personalPhoneNumber, String professionalPhoneNumber, String linkedInLink, String gitLink) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.pseudo = pseudo;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.personalPhoneNumber = personalPhoneNumber;
        this.professionalPhoneNumber = professionalPhoneNumber;
        this.linkedInLink = linkedInLink;
        this.gitLink = gitLink;
    }
    public Contact(String firstName, String lastName, String gender, String pseudo, String email, LocalDate birthDate, String address, String personalPhoneNumber, String professionalPhoneNumber, String linkedInLink, String gitLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.pseudo = pseudo;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.personalPhoneNumber = personalPhoneNumber;
        this.professionalPhoneNumber = professionalPhoneNumber;
        this.linkedInLink = linkedInLink;
        this.gitLink = gitLink;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getpersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public String getprofessionalPhoneNumber() {
        return professionalPhoneNumber;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birtDate) {
        this.birthDate = birtDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setpersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public void setprofessionalPhoneNumber(String professionalPhoneNumber) {
        this.professionalPhoneNumber = professionalPhoneNumber;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact{");
        sb.append("id=").append(id);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", gender=").append(gender);
        sb.append(", pseudo=").append(pseudo);
        sb.append(", email=").append(email);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", address=").append(address);
        sb.append(", personalPhoneNumber=").append(personalPhoneNumber);
        sb.append(", professionalPhoneNumber=").append(professionalPhoneNumber);
        sb.append(", linkedInLink=").append(linkedInLink);
        sb.append(", gitLink=").append(gitLink);
        sb.append('}');
        return sb.toString();
    }
}
