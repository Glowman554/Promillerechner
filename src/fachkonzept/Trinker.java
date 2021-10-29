package fachkonzept;

public class Trinker
{
	private char geschlecht = '-';
	private Getraenk getrunkenesGetraenk = null;
	private int koerpergewichtKG = 0;
	private double reduktionsfaktor = 0.0;


	public Trinker(char geschlecht, Getraenk getrunkenesGetraenk, int koerpergewichtKG)
	{
		this.setzeGeschlecht(geschlecht);
		this.trinken(getrunkenesGetraenk);
		this.setzeKoerpergewichtKG(koerpergewichtKG);
	}

	public double berechenBlutalkoholgehalt()
	{
		return getrunkenesGetraenk.berechneAlkoholgewchtG() / (reduktionsfaktor * koerpergewichtKG);
	}

	public void setzeGeschlecht(char pGeschlecht)
	{

		switch (pGeschlecht)
		{
			case 'm':
				{
					reduktionsfaktor = 0.7;
				}
				break;
			case 'w':
				{
					reduktionsfaktor = 0.6;
				}
				break;
			default:
				{
					throw new IllegalArgumentException("Geschlecht muss m oder w sein");
				}
		}

		this.geschlecht = pGeschlecht;
	}

	public void setzeKoerpergewichtKG(int pKoerpergewichtKG)
	{
		if (pKoerpergewichtKG <= 0)
		{
			throw new IllegalArgumentException("Koerpergewicht darf nicht negativ sein");
		}

		this.koerpergewichtKG = pKoerpergewichtKG;
	}

	public void trinken(Getraenk pGetrunkenesGetraenk)
	{
		if (pGetrunkenesGetraenk == null)
		{
			throw new IllegalArgumentException("Getraenk darf nicht null sein");
		}

		this.getrunkenesGetraenk = pGetrunkenesGetraenk;
	}
}
