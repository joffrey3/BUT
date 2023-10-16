import java.awt.*;
import java.util.*;
import java.lang.*;

public class Flocon {
    public Polygon ordre (int o, LinkedList<Point> liste){
        if(liste.isEmpty()){
            Point point;
            point=new Point(600,300);
            liste.push(point);
            point=new Point(450,540);
            liste.push(point);
            point=new Point(300,300);
            liste.push(point);
        }
        if(o==0){ 
            int n=liste.size();
            int[] x=new int[n];//{300,/*450,*/600};
            int[] y=new int[n];//{300,/*540,*/300};
            for(int i=0;!liste.isEmpty();i++){
                Point p=liste.pop();
                x[i]=new Double(p.getX()).intValue();
                y[i]=new Double(p.getY()).intValue();
            }
            return new Polygon(x,y,n);
        }
        Polygon p;
        LinkedList<Point> l=new LinkedList<Point>();
        Point premier=liste.pop();
        liste.push(premier);
        for(;!liste.isEmpty();){
            
            Point debut=liste.pop();
            if(!liste.isEmpty()){
                Point fin=liste.pop();
                liste.push(fin);
                int debut_x=new Double(debut.getX()).intValue();
                int debut_y=new Double(debut.getY()).intValue();
                int fin_x=new Double(fin.getX()).intValue();
                int fin_y=new Double(fin.getY()).intValue();
                Point point2,point3,point4;
                int segment=new Double(Math.sqrt(new Double((fin_x-debut_x)*(fin_x-debut_x)+(fin_y-debut_y)*(fin_y-debut_y)))).intValue();
                int img_x=debut_x
                point2=new Point((fin_x-debut_x)*1/3+debut_x,(fin_y-debut_y)*1/3+debut_y);
                point3=new Point((fin_x-debut_x)*1/2+debut_x,debut_y-debut_y*1/3*4/5);
                point4=new Point((fin_x-debut_x)*2/3+debut_x,(fin_y-debut_y)*2/3+debut_y);
                l.push(debut);
                l.push(point2);
                l.push(point3);
                l.push(point4);
                l.push(fin);
                System.out.println(l.toString());
            }
            
        }
        p=ordre(o-1,l);
        return p;
    }
}