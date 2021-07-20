var ballsIds = new Array();
var firstQuadrantBalls = [];
var secondQuadrantBalls = [];
var thirdQuadrantBalls = [];
var forthQuadrantBalls = [];
			
var path = new Array(); 

var quadrantBalls = [];

			
function createBallsPath(){

	// 00,01,02,03,04,05,06,07,08
	for(var ballId = 0; ballId < 9;ballId++)
		path[path.length] = "#0" + ballId;
	//  18,28,38,48,58,68,78
	for(var ballId = 1; ballId <= 7;ballId++)
		path[path.length] = '#' + ballId + "8";
	// 88,87,86,85,84,83,82,81,80,
	for(var ballId = 8; ballId >= 0;ballId--)
		path[path.length] = "#8" + ballId;
	// 70,60,50,40,30,20,10
	for(var ballId = 7; ballId >= 1;ballId--)
		path[path.length] = '#' + ballId + "0";
				
}
			
function moveBalls(){
                
	// Move First Quadrant Balls
    var nextId = -1;
    var quadrantLastId = firstQuadrantBalls[firstQuadrantBalls.length-1];
    var quadrantFirstId = firstQuadrantBalls[0];

    for(var idIndex = 0; idIndex < path.length;idIndex++){
                    
    	if( (idIndex < path.length-1) &&
        (quadrantLastId==path[idIndex])){
    		nextId = path[idIndex+1];
            break;
        }
        else if((idIndex == path.length-1) &&
        (quadrantLastId==path[idIndex])){
            nextId = path[0];
            break;
        }
    }

    if(nextId != -1){
    	if($(quadrantLastId).hasClass('color-one')){
    		$(nextId).addClass('color-one');
            $(quadrantFirstId).removeClass('color-one');
        }
        else if($(quadrantLastId).hasClass('color-two')){
             $(nextId).addClass('color-two');
             $(quadrantFirstId).removeClass('color-two');
        }

        for(var index = 0; index < firstQuadrantBalls.length-1;index++)
             firstQuadrantBalls[index] = firstQuadrantBalls[index+1];
        firstQuadrantBalls[firstQuadrantBalls.length-1] = nextId;
                
    }
        
                
    // Move Second Quadrant Balls
    nextId = -1;
    quadrantLastId = secondQuadrantBalls[secondQuadrantBalls.length-1];
    quadrantFirstId = secondQuadrantBalls[0];

    for(var idIndex = 0; idIndex < path.length;idIndex++){
                    
    	if( (idIndex < path.length-1) &&
        (quadrantLastId==path[idIndex])){
    		nextId = path[idIndex+1];
            break;
        }
        else if((idIndex == path.length-1) &&
        (quadrantLastId==path[idIndex])){
        	nextId = path[0];
            break;
        }
    }

                
    if($(quadrantLastId).hasClass('color-one')){
    	$(nextId).addClass('color-one');
        $(quadrantFirstId).removeClass('color-one');
    }
    else if($(quadrantLastId).hasClass('color-two')){
        $(nextId).addClass('color-two');
        $(quadrantFirstId).removeClass('color-two');
    }

    if(nextId != -1){
    	if($(quadrantLastId).hasClass('color-one')){
			$(nextId).addClass('color-one');
            $(quadrantFirstId).removeClass('color-one');
        }
        else if($(quadrantLastId).hasClass('color-two')){
            $(nextId).addClass('color-two');
            $(quadrantFirstId).removeClass('color-two');
        }

        for(var index = 0; index < secondQuadrantBalls.length-1;index++)
        	secondQuadrantBalls[index] = secondQuadrantBalls[index+1];
        secondQuadrantBalls[secondQuadrantBalls.length-1] = nextId;
                
    }

    // Move Third Quadrant Balls
    nextId = -1;
    quadrantLastId = thirdQuadrantBalls[0];
    quadrantFirstId = thirdQuadrantBalls[thirdQuadrantBalls.length-1];

    for(var idIndex = 0; idIndex < path.length;idIndex++){
                    
    	if( (idIndex < path.length-1) &&
        (quadrantLastId==path[idIndex])){
            nextId = path[idIndex+1];
            break;
        }
        else if((idIndex == path.length-1) &&
        (quadrantLastId==path[idIndex])){
            nextId = path[0];
            break;
        }
    }

                
    if($(quadrantLastId).hasClass('color-one')){
        $(nextId).addClass('color-one');
        $(quadrantFirstId).removeClass('color-one');
    }
    else if($(quadrantLastId).hasClass('color-two')){
        $(nextId).addClass('color-two');
        $(quadrantFirstId).removeClass('color-two');
    }

    if(nextId != -1){
		if($(quadrantLastId).hasClass('color-one')){
			$(nextId).addClass('color-one');
            $(quadrantFirstId).removeClass('color-one');
        }
        else if($(quadrantLastId).hasClass('color-two')){
            $(nextId).addClass('color-two');
            $(quadrantFirstId).removeClass('color-two');
        }

        for(var index = 0; index < thirdQuadrantBalls.length-1;index++)
            thirdQuadrantBalls[index] = thirdQuadrantBalls[index+1];
        thirdQuadrantBalls[thirdQuadrantBalls.length-1] = nextId;
                
    }
                
    // Move Forth Quadrant Balls
    nextId = -1;
    quadrantLastId = forthQuadrantBalls[0];
    quadrantFirstId = forthQuadrantBalls[forthQuadrantBalls.length-1];

    for(var idIndex = 0; idIndex < path.length;idIndex++){
                    
    	if( (idIndex < path.length-1) &&
        (quadrantLastId==path[idIndex])){
    		nextId = path[idIndex+1];
            break;
        }
        else if((idIndex == path.length-1) &&
        (quadrantLastId==path[idIndex])){
        	nextId = path[0];
            break;
        
        }
    }
                
    if($(quadrantLastId).hasClass('color-one')){
    	$(nextId).addClass('color-one');
        $(quadrantFirstId).removeClass('color-one');
    }
    else if($(quadrantLastId).hasClass('color-two')){
    	$(nextId).addClass('color-two');
        $(quadrantFirstId).removeClass('color-two');
    }
                
	if(nextId != -1){
		if($(quadrantLastId).hasClass('color-one')){
			$(nextId).addClass('color-one');
            $(quadrantFirstId).removeClass('color-one');
        }
        else if($(quadrantLastId).hasClass('color-two')){
        	$(nextId).addClass('color-two');
            $(quadrantFirstId).removeClass('color-two');
        }

        for(var index = 0; index < forthQuadrantBalls.length-1;index++)
        	forthQuadrantBalls[index] = forthQuadrantBalls[index+1];
        forthQuadrantBalls[forthQuadrantBalls.length-1] = nextId;
                
    }
				
    //console.log("***********************");
    //timer = setTimeout(moveBalls(),1000/*Math.random()*2000*/); 
}
            

function init(){
				
	for(var indexi = 0; indexi < 9;indexi++)
		for(var indexj = 0; indexj < 9;indexj++)
			ballsIds.push("#" + indexi + "" + indexj);
				
	createBallsPath();
				
	groupFirstQuadrantBalls();
	groupSecondQuadrantBalls();
	groupThirdQuadrantBalls();
	groupForthQuadrantBalls();
				
	shadeBalls();
				
	for(var index = 0; index < firstQuadrantBalls.length;index++)
		quadrantBalls[quadrantBalls.length] = firstQuadrantBalls[index];
	//moveBallsClockwise("topRight");
				
	quadrantBalls.slice(0);
	for(var index = 0; index < secondQuadrantBalls.length;index++)
		quadrantBalls[quadrantBalls.length] = secondQuadrantBalls[index];
	//moveBallsClockwise("topLeft");
				
	quadrantBalls.slice(0);
	for(var index = 0; index < thirdQuadrantBalls.length;index++)
		quadrantBalls[quadrantBalls.length] = thirdQuadrantBalls[index];
	//moveBallsClockwise("bottomLeft");
				
	quadrantBalls.slice(0);
	for(var index = 0; index < forthQuadrantBalls.length;index++)
		quadrantBalls[quadrantBalls.length] = forthQuadrantBalls[index];
    //moveBallsClockwise("bottomRight");
                
    moveBalls(); 
				
}

function moveBallsClockwise(flag){
				
	var nextLastBall;
	var nextLastIndex;
				
	var nextRow;
	var nextColumn;
				
	var currentRow = quadrantBalls[quadrantBalls.length-1].substring(1,2);
	var currentColumn = quadrantBalls[quadrantBalls.length-1].substring(2,3);
				
				
	if(parseInt(currentColumn)>0 && parseInt(currentRow)<=3){
					
		if(currentColumn==="1")
			nextColumn = "0";
		else if(currentColumn==="2")
			nextColumn = "1";
		else if(currentColumn==="3")
			nextColumn = "2";
		else if(currentColumn==="4")
			nextColumn = "3";
		else if(currentColumn==="5")
			nextColumn = "4";
		else if(currentColumn==="6")
			nextColumn = "5";
		else if(currentColumn==="7")
			nextColumn = "6";
		else
			nextColumn = "7";
					
					
		nextLastIndex = toIndex(currentRow,nextColumn);
		nextLastBall = ballsIds[nextLastIndex];
					
		$(quadrantBalls[0]).removeClass("color-one");
		quadrantBalls.slice(0,1);
					
		quadrantBalls[quadrantBalls.length] = nextLastBall;
		$(quadrantBalls[quadrantBalls.length-1]).addClass("color-one");
					
	}
	else if(parseInt(currentRow)<8 && Number(currentColumn)<=3){
					
		if(currentRow==="0")
			nextRow = "1";
		else if(currentRow==="1")
			nextRow = "2";
		else if(currentRow==="2")
			nextRow = "3";
		else if(currentRow==="3")
			nextRow = "4";
		else if(currentRow==="4")
			nextRow = "5";
		else if(currentRow==="5")
			nextRow = "6";
		else if(currentRow==="6")
			nextRow = "7";
		else
			nextRow = "8";
					
					
		nextLastIndex = toIndex(nextRow,currentColumn);
		nextLastBall = ballsIds[nextLastIndex];
					
		$(quadrantBalls[0]).removeClass("color-two");
		quadrantBalls.slice(0,1);
					
		quadrantBalls[quadrantBalls.length] = nextLastBall;
		$(quadrantBalls[quadrantBalls.length-1]).addClass("color-two");
	}
	else if(Number(currentColumn)<8 && parseInt(currentRow)>3){ 
					
		if(currentColumn==="0")
			nextColumn = "1";
		else if(currentColumn==="1")
			nextColumn = "2";
		else if(currentColumn==="2")
			nextColumn = "3";
		else if(currentColumn==="3")
			nextColumn = "4";
		else if(currentColumn==="4")
			nextColumn = "5";
		else if(currentColumn==="5")
			nextColumn = "6";
		else if(currentColumn==="6")
			nextColumn = "7";
		else
			nextColumn = "8";
					
					
		nextLastIndex = toIndex(currentRow,nextColumn);
		nextLastBall = ballsIds[nextLastIndex];
					
		$(quadrantBalls[0]).removeClass("color-one");
		quadrantBalls.slice(0,1);
					
		quadrantBalls[quadrantBalls.length] = nextLastBall;
		$(quadrantBalls[quadrantBalls.length-1]).addClass("color-one");
					
	}
	else{
		if(currentRow==="1")
			nextRow = "0";
		else if(currentRow==="2")
			nextRow = "1";
		else if(currentRow==="3")
			nextRow = "2";
		else if(currentRow==="4")
			nextRow = "3";
		else if(currentRow==="5")
			nextRow = "4";
		else if(currentRow==="6")
			nextRow = "5";
		else if(currentRow==="7")
			nextRow = "6";
		else
			nextRow = "7";
					
		nextLastIndex = toIndex(nextRow,currentColumn);
		nextLastBall = ballsIds[nextLastIndex];
					
		$(quadrantBalls[0]).removeClass("color-two");
		quadrantBalls.slice(0,1);
					
		quadrantBalls[quadrantBalls.length] = nextLastBall;
		$(quadrantBalls[quadrantBalls.length-1]).addClass("color-two");
	}
					
	quadrantBalls.slice(0);
				
	if(flag=="topRight"){
		for(var index = 0; index < firstQuadrantBalls.length;index++)
			quadrantBalls[quadrantBalls.length] = firstQuadrantBalls[index];
	}
	else if(flag=="topLeft"){
		for(var index = 0; index < secondQuadrantBalls.length;index++)
			quadrantBalls[quadrantBalls.length] = secondQuadrantBalls[index];
	}
	else if(flag=="bottomLeft"){
		for(var index = 0; index < thirdQuadrantBalls.length;index++)
			quadrantBalls[quadrantBalls.length] = thirdQuadrantBalls[index];
	}
	else{
		for(var index = 0; index < forthQuadrantBalls.length;index++)
			quadrantBalls[quadrantBalls.length] = forthQuadrantBalls[index];
	}
				
	setTimeout(moveBallsClockwise(flag),1000/*Math.random()*2000*/); 
					
}

function toIndex(row,column){
				
	for(var index = 0; index < ballsIds.length;index++)
		if(row==ballsIds[index].substring(1,2) && 
		column==ballsIds[index].substring(2,3))
			return index;
	return -1;
}

function shadeBalls(){
				
	switch(0/*parseInt(Math.random()*6)*/){
	case 0 : 
		shadeFirstQuadrantBalls("color-one");
		shadeSecondQuadrantBalls("color-two");
		shadeThirdQuadrantBalls("color-one");
		shadeForthQuadrantBalls("color-two");
		break;
	case 1 : 
		shadeFirstQuadrantBalls("color-one");
		shadeSecondQuadrantBalls("color-one");
		shadeThirdQuadrantBalls("color-two");
		shadeForthQuadrantBalls("color-two");
		break;
	case 2 : 
		shadeFirstQuadrantBalls("color-two");
		shadeSecondQuadrantBalls("color-one");
		shadeThirdQuadrantBalls("color-two");
		shadeForthQuadrantBalls("color-one");
		break;
	case 3 : 
		shadeFirstQuadrantBalls("color-one");
		shadeSecondQuadrantBalls("color-two");
		shadeThirdQuadrantBalls("color-two");
		shadeForthQuadrantBalls("color-one");
		break;
	case 4 : 
		shadeFirstQuadrantBalls("color-two");
		shadeSecondQuadrantBalls("color-one");
		shadeThirdQuadrantBalls("color-one");
		shadeForthQuadrantBalls("color-two");
		break;
	default : 
		shadeFirstQuadrantBalls("color-two");
		shadeSecondQuadrantBalls("color-two");
		shadeThirdQuadrantBalls("color-one");
		shadeForthQuadrantBalls("color-one");
	}
}

function groupFirstQuadrantBalls(){
				
	var index;
				
	for(index = 6; index <= 8; index++)
		firstQuadrantBalls[firstQuadrantBalls.length] = ballsIds[index];
	for(index = 17; index <= 26; index+=9)
		firstQuadrantBalls[firstQuadrantBalls.length] = ballsIds[index];
				
}

function shadeFirstQuadrantBalls(color){
				
	for(var index = 0; index < firstQuadrantBalls.length;index++)
		if(color=="color-two"){
			$(firstQuadrantBalls[index]).addClass("color-two");   
        }
		else if(color=="color-one")
			$(firstQuadrantBalls[index]).addClass("color-one");
}

function groupSecondQuadrantBalls(){
				
	var index;
				
	for(index = 18; index >= 9; index-=9)
		secondQuadrantBalls[secondQuadrantBalls.length] = ballsIds[index];
	for(index = 0; index <= 2; index++)
		secondQuadrantBalls[secondQuadrantBalls.length] = ballsIds[index];
				
}

function shadeSecondQuadrantBalls(color){
				
	for(var index = 0; index < secondQuadrantBalls.length;index++)
		if(color=="color-two")
			$(secondQuadrantBalls[index]).addClass("color-two");
		else if(color=="color-one")
			$(secondQuadrantBalls[index]).addClass("color-one");
}

function groupThirdQuadrantBalls(){
				
	var index;
				
	for(index = 74; index >= 73; index--)
		thirdQuadrantBalls[thirdQuadrantBalls.length] = ballsIds[index];
	for(index = 72; index >= 54; index-=9)
		thirdQuadrantBalls[thirdQuadrantBalls.length] = ballsIds[index];
				
}

function shadeThirdQuadrantBalls(color){
				
	for(var index = 0; index < thirdQuadrantBalls.length;index++)
		if(color=="color-two")
			$(thirdQuadrantBalls[index]).addClass("color-two");
		else if(color=="color-one")
			$(thirdQuadrantBalls[index]).addClass("color-one");
}

function groupForthQuadrantBalls(){
				
	var index;
				
	for(index = 62; index <= 80; index+=9)
		forthQuadrantBalls[forthQuadrantBalls.length] = ballsIds[index];
	for(index = 79; index >= 78; index--)
		forthQuadrantBalls[forthQuadrantBalls.length] = ballsIds[index];
				
}

function shadeForthQuadrantBalls(color){
				
	for(var index = 0; index < forthQuadrantBalls.length;index++)
		if(color=="color-two")
			$(forthQuadrantBalls[index]).addClass("color-two");
		else if(color=="color-one")
			$(forthQuadrantBalls[index]).addClass("color-one");
}