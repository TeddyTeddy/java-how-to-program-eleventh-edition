public class Question {
	private int questionNo;
	
	// TODO: throw an exception if questionNo is not between 1 to 5
	public Question(int questionNo) {
		this.questionNo = questionNo;
	}
	
	public void show() {
		String question = "This is question ";
		question += questionNo;
		question += ". What is your answer? ";
		System.out.printf("%s%n", question);
	}
	
	public boolean isCorrect(int selectedOption) {
		boolean _isCorrect = false;
		switch(questionNo) {
			case 1:
				if(selectedOption == 1) {
					_isCorrect = true;
				}
				break;
			case 2:
				if(selectedOption == 2) {
					_isCorrect = true;
				}
				break;
			case 3:
				if(selectedOption == 3) {
					_isCorrect = true;
				}
				break;
			case 4:
				if(selectedOption == 4) {
					_isCorrect = true;
				}
				break;
			case 5:
				if(selectedOption == 1) {
					_isCorrect = true;
				}
				break;
		}
		return _isCorrect;
	}
}