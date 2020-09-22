// https://leetcode.com/problems/evaluate-division/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double> > hm = new HashMap();
        for(int i = 0; i < equations.size(); ++i) {
            String n = equations.get(i).get(0), d = equations.get(i).get(1);
            
            hm.putIfAbsent(n, new HashMap<String, Double>());
            hm.putIfAbsent(d, new HashMap<String, Double>());
            hm.get(n).put(d, values[i]);
            hm.get(d).put(n, 1/values[i]);
        }
        
        int size = queries.size(), k = 0;
        double[] res = new double[size];
        
        for(List<String> q: queries) {
            String n = q.get(0), d = q.get(1);
            if(hm.containsKey(n) && hm.containsKey(d)) res[k++] = dfs(hm, n, d, new HashSet<>(), 1);
            else res[k++] = -1;
        }
        
        return res;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> hm, String n, String d, HashSet<String> visited, double val) {
        if(n.equals(d)) return val;
        visited.add(n);
        for(Map.Entry e: hm.get(n).entrySet()) {
            if(visited.contains((String)e.getKey())) continue;
            double res = dfs(hm, (String)e.getKey(), d, visited, val * (double)e.getValue());
            if( res != -1) return res;
        }
        return -1;
    }
}


// class Solution {
//     class Edge{
//        String from;
//        String to;
//        double dist;
    
//        Edge(String src, String dest, double val){
//          from = src;
//          to   = dest;
//          dist = val;
//        }
//     }
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
//         if(equations.isEmpty() || queries.isEmpty()
//            || values == null || values.length != equations.size()
//           )
//             return new double[]{};
//         double[] result = new double[queries.size()];
//         Map<String, List<Edge>> graph = new HashMap<>();
//         for(int i = 0; i < equations.size(); i++){
//             String node1 = equations.get(i).get(0), node2 = equations.get(i).get(1);
//             graph.putIfAbsent(node1, new ArrayList<>());
//             graph.putIfAbsent(node2, new ArrayList<>());
//             graph.get(node1).add(new Edge(node1, node2, values[i]));
//             graph.get(node2).add(new Edge(node2, node1, 1 / values[i]));
//         }
        
//         int idx  = 0;
//         for(List<String> query : queries){
//             String src  = query.get(0);
//             String dest = query.get(1);
//             if(graph.containsKey(src) && graph.containsKey(dest))
//                  result[idx++] = dfs(graph, src, dest, 1, new HashSet<>());
//             else
//                 result[idx++] = -1;
//         }
//         return result;
//     }
    
//     private double dfs(Map<String, List<Edge>> graph, String src, String dest,
//                       double result, Set<String> visited){
        
//         if(src.equals(dest))
//             return result;
//         visited.add(src);
//         for(Edge edge : graph.get(src)){
//             if(visited.contains(edge.to))
//                 continue;
//             double res = dfs(graph, edge.to, dest, result * edge.dist, visited);
//             if(res != -1)
//                 return res;
//         }
//         return -1;
//     }
// }