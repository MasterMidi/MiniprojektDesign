package model;

import java.util.ArrayList;

public class LP {
	private ArrayList<Copy> copies;
	private String title;
	private String artist;
	private String barcode;
	private String publicationDate;
	
	public LP(String title, String artist, String barcode, String publicationDate) {
		super();
		this.title = title;
		this.artist = artist;
		this.barcode = barcode;
		this.publicationDate = publicationDate;
		
		copies = new ArrayList<>();
		
		copies.add(new Copy("3192380192"));
		copies.add(new Copy("2547398573"));
		copies.add(new Copy("2347956744"));
		copies.add(new Copy("8912398795"));
		copies.add(new Copy("1237497433"));
		copies.add(new Copy("4129085238"));
	}
	
	public void addCopy(Copy copy) {
		copies.add(copy);
	}
	
	public void removeCopy(Copy copy) {
		copies.remove(copy);
	}
	
	public Copy findCopy(String serialNumber) {
		return null;
		
	}
	
	public Copy[] getCopies() {
		return copies.toArray(Copy[]::new);
	}
	
	public LP(String title) {
		this(title, null, null, null);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
}
