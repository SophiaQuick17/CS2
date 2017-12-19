public class DepthFirst<N,W>{

  IGraph<N,W> graph;
  INode<N> start_node;
  INode<N> end_node;
  boolean nodesExist = false;
  boolean pathExists = false;
  Stack<INode> path  = new Stack<INode>();
  DoubleLinkList<INode> checked  = new DoubleLinkList<INode>();

  public DepthFirst(IGraph<N,W> g, INode<N> s, INode<N> e){
    graph = g;
    start_node = s;
    end_node = e;
  }

  public boolean Exist(){
    INode<N>[] nodes_arr = graph.getNodeSet();
    boolean startFound = false;
    boolean endFound = false;
    DoubleLinkList<INode> nodes = new DoubleLinkList<INode>();
    INode<N> current;
    int i = 0;

    for(int j = 0; j < nodes_arr.length; j++){
      nodes.append(nodes_arr[j]);
    }

    if(nodes.size() == 0){
      startFound = false;
      endFound = false;
    }
    else{
      while(i < nodes.size()){
        current = nodes.fetch(i);
        if(current.equals(start_node)){
          startFound = true;
          i++;
        }
        else if(current.equals(end_node)){
          endFound = true;
          i++;
        }
        else{
          i++;
        }
      }
    }
    if(startFound == true && endFound == true){
      nodesExist = true;
    }
    else{
      nodesExist = false;
    }
    return nodesExist;
  }

  public boolean Search(INode<N> start, INode<N> end){
    INode<N>[] neighbors_arr = graph.getNeighbors(start);
    DoubleLinkList<INode> neighbors = new DoubleLinkList();
    int n = 0;
    path.push(start);
    checked.append(start);

    for(int a = 0; a < neighbors_arr.length; a++){
      neighbors.append(neighbors_arr[a]);
    }

    if(neighbors.size() > 0 ){
      for(int i = 0; i < neighbors_arr.length; i++){
        if(neighbors_arr[i].equals(end)){
          path.push(end);
          pathExists = true;
          break;
        }
      }
      if(pathExists == false){
        for(int j = 0; j < checked.size() - 1; j++){
          for(int k = 0; k < neighbors.size(); k++){
            if(checked.fetch(j).equals(neighbors.fetch(k))){
              neighbors.remove(k);
            }
            else{
            }
          }
        }
        while(n < neighbors.size()){
          Search(neighbors.fetch(n), end);
          if(pathExists == true){
            break;
          }
          else{
            n++;
          }
        }
        if(pathExists == false && n >= neighbors.size()){
          path.pop();
        }
      }
    }
    else{
      path.pop();
      pathExists = false;
    }
    return pathExists;
  }

}
