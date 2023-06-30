package multimedia;

public abstract class Multimedia {

	public String title;
	public String type;

	public Multimedia (String title, String type) {
		this.title = title;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "File " + type + " - Title: " + title;
	}
	
	public void play() {
		System.out.println(this.toString());
	}
}
