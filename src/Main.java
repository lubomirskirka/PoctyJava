/*
 * 
 * Autors :   Miga� �imon
 * 			  Skirka �ubom�r
 * 			  Sokol Kristi�n
 * 			  Stankovi� Tom�
 * 
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Pocty v0.5");
        menu();

    }
    // Applications menu
    public static void menu()
    {
        while (true)
        {
            Scanner kb = new Scanner(System.in);

            System.out.println("Functions:");
            System.out.println("    1 Transfer between numeral system");
            System.out.println("    2 Mask/Prefix");
            System.out.println("    3 IP Review");
            int y = getNumFromTo("Choose function: ",1,3);
            blank(1);
            switch (y)
            {
                case 1:
                    convertUI();
                    break;
                case 2:
                    prefixUI();
                    break;
                case 3:
                    ipReviewUI();
                    break;
            }
        }
    }
    // method which do 1 Transfer between numeral system
    public static void convertUI()		
    {
        boolean request = true;			// true-from beginning,false-Previous transfer
        int option1 = 0;				// preset option
        int option2 = 0;				// preset option
        while(true)
        {
            Scanner kb2 = new Scanner(System.in);
            if (request)
            {
                System.out.println("Transfer from:");
                System.out.println("    1 Binary");
                System.out.println("    2 Decimal");
                option1 = getNumFromTo("From: ",1,2);			// select an option
                System.out.println("Transfer to:");			// display will offer no possibility that was already selected
                option2 = 0;
                if(option1 == 2)
                {
                    System.out.println("    1 Binary");
                    option2 = getNumFromTo("To: ",1,1);				// select an option
                    switch (option2)
                    {
                        case 1:
                            option2 = 1;
                    }
                }
                if(option1 == 1)
                {
                    System.out.println("    1 Decimal");
                    option2 = getNumFromTo("To: ",1,1);				// select an option
                    switch (option2)
                    {
                        case 1:
                            option2 = 2;
                    }

                }
                blank(1);
            }

            switch (option1)
            {
                case 1:
                    if(option2 == 2)
                    {
                       
                    	System.out.print("Enter binary number: ");
                        int[] in = getBinNum();
                        System.out.println("The number entered in decimal is: " + fromBinToDec(in));
                    }
                    break;
                case 2:
                    if(option2 == 1)
                    {
                        int in = getNum("Enter decimal number");
                        System.out.print("The number entered in binary is: ");
                        for (int x : fromDecToBin(in))
                        {
                            System.out.print(x);
                        }
                    }
                    break;
            }
            enterToContinue();

            blank(2);

            System.out.println("What do you want to do? Continue with conversion settings = Enter, New convert = 0, 1 = Menu");
            String back = kb2.nextLine();



            try {
                int in = Integer.parseInt(back);
                if(in == 0)
                {
                	request = true;
                    option1 = 0;
                    option2 = 0;
                    continue;				// method are initiated from the beginning
                }
                if (in == 1)
                {
                    break;					// end method/transfer, and the program returns to the menu
                }
            }
            catch (Exception e)
            {
                request = false;
                continue;					// previous transfer
            }
            System.out.println();
            System.out.println();
        }
    }
    // method which do 2.maska/prefix
    public static void prefixUI()	 
    {
        boolean request = true;				// true-from the beginning,false-Previous transfer
        int option1 = 0;					// preset option
        int option2 = 0;					// preset option
        while(true)
        {
            Scanner kb2 = new Scanner(System.in);
            if (request)
            {
                System.out.println("Convert from:");
                System.out.println("    1 Prefix");
                System.out.println("    2 Mask");
                System.out.println("    3 Wildcard");
                option1 = getNumFromTo("From: ",1,3);                 // select an option
                System.out.println("Convert to:"); 		 // display will offer no possibility that was already selected
                option2 = 0;
                if(option1 == 1)
                {
                    System.out.println("    1 Mask");
                    System.out.println("    2 Wildcard");
                    option2 = getNumFromTo("To: ",1,2);
                }
                if(option1 == 2)
                {
                    System.out.println("    1 Prefix");
                    System.out.println("    2 Wildcard");
                    option2 = getNumFromTo("To: ",1,2);
                    switch(option2)
                    {
                        case 1:
                            option2 = 3;
                            break;
                        case 2:
                            option2 = 4;
                            break;
                    }
                }
                if(option1 == 3)
                {
                    System.out.println("    1 Prefix");
                    System.out.println("    2 Mask");
                    option2 = getNumFromTo("To: ",1,2);
                    switch(option2)
                    {
                        case 1:
                            option2 = 5;
                            break;
                        case 2:
                            option2 = 6;
                            break;
                    }
                }
                blank(1);
            }

            switch (option1)
            {
                case 1:
                    if(option2 == 1)
                    {
                        while (true)
                        {
                            int in = getNum("Enter prefix: ");
                            if (in >= 0 && in <= 32)
                            {
                                System.out.print("Mask is: ");
                                int[] mask = fromPrefixToMask(in);
                                writeAddress(mask);
                                break;
                            }
                            else
                            {
                                System.out.println("Wrong prefix, this prefix does not exist");
                            }
                        }
                    }
                    if(option2 == 2)
                    {
                        while (true)
                        {
                            int in = getNum("Enter prefix: ");
                            if (in >= 0 && in <= 32)
                            {
                                System.out.print("Wildcard is: ");
                                int[] wildcard = fromPrefixToWildcard(in);
                                writeAddress(wildcard);
                                break;
                            }
                            else
                            {
                                System.out.println("Wrong prefix, this prefix does not exist");
                            }
                        }
                    }
                    break;
                case 2:
                    if(option2 == 3)
                    {
                        System.out.print("Enter mask: ");
                        int[] in = getAddress();
                        System.out.println("Prefix is: " + fromMaskToPrefix(in));
                    }
                    if(option2 == 4)
                    {
                        System.out.print("Enter mask: ");
                        int[] in = getAddress();
                        int[] out = fromMaskToWildcard(in);
                        System.out.print("Wildcard is:  ");
                        writeAddress(out);
                    }
                    break;
                case 3:
                    if(option2 == 5)
                    {
                        System.out.print("Enter wildcard: ");
                        int[] in = getAddress();
                        System.out.println("Prefix is: " + fromWildcardToPrefix(in));
                    }
                    if(option2 == 6)
                    {
                        System.out.print("Enter wildcard: ");
                        int[] in = getAddress();
                        int[] out = fromWildcardToMask(in);
                        System.out.print("Maska is: ");
                        writeAddress(out);
                    }
                    break;
                default:
                    System.out.println("Wrong input");
                    continue;
            }
            enterToContinue();

            blank(2);

            System.out.println("What do you want to do? Continue with conversion settings = Enter, New convert = 0, 1 = Menu");
            String back = kb2.nextLine();
            try
            {
                int in = Integer.parseInt(back);
                if(in == 0)
                {
                	request = true;
                    option1 = 0;
                    option2 = 0;
                    continue;							// method are initiated from the beginning
                }
                if (in == 1)
                {
                    break;								// end method/transfer, and the program returns to the menu
                }
            }
            catch (Exception e)
            {
                request = false;
                continue;                               // previous transfer
            }
            System.out.println();
            System.out.println();
        }
    }
    // method which do 3.IP Review
    public static void ipReviewUI()
    {
        Scanner kb7 = new Scanner(System.in);
        System.out.print("Enter IPv4 address: ");
        int[] address = getAddress();					// address
        System.out.print("Enter prefix: ");				// prefix network
        int prefix = kb7.nextInt();
        System.out.println();

        System.out.print("Maska is: ");
        writeAddress(fromPrefixToMask(prefix));			// subnet mask
        System.out.println();

        System.out.print("Network adress: ");			
        writeAddress(getNetOrBroAddress(address,prefix,true));		// network address
        System.out.println();

        System.out.print("Broadcast adress: ");						// broadcast address
        writeAddress(getNetOrBroAddress(address,prefix,false));
        System.out.println();

        System.out.println("Number of address: " + getSpaceAddress(prefix));					// number of address

        System.out.println("Number of address for devices: " + (getSpaceAddress(prefix) - 2));	// number of address for devices

        System.out.print("The first usable adress: ");				// the first usable address
        writeAddress(getFirstOrLastAddress(address,prefix,true));
        System.out.println();

        System.out.print("The last usable adress: ");				// the last usable address
        writeAddress(getFirstOrLastAddress(address,prefix,false));
        System.out.println();

        enterToContinue();
        blank(2);
    }
    // method for blank lines in UI
    public static void blank(int num)
    {
        for (int i = 0; i < num;i++)
            System.out.println();
    }
    public static void enterToContinue()
    {
        Scanner enter = new Scanner(System.in);
        enter.nextLine();
    }
    // method for get IPv4 address from user in console
	public static int[] getAddress()
    {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
        while (true)
        {
            String [] inout = kb.nextLine().split("\\.");
            try {
                int[] address = stringArrayToIntArray(inout);
                if(address.length == 4)
                {
                    return address;
                }
                else
                {
                    System.out.print("Enter the address with four octet: ");
                    continue;
                }
            }
            catch (Exception e)
            {
                System.out.println("Wrong input");
                continue;
            }
        }

    }
    public static int getNum(String what)
    {
        int out = 0;
        while (true)
        {
            Scanner kb9 = new Scanner(System.in);
            System.out.print(what);
            try {
                out = kb9.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.print("Enter number only");
                enterToContinue();
            }

        }
        return out;
    }
    public static int getNumFromTo(String what, int from, int to)
    {
        int out;
        while (true)
        {
            out = getNum(what);
            if (out >= from && out <= to)
            {
                break;
            }
            else
                System.out.println("Wrong input");
        }
        return out;
    }
	// method which write address with four octet
    public static void writeAddress(int[] address)
    {
        for (int i = 0; i < 4; i++)
        {
            System.out.print(address[i]);
            if (i != 3)
                System.out.print(".");
        }
    }
    public static int[] getBinNum()
    {
    		Scanner kb3 = new Scanner(System.in);
	        String in = kb3.nextLine();
	        String[] inout = new String[in.length()];
	        for (int i = 0; i < in.length(); i++)
	        {
	            String character = in.substring(i,i+1);
	            inout[i] = character;
	        }
	        return stringArrayToIntArray(inout);
    	
    }

    // method for transfer from decimal to binary
    public static int[] fromDecToBin(int dec)
    {
        int bits = bits(dec);       // variable which is stored the number of bits of the decimal number
        int[] bin = new int[bits];  // array where will be saved a binary number
        int rest = dec;
        for(int index = bits - 1;index >= 0;index--)	// dividing the decimal number 2
        {
            bin[index] = rest %2;
            rest = rest / 2;
        }
        return bin;
    }
    /*
     *  special method for transfer from decimal to binary (8 bits)
     * 	method returns an eight bit binary number
     */
    public static int[] fromDecToBin8(int dec)
    {
    	int[] bin = fromDecToBin(dec);
    	int[] out = new int[8];
    	int read = 0;
    	for(int i = 8 - bin.length; i < out.length; i++)
    	{
    		out[i] = bin[read];
    		read++;
    	}
    	return out;
    }
    // method for transfer from binary to decimal
    public static int fromBinToDec(int[] bin)
    {
        int dec = 0;                                // The resulting number in decimal
        int index = 0;								// array element bin
        for(int i = bin.length - 1; i >= 0; i--)
        {
            if(bin[i] == 1)
            {
                dec += exponentiation(2,index);
                index++;
            }
            else
                index++;
        }
        return dec;
    }
    // method for the convert from prefix to mask
    public static int[] fromPrefixToMask(int prefix)
    {
        int[] mask = new int[4];  			// array where will be saved the resulting mask  
        int full = prefix / 8;				// find out how many octets will be 255
        for(int i = 0; i < full;i++)
        {
            mask[i] = 255;
        }
        if(full < 4)
        {
            prefix = prefix - (full*8);		// deducted from the total prefix octets which are 255
            int[] activeOctet = new int[8];	// array where will be saved remaining 1 of prefix
            for(int i = 0; i < prefix;i++)
            {
                activeOctet[i] = 1;
            }
            mask[full] = fromBinToDec(activeOctet);
        }

        return mask;
    }
    // method for convert from mask to prefix
    public static int fromMaskToPrefix(int[] mask)
    {
        int prefix = 0;                     			// prefix
        for(int i = 0; i < mask.length;i++)				// browse the mask octets
        {
            int[] pole = fromDecToBin(mask[i]);			// octet of the mask converts to the binary number
            for(int a = 0; a < pole.length;a++)			// cycle find out how many 1 there are in octet
            {
                if(pole[a] == 1)
                    prefix++;
                else									// if will be given element of array zero the program returns prefix
                	return prefix;
            }
        }
        return prefix;
    }
    // method for convert from prefix to wildcard
    public static int[] fromPrefixToWildcard(int prefix)
    {
    	int[] mask = fromPrefixToMask(prefix);         // array where is converted prefix to mask
		int[] Wildcard = fromMaskToWildcard(mask);     // array where will be saved wildcard
		return Wildcard;
    }
    // method for convert from mask to wildcard
    public static int[] fromMaskToWildcard(int[] mask)
    {
        int[] Wildcard = new int[4];      				// array where will be saved wildcard
        for(int index = 0; index < Wildcard.length;index++)
        {
            Wildcard[index] = 255 - mask[index];
        }
        return Wildcard;
    }
    // method for convert from wildcard to mask
    public static int[] fromWildcardToMask(int[] wildcard)
    {
    	int[] mask = new int[4];            			// array where will be saved mask
    	
    	for(int i = 0; i < mask.length;i++)
    	{
    		mask[i] = 255 - wildcard[i];
    	}
    	return mask;
    }
    // method for convert from wildcard to prefix
    public static int fromWildcardToPrefix(int[] wildcard)
    {
    	int prefix = fromMaskToPrefix(fromWildcardToMask(wildcard));
    	return prefix;
    }
    // method for get network or broadcast address
    public static int[] getNetOrBroAddress(int[] address,int prefix,boolean net)	// if net==true->getNet  if net==false->getBro
    {
    	if(prefix == 32)											// if prefix = 32 return full address because  nothing changes 
    		return address;
        
    	int[] octet1 = fromDecToBin8(address[0]);
    	int[] octet2 = fromDecToBin8(address[1]);
    	int[] octet3 = fromDecToBin8(address[2]);
    	int[] octet4 = fromDecToBin8(address[3]);
    	int fromThisPrefix = prefix / 8 + 1; 						// calculated in which the octet is starting to change 0/1
    	int border = prefix - (prefix / 8)*8;						// border where starts change 0/1
    	
    	changeOctet(octet1, fromThisPrefix, 1, border, net);		// change octet1
    	changeOctet(octet2, fromThisPrefix, 2, border, net);		// change octet2
    	changeOctet(octet3, fromThisPrefix, 3, border, net);		// change octet3
    	changeOctet(octet4, fromThisPrefix, 4, border, net);		// change octet4
    	
    	int[] outAddress = new int[4];								// array where will be saved the resulting address
    	outAddress[0] = fromBinToDec(octet1);						
    	outAddress[1] = fromBinToDec(octet2);
    	outAddress[2] = fromBinToDec(octet3);
    	outAddress[3] = fromBinToDec(octet4);
    	return outAddress;
    }
    // method for change octet for method getNetOrBroAddress 
    public static void changeOctet(int[] octet,int fromThisPrefix,int numOctet,int border,boolean net)	//octet,fromThisPrefix,number octet,border,net
    {
    	if(fromThisPrefix <= numOctet)			// numOctet - number octets which is changing 
    	{
    		border = (fromThisPrefix == numOctet) ? border : 0;
    		for(int i = border;i < 8;i++)
    		{
    			octet[i] = (net) ? 0 : 1;		// change 1/0    - if true numbers are changing on 0  if false on 1
    		}
    	}
    }
    // method for find out number all address 
    public static int getSpaceAddress(int prefix)
    {
    	int spaceAddress;
    	spaceAddress = exponentiation(2,32 - prefix);
    	return spaceAddress;	
    }
    // method for find out the first or the last address 
    public static int[] getFirstOrLastAddress(int[] address,int prefix,boolean or)	//if or==true->getFirst if or==false->getLast
    {
    	int[] net = getNetOrBroAddress(address,prefix,true);     	// array for network address	
    	int[] bro = getNetOrBroAddress(address,prefix,false);		// array for broadcast address
    	
    	net[3]++;
    	bro[3]--;
    	
    	return (or) ? net : bro;	
    }
    // method for exponentiation
    public static int exponentiation(int base, int exponent)
    {
        int out = 0;
        for(int i = 0; i <= exponent; i++)
        {
            if( i == 0)
                out = 1;
            else
                out = out * base;
        }
        return out;
    }
    // method for find out number bits decimal number 
    public static int bits(int dec)
    {
        if (dec == 0)		// if dec = 0 binary is had 1 number-> 0 
            return 1;
        for(int index = 0;;index++)
        {
            int f = exponentiation(2,index);   
            if(dec / f == 0)
            {
                return index;
            }
        }
    }
    // method for convert from String array to int array 
    public static int[] stringArrayToIntArray(String[] array)
    {
        int[] arrayInt = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            arrayInt[i] = Integer.parseInt(array[i]);
        }
        return arrayInt;
    }

}