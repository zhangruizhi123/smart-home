package com.telrob.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
  public static String MD5(String inStr)
  {
    MessageDigest md5 = null;
    try
    {
      md5 = MessageDigest.getInstance("MD5");
    }
    catch (Exception e)
    {
      System.out.println(e.toString());
      e.printStackTrace();
      return "";
    }
    char[] charArray = inStr.toCharArray();
    byte[] byteArray = new byte[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      byteArray[i] = ((byte)charArray[i]);
    }
    byte[] md5Bytes = md5.digest(byteArray);
    StringBuffer hexValue = new StringBuffer();
    for (int i = 0; i < md5Bytes.length; i++)
    {
      int val = md5Bytes[i] & 0xFF;
      if (val < 16) {
        hexValue.append("0");
      }
      hexValue.append(Integer.toHexString(val));
    }
    return hexValue.toString();
  }
  
  public static String getUUID() {
	  UUID uuid=UUID.randomUUID();
	  return uuid.toString().replace("-", "").toLowerCase();
  }
  
  public static String getRandomId() {
	  BigInteger dev=new BigInteger("62");
	  BigInteger zer=new BigInteger("0");
	  long currentTime=System.currentTimeMillis();
	  int rand=(int) ((Math.random()*9+1)*10000);
	  BigInteger big=new BigInteger(currentTime+""+rand);
	  List<Integer>list=new ArrayList<Integer>();
	  do {
		  int mod=big.mod(dev).intValue();
		  list.add(mod);
		  big=big.divide(dev);
	  }while(big.compareTo(zer)>0);
	  String result="";
	  for(int i=list.size()-1;i>=0;i--) {
		  int temp=list.get(i);
		  if(temp<10) {
			  result+=temp;
		  }else if(temp<36) {
			  result+=(char)(temp-10+'A');
		  }else {
			  result+=(char)(temp-36+'a');
		  }
	  }
	  return result;
  }
  
  public static void main(String[] args) {
	System.out.println(getRandomId());
}
}
