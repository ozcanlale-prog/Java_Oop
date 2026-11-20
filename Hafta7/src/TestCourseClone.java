public class TestCourseClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Course course1 = new Course("Data Structures");
        course1.addStudent("Ali");
        course1.addStudent("Ayşe");

        // Derin kopya oluştur
        Course course2 = (Course) course1.clone();
        course2.addStudent("Mehmet");

        System.out.println("course1 öğrenci sayısı: " + course1.getNumberOfStudents()); // 2
        System.out.println("course2 öğrenci sayısı: " + course2.getNumberOfStudents()); // 3

        // course1'in dizisi course2'den etkilenmedi mi kontrol et
        System.out.println("course1'deki 3. eleman: " + course1.getStudents()[2]); // null
        System.out.println("course2'deki 3. eleman: " + course2.getStudents()[2]); // Mehmet
    }
}