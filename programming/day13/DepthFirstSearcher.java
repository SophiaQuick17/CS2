public class DepthFirstSearcher<N,W> implements ISearcher<N,W>{

  IGraph<N,W> graph;
  int index = 0;
  IList<INode<N>> path = new DoubleLinkList<INode<N>>();

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
    graph = g;
    INode<N> cn = s;
    Object[] os = graph.getEdgesFrom(s);
    IEdge<N,W>[] arrayEdgeFrom = new IEdge[os.length];
    for(int i=0; i<os.length; i++) {
      arrayEdgeFrom[i]=(IEdge<N,W>)os[i];
    }
    arrayEdgeFrom = graph.getEdgesFrom(s);
    for (int i = 0; i < arrayEdgeFrom.length; i++){
      INode<N> currentNode = arrayEdgeFrom[i].getDestination();
      cn = currentNode;
      if (currentNode.equals(e)){
        return true;
      }
    }
    pathExists(graph, cn, e);
    return false;
  }

  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
    graph = g;
    if (pathExists(g, s, e) == false){
      return null;
    }
    path.append(s);
    IEdge<N,W>[] arrayEdgeFrom = g.getEdgesFrom(s);
    for (int i = 0; i < arrayEdgeFrom.length; i++){
      INode<N> currentNode = arrayEdgeFrom[i].getDestination();
      if (currentNode.equals(e)){
        return path;
      }
      else{
        getPath(graph, currentNode, e);
      }
    }
    return path;
  }

  public static void main(String[] args) {
    DepthFirstSearcher<Integer,Integer> DFS = new DepthFirstSearcher();
    IGraph<Integer,Integer> graph = new Graph();
    INode<Integer> node1;
    INode<Integer> node2;
    node1 = graph.addNode(15);
    node2 = graph.addNode(1);
    graph.addEdge(node1, node2, 10);
    IList<INode<Integer>> list = DFS.getPath(graph, node1, node2);
  }

}
