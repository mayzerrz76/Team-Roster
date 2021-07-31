/**********************************************************
* Program Name   : Roster
* Author         : Ryan May
* Due Date       : 05/12/2020
* Course/Section : CSC111-302
* Program Description: This program allows you to create and manage a team.
*					The program will display a menu with various actions to
*					manage your team information. The menu allows the user to add or
*					delete players from the team, display the team, sort the team
*					roster by player jersey number or name, update or add a coach,
*					update or add the sport, or quit. The program includes a welcome
*					message at the beginning and an exit message when you quit. If
*					you choose an invalid menu selection the program displays an error message.
*				    This program formats player and coach names to phonebook format if they
*					enter full names, or to title case if they only enter single names.
*					This program also formats sport and team name and player positions to
*					title case.
*
* Methods:
* -------
* main			   		-  Allows the user to create a team object using a team name,
*						   max roster size, and sport name.  The method allows the user
*						   to choose an action from a menu. The actions include adding players,
*						   deleting players, displaying the team, sorting the team player roster,
*						   changing coach name, changing sport name, or quitting. If an invalid
*						   menu choice is input this method displays an error message. When you
*						   choose to quit, an exit message is displayed.
* createTeam			-  This method allows you to enter a team, max roster size,
*						   and sport name to instantiate a team object, and returns
*						   that team object. Returns a default team object if user
*						   chooses quit.
* menu					-  Displays a menu with different actions. Gets a menu
*						   choice from the user and returns as an integer.
* addPlayers			-  Allows user to add multiple players to a team object
* deletePlayers			-  Displays a player list with index numbers and allows
*						   user to delete multiple players by index number.
* coachMod 				-  Allows the user to add or update a teams coach name
* sportMod 				-  Allows the user to add or update a teams sport name
* displayTeam			-  Displays a teams information including a player info to user
* errorMessage			-  Displays an error message to the user
* sortRoster	 		-  Allows user to sort a teams players by jersey number or name
* exitMessage      		-  Displays exit message and program author signature
**********************************************************/

public class Roster
{
	//class constants

	//class variables

	/**************************************************/

	/**********************************************************
	* Method Name    : main
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method allows a user to create a team. This
	*					method calls upon a menu method that allows a user to
	*					perform various actions on their team oject. The method
	*					allows you to perform these actions as many times as user
	*					wants until they choose the option to quit. The menu options
	*					allow you to add players, delete players, display the team,
	*					add or change coach name, add or change sport name, sort
	*					the team player roster, or quit. Each of these actions
	*					will be performed by their respected methods that exist within
	*					this class. When you choose to quit this method displays an exit
	*					message.
	*
	* BEGIN main
	*	  Call create team method to return an instantiated team
	*	  Call the menu method to display menu and get user menu selection
	*	  WHILE(The selection is not quit)
	*	  	  IF(User selection is add players)
	*			  Call the add players method
	*	  	  ELSE
	*			  IF(User selection is delete players)
	*				  Call the delete players method
	*			  ELSE
	*				  IF(User selection is display team)
	*					  Call the display team method
	*				  ELSE
	*					  IF(User selection is add or change coach)
	*						  Call the coach modifier method
	*					  ELSE
	*						  IF(User selection is add or change sport)
	*							  Call the sport modifier method
	*						  ELSE
	*							  IF(User selection is sort roster)
	*								  Call the sort roster method
	*							  ELSE
	*								  Call method to dispay error message
	*  							  END IF
	*						  END IF
	*					  END IF
	*				  END IF
	*			  END IF
	*		  END IF
	*		  Call the menu method to display menu and get user menu selection
	*	  END WHILE
	*	  Call method to display an exit message
	* END main
    **********************************************************/

	public static void main(String [] args)
	{
		//local constants
		final int QUIT = 0;					//Used as a quit sentinel value for our menu
		final int ADD_PLAYERS = 1;			//Used to represent the add player menu choice
		final int DELETE_PLAYERS = 2;		//Used to represent the delete player menu choice
		final int DISPLAY_TEAM = 3;			//Used to represent the display team menu choice
		final int COACH_MOD = 4;			//Used to represent the add or change coach menu choice
		final int SPORT_MOD = 5;			//Used to represent the add or change sport menu choice
		final int SORT_ROSTER = 6;			//Used to represent the sort roster menu choice

		//local variables
		TeamInfo team;						//This is a team object
		int selection;						//Number that represents the users menu selection

		/****************************************************/

		//Call create team method to return an insantiated team
		team = Roster.createTeam();

		//Call the menu method to display menu and get user menu selection
		selection = Roster.menu();

		//WHILE(The selection is not quit)
		while(selection != QUIT)
		{
			//IF(User selection is add players)
			if(selection == ADD_PLAYERS)

				//Call the add players method
				Roster.addPlayers(team);

			//ELSE
			else

				//IF(User selection is delete player)
				if(selection == DELETE_PLAYERS)

					//Call the delete players method
					Roster.deletePlayers(team);

				//ELSE
				else

					//IF(User selection is display team)
					if(selection == DISPLAY_TEAM)

						//Call the display team method
						Roster.displayTeam(team);

					//ELSE
					else

						//IF(User selection is add or change coach)
						if(selection == COACH_MOD)

							//Call the coach modifier method
							Roster.coachMod(team);

						//ELSE
						else

							//IF(User selection is add or change sport)
							if(selection == SPORT_MOD)

								//Call the sport modifier method
								Roster.sportMod(team);

							//ELSE
							else

								//IF(User selection is sort team)
								if(selection == SORT_ROSTER)

									//Call the sort roster method
									Roster.sortRoster(team);

								//ELSE
								else

									//Call method to display error message
									Roster.errorMessage();

								//END IF

							//END IF

						//END IF

					//END IF

				//END IF

			//END IF

			//Call the menu method to display menu and get users menu selection
			selection = Roster.menu();

		}
		//END WHILE

		//Call method to display an exit message
		Roster.exitMessage();

	}//End main

	/**********************************************************
	* Method Name    : createTeam
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will display a welcome message.
	*          			This method will then get a team name from the user
	*					or they can choose to quit to menu. If the user does
	*					enter a team, this method will get the max roster size
	*					from user, and will get the sport name from user.
	*					The method uses this team info to instantiate a team object.
	*					This method returns that object. If the user did not enter a
	*					team, a default team object will be instantiated and returned.
	*
	* BEGIN createTeam
	*	  Display welcome message and ask user for a team name or quit to menu
	*	  IF(Team name input is not quit)
	*	  	  Format team name to title case
	*	  	  Ask user for the max roster size
	*	  	  Ask user for the team sport
	*		  Format sport to title case
	*		  Instantiate a team object
	*	  ELSE
	*		  Instantiate a default team object
	*	  END IF
	*	  Return the team object
	* END createTeam
    **********************************************************/

	public static TeamInfo createTeam()
	{
		//local constants
		final String QUIT = "0";			//Used as a value to quit to menu

		//local variables
		String teamIn;						//Represents a team name input by the user
		String sportIn;						//Represents a team sport name input by the user
		int maxRosterIn;					//Represents the max team roster size input by the user
		TeamInfo team1;						//Represents a team object we will insantiate and return

		/****************************************************/

		//Display welcome message and ask user for a team name or quit to menu
		System.out.print("\n\n\n\n" + Util.setLeft(17, "Welcome, and thank you for using Team Manager!") +
						"\n" + Util.setLeft(30, "Created by: Ryan May") + "\n\n\n" +
						Util.setLeft(19, "Enter the name of your team or 0 for menu : "));
		teamIn = Keyboard.readString();

		//IF(Team name input is not quit)
		if(teamIn.compareTo(QUIT) != 0)
		{
			//Format team name to title case
			teamIn = Util.toTitleCase(teamIn);

			//Ask user for the max roster size
			System.out.print(Util.setLeft(19, "Enter the maximum roster size of the team : "));
			maxRosterIn = Keyboard.readInt();

			//Ask user for the team sport
			System.out.print(Util.setLeft(19, "Enter the sport of the team               : "));
			sportIn = Keyboard.readString();

			//Format sport to title case
			sportIn = Util.toTitleCase(sportIn);

			//Instantiate a team object
			team1 = new TeamInfo(maxRosterIn, teamIn, sportIn);
		}

		//ELSE
		else

			//Instantiate a default team object
			team1 = new TeamInfo(25, "No Team", "No Sport");

		//END IF

		//Return the team object
		return team1;



	}//End createTeam

	/**********************************************************
	* Method Name    : menu
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					a menu with numbers next to each menu choice.
	*					The method will allow the user to enter their menu
	*					choice. The menu choice is returned as an integer.
	*
	* BEGIN menu
	*	  Clear screen
	*	  Display a menu header
	*	  Display menu options with number choices
	*	  Get menu choice from user
	*	  Return menu choice as an integer
	* END menu
    **********************************************************/

	public static int menu()
	{
		//local constants

		//local variables
		int menuChoice;							//Represents the menu choice number of the user

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display a menu header
		System.out.print("\n\n\n\n" + Util.setLeft(35, "TEAM  MENU"));

		//Display menu options with number choices
		System.out.print("\n\n" +
						Util.setLeft(26,"(0) Quit out of Team Manager") + "\n" +
						Util.setLeft(26,"(1) Add Players to Your Team") + "\n" +
						Util.setLeft(26,"(2) Delete Players from Team") + "\n" +
						Util.setLeft(26,"(3) Display Team and Players") + "\n" +
						Util.setLeft(26,"(4) Add or Change Coach Name") + "\n" +
						Util.setLeft(26,"(5) Add or Change Sport Name") + "\n" +
						Util.setLeft(26,"(6) Sort Your  Player Roster") + "\n\n" +
						Util.setLeft(26,"Enter a menu choice number: "));

		//Get menu choice from user
		menuChoice = Keyboard.readInt();

		//Return menu choice as an integer
		return menuChoice;

	}//End menu

	/**********************************************************
	* Method Name    : addPlayers
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and call
	*					a method that displays a team's players with
	*					index numbers next to each player. That same method
	*					will get an index choice from the user and use that choice
	*					to call a method that deletes the player the user chose.
	*					This method allows user to delete multiple players or to
	*					quit/return to menu. This method will also let the user know
	*					if a player was deleted or not.
	*
	* BEGIN addPlayers
	*	  Clear screen
	*	  Get the name of the player or return to the main menu
	*	  WHILE(Player is not return)
	*		  Format the player name
	*		  Get the position of the player
	*		  Format the length of the position name
	*		  Format position name to title case
	*		  Get the jersey number of the player
	*		  Instantiate a player object
	*		  Clear the screen
	*	  	  IF(Player is added)
	*			  Display message that the player was added
	*		  ELSE
	*			  Display message that the player was not added
	*		  END IF
	*		  Get the name of the player or return to main menu
	*	  END WHILE
	* END addPlayers
    **********************************************************/

	public static void addPlayers (TeamInfo teamObject)
	{
		//local constants
		final String RETURN = "0";			//String value used to quit/return to menu
		final int MAX_NAME_LENGTH = 20;		//Used to represent the maximum name length for a player

		//local variables
		String player;						//The player name the user puts in
		int jersey;							//The players jersey number the user puts in
		String position;					//The players position the user puts in
		PlayerInfo tempPlayer;				//Declaring a player object we can use to construct a player object

		/****************************************************/

		//Clear Screen
		Util.cls();

		//Get the name of the player or return to main menu
		System.out.print("\n\n\n\n" + Util.setLeft(17, "Enter a player name or 0 to return to menu : "));
		player = Keyboard.readString();

		//WHILE(Player is not return)
		while(player.compareTo(RETURN) != 0)
		{
			//Format the player name
			player = Util.phoneBookFormat(player);
			player = Util.formatNameLength(MAX_NAME_LENGTH, player);

			//Get the position of the player
			System.out.print(Util.setLeft(17, "Enter the position of the player           : "));
			position = Keyboard.readString();

			//Format the length of the position name
			position = Util.formatNameLength(10, position);

			//Format position name to title case
			position = Util.toTitleCase(position);

			//Get the jersey number of the player
			System.out.print(Util.setLeft(17, "Enter the jersey number of the player      : "));
			jersey = Keyboard.readInt();

			//Instantiate a player object
			tempPlayer = new PlayerInfo(player, position, jersey);

			//Clear the screen
			Util.cls();

			//IF(Player is added)
			if(teamObject.addPlayer(tempPlayer))

				//Display message that the player was added
				System.out.print("\n\n" + Util.setLeft(32,"Player was added!") + "\n\n");

			//ELSE
			else

				//Display message that the player was not added
				System.out.print("\n\n" + Util.setLeft(30, "Player was NOT added!") + "\n\n");

			//END IF

			//Get the name of the player or return to main menu
			System.out.print(Util.setLeft(17, "Enter a player name or 0 to return to menu : "));
			player = Keyboard.readString();

		}
		//END WHILE

	}//End addPlayers

	/**********************************************************
	* Method Name    : deletePlayers
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and call
	*					a method that displays a team's players with
	*					index numbers next to each player. That same method
	*					will get an index choice from the user and use that choice
	*					to call a method that deletes the player the user chose.
	*					This method allows user to delete multiple players or to
	*					quit/return to menu. This method will also let the user know
	*					if a player was deleted or not.
	*
	* BEGIN deletePlayers
	*	  Clear screen
	*	  Print blank lines for output purpose
	*	  Call method to display player list with index number and get index number to delete
	*	  WHILE(User index input is not return)
	*		  Clear screen
	*	  	  IF(Player is deleted)
	*			  Display message that the player was deleted
	*		  ELSE
	*			  Display message that no player was deleted
	*		  END IF
	*		  Print blank lines for output purpose
	*		  Call method to display player list with index number and get index number to delete
	*	  END WHILE
	* END deletePlayers
    **********************************************************/

	public static void deletePlayers(TeamInfo teamObject)
	{
		//local constants
		final int RETURN = 0;				//Represents a value used to quit/return to menu

		//local variables
		int indexIn;						//Represents the index choice the user inputs

		/****************************************************/

		//Clear screen
		Util.cls();

		//Print blank lines for output purpose
		System.out.print("\n\n\n\n\n\n");

		//Display player list with index number and get index number to delete
		indexIn = teamObject.displayPlayerIndex();

		//WHILE(User index input is not return)
		while(indexIn != RETURN)
		{
			//Clear screen
			Util.cls();

			//IF(Player is deleted)
			if(teamObject.deletePlayer(indexIn))

				//Display message that the player was deleted
				System.out.print("\n\n\n" + Util.setLeft(30, "Player was deleted! "));

			//ELSE
			else

				//Display message that no player was deleted
				System.out.print("\n\n\n" + Util.setLeft(29, "No player was deleted!"));

			//END IF

			//Print blank lines for output purposes
			System.out.print("\n\n\n");

			//Display player list with index number and get index number to delete
			indexIn = teamObject.displayPlayerIndex();

		}
		//END WHILE

	}//End deletePlayers

	/**********************************************************
	* Method Name    : coachMod
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					the current coach name of a team. This method allows
	*				    you to update the coach name or you can choose not to.
	*
	* BEGIN coachMod
	*	  Clear screen
	*	  Display the current coach
	*	  Ask user for a coach name or to return to menu
	*	  IF(Coach name is not return)
	*	  	  Format coach name to title case
	*		  Set the coach name to the users input
	*	  END IF
	* END coachMod
    **********************************************************/

	public static void coachMod (TeamInfo teamObject)
	{
		//local constants
		final String RETURN = "0";				//Represents a value used to return to menu

		//local variables
		String coachInput;						//Represents the coach name input by user

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display the current coach
		System.out.print("\n\n\n\n" +
						Util.setLeft(25, "Current Coach: ") +
						Util.setRight(15, "" + teamObject.getCoach()));

		//Ask user for a coach name
		System.out.print("\n\n\n" +
						Util.setLeft(21, "Input a new coach name or 0 to return: "));
		coachInput = Keyboard.readString();

		//IF(Coach name is not return)
		if(coachInput.compareTo(RETURN) != 0)
		{
			//Format coach name to title case
			coachInput = Util.phoneBookFormat(coachInput);

			//Set the coach name to the users input
			teamObject.setCoach(coachInput);
		}
		//END IF

	}//End coachMod

	/**********************************************************
	* Method Name    : sportMod
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					the current sport name of a team. This method allows
	*				    you to update the sport name or you can choose not to.
	*
	* BEGIN sportMod
	*	  Clear screen
	*	  Display the current sport
	*	  Ask user for a sport name or to return to menu
	*	  IF(Sport name is not return)
	*	  	  Format sport name to title case
	*		  Set the sport name to the users input
	*	  END IF
	* END sportMod
    **********************************************************/

	public static void sportMod (TeamInfo teamObject)
	{
		//local constants
		final String RETURN = "0";				//Represents a value used to return to menu

		//local variables
		String sportInput;						//Represents the sport name input by user

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display the current sport
		System.out.print("\n\n\n\n" +
						Util.setLeft(25, "Current Sport: ") +
						Util.setRight(15, "" + teamObject.getSport()));

		//Ask user for a sport name or to return to menu
		System.out.print("\n\n\n" +
						Util.setLeft(21, "Input a new sport name or 0 to return: "));
		sportInput = Keyboard.readString();

		//IF(Sport name is not return)
		if(sportInput.compareTo(RETURN) != 0)
		{
			//Format sport name to title case
			sportInput = Util.toTitleCase(sportInput);

			//Set the sport name to the users input
			teamObject.setSport(sportInput);
		}
		//END IF

	}//End sportMod

	/**********************************************************
	* Method Name    : displayTeam
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					all of the team information.
	*
	* BEGIN displayTeam
	*	  Clear screen
	*	  Display the team information
	*	  Pause screen by asking for input
	* END displayTeam
    **********************************************************/

	public static void displayTeam (TeamInfo teamObject)
	{
		//local constants

		//local variables
		String pause;					//Arbitrary value used to pause the screen

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display the team information
		System.out.print(teamObject.toString());

		//Pause screen by asking for input
		System.out.print("\n\n" +
						Util.setLeft(22, "Enter 0 to return to the main menu: "));
		pause = Keyboard.readString();

	}//End displayTeam

	/**********************************************************
	* Method Name    : errorMessage
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					an error message to the user. This method pauses
	*					the screen on the message by asking for input.
	*
	* BEGIN errorMessage
	*	  Clear screen
	*	  Display error message
	*	  Pause screen by asking for input
	* END errorMessage
    **********************************************************/

	public static void errorMessage()
	{
		//local constants

		//local variables
		String errorPause;

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display error message
		System.out.print("\n\n\n\n" +
						Util.setLeft(26, "Your selection was invalid!!"));

		//Pause screen by asking for input
		System.out.print("\n\n" +
						Util.setLeft(22, "Enter 0 to return to the main menu: "));
		errorPause = Keyboard.readString();

	}//End errorMessage

	/**********************************************************
	* Method Name    : sortRoster
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					sorting options for the user. The method allows the user
	*					to choose to sort a teams players by name or by jersey number.
	*					It will let the user know that the players were sorted, if
	*					their choice was valid. If their sorting choice was invalid
	*					it will let user know the team was not sorted.
	*
	* BEGIN sortRoster
	*	  Clear screen
	*	  Display sorting options and ask user for sorting choice
	*	  IF(Users sorting choice is sort by jersey number)
	*     	  Call method to sort players by jersey number
	*		  Display message that team was sorted
	*	  ELSE
	*		  IF(Users sorting choice is sort by name)
	*			  Call method to sort players by name
	*			  Display message that team was sorted
	*	  ELSE
	*		  Display message that team was not sorted
	*	  END IF
	*	  Pause the screen by asking for input
	* END sortRoster
    **********************************************************/

	public static void sortRoster(TeamInfo teamObject)
	{
		//local constants
		final int BY_NUM = 1;					//Used to indicate the sort by jersey number choice
		final int BY_NAME = 2;					//Used to indicate the sort by name choice

		//local variables
		int sortChoice;							//Represents the sorting choice input by the user
		String pauseSort;						//Arbitrary value used to pause the screen

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display sorting options and ask user for sorting choice
		System.out.print("\n\n\n\n" +
						Util.setLeft(27, "(1) Sort by jersey number") + "\n" +
						Util.setLeft(27, "(2) Sort by player name") + "\n\n" +
						Util.setLeft(27, "Input menu sort choice: "));
		sortChoice = Keyboard.readInt();

		//IF(Users sorting choice is sort by jersey number)
		if(sortChoice == BY_NUM)
		{
			//Call method to sort players by jersey number
			teamObject.sortByJersey();

			//Display message that team was sorted
			System.out.print("\n\n" +
							Util.setLeft(32, "Team was sorted!"));
		}

		//ELSE
		else

			//IF(Users sorting choice is sort by name)
			if(sortChoice == BY_NAME)
			{
				//Call method to sort players by name
				teamObject.sortByName();

				//Display message that team was sorted
				System.out.print("\n\n" +
								Util.setLeft(32, "Team was sorted!"));
			}

		//ELSE
		else

			//Display message that team was not sorted
			System.out.print("\n\n" +
							Util.setLeft(30, "Team was NOT sorted!"));

		//END IF

		//Pause the screen by asking for input
		System.out.print("\n\n" +
							Util.setLeft(27, "Enter 0 to return to menu: "));
		pauseSort = Keyboard.readString();

	}//End sortRoster

	/**********************************************************
	* Method Name    : exitMessage
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*					an exit and thank you method with author signature.
	*
	* BEGIN exitMessage
	*	  Clear screen
	*	  Display exit message
	*	  Display author signature
	* END exitMessage
    **********************************************************/

	public static void exitMessage()
	{
		//local constants

		//local variables

		/****************************************************/

		//Clear screen
		Util.cls();

		//Display exit message
		System.out.print("\n\n\n\n" +
						Util.setLeft(23, "Thank you for using building manager!!"));

		//Display author signature
		System.out.print("\n\n" +
						Util.setLeft(29, "Created by:   Ryan May") + "\n" +
						Util.setLeft(29, "Class     : CSC112-301") + "\n" +
						Util.setLeft(29, "Due Date  : 09/29/2020") + "\n\n\n\n\n\n");

	}//End exitMessage



}//End Roster