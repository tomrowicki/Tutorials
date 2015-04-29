
public class timeClass {
	public static void main(String args[]){
		tuna4 tunaObject = new tuna4();
		System.out.println(tunaObject.toMilitary());
		System.out.println(tunaObject.toNormal());
		tunaObject.setTime(13, 27, 6);
		System.out.println(tunaObject.toMilitary());
		System.out.println(tunaObject.toNormal());
		tunaObject.hour = 7;
		System.out.println(tunaObject.toNormal());
	}
}
