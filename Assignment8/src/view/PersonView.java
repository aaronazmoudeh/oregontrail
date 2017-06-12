package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import person.Person;

public class PersonView extends JPanel implements Observer {

	private Person person;
	private JButton b;
	
	public PersonView(Person p) {
		person = p;
		b = new JButton(p.toString());
		
		add(b);
		person.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				b.setText(person.toString());
			}
		});
	}
}
