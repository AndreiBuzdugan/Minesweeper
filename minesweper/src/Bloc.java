import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class TestPane extends JPanel {

    JLabel label;
    static Timer timer;
    static int counttime;
    static int min;

    public static int getCounttime() {
        return counttime;
    }

    public static int getMin() {
        return min;
    }

    public TestPane() {
        label = new JLabel("...");
        setLayout(new GridBagLayout());
        add(label);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counttime++;

                if ( counttime < 60 ) {
                    if(min < 1){
                        label.setText(Integer.toString(counttime));
                    }else{label.setText(Integer.toString(min)+":"+Integer.toString(counttime));}
                } else if( min < 10 ){
                    min++;
                    counttime=0;
                    label.setText(Integer.toString(min)+":"+Integer.toString(counttime));
                }
                else {
                    ((Timer) (e.getSource())).stop();
                    Functii.showGameOverMessage();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
