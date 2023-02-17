package markup_cost;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MarkUpCostCalc extends JFrame{

	private JPanel myPanel;
	private JTextField cost;
	private JTextField markUp;
	private JButton Calc;
	private JLabel enterCost;
	private JLabel per;
	private JButton exit;
	
	public MarkUpCostCalc() {
		
		setTitle("Mark up cost");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,200);
		
		cost= new JTextField(10);
		markUp= new JTextField(10);
		Calc= new JButton("Mark up Calculate");
		enterCost = new JLabel("Enter cost");
		enterCost.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		per = new JLabel("\nEnter mark up percentage");
		per.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		exit= new JButton("exit"); 
		
		myPanel= new JPanel();
		myPanel.add(enterCost);
		myPanel.add(cost);
		myPanel.add(per);
		myPanel.add(markUp);
		myPanel.add(Calc);
		myPanel.add(exit);
		myPanel.setLayout(new GridLayout(3,1));
		add(myPanel);
		
		Calc.addActionListener(new Calculate());
		exit.addActionListener(new exitButton());
		
		
		
		setVisible(true);
		
	}
	
	private class Calculate implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String getCost=cost.getText();
			String getMarkup=markUp.getText();
			
			if(getCost.isEmpty() || getCost.isBlank() || getMarkup.isBlank() || getMarkup.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Check again, cost or mark up can not be empty");
			}
			else {
			
			double markUpPrice=(Double.parseDouble(getCost)*Double.parseDouble(getMarkup))/100 +
					Double.parseDouble(getCost);
			
			JOptionPane.showMessageDialog(null, "Mark up cost is $" + markUpPrice);
			}
		}
		
		
		
	}
	
	private class exitButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MarkUpCostCalc();
	}

}
