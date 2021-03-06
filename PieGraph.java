import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class PieGraph extends Applet {
  float pa[];
  int count;
  float max = 0;
  float sum = 0;
  public void init() {
    StringTokenizer data = new StringTokenizer(getParameter("pie"));
    count = data.countTokens();
    pa= new float[count];
    setBackground(new Color(0,0,0));
    //値の比較
    int i;
    for(i=0;i<count;i++){
      pa[i] =  Float.parseFloat(data.nextToken());
    }
    for(i=0;i<pa.length;i++){
      sum += pa[i];
      if(max<=pa[i]){
        max = pa[i];
      }
    }

  }
  public void paint(Graphics g) {
    int k;
    g.fillOval(35,-40,340,340);
    // 外の枠
    g.setColor(new Color(255,255,255));
    g.drawRect(15,15,400,250);
    //　中の両サイドの枠
    g.setColor(new Color(25,25,25));
    g.fillRect(15+1,15+1,75-1,250-2);
    g.fillRect(325+15+1,15+1,75-1,250-2);

    g.setColor(new Color(25,25,25));
    g.fillOval(15+80-1, 15+5-1, 242, 242);
    g.setColor(new Color(35,35,35));
    g.fillOval(15+80, 15+5, 240, 240);

    //一番外枠の表示

    g.setColor(new Color(255,0,0));
    g.fillArc(15+80,15+5,240,240,90,360);
    g.setColor(new Color(255,128,0));
    g.fillArc(15+80,15+5,240,240,90,315);
    g.setColor(new Color(255,255,0));
    g.fillArc(15+80,15+5,240,240,90,270);
    g.setColor(new Color(0,255,0));
    g.fillArc(15+80,15+5,240,240,90,225);
    g.setColor(new Color(0,255,255));
    g.fillArc(15+80,15+5,240,240,90,180);
    g.setColor(new Color(0,128,255));
    g.fillArc(15+80,15+5,240,240,90,135);
    g.setColor(new Color(0,0,255));
    g.fillArc(15+80,15+5,240,240,90,90);
    g.setColor(new Color(0,0,128));
    g.fillArc(15+80,15+5,240,240,90,45);

    g.setColor(new Color(255,255,255));
    g.fillOval(15+80+8,15+5+8,224,224);

    g.setColor(new Color(255,255,255));
    g.fillOval(15+80+9,15+5+9,222,222);

    // g.setColor(new Color(190,0,0));
    // g.fillArc(15+80+10,15+5+10,220,220,90,Math.round(360*pa[7]/max));

    // g.drawString(7+"",15+15+325,45+20+15*7);
    // g.drawString((int)(100*pa[7]/max)+"%",15+35+325,45+20+15*7);

    g.setColor(new Color(25,25,25));
    g.fillOval(15+100, 15+25, 200, 200);

    // for(k=6;k>=4;k--){
    //   g.setColor(new Color(25,25,25));
    //   g.fillOval(15+100+(42-7*k),15+25+(42-7*k), 200-(84-14*k), 200-(84-14*k));
    //   g.setColor(new Color(255,250-50*(2-(6-k)),0));
    //   g.fillArc(15+100+(42-7*k),15+25+(42-7*k), 200-(84-14*k), 200-(84-14*k), 90,Math.round(360*pa[k]/max));
    //   g.drawString(k+"",15+15+325,45+20+15*k);
    //   g.drawString((int)(100*pa[k]/max)+"%",15+35+325,45+20+15*k);
    // }
    g.setColor(new Color(35,35,35));
    g.fillOval(15+120, 15+45, 160, 160);
    int i;
    // for(i=3;i>=0;i--){
    //   g.setColor(new Color(35,35,35));
    //   g.fillOval(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i));
    //   g.setColor(new Color(0,250-50*(3-i),100+50*(3-i)));
    //   g.fillArc(15+120+(15-5*i),15+45+(15-5*i), 160-(30-10*i), 160-(30-10*i), 90,Math.round(360*pa[i]/max));
    //   g.drawString(i+"",15+15+325,45+20+15*i);
    //   g.drawString((int)(100*pa[i]/max)+"%",15+35+325,45+20+15*i);
    // }
    g.setColor(new Color(25,25,25));
    g.fillOval(15+140, 15+65, 120, 120);

    Graphics2D g2 = (Graphics2D)g;
    // //うしろぼやけ
    // float[] dist = {0.4f, 0.6f, 0.9f};
    // Color[] colors = {new Color(128,128,0),new Color(64,64,0),new Color(5,5,5,80)};
    //  RadialGradientPaint rgp =
    //     new RadialGradientPaint( 215, 140, 150, dist, colors);
    // g2.setPaint(rgp);
    // g.fillOval(15+80+10,15+5+10,220,220);

    for(i=count-1;i>=0;i--){
      if(105+45-(90*i/(count-1))/2<135){
        g.setColor(new Color(25,25,25));
      }else if(105+45-(90*i/(count-1))/2<155){
        g.setColor(new Color(35,35,35));
      }else{
        g.setColor(new Color(25,25,25));
      }
      g.fillOval(105+45-(90*i/(count-1))/2,30+45-(90*i/(count-1))/2,130+90*i/(count-1),130+90*i/(count-1));
      if(pa[i]*100/max > 87.5){
        g.setColor(new Color(255,0,0));
      }else if(pa[i]*100/max > 75.0){
        g.setColor(new Color(255,128,0));
      }else if(pa[i]*100/max > 62.5){
        g.setColor(new Color(255,255,0));
      }else if(pa[i]*100/max > 50.0){
        g.setColor(new Color(0,255,0));
      }else if(pa[i]*100/max > 37.5){
        g.setColor(new Color(0,255,255));
      }else if(pa[i]*100/max > 25.0){
        g.setColor(new Color(00,128,255));
      }else if(pa[i]*100/max > 12.5){
        g.setColor(new Color(0,0,255));
      }else{
        g.setColor(new Color(0,0,128));
      }
      g.fillArc(105+45-(90*i/(count-1))/2,30+45-(90*i/(count-1))/2,130+90*i/(count-1),130+90*i/(count-1),90,Math.round(360*pa[i]/max));
      g.drawString(i+"",15+15+325,45+20+15*i);
      g.drawString((int)(100*pa[i]/max)+"%",15+35+325,45+20+15*i);

    }

    //メーター
    int j;
    int arc1 = 90;
    int length;

    //文面の記述
    g.setColor(new Color(255,255,255));
    g.drawString("各要素の",15+12,30);
    g.drawString("数値一覧表",15+5,30+15);
    g.drawString("最大値に",15+12+325,30);
    g.drawString("対する比率",15+5+325,30+15);

    //内側のメーター
    for(j=0;j<count;j++){
      float percent = pa[j]*100/max;
      length = Math.round(360*pa[j]/sum);
      if(percent > 87.5){
        g.setColor(new Color(155+50+(int)(50*percent/100),0+(int)(50*percent/100),0+(int)(50*percent/100)));
      }else if(percent > 75.0){
        g.setColor(new Color(155+50+(int)(50*percent/100),28+50+(int)(50*percent/100),0+(int)(50*percent/100)));
      }else if(percent > 62.5){
        g.setColor(new Color(155+50+(int)(50*percent/100),155+50+(int)(50*percent/100),0+(int)(50*percent/100)));
      }else if(percent > 50.0){
        g.setColor(new Color(0+50+(int)(50*percent/100),155+50+(int)(50*percent/100),0+(int)(50*percent/100)));
      }else if(percent > 37.5){
        g.setColor(new Color(0+50+(int)(50*percent/100),155+50+(int)(50*percent/100),155+50+(int)(50*percent/100)));
      }else if(percent > 25.0){
        g.setColor(new Color(0+50+(int)(50*percent/100),28+50+(int)(50*percent/100),155+50+(int)(50*percent/100)));
      }else if(percent > 12.5){
        g.setColor(new Color(0+50+(int)(50*percent/100),0+(int)(50*percent/100),155+50+(int)(50*percent/100)));
      }else{
        g.setColor(new Color(0+50+(int)(50*percent/100),0+(int)(50*percent/100),28+50+(int)(50*percent/100)));
      }
      g.drawString(j+"",15+15,45+20+15*j);
      g.drawString((int)(pa[j])+"",15+35,45+20+15*j);
      g.fillArc(15+140, 15+65, 120, 120, arc1, length);
      arc1 += length;
    }

    //一番内側のコード
    g.setColor(new Color(35,35,35));
    g.fillOval(15+160, 15+85, 80, 80);
    g.setColor(new Color(25,25,25));
    g.fillOval(15+180, 15+105, 40, 40);

    //円縦線
    g.setColor(Color.WHITE);
    g.fillRect(15+200-1,15+5,3,120);
    g.setColor(Color.ORANGE);
    g.drawLine(15+200,15+5+5,15+200,120+20);
  }
}