package logic;


import java.util.Calendar;

import org.joda.time.DateTime;

//Storage class should store the static int numberOfTask;
public class Task {
	private static int numberOfTask = 0;
	private String title;
	private String description;
	private boolean isFinished;
	private DateTime startingTime;
	private DateTime endingTime;
	private DateTime startingDate;
	private DateTime endingDate;
	private static String type_tag;
	//private int index;

	public Task(String title){
		this.title = title;
		description = new String();
		numberOfTask++;
		isFinished = false;
		type_tag = "task";
		//index = numberOfTask;
	}

	public Task(){
		String time = Calendar.getInstance().toString();
		title = "Untitled " + time;
		description = new String();
		numberOfTask++;
		isFinished = false;
		type_tag = "task";
		//index = numberOfTask;
	}

	/*public Task(String title, Calendar sdate, Time stime, Date edate, Time etime){
		this(title);
		startingDate= sdate;
		startingTime = stime;
		endingTime = etime;
		endingDate = edate;
		type_tag = "event";
	}

	public Task(Date sdate, Time stime, Date edate, Time etime){
		this();
		startingDate= sdate;
		startingTime = stime;
		endingTime = etime;
		endingDate = edate;
		type_tag = "event";
	}*/

	public Task(String title, DateTime startingDate, DateTime endingDate){
		this(title);
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		type_tag = "event";
	}

	public Task(DateTime sdate, DateTime edate){
		this();
		startingDate = sdate;
		endingDate = edate;
		type_tag = "event";
	}

	/*public Task(String title, Date date, Time time){
		this(title);
		endingTime = time;
		endingDate = date;
	}

	public Task(Date date, Time time){
		this();
		endingTime = time;
		endingDate = date;
	}*/

	public Task(String title, DateTime date){
		this(title);
		endingDate = date;
	}

	public Task(DateTime date){
		this();
		endingDate = date;
	}


	//Accessors
	public String getTitle(){
		return title;
	}
	public String getDescription(){
		return description;
	}
	public boolean getStatus(){
		return isFinished;
	}
	public int getTaskCount(){
		return numberOfTask;
	}
	public String getType(){
		return type_tag;
	}
	public DateTime getStartingDate(){
		return startingDate;
	}
	/*public DateTime getStartingTime(){
		return startingTime;
	}
	public DateTime getEndingTime(){
		return endingTime;
	}*/
	public DateTime getEndingDate(){
		return endingDate;
	}
	/*public int getIndex(){
		return index;
	}*/


	//Mutators
	public void setDescription(String des){
		description = des;
	}
	public void setTitle(String til){
		title = til;
	}

	public boolean mark(){
		numberOfTask--;
		isFinished = true;
		return isFinished;

	}
	public void unMark() {
		isFinished = false;
		numberOfTask++;
	}

	public void setStartingDate(DateTime date){
		startingDate = date;
		setTag();
	}

	public void setEndingDate(DateTime date){
		endingDate = date;
		setTag();
	}


	//decide on the tag

	public void setTag(){
		if((startingDate == null)){
			if(endingDate == null){
				type_tag = "task";
			}
			else{
				type_tag = "deadline";
			}
		}
		else{
			type_tag = "event";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task) {
			Task task = (Task) obj;
			return (this.getDescription().equals(task.getDescription())) &&
					(this.getTitle().equals(task.getTitle())) &&
					(this.getStatus() == task.getStatus()) &&
					(this.getEndingDate().equals(task.getEndingDate())) &&
					(this.getStartingDate().equals(task.getStartingDate()));
		} else {
			return false;
		}
	}



}


