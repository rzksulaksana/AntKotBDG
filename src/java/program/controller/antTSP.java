package program.controller;

import static java.lang.Math.pow;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import program.model.SemutModel;
import java.util.Random;

public class antTSP{
     // Algorithm parameters:
    // original amount of trail
    private double tij = 0.01;
    // trail preference
    private double alpha = 1;
    // greedy preference
    private double beta = 1;
    // trail evaporation coefficient
    private double evaporation = 0.5;
    // new trail deposit coefficient;
    private double Q = 1;
    
    // Reasonable number of iterations
    // - results typically settle down by 500
    private int maxIterations = 2;

    public int n = 0; // # towns
    public int tmp = 0;
    public int m = 5; // # ants
    private double graph[][] = null;
    private double trails[][] = null;
    private Semut agent[] = null;
    private Random rand = new Random();
    private double probs[] = null;

    private int currentIndex = 0;

    public int[] bestTour;
    public double bestTourLength;
    
/*Semut*/    
    private class Semut {
        public int tour[] = new int[graph.length];
        // Maintain visited list for towns, much faster
        // than checking if in tour so far.
        public boolean visited[] = new boolean[graph.length];
        
        public boolean status =false;
        
        public void visitTown(int town) {
            tour[currentIndex + 1] = town;
            visited[town] = true;
        }

        public boolean visited(int i) {
            return visited[i];
        }

        public double tourLength() {
            List <Integer> journey = new ArrayList<>();
            int iter=0;
            double length=0;
            while(iter<tour.length){
                if(tour[iter]!=0){
                    journey.add(tour[iter]);
                }
                iter++;
            }
            for (int i =0; i < journey.size(); i++) {
                if(i<journey.size()-1){
                    if(graph[journey.get(i)][journey.get(i+1)]==0){
                        break;
                    }else{
                        length += 1/graph[journey.get(i)][journey.get(i+1)];
                    }
                }
            }
            
        return length;
    }

        public void clear() {
            for (int i = 0; i < n; i++)
                visited[i] = false;
        }
        
        public void clear_tour(){
            for(int i = 0 ;i<n;i++){
                tour[i]=0;
                status = false;
            }
        }
        
        public boolean Cek_Status(){
            return status;
        }
                    
        public boolean Sampai(){
            status = true;
            return status;
        }    
    }

/*graph*/
    public void graf(){
        SemutModel jarak  =  new SemutModel();
        List<SemutModel> temp = new ArrayList();
        temp = jarak.AmbilJarak();
        int x;
        
        
        try {
            tmp = jarak.jml_jalan();
        } catch (SQLException ex) {
            Logger.getLogger(antcol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        if (graph == null){
            graph = new double[temp.size()][temp.size()];
        }
        
        for(int i = 1;i<=tmp;i++){
            for(int j = 1;j <=tmp;j++){
               graph[i][j]=0;  
            }
        }
        x=0;
        
        while(x<temp.size()){
            graph[temp.get(x).getJalan_asal()][temp.get(x).getJalan_tujuan()]=1/temp.get(x).getJarak();
            x++;
        }
                
            
            /*System.out.print("  ");
            for (int i = 1; i <= tmp; i++)
                System.out.print(i + " ");
            System.out.println();
 
            for (int i = 1; i <= tmp; i++) 
            {
                System.out.print(i + " ");
                for (int j = 1; j <= tmp; j++) 
                    System.out.print(graph[i][j] + " ");
                System.out.println();
            }
            */
        n= graph.length;
        // all memory allocations done here
        trails = new double[n][n];
        probs = new double[n];
        agent = new Semut[m];
        for (int j = 0; j < m; j++){
            agent[j] = new Semut();
        }
    }
    
    public static double pow(final double a, final double b) {
        final int x = (int) (Double.doubleToLongBits(a) >> 32);
        final int y = (int) (b * (x - 1072632447) + 1072632447);
        return Double.longBitsToDouble(((long) y) << 32);
    }
    
    private void probTo(Semut agent,int index){
        
        int i = agent.tour[index];
        
        double denom = 0.0;
        
        for (int l = 0; l < n; l++){
            if (!agent.visited(l)){
                denom += pow(trails[i][l], alpha) * pow(graph[i][l], beta);
            }
        }
        for (int j = 0; j < n; j++) {
            if (agent.visited(j)) {
                probs[j] = 0.0;
            }else{
                double numerator = pow(trails[i][j], alpha)* pow(graph[i][j], beta);
                if(denom !=0){
                    probs[j] = numerator / denom;
                }else{
                    probs[j] = 0.0;
                }
            }
        }
    }
    
    private int selectNextTown(Semut agent,int ke) {
        int kota=0;
        List<Integer> tamp = new ArrayList();
        
        double r = rand.nextDouble();
        
        int index = 0;
        int a=0;
        int ctr=0;
        if(agent.tour[currentIndex]==0){
            ctr = currentIndex;
            while(agent.tour[ctr]==0){
                a++;
                ctr--;
            }
            index = currentIndex - a;
            probTo(agent,index);
        }else{
            probTo(agent,currentIndex);
        }
        
        for (int i = 0; i < n; i++){
            if(probs[i]!=0){
                if(probs[i]>r){
                    tamp.add(i);
                }
            }
        }
       
        if(!tamp.isEmpty()){
           if(tamp.size()>1){
                for(int i=0;i<tamp.size();i++){
                    if(i<tamp.size()-1){
                        if(probs[tamp.get(i)]<probs[tamp.get(i+1)]){
                            if(!agent.visited(tamp.get(i))){
                                kota = tamp.get(i);
                            }
                        }
                    }
                }
            }
            else if(tamp.size()==1){
                if(agent.visited(tamp.get(0))){
                    kota = 0;
                }else{
                    kota = tamp.get(0);
                }
            }
        }
        if(kota == ke){
            agent.Sampai();
        }
        return kota;
    }
    
    private void updateTrails() {
        // evaporation
        int i;
        for ( i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                trails[i][j] *= evaporation;

        // each ants contribution
        for (Semut a : agent) {
            double contribution = Q / a.tourLength();
            for (i = 0; i < n - 1; i++) {
                trails[a.tour[i]][a.tour[i + 1]] += contribution;
            }
            trails[a.tour[n - 1]][a.tour[0]] += contribution;
        }
    }

    // Choose the next town for all ants
    private void moveAnts(int ke) {
        while (currentIndex < n-1) {
            for (Semut a : agent){
                if(a.Cek_Status()!=true){
                    a.visitTown(selectNextTown(a,ke));
                }
            }
            currentIndex++;
        }
    }

    // m ants with random start city
    private void setupAnts(int dari) {
        currentIndex = -1;
        for (int i = 0; i < m; i++) {
            agent[i].clear();
            agent[i].clear_tour();
            agent[i].visitTown(dari);
        }
        currentIndex++;
    }

    private void updateBest() {
             /*if (bestTour == null) {
                for(int i=0;i<m;i++){
                    if(agent[i].Cek_Status()==true){
                        bestTour = agent[i].tour;
                        bestTourLength = agent[i].tourLength();
                        break;
                    }else{
                        break;
                    }
                }
            }else{   */
                for (Semut a : agent) {               
                    if(a.Cek_Status()==true){
                        if (bestTour == null) {
                            bestTourLength = a.tourLength();
                            bestTour = a.tour.clone();
                        }else{
                            if(a.tourLength() < bestTourLength) {
                                bestTourLength = a.tourLength();
                                bestTour = a.tour.clone();
                            }
                        }
                    }
                }
    }

    public static String tourToString(int tour[]) {
        String t = new String();
        for (int i : tour){
            t = t + " " + i;
        }
        return t;
    }

    public int[] solve(int asal,int tujuan) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                trails[i][j] = tij;
            }
        }

        int iteration = 0;
        while (iteration < maxIterations) {
            setupAnts(asal);
            moveAnts(tujuan);
            updateTrails();
            updateBest();
            
            for(int a =0 ;a<m;a++){
                System.out.println("agent"+Arrays.toString(agent[a].tour));
                System.out.println("status"+agent[a].status);
            }
            iteration++;
        }
        
        /*
        // Subtract n because we added one to edges on load
       //System.out.println("Best tour length: " + (bestTourLength));
       //System.out.println("Best tour:" + tourToString(bestTour));*/
        System.out.println("Best tour:" + tourToString(bestTour));
        System.out.println("Best tour length: " + (bestTourLength));
        return bestTour;
    }
}
