/**********************************************************
* Program Name   : TeamInfo
* Author         : Ryan May
* Due Date       : 05/12/2020
* Course/Section : CSC111-302
* Program Description: This program allows you to construct
*		objects that contain data for a team and team information.
*		The program also formats the data of a team to string
*		data for output purposes. The program keeps track of an
*		array of player objects, and includes methods to add or delete
*		players. This program keeps track of the amount of players on a
*		team, and allows you to get and set the name of the team coach
*		and the team sport.
*
* Methods:
* -------
* Constructor   		-  Instantiates an obect of this class and initializes
*						   the instance data. Instantiates an array of player
*						   objects.
* addPlayer 			-  Adds a player object to a player array if there is room
*						   on the player roster. Returns true if player is added.
* deletePlayer			-  Deletes a player obect using an index number to indicate
*				 		   which player. Returns true if player is deleted.
* displayPlayerIndex	-  Displays array of player objects with index numbers next to
*						   each player, and allows the user to input an index number that
*						   indicates which player to delete, and returns that number.
* getCoach 				-  Returns the name of a teams coach
* getSport 				-  Returns the name of a teams sport
* setCoach 				-  Allows you to set the name of the coach for a team object
* setSport				-  Allows you to set the name of the sport for a team object
* getJerseyNum  		-  Returns the jersey number of a player
* sortByName 			-  Sorts the player array by player name in lexically ascending order
* sortByJersey			-  Sorts the player array by jersey number in numerically ascending order
* toString      		-  Formats a team objects data to a string output
**********************************************************/

public class TeamInfo
{
	//class constants

	//class variables
	private String teamName;
	private String coachName;
	private PlayerInfo [] players;
	private int maxPlayers;
	private int numPlayers;
	private String sportLeague;

	/********************************************************/

	/**********************************************************
	* Method Name    : TeamInfo
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This is a constructor method that is used
	*					instantiate a teaminfo object that represents a team
	*					This method takes the max roster size of a team, the
	*					team name, and sport name and uses that data to initialize
	*					a team, including instantiating an array of player objects
	*					using the max roster size parameter as the size of the array.
	*					The rest of the class data is initialized here as well to avoid
	*					null pointers.
	*
	* BEGIN TeamInfo
	*	  Initialize the instance data
	* END TeamInfo
    **********************************************************/

	public TeamInfo(int maxNum, String team, String sport)
	{
		//local constants

		//local variables

		/****************************************************/

		//Instantiate the instance data
		teamName = team;
		coachName = "N/A";
		sportLeague = sport;
		players = new PlayerInfo [maxNum];
		numPlayers = 0;
		maxPlayers = maxNum;

	}//End TeamInfo

	/**********************************************************
	* Method Name    : addPlayer
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*				a list of players on a team, with index numbers next
	*				to each player.  This method will then prompt the user
	*				to choose an index number of a player that they would like
	*				to delete. The index number they choose is returned by this
	*				method as an integer.
	*
	* BEGIN addPlayer
	*	  IF(The player array is not full)
	*	  	  Add player obect to the next available array element
	*		  Increment the number of players
	*		  Set player added indicator to added value
	*	  ELSE
	*		  Set player added indicator to not added value
	*	  END IF
	*	  Return true if a player was added, return false if a player was not added
	* END addPlayer
    **********************************************************/

	public boolean addPlayer(PlayerInfo player)
	{
		//local constants
		final int ADDED = 0;					//Used to toggle the value of our player added indicator
		final int NOT_ADDED = 1;				//Used to toggle the value of our player added indicator

		//local variables
		int playerAdded = 0;					//Player added indicator 0 if player was added 1 if player was not

		/****************************************************/

		//IF(The player array is not full)
		if(numPlayers < maxPlayers)
		{
			//Add player object to the next available array element
			players[numPlayers] = player;

			//Increment the number of players
			numPlayers += 1;

			//Set player added indicator to added
			playerAdded = ADDED;
		}

		//ELSE
		else

			//Set player added indicator to not added
			playerAdded = NOT_ADDED;

		//END IF

		//Return true if a player was added, return false if a player was not added
		return (playerAdded == ADDED);

	}//End addPlayer

	/**********************************************************
	* Method Name    : deletePlayer
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*				a list of players on a team, with index numbers next
	*				to each player.  This method will then prompt the user
	*				to choose an index number of a player that they would like
	*				to delete. The index number they choose is returned by this
	*				method as an integer.
	*
	* BEGIN deletePlayer
	*	  IF(The index of the player is valid)
	*	  	  FOR(Each player that comes after the deleted player in the player array)
	*			   Shift each player up one spot in the player array
	*		  END FOR
	*		  Decrement the number of players
	*	  END IF
	*	  Return true if a player was deleted, return false if a player was not deleted
	* END deletePlayer
    **********************************************************/

	public boolean deletePlayer(int indexNum)
	{
		//local constants

		//local variables

		/****************************************************/

		//IF(The index of the player is valid)
		if(indexNum > 0 && indexNum <= numPlayers)
		{
				//FOR(Each player that comes after the deleted player in the player array)
				for(int i = indexNum; i < numPlayers; i ++)
				{
					//Shift each player up one spot in the player array
					players[i-1] = players[i];
				}
				//END FOR

				//Decrement the number of players
				numPlayers -= 1;
		}
		//END IF

		//Return true if a player was deleted, return false if a player was not deleted
		return (indexNum > 0 && indexNum <= numPlayers);

	}//End deletePlayer

	/**********************************************************
	* Method Name    : displayPlayerIndex
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will clear the screen and display
	*				a list of players on a team, with index numbers next
	*				to each player.  This method will then prompt the user
	*				to choose an index number of a player that they would like
	*				to delete. The index number they choose is returned by this
	*				method as an integer.
	*
	* BEGIN displayPlayerIndex
	*	  Display header
	*	  FOR(Each player in the array)
	*		  Display player info of each player on separate line with index numbers
	*	  END FOR
	*	  Ask user for index number of the player they want to delete
	*	  Return the users index choice as an integer
	* END displayPlayerIndex
    **********************************************************/

	public int displayPlayerIndex()
	{
		//local constants

		//local variables
		int indexIn;					//Represents the index number that the user chooses

		/****************************************************/

		//Display header
		System.out.print(Util.setLeft(17, "Index	Player                Position     Num")
						+"\n");

		//FOR(Each player in the array)
		for(int playerIndex = 1; playerIndex <= numPlayers; playerIndex ++)
		{
			//Display player info of each player on separate line with index numbers
			System.out.print(Util.setRight(20, "" + playerIndex) +
							Util.setLeft(4, "" +  players[playerIndex-1]) +
							"\n");
		}
		//END FOR

		//Ask user for index number of the player they want to delete
		System.out.print("\n" + Util.setLeft(11, "Enter index of player you want to delete or 0 to return: "));
		indexIn = Keyboard.readInt();

		//Return the users index choice as an integer
		return indexIn;

	}//End displayPlayerIndex

	/**********************************************************
	* Method Name    : setCoach
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will allow you to set the
	*				coach name of a team object.  The method takes
	*				a string as a parameter and sets the coaches name
	*				to that string.
	*
	* BEGIN getCoach
	*	  Set the coach name
	* END getCoach
    **********************************************************/

	public void setCoach(String coachIn)
	{
		//local constants

		//local variables

		/****************************************************/

		//Set the coach name
		coachName = coachIn;

	}//End setCoach

	/**********************************************************
	* Method Name    : getCoach
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will return the coach name
	*				of a team object.
	*
	* BEGIN getCoach
	*	  Return coach name
	* END getCoach
    **********************************************************/

	public String getCoach()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return coach name
		return coachName;

	}//End getCoach

	/**********************************************************
	* Method Name    : setSport
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will allow you to set the
	*				sport name of a team object.  The method takes
	*				a string as a parameter and sets the sport name
	*				to that string.
	*
	* BEGIN setSport
	*	  Set the sport name
	* END setSport
    **********************************************************/

	public void setSport(String sportIn)
	{
		//local constants

		//local variables

		/****************************************************/

		//Set the sport name
		sportLeague = sportIn;

	}//End setSport

	/**********************************************************
	* Method Name    : getSport
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will return the sport name
	*				of a team object.
	*
	* BEGIN getSport
	*	  Return the sport name
	* END getSport
    **********************************************************/

	public String getSport()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return the sport name
		return sportLeague;

	}//End getSport

	/**********************************************************
	* Method Name    : sortByJersey
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will use nested for loops
	*					to compare the jersey numbers of player objects
	*					that are next to eachother in an array
	*					and places the the objects in numerical order
	*				    by creating a tempory object. This is
	*					considered bubble sorting.
	*
	* BEGIN sortByJersey
	* 	  FOR(As long as the array is not sorted)
	*		  FOR(Each element next to each other in the array)
	*			  IF(Player elements are not in numerically ascending order)
	*				  Store the player with the larger numer as a temporary player object
	*				  Shift the player with the smaller number up in the array
	*				  Shift the player with the bigger number down in the array
	*			  END IF
	*		  END FOR
	*	  END FOR
	* END sortByJersey
    **********************************************************/

	public void sortByJersey()
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer;					//Represents a player object for temporary storage purposes

		/****************************************************/

		//FOR(As long as array is not sorted)
		for(int i = 0; i < numPlayers; i++)
		{
			//FOR(Each element next to each other in the array)
			for(int j = i + 1; j < numPlayers; j++)
			{
				//IF(Player elements are not in numerically ascending order)
				if(players[i].getJerseyNum() > players[j].getJerseyNum())
				{
					//Store the player with the larger number as a temporary player object
					tempPlayer = players[i];

					//Shift the player with the smaller number up in the array
					players[i] = players[j];

					//Shift the player with the bigger number down in the array
					players[j] = tempPlayer;
				}
				//END IF
			}
			//END FOR
		}
		//END FOR

	}//End soryByJersey

	/**********************************************************
	* Method Name    : sortByName
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will use nested for loops
	*					to compare the names of player objects
	*					that are next to eachother in an array
	*					and places the the objects in lexical order
	*				    by creating a tempory object. This is
	*					considered bubble sorting.
	*
	* BEGIN sortByName
	* 	  FOR(As long as the array is not sorted)
	*		  FOR(Each element next to each other in the array)
	*			  IF(Player elements are not in lexically ascending order)
	*				  Store the player with the name that comes lexically last as a temporary player object
	*				  Shift the player with the name that comes lexically first up in the array
	*				  Shift the player with name that comes lexically last down in the array
	*			  END IF
	*		  END FOR
	*	  END FOR
	* END sortByName
    **********************************************************/

	public void sortByName()
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer;					//Represents a player object for temporary storage purposes

		/****************************************************/

		//FOR(As long as the array is not sorted)
		for(int i = 0; i < numPlayers; i++)
		{
			//FOR(Each element next to each other in the array)
			for(int j = i + 1; j < numPlayers; j++)
			{
				//IF(Player elements are not in lexically ascending order)
				if(players[i].getName().compareTo(players[j].getName()) > 0)
				{
					//Store the player with name that comes lexically last as a temporary player object
					tempPlayer = players[i];

					//Shift the player with name that comes lexically first up in the array
					players[i] = players[j];

					//Shift the player with name that comes lexically last down in the array
					players[j] = tempPlayer;
				}
				//END IF
			}
			//END FOR
		}
		//END FOR

	}//End soryByName

	/**********************************************************
	* Method Name    : toString
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will format the data of a
	*					player object to a string for output
	*					purposes.
	*
	* BEGIN toString
	* 	  Format string output of object
	*	  Return output
	* END toString
    **********************************************************/

	public String toString()
	{
		//local constants

		//local variables
		String output;					//The string output of our team object

		/****************************************************/

		output = "\n\n\n\n" + Util.setLeft(26, "Team  Name : ") + Util.setRight(15, "" + teamName) +
				"\n" + Util.setLeft(26, "Sport Name : ") + Util.setRight(15, "" + sportLeague) +
				"\n" + Util.setLeft(26, "Coach Name : ") + Util.setRight(15, "" + coachName) +
				"\n\n" + Util.setLeft(21, "Player Name           Position     Num") + "\n";
				for(int count = 1; count <= numPlayers; count ++)
					output += Util.setLeft(21, "" + players[count - 1]) + "\n";

				return output;

	}//End toString

}//End TeamInfo program

