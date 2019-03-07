
package adaptadores;


public class DVD implements MediaDivX {

    @Override
    public void playFilm(String filename) {
        System.out.println("Playing DVD File " + filename);
    }
    
}
