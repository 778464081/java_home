package T1;

public interface StudentDao {
    public Student[] findAll();
    public  Student findBySid(int sid);
    public boolean delete(int sid);
    public boolean add(Student stu);
    public Student[] findBySname(String sname);
}
