var imageArray; // global variable that holds a list of available animal images
var labelArray; // global variable that holds a list of available animal names (matches images by array index)
var gameLevel = 1; 
var displayedAnimalsArray; // keeps track of which animals are dislpayed for 5 seconds
var intervalCounter = 0; // time counter value (used to hide images after 5 seconds)
var intervalObj = null; // time counter/interval object
var strikeCount = 0;
var msgbox = new Notification();

//************************************************************************************************************************
// Function:  	loadGlobalArrays
// Description:	Defines two lists - a list of available animal images, stored in imageArray and a list of labels (names)
//					for available animal images, stored in labelArray.  The two arrays correspond to each other by index.
//					This should really be done better with XML.
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function loadGlobalArrays(){
	imageArray = new Array(20);
	labelArray = new Array(20);
	
	imageArray[0] = "images/cartoons/cat.jpg";
	labelArray[0] = "Cat";
	
	imageArray[1] = "images/cartoons/dog.jpg";
	labelArray[1] = "Dog";
	
	imageArray[2] = "images/cartoons/pig.jpg";
	labelArray[2] = "Pig";
	
	imageArray[3] = "images/cartoons/bear.jpg";
	labelArray[3] = "Bear";
	
	imageArray[4] = "images/cartoons/cow.jpg";
	labelArray[4] = "Cow";
	
	imageArray[5] = "images/cartoons/bird.jpg";
	labelArray[5] = "Bird";
	
	imageArray[6] = "images/cartoons/lion.jpg";
	labelArray[6] = "Lion";

	imageArray[7] = "images/cartoons/butterfly.jpg";
	labelArray[7] = "Butterfly";
	
	imageArray[8] = "images/cartoons/crocodile.jpg";
	labelArray[8] = "Crocodile";
	
	imageArray[9] = "images/cartoons/donkey.jpg";
	labelArray[9] = "Donkey";
	
	imageArray[10] = "images/cartoons/elephant.jpg";
	labelArray[10] = "Elephant";
	
	imageArray[11] = "images/cartoons/fish.jpg";
	labelArray[11] = "Fish";
	
	imageArray[12] = "images/cartoons/giraffe.jpg";
	labelArray[12] = "Giraffe";
	
	imageArray[13] = "images/cartoons/hippo.jpg";
	labelArray[13] = "Hippo";
	
	imageArray[14] = "images/cartoons/horse.jpg";
	labelArray[14] = "Horse";
	
	imageArray[15] = "images/cartoons/mouse.jpg";
	labelArray[15] = "Mouse";
	
	imageArray[16] = "images/cartoons/octopus.jpg";
	labelArray[16] = "Octopus";
	
	imageArray[17] = "images/cartoons/rhino.jpg";
	labelArray[17] = "Rhino";
	
	imageArray[18] = "images/cartoons/tiger.jpg";
	labelArray[18] = "Tiger";
	
	imageArray[19] = "images/cartoons/zebra.jpg";
	labelArray[19] = "Zebra";

}


//************************************************************************************************************************
// Function:  	showMemImages
// Description:	Displays x-number of images based on the game level.  Uses random function to select random images from
//					the list of available animal pictures.  Sets a 5-second interval to show images for only 5 seconds.
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************

function showMemImages(){
	window.clearInterval(intervalObj); // clear existing intervals if user runs the game multiple times in a row.
	document.getElementById("answerList").style.display = "none"; // hide "answer" selector
	var i = 0; 
	var rand = 0; // initialize random image selection
	displayedAnimalsArray = new Array(); // initialize array for images that are shown to users
	
	// loop through images that are available for selected level (three images per level)
	for(i=0;i<(gameLevel * 3);i++){ 
		rand = getRandom(); // get random value between 0 and number of available images
		document.images["q_image_" + (i+1)].src = imageArray[rand];	 // display image
		displayedAnimalsArray[i] = rand; // save randomly selected image in array
	}
	intervalObj = window.setInterval("testMemory()", 1000); // set interval (to count out 5 seconds)
}


//************************************************************************************************************************
// Function:  	testMemory
// Description:	This function is called by setInterval() every second.  Once interval counter reaches 5 seconds, 
//					hide all displayed images and display a list of available animals (answer list) so that user 
//					can select animals that he/she saw on the screen.
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function testMemory(){
	intervalCounter = intervalCounter + 1; // increment interval counter
	updateTimer(); // display updated counter value (currently unused)
	if(intervalCounter == 5){ // once interval counter reaches 5 seconds, hide all images
		hideMemImages(); // hide images
		displayAvailableAnimals(); // display list of possible answers
		intervalCounter = 0; // reset counter
		window.clearInterval(intervalObj); // reset interval
	}
}


//************************************************************************************************************************
// Function:  	displayAvailableAnimals
// Description:	This function displays a list of all available animals.  User can select animals (answer choices)
//					by clicking on links.
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function displayAvailableAnimals(){
	var i = 0;
	var lst = ""; // initialize animal list
	var div = document.getElementById("answerList");
	if(div){
		div.style.display = "block"; // show div that contains list of animals
		
		// loop through label array and concatinate answer list
		for(i=0;i<labelArray.length;i++){ 
			if(lst == ""){
				lst = "<a href='javascript:checkAnimalSelection(" + i + ");'>" + labelArray[i] + "</a>";
			}
			else{
				lst = lst + ", " + "<a href='javascript:checkAnimalSelection(" + i + ");'>" + labelArray[i] + "</a>";
			}
		}
		div.innerHTML = "<b>Which animals did you see?</b><br /><i>(click to select)</i><br /><br />" + lst;
	}
}

//************************************************************************************************************************
// Function:  	checkAnimalSelection
// Description:	When user clicks on an animal name, this function compares the index of the animal selected by user
//					with the array of animals that were displayed on screen.  If they match, replaces "question mark"
//					image with the image of animal.  If selection is incorrect (animal was not initially displayed),
//					throws an error message.
// Arguments:	idx (index from the labelArray)
// Return Val: 	None
//************************************************************************************************************************
function checkAnimalSelection(idx){
	var i = 0;
	var tmp = "";
	var isCorrectSelection = false; // boolean variable that tracks whether or not image was displayed
	
	// loop through images that were displayed on screen
	for(i=0;i<displayedAnimalsArray.length;i++){
		if(displayedAnimalsArray[i] == idx){ // if image matches user selection
			document.images["q_image_" + (i+1)].src = imageArray[idx];
			isCorrectSelection = true;
		}		
	}
	
	// if no images matched user selections
	if(!isCorrectSelection){
		tmp = new String(labelArray[idx]);
		tmp = tmp.toLowerCase();
		strikeCount = strikeCount + 1;
		displayStrikeMessage(tmp);
		if(strikeCount == 3){
			hideMemImages();	
			document.getElementById("answerList").style.display = "none";
			strikeCount = 0;
		}
		//alert("I don't think you actually saw a " + tmp + ".  Maybe you should try again!", null, "Wrong!!!");
	}

}


//************************************************************************************************************************
// Function:  	hideMemImages
// Description:	Hide all animal images
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function hideMemImages(){
	var i = 0;
	for(i=0;i<(gameLevel*3);i++){
		document.images["q_image_" + (i+1)].src = "images/question_mark.jpg";	
	}
}


//************************************************************************************************************************
// Function:  	getRandom
// Description:	Gets a random number between 0 and the number of available animals.  Uses recursion to prevent
//					duplication.
// Arguments:	None
// Return Val: 	ranNum - random number
//************************************************************************************************************************
function getRandom()
{
	var uBound = imageArray.length - 1 // get a count of available animals
    var ranNum= Math.floor(Math.random()*uBound); // generate random number
    if(checkRandomDuplicate(ranNum)){ // check if this number (animal) has already been selected by random generator
    	return getRandom(); // number already exists, function calls itself again
    }
    else{
	    return ranNum;
    }
}


//************************************************************************************************************************
// Function:  	checkRandomDuplicate
// Description:	Checks if a random number (animal) has already been selected by random generator
// Arguments:	randNum - random number
// Return Val: 	true or false
//************************************************************************************************************************
function checkRandomDuplicate(randNum){
	var i = 0;
	var retVal = false;
	// loop through displayed animal and see if this animal has already been randomly selected.
	for(i=0;i<displayedAnimalsArray.length;i++){
		if(displayedAnimalsArray[i] == randNum){
			retVal = true;	
		}
	}
	return retVal;
}


//************************************************************************************************************************
// Function:  	changeGameLevel
// Description:	Updates game level (between 1 and 3) when user clicks "Proceed to Level x..." button
// Arguments:	btn - button that was clicked to change game level
// Return Val: 	None
//************************************************************************************************************************
function changeGameLevel(btn){
	if(btn){
		window.clearInterval(intervalObj); // clear interval (5-second counter) if user changes game level
		hideMemImages(); // hide all images
		document.getElementById("answerList").style.display = "none"; // hide answer list
		
		// Update game level based on current game level
		switch(gameLevel){
			case 1:
				gameLevel = gameLevel + 1;
				break;
			case 2:	
				gameLevel = gameLevel + 1;
				break;
			case 3:
				gameLevel = 1;
				break;
		}
		
		// Display image blocks appropriate for selected level
		showCurrentGameLevels();
		
		// Update "change level" button text based on the new game level value
		switch(gameLevel){
			case 1:
				btn.value = "Proceed to Level 2";
				break;
			case 2:	
				btn.value = "Proceed to Level 3";
				break;
			case 3:
				btn.value = "Return to Level 1";
				break;
		}
		
		// Display current game level in the header
		updateGameHeader(); // update
		
	}	
}


//************************************************************************************************************************
// Function:  	showCurrentGameLevels
// Description:	Displays image blocks appropriate for selected level
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function showCurrentGameLevels(){
	var i = 0;
	
	// first, hide all game level image blocks
	for(i=1;i<=3;i++){
		document.getElementById("gameLevel" + i).style.display = "none";
	}

	// displays image blocks appropriate for selected level
	for(i=1;i<=gameLevel;i++){
		document.getElementById("gameLevel" + i).style.display = "block";
	}
}


//************************************************************************************************************************
// Function:  	updateGameHeader
// Description:	Updates header text with selected game level
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function updateGameHeader(){
	document.getElementById("displayHeader").innerHTML = "HOW GOOD IS YOUR MEMORY?<br />LEVEL " + gameLevel;	
}


//************************************************************************************************************************
// Function:  	updateTimer
// Description:	Updates counter display (ticks off seconds before images dissapear)  [CURRENTLY UNUSED]
// Arguments:	None
// Return Val: 	None
//************************************************************************************************************************
function updateTimer(){
	//document.getElementById("displayTimerValue").innerHTML = intervalCounter;
}

function displayHelpMessage(){
	var msg = "<center>Click the 'Test My Memory' button at the bottom of the screen.  The boxes marked with question marks will be replaced with images. ";
	msg = msg + "<br /><br />You will have five seconds to memorize the animals displayed on the screen.  After 5 seconds images will dissapear and you will be presented with a list of animal names. ";
	msg = msg + "You will need to select correct animals from the list. <br /><br />This game allows 3 mistakes.  Once 3 mistakes have been made, the game will be restarted. ";
	msg = msg + "<br /><br />If you would like to challenge yourself, chose a higher level by clicking the 'Progress to Level...' button.";
	msg = msg + "<br /><br /><input type='button' class='navButtons' value='OK' name='btnOK' id='btnOK' onclick='hideHelpMessage();' /></center>";
	msgbox.showCenterMessage(msg);	
}

function displayStrikeMessage(animalName){
	var msg = "";
	if(strikeCount == 3){
		msg = "<center>I don't think you actually saw a " + animalName + " - that's <b>STRIKE " + strikeCount + "</b>.  START OVER!!!";
	}
	else{
		msg = "<center>I don't think you actually saw a " + animalName + " - that's <b>STRIKE " + strikeCount + "</b>.  Maybe you should try again!";
	}
	msg = msg + "<br /><br /><input type='button' class='navButtons' value='OK' name='btnOK' id='btnOK' onclick='hideHelpMessage();' /></center>";
	msgbox.showCenterMessage(msg);	
}

function hideHelpMessage(){
	msgbox.hideCenterMessage();	
}

window.onload = function(){
	loadGlobalArrays();
	showCurrentGameLevels();
	updateGameHeader();
}



