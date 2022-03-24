package montains_and_rain;

public class Coordinates extends PlayGround{

    private int row;
    private int column;
    private int height;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
        this.height = getBASE_HEIGHT();
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setHeightPlus(int height) {
        this.height = this.height+height;
    }

}
