import java.util.*;
 
public class wikijava
{
	//Antalet omflyttningar vi får göra.
	static int antal;
 
	//Letar fram indexet för den första förekomsten av den angivna bokstaven.
	/*
	ord: Vår array med bokstäver som representerar vårt ord.
	find: Bokstaven vi ska hitta.
	from: Vi vill leta efter bokstaven framför detta index i arrayn.
	*/
	public static int findFirst(char [] ord, char find, int from)
	{
		for(int i = from; i<ord.length; i++)
		{
			if(ord[i]==find) return i;
		}
 
		return from;
	}
 
	//Avgör om det är möjligt att flytta bokstaven från ett index
	// till ett annat index inom antalet tillåtna drag.
	/*
	ord: Vår array med bokstäver som representerar vårt ord.
	to: Indexet vi vill flytta till
	from: Indexet vi vill flytta från.
	*/
	public static boolean isPossible(char [] ord, int to, int from)
	{
		if(from-to<=antal) return true;
		else return false;
	}
 
	//Flyttar en bokstav från ett index till ett annat.
	/*
	ord: Vår array med bokstäver som representerar vårt ord.
	to: Indexet vi ska flytta till
	from: Indexet vi ska flytta från.
	*/
	public static void move(char [] ord, int to, int from)
	{
		for(int i = from; i>to; i--)
		{
			char tmp = ord[i];
			ord[i] = ord[i-1];
			ord[i-1] = tmp;
 
			//Vi har förbrukat ett drag.
			antal--;
		}
	}
 
	public static void main(String [] klein)
	{
		Scanner scan = new Scanner(System.in);
 
		String sekvens = scan.next();
 
		antal = scan.nextInt();
 
		//Omvandlar ordet till en char-array som är trivsammare att hanskas med.
		char [] ord = sekvens.toCharArray();
 
		//Skapar en kopia av ordet och sorterar bokstäverna.
		//På så sätt vet vi enkelt vilken bokstav vi bör leta
		// efter härnäst. Den som ligger längst fram är bäst osv.
		char [] optimal = Arrays.copyOfRange(ord, 0, ord.length);
		Arrays.sort(optimal);
 
		//Håller reda på vilka bokstäver vi har flyttat till
		// sin "rätta" position.
		boolean [] used = new boolean [ord.length];
		Arrays.fill(used, false);
 
		//Flyttar bokstäverna.
		for(int i = 0; i<ord.length; i++)
		{
			//Flyttar bästa möjliga bokstaven till vår position.
			for(int j = 0; j<ord.length; j++)
			{
				//Om den inte redan står rätt förstås.
				if(ord[i]!=optimal[j])
				{
					//Om vi redan använt den här optimala bokstaven
					// så går vi vidare till nästa varv i loopen.
					//D.v.s. vi kollar nästa bästa bokstav.
					if(used[j]) continue;
 
					//Hittar indexet för vår önskade bokstav.
					int from = findFirst(ord, optimal[j], i);
 
					//Kollar om det är möjligt att flytta bokstaven till
					// vår önskade position.
					if( isPossible(ord, i, from) )
					{
						//Flyttar bokstaven.
						move(ord, i, from);
 
						//Nu har vi använt den, den står rätt.
						used[j] = true;
 
						//Avbryter den inre loopen. Nu är vi ju klara
						// med den här positionen. Gå vidare till nästa.
						break;
					}
				}
				else //Om den redan står rätt.
				{
					//Då har vi redan använt det valet ju.
					used[j] = true;
 
					//Och vi går vidare på nästa position.
					break;
				}
			}
 
			//Onödigt att bara fortsätta köra på.
			if(antal==0) break;
		}
 
		//Gör om den bästa sekvensen till en String.
		String svar = new String(ord);
 
		//Skriver ut svaret.
		System.out.println(svar);
	}
}
