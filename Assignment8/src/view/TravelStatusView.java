package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;
import model.InTransitException;
import model.TravelObserver;

public class TravelStatusView extends JPanel implements TravelObserver {

	private Adventure adventure;
	private int distance_to_destination;
	private JLabel travelLabel;
	private City destination;
	private City currentCity;

	public TravelStatusView(Adventure adventure) {

		this.adventure = adventure;
		try {
			this.currentCity = adventure.getCurrentCity();
		} catch (InTransitException e) {

		}

		adventure.addTravelObserver(this);

		this.travelLabel = new JLabel("Day " + adventure.getDay() + ": "
				+ "you are in " + currentCity.toString());
		add(travelLabel);
	}

	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {

		this.destination = destination;

		if (distance_to_destination > 0) {
			travelLabel.setText("Day " + adventure.getDay() + ": "
					+ distance_to_destination + " miles to "
					+ destination.toString());
		} else {
			travelLabel.setText("Day " + adventure.getDay() + ": "
					+ "arrived at " + destination.toString());
		}
		add(travelLabel);
	}

}
