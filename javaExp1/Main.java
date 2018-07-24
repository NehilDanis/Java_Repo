package duzenli;

import java.util.Scanner;

import duzenli.Courses;
import duzenli.Students;

public class Main {

	public static void main(String[] args) {
		Students [] ogrenci=new Students[400];
		Courses [] ders=new Courses [40];
		for(int i=0;i<400;i++){
			ogrenci[i]=new Students();
		}
		for(int i=0;i<40;i++){
			ders[i]=new Courses();
		}
		Scanner s1=new Scanner(System.in);
		while(true){
			System.out.println("1.Adding Operations");
			System.out.println("2.Deleting Operations");
			System.out.println("3.Listing Operation");
			System.out.println("4.Exit");
			System.out.println("Please choose one option that you want to execute(1,2,3,4):");
			int sayi1=s1.nextInt();
				if(sayi1==1){
					Students.addingMethod(ogrenci,ders);
				}
				else if(sayi1==2){
					Students.deletingMethod(ogrenci,ders);
				}
				else if(sayi1==3){
					Courses.listingMethod(ogrenci, ders);
				}
				else if(sayi1==4){
					break;
				}
				else{
					continue;
				}
		}

	}

}//class
