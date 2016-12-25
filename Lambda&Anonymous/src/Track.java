import java.lang.Comparable;


public class Track implements Comparable<Track> {
	public enum Genre {
        Undefined, Rock, Jazz, Metal, Punk, RocknRoll, Blues, Latin, Reggae, Pop, Soundtrack, BossaNova, EasyListening, HeavyMetal, RnB, Electronica, World, HipHop, SciFi, TVShows, Fantasy, Drama, Comedy, Alternative, Classical, Opera
    };

    private String trackName;
    private String artistName;
    private String albumName;
    private Genre genre;
    private String composerName;
    private int trackLength; // in milliseconds
    private int trackSize; // in bytes
    private int rating; // 1-dislike, 2-indifferent, 3-okay, 4-like, 5-love

    public Track(String trackName, String artistName, String albumName,
            Genre genre, String composerName, int trackLength, int trackSize,
            int rating) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.genre = genre;
        this.composerName = composerName;
        this.trackLength = trackLength;
        this.trackSize = trackSize;
        this.rating = rating;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getComposerName() {
        return composerName;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }

    public double getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public double getTrackSize() {
        return trackSize;
    }

    public void setTrackSize(int trackSize) {
        this.trackSize = trackSize;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.trackName + "  |  " + this.artistName + "  |  "
                + this.albumName + "  |  " + this.genre.toString() + "  |  "
                + this.composerName + "  |  " + this.trackLength + "  |  "
                + this.trackSize + "  |  " + this.rating;
    }

    /**
     * Compares two tracks by the artist name and then by track name,
     * lexicographically, ignoring case differences. The result is a negative
     * integer if this Track object precedes <code>anotherTrack</code>. The
     * result is a positive integer if this Track object follows
     * <code>anotherTrack</code>. The result is zero if the tracks are
     * equivalent.
     * 
     * @param anotherTrack
     *            the Track to be compared
     * @return the value of 0 if the argument track is equivalent to this track;
     *         a value less than 0 if this track precedes the argument track; a
     *         value greater than 0 if this track follows the argument track.
     */
    @Override
    public int compareTo(Track anotherTrack) {
        // @TODO: Rewrite the code below
        // Hint: This function may use String.compareToIgnoreCase()
        // http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareToIgnoreCase(java.lang.String)
        // Hint: This function may use getArtistName()
        // Hint: This function may use getTrackName()
        // Hint: estimated 3-10 lines of code

        if (this.getArtistName().compareToIgnoreCase(anotherTrack.getArtistName()) == 0) {
            if (this.getTrackName().compareToIgnoreCase(anotherTrack.getTrackName()) == 0) {
                return 0;
            }
            if (this.getTrackName().compareToIgnoreCase(anotherTrack.getTrackName()) < 0) {
                return -1;
            }
            if (this.getTrackName().compareToIgnoreCase(anotherTrack.getTrackName()) > 0) {
                return 1;
            }
        }
        if (this.getArtistName().compareToIgnoreCase(anotherTrack.getArtistName()) < 0) {
            return -1;
        }
        if (this.getArtistName().compareToIgnoreCase(anotherTrack.getArtistName()) > 0) {
            return 1;
        }
        return 0;
    }

    public void print() {
        System.out.print(this);
    }

    public void briefPrint() {
        System.out.println(this.artistName + "'s " + this.trackName + " | "
            + this.rating + " | " + this.trackLength);
    }
}
