package com.example.hellowrld;

public class XMLCollectedData {
    String city;
    int temp;
    
    public void setCity(String c)
    {
    city = c;
}
    public void setTemp(int t){
    	temp = t;
    }
    public String dataToString(){
    	return "In "+city +" current temp is "+temp +" degrees.";
    }
}
