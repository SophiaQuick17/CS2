public class Graph<N, W> implements IGraph<N, W>{

  DoubleLinkList<INode> nodes = new DoubleLinkList<INode>();
  DoubleLinkList<IEdge> edges = new DoubleLinkList<IEdge>();
  DoubleLinkList<IEdge> edgesFrom = new DoubleLinkList<IEdge>();
  int edgesFromSize;
  IEdge<N,W>[] arrayEdgeFrom;

  public INode<N>[] getNodeSet(){
    INode<N>[] nodeSet = (INode<N>[]) new Object[nodes.size()];
    for (int i = 0; i < nodes.size(); i++){
      nodeSet[i] = nodes.fetch(i);
    }
    return nodeSet;
  }

  public DoubleLinkList<IEdge> getDLLEdge(){
    return edges;
  }

  public Boolean isValueThere(INode<N> n, DoubleLinkList<INode> list){
    for (int i = 0; i < list.size(); i++){
      //compare the values of the nodes
      if (n.getValue().equals(list.fetch(i).getValue())){
        return true;
      }
    }
    return false;
  }

  public INode<N>[] getNeighbors(INode<N> n){
    DoubleLinkList<INode> neighbors = new DoubleLinkList<INode>();
    for (int i = 0; i < edges.size(); i++){
      if (edges.fetch(i).getSource() == n){
        if (isValueThere(edges.fetch(i).getDestination(), neighbors) == false){
          neighbors.append(edges.fetch(i).getDestination());
        }
      }
      if (edges.fetch(i).getDestination() == n){
        if (isValueThere(edges.fetch(i).getSource(), neighbors) == false){
          neighbors.append(edges.fetch(i).getSource());
        }
      }
    }
    INode<N>[] neighborSet = (INode<N>[]) new Object[neighbors.size()];
    for (int i = 0; i < neighbors.size(); i++){
      neighborSet[i] = neighbors.fetch(i);
    }
    return neighborSet;
  }

  public INode<N> addNode(N v){
    INode<N> node = new Node<N>(v);
    if (isValueThere(node, nodes) == false){
      nodes.append(node);
    }
    return node;
  }

  public IEdge<N,W>[] getEdgeSet(){
    IEdge<N,W>[] edgeSet = (IEdge<N,W>[]) new Edge[edges.size()];
    for (int i = 0; i < edges.size(); i++){
      edgeSet[i] = edges.fetch(i);
    }
    return edgeSet;
  }

  public IEdge<N,W>[] getEdgesFrom(INode<N> n){
    for (int i = 0; i < edges.size(); i++){
      if (edges.fetch(i).getSource() == n){
        edgesFrom.append(edges.fetch(i));
      }
    }
    edgesFromSize = edgesFrom.size();
    arrayEdgeFrom = (IEdge<N,W>[]) new Object[edgesFrom.size()];
    for (int i = 0; i < edgesFrom.size(); i++){
      arrayEdgeFrom[i] = edgesFrom.fetch(i);
    }
    return arrayEdgeFrom;
  }

  public IEdge<N,W>[] getEdgesTo(INode<N> n){
    IList<IEdge> edgesTo = new DoubleLinkList<IEdge>();
    for (int i = 0; i < edges.size(); i++){
      if (edges.fetch(i).getDestination() == n){
        edgesTo.append(edges.fetch(i));
      }
    }
    IEdge<N,W>[] arrayEdgeTo = (IEdge<N,W>[]) new Object[edgesTo.size()];
    for (int i = 0; i < edgesTo.size(); i++){
      arrayEdgeTo[i] = edgesTo.fetch(i);
    }
    return arrayEdgeTo;
  }

  public boolean doesEdgeExist(IEdge<N,W> e, DoubleLinkList<IEdge> list){
    for (int i = 0; i < edges.size(); i++){
      if (e.equals(edges.fetch(i)) == true){
        return true;
      }
    }
    return false;
  }

  public void addEdge(INode<N> s, INode<N> d, W w){
    IEdge<N,W> edge = new Edge<N,W>(s,d,w);
    if (doesEdgeExist(edge, edges) == false){
      edges.append(edge);
    }
  }

}
