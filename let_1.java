public class Main {
    public static void main(String[] args) {
        BaumanStudent student = new BaumanStudent("Даниил", "ИУ");
        System.out.println(student.Education());
        System.out.println(student.desireToStudy());
        System.out.println(student.passExams());
        System.out.println(student.getDepartment());
    }

    public abstract static class Student {
        private String name;
        public Student(String name) {
            this.name = name;
        }
        public abstract String Education();
        public abstract String desireToStudy();
    }
    public static class BaumanStudent extends Student {
        private String department;

        public BaumanStudent(String name, String departament) {
            super(name);
            this.department = departament;
        }

        public String Education() {
            return "ВУЗ";
        }

        public String desireToStudy(){
            return "Да";
        }

        public String passExams() {
            return "сдаю";
        }

        public String getDepartment(){
            return department;
        }
    }
}
