//***********************************************************************************************************
//Class:        Notification
//Parameters:   None
//Description:  This class is an alternative to javascript "confirm" message prompt.  It displays (and hides)
//              a program-generated message by creating two layers.  The first layer is semi-transparent;
//              it overlays an existing web page and prevents user from clicking on any of the page controls
//              while the message is active/visible.
//              The second layer contains the message itself, plus any HTML elements that are passed within
//              the message string.
//***********************************************************************************************************
function Notification(){
    this.displayWidth = 600;  /* width of the message layer, set to 600px by default */
    this.displayHeight = 0;   /* height of the message layer, if set to 0, the layer will 
                                    auto-resize to the length of the message. */
    this.displayTopPosition = 100;  /* specifies how far from the top of the browser window the message 
                                        should be displayed. */
    this.overlayBackgroundColor = "#3c3c3c";  /* background color for the overlay layer (first layer) */
    this.messageBackgroundColor = "#ffffff";  /* background color for the message layer (second layer) */
    this.messageBorderColor = "#000000";  /* border color for the message layer (second layer) */
    
       
    //***********************************************************************************************************
    //Method:       showCenterMessage
    //Parameters:   msg (String) - contains message text
    //Description:  Creates two layers - an overlay layer and a message layer.  See 
    //              class description above for more details
    //***********************************************************************************************************    
    this.showCenterMessage = function(msg){
        /* Get "body" element and retrieve current page's width and height information */
        var body = document.getElementsByTagName('body').item(0);
        var bodyHeight = body.offsetHeight + 50;
        var bodyWidth = body.offsetWidth;
        if(bodyHeight < 3000){
            bodyHeight = 3000;
        }
        
        /* Create a semi-transparent overlay layer */
        var overlayDiv = document.createElement('div');
        overlayDiv.id = 'center-message-overlay';
        overlayDiv.style.position = "absolute";
        overlayDiv.style.opacity = ".75"; /* opacity settings for FireFox and Safari */
        overlayDiv.style.filter = "alpha(opacity=75)"; /* opacity settings for Internet Explorer */
        overlayDiv.style.width = bodyWidth + "px";
        overlayDiv.style.height = bodyHeight + "px";
        overlayDiv.style.backgroundColor = this.overlayBackgroundColor;
        overlayDiv.style.left = "0px";
        overlayDiv.style.top = "0px";
        body.appendChild(overlayDiv);
        
        
        /* Create message layer */
        var msgDiv = document.createElement('div');
        msgDiv.id = "center-message";
        msgDiv.style.position = "absolute";
        msgDiv.style.width = this.displayWidth + "px";
        if(this.displayHeight != 0){ /* if displayHeight property is not set, let the layer auto-resize */
            msgDiv.style.height = this.displayHeight + "px";
        }
        msgDiv.style.backgroundColor = this.messageBackgroundColor;
        msgDiv.style.border = "solid 2px " + this.messageBorderColor;
        msgDiv.style.opacity = "100"; /* opacity settings for FireFox and Safari */
        msgDiv.style.filter = "alpha(opacity=100)"; /* opacity settings for Internet Explorer */
        msgDiv.style.left = ((bodyWidth / 2) - (this.displayWidth / 2)) + "px";
        msgDiv.style.top = this.displayTopPosition + "px";
        msgDiv.style.padding = "20px 20px 20px 20px";
        msgDiv.style.fontSize = "13px";
        msgDiv.innerHTML = msg;
        body.appendChild(msgDiv);
                
    }
    
    //***********************************************************************************************************
    //Method:       hideCenterMessage
    //Parameters:   None
    //Description:  Hides both the overlay and the message layers
    //*********************************************************************************************************** 
    this.hideCenterMessage = function(){
    	var body = document.getElementsByTagName('body').item(0);
        var overlayDiv = document.getElementById('center-message-overlay');
        var msgDiv = document.getElementById('center-message');
        if(msgDiv){ /* hide message layer */
            msgDiv.style.visible = "none";
            msgDiv.style.display = "none";
            body.removeChild(msgDiv);
        }
        
        if(overlayDiv){ /* hide overlay layer */
            overlayDiv.style.visible = "none";
            overlayDiv.style.display = "none";
            body.removeChild(overlayDiv);
        }
        
    }
}