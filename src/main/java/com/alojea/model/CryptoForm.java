package com.alojea.model;

public class CryptoForm {

	private String word;
	private String keystream;
	private Boolean encryption;
	
	public CryptoForm() {
		super();
	}
	public Boolean getEncryption() {
		return (encryption == null)?Boolean.TRUE:encryption;//Set true by default for radio button.
	}
	public void setEncryption(Boolean encryption) {
		this.encryption = encryption;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word.replaceAll("\\s+", "");//assign string without spaces
	}
	public String getKeystream() {
		return keystream;
	}
	public void setKeystream(String keystream) {
		this.keystream = keystream;
	}
	
	
}
