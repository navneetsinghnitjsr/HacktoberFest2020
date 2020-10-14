/*

	Name		Sayan Sikder
	Roll No.	2019PGCACA50

Program 3

Class : Headset
	Members: brand, price
	Methods: constructors, showSpec()

*/
package Program3; 
import java.util.*;
class Headset
{
   	String brand;
    	int price;
    	Headset()
	{
        	brand = "Boat";
        	price = 19500;
    	}
    	Headset(String B, int P)
	{
        	brand = B;
        	price = P;
    	}
    	void showSpecification()
	{
        	System.out.println("Brand                          :  " + brand);
        	System.out.println("Price                          :  " + price);
    	}
}



/*

Class : WirelessHeadset (inherits Headset)
	Members : wirelesstech, batterytype, batteryopduration
	Methods: constructors, showSpec(), changeSpec()

*/

class WirelessHeadset extends Headset
{
	String wirelessTech;
    	String batteryType;
    	String batteryDuration;
    	Headset           H  = new Headset();
    	WirelessHeadset()
	{
        	H.brand         =  "Tesla";
        	H.price         =  2999;
        	wirelessTech    =  "YES";
        	batteryType     =  "Litium-ion";
        	batteryDuration =  "800hr";
    	}
    	WirelessHeadset(String b, int p, String WTech, String BT, String BD)
	{
        	H.brand         =  b;
        	H.price         =  p;
        	wirelessTech    =  WTech;
        	batteryType     =  BT;
        	batteryDuration =  BD;
    	}
    	void showSpecification()
	{
        	H.showSpecification();
        	System.out.println("Wireless                       :  " + wirelessTech);
        	System.out.println("Battery Type                   :  " + batteryType);
        	System.out.println("Battery Duration               :  " + batteryDuration);
    	}
    	void changeSpecification()
	{
        	Scanner sc = new Scanner(System.in);
        	System.out.println("Modify The Specifications ");
        	System.out.print("Enter the Brand                  :  ");
        	String B = sc.nextLine();
        	System.out.print("Enter the Price                  : ");
        	int P =  sc.nextInt();
        	H.brand = B; H.price = P;
        	sc.nextLine();
        	Headset H = new Headset(B,P);
        	System.out.print("Enter the Wireless Type          :  ");
        	wirelessTech = sc.nextLine();
       	 	System.out.print("Enter the Battery Type           :  ");
        	batteryType = sc.nextLine();
        	System.out.print("Enter the Battery Duration Type  :  ");
        	batteryDuration = sc.nextLine();
    	}
}


/*

Class: EarbudHeadset (inherits WirelessHeadset )
	Members : size, isTouchType, weight
	Methods: constructors, showSpec(), changeSpec()
*/

class EarbudHeadset extends  WirelessHeadset
{
    	String size;
    	String isTouchType;
    	double weight;
    	Headset H = new Headset();
    	WirelessHeadset WH = new WirelessHeadset();
    	EarbudHeadset()
	{
        	WH          = new WirelessHeadset("Boos", 99999,"YES","AAA","92hr");
        	size        =  "Medium";
        	isTouchType = "YES";
        	weight      = 05.5;
    	}

    	void showSpecification()
	{
        	WH.showSpecification();
        	System.out.println("Size                           :  " + size);
        	System.out.println("Touch Type                     :  " + isTouchType);
        	System.out.println("Weight (in Gram)               :  " + weight);
        }
    	void changeSpec()
	{
        	Scanner sc = new Scanner(System.in);
        	System.out.println("Modify The Specifications ");
        	System.out.print("Enter the Brand                        :  ");
        	String B = sc.nextLine();
        	System.out.print("Enter the Price                        :  ");
        	int P =  sc.nextInt();
        	H.brand = B; H.price = P;
        	sc.nextLine();
        	Headset H = new Headset(B,P);
       		System.out.print("Enter the Wireless Type                :  ");
        	String W = sc.nextLine();
        	WH.wirelessTech = W;
        	System.out.print("Enter the Battery Type                 :  ");
        	String x  = sc.nextLine();
        	WH.batteryType = x;
        	System.out.print("Enter the Battery Duration Type        :  ");
        	String BD = sc.nextLine();
        	WH.batteryDuration = BD;
        	System.out.print("Enter the Size (Small/Medium/Large)    :  ");
        	size = sc.nextLine();
        	System.out.print("Enter the Touch Type                   :  ");
        	isTouchType = sc.nextLine();
        	System.out.print("Enter the Weight (in Gram )            :  ");
        	weight = sc.nextDouble();
        	WH = new WirelessHeadset(B,P,W,x,BD);
    	}
}



/*

Main 	

*/
public class Program_3
{
	public static void main(String args[]) 
	{
        	Scanner         sc = new Scanner(System.in);
        	Headset          H = new Headset();
        	WirelessHeadset WH = new WirelessHeadset();
        	EarbudHeadset   EH = new EarbudHeadset(); 
        	int choice;
       	 	while (true) 
		{
            		System.out.println("1. Show The Headset ");
            		System.out.println("2. Show The WirelessHeadset ");
            		System.out.println("3. Show The EarbudHeadset ");
            		System.out.println("4. For Modify the Specification of WirelessHeadset ");
            		System.out.println("5. For Modify the Specification of EarbudHeadset   ");
            		System.out.println("6. Exit ");
            		System.out.print("Enter Your Choice : ");
            		choice = sc.nextInt();
            		switch (choice) 
			{
                		case 1:
                    			System.out.print("\n");
                    			H.showSpecification();
                    			System.out.println("\n");
                    			break;
                		case 2:
                    			System.out.print("\n");
                    			WH.showSpecification();
                    			System.out.println("\n");
                    			break;
                		case 3:
                    			System.out.print("\n");
                    			EH.showSpecification();
                    			System.out.println("\n");
                    			break;
                		case 4:
                    			System.out.println("\n");
                    			WH.changeSpecification();
                    			System.out.println("Modification is Successful... \n\n");
                    			break;
                		case 5 :
                    			System.out.print("\n");
                    			EH.changeSpec();
                    			System.out.println("Modification is Successful... \n\n");
                    			break;
                		case 6 :
                    			System.exit(0);
                   	 		break;
                		default: 
					System.out.println("Wrong Choice");
            		}
        	}
    	}
}

