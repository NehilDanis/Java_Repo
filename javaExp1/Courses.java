package duzenli;

import java.util.Scanner;

import duzenli.Main;
import duzenli.Students;

public class Courses {
	public String courseName;//derslerin isimleri
	public String courseId;//derslerin id numaralarý
	public int courseCredit;//derslerin kredileri
	public int courseQuota;//derslerin kotalarý
	public Integer [] studentList=new Integer [100] ;//dersi alan öðrencilerin id no listesi
	public static int k=0;//add a course kýsmýnda girilen ders sayýsýný tutar.
	public int n=0;//derse eklenen ogrenci sayýsýný tutuyor.
	public static int x,y;//öðrenci ve kursun yerini tutmak için 
	
	public static void listingMethod(Students [] ogrenci,Courses [] ders){
		System.out.println();
		System.out.println();
		Scanner s2=new Scanner(System.in);
		while(true){
			System.out.println("1.List all students who registered a specified course");
			System.out.println("2.List all courses that a student registered");
			System.out.println("3.List all students");
			System.out.println("4.List all courses");
			System.out.println("5.Return to main menu");
			System.out.println("Please choose one option that you want to execute(1,2,3,4,5):");
			int sayi2=s2.nextInt();
			if(sayi2==1){
				Scanner a1=new Scanner(System.in);
				System.out.println("Please enter a course id to list all students who registered this course:");
				String course=a1.next();
				int count=0;
				for(int i=0;i<40;i++){
					boolean m=course.equals(ders[i].courseId);
					if(m==true){
						count++;
						x=i;
						break;
					}
				}//for un sonu
				
				if(count==0){
					System.out.println("This course is not exist:");
				}
				else{
						System.out.println(ders[x].courseName+"   "+ders[x].courseCredit+"   "+ders[x].courseQuota);
						searchingMethod(ders,ogrenci,x);
				}//else
				
					
			}//if sayi2==1 in sonu
			else if(sayi2==2){
				Scanner a2=new Scanner(System.in);
				int student;
				System.out.println("Please enter e student id to list all courses that this student registered:");
				student=a2.nextInt();
				int count=0;
				for(int i=0;i<Students.j;i++){
					if(ogrenci[i].id==student){
						count++;
						y=i;
						break;
					}
				}//for
				if(count==0){
					System.out.println("This student is not exist.");
				}
				else{
					System.out.println(ogrenci[y].name+"   "+ogrenci[y].surname);
					searchingMethod2(ders,ogrenci,y);
				}
				
				
			}//ogrencinin kursunu listeleme
			
			
			else if(sayi2==3){
				for(int i=0;i<Students.j;i++){
					System.out.println(ogrenci[i].id+"  "+ogrenci[i].name+"  "+ogrenci[i].surname);
				}
				System.out.println();
				System.out.println();
			}
			else if(sayi2==4){
				for(int i=0;i<Courses.k;i++){
					System.out.println(ders[i].courseId+"  "+ders[i].courseName+"  "+ders[i].courseCredit+"  "+ders[i].courseQuota);
				}
				System.out.println();
				System.out.println();
			}
			else if(sayi2==5){
				break;
			}
			else{
				continue;
			}
			
		}
	}
	
public static void searchingMethod(Courses [] ders,Students [] ogrenci,int x){
	for(int i=0;i<ders[x].studentList.length;i++){
		if(ders[x].studentList[i]!=null){
			for(int j=0;j<Students.j;j++){
				if(ders[x].studentList[i]==ogrenci[j].id){
					System.out.println(ogrenci[j].id+"   "+ogrenci[j].name+"   "+ogrenci[j].surname);
				}
			}
		}
	}
}//gelen ogrenci numaralarýný listede bulur ve bu numaraya sahip öðrencilerin adýný soyadýný id sini bastýrýr.

public static void searchingMethod2(Courses [] ders,Students [] ogrenci,int y){
	for(int i=0;i<ogrenci[y].lessonList.length;i++){
		if(ogrenci[y].lessonList[i]!=null){
			for(int j=0;j<Courses.k;j++){
				boolean n=(ogrenci[y].lessonList[i]).equals(ders[j].courseId);
				if(n==true){
					System.out.println(ders[j].courseId+"   "+ders[j].courseName+"   "+ders[j].courseCredit+"   "+ders[j].courseQuota);
				}
			}
		}
	}
}//gelen ders id lerini listeden bulur ve bunlarýn bilgilerini bastýrýr.


}//class
