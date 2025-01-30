class Song extends Music{
    private String singer;
    public Song(String title, String duration,String singer)
    {
        super(title,duration);
        this.singer=singer;
    }
    public String getSinger()
    {
        return singer;
    }
    @Override
    public void displayInfo() {
        System.out.println("Song"+getTitle()+",Singer:"+singer+",Duration:"+getDuration());
    }

}