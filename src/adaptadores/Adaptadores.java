package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        //obj tipo MediaPlayer (interfaz) = new otra clase
        MediaPlayer player = new MP3();
        //metodo de la misma interfaz (texto)
        player.play("file.mp3");

        //mismo obj = new esta clase(new otra clase())
        player = new FormatAdapter(new MP4());
        //metodo de la misma interfaz (texto)
        player.play("file.mp4");

        player = new FormatAdapter(new VLC());
        player.play("file.avi");

        player = new FormatAdapter(new DVD());
        player.play("file.dvd");

    }

    private static class FormatAdapter implements MediaPlayer { //implentamos interfaz
        //nuevo obj de otra interfaz

        private MediaPackage media;
        private MediaDivX video;

        //(misma interfaz) y asociamos esos dos
        public FormatAdapter(MediaPackage m) {
            media = m;
        }
//        

        public FormatAdapter(MediaDivX vid) {
            video = vid;
        }

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");

            try {
                media.playFile(filename);
            } catch (Exception e) {}
            
            try {
                video.playFilm(filename);
            } catch (Exception e) {}
        }

    }

}
