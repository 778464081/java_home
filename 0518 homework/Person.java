public class Person{
    public String name;
    public char gender;
    public int age;
    public boolean married;
    public void marry(Person another){
        if(this.married==false && another.married==false){
           if(this.gender!=another.gender){
                if(this.gender=='男'){
                    if(this.age>=22 || another.age>=20){
                        System.out.println(this.name +"可以和" + another.name + "结婚");
                    }else{
                        System.out.println("有人未满足年龄");
                    }
                }
                if(this.gender=='女'){
                    if(this.age>=20 || another.age>=22){
                        System.out.println(this.name +"可以和" + another.name + "结婚");
                    }else{
                        System.out.println("有人未满足年龄");
                    }
                }

           }else{
               System.out.println("异性才可结婚");
           }
        }else{
            System.out.println("有人已婚");
        }
    }
    public static void main(String[] args) {
        Person a =new Person();
        Person b =new Person();
        a.name="小美";
        a.gender='女';
        a.age=20;
        a.married=false;
        b.name = "小明";
        b.gender = '男';
        b.age=22;
        b.married=false;
        a.marry(b);
    }
}