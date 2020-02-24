package com.CleanCode.maven.CleanCode;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
class InterestCalculator
{
	static double SimpleInterest(double principle, double year, double rate)
	{
		double SI=(principle*year*rate)/100;
		return SI;
	}
	static double CompoundInterest(double principle,double year, double rate)
	{
		double increment=1+(rate/100);
		double CI=Math.pow(increment, year)*principle;
		return CI;
	}
}

class ConstructionCost
{
	static double TotalCost(int materialChoice,double area)
	{
		double total_cost=0;
		switch(materialChoice)
		{
		case 1:
			total_cost=1200*area;
			break;
		case 2:
			total_cost=1500*area;
			break;
		case 3:
			total_cost=1800*area;
			break;
		case 4:
			total_cost=2500*area;
			break;
		}
		return total_cost;
	}
		
}
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	final Logger LOGGER=LogManager.getLogger(App.class);
    	System.out.append("Enter the princile amount, year, and rate of interest");
    	double year=sc.nextDouble();
    	double principle=sc.nextDouble();
    	double rate=sc.nextDouble();
    	System.out.append("Press 1 to check Simple Interest\nPress 2 to check Compound Interest");
    	int choice=sc.nextInt();
    	if(choice==1)
    	{
    		double SI=InterestCalculator.SimpleInterest(principle,year,rate);
    		LOGGER.debug("Simple Interest:"+SI);
    	}
    	else
    	{
    		double CI=InterestCalculator.CompoundInterest(principle,year,rate);
    		LOGGER.debug("Compound Interest:"+CI);
    	}
    	System.out.append("Enter yout housing area:");
    	float area=sc.nextFloat();
    	System.out.append("Press 1 for standard material\nPress 2 for above standard material\nPress 3 for high standard material\nPress 4 for high standard material and fully automated home");
    	choice=sc.nextInt();
    	double cost=ConstructionCost.TotalCost(choice,area);
    	LOGGER.debug("Construction Cost:"+cost);
    }
}
