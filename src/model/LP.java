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
	
	/**
	 * Adds a copy to the LP, and assigns the parentLP field of copy to this.
	 * @param copy the copy which is to be added
	 */
	public void addCopy(Copy copy) {
		copy.setParentLP(this);
		copies.add(copy);
	}
	
	/**
	 * Removes a copy from the LP
	 * @param copy copy to be removed
	 */
	public void removeCopy(Copy copy) {
		copies.remove(copy);
	}
	
	/**
	 * Returns all the copies of this LP.
	 * @return A list of copies contained in this LP
	 */
	public List<Copy> getCopies() {
		return new ArrayList<>(copies);
	}

	/**
	 * Return the LPs title
	 * @return title of the LP
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * sets a new title for this LP
	 * @param title the title to be used
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * returns the artist name of this LP
	 * @return the Artist name.
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * sets the artist name to this LP
	 * @param artist the new artist name
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * returns the LPs barcode
	 * @return the barcode of the LP
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * sets the barcode og this LP
	 * @param barcode the new barcode to be used.
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * return the publication date of this LP
	 * @return the publication date
	 */
	public String getPublicationDate() {
		return publicationDate;
	}

	/**
	 * sets the publication date of this LP
	 * @param publicationDate the new publication date to be used
	 */
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
}
