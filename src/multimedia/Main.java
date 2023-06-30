package multimedia;

import java.util.Scanner;

public class Main {
	
	final static int MAX_MEDIA = 1;
	static Scanner scan = new Scanner(System.in);
	
	static Multimedia[] mediaArr = new Multimedia[MAX_MEDIA];
	static Multimedia myMedia;
	
	static int selected;
	static boolean stop = false;

	public static void main(String[] args) {
        System.out.println("Welcome! Here you can create a library of " + MAX_MEDIA + " media elements.");
        
		createMedia();
        System.out.println("Congrats! You have now access to your library! Press 0 to close at any time");

        do {
            selectMedia();
        } while (!stop);
        
        scan.close();  
        System.out.println("Thank you! Come back any time!");
	}
	
	public static void createMedia() {
		for (int i = 0; i < MAX_MEDIA; i++) {
            System.out.println("File #" + (i+1) +" - Type (audio, video, image): ");
            String mediaClass = scan.nextLine();

            System.out.println("File #" + (i+1) +" - Title: ");
            String title = scan.nextLine();

            int duration = 0;
            int brightness = 0;
            if (mediaClass.equalsIgnoreCase("audio") || mediaClass.equalsIgnoreCase("video")) {
                System.out.println("Type #" + (i+1) + " - Duration: ");
                duration = scan.nextInt();
            }

            if (mediaClass.equalsIgnoreCase("image") || mediaClass.equalsIgnoreCase("video")) {
                System.out.println("File #" + (i+1) + " - Brightness: ");
                brightness = scan.nextInt();
            }

            switch (mediaClass.toLowerCase()) {
                case "audio":
                	mediaArr[i] = new Audio(title, duration);
                    break;
                case "video":
                	mediaArr[i] = new Video(title, duration);
                    break;
                case "image":
                	mediaArr[i] = new Image(title, brightness);
                    break;
                default:
                    System.out.println("Invalid Media Type. Press ENTER to continue.");
                    i--;
            }
            
        }
		
	}
	
	public static void selectMedia() {
		System.out.println("You can select a Media file (1-" + MAX_MEDIA + "): ");
        selected = scan.nextInt();
        if (selected == 0) {
        	stop = true;
        } else if (selected >= 1 && selected <= MAX_MEDIA) {
        	selectAction();
        } else {
        	System.out.println("Invalid Index");
        }
	}
	
	public static void selectAction() {
		myMedia = mediaArr[selected - 1];
        
		System.out.println("Choose an option:");
		
		switch (myMedia.type) {
		case "audio": 
			System.out.println("1. Play");
	        System.out.println("2. Edit Volume");
	        break;
		case "video": 
			System.out.println("1. Show");
	        System.out.println("2. Edit Volume");
	        System.out.println("3. Edit Brightness");
	        break;
		case "image": 
			System.out.println("1. Show");
			System.out.println("2. Edit Brightness");
			break;
		default: 
			System.out.println("Error");
		}
		
		int option = scan.nextInt();
		String type = myMedia.type;
		
		switch (option) {
		case 0:
			stop = true;
			break;
        case 1:
            myMedia.play();
            break;
        case 2:
            if (type == "audio") {
            	System.out.println("New volume (1-10): ");
                int newVolume = scan.nextInt();
                ((Audio)myMedia).volume = newVolume;
            } else if (type == "video") {
            	System.out.println("New volume (1-10): ");
                int newVolume = scan.nextInt();
                ((Video)myMedia).volume = newVolume;
            } else if(type == "image") {
            	System.out.println("New brightness (1-10): ");
                int newBrightness = scan.nextInt();
                ((Image) myMedia).light = newBrightness;            
            }
            break;
        case 3:
        	System.out.println("New brightness (1-10): ");
            int newBrightness = scan.nextInt();
            ((Video) myMedia).light = newBrightness;  
        default:
            System.out.println("Invalid option. Please choose again.");
		}
	}
}
