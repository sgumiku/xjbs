package util;

import model.Car;
import model.Node;
import model.Road;

import java.util.*;

public class CalUtil {
    private int maxn = 0x3f3f3f;
    public CalUtil() {
    }

    public int getSpeed(int carSpeed, int roadSpeed){
        return carSpeed >= roadSpeed? roadSpeed : carSpeed;
    }

    /*
     * road：start end speed len
     * car: speed start end
     * cost: len/speed
     * len 节点数量+1
     * */
    /*public List<Integer> getMinPath(Road[][] roadMap, Car car, int len) {
        int[] path = new int[len];
        float[] dis = new float[len];
        boolean[] vis = new boolean[len];
        float[][] map = new float[len][len];
        int start = car.getStart();
        Queue<Integer> queue = new PriorityQueue<>();

        //map初始化
        for(int i=1; i<len; i++)
        {
            for(int j=1; j<len; j++)
                map[i][j] = maxn;
        }
        for(int i=1; i<len; i++)
        {
            for(int j=1; j<len; j++)
            {
                if(roadMap[i][j] != null)
                {
                    int speed = getSpeed(car.getSpeed(),roadMap[i][j].getSpped());
                    map[i][j] = roadMap[i][j].getLen()/speed;
                }
            }

        }
        //路径初始化
        for(int i=1; i<len; i++)
        {
            dis[i] = maxn;
            path[i] = start;
            // System.out.println(dis[i]);
        }
        dis[start] = 0;
        //vis[start] = true;

        for(int i=1; i<len; i++)
        {

            float minPath = maxn;
            int point = i;
            for(int j=1; j<len; j++)
            {
                if(!vis[j] && minPath > dis[j])
                {
                    minPath = dis[j];
                    point = j;
                }
            }

            vis[point] = true;

            for(int j=0; j<len; j++)
            {
                if(!vis[j] && dis[j] > dis[point] + map[point][j])
                {
                    dis[j] = map[point][j] + dis[point];
                    path[j] = point;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=car.getEnd(); path[i] != i;)
        {
            res.add(roadMap[i][path[i]].getId());
            //System.out.println(roadMap[i][path[i]].getId());
            i = path[i];
        }
        res.add(car.getTime());
        res.add(car.getId());
        Collections.reverse(res);
        return res;
    }*/

    public List<Integer> getMinPath(Road[][] roadMap, Car car, int len) {
        int[] path = new int[len];
        double[] dis = new double[len];
        boolean[] vis = new boolean[len];
        double[][] map = new double[len][len];
        int start = car.getStart();

        Comparator<Node> queueComparator = new NodeComparator();
        Queue<Node> queue = new PriorityQueue<>(queueComparator);

        //map初始化
        for(int i=1; i<len; i++)
        {
            for(int j=1; j<len; j++)
                map[i][j] = maxn;
        }
        for(int i=1; i<len; i++)
        {
            for(int j=1; j<len; j++)
            {
                if(roadMap[i][j] != null)
                {
                    int speed = getSpeed(car.getSpeed(),roadMap[i][j].getSpped());
                    map[i][j] = roadMap[i][j].getLen()/speed;
                }
            }

        }
        //路径初始化
        for(int i=1; i<len; i++)
        {
            dis[i] = maxn;
            path[i] = start;
            // System.out.println(dis[i]);
        }
        dis[start] = 0;
        //vis[start] = true;
        queue.offer(new Node(start,dis[start]));
        while(!queue.isEmpty())
        {
            Node top = queue.peek();
            queue.poll();
            vis[top.getIndex()] = true;
            for(int i=0; i<len; i++)
            {
                if(!vis[i] && dis[i] > dis[top.getIndex()] + map[top.getIndex()][i])
                {
                    dis[i] = map[top.getIndex()][i] + dis[top.getIndex()];
                    queue.offer(new Node(i,dis[i]));
                    path[i] = top.getIndex();
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=car.getEnd(); path[i] != i;)
        {
            res.add(roadMap[i][path[i]].getId());
            //System.out.println(roadMap[i][path[i]].getId());
            i = path[i];
        }
        res.add(car.getTime());
        res.add(car.getId());
        Collections.reverse(res);
        return res;
    }


    public int[] miniumTree(int[][] map, int[] d) {
        int len = map[0].length;
        boolean[] vis = new boolean[len];
        for(int i=0; i<len; i++)
        {
            d[i] = map[0][i];
        }
        vis[0] = true;
        for(int i=0; i<len; i++)
        {
            int minPath = maxn;
            int point = i;
            for(int j=0; j<len; j++)
            {
                if(!vis[j] && minPath > d[j])
                {
                    point = j;
                    minPath = d[j];
                }
            }

            vis[point] = true;
            for(int j=0; j<len; j++)
            {
                if(!vis[j] && d[j] > map[j][point])
                    d[j] = map[j][point];
            }

        }
        return d;
    }
}


class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node x, Node y) {
        return x.getCost() <= y.getCost() ? -1 : 1;
    }
}