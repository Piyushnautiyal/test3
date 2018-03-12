package com.deepcloning;
/*
 *Deep copy of an object will have exact copy of all the fields of original object just like shallow copy. 
 *But in additional, if original object has any references to other objects as fields, 
 *then copy of those objects are also created by calling clone() method on them.
 That means clone object and original object will be 100% disjoint. They will be 100% independent of each other. 
 Any changes made to clone object will not be reflected in original object or vice-versa.
 */
public class DeepCopyInJava
{
    public static void main(String[] args)
    {
        Course science = new Course("Physics", "Chemistry", "Biology");
 
        Student student1 = new Student(111, "John", science);
 
        Student student2 = null;
 
        try
        {
            //Creating a clone of student1 and assigning it to student2
 
            student2 = (Student) student1.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
 
        //Printing the subject3 of 'student1'
 
        System.out.println(student1.course.subject3);         //Output : Biology
 
        //Changing the subject3 of 'student2'
 
        student2.course.subject3 = "Maths";
 
        //This change will not be reflected in original student 'student1'
 
        System.out.println(student1.course.subject3);       //Output : Biology
    }
}