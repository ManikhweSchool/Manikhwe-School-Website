package com.manikhweschool.music.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.manikhweschool.model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "RHYTHM")
@Component
public class Rhythm implements Serializable,Cloneable{

	private static final long serialVersionUID = -755311351165608588L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Rhythm_Id", nullable = false)
	private long rhythmId;
	
	@ElementCollection
	private Collection<Long> times;
	
	@ElementCollection
    private Collection<Boolean> canAct;
    
    @Column(name = "Next_Time_Index", nullable = false)
	private int nextTimeIndex;
    
   
    @ManyToMany(mappedBy = "rhythms")
    private Set<Track> tracks;
    
    @ManyToOne(
        targetEntity = Student.class,
        cascade = CascadeType.ALL
    )
    private Student student;
	
	public Rhythm() {
		times = new ArrayList<>();
		canAct = new ArrayList<>();
        nextTimeIndex  = -1;
            
	}
        
    public Rhythm(RhythmType rhythmType) {
    	times = new ArrayList<>();
    	canAct = new ArrayList<>();
        nextTimeIndex  = -1;
        createRhythm(rhythmType);
	}
	
	public Rhythm(ArrayList<Long> times) {
            this.times = times;
            canAct = new ArrayList<>();
            nextTimeIndex  = -1;
	}
	
	public int getNextTimeIndex() {
		return nextTimeIndex;
	}

	public void setNextTimeIndex(int nextTimeIndex) {
		this.nextTimeIndex = nextTimeIndex;
	}

	public void setTimes(ArrayList<Long> times) {
		this.times = times;
	}

	public void setCanAct(ArrayList<Boolean> canAct) {
		this.canAct = canAct;
	}

		private void createRhythm(RhythmType rhythmType){
            
            switch(rhythmType){
                case Rhythm_One : createRhythmOne(); break;
                case Rhythm_Two : createRhythmTwo(); break;
                default : createRhythmThree();
                
            }
        }
        
        public void repeatPattern(long initialTime, long timeBetweenPatterns,long maxPeriod){
        
        	ArrayList<Long> originalTimes = new ArrayList<>();
        	ArrayList<Boolean> originalIsQuestionable = new ArrayList<>();
        	
        	for(int i =0; i< times.size() && i < canAct.size();i++) {
        		originalTimes.add(((ArrayList<Long>)times).get(i));
        		originalIsQuestionable.add(((ArrayList<Boolean>)canAct).get(i));
        	}
            
            if(originalTimes.isEmpty())
                System.out.println("Error : Tap at least twice.");
            
            long constantTime = initialTime-originalTimes.get(0);
            long currentTime = maxPeriod;
            int iterationIndex = 1;
            
            do{  
                for(int i = 0; i < originalTimes.size();i++){
                   currentTime = constantTime*iterationIndex+originalTimes.get(i);
                   if(currentTime<=maxPeriod)
                       addTime(currentTime, originalIsQuestionable.get(i));
                   else
                       break;
                }
                iterationIndex++;
            }while(currentTime<=maxPeriod);
            
        }
        
    public boolean getCanAct(int index){
        
       return ((ArrayList<Boolean>)canAct).get(index);
    }
	
	public void addTime(long time, boolean canAct) {
		times.add(time);
                this.canAct.add(canAct);
	}
        
    public void setCanAct(boolean canAct, int index){
        ((ArrayList<Boolean>)this.canAct).set(index, canAct);
    }
	
	public void clearTimes() {
		times.clear();
		canAct.clear();
	}
        
        public List<Long> getTimes(){
            
            return Collections.unmodifiableList(((ArrayList<Long>)times));
            
        }
        
        public List<Boolean> getCanAct(){
            
            return Collections.unmodifiableList((((ArrayList<Boolean>)canAct)));
            
        }
        
        public long getCurrentTime(){ return ((ArrayList<Long>)times).get(nextTimeIndex);}
        
        public long getNextTime() {
		
            return (long)((ArrayList<Long>)times).get(((++nextTimeIndex)%times.size()));                                                                                                                                                                                                                                                                                                                                                                                                            
	}
        
        public void createRhythmOne(){
        
            if(!times.isEmpty())
                times.clear();
            
            long sum = 0;
            
            for(int index = 1; index <= 3000;index++){
                sum += 1000;
                times.add(sum);
            }
        }
        
        public void createRhythmTwo(){
        
            if(!times.isEmpty())
                times.clear();
            
            long sum = 0;
            
            for(int index = 1; index <= 3000;index++){
                sum += (index%2!=0)?1000:500;
                times.add(sum);
            }
        }
        
        public void createRhythmThree(){
        
            if(!times.isEmpty())
                times.clear();

            long sum = 0;

            for(int index = 1; index <= 3000;index++){

                if(index%3==1) sum += 3000;
                else if(index%3==2) sum += 2000;
                else sum += 100;

                times.add(sum);
            }
        }
        
    @Override
    public Object clone() throws 
    CloneNotSupportedException { 
    	return super.clone();
    }

	public long getRhythmId() {
		return rhythmId;
	}

	public void setRhythmId(long rhythmId) {
		this.rhythmId = rhythmId;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setTimes(Collection<Long> times) {
		this.times = times;
	}

	public void setCanAct(Collection<Boolean> canAct) {
		this.canAct = canAct;
	}
    
    
}

