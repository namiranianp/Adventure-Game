package Model;

<<<<<<< HEAD

public class Creature {


    int hp = 3, atk = 1;
    String name;
    boolean canDrop, canTalk, respawnable;

    //Add different movement types
    public Creature(){
        name = "generic npc name";
        canDrop = false;
        canTalk = false;
        respawnable = false;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int num){
        hp = num;
    }
    public void takeDmg(int num){
        if(num >= hp){
            hp = 0;
        }
    }
    public int getAtk(){
        return atk;
    }
    public void setAtk(int num){
        atk = num;
    }
    public String getName(){
        return name;
    }
    public void setName(String txt){
        name = txt;
    }
//NPC
/*
//talkable enemys maybe?
public boolean talkable(){
  if(this npc is not a monster){
    return true;
  }
  return false;
}
*/
=======
public class Creature {
	String name;

	public Creature(String imageName) {
		name = imageName;
	}
	
	public String getName(){
		return name;
	}
>>>>>>> f7acd6a9aa42a97d6924e5b3752fa5f0e289d5ec
}
