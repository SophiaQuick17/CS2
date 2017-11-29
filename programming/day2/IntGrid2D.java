public class IntGrid2D implements IIntGrid2D{

  int upperx;
  int uppery;
  int lowerx;
  int lowery;
  char val;
  IIntPoint2D point;
  char[][] board;

  public IntGrid2D (int upper_x, int upper_y, int lower_x, int lower_y, char v){
    upperx = upper_x;
    uppery = upper_y;
    lowerx = lower_x;
    lowery = lower_y;
    val = v;
    int width = 1 + Math.abs(lowerx - upperx);
    int height = 1 + Math.abs(lowery - uppery);
    board = new char[width][height];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        board[i][j] = ' ';
      }
    }
  }

  public int getUpperX(){
    return upperx;
  }

  public int getLowerY(){
    return lowery;
  }

  public void setPoint(IIntPoint2D p, char v){
    board[p.getX()+ Math.abs(this.getUpperX())][p.getY()+ Math.abs(this.getLowerY())] = v;
  }

  public char getPoint(IIntPoint2D p){
    return board[p.getX()+1][p.getY()+1];
  }

  public IIntPoint2D getUpperLeftCorner(){
    IntPoint2D upperPoint = new IntPoint2D(upperx, uppery);
    return upperPoint;
  }

  public IIntPoint2D getLowerRightCorner(){
    IntPoint2D lowerPoint = new IntPoint2D(lowerx, lowery);
    return lowerPoint;
  }

}
