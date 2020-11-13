package model;

import java.util.ArrayList;
import java.util.List;

public class LP {
	private List<Copy> copies;
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
	}
	
	public LP(String title) {
		this(title, null, null, null);
	}
	
	public void addCopy(Copy copy) {
		copies.add(copy);
	}
	
	public void removeCopy(Copy copy) {
		copies.remove(copy);
	}
	
	public List<Copy> getCopies() {
		return new ArrayList<>(copies);
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
