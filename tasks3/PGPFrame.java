import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;


/*
 3.5 PGP-Buttons
 In der Klasse PGPFrame wird ein Fenster erzeugt, in dem mittels der Methode addNewButton(PGPButton) neue Buttons vom Typ PGPButton auf dem Frame erzeugt werden können. Diese PGPButtons definieren mittels der click()-Methode die jeweilige Aktion, die nach dem Klicken des Buttons durchgeführt werden soll. 

In der jetzigen Implementierung von PGPButton wird lediglich eine Konsolennachricht "Button was clicked" ausgegeben. Erweiteren Sie das Verhalten mittels neuer Klassen, die von der Klasse PGPButton erben. Hierbei soll das Verhalten durch das Überschreiben der Methode click() erweitert werden.

Implementieren Sie jeweils:

    eine Klasse RecolorPGPButton, die nach jedem Klick die Hintergrundfarbe des Buttons zufällig ändert.
    eine Klasse PrintPositionPGPButton, die nach jedem Klick die Position des Buttons auf dem Frame auf der Konsole ausgibt.
    eine Klasse PrintClickHistoryPGPButton, die zu jedem Klick für diesen Button einen Zeitstempel in einer Liste speichert und diese Liste auf der Konsole ausgibt.

Beachten Sie jeweils die Einhaltung des Substitutionsprinzips nach Liskov.

Das Ergebnis kann dann folgendermaßen aussehen:
 */
public class PGPFrame extends JFrame {

    public PGPFrame(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(5,0));
        this.setTitle("My PGP-Frame");

        // set frame visible
        this.setVisible(true);
    }

    public void addNewButton(PGPButton button){
        this.add(button);
        this.pack();
        this.repaint();
    }

    public static void main(String... args){
        PGPFrame frame = new PGPFrame();
        for(int i=0;i<20;i++){
            String label = String.format("Button_%d",i);
            if(i<5){
                frame.addNewButton(new PGPButton(label));
            } else if(i<10){
                frame.addNewButton(new RecolorPGPButton(label));
            } else if(i<15){
                frame.addNewButton(new PrintPositionPGPButton(label));
            } else if(i<20){
                frame.addNewButton(new PrintClickHistoryPGPButton(label));
            }

        }
    }
}

class PGPButton extends JButton{
    /* static constants to define width and height of buttons */
    private final static int BUT_WIDTH = 200;
    private final static int BUT_HEIGHT = 25;

    /* several constructors */
    public PGPButton(){
        this(null, null);
    }

    public PGPButton(String label){
        this(label,null);
    }

    public PGPButton(Icon icon){
        this(null, icon);
    }

    public PGPButton(String label, Icon icon){
        super(label, icon);
        // set button size
        this.setPreferredSize(new Dimension(BUT_WIDTH,BUT_HEIGHT));

        // add action listener which calls the click method if button is clicked
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PGPButton.this.click();
            }
        });
        this.setVisible(true);
    }

    public void click(){
        System.out.println("Button was clicked!");
    }
}

class RecolorPGPButton extends PGPButton{
    public RecolorPGPButton(String label){
        this.setText(label);
    }

    @Override
    public void click(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color color = new Color(r, g, b);
        this.setBackground(color);
        this.setOpaque(true);
    }
}

class PrintPositionPGPButton extends PGPButton{
    public PrintPositionPGPButton(String label){
        this.setText(label);
    }

    @Override
    public void click(){
        System.out.println("I'm the button at ("+ this.getBounds().x + "," + this.getBounds().y + ")");
    }
}

class PrintClickHistoryPGPButton extends PGPButton{
    private static List<Date> clickedTimes = new ArrayList<Date>();
    public PrintClickHistoryPGPButton(String label){
        this.setText(label);
        
    }

    @Override
    public void click(){
        clickedTimes.add(new Date());
        for(Date date : clickedTimes){
            System.out.println("I was clicked at: " + date);
        }
    }
}