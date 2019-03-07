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
        player.play("file.divx");
    }

    private static class FormatAdapter implements MediaPlayer { //implentamos interfaz
        //nuevo obj de otra interfaz
        private MediaPackage media;
        private MediaDivX divx;

        //(misma interfaz) y asociamos esos dos
        public FormatAdapter(MediaPackage m) {
            media = m;
        }
//        
        public FormatAdapter(MediaDivX d){
            divx = d;
        }

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            media.playFile(filename);
            divx.playFilm(filename);
//            //asi el obj de la interfaz MediaPackage
            //accede a los metodos de la interfaz MediaPlayer (MP4 y VLC)
        }

    }
}
