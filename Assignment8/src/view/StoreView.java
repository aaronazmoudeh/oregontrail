package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.TravelObserver;

public class StoreView extends JPanel {

	private Adventure adventure;
	private JPanel storePanel;
	private JLabel[] storeItems;

	public StoreView(Adventure adventure) {

		this.adventure = adventure;
		try {
			storeItems = new JLabel[adventure.getCurrentCity().getStore()
					.getItemNames().length];
		} catch (InTransitException e) {

		}
		storePanel = new JPanel(new GridLayout(0, 1));

		try {
			for (int i = 0; i < adventure.getCurrentCity().getStore()
					.getItemNames().length; i++) {

				storeItems[i] = new JLabel(adventure.getCurrentCity()
						.getStore().getItemNames()[i]
						+ " - $"
						+ adventure
								.getCurrentCity()
								.getStore()
								.getPrice(
										adventure.getCurrentCity().getStore()
												.getItemNames()[i]));
				storePanel.add(storeItems[i]);
			}
		} catch (InTransitException e) {

		} catch (ItemNotForSaleException e) {

		}

		add(storePanel);
	}

}
