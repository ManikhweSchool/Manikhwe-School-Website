package com.manikhweschool.games;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.manikhweschool.music.model.Rhythm;


public class GameServer implements Serializable{
   
    private static final long serialVersionUID = -5706264683748025903L;

	private boolean canStartHandlingPlayers;
	private boolean doesRhythmFit;
	
    
    private ArrayList<String> patterns;
    private byte correctDirectionIndex;
    private Set<InetAddress> playersIPAddresses;
    
    private Rhythm rhythm;
    private short numberOfPlayers;
    private String gameUniqueId;
    
    private long startTime; // Relative Starting Time
    
    public GameServer() {
    	
    	doesRhythmFit = false;
    	canStartHandlingPlayers = false;
    	
        numberOfPlayers = 2;
        generatePatterns();
        correctDirectionIndex = 0;
        playersIPAddresses = new LinkedHashSet<>();
        rhythm = new Rhythm();
        
    }
    
    public GameServer(short numberOfPlayers){
    
    	doesRhythmFit = false;
        canStartHandlingPlayers = false;
        
        this.numberOfPlayers = numberOfPlayers;
        generatePatterns();
        correctDirectionIndex = 0;
        playersIPAddresses = new LinkedHashSet<>();
        // Works well on the local machine.
        //recruitPlayers();
        rhythm = new Rhythm();
       
    }
	
	public void addRhythmTime() {
		long time = System.currentTimeMillis()-startTime;
		rhythm.addTime(time);
		System.out.println(time);
	}
    
    public void clearRhythm() {
    	
    	rhythm.clearTimes();
    	startTime = System.currentTimeMillis();
    }
    
    public void addTime() {
    	
    	System.out.println(System.currentTimeMillis()-startTime);
    }
    
    @Override
    public String toString() {
    	
    	String representation = "Can Handle Player : " + ((canStartHandlingPlayers)?"Yes\n":"No\n");
    	representation += "Does Rhythm Fit? : " + ((doesRhythmFit)?"Yes\n":"No\n");
    	representation += "Patterns : ";
    	for(String pattern : patterns)
    		representation += pattern + " ";
    	representation += "\nPattern Index : " + correctDirectionIndex + " : ";
    	representation += "\nNumber Of Players : " + numberOfPlayers;
    	representation += "\nGame Id : " + gameUniqueId + "\n";
    	representation += rhythm.toString();
    	
    	return representation;
    	
    }

	public boolean isDoesRhythmFit() {
		return doesRhythmFit;
	}

	public void setDoesRhythmFit(boolean doesRhythmFit) {
		this.doesRhythmFit = doesRhythmFit;
	}

	public boolean isCanStartHandlingPlayers() {
		return canStartHandlingPlayers;
	}

	public void setCanStartHandlingPlayers(boolean canStartHandlingPlayers) {
		this.canStartHandlingPlayers = canStartHandlingPlayers;
	}

	public byte getCorrectDirectionIndex() {
		return correctDirectionIndex;
	}

	public void setCorrectDirectionIndex(byte correctDirectionIndex) {
		this.correctDirectionIndex = correctDirectionIndex;
	}

	public short getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(short numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public String getGameUniqueId() {
		return gameUniqueId;
	}

	public void setGameUniqueId(String gameUniqueId) {
		this.gameUniqueId = gameUniqueId;
	}

	public Rhythm getRhythm() {
		return rhythm;
	}

    public void setRhythm(Rhythm rhythm) {
		this.rhythm = rhythm;
	}




	public void recruitPlayers(){
    
       try{
            // Create a server socket.
            ServerSocket serverSocket = new ServerSocket(8098);
            
            // Player identifier
            short playerNumber = 1;
            
            while(playerNumber <= numberOfPlayers){
            
                // Listen for new connection.
                Socket socket = serverSocket.accept();
                
                // Find the client's hostname and IP address.
                InetAddress inetAddress = socket.getInetAddress();
                
                playersIPAddresses.add(inetAddress);
                
                HandlePlayer handlePlayer = new HandlePlayer(socket, playerNumber);
                
                // Start a new thread
                new Thread(handlePlayer).start();
                System.out.println("Player " + playerNumber + " is connected.");
                playerNumber++;
            }
            
            canStartHandlingPlayers= true;
            serverSocket.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    

    class HandlePlayer implements Runnable{

        // Client socket
        private Socket socket;
        private Player player;
        
        public HandlePlayer(Socket socket, short playerNumber){
        
            this.socket = socket;
            player = new Player(playerNumber);
        }
        
        @Override
        public void run() {
            
            try{
            
                DataInputStream inputFromPlayer = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToPlayer = new DataOutputStream(socket.getOutputStream());
                
                // Continuously serve the player
                while(player.getIsAlive() && canStartHandlingPlayers){
                
                    // Recieve player's direction answer.
                    byte playerAnswer = inputFromPlayer.readByte();
                    player.setPlayerAnswer(playerAnswer);
                    System.out.println("data recieved by a server.");
                    
                    if(player.getHasResponded() && Byte.parseByte(
                    patterns.get(correctDirectionIndex))==player.getPlayerAnswer()){
                        outputToPlayer.writeUTF("correct");
                        System.out.println("data sent by a server.");
                    }
                    else{
                    
                        player.setIsAlive(false);
                        outputToPlayer.writeUTF("game-over");
                        System.out.println("data sent by a server.");
                    }
                }
                
            }catch(IOException ex){
            
                ex.printStackTrace();
            }
        }
    
        
    }
    
    private void generatePatterns(){
    
        patterns = new ArrayList<>();
        
        patterns.add("1");
        patterns.add("2");
        patterns.add("3");
        patterns.add("4");
        
        Collections.shuffle(patterns);
        
    }
    
}


