package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import supplies.Supplies;
import model.Adventure;
import model.City;
import model.Knapsack;
import model.Squad;
import model.TravelObserver;

public class KnapsackView extends JPanel implements Observer {

	private Adventure adventure;
	private Squad squad;
	private JPanel knapPanel;
	private JLabel knapLabel;
	private JLabel title;

	public KnapsackView(Adventure adventure) {

		this.adventure = adventure;
		this.squad = adventure.getSquad();
		this.title = new JLabel("Knapsack:");
		add(title);

		squad.getKnapsack().addObserver(this);
		knapPanel = new JPanel(new GridLayout(0, 1));

		if (squad.getKnapsack().getSupplies().length == 0) {
			knapLabel = new JLabel("Knapsack is empty");
			knapPanel.add(knapLabel);
			add(knapPanel);
		} else {
			for (int i = 0; i < squad.getKnapsack().getSupplies().length; i++) {
				knapLabel = new JLabel(
						squad.getKnapsack().getSupplies()[i].toString());
				knapPanel.add(knapLabel);
			}
			add(knapPanel);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if (squad.getKnapsack().getSupplies().length == 0) {
			remove(knapPanel);
			knapPanel.removeAll();
			knapLabel = new JLabel("Knapsack is empty");
			knapPanel.add(knapLabel);
			add(knapPanel);
		} else {
			remove(knapPanel);
			knapPanel.removeAll();
			for (int i = 0; i < squad.getKnapsack().getSupplies().length; i++) {
				JLabel knapLabel = new JLabel(
						squad.getKnapsack().getSupplies()[i].toString());
				knapPanel.add(knapLabel);
			}
			add(knapPanel);
		}
	}

}
