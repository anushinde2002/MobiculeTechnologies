import java.util.ArrayList;
public class MusicLib {
    private ArrayList<Song>songs;
    public MusicLib()
    {
        songs=new ArrayList<>();


    }
    public void addSong(Song song)
    {
        songs.add(song);
    }
    public void displaySongBySinger(String singer)
    {
        System.out.println("Songs by"+singer+":");
        boolean found=false;
        for(Song song:songs)
        {
            if(song.getSinger().equalsIgnoreCase(singer))
            {
                song.displayInfo();
                found=true;
            }


        }
        if(!found)
        {
            System.out.println("No songs found for this singer:");
        }
    }

}