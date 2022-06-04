package peaksoft;

public class Cities {
     private int id;
     private String name;
     private int age;
     private String square;

     public Cities(int id, String name, int age, String square) {
          this.id = id;
          this.name = name;
          this.age = age;
          this.square = square;
     }

     public Cities() {
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getAge() {
          return age;
     }

     public void setAge(int age) {
          this.age = age;
     }

     public String getSquare() {
          return square;
     }

     public void setSquare(String square) {
          this.square = square;
     }

     @Override
     public String toString() {
          return "\nCity " +
                  "№ " + id +
                  ", " + name +
                  ", age : " + age +
                  ", square  = " + square ;
     }
}
