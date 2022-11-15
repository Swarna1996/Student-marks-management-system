import java.util.*;

class Student{
	private String studentId;
	private String studentName;
	private int prfMarks;
	private int dbmsMarks;
	private int total;
	private double average;
	
	public Student(String studentId,String studentName){
		this.studentId=studentId;
		this.studentName=studentName;
		prfMarks=-1;
		dbmsMarks=-1;
	}
	
	public Student(String studentId,String studentName,int prfMarks,int dbmsMarks){
		this.studentId=studentId;
		this.studentName=studentName;
		this.prfMarks=prfMarks;
		this.dbmsMarks=dbmsMarks;
	}
	
	public String callStudentId(){
		return studentId;
	}
	public String callStudentName(){
		return studentName;
	}
	public int callPrfMarks(){
		return prfMarks;
	}
	public int callDbmsMarks(){
		return dbmsMarks;
	}
	public void addStudentName(String studentName){
		this.studentName=studentName;
	}
	public void addPrfMarks(int prfMarks){
		this.prfMarks=prfMarks;
	}
	public void addDbmsMarks(int dbmsMarks){
		this.dbmsMarks=dbmsMarks;
	}
	public void findTotal(){
		total=dbmsMarks+prfMarks;
	}
	public void findAverage(){
		this.average=(double)total/2;
	}
	public double average(){
		return average;
	}
	public int total(){
		return total;
	}
}

class Example{
	public static Student[] stIdArray=new Student[0];

	
	public final static void clearconsole(){	
	try {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
	} catch (final Exception e) {
		e.printStackTrace();
		// Handle any exceptions.
	}

	}
	
	
	public static int search(String stId){
		
		for(int i=0; i<stIdArray.length; i++){
			Student s1=stIdArray[i];
			if((s1.callStudentId()).equalsIgnoreCase(stId)){
				return i;
			}
		}
		return -1;
	}
	public static void extendArrays(){
		int size=stIdArray.length;
		Student[] tempStIdArray=new Student[size+1];
		
		for (int i = 0; i < size; i++){
			tempStIdArray[i]=stIdArray[i];
		}
		stIdArray=tempStIdArray;
	}
	public static void addNewStudent(){
		Scanner input=new Scanner(System.in);
	System.out.printf("---------------------------------------------------------%n");
	System.out.printf("|			ADD NEW STUDENT	     		|%n");
	System.out.printf("---------------------------------------------------------%n");	
	System.out.printf("%n");
		do{
			System.out.print("Input Student ID : ");
			String stId=input.next();
			if(search(stId)!=-1){
				System.out.println("Student "+stId+" is exist...");
				continue;
			}
			System.out.print("Input Student Name : ");
			String stName=input.next();
			extendArrays();
			Student s1=new Student(stId,stName);
			stIdArray[stIdArray.length-1]=s1;
			
			//insert code to add more students
			System.out.println();
			System.out.print("Do you want to add another student (Y/N): ");
			String option=input.next();
			if(option.equalsIgnoreCase("Y")){
				System.out.println();
				continue;
			}else{
				break;
			}
		}while(true);
			
	}
	
	public static void addMarks(){
		Scanner input=new Scanner(System.in);
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|				ADD MARKS     				|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		do{
			System.out.print("Input Student ID : ");
			String stId=input.next();
			if(search(stId)!=-1){
				int j =search(stId);
				Student s1= stIdArray[j];
				System.out.println("Student Name : "+s1.callStudentName());
				System.out.println();
				
				if(s1.callDbmsMarks()==-1 && s1.callPrfMarks()==-1){
					
					while(true){
					System.out.print("Programming Fundamentals marks : ");
					int pfMarksInput=input.nextInt();
						if(pfMarksInput>=0 && pfMarksInput<101){
								s1.addPrfMarks(pfMarksInput);
								break;	
						}else{System.out.println("Invalid marks. please enter valid marks");
							}
					}
					
					while(true){
					System.out.print("Database management systems marks : ");
					int dbmsMarksInput=input.nextInt();
						if(dbmsMarksInput>=0 && dbmsMarksInput<101){
								s1.addDbmsMarks(dbmsMarksInput);
								break;
						}else{System.out.println("Invalid marks. please enter valid marks");}
					}
					System.out.println();
				System.out.print("Student has been added successfully. ");
				System.out.println();
				}else{
						System.out.println("This student's marks have been already added.");
						System.out.println("If you want to update the marks, please use [4] Update Marks option");
						System.out.println();
							System.out.print("Do you want to add another student (Y/N): ");
							String option=input.next();
						if(option.equalsIgnoreCase("Y")){
							System.out.println();
							continue;
						}else{
							break;
						}
					}
				
			}else{
					System.out.print("Invalid student ID");
						System.out.println();
				}

			//insert code to add more students
					System.out.print(" Do you want to add a new student(Y/n)");
						String option=input.next();
					if(option.equalsIgnoreCase("Y")){
						System.out.println();
						continue;
					}else{
						break;
					}	
		}while (true);
	}
	
	public static void updateStudentDetails(){
	Scanner input=new Scanner(System.in);
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|				ADD MARKS     				|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		do{
			System.out.print("Input Student ID : ");
			String stId=input.next();
			if(search(stId)!=-1){
				int j =search(stId);
				Student s1=stIdArray[j];
				System.out.println("Student Name : "+s1.callStudentName());
				System.out.println();
				
				System.out.print("Enter the new student name : ");
				String newNameInput=input.next();
				s1.addStudentName(newNameInput);
				System.out.println();
				System.out.println("Student details has been updated successfully. ");
				System.out.println();
				}else{
					System.out.print("Invalid student ID. Do you want to add a new student(Y/n)");
						String option=input.next();
					if(option.equalsIgnoreCase("Y")){
						System.out.println();
						continue;
					}else{
						break;
					}	
				}

			//insert code to add more students
					System.out.print(" Do you want to add a new student(Y/n)");
						String option=input.next();
					if(option.equalsIgnoreCase("Y")){
						System.out.println();
						continue;
					}else{
						break;
					}	
		}while (true);
	}
	
	public static void deleteStudent(){
		Scanner input=new Scanner(System.in);
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|				DELETE STUDENTS    			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		do{
			System.out.print("Input Student ID : ");
			String stId=input.next();
			int index=search(stId);
			if(index==-1){
				System.out.println("Student "+stId+" is not exist...");
				continue;
			}else{
				//display student details 
				Student s1=stIdArray[index];
				System.out.println("Student "+s1.callStudentId());
			}
			int size=stIdArray.length;
			for (int i = index; i <size-1; i++){
				stIdArray[i]=stIdArray[i+1];
			}
			Student[] tempStIdArray=new Student[size-1];
			
			for(int i=0; i<size-1; i++){
				tempStIdArray[i]=stIdArray[i];
			}
			stIdArray=tempStIdArray;

			
			System.out.println();
			System.out.print("Do you want to delete another student (Y/N): ");
			String option=input.next();
			if(option.equalsIgnoreCase("Y")){
					System.out.println();
				continue;
			}else{
				break;
			}
			
		}while(true);
	}
	public static void addNewStudentWithMarks(){
		Scanner input=new Scanner(System.in);
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|			ADD NEW STUDENT	WITH MARKS     			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		do{
			System.out.print("Input Student ID : ");
			String stId=input.next();
			if(search(stId)!=-1){
				System.out.println();
				System.out.println("Student "+stId+" is exist...");
				continue;
			}
			//System.out.println();
			System.out.print("Input Student Name : ");
			String stName=input.next();
			System.out.print("Input Marks for PRF  : ");
			int prfMarks=input.nextInt();
			
			System.out.print("Input Marks for DBMS : ");
			int dbmsMarks=input.nextInt();
			
			extendArrays();
			Student s1=new Student(stId,stName,prfMarks,dbmsMarks);
			stIdArray[stIdArray.length-1]=s1;
	
			
			//insert code to add more students
			System.out.println();
			System.out.print("Do you want to add another student (Y/N): ");
			String option=input.next();
			if(option.equalsIgnoreCase("Y")){
					System.out.println();
				continue;
			}else{
				break;
			}
		}while(true);
			
	}
	public static void bestInDbms(){
		Scanner input=new Scanner(System.in);
		System.out.printf("-----------------------------------------------------%n");
	System.out.printf("|	 BEST IN PROGRAMMING FUNDAMENTALS    	    |%n");
	System.out.printf("-----------------------------------------------------%n");	
	System.out.printf("%n");
	
	do{	
		int size=stIdArray.length;
		Student[] tempStIdArray=new Student[size];
	
		
		for (int i = 0; i < size; i++){
			tempStIdArray[i]=stIdArray[i];
		}
		for(int i=size-1; i>0; i--){
			for(int j=0; j<i; j++){
				Student s1=tempStIdArray[j];
				Student s2=tempStIdArray[j+1];
				if(s1.callDbmsMarks()<s2.callDbmsMarks()){
					tempStIdArray[j]=s2;
					tempStIdArray[j+1]=s1;
					
				}
			}
		}
		System.out.println("StId\tName\tDBMS");
		for (int i = 0; i < stIdArray.length; i++){
			Student s3 =tempStIdArray[i];
			System.out.println(s3.callStudentId()+"\t"+s3.callStudentName()+"\t"+s3.callDbmsMarks());
		}
		
				System.out.println();
			System.out.print("Do you want to stay? (Y/N): ");
			String option=input.next();
			if(option.equalsIgnoreCase("Y")){
					System.out.println();
				continue;
			}else{
				break;
			}
		
		}while(true);
	}
	
	public static void bestInPrf(){
		Scanner input=new Scanner(System.in);
		System.out.printf("-----------------------------------------------------%n");
	System.out.printf("|	 BEST IN PROGRAMMING FUNDAMENTALS    	    |%n");
	System.out.printf("-----------------------------------------------------%n");	
	System.out.printf("%n");
	
	
	do{	
		int size=stIdArray.length;
		Student[] tempStIdArray=new Student[size];
	
		for (int i = 0; i < size; i++){
			tempStIdArray[i]=stIdArray[i];
		}
		for(int i=size-1; i>0; i--){
			for(int j=0; j<i; j++){
				Student s1=tempStIdArray[j];
				Student s2=tempStIdArray[j+1];
				if(s1.callPrfMarks()<s2.callPrfMarks()){
					tempStIdArray[j]=s2;
					tempStIdArray[j+1]=s1;	
				}
			}
		}
		System.out.println("StId\tName\tPRF");
		for (int i = 0; i < stIdArray.length; i++){
			Student s3=stIdArray[i];
			System.out.println(s3.callStudentId()+"\t"+s3.callStudentName()+"\t"+s3.callPrfMarks());
		}
				System.out.println();
			System.out.print("Do you want to stay? (Y/N): ");
			String option=input.next();
			if(option.equalsIgnoreCase("Y")){
					System.out.println();
				continue;
			}else{
				break;
			}
		}while(true);
	}
	
	
	public static void printStudentDetails(){
		Scanner input=new Scanner(System.in);
		System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|			PRINT STUDENT DETAILS     			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
		do{
		System.out.println("StId\tName\tPRF\tDBMS");
		for (int i = 0; i < stIdArray.length; i++){
			Student s1=stIdArray[i];
			System.out.println(s1.callStudentId()+"\t"+s1.callStudentName()+"\t"+s1.callPrfMarks()+"\t"+s1.callDbmsMarks());
		}
		
		System.out.println();
			System.out.print("Do you want to stay? (Y/N): ");
			String option=input.next();
			if(option.equalsIgnoreCase("Y")){
					System.out.println();
				continue;
			}else{
				break;
			}
		}while(true);
	}
	
		public static void printStudentRanks(){
		
	System.out.printf("---------------------------------------------------------------------------------%n");
	System.out.printf("|				PRINT STUDENT RANKS   				|%n");
	System.out.printf("---------------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
	
		Scanner input =new Scanner(System.in);
		
		Student[] tempStudentIdArray = new Student[stIdArray.length];
			for (int i = 0; i < stIdArray.length; i++){
				tempStudentIdArray[i]=stIdArray[i];
				Student s1=tempStudentIdArray[i];
				s1.findTotal();
				s1.findAverage();
			}
		

	////////////// sorting /////////////////////////////////////
		for(int k=tempStudentIdArray.length-1;k>0;k--){
			for(int j=0;j<k;j++){
				Student s2=tempStudentIdArray[j];
				Student s3=tempStudentIdArray[j+1];
				if(s2.average()<s3.average()){
					tempStudentIdArray[j]=s3;
					tempStudentIdArray[j+1]=s2;
				}
			}
		}
	
		System.out.printf("---------------------------------------------------------------------------------%n");
		System.out.printf("| %-5s | %-10s | %-20s | %-15s | %-15s |%n","Rank","ID","Name","Total Marks","Avg. Marks");
		System.out.printf("---------------------------------------------------------------------------------%n");
		for (int i = 0; i < tempStudentIdArray.length; i++){
			Student s5=tempStudentIdArray[i];
			System.out.printf("| %-5d | %-10s | %-20s | %-15d | %-15.2f |%n",(i+1),s5.callStudentId(),s5.callStudentName(),s5.total(),s5.average());
			System.out.printf("---------------------------------------------------------------------------------%n");
		}
		System.out.printf("%n");
		System.out.print("Do you want to go back to the main menu? (Y/n) ");
							String result = input.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									
									System.out.println();
									}else{
									
									clearconsole();
									}
	
	}	
		

	 
	public static void main(String args[]){
		
		Scanner input=new Scanner(System.in);
		L1:do{
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|		WELCOME TO GDSE MARKS MANAGEMENT SYSTEM		     	|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	
	System.out.println();	
	System.out.println();
	System.out.println("[1] Add New Student\t\t\t[2] Add New Student With Marks");	
	System.out.println("[3] Add Marks\t\t\t\t[4] Update Student Details");	
	System.out.println("[5] Update Marks\t\t\t[6] Delete Student");	
	System.out.println("[7] Print Student Details\t\t[8] Print Student Ranks");	
	System.out.println("[9] Best in Programming Fundamentals\t[10] Best in Database Management System");	
	System.out.println();	
	System.out.println();	
		
			System.out.print("Enter an option to continue >");
			int op=input.nextInt();
			input.nextLine();
			clearconsole();
			switch(op){
				case 1 : addNewStudent();clearconsole(); break;
				case 2 : addNewStudentWithMarks();clearconsole(); break;
				case 3 : addMarks();clearconsole(); break;
				case 4 : updateStudentDetails(); clearconsole(); break;
				case 5 : deleteStudent();clearconsole(); break;
				case 6 : deleteStudent();clearconsole(); break;
				case 7 : printStudentDetails();clearconsole(); break;
				case 8 :  printStudentRanks(); break;
				case 9 : bestInPrf(); clearconsole(); break;
				case 10 : bestInDbms(); clearconsole(); break;
			}
			
		}while(true);
	}
}
