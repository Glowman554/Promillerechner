package benutzerschnittselle;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import fachkonzept.Getraenk;
import fachkonzept.Trinker;

public class Konsole
{
	public static void main(String[] args)
	{
		// System.out.println("Hallo Welt!");

		// Getraenk g = new Getraenk(40, 200);
		// Trinker t = new Trinker('m', g, 85);

		// System.out.println(t.berechenBlutalkoholgehalt());

		/*
			Konsolenoutput:


			Promillerechner
			---------------
			Daten zum Trinker
			Geschlecht (m/w): 
			m
			Körpergewicht [kg]: 
			85
			Daten zum Getränk
			Menge [ml]: 
			200
			Alkoholgehalt [Vol.-%]: 
			40
			Ergebnis
			Blutalkoholkonzentration: 
			1.0756302521008405 Promille
		*/

		System.out.println("Promillerechner\n---------------");

		System.out.println("Daten zum Trinker");

		Scanner input = new Scanner(System.in);

		System.out.println("Geschlecht (m/w): ");

		char geschlecht;
		while (true)
		{
			geschlecht = input.nextLine().charAt(0);
			
			if (geschlecht == 'm' || geschlecht == 'w')
			{
				break;
			}

			System.out.println("Bitte geben Sie m oder w ein.");
		}

		System.out.println("Körpergewicht [kg]: ");

		int koerpergewicht;
		while (true)
		{
			try
			{
				koerpergewicht = Integer.parseInt(input.nextLine());

				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Bitte geben Sie eine Zahl ein.");
			}
		}

		System.out.println("Daten zum Getränk");

		System.out.println("Menge [ml]: ");

		int menge;
		while (true)
		{
			try
			{
				menge = Integer.parseInt(input.nextLine());

				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Bitte geben Sie eine Zahl ein.");
			}
		}

		System.out.println("Alkoholgehalt [Vol.-%]: ");

		double alkoholgehalt;
		while (true)
		{
			try
			{
				NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
				alkoholgehalt = numberFormat.parse(input.nextLine()).doubleValue();

				break;
			}
			catch (ParseException e)
			{
				System.out.println("Bitte geben Sie eine Zahl ein.");
			}
		}

		Trinker t = new Trinker(geschlecht, new Getraenk(alkoholgehalt, menge), koerpergewicht);

		System.out.println("Ergebnis");

		System.out.printf("Blutalkoholkonzentration:\n%.2f Promille\n", t.berechenBlutalkoholgehalt());	

		input.close();
	}
}
