package maincode;

public class Transition {
	
	UI ui;
	
	public Transition(UI UserInterface) {
		ui = UserInterface;
		
	}
	public void ShowTitleScreen() {
		ui.TitlenamePanel.setVisible(true);
		ui.StartButtonPanel.setVisible(true);
		
		ui.mainTextArea.setVisible(false);
		ui.ButtonPanel.setVisible(false);
		ui.UserPanel.setVisible(false);
		
	}
	public void TitletoStarter() {
		ui.TitlenamePanel.setVisible(false);
		ui.StartButtonPanel.setVisible(false);
		
		ui.mainTextArea.setVisible(true);
		ui.ButtonPanel.setVisible(true);
		ui.UserPanel.setVisible(true);
	}
}
