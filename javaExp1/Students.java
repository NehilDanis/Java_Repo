package duzenli;

import java.util.Scanner;

import duzenli.Courses;
import duzenli.Main;


public class Students {
	public String name;//öðrencinin adý
	public String surname;//öðrencinin soyadý
	public int id;//öðrencinin id numarasý
	public int credit=0;//öðrencinin sahip olduðu kredi
	public String [] lessonList=new String [8];//öðrencinin aldýðý derslerin id numaralarý
	public static int j=0;//add a students kýsmýnda girilen öðrenci sayýsýný tutar.
	public int z=0;//ogrenciye eklenen ders sayýsýný tutar.
	public static int studentid;//specific bir derse ogrenci eklerken ogrenci id yi tutar.Geçici olarak.
	public  static String courseid;//specific bir derse ogrenci eklerken course id yi tutar.Geçici olarak.
	public static int x,y;//student ve course id nin yerini tutmak için
	public static int a,b;//ogrenciyi bulmak için
	
	public static void addingMethod(Students [] ogrenci,Courses [] ders){
		System.out.println();
		System.out.println();
		Scanner s2=new Scanner (System.in);
		while(true){
			System.out.println("1.Add a student");
			System.out.println("2.Add a student to a specified course");
			System.out.println("3.Add a course");
			System.out.println("4.Return to main menu");
			System.out.println("Please choose one option that you want to execute(1,2,3,4):");
			int sayi2=s2.nextInt();
			if(sayi2==1){
				Scanner a1=new Scanner (System.in);
				Scanner a2=new Scanner (System.in);
				for(int i=Students.j;i<400;i++){
						System.out.println("Please enter an id number for a student:");
						int id2;
						id2=a1.nextInt();
						int count=0;
						for(int j=0;j<400;j++){
							if(id2==ogrenci[j].id){
								count++;
							}	
						}
						if(count<1){
							ogrenci[i].id=id2;
							System.out.println("Please enter a name for a student:");
							ogrenci [i].name=a1.next();
							System.out.println("Please enter a surname for a student:");
							ogrenci[i].surname=a1.next();
							Students.j++;
							System.out.println("Done!");
							System.out.println("Do you want to continue adding students?If you want,press 1 or press 2:");
							int sayi3=a2.nextInt();
							if(sayi3==1){
								continue;
							}
							else if(sayi3==2){
								break;
							}
							else{
								i--;
								continue;
							}
						}
						else if(count>=1){
							System.out.println("This Student has already exist.");
							System.out.println("Do you want to continue adding students?If you want,press 1 or press 2:");
							int sayi3=a2.nextInt();
							if(sayi3==1){
								continue;
							}
							else if(sayi3==2){
								break;
							}
							else{
								i--;
								continue;
							}
						}
						
					
					}//for
				}//add a student
				
				else if(sayi2==2){
					System.out.println();
					System.out.println();
					Scanner a5=new Scanner(System.in);
					Scanner a6=new Scanner(System.in);
					Scanner a7=new Scanner(System.in);
					System.out.println("Please enter your student id");
					studentid=a5.nextInt();
					System.out.println("Please enter the course's id that you want to add your lesson list:");
					courseid=a6.next();
					 int c1=0;//counter
					 int c2=0;//counter
					 int c3=0;//counter
					for(int i=0;i<400;i++){
						if(ogrenci[i].id==studentid){
							c1++;
							x=i;
							break;
						}
					}//for un sonu
					for(int i=0;i<40;i++){
						
						boolean e=courseid.equals(ders[i].courseId);
						if(e==true){
							c2++;
							y=i;
							break;
						}
					}//for un sonu
					
					for (int j=0;j<ders[y].courseQuota;j++){
						if(ders[y].studentList[j]!=null  &&  ders[y].studentList[j]==studentid){
							c3++;
							//System.out.println(c3);
							break;
						}
					}//for un sonu
			
					if(c1==1 && c2==1 && c3==0){
						if(ogrenci[x].z==8){
							System.out.println("There is no place to add a lesson.");
						}
						else if(ogrenci[x].credit+ders[y].courseCredit>22){
							System.out.println("There is no credit for adding lesson.");
							break;
						}
						else if(ogrenci[x].z<8){
						for(int i=ogrenci[x].z;i<8;i++){
							if(ogrenci[x].credit+ders[y].courseCredit<=22){
								ogrenci[x].lessonList[i]=courseid;
								ogrenci[x].credit=ogrenci[x].credit+ders[y].courseCredit;
								ogrenci[x].z++;
								break;
							}
						}
						if(ders[y].n==ders[y].courseQuota){
							System.out.println("There is no place to add a student.");
							break;
						}//if
						else if(ders[y].n<ders[y].courseQuota){
							for(int i=ders[y].n;i<ders[y].courseQuota;i++){
								ders[y].studentList[i]=studentid;
								ders[y].n++;
								break;
							}
							System.out.println("Done!");
						}//else if
					}
					
					}//if in sonu
					
					else if(c3==1){
						System.out.println("This student has already exist in this course.");
					}
					else if(c1==0){
						System.out.println("This student is not exist.");
					}
					else if(c2==0){
						System.out.println("This course is not exist.");
					}
	
				}//add a student to specific course

				else if(sayi2==3){
					Scanner a3=new Scanner(System.in);
					Scanner a4=new Scanner(System.in);
					for(int i=Courses.k;i<40;i++){
						int count=0;
						System.out.println();
						System.out.println();
						System.out.println("Please enter a course's id:");
						String courseid=a3.next();
						for(int j=0;j<40;j++){
							boolean m=courseid.equals(ders[j].courseId);
							if(m==true){
								count++;
								break;
							}
						}//for un sonu
						
						if(count==1){
							System.out.println("This course has already exist.");
							System.out.println("Do you want to continue adding courses?If you want,press 1 or press 2:");
							int sayi4=a4.nextInt();
							if(sayi4==1){
								continue;
							}
							else if(sayi4==2){
								break;
							}
							else{
								i--;
								continue;
							}
						}
						else{
							ders[i].courseId=courseid;
							System.out.println("Please enter a name for a course:");
							ders [i].courseName=a3.next();
							System.out.println("Please enter a course's credit:");
							ders[i].courseCredit=a3.nextInt();
							System.out.println("Please enter a course's quota:");
							ders[i].courseQuota=a3.nextInt();
							Courses.k++;
							System.out.println("Done!");
							System.out.println("Do you want to continue adding courses?If you want,press 1 or press 2:");
							int sayi4=a4.nextInt();
							if(sayi4==1){
								continue;
							}
							else if(sayi4==2){
								break;
							}
							else{
								i--;
								continue;
							}//else in sonu
						
						}
						
					}//for
					
					
				}//add a course
			
				else if (sayi2==4){
					break;
				}//return to main menu
				
				else{
					continue;
				}
		}//while(true)
		
	}//adding method
	
	
	public static void deletingMethod(Students [] ogrenci,Courses [] ders){
		System.out.println();
		System.out.println();
		Scanner s2=new Scanner(System.in);
		while(true){
			System.out.println("1.Delete a student by student id");
			System.out.println("2.Delete a student by student id from a specific course");
			System.out.println("3.Delete a course by course id");
			System.out.println("4.Return to main menu");
			System.out.println("Please choose one option that you want to execute (1,2,3,4)");
			int sayi2=s2.nextInt();
			
			
			if(sayi2==1){
				Scanner a1=new Scanner(System.in);
				System.out.println("Please enter a student id that you want to delete from the system:");
				int student=a1.nextInt();
				int count=0;
				int count1=0;
				for(int i=0;i<Students.j;i++){
					if(ogrenci[i].id==student){
						count++;
						x=i;
						break;
					}
				}//for -->ogrenciyi listede arattýk.
				
				if(count==1){
					for(int i=0;i<Courses.k;i++){
						for(int j=0;j<ders[i].studentList.length;j++){
							if(ders[i].studentList[j]!=null){
								if(ders[i].studentList[j]==student){
									count1++;
									for(int x=j;x<ders[i].studentList.length;x++){
										if(ders[i].studentList[x]!=null){
											ders[i].studentList[x]=ders[i].studentList[x+1];
										}
									}
									ders[i].n--;
								}
							}
						}
					}//derslerin içinden silmek için
					
					if(count1==0){
						System.out.println("This student is not registered to any of lessons.");
					}
					
					for(int i=x;i<Students.j;i++){
						if(ogrenci[i].id!=0){
							ogrenci[i].id=ogrenci[i+1].id;
							ogrenci[i].name=ogrenci[i+1].name;
							ogrenci[i].surname=ogrenci[i+1].surname;
							ogrenci[i].credit=ogrenci[i+1].credit;
							ogrenci[i].lessonList=ogrenci[i+1].lessonList;
						}
					}
					Students.j--;
					System.out.println("Done!");
					
				}//if-->silme iþlemi yapýlýr.
				else{
					System.out.println("This student is not exist.");
				}//else
				
				
			}//if sayi2==1
			
			else if(sayi2==2){
				Scanner a1=new Scanner(System.in);
				Scanner a2=new Scanner (System.in);
				System.out.println("Please enter a student id that you want to delete from specified course:");
				int student=a1.nextInt();
				System.out.println("Please enter a course id:");
				String course=a2.next();
				int count1=0;
				int count2=0;
				int count3=0;
				int count4=0;
				
				for(int i=0;i<Students.j;i++){
					if(ogrenci[i].id==student){
						x=i;
						count1++;
						break;
					}
				}//for--> ogrencinin listede var olup olmadýðýný bulduk.
				
				for(int j=0;j<Courses.k;j++){
					if(ders[j].courseId!=null){
						boolean n=course.equals(ders[j].courseId);
						if(n==true){
							y=j;
							count2++;
							break;
						}
					}
				}//for-->dersin listede olup olmadýðýný ve dersin listedeki yerini bulduk.
				
				if(count1==1 && count2==1){
					for(int i=0;i<ders[y].studentList.length;i++){
						if(ders[y].studentList[i]!=null){
							if(ders[y].studentList[i]==student){
								count3++;
								a=i;
							}
						}
					}//-->for
					if(count3==1){
						for(int i=a;i<ders[y].studentList.length;i++){
							if(ders[y].studentList[i]!=null){
								ders[y].studentList[i]=ders[y].studentList[i+1];
							}
						}
						ders[y].n--;
					}
					else if(count3==0){
						System.out.println("This student is not registered to this course.");
					}
					
					for(int j=0;j<ogrenci[x].lessonList.length;j++){
						if(ogrenci[x].lessonList[j]!=null){
							boolean n=course.equals(ogrenci[x].lessonList[j]);
							if(n==true){
								count4++;
								b=j;
							}
						}
					}//-->for
					
					if(count4==1){
						for(int i=b;i<ogrenci[x].lessonList.length;i++){
							if(ogrenci[x].lessonList[i]!=null){
								ogrenci[x].lessonList[i]=ogrenci[x].lessonList[i+1];
								ogrenci[x].credit=ogrenci[x].credit-ders[y].courseCredit;
							}
						}
						ogrenci[x].z--;
					}
					
					else if(count4==0){
						System.out.println("This course is not registered to this student.");
					}
					
					System.out.println("Done!");
				}//silme iþlemini yap.
				
				else if(count1==0){
					System.out.println("This student is not exist.");
				}
				
				else if(count2==0){
					System.out.println("This course is not exist");
				}
				
			}//else if sayi2==2
			
			
			else if(sayi2==3){
				Scanner a2=new Scanner (System.in);
				System.out.println("Please enter a course id that you want to delete from the system:");
				String course=a2.next();
				int count=0;
				int count1=0;
				for(int i=0;i<Courses.k;i++){
					if(ders[i].courseId!=null){
						boolean n=course.equals(ders[i].courseId);
						if(n==true){
							count++;
							x=i;
							break;
						}//if
					}//if
				}//for
				
				if(count==1){
					for(int i=0;i<Students.j;i++){
						for(int j=0;j<ogrenci[i].lessonList.length;j++){
							if(ogrenci[i].lessonList[j]!=null){
								boolean n=course.equals(ders[i].courseId);
								if(n==true ){
									count1++;
									for(int v=j;v<ogrenci[i].lessonList.length;v++){
										if(ogrenci[i].lessonList[v]!=null){
											ogrenci[i].lessonList[v]=ogrenci[i].lessonList[v+1];
											ogrenci[i].credit=ogrenci[i].credit-ders[x].courseCredit;
										}
									}
									ogrenci[i].z--;
								}
							}
						}
					}//ogrenciler için
					if(count1==0){
						System.out.println("This lesson is not registered to any of students.");
					}
					
					for(int i=x;i<Courses.k;i++){
						if(ders[i].courseId!=null){
							ders[i].courseId=ders[i+1].courseId;
							ders[i].courseCredit=ders[i+1].courseCredit;
							ders[i].courseName=ders[i+1].courseName;
							ders[i].courseQuota=ders[i+1].courseQuota;
							ders[i].studentList=ders[i+1].studentList;
						}
					}//genel dersler listesinden silmek için
					Courses.k--;
					System.out.println("Done!");
			
				}//ders listede mevcutsa silme iþlemine geçilir.
				
				
				
				else{
					System.out.println("This lesson is not exist.");
				}//ders listede mevcut degilse bunu basýp çýkar.
				
			}//else if sayi2==3
			
	
			else if(sayi2==4){
				break;
			}//else if sayi2==4
			
			else{
				continue;
			}
			
			
			
			
			
			
			
		}//while true
			
	}//method
	
}//class
