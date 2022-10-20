import java.util.*;
class Coursework{
	public static String[] studentID=new String[0];
	public static String[] studentName=new String[0];
	public static int[] pfMarks = new int[0];
	public static int[] dbmsMarks = new int[0];
	
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
	public static void addNewStudent(){
		Scanner input=new Scanner(System.in);
	System.out.printf("---------------------------------------------------------%n");
	System.out.printf("|			ADD NEW STUDENT	     		|%n");
	System.out.printf("---------------------------------------------------------%n");	
	System.out.printf("%n");
		boolean finalResult = true;
		 do{
			System.out.print("Enter Student ID : ");
			String ID=input.nextLine();
			
			if(!search(studentID,ID)){
				System.out.print("Enter Student Name : ");
				String stdName=input.nextLine();
				String[] temp=new String[studentID.length+1];
					for (int i = 0; i < studentID.length; i++){
						temp[i]=studentID[i];
					}
					studentID=temp;
					studentID[studentID.length-1]=ID;
				String[] temp1=new String[studentName.length+1];
					for (int i = 0; i < studentName.length; i++){
						temp1[i]=studentName[i];
					}
					studentName=temp1;
					studentName[studentName.length-1]=stdName;
				System.out.print("Student has been added successfully. ");
				System.out.print("Do you want to add a new student(Y/n) ");
				String result = input.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
					int[] temp3=new int[pfMarks.length+1];
					for (int i = 0; i < pfMarks.length; i++){
						temp3[i]=pfMarks[i];
					}
					pfMarks=temp3;
					pfMarks[pfMarks.length-1]=-1;	
					
					int[] temp4=new int[dbmsMarks.length+1];
					for (int i = 0; i < dbmsMarks.length; i++){
						temp4[i]=dbmsMarks[i];
					}
					dbmsMarks=temp4;
					dbmsMarks[dbmsMarks.length-1]=-1;
							
			}else{
				System.out.println("The Student ID already exists ");
				}
		}while(finalResult);		
	}
	public static void addNewStudentWithMarks(){
		
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|			ADD NEW STUDENT	WITH MARKS     			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		Scanner input=new Scanner(System.in);
		Scanner new2 =new Scanner(System.in);
		Scanner new3 =new Scanner(System.in);
		Scanner new4 =new Scanner(System.in);
		boolean finalResult = true;
		do{
			System.out.print("Enter Student ID : ");
			String ID=input.nextLine();
			
			if(!search(studentID,ID)){
				System.out.print("Enter Student Name : ");
				String stdName=new2.nextLine();
				String[] temp=new String[studentID.length+1];
					for (int i = 0; i < studentID.length; i++){
						temp[i]=studentID[i];
					}
					studentID=temp;
					studentID[studentID.length-1]=ID;
				String[] temp1=new String[studentName.length+1];
					for (int i = 0; i < studentName.length; i++){
						temp1[i]=studentName[i];
					}
					studentName=temp1;
					studentName[studentName.length-1]=stdName;
		
					while(true){
					System.out.print("Programming Fundamentals marks : ");
					int pfMarksInput=new3.nextInt();
						if(pfMarksInput>=0 && pfMarksInput<101){
							int[] temp3=new int[pfMarks.length+1];
								for (int i = 0; i < pfMarks.length; i++){
									temp3[i]=pfMarks[i];
								}
								pfMarks=temp3;
								pfMarks[pfMarks.length-1]=pfMarksInput;
								break;	
						}else{System.out.println("Invalid marks. please enter valid marks");
							}
					}
					
					while(true){
					System.out.print("Database management systems marks : ");
					int dbmsMarksInput=new4.nextInt();
						if(dbmsMarksInput>=0 && dbmsMarksInput<101){
							int[] temp4=new int[dbmsMarks.length+1];
								for (int i = 0; i < dbmsMarks.length; i++){
									temp4[i]=dbmsMarks[i];
								}
								dbmsMarks=temp4;
								dbmsMarks[dbmsMarks.length-1]=dbmsMarksInput;
								break;
						}else{System.out.println("Invalid marks. please enter valid marks");}
					}
					System.out.println();
				System.out.print("Student has been added successfully. ");
				Scanner new1 =new Scanner(System.in);
				System.out.print("Do you want to add a new student(Y/n) ");
				String result = new1.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
					
							
			}else{
				System.out.println("The Student ID already exists ");
				}

		}while(finalResult);		
	}
	public static void addMarks(){
		
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|				ADD MARKS     				|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
		Scanner input=new Scanner(System.in);
		Scanner input1=new Scanner(System.in);
		Scanner input2=new Scanner(System.in);

		boolean finalResult = true;
		while(finalResult){
			System.out.print("Enter Student ID : ");
			String inputID=input.nextLine();
			if(search(studentID,inputID)){
				int j =searchIndex(studentID,inputID);
				System.out.println("Student Name : "+studentName[j]);
				System.out.println();

				if(pfMarks[j]==-1 && dbmsMarks[j]==-1){
					while(true){
					System.out.print("Programming Fundamentals marks : ");
					int pfMarksInput=input1.nextInt();
						if(pfMarksInput>=0 && pfMarksInput<101){
								pfMarks[j]=pfMarksInput;
								break;	
						}else{System.out.println("Invalid marks. please enter valid marks");
							}
					}
					
					while(true){
					System.out.print("Database management systems marks : ");
					int dbmsMarksInput=input2.nextInt();
						if(dbmsMarksInput>=0 && dbmsMarksInput<101){
								dbmsMarks[j]=dbmsMarksInput;
								break;
						}else{System.out.println("Invalid marks. please enter valid marks");}
					}
				System.out.print("Student has been added successfully. ");
				Scanner new1 =new Scanner(System.in);
				System.out.print("Do you want to add a new student(Y/n) ");
				String result = new1.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
					}else{
						System.out.println("This student's marks have been already added.");
						System.out.println("If you want to update the marks, please use [4] Update Marks option");
						System.out.print("Do you want to add a new student(Y/n)");
							Scanner new2 =new Scanner(System.in);
							String result = new2.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = true;
									System.out.println();
									}else{
									finalResult = false;
									}
						}
			}else{
				System.out.print("Invalid student ID. Do you want to add a new student(Y/n)");
				Scanner new2 =new Scanner(System.in);
				String result = new2.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
				}
		}
			
	}	
	public static void updateStudentDetails(){
		
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|			UPDATE STUDENT DETAILS     			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
		Scanner input=new Scanner(System.in);
		Scanner input1=new Scanner(System.in);
		Scanner input2=new Scanner(System.in);

		boolean finalResult = true;
		while(finalResult){
			System.out.print("Enter Student ID : ");
			String inputID=input.nextLine();
			if(search(studentID,inputID)){
				int j =searchIndex(studentID,inputID);
				System.out.println("Student Name : "+studentName[j]);
				System.out.println();
					System.out.print("Enter the new student name : ");
					String newNameInput=input1.nextLine();
						studentName[j]=newNameInput;
						System.out.println();
					System.out.println("Student details has been updated successfully. ");
					
				System.out.print("Do you want to update another student details(Y/n) ");
				String result = input2.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
					}else{
						System.out.println("Invalid Student ID");
						
						System.out.print("Do you want to search again? (Y/n)");
							Scanner new2 =new Scanner(System.in);
							String result = input2.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = true;
									System.out.println();
									}else{
									finalResult = false;
									}
						}
			
		}
			
	}	
	public static void updateMarks(){
		
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|				UPDATE MARKS     			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
		Scanner input=new Scanner(System.in);
		Scanner input1=new Scanner(System.in);
		Scanner input2=new Scanner(System.in);

		boolean finalResult = true;
		while(finalResult){
			System.out.print("Enter Student ID : ");
			String inputID=input.nextLine();
			if(search(studentID,inputID)){
				int j =searchIndex(studentID,inputID);
				System.out.println("Student Name : "+studentName[j]);
				System.out.println();
					System.out.print("Enter new PF MArks : ");
					int newPfMarks=input1.nextInt();
						pfMarks[j]=newPfMarks;
					System.out.print("Enter new DBMS MArks : ");
					int newDbmsMarks=input1.nextInt();
						dbmsMarks[j]=newDbmsMarks;	
						System.out.println();
					System.out.println("Marks have been updated successfully. ");
					
				System.out.print("Do you want to update another student details(Y/n) ");
				String result = input2.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
					}else{
						System.out.println("Invalid Student ID");
						
						System.out.print("Do you want to search again? (Y/n)");
							Scanner new2 =new Scanner(System.in);
							String result = new2.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = true;
									System.out.println();
									}else{
									finalResult = false;
									}
						}

		}
		
	}
	public static void deleteStudent(){
		
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|				DELETE STUDENTS    			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
		Scanner input=new Scanner(System.in);
		boolean finalResult = true;
		 do{
			System.out.print("Enter Student ID : ");
			String ID=input.nextLine();
			
			if(search(studentID,ID)){
				int j = searchIndex(studentID,ID);
				for (int i = j; i < studentID.length-1; i++){
						studentID[i]=studentID[i+1];
					}
				String[] temp=new String[studentID.length-1];
					for (int i = 0; i < temp.length; i++){
						temp[i]=studentID[i];
					}
					studentID=temp;
					///////////////////////////////
				for (int i = j; i < studentName.length-1; i++){
						studentName[i]=studentName[i+1];
					}
				String[] temp1=new String[studentName.length-1];
					for (int i = 0; i < temp1.length; i++){
						temp1[i]=studentName[i];
					}
					studentName=temp1;
					/////////////////////////////
					for (int i = j; i < pfMarks.length-1; i++){
						pfMarks[i]=pfMarks[i+1];
					}
				int[] temp2=new int[pfMarks.length-1];
					for (int i = 0; i < temp2.length; i++){
						temp2[i]=pfMarks[i];
					}
					pfMarks=temp2;
					/////////////////////////////
					for (int i = j; i < dbmsMarks.length-1; i++){
						dbmsMarks[i]=dbmsMarks[i+1];
					}
				int[] temp3=new int[dbmsMarks.length-1];
					for (int i = 0; i < temp3.length; i++){
						temp3[i]=dbmsMarks[i];
					}
					dbmsMarks=temp3;
				System.out.print("Student has been deleted successfully. ");
				System.out.print("Do you want to delete another student?(Y/n) ");
				String result = input.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}		
			}else{
				System.out.print("Invalid Student ID. ");
				System.out.print("Do you want to delete another student?(Y/n) ");
				String result = input.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}	
				}	
		}while(finalResult);	
	}
	public static void printStudentDetails(){
		
	System.out.printf("-------------------------------------------------------------------------%n");
	System.out.printf("|			PRINT STUDENT DETAILS     			|%n");
	System.out.printf("-------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
		Scanner input=new Scanner(System.in);
		Scanner input1=new Scanner(System.in);

		boolean finalResult = true;
		while(finalResult){
			System.out.print("Enter Student ID : ");
			String inputID=input.nextLine();
			if(search(studentID,inputID)){
				int j =searchIndex(studentID,inputID);
				System.out.println("Student Name : "+studentName[j]);
				System.out.println();

				if(pfMarks[j]==-1 && dbmsMarks[j]==-1){
				
				System.out.print("Marks yet to be added");
				System.out.println();
				System.out.print("Do you want to search another student details? (Y/n) ");
				String result = input1.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
					}else{
						String x = "Programming Funadamentals marks";
						System.out.printf("%-40s%10d\n",x,pfMarks[j]);
						String y = "Database Management Systems marks";
						System.out.printf("%-40s%10d\n",y,dbmsMarks[j]);
						int total = findTotal(j);
						float average = findAverage(j);
						int rank = findRank(j);
						String z= "Total";
						System.out.printf("%-40s%10d\n",z,total);
						String a = "Average";
						System.out.printf("%-40s%10.2f\n",a,average);
						String b = "Rank";
						System.out.printf("%-40s%10d\n",b,rank);
						System.out.println();
						System.out.print("Do you want to search another atudent details? (Y/n) ");
							String result = input1.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = true;
									System.out.println();
									}else{
									finalResult = false;
									}
									//clearconsole();
						}
			}else{
				System.out.print("Invalid student ID. Do you want to search another atudent details(Y/n)");
				Scanner new2 =new Scanner(System.in);
				String result = new2.nextLine();
				String yes = "Y";
					if(result.equalsIgnoreCase(yes)){
						finalResult = true;
						System.out.println();
						}else{
						finalResult = false;
						}
				}
	
			}
	}
	public static void printStudentRanks(){
		
	System.out.printf("---------------------------------------------------------------------------------%n");
	System.out.printf("|				PRINT STUDENT RANKS   				|%n");
	System.out.printf("---------------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
	boolean finalResult =true;	
		while(finalResult){
		Scanner input =new Scanner(System.in);
		
		String[] idcopy = new String[studentID.length];
		for (int i = 0; i < studentID.length; i++){
			idcopy[i]=studentID[i];
		}
		String[] namecopy = new String[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			namecopy[i]=studentName[i];
		}
		int[] totalMarks =new int[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			totalMarks[i]=findTotal(i);
		}
		float[] avgMarks = new float[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			avgMarks[i]=findAverage(i);
		}
	/////////////Rank array/////////////////////////////////////	
		int[] rank =new int[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			rank[i]=findRank(i);
		}
	////////////// sorting /////////////////////////////////////
		for(int k=rank.length-1;k>0;k--){
			for(int j=0;j<k;j++){
				if(rank[j]>rank[j+1]){
					int temp=rank[j];
					rank[j]=rank[j+1];
					rank[j+1]=temp;
					
					int temp1=totalMarks[j];
					totalMarks[j]=totalMarks[j+1];
					totalMarks[j+1]=temp1;
					
					String temp2=idcopy[j];
					idcopy[j]=idcopy[j+1];
					idcopy[j+1]=temp2;
					
					String temp3=namecopy[j];
					namecopy[j]=namecopy[j+1];
					namecopy[j+1]=temp3;
					
					float temp4=avgMarks[j];
					avgMarks[j]=avgMarks[j+1];
					avgMarks[j+1]=temp4;
					}
			}
		}
	
		System.out.printf("---------------------------------------------------------------------------------%n");
		System.out.printf("| %-5s | %-10s | %-20s | %-15s | %-15s |%n","Rank","ID","Name","Total Marks","Avg. Marks");
		System.out.printf("---------------------------------------------------------------------------------%n");
		for (int i = 0; i < studentName.length; i++){
			System.out.printf("| %-5d | %-10s | %-20s | %-15d | %-15.2f |%n",rank[i],idcopy[i],namecopy[i],totalMarks[i],avgMarks[i]);
			System.out.printf("---------------------------------------------------------------------------------%n");
		}
		System.out.printf("%n");
		System.out.print("Do you want to go back to the main menu? (Y/n) ");
							String result = input.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = false;
									System.out.println();
									}else{
									finalResult = true;
									clearconsole();
									}
	
	}	
		
}	
	public static void BestInProgrammingFundamentals(){
		
	System.out.printf("-----------------------------------------------------%n");
	System.out.printf("|	 BEST IN PROGRAMMING FUNDAMENTALS    	    |%n");
	System.out.printf("-----------------------------------------------------%n");	
	System.out.printf("%n");
	
	boolean finalResult =true;	
		while(finalResult){
		Scanner input=new Scanner(System.in);
		
		String[] idcopy = new String[studentID.length];
		for (int i = 0; i < studentID.length; i++){
			idcopy[i]=studentID[i];
		}
		String[] namecopy = new String[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			namecopy[i]=studentName[i];
		}
		int[] pfMarkscopy =new int[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			pfMarkscopy[i]=pfMarks[i];
		}
		
		int[] dbmsMarkscopy = new int[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			dbmsMarkscopy[i]=dbmsMarks[i];
		}	
		
	////////////// sorting /////////////////////////////////////
		for(int k=pfMarks.length-1;k>0;k--){
			for(int j=0;j<k;j++){
				if(pfMarkscopy[j]<pfMarkscopy[j+1]){
					int temp=pfMarkscopy[j];
					pfMarkscopy[j]=pfMarkscopy[j+1];
					pfMarkscopy[j+1]=temp;
					
					String temp2=idcopy[j];
					idcopy[j]=idcopy[j+1];
					idcopy[j+1]=temp2;
					
					String temp3=namecopy[j];
					namecopy[j]=namecopy[j+1];
					namecopy[j+1]=temp3;
					
					int temp4=dbmsMarkscopy[j];
					dbmsMarkscopy[j]=dbmsMarkscopy[j+1];
					dbmsMarkscopy[j+1]=temp4;
					}
			}
		}
	
		System.out.printf("---------------------------------------------------------------%n");
		System.out.printf("| %-6s | %-20s | %-12s | %-12s |%n","ID","Name","PF Marks","DBMS Marks");
		System.out.printf("---------------------------------------------------------------%n");
		for (int i = 0; i < studentName.length; i++){
			System.out.printf("| %-6s | %-20s | %-12d | %-12d |%n",idcopy[i],namecopy[i],pfMarkscopy[i],dbmsMarkscopy[i]);
		System.out.printf("---------------------------------------------------------------%n");
		}
		System.out.printf("%n");
		System.out.print("Do you want to go back to the main menu? (Y/n) ");
							String result = input.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = false;
									System.out.println();
									}else{
									finalResult = true;
									clearconsole();
									}
	
	}	
		
}
	public static void BestInDatabaseManagementSystem(){
		System.out.printf("-----------------------------------------------------%n");
	System.out.printf("|	 BEST IN PROGRAMMING FUNDAMENTALS    	    |%n");
	System.out.printf("-----------------------------------------------------%n");	
	System.out.printf("%n");
	
	boolean finalResult =true;	
		while(finalResult){
		Scanner input=new Scanner(System.in);
		
		String[] idcopy = new String[studentID.length];
		for (int i = 0; i < studentID.length; i++){
			idcopy[i]=studentID[i];
		}
		String[] namecopy = new String[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			namecopy[i]=studentName[i];
		}
		int[] pfMarkscopy =new int[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			pfMarkscopy[i]=pfMarks[i];
		}
		
		int[] dbmsMarkscopy = new int[studentName.length];
		for (int i = 0; i < studentName.length; i++){
			dbmsMarkscopy[i]=dbmsMarks[i];
		}	
		
	////////////// sorting /////////////////////////////////////
		for(int k=pfMarks.length-1;k>0;k--){
			for(int j=0;j<k;j++){
				if(dbmsMarkscopy[j]<dbmsMarkscopy[j+1]){
					int temp=dbmsMarkscopy[j];
					dbmsMarkscopy[j]=dbmsMarkscopy[j+1];
					dbmsMarkscopy[j+1]=temp;
					
					String temp2=idcopy[j];
					idcopy[j]=idcopy[j+1];
					idcopy[j+1]=temp2;
					
					String temp3=namecopy[j];
					namecopy[j]=namecopy[j+1];
					namecopy[j+1]=temp3;
					
					int temp4=pfMarkscopy[j];
					pfMarkscopy[j]=pfMarkscopy[j+1];
					pfMarkscopy[j+1]=temp4;
					}
			}
		}
	
		System.out.printf("---------------------------------------------------------------%n");
		System.out.printf("| %-6s | %-20s | %-12s | %-12s |%n","ID","Name","DBMS Marks","PF Marks");
		System.out.printf("---------------------------------------------------------------%n");
		for (int i = 0; i < studentName.length; i++){
			System.out.printf("| %-6s | %-20s | %-12d | %-12d |%n",idcopy[i],namecopy[i],dbmsMarkscopy[i],pfMarkscopy[i]);
		System.out.printf("---------------------------------------------------------------%n");
		}
		System.out.printf("%n");
		System.out.print("Do you want to go back to the main menu? (Y/n) ");
							String result = input.nextLine();
							String yes = "Y";
								if(result.equalsIgnoreCase(yes)){
									finalResult = false;
									System.out.println();
									}else{
									finalResult = true;
									clearconsole();
									}
	
	}	
		}
	
	
	public static void main(String [] args){
		while(true){
		Scanner input=new Scanner(System.in);
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
	int option =input.nextInt(); 
	clearconsole();
	switch(option){
		case 1:
			addNewStudent();
			clearconsole();
			break;
		case 2:
			addNewStudentWithMarks();
			clearconsole();
			break;
		case 3:
			addMarks();
			clearconsole();
			break;
		case 4:
			updateStudentDetails();
			clearconsole();
			break;
		case 5:
			updateMarks();
			clearconsole();
			break;
		case 6:
			deleteStudent();
			clearconsole();
			break;
		case 7:
			printStudentDetails();
			clearconsole();
			break;
		case 8:
			printStudentRanks();
			clearconsole();
			break;
		case 9:
			BestInProgrammingFundamentals();
			clearconsole();
			break;
		case 10:
			BestInDatabaseManagementSystem();
			clearconsole();
			break;	
		}
		}
	}
	public static boolean search(String[] ar,String key){
		for (int i = 0; i < ar.length; i++){
			if(ar[i].equalsIgnoreCase(key)){
				return true;
			}
		}
		return false;
	}
	public static int searchIndex(String[] ar,String key){
		int count=0;
		for(int i=0;i<ar.length;i++){
			if(ar[i].equals(key)){
				count=i;
			}
		}
		return count;
	}
	public static int findTotal(int index){
		int total = pfMarks[index]+dbmsMarks[index];
		return total;
		}
	public static float findAverage(int index){
		float average =(float)findTotal(index)/2;
		return average;
		}
	public static int findRank(int index){
		int[] totalar=new int[pfMarks.length];
		for(int i=0;i<totalar.length;i++){
			totalar[i]=findTotal(i);
			}
	///////////////sorting////////////////
		for(int k=totalar.length-1;k>0;k--){
			for(int j=0;j<k;j++){
				if(totalar[j]>totalar[j+1]){
					int temp=totalar[j];
					totalar[j]=totalar[j+1];
					totalar[j+1]=temp;
					}
			}
		}
		
	///////////////////////////////////////////
		int rank=0;
	for(int i=totalar.length-1;i>=0;i--){
		rank++;
			if(findTotal(index)==totalar[i]){
				return rank;
				}	
			}
		return rank;
	}
}
