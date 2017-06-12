package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;
import model.TravelObserver;

public class SquadStatusView extends JPanel implements TravelObserver {

	private Adventure adventure;
	private JPanel squadPanel;
	private JLabel[] playerLabel;

	public SquadStatusView(Adventure adventure) {

		this.adventure = adventure;
		adventure.addTravelObserver(this);

		playerLabel = new JLabel[adventure.getSquad().getNumPlayers()];
		squadPanel = new JPanel(new GridLayout(0, 1));

		for (int i = 0; i < adventure.getSquad().getNumPlayers(); i++) {

			playerLabel[i] = new JLabel(adventure.getSquad().getPlayer(i)
					.toString());
			squadPanel.add(playerLabel[i]);
		}

		add(squadPanel);
	}

	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {

		for (int i = 0; i < adventure.getSquad().getNumPlayers(); i++) {

			playerLabel[i]
					.setText(adventure.getSquad().getPlayer(i).toString());
			squadPanel.add(playerLabel[i]);
		}

		add(squadPanel);
	}

}
