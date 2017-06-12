package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import person.Person;
import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.Squad;

public class AdventureView extends JPanel {

	private Adventure adventure;
	private JPanel panel_list;

	public AdventureView(Adventure adventure) {
		this.adventure = adventure;

		setLayout(new BorderLayout());

		Squad s = adventure.getSquad();

		TravelControlView travelView = new TravelControlView(adventure);
		add(travelView, BorderLayout.SOUTH);

		TravelStatusView travelStatus = new TravelStatusView(adventure);
		add(travelStatus, BorderLayout.EAST);

		SquadStatusView squadStatus = new SquadStatusView(adventure);
		add(new JScrollPane(squadStatus), BorderLayout.WEST);

		KnapsackView knapView = new KnapsackView(adventure);
		add(knapView, BorderLayout.NORTH);

		StoreView storeView = new StoreView(adventure);
		add(storeView, BorderLayout.CENTER);

	}

}
