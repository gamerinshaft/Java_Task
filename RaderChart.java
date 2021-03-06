import java.applet.Applet;
import java.awt.*;
import java.util.*;
public class RaderChart extends Applet {
  float pa[];
  float pa_second[];
  float max = 0;
  int maxGage;
  float sum = 0;
  float sum_second = 0;
  float percent[];
  float percent_second[];
  int count;
  public void init() {
    StringTokenizer data1 = new StringTokenizer(getParameter("rader1"));
    StringTokenizer data2 = new StringTokenizer(getParameter("rader2"));
    count = data1.countTokens();
    pa =new float[count];
    pa_second =new float[count];

    percent = new float[pa.length];
    percent_second = new float[pa.length];

    setBackground(new Color(0,0,0));
    //値の比較
    int i;
    for(i=0;i<count;i++){
      pa[i] =  Float.parseFloat(data1.nextToken());
      pa_second[i] =  Float.parseFloat(data2.nextToken());
    }
    for(i=0;i<pa.length;i++){
        sum += pa[i];
        sum_second += pa_second[i];
        if(max<=pa[i]){
          max = pa[i];
        }
        if(max<=pa_second[i]){
          max = pa_second[i];
        }
    }
    maxGage = (int)(Math.ceil(max/100.0)*100);
    for(i=0;i<pa.length;i++){
      percent[i] = pa[i]*100/maxGage;
      percent_second[i] = pa_second[i]*100/maxGage;
    }

  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    //うしろぼやけ
    float[] dist = {0.0f, 0.6f, 0.9f};
    Color[] colors = {new Color(0,128,0),new Color(0,64,0),new Color(5,5,5,80)};
     RadialGradientPaint rgp =
        new RadialGradientPaint( 215, 140, 150, dist, colors);
    g2.setPaint(rgp);
    g.fillOval(35,-40,340,340);
    // 外の枠
    g.setColor(new Color(255,255,255));
    g.drawRect(15,15,400,250);
    //　中の両サイドの枠
    g.setColor(new Color(25,25,25));
    g.fillRect(15+1,15+1,75-1,250-2);
    g.fillRect(325+15+1,15+1,75-1,250-2);
    //文面の記述
    g.setColor(new Color(255,255,255));
    g.drawString("入力した",15+12,30);
    g.drawString("値の一覧表",15+5,30+15);
    g.drawString("各要素の",15+12+325,30);
    g.drawString("標準的な値",15+5+325,30+15);
    // レーダー枠
    double rad = (360/pa.length)*(Math.PI/180);
    int i;
    for(i=0;i<pa.length;i++){
      g.setColor(new Color(255,255,255));
      //両サイドの値
      g.drawString(i+1+"",15+15+325,45+20+15*i);
      g.drawString((int)(pa_second[i])+"",15+45+325,45+20+15*i);
      g.drawString(i+1+"",15+15,45+20+15*i);
      g.drawString((int)(pa[i])+"",15+35,45+20+15*i);

      int x1[] = new int[4];
      int y1[] = new int[4];

      //円の周りの値
      g.setColor(new Color(255,255,255));
      int z_x = (int)(-(110*Math.cos(90*Math.PI/180+rad*i)));
      int z_y = (int)(110*Math.sin(90*Math.PI/180+rad*i));
      g.drawString(i+1+"",208+z_x,145-z_y);


      //各値の座標
      int point_x1 = (int)(-(percent[i]*Math.cos(90*Math.PI/180+rad*i)));
      int point_y1 = (int)(percent[i]*Math.sin(90*Math.PI/180+rad*i));
      int point_x1_second = (int)(-(percent_second[i]*Math.cos(90*Math.PI/180+rad*i)));
      int point_y1_second = (int)(percent_second[i]*Math.sin(90*Math.PI/180+rad*i));



      g.setColor(new Color(255,255,255));
      int k;
      for(k=0;k<4;k++){
        x1[k]= (int)(-((100-25*k)*Math.cos(90*Math.PI/180+rad*i)));
        y1[k]= (int)((100-25*k)*Math.sin(90*Math.PI/180+rad*i));
      }
      //棒線
      g.setColor(new Color(255,255,255));
      g.drawLine(215,140,215+x1[0],140-y1[0]);



      //レーダーの点と点とをつなぐ線
      if(i+1<pa.length){
        int x2[] = new int[4];
        int y2[] = new int[4];
        int point_x2 = (int)(-(percent[i+1]*Math.cos(90*Math.PI/180+rad*(i+1))));
        int point_y2 = (int)(percent[i+1]*Math.sin(90*Math.PI/180+rad*(i+1)));
        int point_x2_second = (int)(-(percent_second[i+1]*Math.cos(90*Math.PI/180+rad*(i+1))));
        int point_y2_second = (int)(percent_second[i+1]*Math.sin(90*Math.PI/180+rad*(i+1)));
        int j;
        //値同士の線
        g.setColor(new Color(0,150,50));
        g.drawLine(215+point_x1,140-point_y1,215+point_x2,140-point_y2);
        g.setColor(new Color(250,250,0));
        g.drawLine(215+point_x1_second,140-point_y1_second,215+point_x2_second,140-point_y2_second);

        g.setColor(new Color(255,255,255));
        for(j=0;j<4;j++){
          x2[j]= (int)(-((100-25*j)*Math.cos(90*Math.PI/180+rad*(i+1))));
          y2[j]= (int)((100-25*j)*Math.sin(90*Math.PI/180+rad*(i+1)));
          g.drawLine(215+x2[j],140-y2[j],215+x1[j],140-y1[j]);
        }
        int[] xpoints = {215+point_x1,215+point_x2,215};
        int[] ypoints = {140-point_y1,140-point_y2,140};
        int[] xpoints_second = {215+point_x1_second,215+point_x2_second,215};
        int[] ypoints_second = {140-point_y1_second,140-point_y2_second,140};
        int npoints = xpoints.length;
        Polygon polygon = new Polygon(xpoints, ypoints, npoints);
        Polygon polygon_second = new Polygon(xpoints_second, ypoints_second, npoints);
        GradientPaint gp = new GradientPaint(215+(point_x1+point_x2)/2,140-(point_y1+point_y2)/2,new Color(0,120,0,220),215,140,new Color(220,220,0,200));
        g2.setPaint(gp);
        g2.fill(polygon);
        GradientPaint gp2 = new GradientPaint(215+(point_x1+point_x2)/2,140-(point_y1+point_y2)/2,new Color(220,220,0,250),215,140,new Color(250,250,0,100));
        g2.setPaint(gp2);
        g2.fill(polygon_second);
      }else{
        g.setColor(new Color(255,255,255));
        for(k=0;k<4;k++){
          g.drawLine(215+point_x1,140-point_y1,215+(int)(-(percent[0]*Math.cos(90*Math.PI/180+rad*0))),140-(int)(percent[0]*Math.sin(90*Math.PI/180+rad*0)));
          g.drawLine(215,40+25*k,215+x1[k],140-y1[k]);
        }
        int[] xpoints = {215+point_x1,215+(int)(-(percent[0]*Math.cos(90*Math.PI/180+rad*0))),215};
        int[] ypoints = {140-point_y1,140-(int)(percent[0]*Math.sin(90*Math.PI/180+rad*0)),140};
        int[] xpoints_second = {215+point_x1_second,215+(int)(-(percent_second[0]*Math.cos(90*Math.PI/180+rad*0))),215};
        int[] ypoints_second = {140-point_y1_second,140-(int)(percent_second[0]*Math.sin(90*Math.PI/180+rad*0)),140};
        int npoints = xpoints.length;
        Polygon polygon = new Polygon(xpoints, ypoints, npoints);
        Polygon polygon_second = new Polygon(xpoints_second, ypoints_second, npoints);
        GradientPaint gp = new GradientPaint(215+(point_x1+(int)(-(percent_second[0]*Math.cos(90*Math.PI/180+rad*0))))/2,140-(point_y1+(int)(percent[0]*Math.sin(90*Math.PI/180+rad*0)))/2,new Color(0,120,0,220),215,140,new Color(220,220,0,200));
        g2.setPaint(gp);
        g2.fill(polygon);
        GradientPaint gp2 = new GradientPaint(215+(point_x1+(int)(-(percent_second[0]*Math.cos(90*Math.PI/180+rad*0))))/2,140-(point_y1+(int)(percent[0]*Math.sin(90*Math.PI/180+rad*0)))/2,new Color(220,220,0,250),215,140,new Color(250,250,0,100));
        g2.setPaint(gp2);
        g2.fill(polygon_second);
      }
    }

  }
}