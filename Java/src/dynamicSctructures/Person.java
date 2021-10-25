package dynamicSctructures;

public class Person {
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private String emergencyPhone;
    private String bloodType;

    public Person(String id, String name, String lastName, int age, String phone, String emergencyPhone, String bloodType) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public String getBloodType() {
        return bloodType;
    }
}
