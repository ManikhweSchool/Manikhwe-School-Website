package com.manikhweschool.games;

public class Player {
    
    private short playerNumber;
    private boolean isAlive;
    private boolean hasResponded;
    private byte playerAnswer;
    
    public Player(short playerNumber){
    
        if(playerNumber>0)
            this.playerNumber = playerNumber;
        else
            this.playerNumber = 0;
        
        hasResponded = false;
        isAlive = true;
        playerAnswer = 0;
    }
    
    public byte getPlayerAnswer(){
    
        return playerAnswer;
    }
    
    public void setPlayerAnswer(byte playerAnswer){
    
        this.playerAnswer = playerAnswer;
    }
    
    public boolean getHasResponded(){
    
        return hasResponded;
    }
    
    public void setHasResponded(boolean hasResponded){
    
        this.hasResponded = hasResponded;
    }
    
    public short getPlayerNumber(){
    
        return playerNumber;
    }
    
    public void setIsAlive(boolean isAlive){
    
        this.isAlive = isAlive;
    }
    
    public boolean getIsAlive(){
    
        return isAlive;
    }
    
}

