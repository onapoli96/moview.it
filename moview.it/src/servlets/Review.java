package servlets;

public class Review {
	private double valutazione;
	private String user;
	private String text;
	
	public Review() {
	}
	
	public Review(double valutazione, String user, String text) {
		this.valutazione = valutazione;
		this.user = user;
		this.text = text;
	}


	@Override
	public String toString() {
		return "Review [valutazione=" + valutazione + ", user=" + user + ", text=" + text + "]";
	}
	public double getValutazione() {
		return valutazione;
	}
	public void setValutazione(double valutazione) {
		this.valutazione = valutazione;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
