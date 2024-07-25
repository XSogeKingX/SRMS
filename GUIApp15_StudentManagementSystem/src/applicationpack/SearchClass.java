package applicationpack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
class SearchPanel extends JPanel
{
    private JLabel      lblCaption,lblMSG;
    private JTextField  txtQuery;
    private JButton     btnSubmit,btnCancel;
    private SearchFrame father;
    private MainPanel   mainpanel;
    
    private JLabel makeLabel(String cap,int x,int y,int w,int h,int mode)
    {
        JLabel temp = new JLabel(cap);
        if(mode == 0)
        {
            temp.setOpaque(true);
            temp.setBackground(Color.BLUE);
            temp.setForeground(Color.WHITE);
            temp.setFont(new Font("Verdana", 1, 18));
            temp.setHorizontalAlignment(JLabel.CENTER);
            Border b1 = BorderFactory.createLineBorder(Color.RED, 3);
            Border b2 = BorderFactory.createLineBorder(Color.WHITE, 2);
            Border b3 = BorderFactory.createCompoundBorder(b1, b2);
            temp.setBorder(b3);
        }
        else if(mode == 1)
            temp.setFont(new Font("Courier New", 1, 16));
        temp.setBounds(x,y,w,h);
        super.add(temp);
        return temp;
    }
    private JTextField makeTextField(int x,int y,int w,int h)
    {
        JTextField temp = new JTextField();
        temp.setBounds(x,y,w,h);
        temp.setFont(new Font("Courier New", 1, 16));
        temp.setForeground(Color.BLACK);
        temp.setHorizontalAlignment(JTextField.CENTER);
        Border b1 = BorderFactory.createLineBorder(Color.BLACK, 1);
        temp.setBorder(b1);
        super.add(temp);
        return temp;
    }
    private JButton makeButton(String cap,int x,int y,int w,int h)
    {
        JButton temp = new JButton(cap);
        temp.setBounds(x,y,w,h);
        temp.setFont(new Font("Verdana", 1, 14));
        temp.setMargin(new Insets(0,0,0,0));
        ActionListener act = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object ob = e.getSource();
                if(ob == btnSubmit)
                {
                    mainpanel.prepareQuery(txtQuery.getText());
                }
                father.dispose();
            }
        };
        temp.addActionListener(act);
        super.add(temp);
        return temp;
    }
    public SearchPanel(String cap,SearchFrame fath,MainPanel mpanel)
    {
        father      = fath;
        mainpanel   = mpanel;
        lblCaption  = makeLabel("Searching Student By "+cap,  10,10,370,60,0);
        lblMSG      = makeLabel("Enter Student "+cap,         10,90,200,30,1);
        txtQuery    = makeTextField(                         220,90,160,30);
        btnSubmit   = makeButton("Submit",                    67,140,100,30);
        btnCancel   = makeButton("Cancel",                   234,140,100,30);
    }
}
class SearchFrame extends JDialog
{
    public SearchFrame(String cap,MainPanel mpanel)
    {
        super.setTitle("Searching Student by "+cap);
        SearchPanel panel = new SearchPanel(cap,this,mpanel);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.PINK);
        super.add(panel);
    }
}
