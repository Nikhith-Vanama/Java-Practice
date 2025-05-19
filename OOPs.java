class Student extends Object
{
int id;
String name;
double marks;
String branch;
Student()
{
}
Student(int id,String name,double marks,String branch)
{
this.id=id;
this.name=name;
this.marks=marks;
this.branch=branch;
}
public String toString()
{
return ("id = "+id+" name is "+name+" marks = "+marks+" branch is "+branch);
}
}
class Object
{
public static void main(String[] args)
{
Student s1=new Student(101,"nikhith",87,"MCA");
Student s2=new Student(102,"Sree",93,"MCA");
System.out.println(s1);
System.out.println(s2);
}
}