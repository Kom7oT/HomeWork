package HomeWork5;

public class HomeWorkApp5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван", "Директор", "ivanovi@mail.ru", "123456789", 340000, 41);
        employees[1] = new Employee("Борисов Иван", "Управляющий", "ivanovi@mail.ru", "1234789", 780000, 34);
        employees[2] = new Employee("Сгибнев Алесандр", "Менеджер", "ivadvi@mail.ru", "12656789", 340000, 43);
        employees[3] = new Employee("Иванов Борис", "Уборщик", "ivsdfvi@mail.ru", "1234545389", 560000, 56);
        employees[4] = new Employee("Роганева Юлия", "Директор", "ivagfhovi@mail.ru", "1234345789", 1340000, 34);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge()>40)
                employees[i].print();
        }
    }
}
