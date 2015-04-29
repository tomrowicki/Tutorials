
public class Static {
	public static void main(String args[]){
		Static1 member1 = new Static1("Megan","Fox");
		Static1 member2 = new Static1("Natalie", "Portman");
		Static1 member3 = new Static1("Taylor", "Swift");
		
		System.out.println();
		System.out.println(member2.getFirst());
		System.out.println(member2.getLast());
		System.out.println(member2.getMembers());
		
		System.out.println(Static1.getMembers());

	}
}
