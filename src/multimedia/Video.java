package multimedia;

public class Video extends Multimedia implements volume, lighting {
	
	private int duration = 1;
	protected int volume = 1;
	protected int light = 1;

	public Video(String title) {
		super(title, "video");
		this.title = title;
	}
	
	public Video(String title, int duration) {
		super(title, "video");
		this.title = title;
		this.setDuration(duration);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public void volumeUp(int n) {
		this.volume += n;		
	}

	@Override
	public void volumeDown(int n) {
		this.volume -= n;		
	}
	
	@Override
	public void lightingUp(int n) {
		this.light += n;
	}

	@Override
	public void lightingDown(int n) {
		this.light -= n;
	}
	
	@Override
	public void play() {
		int v = this.volume;
		int d = this.getDuration();
		String vol = "Volume: ";
		int l = this.light;
		String light = "Brightness: ";
		
		for (int i=0; i<v; i++) {
			vol += "!";
		}
		
		for (int i=0; i<l; i++) {
			light += "*";
		}
			
		for (int i = 0; i<d; i++) {
			System.out.println(this.toString() + " - " + vol + " - " + light);
		}	
	}
	

}
