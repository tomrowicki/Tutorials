
public class tuna4 { // used by timeClass.java
	public int hour;
	private int minute;
	private int second;
	
	public void setTime(int h, int m, int s){
		hour = ((hour<=0 && h<24) ? h : 0); // if the two conditions are met, hour = h, if not, hour = 0
		minute = ((minute<=0 && m<60) ? m : 0);
		second = ((second<=0 && h<60) ? s : 0);
	}
	
	public String toMilitary(){
		return String.format("%02d:%02d:%02d", hour, minute, second); // displays each number with 2 decimal places
	}
	
	public String toNormal(){
		return String.format("%d:%02d:%02d %s", ((hour==0||hour==12)?12:hour%12), minute, second, (hour<12 ? "AM": "PM"));
	}
}
