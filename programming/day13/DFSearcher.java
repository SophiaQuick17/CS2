public class DFSearcher<N,W> {

  boolean nodesExist;
  boolean pathExists;

    public boolean pathExistsDF(IGraph<N,W> g, INode<N> s, INode<N> e){
      DepthFirst d = new DepthFirst(g, s, e);

      nodesExist = d.Exist();

       if(nodesExist == true){
         pathExists = d.Search(s,e);
       }

       else{
         pathExists = false;
       }
       return pathExists;
    }


    public IList<INode<N>> getPathDF(IGraph<N,W> g, INode<N> s, INode<N> e){
      DepthFirst df = new DepthFirst(g, s, e);
      BreadthFirst b = new BreadthFirst(g, s, e);
      IList<INode<N>> depth_path = new ArrayList<INode<N>>();
      IList<INode<N>> breadth_path = new ArrayList<INode<N>>();

      nodesExist = df.Exist();
      if(nodesExist == true){
        pathExists = df.Search(s,e);
      }
      else{
        pathExists = false;
      }

      if(pathExists == false){
        breadth_path = null;
        depth_path = null;
      }
      else{
        if(s.getValue().equals(e.getValue())){
        }
        else{
          b.Search(s,e);
          breadth_path = b.Path();
          depth_path = df.Path();
        }
      }
      return depth_path;
    }
}
