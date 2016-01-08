//**************************************************************************************************
//	Song.java								Matt Matuk
// 	CSIT 268								Project 6-6
//
//	This class is used to store the different songs info that will be used when picking a
// 	song from the list of songs
//
//
//***************************************************************************************
package net.androidbootcamp.yourpersonalplaylist;

public class Song implements Comparable<Song>
{
	private int name;
	private int picture;
	private int picDes;
	private int song;
	private String strName;

	/**
	 * Creates the song and sets its vars to the passed vars
	 *
	 * @param strN
	 * @param n
	 * @param p
	 * @param pDes
	 * @param s
	 */
	public Song(String strN, int n, int p, int pDes, int s)
	{
		strName = strN;
		name = n;
		picture = p;
		picDes = pDes;
		song = s;
	}
	
	public String getStrName()
	{
		return strName;
	}
	
	public int getName()
	{
		return name;
	}
	
	public int getPicture()
	{
		return picture;
	}
	
	public int getPicDes()
	{
		return picDes;
	}
	
	public int getSong()
	{
		return song;
	}
	
	
	public void setStrName(String strN)
	{
		strName = strN;
	}
	
	public void setName(int n)
	{
		name = n;
	}
	
	public void setPicture(int p)
	{
		picture = p;
	}
	
	public void setPicDes(int pDes)
	{
		picDes = pDes;
	}
	
	public void setSong(int s)
	{
		song =s;
	}
	
	public String toString()
	{
		return "The song ids are: Name: " + name + "\t" + "Picture: " + picture;
	}

	@Override
	public int compareTo(Song another)
	{
		return another.getStrName().compareTo(this.getStrName());
	}

}
