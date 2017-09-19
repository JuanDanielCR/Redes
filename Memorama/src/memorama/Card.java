package memorama;

import javax.swing.ImageIcon;

/**
 *
 * @author JuanDanielCR
 */
public class Card implements Comparable{
    private ImageIcon image;
    private boolean isShown;
    private boolean bocaArriba;
    private byte id;
    private int random;

    public Card(ImageIcon imageIcon, byte id, int random) {
        this.isShown = false;
        this.image = imageIcon;
        this.id = id;
        this.random = random;
        this.bocaArriba = false;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public boolean isIsShown() {
        return isShown;
    }

    public void setIsShown(boolean isShown) {
        this.isShown = isShown;
    }
    
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public boolean isBocaArriba() {
        return bocaArriba;
    }

    public void setBocaArriba(boolean bocaArriba) {
        this.bocaArriba = bocaArriba;
    }
    
    @Override
    public int compareTo(Object o) {
        return (((Card)o).getRandom()-this.random );
    }
    
}
