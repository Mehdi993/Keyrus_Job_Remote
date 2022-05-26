package routines;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */

import java.math.BigDecimal;

public class XML_GENERATION {

    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
	
	
	
	
	
	
	
	 public static  String makeextension(String attrib,String val ) {

	    	String exOpen = "<EXTENSION>";
	    	String exClose = "</EXTENSION>";
	    	String AttOpen = "<ATTRIBUTE>";
	    	String AttClose = "</ATTRIBUTE>";   	
	    	String ValOpen = "<VALUE>";
	    	String ValClose = "</VALUE>";
	    	
	    	//if ( val == null | val.length() == 0 ) {
	    	
	    	if ( val == null ) {
	    		return "";
	    	} else if( val.length() < 1 ) {
	    		return "";
	    	} else {
	    		return exOpen + AttOpen + attrib + AttClose + ValOpen + val + ValClose + exClose;
	    	}    
	    }
	
	
	 
	 public static  String getTAEXTLClientSpainXpress(String valA, String valB, String valC, String valD, String valE, String valF, String valG, String valH, String valI, String valJ, String valK, String valL, String valM, String valN, String valO, String valP, String valQ, BigDecimal valR, String valS, String valT, String valU, String valV, String valW, BigDecimal valX, String valY, String valZ, String valAA, String valAB, String valAC, String valAD, String valAE, BigDecimal valAF, String valAG, String valAH, String valAI, String valAJ, BigDecimal valAK, String valAL, String valAM) {
	    	String FullList = ""; 

	    	FullList = FullList + makeextension( "ABBREVIATEDNAME" , valA);
	    	FullList = FullList + makeextension( "AFFILIATE" , valB);
	    	FullList = FullList + makeextension( "BILLINGCLIENTONLY" , valC);
	    	FullList = FullList + makeextension( "BRANCH" , valD);
	    	FullList = FullList + makeextension( "BUSINESSDESCRIPTION" , valE);
	    	FullList = FullList + makeextension( "CLAIMTYPE" , valF);
	    	FullList = FullList + makeextension( "CLIENTNUMBER" , valG);
	    	FullList = FullList + makeextension( "COMPANY" , valH);
	    	FullList = FullList + makeextension( "CONSUMERCLIENT" , valI);
	    	FullList = FullList + makeextension( "CREDITRULESADJ" , valJ);
	    	FullList = FullList + makeextension( "CREDITRULESIST" , valK);
	    	FullList = FullList + makeextension( "CREDITRULESNEW" , valL);
	    	FullList = FullList + makeextension( "CREDITRULESSTD" , valM);
	    	FullList = FullList + makeextension( "CURRENCY" , valN);
	    	FullList = FullList + makeextension( "DEBTORCODE" , valO);
	    	FullList = FullList + makeextension( "DEPARTMENT" , valP);
	    	FullList = FullList + makeextension( "DISCOUNTAPPLYTO" , valQ);
	    	
	    	if (valR == null) {
	    		FullList = FullList + makeextension( "DISCOUNTPERCENT" , "");
	    	} else {
	    		FullList = FullList + makeextension( "DISCOUNTPERCENT" , valR.toString());
	    	}
	    	
	    	FullList = FullList + makeextension( "EGLOBALID" , valS);
	    	FullList = FullList + makeextension( "EXPRESSCODE" , valT);
	    	FullList = FullList + makeextension( "GONETOBROKER" , valU);
	    	FullList = FullList + makeextension( "GRIPCLIENT" , valV);
	    	FullList = FullList + makeextension( "INSUREDNAME" , valW);
	    	
	    	if (valX == null) {
	    		FullList = FullList + makeextension( "LEGACYCLIENTNUMBER" , "");
	    	} else {
	    		FullList = FullList + makeextension( "LEGACYCLIENTNUMBER" , valX.toString());
	    	}
	    	
	    	
	    	FullList = FullList + makeextension( "MULTICLIENTBILLINGONLY" , valY);
	    	FullList = FullList + makeextension( "MULTICURRENCY" , valZ);
	    	FullList = FullList + makeextension( "OLDCLIENTNUMBER" , valAA);
	    	FullList = FullList + makeextension( "OPTIODATE" , valAB);
	    	FullList = FullList + makeextension( "OPTIOFLAG" , valAC);
	    	FullList = FullList + makeextension( "ORGANIZATIONNAME" , valAD);
	    	FullList = FullList + makeextension( "OWNERNAME" , valAE);
	    	
	    	if (valAF == null) {
	    		FullList = FullList + makeextension( "PARENTCLIENTNUMBER" , "");
	    	} else {
	    		FullList = FullList + makeextension( "PARENTCLIENTNUMBER" , valAF.toString());
	    	}
	    	
	    	FullList = FullList + makeextension( "REMUNERATIONTYPE" , valAG);
	    	FullList = FullList + makeextension( "SCHEME" , valAH);
	    	FullList = FullList + makeextension( "STATEMENTREQUIRED" , valAI);
	    	FullList = FullList + makeextension( "THIRDPARTYBROKER" , valAJ);
	    	    	
	    	if (valAK == null) {
	    		FullList = FullList + makeextension( "UNIQUECLIENTID" , "");
	    	} else {
	    		FullList = FullList + makeextension( "UNIQUECLIENTID" , valAK.toString());
	    	}
	    	
	    	FullList = FullList + makeextension( "USAACTIVE" , valAL);
	    	FullList = FullList + makeextension( "USAPROPERTIES" , valAM);
	    	
	        return FullList;
	    }
	
	
	 
	
	
	
	
	
	
 
}
