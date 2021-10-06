const canvas = document.querySelector("canvas");
canvas.width = innerWidth;
canvas.height = innerHeight;
const context = canvas.getContext('2d');

function createRhythm(){

    var numberOfClaps = 100 + parseInt(Math.random()*100);
    var rhythm = [];
    var sum = 0;

    for(var clapIndex = 0; clapIndex < numberOfClaps;clapIndex++){
        sum += Math.random()*3;
        rhythm[clapIndex] = sum;
    }

    return rhythm;

}

class MinuteStick{ 
    constructor(direction,origin,length,color,forwardSteps,backwardSteps,numberOfAnswers){
        this.origin = origin;
        this.length = length;
        this.setDirection(direction);
        this.color = color;

        this.status = 'stationary';
        this.initialDirection = direction;

        this.originalForwardSteps = forwardSteps;
        this.originalBackwardSteps = backwardSteps;
        this.forwardSteps = forwardSteps;
        this.backwardSteps = backwardSteps;

        this.xTo = origin.x;
        this.yTo = origin.y;

        this.movingStrategy = this.createMovingStrategy(parseInt(Math.random()*12),forwardSteps,backwardSteps,numberOfAnswers);
    }

    setDirection(direction){
        this.direction = direction;
        switch(direction){
            case 1: this.angle = 10*Math.PI/6; this.prevDirection = 12;this.nextDirection=2;break;
            case 2 : this.angle = 11*Math.PI/6; this.prevDirection = 1;this.nextDirection=3;break;
            case 3 : this.angle = 12*Math.PI/6; this.prevDirection = 2;this.nextDirection=4;break;
            case 4 : this.angle = Math.PI/6; this.prevDirection = 3;this.nextDirection=5;break;
            case 5 : this.angle = 2*Math.PI/6; this.prevDirection = 4;this.nextDirection=6;break;
            case 6 : this.angle = 3*Math.PI/6; this.prevDirection = 5;this.nextDirection=7;break;
            case 7 : this.angle = 4*Math.PI/6; this.prevDirection = 6;this.nextDirection=8;break;
            case 8 : this.angle = 5*Math.PI/6; this.prevDirection = 7;this.nextDirection=9;break;
            case 9 : this.angle = 6*Math.PI/6; this.prevDirection = 8;this.nextDirection=10;break;
            case 10 : this.angle = 7*Math.PI/6; this.prevDirection = 9;this.nextDirection=11;break;
            case 11 : this.angle = 8*Math.PI/6; this.prevDirection = 10;this.nextDirection=12;break;
            case 12 : this.angle = 9*Math.PI/6; this.prevDirection = 11;this.nextDirection=1;
        }

        
        
    }

    findFollowingDirection(){
        if(this.status=='moving forward' && this.forwardSteps>0)
            return this.nextDirection;
        else if(this.status=='moving backward' && this.backwardSteps>0)
            return this.prevDirection;
        else
            return this.direction;
    }

    update(){
        
        // Minute stick is going forward.
        if(this.status=='moving forward' && this.forwardSteps>0){
            this.setDirection(this.findFollowingDirection()); // Set using direction not findFollowingDirection.
            this.forwardSteps--;
        }
        // Minute stick has finished going forward.
        else if(this.forwardSteps==0 && this.backwardSteps>0){
            this.status='moving backward';
        }

        // Minute stick is going backwards.
        if(this.status=='moving backward' && this.backwardSteps>0){
            this.setDirection(this.findFollowingDirection());
            this.backwardSteps--;
            
        }
        // Minute stick has finished going backwards.
        else if(this.backwardSteps==0 && this.forwardSteps==0){
            this.forwardSteps = this.originalForwardSteps;
            this.backwardSteps = this.originalBackwardSteps;

            // Once a stick has finished going forwad and then backward, it should start over again.
            if(this.forwardSteps>0){
                this.status='moving forward';
                this.setDirection(this.findFollowingDirection());
                this.forwardSteps--;
                
            }
            // Perheps the stick is only going backwards.
            else{
                this.status='moving backward';
                this.setDirection(this.findFollowingDirection());
                this.backwardSteps--;
                
            }

        }
    }

    drawStick(){
        
        context.beginPath();
        context.moveTo(this.origin.x,this.origin.y);

        context.lineTo(this.xTo,this.yTo);
    
        context.strokeStyle = this.color;
        context.lineWidth = 10;
        context.stroke();

        context.moveTo(this.xTo,this.yTo);
        context.fillStyle = 'green'; 
        context.arc(this.xTo,this.yTo,20,0,Math.PI*2,true);
        context.fill();
        
    }

    createMovingStrategy(currentDirectionIndex,forwardSteps,backwardSteps,numberOfAnswers){

        const directions = [1,2,3,4,5,6,7,8,9,10,11,12];
        var answers = [];

        var fSteps;
        var bSteps;

        while(numberOfAnswers>0){
            fSteps = forwardSteps;
            bSteps = backwardSteps;
            while(fSteps>0){
                
                if(numberOfAnswers>0){
                    answers.push(new Answer(directions[currentDirectionIndex%12]));
                    numberOfAnswers--;
                    fSteps--;
                    currentDirectionIndex++;
                    
                }
                else
                    break;
                
            }

            while(bSteps>0){
                
                if(currentDirectionIndex==-1)
                    currentDirectionIndex = 11;

                if(numberOfAnswers>0){
                    answers.push(new Answer(directions[currentDirectionIndex%12]));
                    numberOfAnswers--;
                    currentDirectionIndex--;
                    bSteps--;
                    
                }
                else
                    break;
                
            }
        }
    
        return answers;
    }
}

class HourStick{
    constructor(minuteStick,direction,color){
        this.minuteStick = minuteStick;
        this.origin = minuteStick.origin;
        this.length = minuteStick.length/1.5;
        this.setDirection(direction);
        this.color = color;

        this.status=='stationary';

        this.xTo = origin.x;
        this.yTo = origin.y;

        this.movingStrategy = this.createMovingStrategy(parseInt(Math.random()*12));
    }

    createMovingStrategy(currentDirectionIndex){

        if(currentDirectionIndex==1)
            return [1,2,3,4,5,6,7,8,9,10,11,12];
        else if(currentDirectionIndex==2)
            return [2,3,4,5,6,7,8,9,10,11,12,1];
        else if(currentDirectionIndex==3)
            return [3,4,5,6,7,8,9,10,11,12,1,2];
        else if(currentDirectionIndex==4)
            return [4,5,6,7,8,9,10,11,12,1,2,3];
        else if(currentDirectionIndex==5)
            return [5,6,7,8,9,10,11,12,1,2,3,4];
        else if(currentDirectionIndex==6)
            return [6,7,8,9,10,11,12,1,2,3,4,5];
        else if(currentDirectionIndex==7)
            return [7,8,9,10,11,12,1,2,3,4,5,6];
        else if(currentDirectionIndex==8)
            return [8,9,10,11,12,1,2,3,4,5,6,7];
        else if(currentDirectionIndex==9)
            return [9,10,11,12,1,2,3,4,5,6,7,8];
        else if(currentDirectionIndex==10)
            return [10,11,12,1,2,3,4,5,6,7,8,9];
        else if(currentDirectionIndex==11)
            return [11,12,1,2,3,4,5,6,7,8,9,10];
        else
            return [12,1,2,3,4,5,6,7,8,9,10,11];

    }

    setDirection(direction){
        this.direction = direction;
        switch(direction){
            case 1: this.angle = 10*Math.PI/6; this.prevDirection = 12;this.nextDirection=2;break;
            case 2 : this.angle = 11*Math.PI/6; this.prevDirection = 1;this.nextDirection=3;break;
            case 3 : this.angle = 12*Math.PI/6; this.prevDirection = 2;this.nextDirection=4;break;
            case 4 : this.angle = Math.PI/6; this.prevDirection = 3;this.nextDirection=5;break;
            case 5 : this.angle = 2*Math.PI/6; this.prevDirection = 4;this.nextDirection=6;break;
            case 6 : this.angle = 3*Math.PI/6; this.prevDirection = 5;this.nextDirection=7;break;
            case 7 : this.angle = 4*Math.PI/6; this.prevDirection = 6;this.nextDirection=8;break;
            case 8 : this.angle = 5*Math.PI/6; this.prevDirection = 7;this.nextDirection=9;break;
            case 9 : this.angle = 6*Math.PI/6; this.prevDirection = 8;this.nextDirection=10;break;
            case 10 : this.angle = 7*Math.PI/6; this.prevDirection = 9;this.nextDirection=11;break;
            case 11 : this.angle = 8*Math.PI/6; this.prevDirection = 10;this.nextDirection=12;break;
            case 12 : this.angle = 9*Math.PI/6; this.prevDirection = 11;this.nextDirection=1;
        }
    }

    findFollowingDirection(){
        if(this.status=='moving forward' && this.minuteStick.direction==12)
            return this.nextDirection;
        else if(this.status=='moving backward' && this.minuteStick.direction==12)
            return this.prevDirection;
        else
            return this.direction;
    }

    update(){
        
        this.setDirection(this.findFollowingDirection());
    }


    drawStick(){
        context.beginPath();
        context.moveTo(this.origin.x,this.origin.y);

        context.lineTo(this.xTo,this.yTo);
    
        context.strokeStyle = this.color;
        context.lineWidth = 10;
        context.stroke();

        context.moveTo(this.xTo,this.yTo);
        context.fillStyle = 'blue'; 
        context.arc(this.xTo,this.yTo,20,0,Math.PI*2,true);
        context.fill();
    }
}

class Clock{
    constructor(origin,minuteStick,hourStick){
        this.minuteStick = minuteStick;
        this.hourStick = hourStick;
        this.origin = origin;
    }

    update(){
        this.minuteStick.update();
        this.hourStick.update();
    }

    drawClock(){
        context.beginPath();

        // Draw origin.
        context.arc(this.origin.x,this.origin.y,20,0,Math.PI*2,true);
        context.fillStyle = this.origin.color;
        context.fill();
        
        context.moveTo(this.origin.x+this.minuteStick.length+10,this.origin.y);
        
        // Draw clock circle.
        context.arc(this.origin.x,this.origin.y,this.minuteStick.length+10,0,Math.PI*2,true);
        context.strokeStyle = 'white';
        context.stroke();

        context.moveTo(this.origin.x+this.minuteStick.length+20,this.origin.y);

        context.fillText('A',
        this.origin.x + (this.minuteStick.length+50)*Math.cos(10*Math.PI/6),
        this.origin.y + (this.minuteStick.length+50)*Math.sin(10*Math.PI/6),
        10);
        context.fillText('1',
        this.origin.x + (this.minuteStick.length+30)*Math.cos(10*Math.PI/6),
        this.origin.y + (this.minuteStick.length+30)*Math.sin(10*Math.PI/6),
        10);

        context.fillText('B',
        this.origin.x + (this.minuteStick.length+50)*Math.cos(11*Math.PI/6),
        this.origin.y + (this.minuteStick.length+50)*Math.sin(11*Math.PI/6),
        10);
        context.fillText('2',
        this.origin.x + (this.minuteStick.length+30)*Math.cos(11*Math.PI/6),
        this.origin.y + (this.minuteStick.length+30)*Math.sin(11*Math.PI/6),
        10);

        context.fillText('C',
        this.origin.x + (this.minuteStick.length+50)*Math.cos(12*Math.PI/6),
        this.origin.y + (this.minuteStick.length+50)*Math.sin(12*Math.PI/6),
        10);
        context.fillText('3',
        this.origin.x + (this.minuteStick.length+30)*Math.cos(12*Math.PI/6),
        this.origin.y + (this.minuteStick.length+30)*Math.sin(12*Math.PI/6),
        10);

        context.fillText('D',
        this.origin.x + (this.minuteStick.length+50)*Math.cos(Math.PI/6),
        this.origin.y + (this.minuteStick.length+50)*Math.sin(Math.PI/6),
        10);
        context.fillText('4',
        this.origin.x + (this.minuteStick.length+30)*Math.cos(Math.PI/6),
        this.origin.y + (this.minuteStick.length+30)*Math.sin(Math.PI/6),
        10);

        context.fillText('E',
        this.origin.x + (this.minuteStick.length+60)*Math.cos(2*Math.PI/6),
        this.origin.y + (this.minuteStick.length+60)*Math.sin(2*Math.PI/6),
        10);
        context.fillText('5',
        this.origin.x + (this.minuteStick.length+40)*Math.cos(2*Math.PI/6),
        this.origin.y + (this.minuteStick.length+40)*Math.sin(2*Math.PI/6),
        10);

        context.fillText('F',
        this.origin.x + (this.minuteStick.length+60)*Math.cos(3*Math.PI/6),
        this.origin.y + (this.minuteStick.length+60)*Math.sin(3*Math.PI/6),
        10);
        context.fillText('6',
        this.origin.x + (this.minuteStick.length+40)*Math.cos(3*Math.PI/6),
        this.origin.y + (this.minuteStick.length+40)*Math.sin(3*Math.PI/6),
        10);

        context.fillText('G',
        this.origin.x + (this.minuteStick.length+60)*Math.cos(4*Math.PI/6),
        this.origin.y + (this.minuteStick.length+60)*Math.sin(4*Math.PI/6),
        10);
        context.fillText('7',
        this.origin.x + (this.minuteStick.length+40)*Math.cos(4*Math.PI/6),
        this.origin.y + (this.minuteStick.length+40)*Math.sin(4*Math.PI/6),
        10);

        context.fillText('H',
        this.origin.x + (this.minuteStick.length+60)*Math.cos(5*Math.PI/6),
        this.origin.y + (this.minuteStick.length+60)*Math.sin(5*Math.PI/6),
        10);
        context.fillText('8',
        this.origin.x + (this.minuteStick.length+40)*Math.cos(5*Math.PI/6),
        this.origin.y + (this.minuteStick.length+40)*Math.sin(5*Math.PI/6),
        10);

        context.fillText('I',
        this.origin.x + (this.minuteStick.length+60)*Math.cos(Math.PI),
        this.origin.y + (this.minuteStick.length+60)*Math.sin(Math.PI),
        10);
        context.fillText('9',
        this.origin.x + (this.minuteStick.length+40)*Math.cos(Math.PI),
        this.origin.y + (this.minuteStick.length+40)*Math.sin(Math.PI),
        10);

        context.fillText('J',
        this.origin.x + (this.minuteStick.length+60)*Math.cos(7*Math.PI/6),
        this.origin.y + (this.minuteStick.length+60)*Math.sin(7*Math.PI/6),
        10);
        context.fillText('10',
        this.origin.x + (this.minuteStick.length+40)*Math.cos(7*Math.PI/6),
        this.origin.y + (this.minuteStick.length+40)*Math.sin(7*Math.PI/6),
        10);

        context.fillText('K',
        this.origin.x + (this.minuteStick.length+50)*Math.cos(8*Math.PI/6),
        this.origin.y + (this.minuteStick.length+50)*Math.sin(8*Math.PI/6),
        10);
        context.fillText('11',
        this.origin.x + (this.minuteStick.length+30)*Math.cos(8*Math.PI/6),
        this.origin.y + (this.minuteStick.length+30)*Math.sin(8*Math.PI/6),
        10);

        context.fillText('L',
        this.origin.x + (this.minuteStick.length+50)*Math.cos(9*Math.PI/6),
        this.origin.y + (this.minuteStick.length+50)*Math.sin(9*Math.PI/6),
        10);
        context.fillText('12',
        this.origin.x + (this.minuteStick.length+30)*Math.cos(9*Math.PI/6),
        this.origin.y + (this.minuteStick.length+30)*Math.sin(9*Math.PI/6),
        10);

        this.minuteStick.drawStick();
        this.hourStick.drawStick();

    }
}


class Game{

    constructor(player,clock,rhythm){
        this.player = player;
        this.clock = clock;
        this.rhythm = rhythm;
        
    }

    drawGame(){
        this.clock.drawClock();
    }

    update(){
        this.clock.update();

    }
}

class Player{
    constructor(){
        this.hasAnswered = true;
        this.isAlive = true;
        this.answers = [];
    
    }

    addAnswer(answer){
        this.answers.push(answer);
    }

    stillAlive(){

    }
}

class Answer{
    constructor(answer){
        this.answer = answer;
    }

    equal(answer){
        return answer==this.answers[this.correctAnswerIndex];
    }

}

const rhythm = createRhythm();
const origin = {x:canvas.width/2,y:canvas.height/2,color:'white'};

const minuteStickLength = (origin.x<origin.y)?canvas.width/2.7:canvas.height/2.7;
const minuteForwardSteps = 1;
const minuteBackwardSteps = 0;
const minute = new MinuteStick(12,origin,minuteStickLength,'white',minuteForwardSteps,minuteBackwardSteps,rhythm.length);

const hour = new HourStick(minute,12,'white');

const clock = new Clock(origin,minute,hour);
const player = new Player();

const game = new Game(player,clock,rhythm);

animate();
moveSticks(game);

function moveSticks(game){

    game.clock.minuteStick.status = 'moving forward';
    game.clock.hourStick.status = 'moving forward';
    

    for(var clapIndex = 0; clapIndex  <game.rhythm.length;clapIndex++){
        
		var minuteStickTimeline = 
			gsap.timeline(
			{
				defaults: {
					duration:0.01
				}
			}
            );
        
        minuteStickTimeline.addLabel("clapTime",game.rhythm[clapIndex]);
        minuteStickTimeline.to(game.clock.minuteStick,{
            xTo: game.clock.origin.x + game.clock.minuteStick.length*Math.cos(game.clock.minuteStick.angle),
            yTo: game.clock.origin.y + game.clock.minuteStick.length*Math.sin(game.clock.minuteStick.angle)}, 
            "clapTime");


        var hourStickTimeline = 
			gsap.timeline(
			{
				defaults: {
					duration:0.01
				}
			}
            );

        hourStickTimeline.addLabel("clapTime",game.rhythm[clapIndex]);
        hourStickTimeline.to(game.clock.hourStick,{
            xTo: game.clock.origin.x + game.clock.hourStick.length*Math.cos(game.clock.hourStick.angle),
            yTo: game.clock.origin.y + game.clock.hourStick.length*Math.sin(game.clock.hourStick.angle)}, 
            "clapTime");
        
        game.update();
        
	}
    
}

function animate(){
    // The method returns what frame you are currently on.
    frameId = requestAnimationFrame(animate);
    context.fillStyle = 'hsl(250, 30%, 30% )';
    context.fillRect(0,0,canvas.width,canvas.height);

    game.drawGame();

    // End Game
    if(!game.player.isAlive)
        cancelAnimationFrame(frameId);
                
            
}

addEventListener('keydown',(event)=>{
    console.log(event.key);
    switch(event.key){
        case '1' :
            player.addAnswer(1);
            break;
        case '2' :
            player.addAnswer(2);
            break;
        case '3' :
            player.addAnswer(3);
            break;
        case '4' :
            player.addAnswer(4);
            break;
        case '5' :
            player.addAnswer(5);
            break;
        case '6' :
            player.addAnswer(6);
            break;
        case '7' :
            player.addAnswer(7);
            break;
        case '8' :
            player.addAnswer(8);
    }
    
});