package ru.geekbrains.homework1;

class Person {
    private Person() {
    }

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private int age;
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {

        public final Person person = new Person();

        public Builder addFirstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public Builder addLastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public Builder addMiddleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public Builder addCountry(String country) {
            this.person.country = country;
            return this;
        }

        public Builder addAddress(String address) {
            this.person.address = address;
            return this;
        }

        public Builder addAge(int age) {
            this.person.age = age;
            return this;
        }

        public Builder addGender(String gender) {
            this.person.gender = gender;
            return this;
        }

    }
}
