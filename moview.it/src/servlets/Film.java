package servlets;

import java.util.ArrayList;
import java.util.Arrays;

public class Film {
	private String titolo;
	private String anno;
	private String valutato;
	private String rilasciato;
	private String runtime;
	private ArrayList<String> paesi;
	private ArrayList<String> generi;
	private String direttore;
	private ArrayList<String> scrittori;
	private ArrayList<String> attori;
	private String trama;
	private String poster;
	private String imdb;
	private String premi;
	private String type;
	
	Film(){}

	public String getTitolo() {
		return titolo;
		
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getValutato() {
		return valutato;
	}

	public void setValutato(String valutato) {
		this.valutato = valutato;
	}

	public String getRilasciato() {
		return rilasciato;
	}

	public void setRilasciato(String rilasciato) {
		this.rilasciato = rilasciato;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public ArrayList<String> getPaesi() {
		return paesi;
	}

	public void setPaesi(ArrayList<String> paesi) {
		this.paesi = paesi;
	}

	public ArrayList<String> getGeneri() {
		return generi;
	}

	public void setGeneri(ArrayList<String> generi) {
		this.generi = generi;
	}

	public String getDirettore() {
		return direttore;
	}

	public void setDirettore(String direttore) {
		this.direttore = direttore;
	}

	public ArrayList<String> getScrittori() {
		return scrittori;
	}

	public void setScrittori(ArrayList<String> scrittori) {
		this.scrittori = scrittori;
	}

	public ArrayList<String> getAttori() {
		return attori;
	}

	public void setAttori(ArrayList<String> attori) {
		this.attori = attori;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getPremi() {
		return premi;
	}

	public void setPremi(String premi) {
		this.premi = premi;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Film [titolo=" + titolo + ", anno=" + anno + ", valutato=" + valutato + ", rilasciato=" + rilasciato
				+ ", runtime=" + runtime + ", paesi=" + paesi + ", generi=" + generi + ", direttore=" + direttore
				+ ", scrittori=" + scrittori + ", attori=" + attori + ", trama=" + trama + ", poster=" + poster
				+ ", imdb=" + imdb + ", premi=" + premi + ", type=" + type + "]";
	}

	
	
	
	
	
	/*
	title
	year
	rated
	released
	runtime
	countries
	genres
	director
	writers
	actors
	plot
	poster 
	imdb
	awards
	type
	*/

}
