package fachkonzept;

public class Getraenk
{
	private double alkoholgehaltPzt = 0;
	private int mengeMl = 0;

	public Getraenk(double alkoholgehaltPzt, int mengeMl)
	{
		this.setzeAlkoholgehaltPzt(alkoholgehaltPzt);
		this.setzeMengeMl(mengeMl);
	}

	public double berechneAlkoholgewchtG()
	{
		return this.mengeMl * (this.alkoholgehaltPzt / 100) * 0.8;
	}

	public void setzeAlkoholgehaltPzt(double pAlkoholgehaltPzt)
	{
		if (pAlkoholgehaltPzt < 0)
		{
			throw new IllegalArgumentException("Alkoholgehalt darf nicht negativ sein");
		}

		this.alkoholgehaltPzt = pAlkoholgehaltPzt;
	}

	public void setzeMengeMl(int pMengeMl)
	{
		if (pMengeMl < 0)
		{
			throw new IllegalArgumentException("Menge darf nicht negativ sein");
		}
		
		this.mengeMl = pMengeMl;
	}
}
