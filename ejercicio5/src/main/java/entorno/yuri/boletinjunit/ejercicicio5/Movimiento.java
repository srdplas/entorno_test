package entorno.yuri.boletinjunit.ejercicicio5;

import java.util.Date;

public class Movimiento 
{
	protected String mConcepto;
	protected Date mFecha;
	protected double mImporte;

	public Movimiento()
	{
		mFecha=new Date();
	}
	
	public double getImporte() 
	{
		return mImporte;
	}

	public String getConcepto()
	{
		return mConcepto;
	}

	public void setConcepto(String newMConcepto)
	{
		mConcepto = newMConcepto;
	}

	public Date getFecha()
	{
		return mFecha;
	}

	public void setFecha(Date newMFecha)
	{
		mFecha = newMFecha;
	}


	public void setImporte(double newMImporte)
	{
		mImporte = newMImporte;
	}
}