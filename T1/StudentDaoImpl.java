package T1;

import java.util.Arrays;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student[] findAll() {
        System.out.println("全部成员分别为：");
        int lengt = StudentDB.students.length;
        for (int i=0;i<lengt;i++){
            System.out.println( StudentDB.students[i].name);
        }
       return StudentDB.students;
    }

    @Override
    public Student findBySid(int sid) {     //根据学号查找学生
        int j =0;
        int lengt = StudentDB.students.length;
        for (int i = 0; i < lengt; i++) {
            if (StudentDB.students[i].sid ==sid){
                System.out.print("姓名：" + StudentDB.students[i].name
                + "学号：" +StudentDB.students[i].sid + "年龄：" + StudentDB.students[i].age +
                        " 学分 ： " + StudentDB.students[i].score);
                 j =i;
            }
        }
        return StudentDB.students[j];
    }

    @Override
    public boolean delete(int sid) {
        int lengt = StudentDB.students.length;
        Student[] fpx =Arrays.copyOf(StudentDB.students,lengt-1);
        for (int i = 0; i < lengt; i++) {
            if (StudentDB.students[i].sid == sid){
                for (int j = i; j <lengt-1 ; j++) {
                    fpx[j] = StudentDB.students[j+1];
                }
            }
        }
        StudentDB.students =Arrays.copyOf(fpx,lengt-1);
        return  true;
    }

    @Override
    public boolean add(Student stu) {
        int length =StudentDB.students.length;
        Student[] fpx = Arrays.copyOf(StudentDB.students,length+1);
        fpx[length+1] =stu;
        StudentDB.students =Arrays.copyOf(fpx,length-5);
        return true;
    }

    @Override
    public Student[] findBySname(String sname) {
            int length =StudentDB.students.length;
            int j=0;
        for (int i = 0; i < length; i++) {
            if (StudentDB.students[i].name ==sname){
                j=i;
                System.out.print("姓名：" + StudentDB.students[i].name
                        + "学号：" +StudentDB.students[i].sid + "年龄：" + StudentDB.students[i].age +
                        " 学分 ： " + StudentDB.students[i].score);
            }
        }
        return StudentDB.students;
    }
    public  static void showgui(){
        StudentDaoImpl one =new StudentDaoImpl();
        Scanner in =new Scanner(System.in);
        while (true){
            System.out.println("查询全部--------------1");
            System.out.println("按学号查找-------------2");
            System.out.println("按名字查找-------------3");
            System.out.println("添加学生---------------4");
            System.out.println("删除学生---------------5");
            int x = in.nextInt();
            switch (x){
                case 1:
                    one.findAll();
                    for (int i=0;i<2;i++){
                        System.out.println(StudentDB.students[i].name);
                    }
                    break;
                case 2:
                    System.out.println("请输入需要查询的学生学号：");
                    int sid =in.nextInt();
                    System.out.println(one.findBySid(sid));
                    break;
                case 3:
                    System.out.println("等下在做这个功能~！");
                    break;
                case 4:
                    Student stu =new Student();
                    System.out.println("请分别输入学生学号，姓名，年龄，分数");
                    stu.setSid(in.nextInt());
                    stu.setName(in.next());
                    stu.setAge(in.nextInt());
                    stu.setScore(in.nextInt());
                    one.add(stu);
                    break;
            }
        }
    }
    public static void main(String[] args) {

//        StudentDB one =new StudentDB();
        StudentDaoImpl.showgui();

    }
}
