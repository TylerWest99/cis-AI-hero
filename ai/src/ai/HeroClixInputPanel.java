package ai;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;


import java.util.*;


public class HeroClixInputPanel extends JPanel {
	
	private Game heroGame; 
	
	//All the labels used
	private JLabel title;
	private JLabel heroLabel;
	private JLabel foeLabel;
	private JLabel aiInstructions;
	private JLabel ironManClicks;
	private JLabel thorClicks;
	private JLabel captAmericaClicks;
	private JLabel foeIronManClicks;
	private JLabel foeThorClicks;
	private JLabel foeCaptAmericaClicks;
	private JLabel locIronMan;
	private JLabel locThor;
	private JLabel locCaptAmerica;
	private JLabel locFoeIronMan;
	private JLabel locFoeThor;
	private JLabel locFoeCaptAmerica;
	private JLabel ironManTokens;
	private JLabel thorTokens;
	private JLabel captAmericaTokens;
	
	//All the buttons used
	private JButton addClicksIronMan;
	private JButton addClicksThor;
	private JButton addClicksCaptAmerica;
	private JButton addClicksFoeIronMan;
	private JButton addClicksFoeThor;
	private JButton addClicksFoeCaptAmerica;
	private JButton setLocations;
	private JButton moveIronMan;
	private JButton moveThor;
	private JButton moveCaptAmerica;
	private JButton addIMActToken;
	private JButton addThorActToken;
	private JButton addCAActToken;
	private JButton addFoeIMActToken;
	private JButton addFoeThorActToken;
	private JButton addFoeCAActToken;
	private JButton rmIMActToken;
	private JButton rmThorActToken;
	private JButton rmCAActToken;
	private JButton rmFoeIMActToken;
	private JButton rmFoeThorActToken;
	private JButton rmFoeCAActToken;
	
	
	//All the textfields used
	private JTextField ironManLoc;
	private JTextField thorLoc;
	private JTextField captAmericaLoc;
	private JTextField foeIronManLoc;
	private JTextField foeThorLoc;
	private JTextField foeCaptAmericaLoc;
	
	public HeroClixInputPanel() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints l = new GridBagConstraints();
		
		heroGame = new Game();
		
		//Create all the labels.
		title = new JLabel("The AiVengers Control Center");
		heroLabel = new JLabel ("Our Heroes");
		foeLabel = new JLabel ("Our Foes");
		aiInstructions = new JLabel("INSTRUCTIONS GO HERE");
		ironManClicks = new JLabel("Iron Man Clicks: 1");
		thorClicks = new JLabel("Thor Clicks: 1");
		captAmericaClicks = new JLabel("Captain America Clicks: 1");
		foeIronManClicks = new JLabel("Iron Man Clicks: 1");
		foeThorClicks = new JLabel("Thor Clicks: 1");
		foeCaptAmericaClicks = new JLabel("Captain America Clicks: 1");
		locIronMan = new JLabel("Iron Man's Position: ??");
		locThor = new JLabel("Thor's Position: ??");
		locCaptAmerica = new JLabel(" Captain America's Postion: ??");
		locFoeIronMan = new JLabel("Iron Man's Postion: ??");
		locFoeThor = new JLabel("Thor's Position: ??");
		locFoeCaptAmerica = new JLabel("Captiain America's Position: ??");
		ironManTokens = new JLabel ("Hero 0 | Foe 0");
		thorTokens = new JLabel ("Hero 0 | Foe 0");
		captAmericaTokens = new JLabel ("Hero 0 | Foe 0");
		
		//Create all the buttons and link them to the button listener
		ButtonListener butListener = new ButtonListener();
		addClicksIronMan = new JButton("Click+1");
		addClicksIronMan.addActionListener(butListener);
		addClicksThor = new JButton("Click+1");
		addClicksThor.addActionListener(butListener);
		addClicksCaptAmerica = new JButton("Click+1");
		addClicksCaptAmerica.addActionListener(butListener);
	    addClicksFoeIronMan = new JButton("Click+1");
	    addClicksFoeIronMan.addActionListener(butListener);
		addClicksFoeThor = new JButton("Click+1");
		addClicksFoeThor.addActionListener(butListener);
		addClicksFoeCaptAmerica = new JButton("Click+1");
		addClicksFoeCaptAmerica.addActionListener(butListener);
		setLocations = new JButton("Save Positions");
		setLocations.addActionListener(butListener);
		moveIronMan = new JButton("Ironman's Move");
		moveIronMan.addActionListener(butListener);
		moveThor = new JButton ("Thor's Move");
		moveThor.addActionListener(butListener);
		moveCaptAmerica = new JButton ("Captain America's Move");
		moveCaptAmerica.addActionListener(butListener);
		addIMActToken = new JButton("+Token");
		addIMActToken.addActionListener(butListener);
		addThorActToken = new JButton("+Token");
		addThorActToken.addActionListener(butListener);
		addCAActToken = new JButton("+Token");
		addCAActToken.addActionListener(butListener);
		addFoeIMActToken = new JButton("+Token");
		addFoeIMActToken.addActionListener(butListener);
		addFoeThorActToken = new JButton("+Token");
		addFoeThorActToken.addActionListener(butListener);
		addFoeCAActToken = new JButton("+Token");
		addFoeCAActToken.addActionListener(butListener);
		rmIMActToken = new JButton("-Token");
		rmIMActToken.addActionListener(butListener);
		rmThorActToken = new JButton("-Token");
		rmThorActToken.addActionListener(butListener);
		rmCAActToken = new JButton("-Token");
		rmCAActToken.addActionListener(butListener);
		rmFoeIMActToken = new JButton("-Token");
		rmFoeIMActToken.addActionListener(butListener);
		rmFoeThorActToken = new JButton("-Token");
		rmFoeThorActToken.addActionListener(butListener);
		rmFoeCAActToken = new JButton("-Token");
		rmFoeCAActToken.addActionListener(butListener);
		
		//Create all the text fields.
		ironManLoc = new JTextField(4);
		thorLoc = new JTextField(4);
		captAmericaLoc = new JTextField(4);
		foeIronManLoc = new JTextField(4);
		foeThorLoc = new JTextField(4);
		foeCaptAmericaLoc = new JTextField(4);
		
		//Set up the title
		l.gridx = 2;
		l.gridy = 0;
		l.insets.top = 5;
		l.insets.bottom = 5;
		l.insets.left = 5;
		l.insets.right = 5;
		add(title,l);
		
		//Place all the elements for the heroes side.
		l.anchor = GridBagConstraints.EAST; 
		l.gridx = 0;
		l.gridy = 1;
		add(heroLabel, l);
		
		l.gridx = 3;
		add(foeLabel, l);
		
		l.gridx = 0;
		l.gridy = 2;
		add(addClicksIronMan, l);
		l.gridy = 3;
		add(ironManLoc, l);
		l.gridy = 5;
		add(addClicksThor, l);
		l.gridy = 6;
		add(thorLoc, l);
		l.gridy = 8;
		add(addClicksCaptAmerica, l);
		l.gridy = 9;
		add(captAmericaLoc, l);
		
		l.anchor = GridBagConstraints.WEST;
		l.gridx = 1;
		l.gridy = 2;
		add(ironManClicks, l);
		l.gridy = 3;
		add(locIronMan, l);
		l.gridy = 5;
		add(thorClicks, l);
		l.gridy = 6;
		add(locThor, l);
		l.gridy = 8;
		add(captAmericaClicks, l);
		l.gridy = 9;
		add(locCaptAmerica, l);
		
		
		//Place all the elements for the enemy side.
		l.anchor = GridBagConstraints.EAST;
		l.gridx = 3;
		l.gridy = 2;
		add(addClicksFoeIronMan, l);
		l.gridy = 3;
		add(foeIronManLoc, l);
		l.gridy = 5;
		add(addClicksFoeThor, l);
		l.gridy = 6;
		add(foeThorLoc, l);
		l.gridy = 8;
		add(addClicksFoeCaptAmerica, l);
		l.gridy = 9;
		add(foeCaptAmericaLoc, l);
		
		l.anchor = GridBagConstraints.WEST;
		l.gridx = 4;
		l.gridy = 2;
		add(foeIronManClicks, l);
		l.gridy = 3;
		add(locFoeIronMan, l);
		l.gridy = 5;
		add(foeThorClicks, l);
		l.gridy = 6;
		add(locFoeThor, l);
		l.gridy = 8;
		add(foeCaptAmericaClicks, l);
		l.gridy = 9;
		add(locFoeCaptAmerica, l);
		
		//Place the move buttons for each hero.
		l.anchor = GridBagConstraints.CENTER;
		l.gridx = 2;
		l.gridy = 3;
		add(moveIronMan, l);
		l.gridy = 6;
		add(moveThor, l);
		l.gridy = 9;
		add(moveCaptAmerica,l);
		
		//Set up the set location button.
		l.gridx = 2;
		l.gridy = 1;
		add(setLocations,l);
		
		//Set up the instructions for what we have to do.
		l.gridy = 11;
		add(aiInstructions,l);
		
		//Set up action token labels.
		l.gridy = 4;
		add(ironManTokens, l);
		l.gridy = 7;
		add(thorTokens, l);
		l.gridy = 10;
		add(captAmericaTokens, l);
		
		//Set up action token buttons
		l.anchor = GridBagConstraints.EAST;
		l.gridx = 0;
		l.gridy = 4;
		add(addIMActToken,l);
		l.gridy = 7;
		add(addThorActToken,l);
		l.gridy = 10;
		add(addCAActToken,l);
		l.gridx = 3;
		l.gridy = 4;
		add(addFoeIMActToken,l);
		l.gridy = 7;
		add(addFoeThorActToken,l);
		l.gridy = 10;
		add(addFoeCAActToken,l);
		
		l.anchor = GridBagConstraints.WEST;
		l.gridx = 1;
		l.gridy = 4;
		add(rmIMActToken,l);
		l.gridy = 7;
		add(rmThorActToken,l);
		l.gridy = 10;
		add(rmCAActToken,l);
		l.gridx = 4;
		l.gridy = 4;
		add(rmFoeIMActToken,l);
		l.gridy = 7;
		add(rmFoeThorActToken,l);
		l.gridy = 10;
		add(rmFoeCAActToken,l);
	}
	
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(addClicksIronMan == e.getSource()) {
				heroGame.ironAddClick();
				ironManClicks.setText("Iron Man Clicks: " + heroGame.ironMan.getClick());
			}
			
			if(addClicksThor == e.getSource()) {
				heroGame.thorAddClick();
				thorClicks.setText("Thor Clicks: " + heroGame.thor.getClick());
			}
			
			if(addClicksCaptAmerica == e.getSource()){
				heroGame.capAddClick();
				captAmericaClicks.setText("Captain America Clicks: " + heroGame.cap.getClick());
			}
			
			if(addClicksFoeIronMan == e.getSource()) {
				heroGame.enemyIronAddClick();
				foeIronManClicks.setText("Iron Man Clicks: " + heroGame.enemyIronMan.getClick());
			}
			
			if(addClicksFoeThor == e.getSource()) {
				heroGame.enemyThorAddClick();
				foeThorClicks.setText("Thor Clicks: " + heroGame.enemyThor.getClick());
			}
			
			if(addClicksFoeCaptAmerica == e.getSource()){
				heroGame.EnemyCapAddClick();
				foeCaptAmericaClicks.setText("Captain America Clicks: " + heroGame.enemyCap.getClick());
			}
			
			if(setLocations == e.getSource()) {
				heroGame.setLocs(heroGame.cap, heroGame.ironMan, heroGame.thor, 
						captAmericaLoc.getText(), ironManLoc.getText(), thorLoc.getText());
				
				heroGame.setLocs(heroGame.enemyCap, heroGame.enemyIronMan, heroGame.enemyThor, 
						foeCaptAmericaLoc.getText(), foeIronManLoc.getText(), foeThorLoc.getText());
				
				locIronMan.setText("Iron Man's Postion: " + ironManLoc.getText());
				locThor.setText("Thor's Postion: " + thorLoc.getText());
				locCaptAmerica.setText("Captain America's Postion: " + captAmericaLoc.getText());
				
				locFoeIronMan.setText("Iron Man's Postion: " + foeIronManLoc.getText());
				locFoeThor.setText("Thor's Position: " + foeThorLoc.getText());
				locFoeCaptAmerica.setText("Captain America's Position: " + foeCaptAmericaLoc.getText());
			}
			
			if(addIMActToken == e.getSource()) {
				heroGame.ironAddToken();
				ironManTokens.setText("Hero " + heroGame.ironMan.getActionTokens() + 
						"| Foe " + heroGame.enemyIronMan.getActionTokens());
			}
			
			if(addThorActToken == e.getSource()) {
				heroGame.thorAddToken();
				thorTokens.setText("Hero " + heroGame.thor.getActionTokens() + 
						"| Foe " + heroGame.enemyThor.getActionTokens());
			}
			
			if(addCAActToken == e.getSource()) {
				heroGame.capAddToken();
				captAmericaTokens.setText("Hero " + heroGame.cap.getActionTokens() + 
						"| Foe " + heroGame.enemyCap.getActionTokens());
			}
			if(addFoeIMActToken == e.getSource()) {
				heroGame.enemyIronAddToken();
				ironManTokens.setText("Hero " + heroGame.ironMan.getActionTokens() + 
						"| Foe " + heroGame.enemyIronMan.getActionTokens());
			}
			if(addFoeThorActToken == e.getSource()) {
				heroGame.enemyThorAddToken();
				thorTokens.setText("Hero " + heroGame.thor.getActionTokens() + 
						"| Foe " + heroGame.enemyThor.getActionTokens());
			}
			if(addFoeCAActToken == e.getSource()) {
				heroGame.EnemyCapAddToken();
				captAmericaTokens.setText("Hero " + heroGame.cap.getActionTokens() + 
						"| Foe " + heroGame.enemyCap.getActionTokens());
				
			}
			if(rmIMActToken == e.getSource()) {
				heroGame.ironRmToken();
				ironManTokens.setText("Hero " + heroGame.ironMan.getActionTokens() + 
						"| Foe " + heroGame.enemyIronMan.getActionTokens());
			}
			if(rmThorActToken == e.getSource()) {
				heroGame.thorRmToken();
				thorTokens.setText("Hero " + heroGame.thor.getActionTokens() + 
						"| Foe " + heroGame.enemyThor.getActionTokens());
			}
			if(rmCAActToken == e.getSource()) {
				heroGame.capRmToken();
				captAmericaTokens.setText("Hero " + heroGame.cap.getActionTokens() + 
						"| Foe " + heroGame.enemyCap.getActionTokens());
			}
			if(rmFoeIMActToken == e.getSource()) {
				heroGame.enemyIronRmToken();
				ironManTokens.setText("Hero " + heroGame.ironMan.getActionTokens() + 
						"| Foe " + heroGame.enemyIronMan.getActionTokens());
			}
			if(rmFoeThorActToken == e.getSource()) {
				heroGame.enemyThorRmToken();
				thorTokens.setText("Hero " + heroGame.thor.getActionTokens() + 
						"| Foe " + heroGame.enemyThor.getActionTokens());
			}
			if(rmFoeCAActToken == e.getSource()) {
				heroGame.enemyCapRmToken();
				captAmericaTokens.setText("Hero " + heroGame.cap.getActionTokens() + 
						"| Foe " + heroGame.enemyCap.getActionTokens());
			}
			
			if(moveIronMan == e.getSource()) {
				//TODO fill in instructions here.
			}
			
			if(moveThor == e.getSource()) {
				//TODO fill in instructions here.
			}
			
			if(moveCaptAmerica == e.getSource()) {
				//TODO fill in instructions here.
			}
		}
		
	}
	
}
