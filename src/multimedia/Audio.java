package multimedia;

public class Audio extends Multimedia implements volume  {
	
	private int duration = 1;
	protected int volume = 1;

	public Audio(String title) {
		super(title, "audio");
	}

	public Audio(String title, int duration) {
		super(title, "audio");
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
	public void play() {
		int v = this.volume;
		int d = this.getDuration();
		String vol = "Volume: ";
		
		for (int i=0; i<v; i++) {
			vol += "!";
		}
			
		for (int i = 0; i<d; i++) {
			System.out.println(this.toString() + " - " + vol);
		}	
	}

}
