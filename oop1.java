import java.util.*;
class oop1{
	public static String[] stIdArray=new String[0];
	public static String[] stNameArray=new String[0];
	public static int[] prfMarksArray=new int[0];
	public static int[] dbmsMarksArray=new int[0];
	
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
			if(stId.equalsIgnoreCase(stIdArray[i])){
				return i;
			}
		}
		return -1;
	}
	public static void extendArrays(){
		int size=stIdArray.length;
		String[] tempStIdArray=new String[size+1];
		String[] tempStNameArray=new String[size+1];
		int[] tempPrfMarksArray=new int[size+1];
		int[] tempDbmsMarksArray=new int[size+1];
		
		for (int i = 0; i < size; i++){
			tempStIdArray[i]=stIdArray[i];
			tempStNameArray[i]=stNameArray[i];
			tempPrfMarksArray[i]=prfMarksArray[i];
			tempDbmsMarksArray[i]=dbmsMarksArray[i];
		}
		stIdArray=tempStIdArray;
		stNameArray=tempStNameArray;
		prfMarksArray=tempPrfMarksArray;
		dbmsMarksArray=tempDbmsMarksArray;
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
			stIdArray[stIdArray.length-1]=stId;
			stNameArray[stNameArray.length-1]=stName;
			prfMarksArray[prfMarksArray.length-1]=-1;
			dbmsMarksArray[dbmsMarksArray.length-1]=-1;
			
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
				System.out.println("Student Name : "+stNameArray[j]);
				System.out.println();
				
				if(prfMarksArray[j]==-1 && dbmsMarksArray[j]==-1){
					extendArrays();
					
					while(true){
					System.out.print("Programming Fundamentals marks : ");
					int pfMarksInput=input.nextInt();
						if(pfMarksInput>=0 && pfMarksInput<101){
								prfMarksArray[j]=pfMarksInput;
								break;	
						}else{System.out.println("Invalid marks. please enter valid marks");
							}
					}
					
					while(true){
					System.out.print("Database management systems marks : ");
					int dbmsMarksInput=input.nextInt();
						if(dbmsMarksInput>=0 && dbmsMarksInput<101){
								dbmsMarksArray[j]=dbmsMarksInput;
								break;
						}else{System.out.println("Invalid marks. please enter valid marks");}
					}
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
				System.out.println("Student Name : "+stNameArray[j]);
				System.out.println();
				
				System.out.print("Enter the new student name : ");
				String newNameInput=input.next();
				stNameArray[j]=newNameInput;
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
				System.out.println("Student "+stNameArray[index]);
			}
			int size=stIdArray.length;
			for (int i = index; i <size-1; i++){
				stIdArray[i]=stIdArray[i+1];
				stNameArray[i]=stNameArray[i+1];
				prfMarksArray[i]=prfMarksArray[i+1];
				dbmsMarksArray[i]=dbmsMarksArray[i+1];
			}
			String[] tempStIdArray=new String[size-1];
			String[] tempStNameArray=new String[size-1];
			int[] tempPrfMarksArray=new int[size-1];
			int[] tempDbmsMarksArray=new int[size-1];
			for(int i=0; i<size-1; i++){
				tempStIdArray[i]=stIdArray[i];
				tempStNameArray[i]=stNameArray[i];
				tempDbmsMarksArray[i]=dbmsMarksArray[i];
				tempPrfMarksArray[i]=prfMarksArray[i];
			}
			stIdArray=tempStIdArray;
			stNameArray=tempStNameArray;
			prfMarksArray=tempPrfMarksArray;
			dbmsMarksArray=tempDbmsMarksArray;
			
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
				System.out.println("Student "+stId+" is exist...");
				continue;
			}
			System.out.print("Input Student Name : ");
			String stName=input.next();
			System.out.print("Input Marks for PRF  : ");
			int prfMarks=input.nextInt();
			
			System.out.print("Input Marks for DBMS : ");
			int dbmsMarks=input.nextInt();
			
			extendArrays();
			stIdArray[stIdArray.length-1]=stId;
			stNameArray[stNameArray.length-1]=stName;
			prfMarksArray[prfMarksArray.length-1]=prfMarks;
			dbmsMarksArray[dbmsMarksArray.length-1]=dbmsMarks;
			
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
		String[] tempStIdArray=new String[size];
		String[] tempStNameArray=new String[size];
		int[] tempDbmsMarksArray=new int[size];
		
		for (int i = 0; i < size; i++){
			tempStIdArray[i]=stIdArray[i];
			tempStNameArray[i]=stNameArray[i];
			tempDbmsMarksArray[i]=dbmsMarksArray[i];
		}
		for(int i=size-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(tempDbmsMarksArray[j]>tempDbmsMarksArray[j+1]){
					int temp=tempDbmsMarksArray[j];
					tempDbmsMarksArray[j]=tempDbmsMarksArray[j+1];
					tempDbmsMarksArray[j+1]=temp;
					
					String tempId=tempStIdArray[j];
					tempStIdArray[j]=tempStIdArray[j+1];
					tempStIdArray[j+1]=tempId;
					
					String tempName=tempStNameArray[j];
					tempStNameArray[j]=tempStNameArray[j+1];
					tempStNameArray[j+1]=tempName;
				}
			}
		}
		System.out.println("StId\tNametDBMS");
		for (int i = 0; i < stIdArray.length; i++){
			System.out.println(tempStIdArray[i]+"\t"+tempStNameArray[i]+"\t"+tempDbmsMarksArray[i]);
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
		String[] tempStIdArray=new String[size];
		String[] tempStNameArray=new String[size];
		int[] tempPrfMarksArray=new int[size];
		
		for (int i = 0; i < size; i++){
			tempStIdArray[i]=stIdArray[i];
			tempStNameArray[i]=stNameArray[i];
			tempPrfMarksArray[i]=prfMarksArray[i];
		}
		for(int i=size-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(tempPrfMarksArray[j]>tempPrfMarksArray[j+1]){
					int temp=tempPrfMarksArray[j];
					tempPrfMarksArray[j]=tempPrfMarksArray[j+1];
					tempPrfMarksArray[j+1]=temp;
					
					String tempId=tempStIdArray[j];
					tempStIdArray[j]=tempStIdArray[j+1];
					tempStIdArray[j+1]=tempId;
					
					String tempName=tempStNameArray[j];
					tempStNameArray[j]=tempStNameArray[j+1];
					tempStNameArray[j+1]=tempName;
				}
			}
		}
		System.out.println("StId\tNametPRF");
		for (int i = 0; i < stIdArray.length; i++){
			System.out.println(tempStIdArray[i]+"\t"+tempStNameArray[i]+"\t"+tempPrfMarksArray[i]);
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
			System.out.println(stIdArray[i]+"\t"+stNameArray[i]+"\t"+prfMarksArray[i]+"\t"+dbmsMarksArray[i]);
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
	/*
		public static void printStudentRanks(){
		
	System.out.printf("---------------------------------------------------------------------------------%n");
	System.out.printf("|				PRINT STUDENT RANKS   				|%n");
	System.out.printf("---------------------------------------------------------------------------------%n");	
	System.out.printf("%n");
		
	boolean finalResult =true;	
		while(finalResult){
		Scanner input =new Scanner(System.in);
		
		String[] idcopy = new String[stIdArray.length];
		for (int i = 0; i < stIdArray.length; i++){
			idcopy[i]=stIdArray[i];
		}
		String[] namecopy = new String[stNameArray.length];
		for (int i = 0; i < stNameArray.length; i++){
			namecopy[i]=stNameArray[i];
		}
		int[] totalMarks =new int[stNameArray.length];
		for (int i = 0; i < stNameArray.length; i++){
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
	*/ 
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
				case 8 :  //printStudentRanks(); break;
				case 9 : bestInPrf(); clearconsole(); break;
				case 10 : bestInDbms(); clearconsole(); break;
			}
			
		}while(true);
	}
}

