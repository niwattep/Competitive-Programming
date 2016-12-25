import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Test {
	static Integer[] originalArray = {54,694,1,8,64,5,8,4,6,746,64,64,86,5,23,25,91};

    static Track track1 = new Track("Smooth", "Santana", "Supernatural",
                Track.Genre.Rock, "M. Itaal Shur & Rob Thomas", 298161,
                9867455, 5);
    static Track track2 = new Track("smooth", "santana", "Ultimate Santana",
                Track.Genre.Rock, "M. Itaal Shur & Rob Thomas", 298161,
                9867455, 2);
    static Track track3 = new Track("Maria Maria", "Santana", "Supernatural",
                Track.Genre.Rock,
                "W. Jean, J. Duplessis, Carlos Santana, K. Perazzo & R. Rekow",
                262635, 8664601, 4);
    static Track track4 = new Track(
                "Imagine",
                "U2",
                "Instant Karma: The Amnesty International Campaign to Save Darfur",
                Track.Genre.Pop, "", 219078, 3562542, 1);
    static Track track5 = new Track("Imagine", "John Lennon", "Imagine",
                Track.Genre.Rock, "John Lennon", 183012, 2976578, 5);
    
    static Track[] tracks = { track1, track2, track3, track4, track5 };

    public static void main(String[] args) {
        
        System.out.println("________Original________");
        printTracks(tracks);
        
        Arrays.sort(tracks, new Comparator<Track>() {
        	@Override
        	public int compare(Track t1, Track t2) {
        		return (int)t1.getTrackLength() - (int)(t2.getTrackLength());
        	}
        });
        System.out.println("________By Length________");
        printTracks(tracks);

        Arrays.sort(tracks, (Track t1, Track t2) -> t2.getRating() - t1.getRating());
        System.out.println("________By Rating________");
        printTracks(tracks);
        
        Integer[] newArray = new Integer[originalArray.length];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        
        Arrays.sort(newArray, (Integer t1, Integer t2) -> t2 - t1);
        System.out.println("________newArray________");
        printArray(newArray);
        System.out.println("________originalArray________");
        printArray(originalArray);
        
        ArrayList<Track> trackList = new ArrayList<Track>(Arrays.asList(tracks));
        
        trackList.forEach(track -> System.out.println(track.getGenre()));  
    }
    
    static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    static void printTracks(Track[] tracks) {
        for (int i = 0; i < tracks.length; i++){
            tracks[i].briefPrint();
        }
    }
}
