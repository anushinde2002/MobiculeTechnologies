abstract class Music {
    private String title;
    private String duration;

    public Music(String title, String duration) {
        this.title=title;
        this.duration=duration;



    }
    public String getTitle()
    {
        return title;
    }
    public String getDuration()
    {
        return duration;
    }
    public abstract void displayInfo();


}
