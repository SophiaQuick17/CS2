public class Edge<N,W> implements IEdge<N,W>{

  INode<N> source;
  INode<N> destination;
  W weight;

  public Edge(INode<N> s, INode<N> d, W w){
    source = s;
    destination = d;
    weight = w;
  }

  public INode<N> getSource(){
    return source;
  }

  public INode<N> getDestination(){
    return destination;
  }

  public W getWeight(){
    return weight;
  }

  public boolean equals(Object o){
    Edge<N,W> edge = (Edge<N,W>) o;
    if (this.getSource() == edge.getSource() && this.getDestination() == edge.getDestination()){
      return true;
    }
    else{
      return false;
    }
  }

}
