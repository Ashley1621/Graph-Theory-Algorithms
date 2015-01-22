/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import graphalgorithms.GraphTools;
import GraphPackage.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Student
 */
public abstract class GraphPanel extends javax.swing.JPanel {

    
    /**
     * Creates new form GraphPanel
     */
    public GraphPanel() {
        vertexList = new LinkedList();
        edgeList = new LinkedList();
        interlacement = new LinkedList();
        title = new String();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    //******************** MY CODE **********************
    
    private final int DEFAULT_WIDTH = 600;
    private final int DEFAULT_HEIGHT = 600;
    
    private LinkedList<DrawableVertex> vertexList;
    private LinkedList<DrawableEdge> edgeList;
    private LinkedList<InterlacementVertex> interlacement;
    private String title;
    
        
    
    public Dimension getPreferredSize() {return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }


     public void paintComponent(Graphics g)
     {

         super.paintComponent(g);
           
         for(int i = 0; i<edgeList.size(); i++){
             DrawableEdge e = edgeList.get(i);
             g.setColor(e.getColor());
             g.drawLine(e.getX1()+Vertex.VERTEX_RADIUS, e.getY1()+Vertex.VERTEX_RADIUS, e.getX2() + Vertex.VERTEX_RADIUS, e.getY2() + Vertex.VERTEX_RADIUS);             
         }
         
         for(int i = 0; i<vertexList.size(); i++){
                DrawableVertex v = vertexList.get(i);
                g.setColor(v.getColor());
                g.fillOval(v.getX(), v.getY(), 2*Vertex.VERTEX_RADIUS, 2*Vertex.VERTEX_RADIUS);    
         }
         
         if(interlacement.size() > 0){
             g.setColor(Color.black);
             g.drawString("Interlacement Graph", 475, 25);
         }
         for(int i = 0; i < interlacement.size(); i++){
             InterlacementVertex v = interlacement.get(i);
             g.setColor(v.getColor());
             g.fillRect(v.getX(), v.getY(), InterlacementVertex.INTERLACEMENT_SIZE, InterlacementVertex.INTERLACEMENT_SIZE);
             g.setColor(Color.white);
             g.drawString(v.getLabel(), (int) (v.getX() + 0.25*InterlacementVertex.INTERLACEMENT_SIZE), (int) (v.getY() + 0.75*InterlacementVertex.INTERLACEMENT_SIZE) );
         }
         
         g.setColor(Color.black);
         g.drawString(title, 175, 50);
          

     }
     
     public void addVertex(Vertex v){
         vertexList.add(new DrawableVertex(v));
     }   
     public void addVertex(Vertex v, Color col){
         vertexList.add(new DrawableVertex(v,col));
     }
     public void addInterlacementVertex(Vertex v, Color col){
         interlacement.add(new InterlacementVertex(v,col));
     }
     public void addEdge(Edge e){
         edgeList.add(new DrawableEdge(e));
     }
     public void addEdge(Edge e, Color col){
         edgeList.add(new DrawableEdge(e,col));
     }
     
     public void setString(String s){
         title = s;
     }
     public void clearString(){
         title = new String();
     }
     
     public void clearBuffers(){
        vertexList = new LinkedList();
        edgeList = new LinkedList();
        interlacement = new LinkedList();
     }
     
     abstract public void finish();

    @Override
    public String toString() {
        return "GraphPanel"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
     

}
