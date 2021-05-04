package week1.day1;

public class Mobile {

	String mobBrand = "Samsung"	;
	boolean isNew = false;
	int gb = 120;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Ready to Learn");
		Mobile mymob = new Mobile();
		String brandName = mymob.mobBrand;
		boolean newmob = mymob.isNew;
		int stCap = mymob.gb;
		System.out.println(brandName);
		System.out.println(newmob);
		System.out.println(stCap);
		

	}

}
