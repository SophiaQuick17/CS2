//Sophia Quick
//CS2
// Written 11/27/17

public class IntPoint2D implements IIntPoint2D{

  int x;
  int y;

  public IntPoint2D(int value_x, int value_y){
    x = value_x;
    y = value_y;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public int manhattanDistance(IIntPoint2D o){
    return Math.abs(this.getX() - o.getX()) + Math.abs(this.getY() - o.getY());
  }

  public double distance(IIntPoint2D o){
    return Math.sqrt(Math.pow((this.getX() - o.getX()),2) + Math.pow((this.getY() - o.getY()),2));
  }

  public String toString(){
    return "(" + getX() + "," + getY() + ")";
  }

  public boolean equals(IIntPoint2D o){
    if (this.getX() == o.getX()){
      if (this.getY() == o.getY()){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }

  public int hashcode(){
    return (getX() << 16) + getY();
  }

}
