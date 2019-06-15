import java.util.*;

class Solution

{

//desired mehod solution

//Accepts a string of calls and return the price

public static int solution(String s)

{

int noOfLines=0,i,j;

int mm,hh,ss,secs,mins;

int total,price,free=0;

String lines[]=new String[100];

//separating the call logs

StringTokenizer tok=new StringTokenizer(s,"\n",false);

while(tok.hasMoreTokens())

{

String t=tok.nextToken();

lines[noOfLines]=t;

noOfLines++;

}

//Store the teh call time and phone numbers of each call in 2D StringBuffer

StringBuffer phone[][]=new StringBuffer[noOfLines][2];

StringBuffer tempPhone[][]=new StringBuffer[noOfLines][2];

for(i=0;i<noOfLines;i++)

{

phone[i][0]=new StringBuffer(lines[i].substring(0,8));

phone[i][1]=new StringBuffer(lines[i].substring(9));

tempPhone[i][0]=new StringBuffer(lines[i].substring(0,8));

tempPhone[i][1]=new StringBuffer(lines[i].substring(9));

}

// Calculate the total price without free offer and store in total

price=0;

total=0;

for(i=0;i<noOfLines;i++)

{

secs=getTotalSeconds(phone[i][0]); // compute the total secs called

if(secs<300)

price=secs*3;

else if(secs>=300)

{

mins=(int)Math.ceil((double)secs/60) ;

price=mins*150;

}

total=total+price;

}

//Calculating maximum call duration and amount to be free

int longest=0;

int tfree=0;

int totalsecs=0;

for(i=0;i<noOfLines-1;i++)

{

secs=getTotalSeconds(tempPhone[i][0]);

totalsecs=secs;

if(secs<300)

price=secs*3;

else if(secs>=300)

{

mins=(int)Math.ceil((double)secs/60) ;

price=mins*150;

}

tfree=price;

for(j=i+1;j<noOfLines;j++)

{

if(tempPhone[i][1].toString().equals(tempPhone[j][1].toString()))

{

secs=getTotalSeconds(tempPhone[j][0]);

totalsecs+=secs;

if(secs<300)

price=secs*3;

else if(secs>=300)

{

mins=(int)Math.ceil((double)secs/60) ;

price=mins*150;

}

tfree=tfree+price;

for(int k=j;k<noOfLines-1;k++)

{

tempPhone[k][0]=tempPhone[k+1][0];

tempPhone[k][1]=tempPhone[k+1][1];

}

j--;

noOfLines--;

}

}

if(longest<totalsecs)

{

free=tfree;

longest=totalsecs;

}

}

return (total - free);

}

//This method return the total call durations in second

public static int getTotalSeconds(StringBuffer phone)

{

int hh=Integer.parseInt(phone.substring(0,2));

int mm=Integer.parseInt(phone.substring(3,5));

int ss=Integer.parseInt(phone.substring(6,8));

int secs=hh*3600 + mm*60 +ss;

return secs;

}

// main program

public static void main(String args[])

{

String s="00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";

int price=solution(s);

System.out.println(s);

System.out.println("\nTotal Bill = "+ price);

}
}
