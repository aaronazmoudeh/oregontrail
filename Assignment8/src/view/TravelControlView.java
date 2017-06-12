package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;
import model.InTransitException;

public class TravelControlView extends JPanel implements ActionListener {

	private Adventure adventure;
	private JComboBox cityList;

	public TravelControlView(Adventure adventure) {

		JLabel travelLabel = new JLabel("Travel to: ");
		this.adventure = adventure;
		City[] cityArr = adventure.getCities();
		cityList = new JComboBox<City>(cityArr);
		cityList.addActionListener(this);
		add(travelLabel);
		add(cityList);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		adventure.travel((City) cityList.getSelectedItem());

	}
}
