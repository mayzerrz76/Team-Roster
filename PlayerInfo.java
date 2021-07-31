/**********************************************************
* Program Name   : PlayerInfo
* Author         : Ryan May
* Due Date       : 05/12/2020
* Course/Section : CSC111-302
* Program Description: This program allows you to construct
*		objects that contain data about player information.
*		The program also formats the data of a player to string
*		data for output purposes. The program checks for a valid
*		jersey number.
*
* Methods:
* -------
* Constructor   -  Instantiates an obect of this class and initializes
*				    the instance data. Constructs a player object.
* getName 		-  Returns the name of a player
* getJerseyNum  -  Returns the jersey number of a player
* toString      -  Formats the objects data to a string output
**********************************************************/

public class PlayerInfo
{
	//class constants

	//class variables
	private String playerName;						//The name of a player
	private int jerseyNum;							//The players jersey number
	private String position;						//The players position

	/**********************************************************
	* Method Name    : PlayerInfo
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This is a constructor method that is used
	*					instantiate a playerinfo object that represents
	*					a player. Tis method takes the player name, position
	*					and jersey number and uses that data to initialize
	*					a player. This method checks to make sure the jersey
	*					number is in range, or it's set to 0.
	*
	* BEGIN PlayerInfo
	*	  Initialize the instance data
	*	  IF(Jersey number parameter in range)
	*	  	  Set jersey number to the jersey number passed in
	*	  END IF
	* END PlayerInfo
    **********************************************************/

	public PlayerInfo(String name, String pos, int jersNum)
	{
		//local constants
		final int MAX_JERSEY_NUM = 99;			//The maximum number that a player can have as a jersey number

		//local variables

		/****************************************************/

		//Initialize the instance data
		playerName = name;
		position = pos;
		jerseyNum = 0;

		//IF(Jersey number parameter is in range)
		if(jersNum >= 0 && jersNum <= MAX_JERSEY_NUM)

			//Set jersey number to the jersey number passed in
			jerseyNum = jersNum;

		//END IF

	}//End PlayerInfo

	/**********************************************************
	* Method Name    : getName
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will return the jersey number
	*					of a player object.
	*
	* BEGIN getJerseyNum
	*	  Return jersey number
	* END getJerseyNum
    **********************************************************/

	public String getName()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return player name
		return playerName;

	}//End getName

	/**********************************************************
	* Method Name    : getJerseyNum
	* Author         : Ryan May
	* Due Date       : 05/12/2020
	* Course/Section : CSC111-302
	* Program Description: This method will return the jersey number
	*					of a player object.
	*
	* BEGIN getJerseyNum
	*	  Return jersey number
	* END getJerseyNum
    **********************************************************/

	public int getJerseyNum()
	{
		//local constants

		//local variables

		/****************************************************/

		//Return jersey number
		return jerseyNum;

	}//End getJerseyNum

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
		String output; 					//String output of our object

		/****************************************************/

		//Format string output of our object
		output = "" + playerName + Util.setLeft(2, "" + position) +
				Util.setRight(6, "" + jerseyNum);

		//Return Output
		return output;

	}//End toString

}//End PlayerInfo program