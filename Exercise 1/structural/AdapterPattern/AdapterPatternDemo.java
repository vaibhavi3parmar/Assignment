public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("vlc", "video.vlc");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("avi", "file.avi");
    }
}
