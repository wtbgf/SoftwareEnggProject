package project.excelSpike;

public class Grade {

	private String letterGrade;
	private double numberGrade;
	
	public Grade(String letterGrade) {
		this.letterGrade = letterGrade;
		this.numberGrade = convertLetterToNumber(letterGrade);
	}
	
	public double convertLetterToNumber(String letterGrade) {
		double numberGrade;
		switch(letterGrade) {
			case "A+":
			case "A": numberGrade = 4.0;
			case "A-": numberGrade = 3.7;
			case "B+": numberGrade = 3.3;
			case "B": numberGrade = 3.0;
			case "B-": numberGrade = 2.7;
			case "C+": numberGrade = 2.3;
			case "C": numberGrade = 2.0;
			case "C-": numberGrade = 1.7;
			case "D+": numberGrade = 1.3;
			case "D": numberGrade = 1.0;
			default: numberGrade = 0;
		}
		return numberGrade;
	}
	
	public String convertNumberToLetter(double number){
		String letterGrade;
                String num;
                num = Double.toString(number);
		switch (num) {
			case "4.0":
				letterGrade = "A";
				break;
			case "3.7":
				letterGrade = "A-";
				break;
			case "3.3": 
				letterGrade = "B+";
				break;
			case "3.0": 
				letterGrade = "B";
				break;
			case "2.7": 
				letterGrade = "B-";
				break;
			case "2.3": 
				letterGrade = "C+";
				break;
			case "2.0": 
				letterGrade = "C";
				break;
			case "1.7": 
				letterGrade = "C-";
				break;
			case "1.3": 
				letterGrade = "D+";
				break;
			case "1.0": 
				letterGrade = "D";
                                break;
			default: letterGrade = "D-";
		}
		return letterGrade;
	}
		
	public double getNumberGrade() {
		return numberGrade;
	}
	
	public String getLetterGrade() {
		return letterGrade;
	}
	
}