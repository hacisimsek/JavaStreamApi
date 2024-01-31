import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);

        int sum = list.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();

        System.out.println(sum);

        System.out.println("******************");


        List<String> strings = List.of("apple", "banana", "orange", "grape", "pineapple");

        long count = strings.stream()
            .filter(s -> s.length() > 5)
            .count();

        System.out.println(count);

        System.out.println("******************");

        List <Integer> squares = list.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());

        System.out.println(squares);

        System.out.println("******************");

        int max = list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        System.out.println(max);

        System.out.println("******************");

        String concat = strings.stream()
                .collect(Collectors.joining());

        System.out.println(concat);

        System.out.println("******************");

        List<String> sortedUppercase = strings.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedUppercase);

        System.out.println("******************");


        double average = doubleList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();

        System.out.println(average);

        System.out.println("******************");

        List<String> uniqueWords = strings.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueWords);

        System.out.println("******************");


        boolean allEven = list.stream()
                .allMatch(n -> n % 2 == 0);

        System.out.println(allEven);

        System.out.println("******************");


        boolean exists = strings.stream()
                .anyMatch(s -> s.startsWith("a"));

        System.out.println(exists);

        System.out.println("******************");


        List<String> fruits = List.of("apple", "banana", "orange", "grape", "pineapple");

        fruits.stream().mapToInt(String::length).max().ifPresent(System.out::println);

        System.out.println("******************");


        List<String> nonNullValues = fruits.stream()
                .filter(s -> s != null)
                .collect(Collectors.toList());

        System.out.println(nonNullValues);

        System.out.println("******************");

        class Employee {
            private String name;
            private String department;
            private Double salary;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public Double getSalary() {
                return salary;
            }

            public void setSalary(Double salary) {
                this.salary = salary;
            }

            public Employee(String name, String department, Double salary) {
                this.name = name;
                this.department = department;
                this.salary = salary;
            }

            @Override
            public String toString(){
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", department='" + department + '\'' +
                        ", salary=" + salary +
                        '}';
            }
        }

        List<Employee> employes = List.of(
                new Employee("john","HR", 1000.0),
                new Employee("jane","HR", 1500.0),
                new Employee("jack","HR", 2000.0),
                new Employee("joe","IT", 2500.0),
                new Employee("jill","IT", 3000.0)
        );

        Map<String,Optional<Employee>> highestSalaryPerDepartment = employes.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        System.out.println(highestSalaryPerDepartment.toString());

        System.out.println("******************");

        Optional<Integer> secondSmallest = list.stream()
                .sorted()
                .skip(1)
                .findFirst();

        System.out.println(secondSmallest.get());

        System.out.println("******************");

        List<Integer> list2 = List.of(10, 20, 30, 4, 5, 60, 70, 80, 90);

        List<Integer> intersection = list.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println(intersection);


        System.out.println("******************");


    }
}